package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPADDRESS")
public class Address {
	@Id
	@Column
	private int empid;
	@Column
	private String addr;
	@Column
	private String country;
	
	@OneToOne(mappedBy = "addr")
	private Emp emp;
	
	
	public Address() {
		this(0, "", "", new Emp());
	}
	public Address(int empid, String addr, String country, Emp emp) {
		this.empid = empid;
		this.addr = addr;
		this.country = country;
		this.emp = emp;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	@Override
	public String toString() {
		return String.format("Address [empid=%s, addr=%s, country=%s, emp=%s]", empid, addr, country, emp);
	}
}
