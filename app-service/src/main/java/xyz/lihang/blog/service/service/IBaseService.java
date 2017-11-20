package xyz.lihang.blog.service.service;

import java.util.List;

public interface IBaseService<T> {
	
	int deleteByPrimaryKey(Integer id);
	
	T selectByPrimaryKey(Integer id);
	
	T selectByPrimaryKey(String id);

    int deleteByPrimaryKey(String id);

    int insert(T t);

    int insertSelective(T t);
    
    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKeyWithBLOBs(T t);

    int updateByPrimaryKey(T t);

    List<T> selectAll();

    long countAll();
    
}
