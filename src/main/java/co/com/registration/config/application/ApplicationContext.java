package co.com.registration.config.application;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import co.com.registration.application.aspect.LogginAspect;

@Configuration
@EnableTransactionManagement
@ComponentScan({"co.com.registration.config"})
@PropertySource(value = {"classpath:jdbc.properties"})
@EnableAspectJAutoProxy
public class ApplicationContext {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String [] {"co.com.registration.application.model"});
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
	}

	private Properties getHibernateProperties() {
		Properties prop = new Properties();
		
		prop.put("hibernate.dialect", env.getProperty("oracle.dialect"));
		prop.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		prop.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		prop.put("hibernate.query.substitutions", env.getProperty("hibernate.query.substitutions"));
		prop.put("hibernate.connection.release_mode", env.getProperty("hibernate.connection.release_mode"));
		prop.put("hibernate.generate_statistics", env.getProperty("hibernate.generate_statistics"));
		
		return prop;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {		
		HibernateTransactionManager txtManager = new HibernateTransactionManager();
		txtManager.setSessionFactory(sessionFactory);
		
		return txtManager;		
	}
	
	@Bean 
    public LogginAspect myAspect() {
        return new LogginAspect();
    }

	
}