package com.beini.service.impl;

import com.beini.bean.Article;
import com.beini.mapper.ArticleMapper;
import com.beini.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by beini on 2017/2/23.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper aticleMapper;


    @Override
    public List<Article> getArticles() {
        return aticleMapper.getSelectArticle();
    }
}
