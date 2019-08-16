package com.xalo.dao;

import org.apache.ibatis.annotations.Insert;

public interface StudentDao {

	/*
	 * 事务的注解,哪个方法需要,就给哪个方法上添加即可 支队publc修饰的方法有作用,其它域修饰符修饰的方法添加之后,不会报错,但是也没用
	 */
	@Insert("insert into student (name,sex,age) values (#{name},#{sex},#{age})")
	public boolean addStudent(String name, String sex, String age);
}
