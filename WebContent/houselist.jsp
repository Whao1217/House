<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>房产信息列表</title>
</head>
<body>
    <div align="center">
        <h1 style="color: black;">信息列表</h1>
        <a href="main.jsp"><div style="color: black;">返回主页</div></a>
        <br>
        <table border="6">
            <tr>
                <td>序号</td>
                <td>房产地址</td>
                <td>销售报价</td>
                <td>顾客ID</td>

            </tr>
            <c:forEach items="${gukes}" var="item" varStatus="status">
                <tr>
                    <td>${item.HouseID}</td>
                    <td><a href="fangchanlistMORE.jsp?HouseID=${item.HouseID}&Address=${item.Address}&Sales=${item.Sales}&UserID=${item.UserID}&RoomType=${item.RoomType}&Year=${item.Year}&Area=${item.Area}&Status=${item.Status}&AgentID=${item.AgentID}"><div style ="color:black;">${item.Address}</div></td>
                    <td>${item.Sales}</td>
                    <td>${item.UserID}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>