<%@ page language="java" pageEncoding="UTF-8"%>
<div class="manager-index">
	<div class="manager-index-btns">
		<!-- 三个按钮 -->
		<a href="javascript:_articleManager_index.addArticle();"
			class="easyui-linkbutton" style="width: 100px;">添加</a>
		<a href="javascript:_articleManager_index.LabelManager();"
			class="easyui-linkbutton" style="width: 100px;">标签管理</a>
	</div>
	<div class="manager-index-table">
		<table id="articleTable"></table>
	</div>

</div>
<script type="text/javascript">
	_articleManager_index = {
		reload:function (){
			$("#articleTable").datagrid("reload");
		},
	
		articleTableload : function() {
			var _columns = [ [
					{
						field : 'articletitle',
						title : '标题',
						width : 300
					},
					{
						field : 'articleusername',
						title : '作者',
						width : 100
					},
					{
						field : 'count',
						title : '浏览次数',
						width : 100
					},
					{
						field : 'version',
						title : '修改次数',
						width : 100
					},
					{
						field : 'isoriginal',
						title : '是否是原创',
						width : 100,
                        formatter : function(value, row, index) {
                            return(row.isoriginal ==null || row.isoriginal == 1 ) ?"是"  : "否";
                        }
                    },
					{
						field : 'createtime',
						title : '创建时间',
						width : 150
					},
					{
						field : 'top',
						title : '置顶等级',
						width : 100,
						formatter : function(value, row, index) {
							var str = (row.top ==null || row.top == 0 ) ?"置顶"  : "取消置顶";
							return   "<a href='javascript:_articleManager_index.topArticle("+row.id+","+ row.top +");'>"+str+"</a>"
						} 
					},
					{
						field : 'category',
						title : '类别',
						width : 100,
						formatter : function(value, row, index) {
							return (row.category==null||row.category.name==null)?"":row.category.name;
						}
					}
					,
					{
						field : 'labelName',
						title : '标签',
						width : 100,
						formatter : function(value, row, index) {
							return  (row.label==null || row.label.name== null)?"":row.label.name;
						}
					}
					,{
						field : 'islock',
						title : '是否锁定',
						width : 100,
						formatter : function(value, row, index) {
							return row.islock==1 ?"否":"锁定";
						}
					}
					,
					{
						field : 'articleLink',
						title : '来自链接',
						width : 100,
						formatter : function(value, row, index) {
							return "<a href='"+row.articlehref+"'>"
									+ row.articlehreftitle + "</a> ";
						}
					}, {
						field : 'operation',
						title : '操作',
						width : 100,
						formatter : function(value, row, index) {
							return "<a href='javascript:_articleManager_index.deleteArticle("+row.id+");'> 删除</a> "
									+"<a href='javascript:_articleManager_index.updateArticle("+row.id+");'> 修改</a>"
									+"<a href='/"+row.id+".html' target='_blank'> 查看</a>"
									;
						}
					},

			] ];
			//datagrid 加载     
			$("#articleTable").datagrid({
				url : '/admin/articleManager/list.action',
				columns : _columns,
				idField : 'id',
				singleSelect : true,
				striped : true,
				pagination : true,
				fit : true,
				emptyMsg : '无数据',
				pageSize : 30,
				loadMsg : true,
				pageList : [ 10, 20, 30 ]
			});
		}
		,
		addArticle : function (){
			var _url =  "/admin/articleManager/articleSetting.action";
			var index = layer.open({
				  type: 2, 
				  area: '800px',
				  content: _url 
				  ,maxmin: true
			});
			layer.full(index);
		}
		,
		updateArticle:function(id){
			var _url =  "/admin/articleManager/articleSetting.action?flag=update&id=" + id;
			var index = layer.open({
				  type: 2, 
				  area: '800px',
				  content: _url 
				  ,maxmin: true
			});
			layer.full(index);
		},
		deleteArticle:function(id){
			var _title ="是否确定删除一个文章";
		 	 var url =  "/admin/articleManager/delete.action";
		        var data  ={ 'id' :id};
		        var successFn = function(){
		        	$("#articleTable").datagrid("reload");
		        }
	        _base_Js.baseAjax (_title,url,data,successFn , null);
		},
		topArticle:function(id,top){
			var url = (top ==null || top == 0 ) ?"/admin/articleManager/setTop.action"  : "/admin/articleManager/setTopDefault.action";
			var _title = (top ==null || top == 0 ) ?"是否置顶"  : "是否取消置顶";
	        var data  ={ 'id' :id};
	        var successFn = function(){
	        	$("#articleTable").datagrid("reload");
	        }
	        _base_Js.baseAjax (_title,url,data,successFn , null);
			
		},
		LabelManager : function (){
			var id = "labelDialog";
			var url = "/admin/articleManager/label/index.action";
			var _title = '标签管理';
			var queryParams = null;
			var width = 800;
			var height = 600;
			_base_Js.baseDialog (id,url,_title,queryParams,width,height);
		}
		
	};

	$(function() {
		_articleManager_index.articleTableload();
	});
</script>