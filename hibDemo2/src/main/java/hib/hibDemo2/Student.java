package hib.hibDemo2;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
	
	@Id
	private int rno;
	private String name;
	private int age;
	@ManyToMany(mappedBy = "stu")
	private List<Laptop> lap = new ArrayList<>();
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
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
	
	
	public List<Laptop> getLap() {
		return lap;
	}
	public void setLap(List<Laptop> lap) {
		this.lap = lap;
	}
	@Override
	public String toString() {
		return "Student [rno=" + rno + ", name=" + name + ", age=" + age + "]";
	}

}
