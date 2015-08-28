/*start add*/
var url = "";
function newUser() {
    $('#dlg').dialog('open').dialog('setTitle', '新增用户');
    $('#fm').form('clear');
    url = 'insertUser.do';
}
function editUser() {
    var row = $('#' + div).datagrid('getSelected');
    if (row) {
        console.log(row);
        $('#dlg').dialog('open').dialog('setTitle', '修改用户');
        $('#fm').form('load', {
            userName: row.userName,
            userAlias: row.userDetail.userAlias,
            email: row.userDetail.email,
            cardType: row.userDetail.cardType,
            mobilePhone: row.userDetail.mobilePhone,
            sex: row.userDetail.sex,
            cardCode: row.userDetail.cardCode,
            birthDate: dateformat(row.userDetail.birthDate)
        });
        $("input[name=userId]").val(row.userId);
        url = 'updateUser.do';
    }
}
function saveUser() {
    $('#fm').form('submit', {
        url: url,
        onSubmit: function () {
            return $(this).form('validate');
        },
        success: function (data) {
            location.reload();
        }
    });
}
/*end*/
