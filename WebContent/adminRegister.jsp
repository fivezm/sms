<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员注册</title>
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
			<p>*管理员注册</p>	
			</div>
			<br />
			<div id="landing-info">
				<form action="${pageContext.request.contextPath }/registerAdmin" method="post">
					姓名： <input type="text" placeholder="请输入你的名字" maxlength="12"
							name="admin_name" /><br>
					
					<p>账号：
					<input type="text" maxlength="12"  placeholder="请输入你的学号" name="admin_num"/>
					</p>
					
		            <p>密码：
					<input type="password"  placeholder="密码为3-6位" name="password"  />
					</p>
					
					<p>
						<input type="checkbox" id="bangding"  checked="checked" />
						<label for="bangding">同意项目条款及服务类型</label>
					</p>
					
					<p>
						<input type="submit" value="注册" style="width:80px;height:40px;font-size: 20px;"/>
					</p>
				</form>
			</div>		

		</div>
</body>
</html>