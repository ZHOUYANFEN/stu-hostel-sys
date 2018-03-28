<%--
  Created by IntelliJ IDEA.
  User: toplinker
  Date: 2018/3/12
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>Admin</title>
</head>
<body>
    <div>
        <form name="addForm" id="adminForm">
            user_name<input id="user_name" type="text"/>
            user_password<input id="user_password" type="text"/>
            <button onclick="saveAdmin()">Save Admin</button>
        </form>
        <form name="getAdminList" id="getAdminList">
            <button type="button" onclick="getAdminList()">getAdmin List</button>
        </form>
    </div>
    <script type="text/javascript" src="<%=path%>/jquery-3.3.1.min.js"></script>
    <script>
        function saveAdmin() {
            var user_name = $("#user_name").val();
            var user_password = $("#user_password").val();
            var admin = {
                'user_name': user_name,
                'user_password': user_password
            };
            $.ajax({
                type: "post",
                contentType: "application/json;charset=utf-8", // WebService 会返回Json类型
                url: "http://localhost:8080<%=path%>/saveAdmin", //调用WebService
                data: admin, //参数
                dataType: 'json',
                error: function(x, e) {
                    alert("我屮艸芔茻！saveAdmin");
                },
                success: function(response) { //回调函数，result，返回值
                    alert("saveAdmin" + response);
                }
            });
        };
    </script>
    <script>
        function getAdminList() {
            $.ajax({
                type: "get",
                contentType: "application/json;charset=utf-8", // WebService 会返回Json类型
                url: "http://localhost:8080<%=path%>/getAdminList", //调用WebService
                data: "", //参数
                dataType: 'json',
                error: function(x, e) {
                    alert("我屮艸芔茻！getAdminList");
                },
                success: function(response) { //回调函数，result，返回值
                    alert("getAdminList" + response);
                }
            });
        }
    </script>
</body>
</html>
