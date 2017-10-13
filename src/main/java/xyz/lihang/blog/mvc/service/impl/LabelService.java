package xyz.lihang.blog.mvc.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import xyz.lihang.blog.mvc.dao.LabelMapper;
import xyz.lihang.blog.mvc.entity.Label;
import xyz.lihang.blog.mvc.service.ILabelService;
import xyz.lihang.blog.tool.utils.BeanUpdateUtils;

@Service
public class LabelService extends BaseService<Label> implements ILabelService {
	
	private LabelMapper labelMapper;
	
	@Resource
	public void setLabelMapper(LabelMapper labelMapper) {
		this.labelMapper = labelMapper;
		super.setBaseMapper(labelMapper);
	}
	
	@Override
	@Transactional
	public int insert(Label t) {
		if(t == null)
			t = new Label();
		t.setCreatetime(new Date());
		t.setVersion(0);
		return super.insert(t);
	}
	
	@Override
	@Transactional
	public int updateByPrimaryKey(Label t) {
		Label temp = selectByPrimaryKey(t.getId());
		temp = (Label) BeanUpdateUtils.objClone(temp, t);
		temp.setVersion(temp.getVersion() + 1);
		return super.updateByPrimaryKey(temp);
	}
	
	
}
