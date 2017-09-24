package ru.zolotarev.portfolio.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

/**
 * Class of basic configurations for the Spring: DataSource, JpaVendorAdapter,
 * JpaTransactionManager, BeanPostProcessor, CommonsMultipartResolver.
 * Class is the source of bean definitions, activates the Spring transaction
 * opportunities through @Transactional. It activates the Spring Data JPA,
 * which would create a specific implementation for the repository of
 * the package "ru.zolotarev.portfolio.repository" and set to interact with
 * the database in memory, using the JPA.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "ru.zolotarev.portfolio.repository")
public class DatabaseConfig {

	/**
	 * Returns the transaction manager, which is suitable for applications
	 * that use a single JPA EntityManagerFactory for transactional data access.
	 *
	 * @param factory a object of class which implements
	 *                EntityManagerFactory.
	 * @return Returns the transaction manager.
	 */
	@Bean
	public JpaTransactionManager transactionManager(final EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}

	/**
	 * Create the entity manager factory.
	 *
	 * @param dataSource a object of the DataSource class with
	 *                   configurations for to connection
	 *                   to the database.
	 * @param adapter    Adapter to connect to the database.
	 * @return The object of the LocalContainerEntityManagerFactoryBean class.
	 */
	@Bean
	@ConfigurationProperties("database.hibernate")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource,
																	   final HibernateJpaVendorAdapter adapter) {
		final LocalContainerEntityManagerFactoryBean factory =
				new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		factory.setJpaVendorAdapter(adapter);
		return factory;
	}

	/**
	 * Returns a object of class DataSource with configurations for to get
	 * a physical connection to the database.
	 *
	 * @return The object of the DataSource class.
	 */
	@Bean
	@ConfigurationProperties("database.jdbc")
	public DataSource dataSource() {
		return new DataSource();
	}

	/**
	 * Returns setting adapter (JPA provider) to connect to the database.
	 *
	 * @return The object of the HibernateJpaVendorAdapter class.
	 */
	@Bean
	@ConfigurationProperties("database.hibernate")
	public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}

	/**
	 * Intercepts any JPA or Hibernate exceptions in Spring exception.
	 *
	 * @return The new object of class which implements BeanPostProcessor
	 * - PersistenceExceptionTranslationPostProcessor.
	 */
	@Bean
	public BeanPostProcessor persistenceTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
