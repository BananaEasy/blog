package com.blog.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.mvc.entity.Comment;
import com.blog.mvc.entity.CommentExample;

public interface CommentMapper extends BaseMapper<Comment>{
    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    List<Comment> selectByExampleWithBLOBs(CommentExample example);

    List<Comment> selectByExample(CommentExample example);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExampleWithBLOBs(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

}