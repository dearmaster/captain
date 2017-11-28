package com.leaf.captain.dear;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:/configuration/db.properties")
public class DatabaseConfiguration {

    /**
     * Exception will be thrown like below if not set this property to sessionFactory
     * org.hibernate.hql.internal.ast.QuerySyntaxException: Article is not mapped [from Article]
     */
    private static final String packageToScanEntities = "com.leaf.captain.dear.model";

    @Value("${SYSTEM_DB_URL}")
    private String url;
    @Value("${SYSTEM_DB_DRIVER}")
    private String driver;
    @Value("${SYSTEM_DB_USERNAME}")
    private String username;
    @Value("${SYSTEM_DB_PASSWORD}")
    private String password;
    @Value("${SYSTEM_DB_DIALECT}")
    private String hibernateDialect;

    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;
    @Value("${hibernate.format_sql}")
    private String hibernateFormatSql;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddlAuto;
    @Value("${hibernate.current_session_context_class}")
    private String hibernateCurrentSessionContextClass;
    @Value("${hibernate.hbm2ddl.import_files}")
    private String hibernateHbm2ddlImportFiles;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(packageToScanEntities);
        Properties props = new Properties();
        props.setProperty("hibernate.show_sql", hibernateShowSql);
        props.setProperty("hibernate.format_sql", hibernateFormatSql);
        props.setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        props.setProperty("hibernate.current_session_context_class", hibernateCurrentSessionContextClass);
        props.setProperty("hibernate.dialect", hibernateDialect);
        props.setProperty("hibernate.hbm2ddl.import_files", hibernateHbm2ddlImportFiles);
        sessionFactory.setHibernateProperties(props);
        return sessionFactory;
    }

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BasicDataSource datasource = new BasicDataSource();
        datasource.setUrl(url);
        datasource.setDriverClassName(driver);
        datasource.setUsername(username);
        datasource.setPassword(password);
        return datasource;
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}