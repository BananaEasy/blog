<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>小航博客-网站地图</title>
</head>
<link href="/ref/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="/ref/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<body>

<div class="container">
    <ol class="breadcrumb" style="margin-top: 20px;">
        <li><a href="/index">主页</a></li>
        <li><a href="/sitemap.html">网站地图</a></li>
    </ol>
    <hr/>
    <table class="table table-hover">
        <tr>
            <th>文章</th>
            <th>类别</th>
            <th>标签</th>
            <th>时间</th>
        </tr>
    <#if (articleList?size > 0) >
        <#list articleList as articleModel>
        <tr>
            <td><a href="/article/${articleModel.id !""}">${articleModel.articletitle !"未知"}</a></td>
            <td><a href="/category/${articleModel.category.id!""}">${articleModel.category.name!"未知"}</a></td>
            <td><a href="/label/${articleModel.label.id!""}">${articleModel.label.name!"未知"}</a></td>
            <td>${articleModel.createtime ?string("yyyy-MM-dd")}</td>
        </tr>
    </#list>
    </#if>
    </table>
</div>
</body>
</html>