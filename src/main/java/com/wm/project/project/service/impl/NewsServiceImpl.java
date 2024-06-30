package com.wm.project.project.service.impl;

import com.wm.project.project.entity.News;
import com.wm.project.project.dao.NewsDao;
import com.wm.project.project.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (News)表服务实现类
 *
 * @author zyf
 * @since 2022-03-09 13:50:29
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsDao newsDao;

    @Override
    public News selectById(String uuid) {
        return newsDao.selectById(uuid);
    }

    @Override
    public News insert(News news) {
        newsDao.insert(news);
        return news;
    }

    @Override
    public News update(News news) {
        this.newsDao.update(news);
        return selectById(news.getUuid());
    }

    @Override
    public boolean deleteById(String uuid) {
        return newsDao.deleteById(uuid) > 0;
    }

    @Override
    public List<News> selectAll() {
        return newsDao.selectAll();
    }
}
