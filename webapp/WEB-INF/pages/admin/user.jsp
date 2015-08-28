<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 2015/7/13 0013
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="${pageScope.basePath}/page.jsp"/>
    <title>用户列表</title>
    <script type="text/javascript" src="${pageScope.basePath}../jsbus/admin/user.js"></script>
</head>
<body>
<%--start--%>
<div id="dlg" class="easyui-dialog"
     style="width:400px;height:auto;padding:10px 20px" closed="true" buttons="#dlg-buttons">
    <form id="fm" method="post">
        <div style="margin: 10px auto;width: 350px;height: auto">
            <div class="control-group">
                <label class="control-label">用户名: </label>
                <input data-options="required:true,validType:'length[1,9]'" type="text" id="userName"
                       class="easyui-textbox" name="userName"/>
            </div>
            <div class="control-group">
                <label class="control-label">名称: </label>
                <input data-options="required:true,validType:'length[1,9]'" type="text" class="easyui-textbox"
                       name="userAlias">
            </div>
            <div class="control-group">
                <label class="control-label">邮箱: </label>
                <input data-options="validType:'email'" type="text" class="easyui-textbox" name="email">
            </div>
            <div class="control-group">
                <label class="control-label">电话号码: </label>
                <input data-options="required:true,validType:'phone'" type="text" class="easyui-textbox"
                       name="mobilePhone">
            </div>
            <div class="control-group">
                <label class="control-label">证件类型: </label>
                <input type="text" class="easyui-combobox" name="cardType" data-options="
                    data:[
                    {'id':'SFZ','text':'身份证'},
                    {'id':'JZ','text':'驾照'},
                    {'id':'LNZ','text':'老年证'},
                    {'id':'JGZ','text':'军官证'}
                    ],
                    valueField:'id',
					textField:'text',
					multiple:false,
					panelHeight:'auto'">
            </div>
            <div class="control-group">
                <label class="control-label">证件号码: </label>
                <input type="text" class="easyui-textbox" name="cardCode">
            </div>
            <div class="control-group">
                <label class="control-label">生日: </label>
                <input class="easyui-datebox" name="birthDate">
            </div>
            <div class="control-group">
                <label class="control-label">性别: </label>
                <input type="text" class="easyui-combobox" name="sex" data-options="
                    data:[
                    {'id':'0','text':'男'},
                    {'id':'1','text':'女'}
                    ],
                    valueField:'id',
					textField:'text',
					multiple:false,
					panelHeight:'auto'">
            </div>
        </div>
        <input type="hidden" name="userId">
    </form>
</div>
<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="saveUser()"
       style="width:90px">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
       onclick="javascript:$('#dlg').dialog('close')" style="width:90px">关闭</a>
</div>
<%--end--%>
<%--start--%>
<table id="user" style="width:auto;height:auto"></table>
<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="newUser()">新增</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'"
       onclick="editUser()">修改</a>
</div>
<%--end--%>

<script>
    var div;
    $(function () {
        if ($("table")) {
            div = $("table").attr("id")
        }
        $("#" + div).datagrid({
            title: "用户管理",
            url: 'findUserList.do',
            loadMsg: '数据装载中......',
            singleSelect: true,//为true时只能选择单行
            fitColumns: true,//允许表格自动缩放，以适应父容器
            collapsible: false,//显示可折叠按钮
            toolbar: '#toolbar',
            pagination: true,
            nowrap: true,
            striped: true,
            remoteSort: false,
            fit: true,
            rownumbers: true,
            columns: [[
                {
                    field: 'userId',
                    title: 'ID',
                    hidden: true
                }, {
                    field: 'password',
                    title: 'pwd',
                    hidden: true
                }, {
                    field: 'userName',
                    title: "名称",
                    align: 'center',
                    width: 200,
                    editor: 'text',
                    sortable: true
                }, {
                    field: "userDetail.cardCode",
                    title: "机构",
                    align: 'center',
                    width: 200,
                    editor: 'text',
                    sortable: true,
                    formatter: function (value, row, index) {
                        return row.userDetail.cardCode;
                    }
                }, {
                    field: 'createTime',
                    title: "创建时间",
                    align: 'center',
                    width: 200,
                    editor: 'datebox',
                    formatter: function (value, row, index) {
                        return dateformat(row.createTime)
                    },
                    sortable: true
                }, {
                    field: 'opt',
                    title: "详情",
                    width: 150,
                    align: 'center',
                    sortable: true,
                    formatter: function (value, row, index) {
                        var e = '<a href="javascript:void(0)" class="l-btn-text" onclick="viewRow(' + index + ')">角色</a> ';
                        var d = '<a href="javascript:void(0)" class="l-btn-text" onclick="viewDepartRow(' + index + ')">机构</a> ';
                        return e + d;
                    }
                }
            ]]
        });
    });
</script>
</body>
</html>
