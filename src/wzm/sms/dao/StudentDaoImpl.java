package wzm.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import wzm.sms.beans.Admin;
import wzm.sms.beans.Student;
import wzm.sms.utils.jdbcUtils;

public class StudentDaoImpl implements IStudentDao {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public Student selectStudentLogin(String num, String password) {
		Student student = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from student where num=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				student = new Student();
				student.setNum(rs.getString("num"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				student.setScore(rs.getDouble("score"));
				student.setId(rs.getInt("id"));
				student.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				jdbcUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return student;
	}
	
	@Override
	public Admin selectAdmin(String num, String password) {
		Admin admin = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from admin where admin_num=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				admin = new Admin();
				admin.setNum(rs.getString("admin_num"));
				admin.setAdmin_name(rs.getString("admin_name"));
				admin.setId(rs.getInt("id"));
				admin.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				jdbcUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return admin;
	}

	@Override
	public Integer insertStudent(Student student) {
		Integer id = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "insert into student(num,password,name,age,score) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getNum());
			ps.setString(2, student.getPassword());
			ps.setString(3, student.getName());
			ps.setInt(4, student.getAge());
			ps.setDouble(5, student.getScore());
			ps.executeUpdate();

			sql = "select @@identity newId";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("newId");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				jdbcUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}
	
	@Override
	public Integer insertAdmin(Admin admin) {
		Integer id = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "insert into admin(admin_num,password,admin_name) values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getNum());
			ps.setString(2, admin.getPassword());
			ps.setString(3, admin.getAdmin_name());
			ps.executeUpdate();

			sql = "select @@identity newId";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("newId");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				jdbcUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}
	@Override
	public List<Student> findStudent() {
		ArrayList<Student> students = new ArrayList<>();
		Student student = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from student where score < 60";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				student = new Student();
				student.setNum(rs.getString("num"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				student.setScore(rs.getDouble("score"));
				student.setId(rs.getInt("id"));
				student.setPassword(rs.getString("password"));
				students.add(student);
			}
			for (Student s : students) {
				System.out.println(s.getName() + " " + s.getScore());
			}
			System.out.println(students.size());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				jdbcUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return students;
	}

	@Override
	public void deleteStudent(int id) {
		boolean isDeleted = false;
		try {
			conn = jdbcUtils.getConnection();
			String sql = " delete from student where id = "+id;
			ps = conn.prepareStatement(sql);
			isDeleted=ps.execute();
			if (isDeleted) {
				System.out.println("删除成功!!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				jdbcUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void deleteAdmin(int id) {
		boolean isDeleted = false;
		try {
			conn = jdbcUtils.getConnection();
			String sql = " delete from admin where id = "+id;
			ps = conn.prepareStatement(sql);
			isDeleted=ps.execute();
			if (isDeleted) {
				System.out.println("删除成功!!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				jdbcUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Student> tofindAllStudent() {
		List<Student> students = new ArrayList<>();
		Student student;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from student";
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				student = new Student();
				student.setNum(rs.getString("num"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				student.setScore(rs.getDouble("score"));
				student.setId(rs.getInt("id"));
				student.setPassword(rs.getString("password"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				jdbcUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return students;
	}
	@Override
	public List<Admin> tofindAllAdmin() {
		List<Admin> admins = new ArrayList<>();
		Admin admin = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select * from admin";
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				admin = new Admin();
				admin.setNum(rs.getString("admin_num"));
				admin.setAdmin_name(rs.getString("admin_name"));
				admin.setId(rs.getInt("id"));
				admin.setPassword(rs.getString("password"));
				admins.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				jdbcUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return admins;
	}

	public Student updataStudent(int id, double score) {
		Student student = null;
		boolean isUpdata = false;
		try {
			conn = jdbcUtils.getConnection();
			String sql = " update student set score="+score+"where id = " +id;
			ps = conn.prepareStatement(sql);
			isUpdata=ps.execute();
			if (isUpdata) {
				System.out.println("修改成功!!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				jdbcUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return student;
	}

	@Override
	public Admin updataAdminPas(int id, String newPas) {
		Admin admin = null;
		boolean isUpdata = false;
		try {
			conn = jdbcUtils.getConnection();
			String sql = " update admin set password = '"+ newPas +"' where id = "+ id;
			ps = conn.prepareStatement(sql);
			isUpdata=ps.execute();
			if (isUpdata) {
				System.out.println("修改成功!!!");
			}else {
				System.out.println(id);
				System.out.println("修改失败!!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				jdbcUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return admin;
	}










}
