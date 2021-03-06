package xyz.lihang.blog.mapper.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.lihang.blog.mapper.entity.FrendLink;
import xyz.lihang.blog.mapper.example.FrendLinkExample;

public interface FrendLinkMapper extends BaseMapper<FrendLink>{
    long countByExample(FrendLinkExample example);

    int deleteByExample(FrendLinkExample example);

    List<FrendLink> selectByExampleWithBLOBs(FrendLinkExample example);

    List<FrendLink> selectByExample(FrendLinkExample example);

    int updateByExampleSelective(@Param("record") FrendLink record, @Param("example") FrendLinkExample example);

    int updateByExampleWithBLOBs(@Param("record") FrendLink record, @Param("example") FrendLinkExample example);

    int updateByExample(@Param("record") FrendLink record, @Param("example") FrendLinkExample example);

}