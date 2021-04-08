package com.hui.tgs.config;

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

    @Value("${spring.datasource.url17}")
    private String url17;

    @Value("${spring.datasource.username17}")
    private String username17;

    @Value("${spring.datasource.password17}")
    private String password17;

    @Value("${spring.datasource.driverClassName17}")
    private String driverClassName17;

    @Value("${spring.datasource.validationQuery17}")
    private String validationQuery17;

    @Value("${spring.datasource.url216}")
    private String url216;

    @Value("${spring.datasource.username216}")
    private String username216;

    @Value("${spring.datasource.password216}")
    private String password216;

    @Value("${spring.datasource.driverClassName216}")
    private String driverClassName216;

    @Value("${spring.datasource.validationQuery216}")
    private String validationQuery216;

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
    @Bean(name = "dataSource17")
    public DataSource druidDataSource17() {
        System.out.println(this.druidLoginUsername);
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.url17);
        datasource.setUsername(this.username17);
        datasource.setPassword(this.password17);
        datasource.setDriverClassName(this.driverClassName17);
        datasource.setInitialSize(this.initialSize);
        datasource.setMaxActive(this.maxActive);
        datasource.setMinIdle(this.minIdle);
        datasource.setMaxWait(this.maxWait);
        datasource.setPoolPreparedStatements(this.poolPreparedStatements);
        datasource.setValidationQuery(this.validationQuery17);
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
        logger.info("druidDataSource17配置成功");
        return datasource;
    }

    @Primary
    @RefreshScope
    @Bean(name = "dataSource216")
    public DataSource druidDataSource216() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.url216);
        datasource.setUsername(this.username216);
        datasource.setPassword(this.password216);
        datasource.setDriverClassName(this.driverClassName216);
        datasource.setInitialSize(this.initialSize);
        datasource.setMaxActive(this.maxActive);
        datasource.setMinIdle(this.minIdle);
        datasource.setMaxWait(this.maxWait);
        datasource.setPoolPreparedStatements(this.poolPreparedStatements);
        datasource.setValidationQuery(this.validationQuery216);
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
        logger.info("druidDataSource216配置成功");
        return datasource;
    }

}