<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
<style type="text/css">
body {
	background-image: url(img/02.jpg);
}

.landing {
	width: 400px;
	height: 200px;
	background-color: aliceblue;
	/*border: 1px solid;*/
	margin: 150px auto;
	border-radius: 6%;
}

.info {
	width: auto;
	height: 200px;
	text-align: center;
}

.landing-nav {
	width: 400px;
	height: 40px;
	text-align: center;
	padding-top: 4px;
	border-bottom: deepskyblue solid;
}
</style>
</head>
<body>
	<div class="landing">
		<div class="landing-nav">
			<p>管理员登录</p>
		</div>

		<div class="info">
			${message }<br>
			<div class="xuehao">
				<form method="post"
					action="${pageContext.request.contextPath }/loginServlet">
					<p>
						账号： <input type="text" placeholder="请输入你的账号" maxlength="12"
							name="num" />
					</p>
					<p>
						密码： <input type="password" placeholder="密码3-6位" maxlength="18"
							name="password" />
					</p>
					<div class="button">
						<input type="reset" value="重置" /> <input type="submit" value="登陆" />

					</div>
				</form>
			</div>
		</div>
</body>
</html>