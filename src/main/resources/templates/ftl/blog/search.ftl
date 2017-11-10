<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <#include "common/seo.ftl">
    <title>小航博客-搜索引擎</title>
</head>
    <link href="/ref/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="/ref/css/style.css" rel="stylesheet">
    <script src="/ref/jquery/jquery-2.1.3.min.js"></script>
    <script src="/ref/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<body>
    <div class="jumbotron">
        <div class="container">
            <h3 class="text-danger" style="text-align: center">小航博客搜索引擎</h3>
            <p class="text-primary" style="text-align: center"><small>这是一个基于lucene实现的站内搜索引擎,在这里你可以快速的查阅本站内容</small></p>
            <form class="form-horizontal" action="/search" method="post" id="searchform">
                <input type="hidden" name="p" value="${pageNum!1}"/>
                <input type="hidden" name="total" value="${total!0}"/>
                    <div class="col-lg-9  col-md-9 col-xs-9 col-sm-9">
                        <input type="text" class="form-control" name="searchStr"  placeholder="要搜索的内容" value="${searchStr!""}"/>
                    </div>
                    <button type="submit" class=" btn btn-primary col-lg-3  col-md-3 col-xs-3 col-sm-3 ">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>搜索</button>
            </form>
        </div>
    </div>
<#if searchStr?? >
    <#if articleList?? && (articleList?size > 0) >
    <div class="container">
        <ol class="breadcrumb">
            <li><a href="/">主页</a></li>
            <li class="active">搜索引擎</li>
        </ol>
    <table class="table table-striped table-hover" style="table-layout:fixed">
        <tr>
            <th width="50%">标题</th>
            <th width="15%">类别</th>
            <th width="15%">标签</th>
            <th width="10%">时间</th>
        </tr>
            <#list articleList as articleModel>
                <tr onclick="gotoArticle(${articleModel.id!""})">
                    <td>${articleModel.articletitle!""}</td>
                    <td>${articleModel.category.name!""}</td>
                    <td>${articleModel.label.name!""}</td>
                    <td>${articleModel.createtime ?string("yyyy-MM-dd")}</td>
                </tr>
            </#list>
        </table>
            <nav aria-label="Page navigation">
                <ul class="pagination" id="page">
                </ul>
            </nav>
        </div>
    <#else>
        <h3 style="text-align: center;color: red">没有搜索到内容</h3>
    </#if>
</#if>
<script>
    var dom  = document.getElementById("searchform");
    if(dom.total.value > 0){
        //进行分页
        var total =  parseInt(dom.total.value);
        var pageNum = dom.p.value;
        var pageDom = $("#page");
        var totalPage = 0;
        if(total % 8 == 0) {
            totalPage = parseInt(total / 8);
        } else {
            totalPage = parseInt(total / 8) + 1;
        }
        for(var i=1;i<=totalPage;i++){
            var $li =  $("<li><a></a></li>");
            $li.children().html(i);
            $li.children().attr("href","javascript:goPage("+i+");")
            if(i == pageNum){
                $li.attr("class"," active");
            }
            if(i == 1){
                var head = $("<li><a></a></li>");
                head.children().html("<span aria-hidden=\"true\">&laquo;</span>");
                head.children().attr("aria-label","Previous");
                head.children().attr("href","javascript:goPage("+1+");");
                pageDom.append(head);
            }else if(i == totalPage){
                var head = $("<li><a></a></li>");
                head.children().html("<span aria-hidden=\"true\">&raquo;</span>");
                head.children().attr("aria-label","Next");
                head.children().attr("href","javascript:goPage("+totalPage+");");
                pageDom.append($li);
                pageDom.append(head);
                break;
            }
            pageDom.append($li);
        }
    }
    
    function goPage(index) {
        dom.p.value = index;
        dom.submit();
    }
    function gotoArticle(id) {
        var url = "/article/" + id;
        window.open(url);
    }
</script>
</body>
</html>