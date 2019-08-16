package com.xalo.dao1;

import org.apache.ibatis.annotations.Insert;

public interface PersonDao {

	@Insert("insert into person (name) values (#{name})")
	public boolean addPerson(String name);

}
