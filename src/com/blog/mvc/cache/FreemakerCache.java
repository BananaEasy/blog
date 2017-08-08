package com.blog.mvc.cache;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.blog.model.Situation;
import com.blog.mvc.dao.AccessRecordMapper;
import com.blog.mvc.dao.CommentMapper;
import com.blog.mvc.dao.MessageMapper;
import com.blog.mvc.service.IFrendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.blog.mvc.service.IArticleService;
import com.blog.mvc.service.ILabelService;
import com.blog.mvc.service.ISystemManagerService;
import com.blog.mvc.service.impl.LabelService;

import freemarker.template.TemplateModelException;


@Component
public class FreemakerCache{


	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	private Map <String,Object> cache =new HashMap<>();
	
	@Resource
	private ISystemManagerService systemManagerService;
	
	@Resource
	private IArticleService articleService;

	@Resource
	private AccessRecordMapper accessRecordMapper;

	@Resource
	private MessageMapper messageMapper;

	@Resource
	private CommentMapper commentMapper;

	
	@Resource
	private ILabelService labelService;

	@Resource
	private IFrendLinkService frendLinkService;

	
	@Resource
	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		this.freeMarkerConfigurer = freeMarkerConfigurer;
		this.refresh();
	}

	/**
	 * 刷新缓存
	 */
	public void refresh(){
		try {
			this.menu().rightItems();
			freeMarkerConfigurer.getConfiguration().setSharedVaribles(cache);
		} catch (TemplateModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 页面右边的条目
	 * @return
	 */
	private FreemakerCache rightItems (){
		//获取热门文章
		cache.put("hotArticleList", articleService.getByHot());
		
		//近期文章
		cache.put("latelyArticleList", articleService.getByLately());
		
		//标签条目
		cache.put("labelList",labelService.selectAll());
		
		//月份分组
		cache.put("groupByMonthList",articleService.groupByMonth());

		//友情链接
		cache.put("frendLinkList",frendLinkService.selectAll());

		Long articleCount = articleService.countAll();
		Long messageCount = messageMapper.countByExample();
		Long accessCount = accessRecordMapper.countByExample();
		Long commentCount = commentMapper.countByExample();

		//访问记录
		Situation situation = new Situation(articleCount,messageCount,accessCount,commentCount);

		cache.put("situation",situation);

		return this;
	}
	
	/**
	 * 菜单栏
	 */
	private FreemakerCache menu(){
		cache.put("menuModelList",systemManagerService.getMenuList());
		return this;
	}
	
}
