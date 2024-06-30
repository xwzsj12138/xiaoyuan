package com.wm.project.project.reptile;

import com.wm.project.project.entity.News;
import com.wm.project.project.util.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.UUID;

/**
 * @author zyf
 * @since 2022/3/9 17:22
 */
//用于爬取腾讯热点新闻并将数据做出处理
public class ReptileByNewss {
    public String ReptileByNewss(){
        String html = new HttpUtils().doGetHtml("http://live.nbd.com.cn/");
        News news = new News();
        news.setUuid(UUID.randomUUID().toString());
        //获取对象
        Document doc = Jsoup.parse(html);
        Element first = doc.getElementsByClass("li-title").first();
//        first.text()
        return  "s";

    }
}
