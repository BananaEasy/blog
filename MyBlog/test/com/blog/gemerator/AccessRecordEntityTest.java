package com.blog.gemerator;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hang.blog.mvc.dao.AccessRecordMapper;
import com.hang.blog.mvc.entity.AccessRecord;
import com.hang.blog.mvc.entity.AccessRecordExample;



public class AccessRecordEntityTest {
	private ApplicationContext ac;
	private AccessRecordMapper am ;
	
	@Before
	public void load(){
		ac = new ClassPathXmlApplicationContext("classpath:bean.xml");
		am = (AccessRecordMapper)ac.getBean("accessRecordMapper");
	}
	
	@Test
	public void findById(){
		AccessRecord selectByPrimaryKey = am.selectByPrimaryKey("1c971d14121a44e98bdac24eaf76a70c");
		System.out.println(selectByPrimaryKey);
	}
	
	
	@Test
	public void getAll(){
		AccessRecordExample are = new AccessRecordExample();
		//条件
		AccessRecordExample.Criteria c = are.createCriteria();
		c.andAcceptencodingIsNull();
		//使用null也可以全部查出来
		List<AccessRecord> selectByExample = am.selectByExample(are);	
		for(AccessRecord ar : selectByExample){
			System.out.println(ar);
		}
		
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
	
	
	
	
}
