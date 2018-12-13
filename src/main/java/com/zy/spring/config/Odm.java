package com.zy.spring.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;

@Configuration
public class Odm implements EnvironmentAware {

    private Environment environment;

    private static final Logger logger = LoggerFactory.getLogger(Odm.class);

    @Bean(name = "mysqlDb1")
    public DataSource dataSource1(){

        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(environment.getProperty("odm.url"));
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(environment.getProperty("odm.password"));
        mysqlXaDataSource.setUser(environment.getProperty("odm.username"));

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("mysql0");


        return xaDataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("mysqlDb1") DataSource mysqlDb1){

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mysqlDb1);

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setConfigLocation(resolver.getResources(environment.getProperty("odm.mybatisConfigLocationLocation"))[0]);
        } catch (Exception e) {
            logger.error(e.toString());
            throw new RuntimeException(e);
        }

        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){

        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //扫描Mapper配置文件与接口的包名
        mapperScannerConfigurer.setBasePackage(environment.getProperty("odm.mapperScannerConfigurerBasePackage"));
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");

        return mapperScannerConfigurer;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
