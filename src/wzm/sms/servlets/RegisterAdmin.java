package wzm.sms.servlets;

import java.io.IOException;
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

@WebServlet("/registerAdmin")
public class RegisterAdmin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.接受表单提交的参数
		request.setCharacterEncoding("utf-8");
		String num = request.getParameter("admin_num");
		String password = request.getParameter("password");
		String admin_name = request.getParameter("admin_name");

		System.out.println(num);
		System.out.println(num+" "+ password+" "+ admin_name);
		
		//2.创建Admin对象
		Admin admin = new Admin(num, password, admin_name);
		//3.创建Serviece对象
		IStudentService service = new StudentServiceImpl();
		
		//4.调用service对象中的saveStudent();
		Integer id = null;
		id = service.saveAdmin(admin);
		//5.插入失败,重定向到register页面,并提示信息
		if(id == null) {
			response.sendRedirect(request.getContextPath()+"/adminRegister.jsp");
			return;
		}
		//6.插入成功,重定向到登录页面.
		HttpSession session = request.getSession();
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
