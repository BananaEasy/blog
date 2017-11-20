package xyz.lihang.blog.mapper.dao;

import xyz.lihang.blog.mapper.entity.AccessRecord;
import xyz.lihang.blog.mapper.example.AccessRecordExample;
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