package ua.kiev.prog.config;

import org.hibernate.dialect.MySQLInnoDBDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("ua.kiev.prog") // Указываем в каком пакете искать Bean
@EnableTransactionManagement // Включаем Spring JTA
@EnableWebMvc // Включаем Spring MVC
public class AppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) { // Bean, который будет управлять транзакциями
        return new JpaTransactionManager(emf);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory
            (DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        Properties jpaProp = new Properties();
        jpaProp.put("hibernate.hbm2ddl.auto", "create");
        jpaProp.put("connection.pool_size",10);

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactory.setJpaProperties(jpaProp);
        entityManagerFactory.setPackagesToScan("ua.kiev.prog");

        return entityManagerFactory;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() { // Bean, который указывает, кто будет выступать JPA реализацией
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true); // Задает генерить или нет схему на основе нашего Entity
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect"); // Указываем диалект

        return adapter;
    }

    @Bean
    public DataSource dataSource() {   // Указывает источник данных
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/dbProg?useSSL=true");
        ds.setUsername("Zakusylo");
        ds.setPassword("03051993_Zakusylo");

        return ds;
    }

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/dynamic/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setOrder(1);
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/static/**")
                .addResourceLocations("/static/");
    }
}
