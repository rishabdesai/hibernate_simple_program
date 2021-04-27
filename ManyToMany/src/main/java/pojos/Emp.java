package pojos;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "EMP")
public class Emp {
	@Id
	private int empno;
	@Column
	private String ename;
	@Column
	private String job;
	@Column
	private Integer mgr;
	@Column
	private Date hire;
	@Column
	private Double sal;
	@Column
	private Double comm;
	
//	@Column
//	private int deptno;  //foreign key field

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="deptno") //deptno = foreign key COLUMN of emp table
	private Dept dept;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Address addr;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="EMPMEETING", 
		joinColumns= { @JoinColumn(name="empid")}, 
		inverseJoinColumns= { @JoinColumn(name="meetingid") })
	private List<Meeting> meetings;

	
	public Emp() {
	}
	
	public List<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}
	
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public Date getHire() {
		return hire;
	}

	public void setHire(Date hire) {
		this.hire = hire;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hire=" + hire
				+ ", sal=" + sal + ", comm=" + comm + ", dept=" + dept + "]";
	}
	
	
}