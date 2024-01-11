package com.example.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.User;
import org.springframework.stereotype.Repository;

//import java.util.List;
//import java.util.Optional;
//import com.example.entity.Count;
//import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserMapper extends BaseMapper<User> {


}
//@Repository
//public interface UserMapper extends JpaRepository<Count,Integer> {
//
//    List<Count> findByUsernameLike(String username);
//
//    Optional<Count> findByUsername(String username);
//}
