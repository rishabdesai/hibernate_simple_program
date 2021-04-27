package daos;

import org.hibernate.Session;

import pojos.Dept;
import pojos.Emp;
import pojos.Meeting;
import utils.HbUtil;

public class EmpDeptDao {
	public Emp getEmp(int empno) {
		Session session = HbUtil.getSession();
		return session.get(Emp.class, empno);
	}
	
	public Dept getDept(int deptno) {
		Session session = HbUtil.getSession();
		return session.get(Dept.class, deptno);
	}
	
	public Meeting getMeeting(int meetingId) {
		Session session = HbUtil.getSession();
		return session.get(Meeting.class, meetingId);
	}

	public void addMeeting(Meeting m) {
		Session session = HbUtil.getSession();
		session.persist(m);
	}

}
