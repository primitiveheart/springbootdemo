package com.example.springbootservice.config;

import com.example.springbootservice.bean.MyRoutingDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/6/25
 * Time  : 8:42 AM
 */
@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.master.jdbc-url}")
    private String url;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.master", ignoreInvalidFields = true)
    public DataSource masterDataSource() {
        DataSource dataSource = DataSourceBuilder.create().build();
        return dataSource;
    }

//    @Bean
//    @ConfigurationProperties("spring.datasource.slave1")
//    public DataSource slave1DataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    @ConfigurationProperties("spring.datasource.slave2")
//    public DataSource slave2DataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    public DataSource myRoutingDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
//                                          @Qualifier("slave1DataSource") DataSource slave1DataSource,
//                                          @Qualifier("slave2DataSource") DataSource slave2DataSource) {
//        Map<Object, Object> targetDataSource = new HashMap<>();
//        targetDataSource.put(DBTypeEnum.MASTER, masterDataSource);
//        targetDataSource.put(DBTypeEnum.SLAVE1, slave1DataSource);
//        targetDataSource.put(DBTypeEnum.SLAVE2, slave2DataSource);
//        // 路由数据源
//        MyRoutingDataSource myRoutingDataSource = new MyRoutingDataSource();
//        myRoutingDataSource.setDefaultTargetDataSource(masterDataSource);
//        myRoutingDataSource.setTargetDataSources(targetDataSource);
//        return myRoutingDataSource;
//    }
}
