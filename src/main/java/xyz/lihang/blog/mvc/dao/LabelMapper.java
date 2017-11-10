package xyz.lihang.blog.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import xyz.lihang.blog.mvc.entity.Label;
import xyz.lihang.blog.mvc.entityexample.LabelExample;

public interface LabelMapper extends  BaseMapper<Label>{
    long countByExample(LabelExample example);

    int deleteByExample(LabelExample example);

    List<Label> selectByExample(LabelExample example);

    int updateByExample(@Param("record") Label record, @Param("example") LabelExample example);
}