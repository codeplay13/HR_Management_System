package com.lti.hrmanagementsystem.configuration;

import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.lti.hrmanagementsystem")
public class AppConfig {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource managerDataSource = new DriverManagerDataSource();
		managerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		managerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		managerDataSource.setUsername("hrsystem");
		managerDataSource.setPassword("hrsystem");
		return managerDataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		Properties props = new Properties();
		props.put(SHOW_SQL, true);
		props.put(HBM2DDL_AUTO, "update");

		sessionFactory.setHibernateProperties(props);
		sessionFactory.setPackagesToScan(new String[] {"com.lti.hrmanagementsystem.bean"});
		return sessionFactory;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties hibernateProperties() {
		return new Properties() {
			private static final long serialVersionUID = 1L;
			{
				setProperty("hibernate.hbm2ddl.auto", "create");
				setProperty("hibernate.dialect", "OracleDialect");
			}
		};
	}

	/*
	 * @Bean public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	 * 
	 * JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	 * jdbcTemplate.setResultsMapCaseInsensitive(true); return jdbcTemplate; }
	 */
}