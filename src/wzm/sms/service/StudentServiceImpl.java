package wzm.sms.service;

import java.util.List;

import wzm.sms.beans.Admin;
import wzm.sms.beans.Student;
import wzm.sms.dao.IStudentDao;
import wzm.sms.dao.StudentDaoImpl;

public class StudentServiceImpl implements IStudentService {
	private IStudentDao dao;

	public StudentServiceImpl() {
		dao = new StudentDaoImpl();
	}

	@Override
	public Student checkStudent(String num, String password) {
		return dao.selectStudentLogin(num, password);
	}

	@Override
	public Integer saveStudent(Student student) {
		return dao.insertStudent(student);
	}
	
	@Override
	public Integer saveAdmin(Admin admin) {
		return dao.insertAdmin(admin);
	}
	
	@Override
	public List<Student> findNoPassStudent() {
		return dao.findStudent();
	}

	@Override
	public void removeStudent(int id) {
		 dao.deleteStudent(id);
	}
	
	@Override
	public void removeAdmin(int id) {
		dao.deleteAdmin(id);
		
	}

	@Override
	public List<Student> findAllStudent() {
		return dao.tofindAllStudent();
	}
	
	@Override
	public List<Admin> findAllAdmin() {
		return dao.tofindAllAdmin();
	}
	
	@Override
	public Student alterStudent(int id,double score) {
		return dao.updataStudent(id,score);
	}

	@Override
	public Admin checkAdmin(String num, String password) {
		return dao.selectAdmin(num,password);
	}

	@Override
	public Admin alterAdminPas(int id, String newPas) {
		return dao.updataAdminPas(id,newPas);
	}







}
