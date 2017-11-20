<div class="blog-right-panel-group">

	<#if (hotArticleList?size > 0)>
		<div class="panel panel-primary blog-right-panel-article">
			<div class="panel-heading">热门文章</div>
			<ul class="list-group ">
				<#list hotArticleList as articleModel>
					<li class="list-group-item blog-right-panel-article-list"><a href="/article/${articleModel.id!}">${articleModel.articletitle!""}</a></li>
				</#list>
			</ul>
		</div>
	</#if>
	<#if (latelyArticleList?size > 0)>
	<div class="panel panel-success blog-right-panel-article">
		<div class="panel-heading">最新文章</div>
		<ul class="list-group">
			<#list latelyArticleList as articleModel>
					<li class="list-group-item blog-right-panel-article-list"><a href="/article/${articleModel.id!}">${articleModel.articletitle!""}</a></li>
			</#list>
		</ul>
	</div>
	</#if>


	<#assign labelClass = ["label-default", "label-primary", "label-success","label-info","label-warning","label-danger"] >
	<div class="panel panel-warning blog-right-panel-label">
		<div class="panel-heading">分类</div>
		<ul class="list-group">
			<#if (labelList?size > 0)>
				<li class="list-group-item blog-right-panel-label-body">

					<#list labelList as labelModel>
						<a class="label ${labelClass[labelModel?index%6]}" href="/label/${labelModel.id}">${labelModel.name!""}</a>
					</#list>
				</li>
			</#if>
			<#if (groupByMonthList?size > 0)>
				<#list groupByMonthList as groupByMonthModel>
                    <li class="list-group-item">
                        日期:<a href="/date/${groupByMonthModel.months!""}">
						${groupByMonthModel.months!""} <span class="badge" style="position:relative;top: -2px">${groupByMonthModel.count!"0"}</span></a>
                    </li>
				</#list>
			</#if>
		</ul>
	</div>

<#if (frendLinkList?size >= 0)>
	<div class="panel panel-danger blog-right-panel-frendlink">
		<div class="panel-heading">友情链接</div>
		<ul class="list-group">
			<#list frendLinkList as frendLinkModel>
				<li class="list-group-item"><a href="${frendLinkModel.link!"javascript:;"}">${frendLinkModel.linktitle!""}</a></li>
			</#list>
			<li class="list-group-item">
				<img src="/images/weixin.jpg" style="width: 100%"/>
                <h6><p class="text-muted">微信公众号</p></h6>
			</li>
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
</div>