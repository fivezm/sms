<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.odd {
	background-color: #eeeeee
}

.even {
	background-color:
}
</style>
<title>Insert title here</title>
</head>
<body>
	登录成功 ${target.name }
	<br>
	<br>
	<a href="${pageContext.request.contextPath }/findAllStudent">刷新</a>
	<a href="${pageContext.request.contextPath }/toFindNoPassStudents">查看不及格的学生</a>
	<a href="${pageContext.request.contextPath }/register.jsp">注册</a>
	<a href="${pageContext.request.contextPath }/login.jsp">退出</a>
	<table border="1" cellspacing="0">
		<tr>
			<th>id</th>
			<th>学号</th>
			<th>姓名</th>
			<th>密码</th>
			<th>年龄</th>
			<th>分数</th>
			<th>删除该学生</th>
			<th colspan="3">修改分数</th>
		</tr>

		<c:forEach items="${students }" var="student" varStatus="vs">
			<tr class="${ vs.count % 2 == 0 ? 'even':'odd'}">

				<form method="post"
					action="${pageContext.request.contextPath }/deleteStudentServlets">
					<input type="hidden" name="id" value=${student.id }>
					<td>${student.id }</td>
					<td>${student.num }</td>
					<td>${student.name }</td>
					<td>${student.password }</td>
					<td>${student.age }</td>
					<td>${student.score }</td>
					<td><input type="submit" value="删除学生"></td>
				</form>
				<form method="post"
					action="${pageContext.request.contextPath }/updataStuent">
					<td><input type="hidden" name="id" value=${student.id }>
						<input type="text" name="newScore"> <input type="submit"
						value="更改成绩"></td>
				</form>


			</tr>
		</c:forEach>
	</table>

</body>
</html>