package com.example.mapper;


import com.example.entity.Count;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserMapper extends JpaRepository<Count,Integer> {

    List<Count> findByUsernameLike(String username);

    Optional<Count> findByUsername(String username);
}
