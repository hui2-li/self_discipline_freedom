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
 * @projectName MyBatisConfig213
 * @description: mybatis配置类 213
 * @date 2020/8/619:51
 */
@Configuration
@MapperScan(basePackages = "com.hui.bobCat.dao.db213", sqlSessionTemplateRef = "sessionTemplate213")
@RefreshScope
public class MyBatisConfig213 {

	@Value(value = "${mybatis-plus.type-aliases-package-db213}")
	private String typeAliasesPackage213;

	@Value(value = "${mybatis-plus.mapper-locations-db213}")
	private String resourcesXml213;


	@Primary
	@Bean("sessionFactory213")
	@RefreshScope
	public SqlSessionFactory sqlSessionFactory213(
			@Qualifier("dataSource213")DataSource defectDataSource213) throws Exception{
		MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
		factoryBean.setDataSource(defectDataSource213);
		factoryBean.setTypeAliasesPackage(typeAliasesPackage213);
		factoryBean.setMapperLocations(
				new PathMatchingResourcePatternResolver()
						.getResources(resourcesXml213));
		factoryBean.getObject().getConfiguration().setJdbcTypeForNull(JdbcType.NULL);
		return factoryBean.getObject();
	}


	@Bean("transactionManager213")
	@RefreshScope
	public DataSourceTransactionManager transactionManager(
			@Qualifier("dataSource213")DataSource defectDataSource213){
		return new DataSourceTransactionManager(defectDataSource213);
	}

	@Bean("sessionTemplate213")
	@RefreshScope
	public SqlSessionTemplate sqlSessionTemplate(
			@Qualifier("sessionFactory213")SqlSessionFactory sqlSessionFactory213) throws Exception{
		SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory213);
		return template;
	}

}
