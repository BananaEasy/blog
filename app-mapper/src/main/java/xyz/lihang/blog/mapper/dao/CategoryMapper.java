package xyz.lihang.blog.mapper.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.lihang.blog.mapper.entity.Category;
import xyz.lihang.blog.mapper.example.CategoryExample;

public interface CategoryMapper extends BaseMapper<Category> {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    List<Category> selectByExample(CategoryExample example);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

}