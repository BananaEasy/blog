<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>博客管理-后台</title>
<link rel="stylesheet" type="text/css"
	href="/ref/easyui/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/ref/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="/ref/layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="/ref/css/managerStyle.css">
<script type="text/javascript" src="/ref/jquery/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="/ref/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="/ref/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/ref/layui/lay/dest/layui.all.js"></script>
</head>
<body>
	<div class="easyui-layout layout-centent">
		<div data-options="region:'north',title:''"
			class="layout-centent-head">
			<h1>博客后台管理</h1>
		</div>
		<div data-options="region:'west',title:'',border:false"
			class="layout-centent-left">
			<div class="easyui-accordion layout-centent-left-accordion">
				<div title="博客后台功能" data-options="selected:true,border:false"
					class="layout-centent-left-accordion-list">
					<a href="javascript:_index_js.articleManager();"
						class="easyui-linkbutton">文章管理</a> <a
						href="javascript:_index_js.articleManager();"
						class="easyui-linkbutton">爬虫管理</a> <a
						href="javascript:_index_js.massageManager();"
						class="easyui-linkbutton">留言管理</a> <a
						href="javascript:_index_js.commentManager();"
						class="easyui-linkbutton">评论管理</a> <a
						href="javascript:_index_js.accessRecordManager();"
						class="easyui-linkbutton">访问记录</a> <a
						href="javascript:_index_js.frendLinkManager();"
						class="easyui-linkbutton">友情链接</a> <a
						href="javascript:_index_js.systemManager();"
						class="easyui-linkbutton">系统设置</a>
				</div>
			</div>
		</div>
		<div data-options="region:'center',title:'',border:false"
			class="layout-centent-right">
			<div id="layout-centent-tabs" class="easyui-tabs"
				data-options="justified:true" style="width: 100%; height: 100%;">
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	$(function() {

	});

	_index_js = {
		articleManager : function() {
			var _href = "/admin/articleManager/index.action";
			var _title = "文章管理";
			_index_js.addTab(_href, _title);
		},
		massageManager : function() {
			var _href = "/admin/massageManager/index.action";
			var _title = "留言管理";
			_index_js.addTab(_href, _title);

		},
		commentManager : function() {
			var _href = "/admin/commentManager/index.action";
			var _title = "评论管理";
			_index_js.addTab(_href, _title);
		},
		accessRecordManager : function() {
			var _href = "/admin/accessRecordManager/index.action";
			var _title = "访问记录";
			_index_js.addTab(_href, _title);
		},
		frendLinkManager : function() {
			var _href = "/admin/frendLinkManager/index.action";
			var _title = "友情链接";
			_index_js.addTab(_href, _title);
		},
		systemManager : function() {
			var _href = "/admin/systemManager/index.action";
			var _title = "系统设置";
			_index_js.addTab(_href, _title);
		},
		addTab : function(_href, _title) {
			_index_js.closeAllTabs();
			$('#layout-centent-tabs').tabs('add', {
				title : _title,
				href : _href,
				closable : true,
				selected : true
			});

		},
		closeAllTabs : function() {
			var tabObj = $('#layout-centent-tabs');
			var tabs = tabObj.tabs('tabs');
			if (tabs != null) {
				$(tabs).each(function() {
					var tab = tabObj.tabs('getSelected');
					var index = tabObj.tabs('getTabIndex', tab);
					tabObj.tabs('close', index);
				});
			}
		}
	}

	_base_Js = {
		baseAjax : function(_title, _url, data, successFn, errorFn) {
			layer.confirm(_title, {
				icon : 7,
				title : '提示',
				skin : 'layui-layer-molv',
				area : [ '150px', '200px' ],
				scrollbar : false,
				move : false,
				btn : [ '确定', '取消' ],
				yes : function(index, layero) {
					var _index = layer.load(1);
					//处理业务逻辑
					$.ajax({
						url : _url,
						type : "post",
						dataType : "json",
						data : data,
						success : function(data) {
							layer.close(_index);
							if (data.status == 'success') {
								if (successFn == null) {
									layer.msg(data.message, {
										icon : 1,
										time : 2000
									});
									return;
								}
								layer.msg(data.message, {
									icon : 1,
									time : 2000
								}, successFn);
							} else {
								if (errorFn == null) {
									layer.msg(data.message, {
										icon : 2,
										time : 2000
									});
									return;
								}
								layer.msg(data.message, {
									icon : 2,
									time : 2000
								}, errorFn);
							}
						},
						error : function() {
							layer.close(_index);
							layer.msg('请求失败,请检查连接', {
								icon : 3,
								time : 2000
							});
						}
					});
				}
			});

		},
		baseDialog : function(_id, _url, _title, _queryParams, width, height) {
			$("<div/>").dialog({
                id: _id,
                href: _url,
                title: _title,
                height: height,
                width: width,
                modal: true,
                queryParams: _queryParams,
                onClose: function () {
                    $("#" + _id).dialog('destroy');  //销毁dialog对象
                }
            });
		}

	}
</script>
</html>