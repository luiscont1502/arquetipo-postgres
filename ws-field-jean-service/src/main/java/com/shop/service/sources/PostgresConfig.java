package com.shop.service.sources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.shop.peristence.postgres.service", "com.shop.service","com.shop.persistence.security.service.impl"
        ,"com.shop.persistence.security.service","com.shop.persistence.security.Utils","com.shop.service.service","com.shop.persistence.security.security.jwt",
        "com.shop.persistence.security.security.filters",
        "com.shop.peristence.postgres.repository","com.shop.persistence.security.repository"})
@EnableJpaRepositories(basePackages = {"com.shop.peristence.postgres.repository","com.shop.persistence.security.repository"})
@EnableTransactionManagement
public class PostgresConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/store_jean");
        dataSource.setUsername("postgres");
        dataSource.setPassword("luis");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("com.shop.peristence.postgres.entity","com.shop.persistence.security.entity");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return emf;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
