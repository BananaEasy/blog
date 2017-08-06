package com.blog.mvc.cache;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.blog.mvc.service.IFrendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
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
	private ILabelService labelService;

	@Resource
	private IFrendLinkService frendLinkService;

	
	@Resource
	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		this.freeMarkerConfigurer = freeMarkerConfigurer;
		this.menu().rightItems().refresh();
	}
	

	
	public void refresh(){
		try {
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
	public FreemakerCache rightItems (){
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


		return this;
	}
	
	/**
	 * 菜单栏
	 */
	public FreemakerCache menu(){
		cache.put("menuModelList",systemManagerService.getMenuList());
		return this;
	}
	
}
