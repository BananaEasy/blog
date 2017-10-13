<div class="blog-right-panel-group">

	<#if (hotArticleList?size > 0)>
		<div class="panel panel-default blog-right-panel-article">
			<div class="panel-heading">热门文章</div>
			<ul class="list-group">
				<#list hotArticleList as articleModel>
					<li class="list-group-item"><a href="/${articleModel.id!}.html">${articleModel.articletitle!""}</a></li>
				</#list>
			</ul>
		</div>
	</#if>
	<#if (latelyArticleList?size > 0)>
	<div class="panel panel-default blog-blog-right-panel-article">
		<div class="panel-heading">最新文章</div>
		<ul class="list-group">
			<#list latelyArticleList as articleModel>
					<li class="list-group-item"><a href="/${articleModel.id!}.html">${articleModel.articletitle!""}</a></li>
			</#list>
		</ul>
	</div>
	</#if>

<#if (labelList?size > 0)>
	<#assign labelClass = ["label-default", "label-primary", "label-success","label-info","label-warning","label-danger"] >
	<div class="panel panel-default blog-right-panel-label">
		<div class="panel-heading">文章标签</div>
		<div class="panel-body " >
			<div class="blog-right-panel-label-body">
				<#list labelList as labelModel>
					<a class="label ${labelClass[labelModel?index%6]}" href="/c/lid/${labelModel.id}.html">${labelModel.name!""}</a>
				</#list>
			</div>
		</div>
	</div>
	
</#if>
<#if (groupByMonthList?size > 0)>
	<div class="panel panel-default blog-right-panel-time">
		<div class="panel-heading">时间分类</div>
		<ul class="list-group">
		<#list groupByMonthList as groupByMonthModel>
			<li class="list-group-item"><a href="/c/date/${groupByMonthModel.months!""}.html">${groupByMonthModel.months!""}<span
					class="badge">${groupByMonthModel.count!"0"}</span></a></li>
		</#list>
		</ul>
	</div>
</#if>
<#if (frendLinkList?size > 0)>
	<div class="panel panel-default blog-right-panel-frendlink">
		<div class="panel-heading">友情链接</div>
		<ul class="list-group">
			<#list frendLinkList as frendLinkModel>
				<li class="list-group-item"><a href="${frendLinkModel.link!"javascript:;"}">${frendLinkModel.linktitle!""}</a></li>
			</#list>
		</ul>
	</div>
</#if>
	<div class="panel panel-default blog-right-panel-statistics">
		<div class="panel-heading">站点统计</div>
		<ul class="list-group">
			<li class="list-group-item">留言次数:${situation.messageCount!"0"}</li>
			<li class="list-group-item">文章个数:${situation.articleCount!"0"}</li>
            <li class="list-group-item">访问次数:${situation.accessCount!"0"}</li>
		</ul>
	</div>

	<div class="panel panel-default blog-right-panel-article">
		<div class="panel-heading">
			<strong>微信公众号</strong>
		</div>
		<div class="panel-body">
			<p><img src="/images/weixin.jpg" style="width: 100%"/></p>
		</div>
	</div>
</div>