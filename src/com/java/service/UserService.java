package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.bean.User;
import com.java.dao.UserMapper;


/**
 * 用户Service 
 * @author iprcc
 *
 */
@Service
public class UserService {
	
	@Autowired         // 使用 spring 注解自动生成一个 UserMapper 对象。
	private UserMapper userMapper;
	
	// 预留注册信息
	public int insertUser(User user) {
		return userMapper.insertSelective(user);
	}
	
	// 通过用户名去查询 User ,并返回用户对象
	public User selectUser(String username) {
		return userMapper.selectByPrimaryKey(username);
	}
	
}
