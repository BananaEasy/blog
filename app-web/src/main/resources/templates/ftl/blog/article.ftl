<#--
文章显示页面
-->
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <#include "common/seo.ftl">
    <title>${article.index.articletitle!""}</title>
</head>
<#include "common/basejs.ftl">
<body>
<#include "common/banner.ftl"/>
<div class="container blog-content">
<#include "common/head.ftl"/>
    <ol class="breadcrumb blog-breadcrumb">
        <li><a href="/">主页</a></li>
        <li><a href="/category/${article.index.category.id!""}">${article.index.category.name !}</a></li>
        <li>文章</li>
    </ol>

    <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-8 col-lg-8 ">
            <div class="blog-article-article">
                <div class="blog-article-article-head">
                    <h1>${article.index.articletitle!""}</h1>
                    <div class="blog-article-article-head-meta">
                        <table>
                            <tr>
                                <td class="hidden-xs">作者:${article.index.articleusername !"未知"}</td>
                                <td>时间:${article.index.createtime ?string("yyyy-MM-dd")}</td>
                                <td>点击:${article.index.count!"0"}</td>
                            </tr>
                        </table>
                    </div>
                </div>

                <div class="row">
                    <div class="blog-article-article-content">
                    <blockquote>
                        <p class="text-warning default-p">${article.index.articleprompt!""}</p>
                    </blockquote>
                        ${article.index.articlecontent !""}
                    </div>
                    <div class="blog-article-article-head-meta">
                        <table>
                            <tr>
                                <td>标签:<a
                                        href="/label/${article.index.label.id!""}">${article.index.label.name!"未知"}</a>
                                </td>
                                <td>分类:<a
                                        href="/category/${article.index.category.id!""}">${article.index.category.name!"未知"}</a>
                                </td>
                                <td class="hidden-xs">文章来源:<a
                                        href="${article.index.articlehref!"javascript:;"}">${article.index.articlehreftitle!""}</a>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <!--评论-->
                    <div class="blog-article-comment">
                        <div id="SOHUCS" sid="${article.index.id!}"></div>
                    </div>
                </div>
            </div>
            <div class="blog-article-page">
                <p>
                    上一篇:
                    <#if article.pre?? >
                        <a href="/article/${article.pre.id!}">${article.pre.articletitle!}</a>
                    <#else>
                        <span>无</span>
                    </#if>
                </p>
                <p>
                    下一篇:
                    <#if article.next?? >
                        <a href="/article/${article.next.id!}">${article.next.articletitle!}</a>
                    <#else>
                        <span>没有更多了</span>
                    </#if>
                </p>
            </div>

        </div>
        <div class="hidden-xs col-sm-4 col-md-4 col-lg-4">
        <#include "common/right.ftl">
        </div>
    </div>
</div>
<#include "common/footer.ftl"/>
</body>
<script src="/ref/js/common.js"></script>
</html>