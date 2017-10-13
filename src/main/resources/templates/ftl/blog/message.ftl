<#--


-->

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>小航博客-留言板</title>
</head>
<#include "common/basejs.ftl">
<body>
	<#include "common/banner.ftl">
	<div class="container blog-content">
	<#include "common/head.ftl">
		<ol class="breadcrumb blog-breadcrumb">
			<li><a href="/index.html">主页</a></li>
			<li>留言板</li>
		</ol>
		<div class="blog-message">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="blog-message-head">
						<h3>欢迎各位留言</h3>
						<p>留言功能已开放 2017.10.12</p>
					</div>
					<hr>
					<div class="blog-message-body">
						<form class="form-horizontal" id="messageForm">
                            <div class="form-group">
								<div class="input-group">
									<span class="input-group-addon" id="sizing-addon1">昵称<font color="red">*</font></span>
									<input type="text" id="name" name="name" value="" class="form-control" placeholder="名称(必填)" aria-describedby="sizing-addon1">
								</div>
                            </div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon" id="sizing-addon2">邮箱<font color="red">*</font></span>
									<input type="email" id="email" name="email" class="form-control" placeholder="邮箱(必填)" value="" aria-describedby="sizing-addon2">
								</div>
							</div>
							<div class="form-group">
								<label for="email" class="control-label" style="padding-bottom: 5px;">发表你的留言<font color="red">*</font></label>
								<input type="hidden" id="content" name="content" value="">
								<div id="editor"></div>
							</div>
							<div class="form-group">
								<button type="button"  id="sendBtn"
									class="btn btn-primary col-xs-4 col-sm-3 col-md-3 col-lg-3 ">提交</button>
							</div>
						</form>
					</div>
				</div>
			</div>
            <div class="blog-message-content">
            </div>
		</div>

        <div class="blog-message-content-bottom" id="toPage">加载更多</div>
	</div>
	<#include "common/footer.ftl"/>
</body>



<script src="/ref/wangEditor/wangEditor.min.js"></script>

<script src="/ref/xss/xss.js"></script>

<script src="/ref/layui/lay/modules/layer.js"></script>

<script type="application/javascript">
	function isblank (str){
		return str == null ||  str.replace(/(^s*)|(s*$)/g, "").length==0;
	}

	function add(message) {
        var html = "<div class=\"panel panel-default blog-right-panel-article\">" +
                "<div class=\"panel-heading\"><div class=\"blog-message-content-head\">" +
                "<p><strong>"+filterXSS(message.name)+"</strong></p><p><small>"+(message.date == null?"未知时间":message.date)+"</small></p>" +
                "</div></div><div class=\"panel-body\"><div class=\"blog-message-content-body\">" +
                "<p>"+filterXSS(message.content)+"</p>" +
                "</div></div></div>"
        return html;
    }

	var p =  1;
	function list (){
        $(".blog-message-content-bottom").text("加载中...");
		setTimeout(function () {
            $.ajax({
                url:"/message/commontList.html",
                method:"POST",
                dataType : "json",
                data:{"p":p},
                success:function (data) {
                    if(data.status == "success"){
                        p = p +1;

                        for(var i=0;i<data.list.length;i++){
                            var message = data.list[i];
                            var html = add(message);
                            $(".blog-message-content").html($(".blog-message-content").html() + html);
                        }

                        $(".blog-message-content-bottom").text("加载下一页")

                    }else{
                        $(".blog-message-content-bottom").text("没有更多了")
                    }
                },
                error:function () {
                    $(".blog-message-content-bottom").text("加载失败")
                }
            });
        },1000);
	}

    $(function(){

        list();
		$("#toPage").click(function () {
			list();
        });
		var E = window.wangEditor
        var editor = new E('#editor');
        editor.customConfig.zIndex = 1;
        editor.customConfig.pasteFilterStyle = false
        editor.customConfig.menus = [
            'head',
            'bold',
            'italic',
            'underline'
        ];
        // 或者 var editor = new E( document.getElementById('#editor') )
        editor.create();
		//消息列表

		$("#sendBtn").click(function () {
			var _name = $("#name").val();
			var _email = $("#email").val();
			var _content = editor.txt.text();
			console.log(_name + "---" + _email + "--" + _content)
			if(isblank(_name)  ){
				$("#name").focus();
                layer.msg('请输入用户名!',{icon: 2});
				return;
			}else if( !/(([\u4E00-\u9FA5]{2,7})|([a-zA-Z]{3,10}))/.test(_name) ){
                $("#name").focus();
                layer.msg('用户名格式不正确!',{icon: 2});
                return;
            }
            if(isblank(_email) ){
                $("#email").focus();
                layer.msg('请输入邮箱!',{icon: 2});
                return;
            }else if(!/^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/.test(_email) ){
                $("#email").focus();
                layer.msg('邮箱格式不正确!',{icon: 2});
                return;
			}
            if(isblank(_content)){
                layer.msg('请输入内容!',{icon: 2});
                return;
            }
			$("#content").val(filterXSS(editor.txt.html()));
			$.ajax({
				url:"/message/commont.html",
				method:"POST",
                dataType : "json",
                data:$("#messageForm").serialize(),
				success:function (data) {
                   if(data.status == 'success'){
                       layer.msg(data.message,{icon: 1});
                       var html = add(data.obj);
                       $(".blog-message-content").html( html + $(".blog-message-content").html() );
                       editor.txt.html('')
				   }else{
                       layer.msg(data.message,{icon: 2});
				   }
                },
				error:function () {
                    layer.msg("请检查网络",{icon: 2});
                }
			});
        });
	});



</script>


</html>