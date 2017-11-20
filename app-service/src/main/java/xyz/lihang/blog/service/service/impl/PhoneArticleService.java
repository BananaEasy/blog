package xyz.lihang.blog.service.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import xyz.lihang.blog.common.tool.utils.RandomUtils;
import xyz.lihang.blog.mapper.dto.ArticleDto;
import xyz.lihang.blog.mapper.dto.LabelDto;
import xyz.lihang.blog.mapper.entity.Article;
import xyz.lihang.blog.mapper.entity.Label;
import xyz.lihang.blog.mapper.example.ArticleExample;
import xyz.lihang.blog.service.config.ServiceConfig;
import xyz.lihang.blog.service.service.IPhoneArticleService;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneArticleService extends ArticleService implements IPhoneArticleService {

    @Override
    public List<ArticleDto> articleList(Integer page, Integer labelId) {
        ArticleExample articleExample = defaultSelectExample();
        ArticleExample.Criteria criteria = articleExample.getOredCriteria().get(0);
        if(labelId != null){
            criteria.andLabelIdEqualTo(labelId);
        }
        PageHelper.startPage(page, ServiceConfig.ARTICLE_ITEM_LENGTH);
        List<Article> list = loadData(articleMapper.selectItem(articleExample));
        List<ArticleDto> dtoList =beanCopy(list);
        //转换

        return dtoList;
    }

    @Override
    public List<ArticleDto> headArticleList() {
        List<Article> list = articleMapper.selectItem(defaultSelectExample());
        //随机3篇文章
        int size = list.size() > 3 ? 3 : list.size();
        List<ArticleDto> dtoList = new ArrayList<>();
        int[] ints = RandomUtils.randomCommon(0, list.size(), size);
        for(int i : ints){
            Article article = list.get(i);
            loadCategory(article);
            loadLabel(article);
            ArticleDto articleDto = new ArticleDto();
            BeanUtils.copyProperties(article,articleDto);
            articleDto.setCategoryName(article.getCategory().getName());
            dtoList.add(articleDto);
        }
        return dtoList;
    }

    @Override
    public List<LabelDto> labelDtoList() {
        List<Label> labels = labelMapper.selectByExample();
        List<LabelDto> labelDtos = new ArrayList<>();
        for(Label label : labels){
            LabelDto labelDto = new LabelDto();
            BeanUtils.copyProperties(label,labelDto);
            labelDtos.add(labelDto);
        }
        return labelDtos;
    }


    public static List<ArticleDto> beanCopy (List<Article> list){
        List<ArticleDto> dtoList = new ArrayList<>();
        for(Article article : list){
            ArticleDto articleDto = new ArticleDto();
            BeanUtils.copyProperties(article,articleDto);
            articleDto.setCategoryName(article.getCategory().getName());
            dtoList.add(articleDto);
        }
        return dtoList;
    }

}
