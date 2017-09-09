<%--
  Created by IntelliJ IDEA.
  User: LiHang
  Date: 2017/8/6
  Time: 15:30
--%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<div class="manager-index">
    <div class="manager-index-btns">
        <a  href="javascript:_Message_Js.delete();" class="easyui-linkbutton" style="width: 100px;">移除第一个</a>
    </div>
    <div class="manager-index-table">
        <table id="data-table"></table>
    </div>
</div>
<script type="text/javascript">
    var _Message_Js = {
        tableLoad : function () {
            var _columns = [ [ {
                field : 'id',
                title : 'ID',
                width : 150
            },
                {
                    field : 'name',
                    title : '姓名',
                    width : 150
                },
                {
                    field : 'email',
                    title : '邮箱',
                    width : 150
                }
                ,
                {
                    field : 'ip',
                    title : 'Ip地址',
                    width : 150
                }
                ,
                {
                    field : 'date',
                    title : '时间',
                    width : 150
                }
            ] ];
            //datagrid 加载
            $("#data-table").datagrid({
                url : '/admin/massageManager/list.action',
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
        },
        reload :function () {
            $("#data-table").datagrid("reload");
        },
        delete :function () {
            _base_Js.baseAjax("是否移除第一个","/admin/massageManager/delete.action",null,function () {
                _Message_Js.reload();
            })
        }

    };
    $(
        function(){
            _Message_Js.tableLoad();
        }
    );

</script>