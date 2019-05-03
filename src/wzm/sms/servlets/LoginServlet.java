package wzm.sms.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wzm.sms.beans.Admin;
import wzm.sms.beans.Student;
import wzm.sms.service.IStudentService;
import wzm.sms.service.StudentServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.接受提交的参数
		String num = request.getParameter("num");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		if(num == null || "".equals(num.trim())) {
			session.setAttribute("message", "用户名不能为空");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		if(password == null || "".equals(password.trim())) {
			session.setAttribute("message", "密码不能为空");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		
		//2.创建Service对象
		IStudentService service = new StudentServiceImpl();
		
		//3.调用service对象中的checkStudent()方法
		Admin admin = service.checkAdmin(num, password);
		session.setAttribute("target", admin);

		//4.验证失败,重定向到login.jsp页面,并给用户提示信息
		if(admin == null) {
			session.setAttribute("message", "用户名或密码错误");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		
		
		// 遍历所有的学生
		List<Student> students = service.findAllStudent();
		session.setAttribute("students", students);
		
		//5.验证通过,重定向到index.jsp页面.
			response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
