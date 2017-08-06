package com.blog.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.mvc.entity.Label;
import com.blog.mvc.entity.LabelExample;

public interface LabelMapper extends  BaseMapper<Label>{
    long countByExample(LabelExample example);

    int deleteByExample(LabelExample example);

    List<Label> selectByExample(LabelExample example);

    int updateByExampleSelective(@Param("record") Label record, @Param("example") LabelExample example);

    int updateByExample(@Param("record") Label record, @Param("example") LabelExample example);

}