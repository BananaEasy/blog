<nav class="navbar navbar-default navbar-fixed-top navbar-inverse blog-navbar">
	<div class="container">
	<div class="navbar-header">
        <a class="navbar-brand" href="/index">
            <img alt="Brand" src="/images/head.png" style="position: relative;width: 30px;height: 30px;border-radius: 15px;top: -5px;"/>
        </a>
		<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
	</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav navbar-right">
			<form  class="navbar-form navbar-right blog-banner-form" action="/search" method="post" role="search">
				<div class="form-group">
					<label class="sr-only"></label>
					<input type="text" name="searchStr" class="form-control" placeholder="关键字">
				</div>
				<button type="submit" class="btn btn-default">搜索</button>
			</form>

			<li role="separator" class="divider"></li>
			<li><a href="/index">主页</a></li>

		<#list menuModelList as menuModel>
			<#if (menuModel.isSon) >
				<li class="dropdown"><a href="${(menuModel.thisCategory.link)!"javasctipt:;"}" class="dropdown-toggle"
										data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"
										<#if (menuModel.thisCategory.title)?? >title="${menuModel.thisCategory.title}"</#if> >
					<#if (menuModel.thisCategory.ico)?? ><span class="${menuModel.thisCategory.ico}" aria-hidden="true"></span> </#if>
				${menuModel.thisCategory.name!""} <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<#list menuModel.sonCategoryList as sonCategory>
							<li><a href="${(sonCategory.link)!"javasctipt:;"}" <#if (sonCategory.title)?? >title="${sonCategory.title}"</#if> >
								<#if (sonCategory.ico )?? ><span class="${sonCategory.ico}" aria-hidden="true"></span> </#if>
							${sonCategory.name!""}</a></li>
						</#list>
					</ul>
				</li>
			<#else>
				<li><a href="${menuModel.thisCategory.link}"
					   <#if (menuModel.thisCategory.title )?? >title="${menuModel.thisCategory.title}"</#if>
				>
					<#if (menuModel.thisCategory.ico )?? ><span class="${menuModel.thisCategory.ico}" aria-hidden="true"></span> </#if>
				${menuModel.thisCategory.name!""}</a></li>
			</#if>
		</#list>
		</ul>
		</div>
	</div>
</nav>
