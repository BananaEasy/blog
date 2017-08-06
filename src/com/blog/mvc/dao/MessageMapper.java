package com.blog.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.mvc.entity.Message;
import com.blog.mvc.entity.MessageExample;

public interface MessageMapper extends  BaseMapper<Message>{
    long countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    List<Message> selectByExampleWithBLOBs(MessageExample example);

    List<Message> selectByExample(MessageExample example);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExampleWithBLOBs(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

}