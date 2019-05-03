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

@WebServlet("/toFindNoPassStudents")
public class ToFindNoPassStudents extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建Service对象
		IStudentService service = new StudentServiceImpl();
		// 调用service对象中的findNoPassStudent()方法
		List<Student> students = service.findNoPassStudent();

		HttpSession session = request.getSession();
		session.setAttribute("noPassStudents", students);

		// 重定向到显示页
		response.sendRedirect(request.getContextPath() + "/noPassScore.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
