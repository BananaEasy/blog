package xyz.lihang.blog.web.controller;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.lihang.blog.mapper.dto.ArticleDto;
import xyz.lihang.blog.mapper.dto.LabelDto;
import xyz.lihang.blog.mapper.entity.Article;
import xyz.lihang.blog.quartz.quartz.ArticleLuceneQuartz;
import xyz.lihang.blog.service.config.ServiceConfig;
import xyz.lihang.blog.service.service.IPhoneArticleService;
import xyz.lihang.blog.service.service.impl.PhoneArticleService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping(value="/phone" )
@Controller
public class PhoneController extends BaseController{

    @Resource
    private IPhoneArticleService phoneArticleService;

    @Resource
    private ArticleLuceneQuartz articleLuceneQuartz;

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<ArticleDto> articleList(Integer p,Integer labelId){
        List<ArticleDto> articleDtos = phoneArticleService.articleList(p == null ? 1 : p, labelId);
        return articleDtos;
    }

    @RequestMapping(value = "/headArticle")
    @ResponseBody
    public List<ArticleDto> headArticle(){
        List<ArticleDto> articleDtos = phoneArticleService.headArticleList();
        return articleDtos;
    }


    @RequestMapping(value = "/label")
    @ResponseBody
    public List<LabelDto> labelList(){
        List<LabelDto> labelDtos = phoneArticleService.labelDtoList();
        return labelDtos;
    }

    @RequestMapping(value="/search")
    @ResponseBody
    public List<ArticleDto> search(String searchStr,Integer p) {
        p = Math.max(p == null ? 1 : p,1);
        List<ArticleDto> dtoList = new ArrayList<>(0);
        try{
            if(StringUtils.isNotBlank(searchStr)){
                Map<String, Object> map = articleLuceneQuartz.searchArticleTitleAfter(searchStr, p , ServiceConfig.ARTICLE_ITEM_LENGTH);
                List<Article> list = (List<Article>)map.get("list");
                //转换
                dtoList = PhoneArticleService.beanCopy(list);
            }
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return dtoList;
    }






}
