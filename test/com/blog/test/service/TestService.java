/*package com.blog.test.service;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.mvc.dao.AccessRecordMapper;
import com.blog.mvc.entity.AccessRecord;
import com.blog.test.model.Student;


*//**
 * 测试事务回滚
 * 
 * 
 * 
 * @author LiHang
 *
 *//*
@Service
public class TestService {
	@Resource
	private AccessRecordMapper accessRecordMapper;
	
	public void add(){
		AccessRecord ar = new AccessRecord();
		ar.setId(UUID.randomUUID().toString().replace("-",""));
		ar.setMillisecond(1000000);
		ar.setStarttime(new Date(new Date().getTime() -100000));
		ar.setEndtime(new Date(new Date().getTime() +100000));
		System.out.println(ar);
		accessRecordMapper.insert(ar);
		
		int i = 1/0;
	}
	
}
*/