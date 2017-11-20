package xyz.lihang.blog.mapper.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.lihang.blog.mapper.entity.Article;
import xyz.lihang.blog.mapper.example.ArticleExample;
import xyz.lihang.blog.mapper.model.ArticleMonths;

public interface ArticleMapper extends BaseMapper<Article>{

    long countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExampleWithBLOBs(ArticleExample example);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
    
    int articleTop(Integer id);
    
    /**
     *    获取文章条目信息           
     *    用于前台 
     *    
     * @param example
     * @return
     */
    List<Article> selectItem(ArticleExample example);
    
    
    /**
     * 只获取标题，ID 浏览次数
     * @param example
     * @return
     */
    List<Article> selectTitle(ArticleExample example);
    
    
    /**
	 * 下一个文章
	 * @param id
	 * @return
	 */
	Article getNextArticle(Integer id);
	
	
	/**
	 * 上一个文章
	 * @param id
	 * @return
	 */
	Article getPreArticle(Integer id);
	
	
	List<ArticleMonths> groupByMonth();

    /**
     * 访问次数增加
     * @param id
     * @return
     */
    int addArticleCount(Integer id);
}