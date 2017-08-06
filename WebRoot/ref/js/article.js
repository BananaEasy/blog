/**
 * 作者：李航 日期：2017-6-30
 * 
 * 文章页面js
 * 
 * 依赖： jquery-emoji jquerywbpl
 */

_ArticleJs = {
	comment: null,
	commentSend : null,
	loademoji: null,
	articlecommentLoad : null,
	isLogin:null
}

/**
 * 加载单击回复按钮显示textare
 */
_ArticleJs.comment = function(){
	// 评论
	$('.comment-show')
			.on(
					'click',
					'.pl-hf',
					function() {
						// 获取回复人的名字
						var fhName = $(this).parents('.date-dz-right').parents(
								'.date-dz').siblings('.pl-text').find(
								'.comment-size-name').html();
						// 回复@
						var fhN = '回复@' + fhName;
						// var oInput =
						// $(this).parents('.date-dz-right').parents('.date-dz').siblings('.hf-con');
						var fhHtml = '<div class="hf-con pull-left"> <textarea class="content comment-input hf-input" placeholder=""></textarea> <a href="javascript:;" class="hf-pl">评论</a></div>';
						// 显示回复
						if ($(this).is('.hf-con-block')) {
							$(this).parents('.date-dz-right').parents(
									'.date-dz').append(fhHtml);
							$(this).removeClass('hf-con-block');
							$('.content').flexText();
							$(this).parents('.date-dz-right').siblings(
									'.hf-con').find('.pre').css('padding',
									'6px 15px');
							// console.log($(this).parents('.date-dz-right').siblings('.hf-con').find('.pre'))
							// input框自动聚焦
							$(this).parents('.date-dz-right').siblings(
									'.hf-con').find('.hf-input').val('')
									.focus().val(fhN);
						} else {
							$(this).addClass('hf-con-block');
							$(this).parents('.date-dz-right').siblings(
									'.hf-con').remove();
						}
					});
}
/**
 * 将请求发送到客户端
 */
_ArticleJs.commentSend = function() {
	// 提交评论
	$('.comment-show')
			.on(
					'click',
					'.hf-pl',
					function() {
						var oThis = $(this);
						var myDate = new Date();
						// 获取当前年
						var year = myDate.getFullYear();
						// 获取当前月
						var month = myDate.getMonth() + 1;
						// 获取当前日
						var date = myDate.getDate();
						var h = myDate.getHours(); // 获取当前小时数(0-23)
						var m = myDate.getMinutes(); // 获取当前分钟数(0-59)
						if (m < 10)
							m = '0' + m;
						var s = myDate.getSeconds();
						if (s < 10)
							s = '0' + s;
						var now = year + '-' + month + "-" + date + " " + h
								+ ':' + m + ":" + s;
						// 获取输入内容
						var oHfVal = $(this).siblings('.flex-text-wrap').find(
								'.hf-input').val();
						console.log(oHfVal)
						var oHfName = $(this).parents('.hf-con').parents(
								'.date-dz').siblings('.pl-text').find(
								'.comment-size-name').html();
						var oAllVal = '回复@' + oHfName;
						if (oHfVal.replace(/^ +| +$/g, '') == ''
								|| oHfVal == oAllVal) {

						} else {
							$
									.getJSON(
											"ref/jquerywbpl/json/pl.json",
											function(data) {
												var oAt = '';
												var oHf = '';
												$
														.each(
																data,
																function(n, v) {
																	delete v.hfContent;
																	delete v.atName;
																	var arr;
																	var ohfNameArr;
																	if (oHfVal
																			.indexOf("@") == -1) {
																		data['atName'] = '';
																		data['hfContent'] = oHfVal;
																	} else {
																		arr = oHfVal
																				.split(':');
																		ohfNameArr = arr[0]
																				.split('@');
																		data['hfContent'] = arr[1];
																		data['atName'] = ohfNameArr[1];
																	}

																	if (data.atName == '') {
																		oAt = data.hfContent;
																	} else {
																		oAt = '回复<a href="#" class="atName">@'
																				+ data.atName
																				+ '</a> : '
																				+ data.hfContent;
																	}
																	oHf = data.hfName;
																});

												var oHtml = '<div class="all-pl-con"><div class="pl-text hfpl-text clearfix"><a href="#" class="comment-size-name">我的名字 : </a><span class="my-pl-con">'
														+ oAt
														+ '</span></div><div class="date-dz"> <span class="date-dz-left pull-left comment-time">'
														+ now
														+ '</span> <div class="date-dz-right pull-right comment-pl-block"><a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a>  </div> </div></div>';
												oThis
														.parents('.hf-con')
														.parents(
																'.comment-show-con-list')
														.find('.hf-list-con')
														.css('display', 'block')
														.append(oHtml)
														&& oThis
																.parents(
																		'.hf-con')
																.siblings(
																		'.date-dz-right')
																.find('.pl-hf')
																.addClass(
																		'hf-con-block')
														&& oThis.parents(
																'.hf-con')
																.remove();
											});
						}
					});

}

/**
 * 表情加载 jquery 选择器
 */
_ArticleJs.loademoji = function(ids) {

	$(ids).emoji({
		showTab : true,
		animation : 'fade',
		icons : [ {
			name : "贴吧表情",
			path : "ref/jquery-emoji/dist/img/tieba/",
			maxNum : 50,
			file : ".jpg",
			placeholder : ":{alias}:",
			alias : {
				1 : "hehe",
				2 : "haha",
				3 : "tushe",
				4 : "a",
				5 : "ku",
				6 : "lu",
				7 : "kaixin",
				8 : "han",
				9 : "lei",
				10 : "heixian",
				11 : "bishi",
				12 : "bugaoxing",
				13 : "zhenbang",
				14 : "qian",
				15 : "yiwen",
				16 : "yinxian",
				17 : "tu",
				18 : "yi",
				19 : "weiqu",
				20 : "huaxin",
				21 : "hu",
				22 : "xiaonian",
				23 : "neng",
				24 : "taikaixin",
				25 : "huaji",
				26 : "mianqiang",
				27 : "kuanghan",
				28 : "guai",
				29 : "shuijiao",
				30 : "jinku",
				31 : "shengqi",
				32 : "jinya",
				33 : "pen",
				34 : "aixin",
				35 : "xinsui",
				36 : "meigui",
				37 : "liwu",
				38 : "caihong",
				39 : "xxyl",
				40 : "taiyang",
				41 : "qianbi",
				42 : "dnegpao",
				43 : "chabei",
				44 : "dangao",
				45 : "yinyue",
				46 : "haha2",
				47 : "shenli",
				48 : "damuzhi",
				49 : "ruo",
				50 : "OK"
			},
			title : {
				1 : "呵呵",
				2 : "哈哈",
				3 : "吐舌",
				4 : "啊",
				5 : "酷",
				6 : "怒",
				7 : "开心",
				8 : "汗",
				9 : "泪",
				10 : "黑线",
				11 : "鄙视",
				12 : "不高兴",
				13 : "真棒",
				14 : "钱",
				15 : "疑问",
				16 : "阴脸",
				17 : "吐",
				18 : "咦",
				19 : "委屈",
				20 : "花心",
				21 : "呼~",
				22 : "笑脸",
				23 : "冷",
				24 : "太开心",
				25 : "滑稽",
				26 : "勉强",
				27 : "狂汗",
				28 : "乖",
				29 : "睡觉",
				30 : "惊哭",
				31 : "生气",
				32 : "惊讶",
				33 : "喷",
				34 : "爱心",
				35 : "心碎",
				36 : "玫瑰",
				37 : "礼物",
				38 : "彩虹",
				39 : "星星月亮",
				40 : "太阳",
				41 : "钱币",
				42 : "灯泡",
				43 : "茶杯",
				44 : "蛋糕",
				45 : "音乐",
				46 : "haha",
				47 : "胜利",
				48 : "大拇指",
				49 : "弱",
				50 : "OK"
			}
		}, {
			name : "QQ表情",
			path : "ref/jquery-emoji/dist/img/qq/",
			maxNum : 91,
			excludeNums : [ 41, 45, 54 ],
			file : ".gif",
			placeholder : "#qq_{alias}#"
		} ]
	});

}
/**
 * 初始化页面的评论列表
 */
_ArticleJs.articlecommentLoad = function () {
	if(1==1){
		$(".blog-article-comment-nobody").html("<p>暂无评论</p>");
	}else{
		
	}
} 
/**
 * 登陆过
 */
_ArticleJs.isLogin = function () {
	var xxx = $(".article-form-group");
	console.log(xxx);
	xxx.remove();
} 

