package com.hui.tgs.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author lihui
 * @title: MyBatisConfig216
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/1010:30
 */
@Configuration
@MapperScan(basePackages = "com.hui.tgs.dao.db216", sqlSessionTemplateRef = "sessionTemplate216")
@RefreshScope
public class MyBatisConfig216 {

    @Value(value = "${mybatis-plus.type-aliases-package-db216}")
    private String typeAliasesPackage216;

    @Value(value = "${mybatis-plus.mapper-locations-db216}")
    private String resourcesXml216;

    @Primary
    @Bean("sessionFactory216")
    @RefreshScope
    public SqlSessionFactory sqlSessionFactory216(
            @Qualifier("dataSource216") DataSource defectDataSource216) throws Exception{
        //此处mybatis-plus得配置为MybatisSqlSessionFactoryBean，不能配置成SqlSessionFactoryBean，否则会报无法绑定的错误信息
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(defectDataSource216);
        factoryBean.setTypeAliasesPackage(typeAliasesPackage216);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources(resourcesXml216));
        factoryBean.getObject().getConfiguration().setJdbcTypeForNull(JdbcType.NULL);

        return factoryBean.getObject();
    }


    @Bean("transactionManager216")
    @RefreshScope
    public DataSourceTransactionManager transactionManager(
            @Qualifier("dataSource216")DataSource defectDataSource216){
        return new DataSourceTransactionManager(defectDataSource216);
    }

    @Bean("sessionTemplate216")
    @RefreshScope
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sessionFactory216")SqlSessionFactory sqlSessionFactory216) throws Exception{
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory216);
        return template;
    }

}

