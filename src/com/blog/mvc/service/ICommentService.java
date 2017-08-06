package com.blog.mvc.service;

import com.blog.mvc.entity.Comment;
import com.blog.mvc.entity.User;
import com.blog.mvc.utils.RenderJson;

public interface ICommentService extends IBaseService<Comment> {

	/**
	 * 评论
	 * @param comment
	 * @param user
	 */
	RenderJson comment(Comment comment, User user);
	
	//主评论
	
	
	
	
}
