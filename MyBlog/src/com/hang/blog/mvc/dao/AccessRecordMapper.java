package com.hang.blog.mvc.dao;

import com.hang.blog.mvc.entity.AccessRecord;
import com.hang.blog.mvc.entity.AccessRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccessRecordMapper {
    long countByExample(AccessRecordExample example);

    int deleteByExample(AccessRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(AccessRecord record);

    int insertSelective(AccessRecord record);

    List<AccessRecord> selectByExampleWithBLOBs(AccessRecordExample example);

    List<AccessRecord> selectByExample(AccessRecordExample example);

    AccessRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AccessRecord record, @Param("example") AccessRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") AccessRecord record, @Param("example") AccessRecordExample example);

    int updateByExample(@Param("record") AccessRecord record, @Param("example") AccessRecordExample example);

    int updateByPrimaryKeySelective(AccessRecord record);

    int updateByPrimaryKeyWithBLOBs(AccessRecord record);

    int updateByPrimaryKey(AccessRecord record);
}