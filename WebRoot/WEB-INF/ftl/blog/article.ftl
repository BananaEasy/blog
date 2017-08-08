<#--
文章显示页面
-->
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>小航博客-文章:${article.index.articletitle!""}</title>
<!-- Bootstrap -->
<link href="/ref/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="/ref/css/style.css" rel="stylesheet">

<!-- comment css-->
<link rel="stylesheet" href="/ref/jquerywbpl/css/style.css">
<link rel="stylesheet" href="/ref/jquerywbpl/css/comment.css">
<!-- comment css end -->
</head>
<body>
	<#include "common/banner.ftl"/>
	<div class="container blog-content">
	<#include "common/head.ftl"/>
		<ol class="breadcrumb blog-breadcrumb">
			<li><a href="/">主页</a></li>
			<li><a href="/c/cid/${article.index.category.id!""}.html">${article.index.category.name !}</a></li>
			<li>${article.index.articletitle!""}</li>
		</ol>

		<div class="row">
			<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8 ">
				<div class="blog-article-article">
					<div class="blog-article-article-head">
						<h1>${article.index.articletitle!""}</h1>
						<div class="blog-article-article-head-meta">
							<table>
								<tr>
									<td>作者:${article.index.articleusername !"未知"}</td>
									<td>时间:${article.index.createtime ?string("yyyy年MM月dd")}</td>
									<td>浏览次数:${article.index.count!"0"}</td>
								</tr>
							</table>
						</div>
					</div>

					<div class="blog-article-article-content">
						<p>${article.index.articlecontent !""}</p>
					</div>

					<div class="blog-article-article-head-meta">
						<table>
							<tr>
								<td>标签:<a href="/c/lid/${article.index.lable.id!""}.html">${article.index.lable.name!"未知"}</a></td>
								<td>分类:<a href="/c/cid/${article.index.category.id!""}.html">${article.index.category.name!"未知"}</a></td>
								<td>文章来源:<a href="${article.index.articlehref!"javascript:;"}">${article.index.articlehreftitle!""}</a></td>
							</tr>
						</table>
					</div>
				</div>


				<div class="blog-article-page">
					<p>
						上一篇:<#if article.pre?? ><a href="/${article.pre.id!}.html">${article.pre.articletitle!}</a><#else> <span>没有更多了</span>  </#if>
					</p>
					<p>
						下一篇:<#if article.next?? > <a href="/${article.next.id!}.html">${article.next.articletitle!}</a> <#else> <span>没有更多了</span> </#if>
					</p>
				</div>

				<#--<div class="panel panel-default">-->
					<#--<div class="panel-heading">评论</div>-->
					<#--<div class="panel-body">-->
						<#--<!-- 评论框显示 &ndash;&gt;-->
						<#--<div class="blog-article-comment">-->
							<#--<form class="form-horizontal" id="articleform">-->
								<#--<div class="form-group article-form-group">-->
									<#--<label for="email" class="col-sm-2 control-label">邮箱</label>-->
									<#--<div class="col-sm-10">-->
										<#--<input type="email" class="form-control" id="email"-->
											<#--placeholder="请输入你的邮箱,如果有最新动态，我们将会通过邮件发送你的邮箱">-->
									<#--</div>-->
								<#--</div>-->
								<#--<div class="form-group article-form-group">-->
									<#--<label for="userName" class="col-sm-2 control-label">用户名</label>-->
									<#--<div class="col-sm-10">-->
										<#--<input type="text" class="form-control" id="userName"-->
											<#--placeholder="请输入你的昵称">-->
									<#--</div>-->
								<#--</div>-->
								<#--<div class="form-group">-->
									<#--<label for="email" class="col-sm-2 control-label">发表你的评论</label>-->
									<#--<div class="col-sm-10">-->
										<#--<div class="blog-article-comment-content"  id="content"></div>-->
									<#--</div>-->
								<#--</div>-->
								<#--<div class="form-group">-->
									<#--<div class="col-sm-1 hidden-xs"></div>-->
									<#--<div class=" col-xs-8 col-sm-7 col-md-7 col-lg-7 "></div>-->
									<#--<button type="submit"-->
										<#--class="btn btn-primary col-xs-4 col-sm-3 col-md-3 col-lg-3 ">提交</button>-->
									<#--<div class="col-sm-1 hidden-xs"></div>-->
								<#--</div>-->
							<#--</form>-->
						<#--</div>-->
					<#--</div>-->
				<#--</div>-->


				<!-- 评论列表 -->
				<#--<div class="panel panel-default">-->
					<#--<div class="panel-heading">评论列表</div>-->
					<#--<div class="panel-body">-->
						<#--<div class="blog-article-comment">-->
							<#--<div class="blog-article-comment-nobody">-->
								<#--<img alt="loading" src="images/loading4.gif">-->
								<#--<p>评论加载中...</p>-->
							<#--</div>-->
							<#---->
							<#---->
							<#--<div class="blog-article-comment-list">-->
								<#--<div class="comment-show">-->
									<#--<div class="comment-show-con clearfix">-->
										<#--<div-->
											<#--class="comment-show-con-list pull-left clearfix blog-article-comment-body">-->
											<#--<div class="pl-text clearfix">-->
												<#--<a href="#" class="comment-size-name">张三 : </a> <span-->
													<#--class="my-pl-con">&nbsp;来啊 造作啊!</span>-->
											<#--</div>-->
											<#--<div class="date-dz">-->
												<#--<span class="date-dz-left pull-left comment-time">2017-5-2-->
													<#--11:11:39</span>-->
												<#--<div class="date-dz-right pull-right comment-pl-block">-->
													<#--<a href="javascript:;"-->
														<#--class="date-dz-pl pl-hf hf-con-block pull-left">回复</a>-->
												<#--</div>-->
											<#--</div>-->
											<#--<div class="hf-list-con">-->
												<#--<div class="all-pl-con">-->
													<#--<div class="pl-text hfpl-text clearfix">-->
														<#--<a href="#" class="comment-size-name">我的名字 : </a><span-->
															<#--class="my-pl-con">asdsadsa</span>-->
													<#--</div>-->
													<#--<div class="date-dz">-->
														<#--<span class="date-dz-left pull-left comment-time">asdasdsad</span>-->
														<#--<div class="date-dz-right pull-right comment-pl-block">-->
															<#--<a href="javascript:;"-->
																<#--class="date-dz-pl pl-hf hf-con-block pull-left">回复</a>-->
														<#--</div>-->
													<#--</div>-->
												<#--</div>-->

											<#--</div>-->
										<#--</div>-->
										<#--<div-->
											<#--class="comment-show-con-list pull-left clearfix blog-article-comment-body">-->
											<#--<div class="pl-text clearfix">-->
												<#--<a href="#" class="comment-size-name">张三 : </a> <span-->
													<#--class="my-pl-con">&nbsp;来啊 造作啊!</span>-->
											<#--</div>-->
											<#--<div class="date-dz">-->
												<#--<span class="date-dz-left pull-left comment-time">2017-5-2-->
													<#--11:11:39</span>-->
												<#--<div class="date-dz-right pull-right comment-pl-block">-->
													<#--<a href="javascript:;"-->
														<#--class="date-dz-pl pl-hf hf-con-block pull-left">回复</a>-->
												<#--</div>-->
											<#--</div>-->
											<#--<div class="hf-list-con">-->
												<#--<div class="all-pl-con">-->
													<#--<div class="pl-text hfpl-text clearfix">-->
														<#--<a href="#" class="comment-size-name">我的名字 : </a><span-->
															<#--class="my-pl-con">asdsadsa</span>-->
													<#--</div>-->
													<#--<div class="date-dz">-->
														<#--<span class="date-dz-left pull-left comment-time">asdasdsad</span>-->
														<#--<div class="date-dz-right pull-right comment-pl-block">-->
															<#--<a href="javascript:;"-->
																<#--class="date-dz-pl pl-hf hf-con-block pull-left">回复</a>-->
														<#--</div>-->
													<#--</div>-->
												<#--</div>-->

											<#--</div>-->
										<#--</div>-->

									<#--</div>-->
								<#--</div>-->

							<#--</div>-->
						<#--</div>-->
					<#--</div>-->
				<#--</div>-->


			</div>
			<div class="hidden-xs col-sm-4 col-md-4 col-lg-4">
				<#include "common/right.ftl">
			</div>
		</div>
	</div>
	<#include "common/footer.ftl"/>
</body>

<script src="/ref/jquery/jquery-2.1.3.min.js"></script>

<#--<script src="/ref/jquery-cookie/js.cookie.js"></script>-->

<script src="/ref/bootstrap-3.3.7/js/bootstrap.min.js"></script>

<#--<!-- comment js &ndash;&gt;-->
<#--<script src="/ref/jquerywbpl/js/jquery.flexText.js"></script>-->
<#--<!-- comment js end &ndash;&gt;-->
<#--<script src="/ref/js/article.js"></script>-->
<#--<!--WANG editor&ndash;&gt;-->
<#--<script src="https://unpkg.com/wangeditor@3.0.3/release/wangEditor.min.js"></script>-->

<script type="text/javascript">
	$(function() {
		
//		_ArticleJs.comment();
//		_ArticleJs.commentSend();
//
//
//        var flag = true;
//		$(window).scroll(function () {
//			var h = $(".blog-article-comment").offset().top;
//			if($(this).scrollTop() + ($(window).height()) > h ){
//				//执行
//
//				//构造输入栏
//
//				//设置评论列表
//				if(flag){
//					flag = false;
//					var E = window.wangEditor
//			        var editor = new E('#content')
//			         editor.customConfig.menus = [
//						    'quote',  // 引用
//						    'emoticon',  // 表情
//						    'code',  // 插入代码
//				    ]
//				    //构造评论
//			        editor.create();
//			        _ArticleJs.isLogin();
//				}
//
//
//			}
//		});
//
//		$(window).resize(function(){
//		  //_ArticleJs.isLogin();
//		});
	});
</script>
</html>