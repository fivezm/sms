package wzm.sms.beans;

import java.io.Serializable;

public class Student implements Serializable {
	private Integer id;
	private String num;
	private String password;
	private String name;
	private int age;
	private Double score;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Student(String num, String name, int age, Double score) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.score = score;
	}
	public Student() {
		super();
	}
	
	
}
