<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加房产经纪人信息</title>
</head>
	
	<%
         Object message = request.getAttribute("message");
         if(message!=null && !"".equals(message)){
     
    %>
         <script type="text/javascript">
              alert("<%=request.getAttribute("message")%>");
         </script>
    <%} %>
<body>
	<form action="addfhousejingliServlet" method="post">
	<div align="center">
	    <h1 style="color: black;">&nbsp&nbsp&nbsp欢迎进行房产经纪人信息添加！</h1>
	    <a href="main.jsp"><div style="color: black;">返回主页</div></a>
	       <br>
		<table border="6px">
			<tr>
            	<td><h4><div style="color: black;">工号：</div></h4></td>
            	<td><input type="text" name="AgentID" maxlength="8" required  placeholder="八位数字:年份+四位序号"/></td>
			</tr>
			<tr>
            	<td><h4><div style="color: black;">姓名：</div></h4></td>
            	<td><input type="text" name="AgentName"  required  placeholder="请输入姓名"/></td>
			</tr>
			<tr>
            	<td><h4><div style="color: black;">地址：</div></h4></td>
            	<td><input type="text" name="AgentAddress" required placeholder="请输入地址"/></td>
			</tr>
			<tr>
            	<td><h4><div style="color: black;">电话：</div></h4></td>
            	<td><input type="text" name="Phone"  required  placeholder="请输入电话" /></td>
			</tr>
			<tr>
				<td></td>
				<td>
				<button type="submit">提&nbsp&nbsp&nbsp交</button>
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<button type="reset">清&nbsp&nbsp&nbsp空</button>
				</td>
			</tr>
		</table>
    </div>
    </form>
</body>
</html>