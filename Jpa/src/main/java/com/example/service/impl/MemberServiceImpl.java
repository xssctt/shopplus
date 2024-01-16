package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.common.ListDto;
import com.example.dto.TokenDto;
import com.example.dto.UserDto;
import com.example.entity.*;
import com.example.execption.CustomException;
import com.example.mapper.MemberMapper;
import com.example.mapper.RoleMapper;
import com.example.mapper.TenantMapper;
import com.example.mapper.UserMapper;
import com.example.service.IMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.until.JwtUtil;
import com.example.until.StringPwd;
import com.example.until.SystemUtil;
import com.example.until.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
@Service
@Slf4j
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

    @Resource
    MemberMapper memberMapper;
    @Resource
    TenantMapper tenantMapper;
    @Resource
    RoleMapper roleMapper;
    @Resource
    UserMapper userMapper;


    @Override
    public TokenDto createtokenCreate(String username, String password) {
        //登录
        //查询用户 密码
        LambdaQueryWrapper<Member> memberLambdaQueryWrapper=new LambdaQueryWrapper<>();
        memberLambdaQueryWrapper
                .eq(Member::getName,username);
        log.info("member 获取");
        log.info("memberMapper.selectOne(memberLambdaQueryWrapper);");
         Member member=memberMapper.selectOne(memberLambdaQueryWrapper);
         if(member != null){
             //true
             log.info("密码验证");
             String pwdsalt=member.getPasswordSalt();
             String pwdhash= StringPwd.hashPassword(password,pwdsalt);
             //密码 hash salt
             if(pwdhash.equals(member.getPasswordHash())){
                 Integer userid=memberMapper.selectOne(new LambdaQueryWrapper<Member>().eq(Member::getName,username)).getId();
                 //获取token
                 String token= JwtUtil.createJwt(Member.builder().id(userid).name(username).build());
                 //String token="";
                 log.info("用户登录");
                 return TokenDto.builder()
                         .token(token)
                         .tenantId(tenantMapper.selectOne(new LambdaQueryWrapper<Tenant>().eq(Tenant::getName,username)).getId())
                         .userId(userid)
                         .build();
             }else {
                 throw new CustomException("密码错误");
             }

         }else {
             //false
             throw new CustomException("用户不存在");
         }

    }

    @Override
    public TokenDto save(String username, String password) {
        //创建用户

        //查询用户 密码
        LambdaQueryWrapper<Member> memberLambdaQueryWrapper=new LambdaQueryWrapper<>();
        memberLambdaQueryWrapper
                .eq(Member::getName,username);
        Member member=memberMapper.selectOne(memberLambdaQueryWrapper);

        if(member == null){

            String passwordSalt=StringPwd.generateSalt();
            String passwordHash=StringPwd.hashPassword(password,passwordSalt);

            int insert = memberMapper.insert(Member.builder().name(username).status(1).passwordHash(passwordHash).passwordSalt(passwordSalt).build());

            if(insert > 0){
                //tenantId   创建租户  创建 user role  token
                Integer memberid=memberMapper.selectOne(new LambdaQueryWrapper<Member>().eq(Member::getName,username)).getId();

                userMapper.insert(User.builder().id(memberid)
                        .name(username).status(1).avatar("").createdAt(TimeUtil.NowTimeToString()).email("").mobile("")
                        .build());
                //Integer userid=userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getName,username)).getId();

               // roleMapper.insert(Role.builder().name(username).status(1).sort(1).spec("").build());


                tenantMapper.insert(Tenant.builder()
                        .address("").picture("")
                        .createdAt(TimeUtil.NowTimeToString()).updatedAt(TimeUtil.NowTimeToString())
                        .name(username).status(1).telephone("").userId(memberid)
                        .build());
                //String token=SystemUtil.genToken(username);

//                 LambdaQueryWrapper<User> userLambdaQueryWrapper=new LambdaQueryWrapper<>();
//                 userLambdaQueryWrapper.eq(User::getName,username);
//                 userMapper.selectOne(userLambdaQueryWrapper);
                log.info("用户注册");
                return TokenDto.builder()
                        .token("")
                        .tenantId(tenantMapper.selectOne(new LambdaQueryWrapper<Tenant>().eq(Tenant::getName,username)).getId())
                        .userId(memberid)
                        .build();
            }{
                throw new CustomException("用户创建失败");
            }


        }else {
            //false
            log.info("用户存在");
            throw new CustomException("用户存在");
        }
    }

    @Override
    public Boolean updateStatusBoolean(Integer userid, Integer status) {
        if(memberMapper.updateStatusBoolean(userid, status) > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public ListDto<UserDto> selectAllByIdAndNameAndStatus(Integer id, String name, Integer status, Integer limit, Integer page) {

        //limit  每页多少数据
        // offset  跳过多少数据
        // totalCount
        //totalPages  多少页
        //page

//        if(status == 0){
//            status = null;
//        }

        Integer aoffset;
        aoffset = (page - 1) * limit;



        Integer totalCount=memberMapper.selectAllByIdAndNameAndStatus(id,name,status);

        Integer totalPages = totalCount;
        if (totalCount % limit != 0){
          totalPages= totalPages/limit;
          totalPages +=1;
        }

        Pagination pagination=Pagination.builder().total(totalPages).page(page).limit(limit).build();
        List<Member> members = memberMapper.selectAllByIdAndNameAndStatuspage(id, name, status, limit, aoffset);

        List<UserDto> userDtoList=new ArrayList<>();

        for (Member m:members){
            userDtoList.add(UserDto.builder()
                    .id(m.getId()).status(m.getStatus())
                    .name(m.getName())
                    .avatar(m.getAvatar())
                    .createdAt(m.getCreateAt())
                    .email("")
                    .mobile(m.getMobile()).build());
        }


        //new ListDto<UserDto>(userDtoList,pagination);

        return new ListDto<UserDto>(userDtoList,pagination);
    }


}
