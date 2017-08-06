package com.blog.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.mvc.entity.FrendLink;
import com.blog.mvc.entity.FrendLinkExample;

public interface FrendLinkMapper extends BaseMapper<FrendLink>{
    long countByExample(FrendLinkExample example);

    int deleteByExample(FrendLinkExample example);

    List<FrendLink> selectByExampleWithBLOBs(FrendLinkExample example);

    List<FrendLink> selectByExample(FrendLinkExample example);

    int updateByExampleSelective(@Param("record") FrendLink record, @Param("example") FrendLinkExample example);

    int updateByExampleWithBLOBs(@Param("record") FrendLink record, @Param("example") FrendLinkExample example);

    int updateByExample(@Param("record") FrendLink record, @Param("example") FrendLinkExample example);

}