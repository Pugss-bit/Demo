package com.xalo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xalo.dao.StudentDao;
import com.xalo.dao1.PersonDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03ApplicationTests {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private PersonDao personDao;

	@Test
	public void contextLoads() {
		studentDao.addStudent("test", "男", "12");
		personDao.addPerson("张三");
	}
}