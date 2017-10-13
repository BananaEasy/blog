
<footer class="blog-footer">
	<div class="container">
		<p>
			<a href="/sitemap.xml">网站地图</a>
		</p>
		<p>© 2017<a href="/index.html">小航博客</a> 蜀ICP备17028272号-1</p>
        <p>本站采用创作共用版权 CC BY-NC-ND/2.5/CN 许可协议</p>
	</div>
</footer>
<canvas id="canvas" style="position:fixed;left:0px;top:0px;width: 100%;height: 100%;z-index: -1"></canvas>
<script src="/ref/js/cavas.js"></script>
<script>
    $('img').error(function(){
        $(this).attr('src', "/images/noimage.png");
    });
</script>
