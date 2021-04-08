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
 * @title: MyBatisConfig17
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/1010:30
 */
@Configuration
@MapperScan(basePackages = "com.hui.tgs.dao.db17", sqlSessionTemplateRef = "sessionTemplate17")
@RefreshScope
public class MyBatisConfig17 {

    @Value(value = "${mybatis-plus.type-aliases-package-db17}")
    private String typeAliasesPackage17;

    @Value(value = "${mybatis-plus.mapper-locations-db17}")
    private String resourcesXml17;

    @Primary
    @Bean("sessionFactory17")
    @RefreshScope
    public SqlSessionFactory sqlSessionFactory17(
            @Qualifier("dataSource17") DataSource defectDataSource17) throws Exception{
        //此处mybatis-plus得配置为MybatisSqlSessionFactoryBean，不能配置成SqlSessionFactoryBean，否则会报无法绑定的错误信息
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(defectDataSource17);
        factoryBean.setTypeAliasesPackage(typeAliasesPackage17);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources(resourcesXml17));
        factoryBean.getObject().getConfiguration().setJdbcTypeForNull(JdbcType.NULL);

        return factoryBean.getObject();
    }


    @Bean("transactionManager17")
    @RefreshScope
    public DataSourceTransactionManager transactionManager(
            @Qualifier("dataSource17")DataSource defectDataSource17){
        return new DataSourceTransactionManager(defectDataSource17);
    }

    @Bean("sessionTemplate17")
    @RefreshScope
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sessionFactory17")SqlSessionFactory sqlSessionFactory17) throws Exception{
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory17);
        return template;
    }

}

