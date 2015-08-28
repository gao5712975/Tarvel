<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 2015/7/10 0010
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <meta http-equiv="Cache-Control" content="no-store" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
    <jsp:include page="${pageScope.basePath}/page.jsp"/>
    <title></title>
    <script type="text/javascript" src="${pageScope.basePath}js/easyui/easyuiTab.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
<div region="west" hide="true" split="true" title="导航菜单" style="width: 220px;" id="west">
    <div id="nav" class="easyui-accordion" fit="true" border="false">
        <script>
            var _menus = {
                "menus": [{
                    "menuid": "3",
                    "icon": "icon-nav",
                    "menuname": "系统管理",
                    "menus": [{
                        "menuid": "301",
                        "menuname": "用户列表",
                        "icon": "icon-biaogege",
                        "url": "admin/findUserListView.do"
                    }, {
                        "menuid": "302",
                        "menuname": "链接管理",
                        "icon": "icon-biaogege",
                        "url": "admin/findPurviewListView.do"
                    },
                        {
                            "menuid": "303",
                            "menuname": "角色管理",
                            "icon": "icon-biaogege",
                            "url": "admin/findRoleListView.do"
                        }
                    ]
                }]
            };
        </script>
    </div>
</div>
<%--<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>--%>
<%--<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>--%>
<div id="mainPanle" region="center" style="background: #eee; overflow-y: hidden">
    <div id="tabs" class="easyui-tabs" fit="true" border="false">
        <div title="欢迎使用">

        </div>
    </div>
</div>
<div id="mm" class="easyui-menu" style="width: 150px;">
    <div id="mm-tabupdate">刷新</div>
    <div class="menu-sep"></div>
    <div id="mm-tabclose">关闭</div>
    <div id="mm-tabcloseall">全部关闭</div>
    <div id="mm-tabcloseother">除此之外全部关闭</div>
    <div class="menu-sep"></div>
    <div id="mm-tabcloseright">当前页右侧全部关闭</div>
    <div id="mm-tabcloseleft">当前页左侧全部关闭</div>
    <div class="menu-sep"></div>
    <div id="mm-exit">退出</div>
</div>
</body>
</html>
