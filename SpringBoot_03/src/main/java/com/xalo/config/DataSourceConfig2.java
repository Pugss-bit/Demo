package com.xalo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.xalo.dao1", sqlSessionFactoryRef = "sessionFactory2")
public class DataSourceConfig2 {

	// 配置数据源
	// 将datasource对象注册到ioc容器,并且id为datasource1
	@Bean(name = "datasource2")
	// dataSource的配置都来自于属性文件中以prefix开头的属性
	@ConfigurationProperties(prefix = "spring.datasource.sd")
	public DataSource getDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "sessionFactory2")
	public SqlSessionFactory getSqlSessionFactory(@Qualifier("datasource2") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		// 设置数据源
		bean.setDataSource(dataSource);
//		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:daoMapper2/**/*Mapper.xml"));
		return bean.getObject();
	}
}