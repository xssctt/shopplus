package com.example.service;

import com.example.common.ListDto;
import com.example.dto.RoleDto;
import com.example.dto.UserDto;
import com.example.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
public interface IRoleService extends IService<Role> {

    ListDto<RoleDto> selectAllByNameAndUseridAndApec(Integer limit,Integer page,String name,String spec,Integer userid);

    Set<String> selectAllById(Integer roleid);

    Boolean updateRoleTask(Integer roleid, List<String> taskCodeList);

    Boolean updateUserRole(Integer userid, List<Integer> RoleList);
}
