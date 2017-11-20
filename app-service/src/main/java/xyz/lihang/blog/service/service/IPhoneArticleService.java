package xyz.lihang.blog.service.service;

import org.springframework.cache.annotation.Cacheable;
import xyz.lihang.blog.mapper.dto.ArticleDto;
import xyz.lihang.blog.mapper.dto.LabelDto;
import xyz.lihang.blog.mapper.entity.Article;

import java.util.List;

public interface IPhoneArticleService extends  IArticleService {


    @Cacheable(cacheNames =ArticleListCacheName , keyGenerator="cacheKeyGenerator")
    List<ArticleDto> articleList(Integer page, Integer labelId);

    @Cacheable(cacheNames =ArticleListCacheName , keyGenerator="cacheKeyGenerator")
    List<ArticleDto> headArticleList();

    @Cacheable(cacheNames =ArticleListCacheName , keyGenerator="cacheKeyGenerator")
    List<LabelDto> labelDtoList();


}
