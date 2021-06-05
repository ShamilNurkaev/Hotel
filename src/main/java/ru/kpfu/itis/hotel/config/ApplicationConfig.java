package ru.kpfu.itis.hotel.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.kpfu.itis.hotel.converters.DateConverter;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

@Configuration
@ComponentScan(basePackages = {
        "ru.kpfu.itis.hotel.services",
        "ru.kpfu.itis.hotel.aspects",
        "ru.kpfu.itis.hotel.controllers"
})
@EntityScan(basePackages = "ru.kpfu.itis.hotel.models")
@EnableJpaRepositories(basePackages = "ru.kpfu.itis.hotel.repositories")
@EnableAspectJAutoProxy
public class ApplicationConfig implements WebMvcConfigurer {

    private final Environment environment;

    @Autowired
    public ApplicationConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public DataSource dataSource() {
//        return new HikariDataSource(hikariConfig());
//    }

//    @Bean
//    public HikariConfig hikariConfig() {
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setJdbcUrl(environment.getProperty("database.url"));
//        hikariConfig.setDriverClassName(environment.getProperty("database.driver.classname"));
//        hikariConfig.setUsername(environment.getProperty("database.username"));
//        hikariConfig.setPassword(environment.getProperty("database.password"));
//        hikariConfig.setMaximumPoolSize(Integer.parseInt(
//                Objects.requireNonNull(environment.getProperty("database.hikari.max-pool-size"))));
//        return hikariConfig;
//    }

//    @Bean
//    public FreeMarkerViewResolver freemarkerViewResolver() {
//        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//        resolver.setPrefix("");
//        resolver.setSuffix(".ftlh");
//        resolver.setContentType("text/html;charset=UTF-8");
//        return resolver;
//    }

//    @Bean
//    public FreeMarkerConfigurer freemarkerConfig() {
//        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//        configurer.setTemplateLoaderPaths("classpath:/templates/");
//        return configurer;
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:static/");
    }

    @Bean
    DateConverter dateConverter() {
        return new DateConverter();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(dateConverter());
    }

    //    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        // создаем адаптер, который позволит Hibernate работать с Spring Data Jpa
//        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
//        hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
//        // создали фабрику EntityManager как Spring-бин
//        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactory.setDataSource(dataSource());
//        entityManagerFactory.setPackagesToScan("ru.kpfu.itis.group903.nurkaev.models");
//        entityManagerFactory.setJpaVendorAdapter(hibernateJpaVendorAdapter);
//        entityManagerFactory.setJpaProperties(additionalHibernateProperties());
//        return entityManagerFactory;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//
//        return transactionManager;
//    }
//
//    private Properties additionalHibernateProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
//        properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
//        properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
//
//        properties.setProperty("hibernate.hbm2ddl.import_files_sql_extractor",
//                environment.getProperty("hibernate.hbm2ddl.import_files_sql_extractor"));
//        properties.setProperty("hibernate.connection.charSet",
//                environment.getProperty("hibernate.connection.charSet"));
//        properties.setProperty("hibernate.hbm2ddl.import_files",
//                environment.getProperty("hibernate.hbm2ddl.import_files"));
//        properties.setProperty("connection.autocommit", environment.getProperty("connection.autocommit"));
//        return properties;
//    }
}
