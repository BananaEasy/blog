package xyz.lihang.blog.mvc.quartz;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import xyz.lihang.blog.model.Situation;
import xyz.lihang.blog.mvc.dao.AccessRecordMapper;
import xyz.lihang.blog.mvc.service.IFrendLinkService;
import xyz.lihang.blog.mvc.service.impl.ArticleManagerService;
import xyz.lihang.blog.mvc.service.impl.MessageHandle;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import xyz.lihang.blog.mvc.service.IArticleService;
import xyz.lihang.blog.mvc.service.ILabelService;
import xyz.lihang.blog.mvc.service.ISystemManagerService;

import freemarker.template.TemplateModelException;


@Component
public class BlogCacheManager {


	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	private Map <String,Object> cache =new HashMap<>();
	
	@Resource
	private ISystemManagerService systemManagerService;
	@Resource
	private IArticleService articleService;
	@Resource
	private AccessRecordMapper accessRecordMapper;
	@Resource
	private MessageHandle messageHandle;
	@Resource
	private ILabelService labelService;
	@Resource
	private IFrendLinkService frendLinkService;

	@Autowired
	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		this.freeMarkerConfigurer = freeMarkerConfigurer;
		this.refreshFreemakerCache();
	}

	/**
	 * 刷新Freemaker缓存 和 Redis 缓存
	 */
	@Caching(evict = {
			@CacheEvict(cacheNames= ArticleManagerService.ArticleListCacheName, allEntries=true),
			@CacheEvict(cacheNames=ArticleManagerService.ArticleBeanCacheName, allEntries=true ) })
	public void refreshFreemakerCache(){
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
	private BlogCacheManager rightItems (){
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
		Long messageCount = messageHandle.getCount();
		Long accessCount = accessRecordMapper.countByExample();

		//访问记录
		Situation situation = new Situation(articleCount,messageCount,accessCount);
		cache.put("situation",situation);
		return this;
	}
	
	/**
	 * 菜单栏
	 */
	private BlogCacheManager menu(){
		cache.put("menuModelList",systemManagerService.getMenuList());
		return this;
	}
	
}
