package com.example.demo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

import com.example.mapper.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    DataSource dataSource;

    @Resource
    UserMapper mapper;
//mapper.findByUsername("11") 调用 findByUsername 方法来查找用户名为 "11" 的数据。这将返回一个 Optional 对象，它可以包含查找到的结果或者为空。
//.ifPresent(System.out::println) 是 Optional 对象的一个方法。它接受一个Consumer函数，用于处理 Optional 对象中的值（如果存在）。在这里，System.out::println 是一个方法引用，用于打印 Optional 对象中的值。
//如果 mapper.findByUsername("11") 返回一个包含数据的Optional，那么它将被传递给System.out::println，并打印出来。如果 Optional 为空，那么不会执行任何操作。
    @Test
    void contextLoads() {
        //System.out.println(mapper.findById(1));
        mapper.findByUsername("11").ifPresent(System.out::println);
        mapper.findByUsernameLike("%1%").forEach(System.out::println);
//       Count count=new Count();
//       count.setPassword("111");
//       count.setUsername("222");
//
//       Count counts=Count.builder().username("23r3").password("bdbdzb").build();
//
//        Count count1= mapper.save(counts);
//        System.out.println(count1);

        //mapper.deleteById(1);

        //mapper.findAll(PageRequest.of(0,2)).forEach(System.out::println);
    }


    @Test
    void AutoCode() {
        FastAutoGenerator
                .create(new DataSourceConfig.Builder(dataSource))
                .globalConfig(builder -> {
                    builder.author("lbw");              //作者信息，一会会变成注释
                    builder.commentDate("2024-01-01");  //日期信息，一会会变成注释
                    builder.outputDir("src/main/java"); //输出目录设置为当前项目的目录
                })
                //打包设置，这里设置一下包名就行，注意跟我们项目包名设置为一致的
                .packageConfig(builder -> builder.parent("com.example"))
                .strategyConfig(builder -> {
                    //设置为所有Mapper添加@Mapper注解
                    builder
                            .mapperBuilder()
                            .mapperAnnotation(Mapper.class)
                            .build();
                })
                .execute();
    }

}
