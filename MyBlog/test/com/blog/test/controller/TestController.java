package com.blog.test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.test.model.Student;
import com.blog.test.service.TestService;


@Controller
public class TestController {
	
	@Resource
	private TestService testService;
	
	@RequestMapping(value="/index" ,method={RequestMethod.POST,RequestMethod.GET})
	public String index(){
		return "test/index";
	}
	
	@RequestMapping(value="/freemarker" ,method={RequestMethod.POST,RequestMethod.GET})
	public String freemarker(Model model){
		Map<String,String> map = new HashMap<>();
		map.put("user","张三");
		map.put("url","/index.action");
		map.put("name","测试");
		model.addAttribute("root", map);
		return "test/test";
	}
	
	@RequestMapping(value="/test" ,method={RequestMethod.POST,RequestMethod.GET})
	public String test(Student student){
		System.out.println("-------------" + student);
		testService.add(student);
		return "test/success";
	}
}
