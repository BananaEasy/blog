<%--
  Created by IntelliJ IDEA.
  User: LiHang
  Date: 2017/8/6
  Time: 15:30
--%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<div class="manager-index">
    <div class="manager-index-btns">
        <a  href="javascript:_frendLink_Js.add();" class="easyui-linkbutton" style="width: 100px;">添加</a>
        <a  href="javascript:_frendLink_Js.endEdit();" class="easyui-linkbutton" style="width: 100px;">保存</a>
    </div>
    <div class="manager-index-table">
        <table id="data-table"></table>
    </div>
</div>
<script type="text/javascript">
    var _frendLink_Js = {
        lastEditorIndex : null,
        tableLoad : function () {
            var _columns = [ [ {
                field : 'id',
                title : 'ID',
                width : 100
            }, {
                field : 'linktitle',
                title : '友链名称',
                width : 100,
                editor:'text'
            },{
                field : 'link',
                title : '地址',
                width : 100,
                editor:'text'
            },{
                field : 'record',
                title : '备注',
                width : 100,
                editor:'text'
            },{
                field : 'version',
                title : '修改次数',
                width : 100
            }, {
                field : 'createtime',
                title : '创建时间',
                width : 100
            }, {
                field : 'endtime',
                title : '结束时间',
                width : 100,
                editor:'text'
            },{
                field : 'operation',
                title : '操作',
                width : 100 ,
                formatter: function(value,row,index){
                    return "<a href='javascript:_frendLink_Js.delete(\""+row.id+"\");' >删除</a>";
                }
            } ] ];
            //datagrid 加载
            $("#data-table").datagrid({
                url : '/admin/frendLinkManager/list.action',
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
                ,onDblClickRow : function (index, row){
                    if(_frendLink_Js.lastEditorIndex != null && index != _frendLink_Js.lastEditorIndex){
                        $("#data-table").datagrid("endEdit",_frendLink_Js.lastEditorIndex);
                        $("#data-table").datagrid("beginEdit",index);
                        _frendLink_Js.lastEditorIndex = index;
                    }else{
                        if(_frendLink_Js.lastEditorIndex == null){
                            $("#data-table").datagrid("beginEdit",index);
                            _frendLink_Js.lastEditorIndex = index;
                        }
                    }
                }
                ,onAfterEdit:function(row,changes){
                    console.log ("-------------------------------------------");
                    console.log (changes);
                    _frendLink_Js.update(changes);

                }
            });
        },
        endEdit : function (){
            $("#data-table").datagrid("endEdit",_frendLink_Js.lastEditorIndex);
        },
        add :function () {
            var _title ="是否确定添加";
            var url = "/admin/frendLinkManager/add.action";
            var data = null;
            var successFn = function(){
                _frendLink_Js.reload();
                _frendLink_Js.lastEditorIndex = null;
            }
            _base_Js.baseAjax (_title,url,null,successFn , null);
        },
        update:function (changes) {
            var _title ="是否确定修改内容";
            var url = "/admin/frendLinkManager/update.action";
            var data  = changes;
            var successFn = function(){
                _frendLink_Js.reload();
            }
            _base_Js.baseAjax (_title,url,data,successFn , null);
        },
        delete :function (id) {
            var _title ="是否确定删除";
            var url = "/admin/frendLinkManager/delete.action";
            var data  ={ 'id' : id};
            var successFn = function(){
                _frendLink_Js.reload();
            }
            _base_Js.baseAjax (_title,url,data,successFn , null);
        },
        reload :function () {
            $("#data-table").datagrid("reload");
        }

    };
    $(
        function(){
            _frendLink_Js.tableLoad();
        }
    );

</script>