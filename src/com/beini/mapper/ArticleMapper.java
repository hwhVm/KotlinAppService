package com.beini.mapper;

import com.beini.bean.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * Created by beini on 2017/2/22.
 */

public interface ArticleMapper {

    @Select("select * from Article")
    List<Article> getSelectArticle();

}
