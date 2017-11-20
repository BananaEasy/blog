<%@ page language="java" pageEncoding="UTF-8"%>
<div id="labelDialog" style="width: 100%;height: 100%">
	<div class="manager-index">
		<div class="manager-index-btns">
			<a href="javascript:_labelManager_index.addLabel();"
			   class="easyui-linkbutton" style="width: 100px;">添加</a> <a
				href="javascript:_labelManager_index.endEdit();"
				class="easyui-linkbutton" style="width: 100px;">保存</a>
		</div>
		<div class="manager-index-table">
			<table id="labelTable"></table>
		</div>
	</div>
</div>
<script>
	_labelManager_index = {
		lastEditorIndex : null,
        labelTableload : function() {

			var _columns = [[
			    {
					field : 'id',
					title : 'id',
					width : 100
				}, {
					field : 'name',
					title : '标签名',
					width : 100,
					editor:'text'
				}, {
					field : 'version',
					title : '修改次数',
					width : 100
				}, {
					field : 'createtime',
					title : '创建时间',
					width : 100
				}, {
                    field : 'opsere',
					title : '操作',
					width : 100,
                    formatter: function(value,row,index){
						return "<a href='javascript:_labelManager_index.deleteLabel("+row.id+");' >删除</a>";
					}
				}
			]];
			//datagrid 加载     
            $("#labelTable").datagrid({
				url : '/admin/articleManager/label/list.action',
				columns : _columns,
                idField : 'id',
                singleSelect : true,
                striped : true,
                pagination : true,
                fit : true,
                emptyMsg : '无数据',
                pageSize : 30,
                loadMsg : true,
                pageList : [ 10, 20, 30 ],
				onDblClickRow : function (index, row){
                    console.log (index + '--' + row);
					if(_labelManager_index.lastEditorIndex != null && index != _labelManager_index.lastEditorIndex){
							$("#labelTable").datagrid("endEdit",_labelManager_index.lastEditorIndex);
							$("#labelTable").datagrid("beginEdit",index);
							_labelManager_index.lastEditorIndex = index;
					}else{
						if(_labelManager_index.lastEditorIndex == null){
							$("#labelTable").datagrid("beginEdit",index);
							_labelManager_index.lastEditorIndex = index;
						}
					}
				},
				onAfterEdit:function(row,changes){
						var _title ="是否确定修改内容";
				        var url = "/admin/articleManager/label/update.action";
				        var data  = changes;
				        var successFn = function(){
				        	$("#labelTable").datagrid("reload");
                            _labelManager_index.lastEditorIndex = null;
				        }
				        _base_Js.baseAjax (_title,url,data,successFn , null);
				}
			});

		},
		endEdit : function (){
			$("#labelTable").datagrid("endEdit",_labelManager_index.lastEditorIndex); 
		},
		deleteLabel : function(id){
			var _title ="是否确定删除一个标签";
	        var url = "/admin/articleManager/label/delete.action";
	        var data  ={ 'id' : id};
	        var successFn = function(){
	        	$("#labelTable").datagrid("reload");
	        }
	        _base_Js.baseAjax (_title,url,data,successFn , null);
		},
		addLabel : function(){
			var _title ="是否确定添加一个标签";
	        var url = "/admin/articleManager/label/add.action";
	        var data = null;
	        var successFn = function(){
	        	$("#labelTable").datagrid("reload");
	        }
	        _base_Js.baseAjax (_title,url,null,successFn , null);
		}
	};
	$(function() {
		_labelManager_index.labelTableload();
	});
</script>