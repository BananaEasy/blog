package com.blog.test.dao;

import java.util.List;

import com.blog.test.model.Student;

public interface StudentMapper {
	public Integer add2(Student student);
	public List<Student> list();
	public Integer add1();
	
}
