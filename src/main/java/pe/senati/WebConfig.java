/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import pe.senati.model.RoleConverter;

@Configuration //indica que esta clase es de configuración
@ComponentScan //indica el uso de los @Components (beans)
@EnableWebMvc //habilita el uso de spring mvc
@EnableTransactionManagement //habilita el uso de transacciones
public class WebConfig extends WebMvcConfigurerAdapter 
{
    @Bean
    public ViewResolver viewResolver()
    {
        //objeto que resuelve la ruta en donde se almacenará las páginas jsp
        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
        
        resolver.setPrefix("/WEB-INF/views/"); //ruta de la carpeta para las páginas        
        resolver.setSuffix(".jsp"); //se define el tipo de páginas, que será .jsp
        resolver.setExposeContextBeansAsAttributes(true);
        
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/public/**").addResourceLocations("/public/");
    }
    
    //bean para la conexión a la BD
    @Bean
    public ComboPooledDataSource dataSource() throws PropertyVetoException
    {
        //objeto pool de conexiones
        ComboPooledDataSource cpds=new ComboPooledDataSource();
        
        //driver and url for MySQL 8.x
        cpds.setDriverClass("com.mysql.cj.jdbc.Driver"); //driver
        cpds.setJdbcUrl("jdbc:mysql://node41855-env-7484652.jelastic.saveincloud.net:3306/dbSistemaBotica?serverTimezone=UTC"); //url
        
        cpds.setUser("root"); //usuario
        cpds.setPassword("FAAqek43532"); //password
        
        cpds.setMinPoolSize(10); //minima cant de conexiones
        cpds.setMaxPoolSize(50); //maxima cant de conexiones
        cpds.setMaxStatements(20); //maxima cant de consultas
        cpds.setTestConnectionOnCheckout(true);
        
        return cpds;
    }              
    
    //bean para usar JPA-Hibernate
    @Bean
    public JpaVendorAdapter jpaVendorAdapter()
    {
        //objeto adaptador
        HibernateJpaVendorAdapter adapter=new HibernateJpaVendorAdapter();
        
        //adaptandose 
        adapter.setDatabase(Database.MYSQL); //a MySQL
        adapter.setShowSql(true); //a usar SQL
        adapter.setGenerateDdl(true); //a usar DDL (crear tablas,restricciones,etc)
        
        //dialecto
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        
        return adapter;
    }
    
    //bean contenedor (dataSource y jpaVendorAdapter)
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource,JpaVendorAdapter jpaVendorAdapter)
    {
        //objeto contenedor
        LocalContainerEntityManagerFactoryBean emfb=
                new LocalContainerEntityManagerFactoryBean();
        
        //contiene
        emfb.setDataSource(dataSource); //a dataSource
        emfb.setJpaVendorAdapter(jpaVendorAdapter); //a jpaVendorAdapter
        
        //se define el paquete modelo de negocio
        emfb.setPackagesToScan("pe.senati.model");
        
        return emfb;
    }
    
    //bean para el manejo de excepciones
    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    //bean para usar el objeto EntityManager (Manejador de entidades)
    @Bean
    public PersistenceAnnotationBeanPostProcessor paPostProcessor() {
        return new PersistenceAnnotationBeanPostProcessor();
    }
    
    //bean para el manejo de transacciones
    @Bean
    public PlatformTransactionManager transactionManager(
            DataSource dataSource, EntityManagerFactory entityManagerFactory)
    {
        //objeto transacción
        JpaTransactionManager transactionManager=new JpaTransactionManager();
        
        transactionManager.setDataSource(dataSource);
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        
        return transactionManager;
    }
    /*
    @Bean
    public RoleConverter roleConverter(){
        return new RoleConverter();
    }

    // agrgando formato convertidor
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(roleConverter());
    }
    */
    
}
