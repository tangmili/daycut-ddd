package com.cathay.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * 单库配置
 * @author James
 * @date 2018/5/14 下午9:15
 */
@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@MapperScan(basePackages = "com.cathay.account.accswitch.dao.persistence")
public class GuotaiSingleDataSourceConfig {

    @Bean(name = "guotaiSingleDataSource")
    @Primary
    public DataSource getDataSource(@Qualifier("daycutdataSource") DataSource ddsSingleDataSource) {
        DataSource dataSource = ddsSingleDataSource;
        return dataSource;
    }

    @Bean(name = "guotaiSingleSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("guotaiSingleDataSource") DataSource guotaiSingleDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(guotaiSingleDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mybatis/mapper/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis/mybatis-config.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "guotaiSingleSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("guotaiSingleSqlSessionFactory") SqlSessionFactory guotaiSingleSqlSessionFactory){
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(guotaiSingleSqlSessionFactory);
        return sqlSessionTemplate;
    }

    @Bean("guotaiSingleTransactionManager")
    @Primary
    public PlatformTransactionManager transactionManager(@Qualifier("guotaiSingleDataSource") DataSource guotaiSingleDataSource) {
        return new DataSourceTransactionManager(guotaiSingleDataSource);
    }

    @Bean("guotaiSingleTransactionTemplate")
    public TransactionTemplate transactionTemplate(@Qualifier("guotaiSingleDataSource") DataSource guotaiSingleDataSource){
        return new TransactionTemplate(transactionManager(guotaiSingleDataSource));
    }
}
