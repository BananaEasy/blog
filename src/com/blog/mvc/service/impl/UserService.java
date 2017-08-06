package com.blog.mvc.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.blog.mvc.dao.UserMapper;
import com.blog.mvc.entity.User;
import com.blog.mvc.exception.MyException;
import com.blog.mvc.service.IUserService;
import com.blog.mvc.utils.UUIDUtils;
import com.blog.mvc.utils.Validator;
@Service
public class UserService extends BaseService<User> implements IUserService{
	private UserMapper userMapper;

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
		super.setBaseMapper(userMapper);
	}

	@Override
	public User register(User user) {
		if(user == null){
			throw new MyException("请输入数据");
		}
		//校验
		if(!Validator.isEmail(user.getEmail())){
			throw new MyException("邮箱格式不正确");
		}

		if(!Validator.isUsername(user.getUsername())){
			throw new MyException("呢称格式不正确");
		}
		
		user.setId(UUIDUtils.getUUID());
		
		user.setUserheadimage("");
		
		user.setCreatetime(new Date());
		
		int success = userMapper.insert(user);
		
		return user;
	}
	
	
}
