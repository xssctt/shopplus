package com.example.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//import java.util.List;
//import java.util.Optional;
//import com.example.entity.Count;
//import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserMapper extends BaseMapper<User> {
    @Delete("delete from roleuser where userid=#{userid} and roleid=#{roleid} ")
    Integer deleteUserRoleById(@Param("userid") Integer userid, @Param("roleid") Integer roleid);


    @Select("select roleid from roleuser where userid=#{userid}")
    List<Integer> selectAllById(@Param("userid")  Integer userid);

}
//@Repository
//public interface UserMapper extends JpaRepository<Count,Integer> {
//
//    List<Count> findByUsernameLike(String username);
//
//    Optional<Count> findByUsername(String username);
//}
