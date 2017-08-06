package com.blog.mvc.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.blog.mvc.entity.Category;
import com.blog.mvc.entity.CategoryExample;

public interface CategoryMapper extends BaseMapper<Category> {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    List<Category> selectByExample(CategoryExample example);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

}