package wzm.sms.dao;

import java.util.List;

import wzm.sms.beans.Admin;
import wzm.sms.beans.Student;

public interface IStudentDao {

	Student selectStudentLogin(String num, String password);

	Integer insertStudent(Student student);
	
	Integer insertAdmin(Admin admin);
	
	List<Student> findStudent();
	
	void deleteStudent(int id);
	
	void deleteAdmin(int id);

	List<Student> tofindAllStudent();

	List<Admin> tofindAllAdmin();
	
	Student updataStudent(int id, double score);

	Admin selectAdmin(String num, String password);

	Admin updataAdminPas(int id, String newPas);





}
