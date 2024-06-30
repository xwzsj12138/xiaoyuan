package com.wm.project.project;

import com.wm.project.project.util.HttpUtils;
import io.jsonwebtoken.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;


@SpringBootTest
class ProjectApplicationTests {

    private  long time=1000*60*60*24;
    private String signature="admin";

    @Test
//    @Scheduled(fixedRate = 3 * 1000)
    void contextLoads() {
//        System.out.println("123");
//        HttpUtils httpUtils = new HttpUtils();
//        String s = httpUtils.doGetHtml("https://news.qq.com/");
//        System.out.println(s);
    }

    public String JwtDemo(){
        JwtBuilder jwtBuilder=Jwts.builder();
        String jwttoken=jwtBuilder
                //header
                .setHeaderParam("type","JWT")
                .setHeaderParam("alg","HS256")
                //payload 载荷的配置
                .claim("username","zc")
                .claim("role","admin")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .setId(UUID.randomUUID().toString())
                //signature
                .signWith(SignatureAlgorithm.HS256,signature)
                //拼接起来
                .compact();
        System.out.println(jwttoken);
        return jwttoken;
    }

    @Test
    public void parse(){
//        String token="eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VybmFtZSI6InpjIiwicm9sZSI6ImFkbWluIiwic3ViIjoiYWRtaW4tdGVzdCIsImV4cCI6MTY0ODA5MjI2MiwianRpIjoiMDMxNDUwY2UtNTY0ZC00MGRjLWIzZjMtYmE2YzBhNTdkYmU5In0.OkpV9HnOJ8TvnJ7co7tESvyOiwjjMJHGzoqclmOtQVQ\n";
        String token = new ProjectApplicationTests().JwtDemo();
        JwtParser parser = Jwts.parser();
        Jws<Claims> claimsJws = parser.setSigningKey(signature).parseClaimsJws(token);
//        claimsJws.getHeader();
        Claims body = claimsJws.getBody();
        System.out.println(body.get("username"));
        System.out.println(body.get("role"));
        System.out.println(body.getId());

//        System.out.println(claimsJws.getHeader());

    }
    @Test
    public void data(){
        System.out.println(new Date());
    }


}
