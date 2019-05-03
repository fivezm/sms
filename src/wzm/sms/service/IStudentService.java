package wzm.sms.service;

import java.util.List;

import wzm.sms.beans.Admin;
import wzm.sms.beans.Student;

public interface IStudentService {

	//验证是否有这人
	Student checkStudent(String num, String password);
	
	Admin checkAdmin(String num,String password);

	//增
	Integer saveStudent(Student student);
	
	Integer saveAdmin(Admin admin);
	
	//删除指定id
	void removeStudent(int id);
	
	void removeAdmin(int id);
	
	//查所有
	List<Student> findAllStudent();
	
	List<Admin> findAllAdmin();
	
	List<Student> findNoPassStudent();
	
	//修改
	Student alterStudent(int id,double score);
	
	Admin alterAdminPas(int id,String newPas);


}
