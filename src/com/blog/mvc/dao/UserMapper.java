package com.blog.mvc.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.blog.mvc.entity.User;
import com.blog.mvc.entity.UserExample;

public interface UserMapper extends  BaseMapper<User>{
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

}