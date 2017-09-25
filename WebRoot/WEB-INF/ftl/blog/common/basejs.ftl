<link href="/ref/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="/ref/css/style.css" rel="stylesheet">
<script src="/ref/jquery/jquery-2.1.3.min.js"></script>
<script src="/ref/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script src="/ref/jquery-lazy/jquery.lazyload.js"></script>
<script src="/ref/jquery-lazy/scrolltopcontrol.js"></script>
<script>
    //百度统计
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?6bfb017fe3c8792dbe3845b93ac5fc79";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();

</script>
<script>
    //百度站长
    (function(){
        var bp = document.createElement('script');
        var curProtocol = window.location.protocol.split(':')[0];
        if (curProtocol === 'https') {
            bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
        }
        else {
            bp.src = 'http://push.zhanzhang.baidu.com/push.js';
        }
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(bp, s);
    })();
</script>

<script>
//图片懒加载
    $(function () {
        $("img").lazyload({
            effect: "fadeIn",
            placeholder : "/images/loading3.gif",
            threshold: 200,
            failurelimit : 10
        });
    });
</script>