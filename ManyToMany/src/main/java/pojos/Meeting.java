package pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MEETING")
public class Meeting {
	@Id
	@Column
	private int id;
	@Column
	private String subject;
	@Column
	private Date meetDate;
	@ManyToMany(mappedBy = "meetings")
	private List<Emp> empList;
	
	public Meeting() {
		this(0, "", new Date());
	}

	public Meeting(int id, String subject, Date meetDate) {
		this.id = id;
		this.subject = subject;
		this.meetDate = meetDate;
		this.empList = new ArrayList<Emp>();
	}
	
	public Meeting(int id, String subject, Date meetDate, List<Emp> empList) {
		this.id = id;
		this.subject = subject;
		this.meetDate = meetDate;
		this.empList = empList;
	}

	public List<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getMeetDate() {
		return meetDate;
	}

	public void setMeetDate(Date meetDate) {
		this.meetDate = meetDate;
	}

	@Override
	public String toString() {
		return String.format("Meeting [id=%s, subject=%s, meetDate=%s]", id, subject, meetDate);
	}
}
