package com.demo.framework.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.demo.modules.common.handler.MyMetaObjectHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLException;


@Component
public class DataSourceConfig {

    @Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource(DbConfig dbConfig) {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dbConfig.getDbUrl());
        datasource.setUsername(dbConfig.getUsername());
        datasource.setPassword(dbConfig.getPassword());
        datasource.setDriverClassName(dbConfig.getDriverClassName());
        datasource.setInitialSize(dbConfig.getInitialSize());
        datasource.setMinIdle(dbConfig.getMinIdle());
        datasource.setMaxActive(dbConfig.getMaxActive());
        datasource.setMaxWait(dbConfig.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(dbConfig.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(dbConfig.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(dbConfig.getValidationQuery());
        datasource.setTestWhileIdle(dbConfig.isTestWhileIdle());
        datasource.setTestOnBorrow(dbConfig.isTestOnBorrow());
        datasource.setTestOnReturn(dbConfig.isTestOnReturn());
        datasource.setPoolPreparedStatements(dbConfig.isPoolPreparedStatements());
        datasource.setMaxPoolPreparedStatementPerConnectionSize(dbConfig.getMaxPoolPreparedStatementPerConnectionSize());
        try {
            datasource.setFilters(dbConfig.getFilters());
        } catch (SQLException e) {
        }

        return datasource;
    }


    @Bean("sqlSessionFactory")
    public MybatisSqlSessionFactoryBean sqlSessionFactory(DruidDataSource dataSource, GlobalConfig globalConfig) throws IOException {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
        mybatisSqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath:/mapper/*/*.xml"));

        //分页插件
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType(DbType.MYSQL.getDb());
        mybatisSqlSessionFactoryBean.setPlugins(new Interceptor[]{paginationInterceptor});

        mybatisSqlSessionFactoryBean.setGlobalConfig(globalConfig);

        MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
        //关闭二级缓存
        mybatisConfiguration.setCacheEnabled(false);

        //下划线转驼峰
        mybatisConfiguration.setMapUnderscoreToCamelCase(true);
        mybatisSqlSessionFactoryBean.setConfiguration(mybatisConfiguration);

        return mybatisSqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.demo.modules.*.dao");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }

    /**
     * 全局配置
     *
     * @return
     */
    @Bean
    public GlobalConfig globalConfig() {
        //数据库配置
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();

        // 默认为UUID
        dbConfig.setIdType(IdType.UUID);

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //全局配置
        globalConfig.setMetaObjectHandler(new MyMetaObjectHandler());
        globalConfig.setDbConfig(dbConfig);
        return globalConfig;
    }

}
