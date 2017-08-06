package com.blog.gemerator;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.blog.mvc.dao.AccessRecordMapper;
import com.blog.mvc.dao.ArticleMapper;
import com.blog.mvc.dao.CategoryMapper;
import com.blog.mvc.entity.AccessRecord;
import com.blog.mvc.entity.Category;
import com.github.pagehelper.PageHelper;


/**
 * myBatis 数据测试
 * @author LiHang
 *
 */
public class AccessRecordEntityTest {
	private ApplicationContext ac;
	private AccessRecordMapper am ;
	private CategoryMapper cm ;
	
	@Before
	public void load(){
		ac = new ClassPathXmlApplicationContext("classpath:bean.xml");
		am = (AccessRecordMapper)ac.getBean("accessRecordMapper");
		cm = (CategoryMapper)ac.getBean("categoryMapper");
	}
	
	@Test
	public void findById(){
		AccessRecord selectByPrimaryKey = am.selectByPrimaryKey("1c971d14121a44e98bdac24eaf76a70c");
		System.out.println(selectByPrimaryKey);
	}	
	
	
	@Test
	public void getAll(){
	/*	AccessRecordExample are = new AccessRecordExample();
		//条件
		AccessRecordExample.Criteria c = are.createCriteria();
		c.andAcceptencodingIsNull();
		//使用null也可以全部查出来
		PageHelper.startPage(1, 10);
		List<AccessRecord> selectByExample = am.selectByExample(are);	
		for(AccessRecord ar : selectByExample){
			System.out.println(ar);
		}*/
		System.out.println(am.selectByExample());
		System.out.println(am.countByExample());
	}
	@Test
	public void insert(){
		AccessRecord ar = new AccessRecord();
		ar.setId(UUID.randomUUID().toString().replace("-",""));
		ar.setMillisecond(1000000);
		ar.setStarttime(new Date(new Date().getTime() -100000));
		ar.setEndtime(new Date(new Date().getTime() +100000));
		System.out.println(ar);
		am.insert(ar);
	}
	
	@Test
	public void insertNull(){
		cm.insert(null);
	}
	
	
	@Test
	public void getAll1(){
		PageHelper.startPage(2,100);
		List<Category> selectByExample = cm.selectByExample(null);	
		for(Category ar : selectByExample){
			System.out.println(ar);
		}
	}
	
	@Test
	public void update(){
		AccessRecord ar = new AccessRecord();
		ar.setId("1c971d14121a44e98bdac24eaf76a70c");
		ar.setMillisecond(1000000);
		ar.setStarttime(new Date(new Date().getTime() -100000));
		ar.setEndtime(new Date(new Date().getTime() +100000));
		ar.setCookie("来了");
		System.out.println(ar);
		am.updateByPrimaryKey(ar);
	}
	
	
	@Test
	public void select(){
		ArticleMapper am = ac.getBean(ArticleMapper.class);
		System.out.println(am.groupByMonth());
	}
	
}
