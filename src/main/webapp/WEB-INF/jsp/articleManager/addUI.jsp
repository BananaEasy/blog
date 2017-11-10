<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/basePath.jsp"%>
<!DOCTYPE>
<html>
<head>
<title>新增</title>
</head>
<link rel="stylesheet" type="text/css" href="/ref/layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="/ref/css/managerStyle.css">
<script type="text/javascript" src="/ref/jquery/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="/ref/layui/lay/dest/layui.all.js"></script>
<script type="text/javascript" src="/ref/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="/ref/ueditor/ueditor.all.min.js"></script>

<body>
	<div style="width: 1200px;margin:  0 auto;" >
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>标题图片</legend>
		</fieldset>
		<div class="layui-form-item">
				<label class="layui-form-label">文章标题图片1</label>
				<div class="layui-input-block">
					<input type="file" id="articletitleimagepath1"  name="file" class="layui-upload-file" lay-title="添加一个标题图片1"/> 
				</div>
			</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">文章标题图片2</label>
		<div class="layui-input-block">
			<input type="file" id="articletitleimagepath2" name="file" class="layui-upload-file" lay-title="添加一个标题图片2"/> 
			</div>
		</div>
		
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>文章</legend>
		</fieldset>
		<form class="layui-form layui-form-pane"  id="articleForm">
			<input type="hidden" name="id" value="${id}" />
			<div class="layui-form-item">
				<label class="layui-form-label">文章标题</label>
				<div class="layui-input-block">
					<input type="text" name="articletitle" autocomplete="off"
						placeholder="请输入标题" class="layui-input"/>
				</div>
			</div>
			
			 <div class="layui-form-item layui-form-text">
			    <label class="layui-form-label">文章提示标题</label>
			    <div class="layui-input-block" >
				    <textarea name="articleprompt" required lay-verify="required" placeholder="请输入" class="layui-textarea"></textarea>
			    </div>
			  </div>
			
			  <div class="layui-form-item">
			    <div class="layui-inline">
					<label class="layui-form-label">配图1</label>
					<div class="layui-input-inline">
						<input type="text" name="articletitleimagepath1" lay-verify="required"
							placeholder="请输入" autocomplete="off" class="layui-input"/>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">配图2</label>
					<div class="layui-input-inline">
						<input type="text" name="articletitleimagepath2" lay-verify="required"
							placeholder="请输入" autocomplete="off" class="layui-input"/>
					</div>
				</div>
			</div>
		  <div class="layui-form-item">
			    <div class="layui-inline">
					<label class="layui-form-label">文章作者</label>
					<div class="layui-input-inline">
						<input type="text" name="articleusername" lay-verify="required"
							placeholder="请输入" autocomplete="off" class="layui-input" value="管理员"/>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">浏览次数</label>
					<div class="layui-input-inline">
						<input type="text" name="count" lay-verify="required"
							placeholder="请输入" autocomplete="off" class="layui-input" value="0"/>
					</div>
				</div>
			</div>
			  <div class="layui-form-item">
			    <div class="layui-inline">
			     <label class="layui-form-label">来自网站</label>
				<div class="layui-input-inline">
					<input type="text" name="articlehreftitle" lay-verify="required"
						placeholder="请输入" autocomplete="off" class="layui-input" value="我的博客"/>
				</div>
			    </div>
			    <div class="layui-inline">
			      <label class="layui-form-label">来自链接</label>
				<div class="layui-input-inline">
					<input type="text" name="articlehref" lay-verify="required"
						placeholder="请输入" autocomplete="off" class="layui-input" value="http://www.lihang.xyz"/>
				</div>
			    </div>
			  </div>


			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">原创?</label>
					<div class="layui-input-inline">
						<select name="isoriginal" lay-verify="required" lay-search="">
							<option value="1">是</option>
							<option value="2">否</option>
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">锁定?</label>
					<div class="layui-input-inline">
						<select name="islock" lay-verify="required" lay-search="">
							<option value="1">否</option>
							<option value="2">是</option>
						</select>
					</div>
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">类别</label>
					<div class="layui-input-inline">
						<select name="categoryId" lay-verify="required" lay-search="">
							<c:forEach items="${requestScope.catgoryList}" var="category">
								<option value="${category.id}">${category.name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">标签</label>
					<div class="layui-input-inline">
						<select name="labelId" lay-verify="required" lay-search="">
							<c:forEach items="${requestScope.labelList}" var="label">
								<option value="${label.id}">${label.name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			 
			  <div class="layui-form-item layui-form-text">
			    <label class="layui-form-label">文章内容</label>
			    <div class="layui-input-block" >
				    <script id="content" name="articlecontent" type="text/plain" style="height: 500px;"></script>
			    </div>
			  </div>
		</form>
		  <a class="layui-btn" href="javascript:save();">保存</a>
	</div>
	
</body>

<script type="text/javascript">
$(
	function (){
		var ue = UE.getEditor('content');
		layui.use(['form','upload'], function() {
			    UE.getEditor('content');
			    function createEditor(){
			        enableBtn();
			        UE.getEditor('content')
			    }
			var form = layui.form();
			form.render();
			fileupload("articletitleimagepath1");
			fileupload("articletitleimagepath2");
			var id = $("input[name='id']").val();
			if(id!= null && id != ''){
				loadData (id,ue,form);
			}
		}); 
		
	}
);

function fileupload (id){
			layui.upload({
			    url: '/admin/fileUpload/image.action',
			   	method:'post',
			    before: function(input){
			    	layer.msg('文件即将上传,请稍后...');
			      }
			      ,success: function(data){
			    	   if(data.status=='success'){
			    		  layer.msg('文件上传成功');
			    		  $("input[name='"+id+"']").val(data.obj);
			    	   }else{
			    		   layer.msg(data.msg, { shade: 0.3, time: 1000, icon: 2 });
			    	   }
			      },
			      elem:"#"+id,
			      error:function(){
			    	 layer.msg('网络异常', { shade: 0.3, time: 1000, icon: 2 });
			      }
			  });
}

function loadData (id,ue,form){
	var _url = "/admin/articleManager/get.action";
	var _data  = {"id" : id};
	$.ajax({
		url : _url,
		type : "post",
		dataType : "json",
		data : _data,
		success : function(data) {
			$("select[name='labelId']").val(data.labelId);
			$("select[name='categoryId']").val(data.categoryId);
			$("select[name='isoriginal']").val(data.isoriginal);
			$("select[name='islock']").val(data.islock);
			$("input[name='articletitle']").val(data.articletitle);
			$("textarea[name='articleprompt']").text(data.articleprompt);
			$("input[name='articlehref']").val(data.articlehref);
			$("input[name='articleusername']").val(data.articleusername);
			$("input[name='count']").val(data.count);
			$("input[name='articlehreftitle']").val(data.articlehreftitle);
			$("input[name='articletitleimagepath1']").val(data.articletitleimagepath1);
			$("input[name='articletitleimagepath2']").val(data.articletitleimagepath2);
			ue.ready(function() {
			    ue.setContent(data.articlecontent);
			});
			form.render();
		},
		error : function() {
			layer.msg('请求失败,请检查连接', {
				icon : 3,
				time : 2000
			});
		}
	});
}
function save(){
	var _url = null;
	var id = $("input[name='id']").val();
	if(id!= null && id != ''){
		_url = "/admin/articleManager/update.action";
	}else{
		_url = "/admin/articleManager/add.action";
	}
	var _data = $("#articleForm").serialize();
	console.log(_data);
	
	$.ajax({
		url : _url,
		type : "post",
		dataType : "json",
		data : _data,
		success : function(data) {
			 if(data.status=='success'){
			 	layer.msg(data.message, { shade: 0.3, time: 2000 },function(){
			 		window.parent._articleManager_index.reload();
			 		window.parent.layer.closeAll();
			 	});
	    	   }else{
	    		   layer.msg(data.message, { shade: 0.3, time: 1000, icon: 2 });
	    	   }
		},
		error : function() {
			layer.msg('请求失败,请检查连接', {
				icon : 3,
				time : 2000
			});
		}
	});
			
}

</script>

</html>
