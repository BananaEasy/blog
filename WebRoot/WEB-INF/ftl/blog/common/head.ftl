

	<nav class="navbar navbar-default navbar-fixed-top navbar-inverse blog-navbar">
			<div class="container">
			<div class="navbar-header">
		      <a class="navbar-brand" href="#"><small>欢迎使用小航博客</small></a>
		    </div>
			
				<div class="collapse navbar-collapse" >
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">切换主题 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">原始</a></li>
								<li><a href="#">蓝色</a></li>
								<li><a href="#">绿色</a></li>
							</ul></li>
						<li><a href="#">关于我们</a></li>
					</ul>

					<form class="navbar-form navbar-right">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="关键字">
						</div>
						<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>搜索</button>
					</form>
				</div>
			</div>
		</nav>
		<nav
			class="navbar navbar-default  blog-navbar">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
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