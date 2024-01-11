package com.example.service;

import com.example.common.ListDto;
import com.example.dto.TokenDto;
import com.example.dto.UserDto;
import com.example.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mapper.MemberMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
public interface IMemberService extends IService<Member> {

    TokenDto createtokenCreate(String username, String password);

    TokenDto save(String username, String password);

    Boolean updateStatusBoolean(Integer userid,Integer status);

    ListDto<UserDto> selectAllByIdAndNameAndStatus(Integer id, String name, Integer status, Integer limit, Integer page);

}
