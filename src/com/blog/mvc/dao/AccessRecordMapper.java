package com.blog.mvc.dao;

import com.blog.mvc.entity.AccessRecord;
import com.blog.mvc.entity.AccessRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccessRecordMapper extends BaseMapper<AccessRecord> {
	
    List<AccessRecord> selectByExampleWithBLOBs(AccessRecordExample example);

    List<AccessRecord> selectByExample(AccessRecordExample example);

    long countByExample(AccessRecordExample example);

    int deleteByExample(AccessRecordExample example);

    int updateByExampleSelective(@Param("record") AccessRecord record, @Param("example") AccessRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") AccessRecord record, @Param("example") AccessRecordExample example);

    int updateByExample(@Param("record") AccessRecord record, @Param("example") AccessRecordExample example);
   
}