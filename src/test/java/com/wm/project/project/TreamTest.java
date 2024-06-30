package com.wm.project.project;

import lombok.Data;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
class User{
    String name;
    Integer age;
}

@SpringBootTest
public class TreamTest {
    public static void main(String[] args) {
       new TreamTest().Test1();
    }

    //练习Stream
    public void Test1(){
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(0+i);
            user.setName(i+1+"号人机");
           list.add(user);
        }
        //提取list中i>5
        Object[] objects = list.stream().filter(e -> e.getAge() > 5)
                .map(user -> user.getAge().toString())
                .collect(Collectors.toList()).toArray();

        System.out.println(Arrays.stream(objects));

        System.out.println(list);
        System.out.println("=======");
        List<User> collect = list.stream().filter(user -> user.getAge() > 5)
                .collect(Collectors.toList());
        System.out.println(collect);

     //常用方法：skip操作用于跳过Stream流中的前n个元素。
//        List<String> list2 = Arrays.asList("a", "b", "c", "d", "e");
//        list2.stream().skip(2).forEach(System.out::println);
        //map操作
        //map操作用于转换Stream流中的元素。它接受一个Function接口类型的参数，通过这个函数，我们可以将元素转换成其他类型。
//       list.stream().map(user -> user.getAge()::toUnsignedString)

//        list.stream().map(n->n.setName(n.getAge().toString())).collect(Collectors)
        List<Integer> integers = Arrays.asList(1, 2, 3, 1);
        //list 去重springboot写法
        ArrayList<Integer> integers1 = new ArrayList<>(new LinkedHashSet<>(integers));
        System.out.println(integers1);
        //


    }
}
