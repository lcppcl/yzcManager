<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <LINK rel="Bookmark" href="/pig.png">
    <LINK rel="Shortcut Icon" href="/pig.png"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.7/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css"/>
    <title>养殖场管理系统</title>
</head>
<body>
<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl"><a class="logo navbar-logo f-l mr-10 hidden-xs"
                                           href="#">养殖场管理系统</a> <a
                class="logo navbar-logo-m f-l mr-10 visible-xs" href="#">H-ui</a> <span
                class="logo navbar-slogan f-l mr-10 hidden-xs"></span> <a aria-hidden="false"
                                                                          class="nav-toggle Hui-iconfont visible-xs"
                                                                          href="javascript:;">&#xe667;</a>
            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                <ul id="c1" class="cl">
                    <li id="wel">欢迎您：</li>
                    <li id="well" class="dropDown dropDown_hover"><a href="#" id="username" class="dropDown_A"></a>
                        <ul id="c2" class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:showMember();">个人信息</a></li>
                            <li><a href="javascript:logout();">注销</a></li>
                        </ul>
                    </li>
                    <li id="Hui-msg"><a href="javascript:feed_add('消息提示','scts/message.html','800','500')"
                                        title="消息"><span class="badge badge-danger" id="messagenum"></span><i
                            class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a></li>
                    <li id="Hui-skin" class="dropDown right dropDown_hover"><a href="javascript:;" class="dropDown_A"
                                                                               title="换肤"><i class="Hui-iconfont"
                                                                                             style="font-size:18px">&#xe62a;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
                            <li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
                            <li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
                            <li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
                            <li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
                            <li><a href="javascript:;" data-val="orange" title="绿色">橙色</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<aside class="Hui-aside">
    <input runat="server" id="divScrollValue" type="hidden" value=""/>

    <input type="hidden" id="emp_id" value="${sessionScope.employee.emp_id }">
    <input type="hidden" id="emp_name" value="${sessionScope.employee.emp_name }">
    <input type="hidden" id="dept_id" value="${sessionScope.employee.emp_dept_id }">
    <input type="hidden" id="emp_manager" value="${sessionScope.employee.emp_manager }">

    <div class="menu_dropdown bk_2">
        <dl id="menu_article0">
            <dt><i class="Hui-iconfont">&#xe616;</i> 生产管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul class="manage">
                    <%--<li><a _href="scgl/pregnant.html" data-title="育种管理" href="javascript:void(0)">育种管理</a></li>--%>
                    <li><a _href="scgl/peizhongjilu.html" data-title="配种记录管理" href="javascript:void(0)">配种记录管理</a></li>
                    <li><a _href="scgl/pregnant.html" data-title="怀孕记录管理" href="javascript:void(0)">怀孕记录管理</a></li>
                    <li><a _href="scgl/fenwan.html" data-title="分娩记录管理" href="javascript:void(0)">分娩记录管理</a></li>
                    <%--<li><a _href="scgl/zhuzhipandian.html" data-title="猪只盘点管理" href="javascript:void(0)">猪只盘点管理</a></li>--%>

                </ul>
            </dd>
        </dl>
        <dl id="menu_article1">
            <dt><i class="Hui-iconfont">&#xe616;</i> 生产分析<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
            </dt>
            <dd>
                <ul>
                    <li><a _href="scfx/zcjzpg.html" data-title="猪场价值评估" href="javascript:void(0)">猪场价值评估</a></li>
                    <li><a _href="scfx/swlfx.html" data-title="死亡率分析" href="javascript:void(0)">死亡率分析</a></li>
                    <li><a _href="scfx/shengchan_fenxi.html" data-title="生产效率分析"
                           href="javascript:void(0)">生产效率分析</a></li>
                    <li><a _href="scfx/shoutailv_fenxi.html" data-title="受胎率分析" href="javascript:void(0)">受胎率分析</a>
                    </li>
                </ul>
            </dd>
        </dl>

<%--
        <dl id="menu-article2"  id="menu_article2">
            <dt><i class="Hui-iconfont">&#xe616;</i> 生产提示<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul class="manage">
                    <li><a _href="scts/dcmz.html" data-title="待产母猪提示" href="javascript:void(0)">待产母猪提示</a></li>
                    <li><a _href="scts/dnmz.html" data-title="断奶母猪提示" href="javascript:void(0)">断奶母猪提示</a></li>
                    <li><a _href="scts/my.html" data-title="免疫提示" href="javascript:void(0)">免疫提示</a></li>
                    <li><a _href="scts/dpmz.html" data-title="待配母猪提示" href="javascript:void(0)">待配母猪提示</a></li>
                    <li><a _href="scts/rsjc.html" data-title="妊娠检查提示" href="javascript:void(0)">妊娠检查提示</a></li>

                </ul>
            </dd>
        </dl>
--%>

        <dl id="menu_article3">
            <dt><i class="Hui-iconfont">&#xe616;</i> 猪场管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul class="manage">
                    <li><a _href="pig_manager/boar.html" data-title="公猪管理" href="javascript:void(0)">公猪管理</a></li>
                    <li><a _href="pig_manager/sow.html" data-title="母猪管理" href="javascript:void(0)">母猪管理</a></li>
                    <li><a _href="pig_manager/seeds.html" data-title="育种猪管理" href="javascript:void(0)">育种猪管理</a></li>
                    <li><a _href="pig_manager/disease.html" data-title="病历管理" href="javascript:void(0)">病历管理</a></li>
                    <li><a _href="pig_manager/grade.html" data-title="猪舍管理" href="javascript:void(0)">猪舍管理</a></li>
                    <li><a _href="pig_manager/class.html" data-title="栏位管理" href="javascript:void(0)">栏位管理</a></li>
                    <li><a _href="pig_manager/variety.html" data-title="品种管理" href="javascript:void(0)">品种管理</a></li>
                    <li><a _href="pig_manager/feed_record.html" data-title="饲养记录" href="javascript:void(0)">饲养记录</a>
                    </li>
                    <li><a _href="pig_manager/dead.html" data-title="死亡管理" href="javascript:void(0)">死亡管理</a></li>
                </ul>
            </dd>
        </dl>

        <dl id="menu_article4">
            <dt><i class="Hui-iconfont">&#xe620;</i> 业务管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul class="data">
                    <li><a _href="yewu_manage/cg.html" data-title="采购管理" href="javascript:void(0)">采购管理</a></li>
                    <li><a _href="yewu_manage/zmm.html" data-title="猪买卖管理" href="javascript:void(0)">猪买卖管理</a></li>
                    <%--<li><a _href="yewu_manage/mmdd.html" data-title="买卖订单管理" href="javascript:void(0)">销售管理/买卖订单管理</a></li>--%>
                    <li><a _href="yewu_manage/hzs.html" data-title="合作商管理" href="javascript:void(0)">来往单位/合作商管理</a></li>
                </ul>
            </dd>
        </dl>

<%--
        <dl id="menu_article5">
            <dt><i class="Hui-iconfont">&#xe620;</i> 生产报表<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul class="data">
                    <li><a _href="./pro_chart/saveDetail.html" data-title="存栏明细" href="javascript:void(0)">存栏明细</a></li>
                    <li><a _href="./pro_chart/boar-product-report.html" data-title="公猪生产成绩表" href="javascript:void(0)">公猪生产成绩表</a>
                    </li>
                    <li><a _href="./pro_chart/sow-product-report.html" data-title="母猪生产成绩表" href="javascript:void(0)">母猪生产成绩表</a>
                    </li>
                    <li><a _href="./pro_chart/pigs-feed-cost.html" data-title="猪群饲养成本"
                           href="javascript:void(0)">猪群饲养成本</a></li>
                </ul>
            </dd>
        </dl>
--%>

        <dl id="menu_article6">
            <dt><i class="Hui-iconfont">&#xe61a;</i> 报表统计<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul class="data">
                    <li><a _href="statistics/user_count.html" data-title="来往客户统计" href="javascript:void(0)">来往客户统计</a>
                    </li>
                    <li><a _href="statistics/month_count.html" data-title="月统计报表" href="javascript:void(0)">月统计报表</a>
                    </li>
                    <li><a _href="statistics/pigsell_count.html" data-title="猪类销售统计"
                           href="javascript:void(0)">猪类销售统计</a></li>
                    <li><a _href="statistics/livestock_count.html" data-title="存栏统计" href="javascript:void(0)">存栏统计</a>
                    </li>
                </ul>
            </dd>
        </dl>

        <dl id="menu_article7">
            <dt><i class="Hui-iconfont">&#xe62d;</i> 人事管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul class="staff">
                    <!-- <li><a _hrstaffingoyee/admin-permission.html" data-title="职位管理" href="javascript:void(0)">职位管理</a></li> -->
                    <%--<li><a _href="employee/admin-list.html" data-title="管理员列表" href="javascript:void(0)">管理员列表</a></li>--%>
                    <li><a _href="employee/dept-manage.html" data-title="部门管理" href="javascript:void(0)">部门管理</a></li>
                    <li><a _href="employee/member-list.html" data-title="员工管理" href="javascript:;">员工管理</a></li>
                </ul>
            </dd>
        </dl>

<%--
        <dl id="menu-system">
            <dt><i class="Hui-iconfont">&#xe62e;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul class="system">
                    <li><a _href="system/system-base.html" data-title="系统设置" href="javascript:void(0)">系统设置</a></li>
                    <li><a _href="system/system-data.html" data-title="数据字典" href="javascript:void(0)">数据字典</a></li>
                    <li><a _href="system/system-shielding.html" data-title="屏蔽词" href="javascript:void(0)">屏蔽词</a></li>
                    <li><a _href="system/system-log.html" data-title="系统日志" href="javascript:void(0)">系统日志</a></li>
                </ul>
            </dd>
        </dl>
--%>
    </div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
</div>
<section class="Hui-article-box">
    <div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
        <div class="Hui-tabNav-wp">
            <ul id="min_title_list" class="acrossTab cl">
                <li class="active"><span title="我的桌面" data-href="welcome.html">我的桌面</span><em></em></li>
            </ul>
        </div>
        <div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S"
                                                  href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a
                id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a>
        </div>
    </div>
    <div id="iframe_box" class="Hui-article">
        <div class="show_iframe">
            <div style="display:none" class="loading"></div>
            <iframe scrolling="yes" frameborder="0" src="welcome.html"></iframe>
        </div>
    </div>
</section>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/jquery.cookie.js"></script>
<script type="text/javascript" src="lib/layer/2.1/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
    $(function () {
        var dept_id = $("#dept_id").val();
        var emp_manager = $("#emp_manager").val();
        if (emp_manager == 0) {
            if (dept_id == 1) {
                $("#menu_article4").remove();
                $("#menu_article6").remove();
                $("#menu_article7").remove();
            } else if (dept_id == 2) {
                $("#menu_article1").remove();
                $("#menu_article3").remove();
                $("#menu_article6").remove();
                $("#menu_article7").remove();
            } else if (dept_id == 3) {
                $("#menu_article0").remove();
                $("#menu_article3").remove();
                $("#menu_article4").remove();
                $("#menu_article7").remove();
            } else if (dept_id == 4) {
                $("#menu_article0").remove();
                $("#menu_article1").remove();
                $("#menu_article3").remove();
                $("#menu_article4").remove();
                $("#menu_article6").remove();
            }
        }
    });
</script>

<script type="text/javascript">
    $(function () {
        /* var username = sessionStorage.getItem("username"); */
        var username = $("#emp_name").val();
        if (!username) {
            layer.alert("您还未登录，请先登录后再进行操作");
            window.location.href = "login.jsp";
            return;
        } else {
            $("#username").html(username + '<i class="Hui-iconfont">&#xe6d5;</i>');
        }
    });

    function logout() {
        sessionStorage.removeItem("username");
        sessionStorage.removeItem("userId");
        sessionStorage.removeItem("deptId");
        sessionStorage.removeItem("emp_manager");
        $.post("/user/logoutUser.do",function (data) {
            if(data.messageCode == 906){
                window.location.href = "login.jsp";
            }else {
                layer.alert("注销失败，请稍后再试！");
            }
        },"json");

    }

    /*查看信息*/
    function showMember(){
        var id = $("#emp_id").val();
        layer_show("查看信息" , "employee/member-show.html?id="+id , 600, 510 );
    }
</script>
<!-- <script type="text/javascript">
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s)})();
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E"));
</script> -->
</body>

<script type="text/javascript">

    //window.onload=createMessage();

    //function createMessage() {
    //    $.getJSON('scts.do',{"v":"createMessage"},function (data) {
    //    });
    //    setTimeout(getMessage,3000);
    //}
    //
    //function getMessage() {
    //	var num=0;
    //    $.getJSON('scts.do',{"v":"getMessage"},function (data) {
    //    	//遍历数据
    //    	num=data.length
    //    	$("#messagenum").html(num);
    //    });
    //}
    //参数
    function feed_add(title, url, w, h) {
        layer_show(title, url, w, h);
    }

</script>
</html>