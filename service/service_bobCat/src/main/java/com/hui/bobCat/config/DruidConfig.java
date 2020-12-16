package com.hui.bobCat.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.validation.annotation.Validated;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author lihui
 * @title: DruidConfiguration
 * @projectName springcloud-freedom
 * @description: TODO Druid连接池配置文件
 * @date 2020/8/716:56
 */

@Validated
@Configuration
@RefreshScope
@Data
public class DruidConfig{


    private Logger logger = LoggerFactory.getLogger(getClass());

    private boolean druidLoginEnabled;

    @Value("${spring.datasource.druidLoginUsername}")
    private String druidLoginUsername;

    @Value("${spring.datasource.druidLoginPassword}")
    private String druidLoginPassword;

    @Value("${spring.datasource.url213}")
    private String url213;

    @Value("${spring.datasource.username213}")
    private String username213;

    @Value("${spring.datasource.password213}")
    private String password213;

    @Value("${spring.datasource.driverClassName213}")
    private String driverClassName213;

    @Value("${spring.datasource.validationQuery213}")
    private String validationQuery213;

    @Value("${spring.datasource.url166}")
    private String url166;

    @Value("${spring.datasource.username166}")
    private String username166;

    @Value("${spring.datasource.password166}")
    private String password166;

    @Value("${spring.datasource.driverClassName166}")
    private String driverClassName166;

    @Value("${spring.datasource.validationQuery166}")
    private String validationQuery166;

    @Value("${spring.datasource.url111}")
    private String url111;

    @Value("${spring.datasource.username111}")
    private String username111;

    @Value("${spring.datasource.password111}")
    private String password111;

    @Value("${spring.datasource.driverClassName111}")
    private String driverClassName111;

    @Value("${spring.datasource.validationQuery111}")
    private String validationQuery111;

    @Value("${spring.datasource.url77}")
    private String url77;

    @Value("${spring.datasource.username77}")
    private String username77;

    @Value("${spring.datasource.password77}")
    private String password77;

    @Value("${spring.datasource.driverClassName77}")
    private String driverClassName77;

    @Value("${spring.datasource.validationQuery77}")
    private String validationQuery77;

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.keepAlive}")
    private boolean keepAlive;

    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.removeAbandoned}")
    private boolean removeAbandoned;

    @Value("${spring.datasource.removeAbandonedTimeout}")
    private int removeAbandonedTimeout;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;

    @Value("${spring.datasource.maxEvictableIdleTimeMillis}")
    private long maxEvictableIdleTimeMillis;

    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.phyMaxUseCount}")
    private int phyMaxUseCount;

    @Value("${spring.datasource.connectionProperties}")
    private String connectionProperties;

    @Value("${spring.datasource.filters}")
    private String filters;

    @Bean
    @RefreshScope
    public ServletRegistrationBean<StatViewServlet> druidServlet() {
        ServletRegistrationBean<StatViewServlet> reg = new ServletRegistrationBean<StatViewServlet>();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        // web访问是否需要登录
        if (druidLoginEnabled) {
            reg.addInitParameter("loginUsername", druidLoginUsername);
            reg.addInitParameter("loginPassword", druidLoginPassword);
            reg.addInitParameter("principalSessionName", "session.SPRING_SECURITY_CONTEXT.authentication.principal.trueName");
        }
        return reg;
    }

    @Bean
    @RefreshScope
    public FilterRegistrationBean<WebStatFilter> filterRegistrationBean() {
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        filterRegistrationBean.addInitParameter("principalCookieName", "USER_COOKIE");
        filterRegistrationBean.addInitParameter("principalSessionName", "USER_SESSION");
        return filterRegistrationBean;
    }

    @Primary
    @RefreshScope
    @Bean(name = "dataSource213")
    public DataSource druidDataSource213() {
        System.out.println(this.druidLoginUsername);
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.url213);
        datasource.setUsername(this.username213);
        datasource.setPassword(this.password213);
        datasource.setDriverClassName(this.driverClassName213);
        datasource.setInitialSize(this.initialSize);
        datasource.setMaxActive(this.maxActive);
        datasource.setMinIdle(this.minIdle);
        datasource.setMaxWait(this.maxWait);
        datasource.setPoolPreparedStatements(this.poolPreparedStatements);
        datasource.setValidationQuery(this.validationQuery213);
        datasource.setTestOnBorrow(this.testOnBorrow);
        datasource.setTestOnReturn(this.testOnReturn);
        datasource.setTestWhileIdle(this.testWhileIdle);
        datasource.setKeepAlive(this.keepAlive);
        datasource.setRemoveAbandonedTimeout(this.removeAbandonedTimeout);
        datasource.setTimeBetweenEvictionRunsMillis(this.timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(this.minEvictableIdleTimeMillis);
        datasource.setMaxEvictableIdleTimeMillis(this.maxEvictableIdleTimeMillis);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(this.maxPoolPreparedStatementPerConnectionSize);
        datasource.setPhyMaxUseCount(this.phyMaxUseCount);
        datasource.setConnectionProperties(this.connectionProperties);
        try {
            datasource.setFilters(this.filters);
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        logger.info("druidDataSource213配置成功");
        return datasource;
    }

    @Bean(name = "dataSource166")
    @RefreshScope
    public DataSource druidDataSource166() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.url166);
        datasource.setUsername(this.username166);
        datasource.setPassword(this.password166);
        datasource.setDriverClassName(this.driverClassName166);
        datasource.setInitialSize(this.initialSize);
        datasource.setMaxActive(this.maxActive);
        datasource.setMinIdle(this.minIdle);
        datasource.setMaxWait(this.maxWait);
        datasource.setPoolPreparedStatements(this.poolPreparedStatements);
        datasource.setValidationQuery(this.validationQuery166);
        datasource.setTestOnBorrow(this.testOnBorrow);
        datasource.setTestOnReturn(this.testOnReturn);
        datasource.setTestWhileIdle(this.testWhileIdle);
        datasource.setKeepAlive(this.keepAlive);
        datasource.setRemoveAbandonedTimeout(this.removeAbandonedTimeout);
        datasource.setTimeBetweenEvictionRunsMillis(this.timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(this.minEvictableIdleTimeMillis);
        datasource.setMaxEvictableIdleTimeMillis(this.maxEvictableIdleTimeMillis);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(this.maxPoolPreparedStatementPerConnectionSize);
        datasource.setPhyMaxUseCount(this.phyMaxUseCount);
        datasource.setConnectionProperties(this.connectionProperties);
        try {
            datasource.setFilters(this.filters);
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        logger.info("druidDataSource166配置成功");
        return datasource;
    }

    @Bean(name = "dataSource111")
    @RefreshScope
    public DataSource druidDataSource111() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.url111);
        datasource.setUsername(this.username111);
        datasource.setPassword(this.password111);
        datasource.setDriverClassName(this.driverClassName111);
        datasource.setInitialSize(this.initialSize);
        datasource.setMaxActive(this.maxActive);
        datasource.setMinIdle(this.minIdle);
        datasource.setMaxWait(this.maxWait);
        datasource.setPoolPreparedStatements(this.poolPreparedStatements);
        datasource.setValidationQuery(this.validationQuery111);
        datasource.setTestOnBorrow(this.testOnBorrow);
        datasource.setTestOnReturn(this.testOnReturn);
        datasource.setTestWhileIdle(this.testWhileIdle);
        datasource.setKeepAlive(this.keepAlive);
        datasource.setRemoveAbandonedTimeout(this.removeAbandonedTimeout);
        datasource.setTimeBetweenEvictionRunsMillis(this.timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(this.minEvictableIdleTimeMillis);
        datasource.setMaxEvictableIdleTimeMillis(this.maxEvictableIdleTimeMillis);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(this.maxPoolPreparedStatementPerConnectionSize);
        datasource.setPhyMaxUseCount(this.phyMaxUseCount);
        datasource.setConnectionProperties(this.connectionProperties);
        try {
            datasource.setFilters(this.filters);
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        logger.info("druidDataSource111配置成功");
        return datasource;
    }

    @Bean(name = "dataSource77")
    @RefreshScope
    public DataSource druidDataSource77() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.url77);
        datasource.setUsername(this.username77);
        datasource.setPassword(this.password77);
        datasource.setDriverClassName(this.driverClassName77);
        datasource.setInitialSize(this.initialSize);
        datasource.setMaxActive(this.maxActive);
        datasource.setMinIdle(this.minIdle);
        datasource.setMaxWait(this.maxWait);
        datasource.setPoolPreparedStatements(this.poolPreparedStatements);
        datasource.setValidationQuery(this.validationQuery111);
        datasource.setTestOnBorrow(this.testOnBorrow);
        datasource.setTestOnReturn(this.testOnReturn);
        datasource.setTestWhileIdle(this.testWhileIdle);
        datasource.setKeepAlive(this.keepAlive);
        datasource.setRemoveAbandonedTimeout(this.removeAbandonedTimeout);
        datasource.setTimeBetweenEvictionRunsMillis(this.timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(this.minEvictableIdleTimeMillis);
        datasource.setMaxEvictableIdleTimeMillis(this.maxEvictableIdleTimeMillis);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(this.maxPoolPreparedStatementPerConnectionSize);
        datasource.setPhyMaxUseCount(this.phyMaxUseCount);
        datasource.setConnectionProperties(this.connectionProperties);
        try {
            datasource.setFilters(this.filters);
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        logger.info("druidDataSource77配置成功");
        return datasource;
    }
}