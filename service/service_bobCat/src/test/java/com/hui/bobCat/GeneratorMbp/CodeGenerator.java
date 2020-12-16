package com.hui.bobCat.GeneratorMbp;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * @author lihui
 * @title: CodeGenerator 代码生成器
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/114:12
 */
public class CodeGenerator {

    @Test
    public void run(){

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //此处最好用绝对路径
        gc.setOutputDir("C:\\D\\soft\\workspace\\self_discipline_freedom\\service\\service_bobCat" + "/src/main/java");

        gc.setAuthor("lihui");
        //gc.set

        gc.setOpen(false); //生成后是否打开资源管理器
        gc.setFileOverride(false); //重新生成时文件是否覆盖
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList

        //UserServie
        gc.setMapperName("%sDAO");
        gc.setXmlName("%sDAOMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");


        //gc.setIdType(IdType.ID_WORKER_STR); //主键策略
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
        gc.setSwagger2(true);//开启Swagger2模式

        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.ORACLE);
        dsc.setTypeConvert(new ITypeConvert() {

            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                String t = fieldType.toLowerCase();
                if(t.contains("datetime")){
                    return DbColumnType.DATE;
                }
                //其它字段采用默认转换（非mysql数据库可以使用其它默认的数据库转换器）
                return new OracleTypeConvert().processTypeConvert(globalConfig,fieldType);
            }

        });
        dsc.setUrl("jdbc:oracle:thin:@10.162.244.77:1521:JFTRACE");
        dsc.setDriverName("oracle.jdbc.OracleDriver");
        dsc.setUsername("sajet");
        dsc.setPassword("tech");
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.hui.bobCat");
        pc.setEntity("been");
        pc.setMapper("dao.db166");
        pc.setXml("mapper.db166");
        pc.setService("service.db166");
        pc.setServiceImpl("service.db166.impl");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();

        /**
         *  此处是表名，区分大小写（注意）oracle一般是大写
         */
        strategy.setInclude(new String[]{"BOBCAT_STATION_MAPPING"});

        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        //strategy.setTablePrefix(pc.getModuleName() + "_"); //生成实体时去掉表前缀

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作

        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

        mpg.setStrategy(strategy);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        mpg.setCfg(cfg);


        // 6、执行
        mpg.execute();
        // 打印注入设置
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }

}
