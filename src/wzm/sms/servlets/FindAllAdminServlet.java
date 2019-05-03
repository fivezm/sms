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


@WebServlet("/findAllAdminServlet")
public class FindAllAdminServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 2.创建Service对象
				IStudentService service = new StudentServiceImpl();
				HttpSession session = request.getSession();
				// 遍历所有的学生
				 List<Admin> admins = service.findAllAdmin();
				session.setAttribute("admins", admins);
				for(Admin a:admins) {
					System.out.println(a.getAdmin_name());
				}
				// 5.验证通过,重定向到allAdmin.jsp页面.
				response.sendRedirect(request.getContextPath() + "/allAdmin.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
