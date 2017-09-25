<#--
  	用于显示文章列表
-->
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>小航博客-主页</title>
</head>
<#include "common/basejs.ftl">
<body>
<#include "common/banner.ftl">
	<div class="container blog-content">
	<#include "common/head.ftl">
		<div class="row">
			<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8 blog-article-height">
			<#if (articleList?size > 0) >
				<#list articleList as articleModel>
					<article class="blog-article">
						<div class="blog-article-head">
							<div class="blog-article-head-title">
								<h1>
									<a href="/${articleModel.id !""}.html">${articleModel.articletitle !"未知"}</a>
								</h1>
							</div>
							<div class="blog-article-head-meta">
								<table>
									<tr>
										<td class="hidden-xs">作者:${articleModel.articleusername !"未知"}</td>
										<td>时间:${articleModel.createtime ?string("yyyy年MM月dd")}</td>
										<td>浏览次数:${articleModel.count!"0" }</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="blog-article-content">
							<#if articleModel.articletitleimagepath1 ?? >
								<div class="blog-article-content-img">
									<a href="/${articleModel.id !""}.html"> <img alt="" src="${articleModel.articletitleimagepath1}" />
									</a>
								</div>
							</#if>
							<div class="blog-article-content-content">
								<p>${articleModel.articleprompt!""}</p>
							</div>
							<div class="blog-article-content-show">
								<a type="button" class=" btn-primary btn-lg" href="/${articleModel.id !""}.html">阅读全文</a>
							</div>
							<hr />
							<div class="blog-article-head-meta">
								<table>
									<tr>
										<td>标签:<a href="/c/lid/${articleModel.lable.id!""}.html">${articleModel.lable.name!"未知"}</a></td>
										<td>分类:<a href="/c/cid/${articleModel.category.id!""}.html">${articleModel.category.name!"未知"}</a></td>
										<td class="hidden-xs">文章来源:<a href="${articleModel.articlehref!"javascript:;"}">${articleModel.articlehreftitle!""}</a></td>
									</tr>
								</table>
							</div>
						</div>
					</article>
			      </#list>
					<#if ( pageInfo ??) >
					<div class="blog-content-page">
						<div class="btn-group btn-group-lg" role="group">
							<#if (pageInfo.hasPreviousPage) ><a type="button" class="btn btn-default" href="/index-${pageInfo.prePage}.html"><strong>上一页</strong></a></#if>
							<span><strong>第${pageInfo.pageNum}页/共${pageInfo.pages}页</strong></span> 
							<#if (pageInfo.hasNextPage)><a type="button" class="btn btn-default" href="/index-${pageInfo.nextPage}.html" ><strong>下一页</strong></a></#if>
						</div>
					</div>
					</#if>
			<#else>	
					<p style="color:red;text-align: center;font-size:30px">暂无文章</p>
			</#if>
			</div>
			<div class="hidden-xs col-sm-4 col-md-4 col-lg-4">
				<#include "common/right.ftl">
			</div>
		</div>
	</div>
	<#include "common/footer.ftl"/>
</body>


</html>