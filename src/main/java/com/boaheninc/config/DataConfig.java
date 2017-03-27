package com.boaheninc.config;

import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@PropertySource("app.properties")
public class DataConfig {
	@Autowired
	private Environment env;
	
    @Bean
	public LocalSessionFactoryBean sessionFactory(){
		Resource config = new ClassPathResource("hibernate.cfg.xml");
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setConfigLocation(config);
		sessionFactory.setPackagesToScan(env.getProperty("giflib.entity.package"));
		sessionFactory.setDataSource(dataSource());
		return sessionFactory;
	}

    @Bean
	public DataSource dataSource() {
    	BasicDataSource ds=new BasicDataSource();
    	ds.setDriverClassName(env.getProperty("giflib.db.driver"));
    	ds.setUrl(env.getProperty("giflib.db.url"));
    	ds.setUsername(env.getProperty("giflib.db.username"));
    	ds.setPassword(env.getProperty("giflib.db.password"));
		return ds;
	}
}
