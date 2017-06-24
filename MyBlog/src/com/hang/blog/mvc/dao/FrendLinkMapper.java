package com.hang.blog.mvc.dao;

import com.hang.blog.mvc.entity.FrendLink;
import com.hang.blog.mvc.entity.FrendLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FrendLinkMapper {
    long countByExample(FrendLinkExample example);

    int deleteByExample(FrendLinkExample example);

    int deleteByPrimaryKey(String id);

    int insert(FrendLink record);

    int insertSelective(FrendLink record);

    List<FrendLink> selectByExampleWithBLOBs(FrendLinkExample example);

    List<FrendLink> selectByExample(FrendLinkExample example);

    FrendLink selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FrendLink record, @Param("example") FrendLinkExample example);

    int updateByExampleWithBLOBs(@Param("record") FrendLink record, @Param("example") FrendLinkExample example);

    int updateByExample(@Param("record") FrendLink record, @Param("example") FrendLinkExample example);

    int updateByPrimaryKeySelective(FrendLink record);

    int updateByPrimaryKeyWithBLOBs(FrendLink record);

    int updateByPrimaryKey(FrendLink record);
}