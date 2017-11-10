<%--
  Created by IntelliJ IDEA.
  User: LiHang
  Date: 2017/8/6
  Time: 15:30
--%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<div class="manager-index">
    <div class="manager-index-table">
        <table id="data-table"></table>
    </div>
</div>
<script type="text/javascript">
    var _accessRecord_Js = {
        lastEditorIndex : null,
        tableLoad : function () {
            var _columns = [ [  {
                field : 'useragent',
                title : 'useragent',
                width : 100,

            }, {
                field : 'ips',
                title : 'ips',
                width : 100,

            }, {
                field : 'method',
                title : 'method',
                width : 100,

            }, {
                field : 'accept',
                title : 'accept',
                width : 100,

            }, {
                field : 'acceptencoding',
                title : 'acceptencoding',
                width : 100,

            }, {
                field : 'connection',
                title : 'connection',
                width : 100,

            }, {
                field : 'host',
                title : 'host',
                width : 100,

            },{
                field : 'starttime',
                title : '开始时间',
                width : 150
            },{
                field : 'endtime',
                title : '结束时间',
                width : 150,

            }, {
                field : 'acceptlanguage',
                title : 'acceptlanguage',
                width : 100,

            }, {
                field : 'referer',
                title : 'referer',
                width : 100,

            }, {
                field : 'xrequestedwith',
                title : 'xrequestedwith',
                width : 100,

            }, {
                field : 'userid',
                title : 'userid',
                width : 100,

            }

            ] ];
            //datagrid 加载
            $("#data-table").datagrid({
                url : '/admin/accessRecordManager/list.action',
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
        }

    };
    $(
        function(){
            _accessRecord_Js.tableLoad();
        }
    );

</script>