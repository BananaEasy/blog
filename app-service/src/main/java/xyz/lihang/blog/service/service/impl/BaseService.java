package xyz.lihang.blog.service.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import xyz.lihang.blog.mapper.dao.BaseMapper;
import xyz.lihang.blog.service.service.IBaseService;


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
	@Transactional
	public int deleteByPrimaryKey(Integer id) {
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
	@Transactional
	public int deleteByPrimaryKey(String id) {
		return baseMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int insert(T t) {
		return baseMapper.insert(t);
	}

	@Override
	@Transactional
	public int insertSelective(T t) {
		return baseMapper.insertSelective(t);
	}

	@Override
	@Transactional
	public int updateByPrimaryKeySelective(T t) {
		return baseMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	@Transactional
	public int updateByPrimaryKeyWithBLOBs(T t) {
		return baseMapper.updateByPrimaryKeyWithBLOBs(t);
	}

	@Override
	@Transactional
	public int updateByPrimaryKey(T t) {
		return baseMapper.updateByPrimaryKey(t);
	}


	@Override
	public List<T> selectAll() {
		return baseMapper.selectByExample();
	}

	@Override
	public long countAll() {
		return baseMapper.countByExample();
	}
	
}
