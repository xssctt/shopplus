package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

import com.example.common.JsonResult;
import com.example.dto.Task;
import com.example.entity.Member;
import com.example.entity.Role;
import com.example.mapper.UserMapper;
import com.example.service.IMemberService;
import com.example.service.IRoleService;
import com.example.service.ITaskService;
import com.example.until.StringPwd;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//        //System.out.println(mapper.findById(1));
//        mapper.findByUsername("11").ifPresent(System.out::println);
//        mapper.findByUsernameLike("%1%").forEach(System.out::println);
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

    @Resource
    ITaskService taskService;

    @Test
    void contextLoadpwd() {
       // String salt=StringPwd.generateSalt().toString();
        //System.out.println(salt);
        //A0snxyUMljjTgmNNv3+OTA==
        //System.out.println(  StringPwd.hashPassword("123user", "A0snxyUMljjTgmNNv3+OTA==") );
        //sTSyvYPrnP8KCDQWAx0u5y5nza7Fp7QX03iPqvAxtEk=
        Map<String,String> taskmap=new HashMap<>();

        List<Task> list = taskService.list(new LambdaQueryWrapper<>());
        for (Task t:list) {
            taskmap.put(t.getTaskname(),t.getSpec());
        }
        System.out.println(taskmap);
    }

    @Resource
    IRoleService roleService;
    @Test
    void con(){
        LambdaUpdateWrapper<Role> roleLambdaUpdateWrapper=new LambdaUpdateWrapper<>();
        roleLambdaUpdateWrapper.set(Role::getStatus,2).eq(Role::getId,1);

        if(roleService.update(roleLambdaUpdateWrapper)){

            System.out.println("111111111111");
        }else {
            System.out.println("22222222222222222");
        }
    }

}
