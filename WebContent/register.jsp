<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册学生</title>
<style type="text/css">
			body{
	background-image: url(img/02.jpg);
	
	background-repeat: no-repeat;
	 background-size: cover;
}

#landing{
	width: 400px;
	height: 350px;
	text-align: center;
	border: 0px ;
	background-color: aliceblue;
	border-radius: 4%;
	margin: 100px auto;
}

#landing-top{
	width: 400px;
	height: 80px;
	font-size: 30px ;
	font-family: "微软雅黑";
	padding-top: 10px;
	color: white;
	background-color: deepskyblue ;

}
			
		</style>
</head>
<body>
	
	<div id="landing">
			 
			<div id="landing-top">
			<p>*注册学生</p>	
			</div>
			<br />
			<div id="landing-info">
					${message }<br>
				<form action="${pageContext.request.contextPath }/registerServlet" method="post">
						学号 :   <input type="text" name="num" ><br>
						密码 :   <input type="password" name="password" ><br>
						姓名 :   <input type="text" name="name" ><br>
						年龄 :   <input type="text" name="age" ><br>
						成绩 :   <input type="text" name="score" ><br>
						<input type="submit" value="注册" style="width:80px;height:40px;font-size: 20px;"><br>
				
				</p>
				</form>
			</div>		
  
		</div>
</body>
</html>