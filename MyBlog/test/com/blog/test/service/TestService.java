package com.blog.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.test.dao.StudentMapper;
import com.blog.test.model.Student;

@Service
public class TestService {
	@Autowired
	private StudentMapper testDao;
	
	public void add(Student student){
		
		
		testDao.add2(student);
		int i = 1/0;
	}
	
}
