package com.blog.mvc.service.impl;

import java.util.List;

import com.blog.mvc.dao.BaseMapper;
import com.blog.mvc.entity.AccessRecord;
import com.blog.mvc.service.IBaseService;


/**
 * service抽取方法
 * @author LiHang
 *
 * @param <T>
 */
public abstract class BaseService<T> implements IBaseService<T> {
	
	private BaseMapper<T> baseMapper;

	public void setBaseMapper(BaseMapper<T> baseMapper) {
		this.baseMapper = baseMapper;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return baseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public T selectByPrimaryKey(Integer id) {
		return baseMapper.selectByPrimaryKey(id);
	}

	@Override
	public T selectByPrimaryKey(String id) {
		return baseMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return baseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(T t) {
		return baseMapper.insert(t);
	}

	@Override
	public int insertSelective(T t) {
		return baseMapper.insertSelective(t);
	}

	@Override
	public int updateByPrimaryKeySelective(T t) {
		return baseMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(T t) {
		return baseMapper.updateByPrimaryKeyWithBLOBs(t);
	}

	@Override
	public int updateByPrimaryKey(T t) {
		return baseMapper.updateByPrimaryKey(t);
	}


	@Override
	public List<T> selectAll() {
		// TODO Auto-generated method stub
		return baseMapper.selectByExample();
	}

	@Override
	public long countAll() {
		// TODO Auto-generated method stub
		return baseMapper.countByExample();
	}
	
}
