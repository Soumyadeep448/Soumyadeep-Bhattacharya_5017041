package com.example.employeemanagementsystem.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.example.employeemanagementsystem.repository.department",
    entityManagerFactoryRef = "departmentEntityManagerFactory",
    transactionManagerRef = "departmentTransactionManager"
)
public class SecondaryDataSourceConfig {

    @Bean(name = "departmentDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource departmentDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "departmentEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean departmentEntityManagerFactory(
            @Qualifier("departmentDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.example.employeemanagementsystem.model.department");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    @Bean(name = "departmentTransactionManager")
    public PlatformTransactionManager departmentTransactionManager(
            @Qualifier("departmentEntityManagerFactory") LocalContainerEntityManagerFactoryBean departmentEntityManagerFactory) {
        return new JpaTransactionManager(departmentEntityManagerFactory.getObject());
    }
}
