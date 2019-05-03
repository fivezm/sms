<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<br /><script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstra<p.min.js"></script>
<style type="text/css">
body{
	margin: 0;
	padding: 0;
	background: url(img/01.jpg);
}
.system{
	width: 1000px;
	height: auto;
	margin: 0 auto;
	text-align: center;
	border: 1px solid #E1E1E1;
	margin: 55px auto;
}

.system-top{
	width: auto;
	height: 100px;
	font-size: 60px;
	line-height: 100px;
	color: aliceblue;
	background-image: url(../img/背景2.jpg);
	
}

.system-nav{
	position:relative;
	width: auto;
	height: 60px;
	border: 1px solid #e1e1e1;
	
}

.system-nav a{
	text-decoration: none;
}

.system-nav .register, .system-nav .refer{
	line-height: 60px;
	word-spacing: 2em;
}

.system-nav .register{
	display: inline-block;
	width: 231px;
	height: auto;
}

.system-nav .refer{
	display: inline-block;
	width: 410px;
	height: auto;
}
.system-nav .admin{
	display: inline-block;
	width: 258px;
	height: auto;
}

.system-form{
	
	text-align: center;
	
}

.system-form .info{
	margin: 40px auto;
}

table th{
	width: 144px;
	height: 32px;
	text-align: center;
}

table caption{
	margin-bottom: 10px;
	color: #000;
}
table td:hover {
	background-color: #F60;
}

.system-nav div:hover{
	background-color: #00CC66;
} 

.navbar-default .navbar-nav > li > a {
    color: #fff;
}

.navbar-default {
    background-color: #5996bd;
}
				table thead tr:nth-of-type(1){
			background-color: skyblue;
		}	
</style>
<title>不及格的学生</title>
</head>
<body>
	<div class="system">

			<div class="">
				
                <nav class="navbar navbar-default" role="navigation" style="border-radius: 0;">
				  <div class="container-fluid">
				  	<div class="navbar-header">
						<a class="navbar-brand" href="${pageContext.request.contextPath }/findAllStudent" style="color: #fff;">学生管理系统</a>
					</div>
				    <ul class="nav navbar-nav navbar-right">
						<li><a href="${pageContext.request.contextPath }/toFindNoPassStudents"><span class="glyphicon"></span> 查询不及格学生</a></li>
				      <li><a href="${pageContext.request.contextPath }/findAllStudent"><span class="glyphicon"></span> 所有学生</a></li>
						<li><a href="${pageContext.request.contextPath }/register.jsp"><span class="glyphicon"></span> 学生注册</a></li>
				      <li><a href="${pageContext.request.contextPath }/findAllAdminServlet"><span class="glyphicon"></span> 所有管理员</a></li>
						<li><a href="${pageContext.request.contextPath }/adminRegister.jsp"><span class="glyphicon"></span> 管理员注册</a></li>
				      <li><a href="${pageContext.request.contextPath }/login.jsp"><span class="glyphicon"></span> 退出</a></li>
				    </ul>
				  </div>
				</nav>
			</div>
            	
			<div class="system-form">
				
				<table  class="info" border="1" cellspacing="0" cellpadding=""  >
					<caption>基本信息：</caption>
					<thead>
						<tr>
							<th>学号</th>
							<th>姓名</th>
							<th>密码</th>
							<th>年龄</th>
							<th>分数</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${noPassStudents }" var="student" varStatus="vs">
							<tr class="${ vs.count % 2 == 0 ? 'even':'odd'}">
								<td>${student.num }</td>
								<td>${student.name }</td>
								<td>${student.password }</td>
								<td>${student.age }</td>
								<td>${student.score }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
		</div>
</body>
</html>