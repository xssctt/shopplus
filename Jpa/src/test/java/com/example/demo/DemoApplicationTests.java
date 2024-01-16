package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

import com.example.common.JsonResult;
import com.example.dto.Task;
import com.example.entity.Member;
import com.example.entity.Product;
import com.example.entity.Role;
import com.example.mapper.RoleMapper;
import com.example.mapper.TaskMapper;
import com.example.mapper.UserMapper;
import com.example.service.*;
import com.example.until.StringPwd;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.*;

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
    @Resource
    RoleMapper roleMapper;
    @Resource
    TaskMapper taskMapper;
    @Test
    void con(){
//        List list = roleMapper.selectAllById(1);
//        System.out.println(list);
//        List list1 = taskMapper.selectBatchIds(list);
//        System.out.println(taskMapper.selectBatchIds(list));


//        List<Integer> taskidlist = roleMapper.selectAllById(1);
//
//        Set<String> stringSet=new HashSet<>();
//        for (Integer id:taskidlist) {
//            stringSet.add(taskMapper.selectNameByid(id));
//        }
//        System.out.println(stringSet);


        Role role=Role.builder()
                .id(3).sort(100).name("xss").spec("xss").status(1).build();

        roleService.update(new LambdaUpdateWrapper<Role>()
                .set(Role::getName,role.getName())
                .set(Role::getSpec,role.getSpec())
                .set(Role::getSort,role.getSort())
                .eq(Role::getId,role.getId()));




    }



    @Test
    void contextLoada() {
        List<String> list=new ArrayList<>();
        list.add("plate.manage");
        list.add("cardCategory.manage");
        list.add("craft.manage");
        list.add("plan.manage");

        if(roleService.updateRoleTask(1,list)){
            System.out.println("ok");
        }else {
            System.out.println("no");
        }

    }
    @Resource
    IProductService productService;

    @Resource
    IMemberService memberService;

    @Test
    void contextLoadb() {
        productService.update(new LambdaUpdateWrapper<Product>().set(Product::getStatus,2).eq(Product::getId,1));
      //  memberService.save("xss","xss");
//
//        if(productService.save(Product.builder()
//                .allowDiscount(1).categoryId(1)
//                .categoryName("分类name").name("商品name").cover("封面图片")
//                .description("描述").price("11").sort(10).status(1)
//                .build())){
//            System.out.println("ok");
//        }else {
//            System.out.println("no");
//        }
    }

}
