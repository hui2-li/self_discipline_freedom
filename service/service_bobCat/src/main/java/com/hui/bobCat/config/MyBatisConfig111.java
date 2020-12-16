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
 * @title: MyBatisConfig111
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/88:47
 */
@Configuration
@MapperScan(basePackages = "com.hui.bobCat.dao.db111", sqlSessionTemplateRef = "sessionTemplate111")
@RefreshScope
public class MyBatisConfig111 {

    @Value(value = "${mybatis-plus.type-aliases-package-db111}")
    private String typeAliasesPackage111;

    @Value(value = "${mybatis-plus.mapper-locations-db111}")
    private String resourcesXml111;

    @Primary
    @Bean("sessionFactory111")
    @RefreshScope
    public SqlSessionFactory sqlSessionFactory111(
            @Qualifier("dataSource111") DataSource defectDataSource111) throws Exception{
        //此处mybatis-plus得配置为MybatisSqlSessionFactoryBean，不能配置成SqlSessionFactoryBean，否则会报无法绑定的错误信息
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(defectDataSource111);
        factoryBean.setTypeAliasesPackage(typeAliasesPackage111);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources(resourcesXml111));
        factoryBean.getObject().getConfiguration().setJdbcTypeForNull(JdbcType.NULL);

        return factoryBean.getObject();
    }


    @Bean("transactionManager111")
    @RefreshScope
    public DataSourceTransactionManager transactionManager(
            @Qualifier("dataSource111")DataSource defectDataSource111){
        return new DataSourceTransactionManager(defectDataSource111);
    }

    @Bean("sessionTemplate111")
    @RefreshScope
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sessionFactory111")SqlSessionFactory sqlSessionFactory111) throws Exception{
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory111);
        return template;
    }

}
