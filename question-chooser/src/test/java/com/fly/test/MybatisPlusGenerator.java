package com.fly.test;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.List;
public class MybatisPlusGenerator {

    /**
     * <a href="https://blog.csdn.net/ChinaYangJu/article/details/126209506">SpringBoot集成MyBatis-Plus + MyBatis-Plus（3.5.3版本）代码生成器</a>
     */
    public static void main(String[] args) {
        /*
            特别注意：生成的时间类型均为：“LocalDateTime”格式，需要加入以下注解方可正常使用
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @JsonDeserialize(using = LocalDateTimeDeserializer.class)
            @JsonSerialize(using = LocalDateTimeSerializer.class)
        */

        // 数据库连接
        String url = "jdbc:mysql://192.168.11.240:32306/question_chooser?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8";//数据库url
        String username = "root";   // 账号
        String password = "root";   // 密码
        String module = "mp";       // 模块名

        // 全局配置参数
        String author = ""; //作者
        String outputDir = System.getProperty("user.dir")+"/"+module+"/src/main/java";      // 文件输出目录

        //包配置参数
        String parent = "com";//父包名
        String moduleName = "fly.test";//父包模块名
        String entity = "entity";//Entity 实体类包名
        String mapper = "mapper";//Mapper 包名
        String mapperXml = "mapper";//Mapper XML 包名
        String service = "service";//Service 包名
        String serviceImpl = "service.impl";//Service Impl 包名
        /*String controller = "controller";//Controller 包名*/

        //要生成的数据库表
        List<String> tables = new ArrayList<>();
        tables.add("subject");

        //开始生成
        FastAutoGenerator.create(url,username,password)
                //全局配置
                .globalConfig(builder -> {
                    builder.author(author)
                            .outputDir(outputDir)
                            /*.enableSwagger()//开启swagger*/
                            .commentDate("yyyy-MM-dd");//注释日期
                })
                //包配置
                .packageConfig(builder -> {
                    builder.parent(parent)
                            .moduleName(moduleName)
                            .entity(entity)
                            .mapper(mapper)
                            .xml(mapperXml)
                            .service(service)
                            .serviceImpl(serviceImpl)
                    /*.controller(controller)*/;
                })
                //策略配置
                .strategyConfig(builder -> {
                    builder.addInclude(tables)
                            //开启生成实体类
                            .entityBuilder()
                            .enableLombok()//开启 lombok 模型
                            .enableTableFieldAnnotation()//开启生成实体时生成字段注解
                            //开启生成mapper
                            .mapperBuilder()
                            .enableBaseResultMap()//启用 BaseResultMap 生成
                            .superClass(BaseMapper.class)//设置父类
                            .enableMapperAnnotation()//开启 @Mapper 注解
                            .formatMapperFileName("%sMapper")//格式化 mapper 文件名称
                            .formatXmlFileName("%sMapper")//格式化 xml 实现类文件名称
                            //开启生成service及impl
                            .serviceBuilder()
                            .formatServiceFileName("%sService")//格式化 service 接口文件名称
                            .formatServiceImplFileName("%sServiceImpl");//格式化 service 实现类文件名称
                            /*//开启生成controller
                            .controllerBuilder()
                            // 映射路径使用连字符格式，而不是驼峰
                            .enableHyphenStyle()
                            .formatFileName("%sController")//格式化文件名称
                            .enableRestStyle();*/
                })
                .templateEngine(new VelocityTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateConfig(builder -> builder.controller(""))//关闭生成controller
                .execute();
    }

}
