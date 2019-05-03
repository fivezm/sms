package wzm.sms.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wzm.sms.beans.Student;
import wzm.sms.service.IStudentService;
import wzm.sms.service.StudentServiceImpl;


@WebServlet("/deleteStudentServlets")
public class DeleteStudentServlets extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 创建Service对象
				IStudentService service = new StudentServiceImpl();
				int id = Integer.parseInt(request.getParameter("id"));
				
				service.removeStudent(id);
				
				// 遍历所有的学生
				List<Student> students = service.findAllStudent();
				HttpSession session = request.getSession();
				session.setAttribute("students", students);

				// 重定向到显示页
				response.sendRedirect(request.getContextPath() + "/index.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
