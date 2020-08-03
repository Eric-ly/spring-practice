package com.example.spring_mvc_test.controller;

import com.example.spring_mvc_test.model.ClassModel;
import com.example.spring_mvc_test.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring_mvc_test.model.Student;

@Controller
@RequestMapping("/")
public class DemoController {

	@Autowired
	private ClassModel classModel;

	@Autowired
	private Service service;

	private ApplicationContext demo;

	@ResponseBody
	@RequestMapping(value = "hello",
			method = {RequestMethod.GET, RequestMethod.POST},
			produces = "application/json;charset=utf-8")
	public String hello() {
		if (classModel != null && !CollectionUtils.isEmpty(classModel.getStudents())) {
			return service.showStudentName(classModel.getStudents().get(0));
		}
		String value = service.check();
		//		WebApplicationContext webContext = ContextLoader.getCurrentWebApplicationContext();
		return "hello" ;
	}

	public ApplicationContext getDemo() {
		return demo;
	}

	public void setDemo(ApplicationContext demo) {
		this.demo = demo;
	}
}