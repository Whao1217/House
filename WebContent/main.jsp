<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>主页面</title>
</head>
	<%! String id;%>
	<%
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie :cookies)
		{
			if(cookie.getName().equals("id"))
			{
				id = cookie.getValue();
			}
		}
		%>
	<%
         Object message = request.getAttribute("message");
         if(message!=null && !"".equals(message)){
     
    %>
         <script type="text/javascript">
              alert("<%=request.getAttribute("message")%>");
         </script>
    <%} %>
<body>
	
	    <h2 >&nbsp&nbsp&nbsp欢迎工号为<%=id%>的管理员登录！</h2>
		<table border="6">
			<tr>
            	<td><h4><a href="addfangchan.jsp">新添房产信息</a></h4></td>
			</tr>
			<tr>
            	<td><h4><a href="addfangchanjingji.jsp">新增房产经纪人</a></h4></td>
			</tr>
			<tr>
            	<td><h4><a href="gukeshenheServlet">顾客审核</a></h4></td>
			</tr>
			<tr>
            	<td><h4><a href="showfangchanServlet">查询房产信息</a></h4></td>
			</tr>
			<tr>
            	<td><h4><a href="showfangchanServlet">停售房产</a></h4></td>
			</tr>
			<tr>
            	<td><h4><a href="showfangchanServlet">房产授权</a></h4></td>
			</tr>
			<tr>
            	<td><h4><a href="updateadminpassword.jsp">密码重置</a></h4></td>
			</tr>
		</table>
    </div>
</body>
</html>