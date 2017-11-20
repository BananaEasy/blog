package xyz.lihang.blog.service.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.lihang.blog.common.tool.utils.BeanUpdateUtils;
import xyz.lihang.blog.mapper.dao.LabelMapper;
import xyz.lihang.blog.mapper.entity.Label;
import xyz.lihang.blog.service.service.ILabelService;

import javax.annotation.Resource;
import java.util.Date;


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
