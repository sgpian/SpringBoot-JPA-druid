package com.example.dao;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/1/17.
 */
public interface UserRepository extends JpaRepository<User,Integer>{

}
