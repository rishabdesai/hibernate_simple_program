package pojos;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS")
public class Student {
	@EmbeddedId
	private StudStdRoll id;
	@Column
	private String name;
	@Column
	private double marks;
	
	public Student() {
		this(new StudStdRoll(), "", 0.0);
	}
	public Student(StudStdRoll id, String name, double marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
	public StudStdRoll getId() {
		return id;
	}
	public void setId(StudStdRoll id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}
}
