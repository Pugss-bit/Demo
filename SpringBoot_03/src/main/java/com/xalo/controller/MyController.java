package com.xalo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xalo.service.StudentService;

@Controller
public class MyController {

//	@GetMapping("/first")
//	public String first() {
//		System.out.println("first方法");
//		int a = 10 / 0;
//		return "index";
//	}

	@Autowired
	private StudentService studentService;

	@RequestMapping("/add")
	@ResponseBody
	public String addStudent(String name, String sex, String age) {
		return studentService.addStudent(name, sex, age) ? "成功" : "失败";
	}

//	@GetMapping("/ad")
//	@ResponseBody
//	public String advice() {
//		System.out.println("asd");
//		return "asd";
//	}

//	@ExceptionHandler()
//	public String handlerException(Exception exception) {
//		exception.printStackTrace();
//		return "error";
//	}
//
//	@ExceptionHandler(value = ArithmeticException.class)
//	public String handlerAException(Exception exception) {
//		exception.printStackTrace();
//		return "error";
//	}
}