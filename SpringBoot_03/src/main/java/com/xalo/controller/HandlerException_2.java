package com.xalo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

//@Component
public class HandlerException_2 implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		System.out.println("执行了统一处理异常的方法");
		ex.printStackTrace();
		ModelAndView mv = new ModelAndView();
		mv.addObject("ex", ex);
		mv.setViewName("error");
		return mv;// spring中的ModelAndView是干什么用的?
	}

}
