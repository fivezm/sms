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

@WebServlet("/deleteAdminServlet")
public class DeleteAdminServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 创建Service对象
		IStudentService service = new StudentServiceImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		
		service.removeAdmin(id);;
		
		// 找出所有的管理员
		List<Admin> admins = service.findAllAdmin();
		HttpSession session = request.getSession();
		session.setAttribute("admins", admins);

		// 重定向到 findAlladminServlet刷新页面
		response.sendRedirect(request.getContextPath() + "/findAllAdminServlet");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
