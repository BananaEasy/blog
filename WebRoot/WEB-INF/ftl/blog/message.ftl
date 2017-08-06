<#--


-->

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>小航博客-留言板</title>
<!-- Bootstrap -->
<link href="ref/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="ref/css/style.css" rel="stylesheet">

<!-- emoji css -->
<link rel="stylesheet" href="ref/jquery-emoji/dist/css/jquery.emoji.css" />
<link rel="stylesheet"
	href="ref/jquery-emoji/lib/css/jquery.mCustomScrollbar.min.css" />
<!-- emoji end -->

<!-- comment css-->
<link rel="stylesheet" href="ref/jquerywbpl/css/style.css">
<link rel="stylesheet" href="ref/jquerywbpl/css/comment.css">
<!-- comment css end -->
</head>
<body>
	<#include "common/banner.ftl">
	<div class="container blog-content">
	<#include "common/head.ftl">
		<ol class="breadcrumb blog-breadcrumb">
			<li><a href="#">主页</a></li>
			<li>留言板</li>
		</ol>
		<div class="blog-message">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="blog-message-head">
						<h3>欢迎各位留言</h3>
						<p>网站有缓存，，，，，</p>
					</div>
					<hr>
					<div class="blog-message-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="email" class=" control-label">发表你的留言</label>
								<textarea class="form-control" rows="4" id="content"></textarea>
							</div>
							<div class="form-group">
								<div class=" col-xs-8 col-sm-9 col-md-9 col-lg-9 "></div>
								<button type="submit"
									class="btn btn-primary col-xs-4 col-sm-3 col-md-3 col-lg-3 ">提交</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	<#list 1..10 as t>
		<div class="panel panel-default blog-right-panel-article">
			<div class="panel-heading">
				<div class="blog-message-content-head">
					<p>
						<strong>张三</strong>
					</p>
					<p>
						<small>2017年7月1日14:49:14</small>
					</p>
				</div>
			</div>
			<div class="panel-body">
				<div class="blog-message-content-body">
					<p>我爱你啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</p>
				</div>
			</div>
		</div>
	</#list>
		<div class="blog-content-page">
			<div class="btn-group btn-group-lg" role="group">
				<a type="button" class="btn btn-default"><strong>上一页</strong></a> <span><strong>第1页/共3页</strong></span>
				<a type="button" class="btn btn-default"><strong>下一页</strong></a>
			</div>
		</div>
	</div>
	<#include "common/footer.ftl"/>
</body>

<script src="ref/jquery/jquery-2.1.3.min.js"></script>

<script src="ref/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<!-- emoji js  -->
<!--(Optional) the js for jquery.mCustomScrollbar's addon-->
<script src="ref/jquery-emoji/lib/script/jquery.mousewheel-3.0.6.min.js"></script>
<!--the js for jquery.mCustomScrollbar-->
<script src="ref/jquery-emoji/lib/script/jquery.mCustomScrollbar.min.js"></script>
<!--the js for this plugin-->
<script src="ref/jquery-emoji/dist/js/jquery.emoji.min.js"></script>
<!-- emoji js end -->
<script src="ref/js/message.js"></script>

<script type="text/javascript">
	_MessageJs.loademoji("#content")
</script>
</html>