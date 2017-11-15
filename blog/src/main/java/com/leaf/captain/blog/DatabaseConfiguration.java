package com.leaf.captain.blog;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
//@EnableTransactionManagement
@PropertySource("classpath:/configuration/db.properties")
public class DatabaseConfiguration {

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

    /**
     *           <prop key="hibernate.show_sql">${hibernate.prop.show_sql.${RUN_MODE}}</prop>
     <prop key="hibernate.format_sql">${hibernate.prop.format_sql.${RUN_MODE}}</prop>
     <prop key="hibernate.hbm2ddl.auto">${hibernate.prop.hbm2ddl.auto.${RUN_MODE}}</prop>
     <prop key="hibernate.current_session_context_class">${hibernate.current_session_context_class.${RUN_MODE}}</prop>
     <prop key="hibernate.dialect">${SYSTEM_DB_DIALECT}</prop>
     <prop key="hibernate.dialect">${SYSTEM_DB_DIALECT}</prop>
     <prop key="hibernate.hbm2ddl.import_files">${hibernate.hbm2ddl.import_files.${RUN_MODE}}</prop>
     * @return
     */

    @Bean
    public LocalSessionFactoryBean sessionFactory() {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
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

//    @Bean(destroyMethod = "close", initMethod = "init")
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