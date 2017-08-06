package com.blog.mvc.service;

import com.blog.mvc.entity.User;

public interface IUserService extends IBaseService<User> {

	User register(User user);

	
}
