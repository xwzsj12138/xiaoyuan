package com.wm.project.project.controller;


import com.wm.project.project.entity.News;
import com.wm.project.project.reptile.ReptileByNewss;
import com.wm.project.project.service.NewsService;

import com.wm.project.project.util.CommonUtil;
import com.wm.project.project.util.HttpUtils;
import com.wm.project.project.util.Result;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * (News)表控制层
 *
 * @author zyf
 * @since 2022-03-09 13:50:26
 */
@RestController
@RequestMapping("news")
@EnableCaching
public class NewsController {
    /**
     * 服务对象
     */
    @Resource
    private NewsService newsService;

    @GetMapping
    public Result<Object> selectAll(){
        List<News> news = newsService.selectAll();
        if(news.size()>0){
            return  CommonUtil.successResult(news);
        }else {
            return CommonUtil.errorResult();
        }
    }

//    @Scheduled(fixedDelay = 3 * 1000)
    public void insert(){
//        News news = new News();
////        news.setUuid(UUID.randomUUID().toString());
////        newsService.insert(news);
//        String s = new HttpUtils().doGetHtml("https://weibo.com/newlogin?tabtype=weibo&gid=102803&url=https%3A%2F%2Fweibo.com%2F");
//        System.out.println(s);

        String s = new ReptileByNewss().ReptileByNewss();
        System.out.println(s+"ddddd");
    }

}

