package com.xmair.core.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by summer on 2016/11/25.
 */
@Configuration
@MapperScan(basePackages = "com.xmair.core.mapper.framedb", sqlSessionTemplateRef  = "framedbSqlSessionTemplate")
public class FramedbConfig {

    @Bean(name = "framedbDataSource")
    @ConfigurationProperties(prefix = "framedb.spring.datasource")

    public DataSource framedbDataSource() {
        return new DruidDataSource();
    }



    @Bean(name = "framedbSqlSessionFactory")

    public SqlSessionFactory testSqlSessionFactory(@Qualifier("framedbDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        bean.setMapperLocations(resolver.getResources("classpath:framedb/*.xml"));
        return bean.getObject();
    }




    @Bean(name = "framedbTransactionManager")

    public DataSourceTransactionManager testTransactionManager(@Qualifier("framedbDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "framedbSqlSessionTemplate")

    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("framedbSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}