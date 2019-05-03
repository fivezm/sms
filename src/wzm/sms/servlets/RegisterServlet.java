package wzm.sms.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import wzm.sms.beans.Student;
import wzm.sms.service.IStudentService;
import wzm.sms.service.StudentServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.接受表单提交的参数
		request.setCharacterEncoding("utf-8");
		String num = request.getParameter("num");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		Integer age = Integer.parseInt(request.getParameter("age"));
		Double score = Double.parseDouble(request.getParameter("score"));
		
		
		//2.创建Student对象
		Student student = new Student(num, name, age, score);
		student.setPassword(password);
		//3.创建Serviece对象
		IStudentService service = new StudentServiceImpl();
		
		//4.调用service对象中的saveStudent();
		Integer id = null;
		id = service.saveStudent(student);
		//5.插入失败,重定向到register页面,并提示信息
		if(id == null) {
			response.sendRedirect(request.getContextPath()+"/register.jsp");
			return;
		}
		//6.插入成功,重定向到登录页面.
		HttpSession session = request.getSession();
		request.setAttribute("message", "注册成功");
		response.sendRedirect(request.getContextPath()+"/findAllStudent");
	}

}
