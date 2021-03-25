package com.hui.bobCat.config;

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
 * @title: MyBatisConfig77
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/1010:30
 */
@Configuration
@MapperScan(basePackages = "com.hui.bobCat.dao.db77", sqlSessionTemplateRef = "sessionTemplate77")
@RefreshScope
public class MyBatisConfig77 {

    @Value(value = "${mybatis-plus.type-aliases-package-db77}")
    private String typeAliasesPackage77;

    @Value(value = "${mybatis-plus.mapper-locations-db77}")
    private String resourcesXml77;

    @Primary
    @Bean("sessionFactory77")
    @RefreshScope
    public SqlSessionFactory sqlSessionFactory77(
            @Qualifier("dataSource77") DataSource defectDataSource77) throws Exception{
        //此处mybatis-plus得配置为MybatisSqlSessionFactoryBean，不能配置成SqlSessionFactoryBean，否则会报无法绑定的错误信息
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(defectDataSource77);
        factoryBean.setTypeAliasesPackage(typeAliasesPackage77);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources(resourcesXml77));
        factoryBean.getObject().getConfiguration().setJdbcTypeForNull(JdbcType.NULL);

        return factoryBean.getObject();
    }


    @Bean("transactionManager77")
    @RefreshScope
    public DataSourceTransactionManager transactionManager(
            @Qualifier("dataSource77")DataSource defectDataSource77){
        return new DataSourceTransactionManager(defectDataSource77);
    }

    @Bean("sessionTemplate77")
    @RefreshScope
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sessionFactory77")SqlSessionFactory sqlSessionFactory77) throws Exception{
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory77);
        return template;
    }

}

