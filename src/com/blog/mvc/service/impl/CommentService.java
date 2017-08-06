package com.blog.mvc.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.blog.mvc.dao.BaseMapper;
import com.blog.mvc.dao.CommentMapper;
import com.blog.mvc.dao.UserMapper;
import com.blog.mvc.entity.Comment;
import com.blog.mvc.entity.User;
import com.blog.mvc.exception.MyException;
import com.blog.mvc.service.ICommentService;
import com.blog.mvc.service.IUserService;
import com.blog.mvc.utils.RenderJson;

@Service
public class CommentService extends BaseService<Comment> implements ICommentService {
	
		@Resource
		private IUserService userService;
	
		
		private CommentMapper commentMapper;
		
		@Resource
		public void setCommentMapper(CommentMapper commentMapper) {
			this.commentMapper = commentMapper;
			super.setBaseMapper(commentMapper);
		}




		@Override
		public RenderJson comment(Comment comment, User user) {
			RenderJson rj = RenderJson.Instance();
			//用户校验
			if(user == null){
				throw new MyException("请输入邮箱和用户名,方可评论");
			}else{
				if(StringUtils.isNotBlank(user.getId())){
					user = userService.selectByPrimaryKey(user.getId());
					if(user == null){
						throw new MyException("用户不存在");
					}
				}else{
					//注册
					user = userService.register(user);
				}
			}
			//评论
			
			
			
			
			
			return rj;
		}
}
