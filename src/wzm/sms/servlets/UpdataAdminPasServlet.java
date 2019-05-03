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

@WebServlet("/updataAdminPasServlet")
public class UpdataAdminPasServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建Service对象
		IStudentService service = new StudentServiceImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		String newPas = request.getParameter("newPas");
		Admin admin = service.alterAdminPas(id, newPas);

		response.sendRedirect(request.getContextPath() + "/findAllAdminServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
