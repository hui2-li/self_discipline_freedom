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
 * @projectName MyBatisConfig166
 * @description: mybatis配置类 166
 * @date 2020/8/619:51
 */
@Configuration
@MapperScan(basePackages = "com.hui.bobCat.dao.db166", sqlSessionTemplateRef = "sessionTemplate166")
@RefreshScope
public class MyBatisConfig166 {

	@Value(value = "${mybatis-plus.type-aliases-package-db166}")
	private String typeAliasesPackage166;

	@Value(value = "${mybatis-plus.mapper-locations-db166}")
	private String resourcesXml166;

	@Primary
	@Bean("sessionFactory166")
	@RefreshScope
	public SqlSessionFactory sqlSessionFactory166(
			@Qualifier("dataSource166")DataSource defectDataSource166) throws Exception{
		//此处mybatis-plus得配置为MybatisSqlSessionFactoryBean，不能配置成SqlSessionFactoryBean，否则会报无法绑定的错误信息
		MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
		factoryBean.setDataSource(defectDataSource166);
		factoryBean.setTypeAliasesPackage(typeAliasesPackage166);
		factoryBean.setMapperLocations(
				new PathMatchingResourcePatternResolver()
						.getResources(resourcesXml166));
		factoryBean.getObject().getConfiguration().setJdbcTypeForNull(JdbcType.NULL);

		return factoryBean.getObject();
	}


	@Bean("transactionManager166")
	@RefreshScope
	public DataSourceTransactionManager transactionManager(
			@Qualifier("dataSource166")DataSource defectDataSource166){
		return new DataSourceTransactionManager(defectDataSource166);
	}

	@Bean("sessionTemplate166")
	@RefreshScope
	public SqlSessionTemplate sqlSessionTemplate(
			@Qualifier("sessionFactory166")SqlSessionFactory sqlSessionFactory166) throws Exception{
		SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory166);
		return template;
	}


}
