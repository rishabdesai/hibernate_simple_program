package daos;

import org.hibernate.Session;

import pojos.Emp;
import utils.HbUtil;

public class EmpDeptDao {
	public Emp getEmp(int empno) {
		Session session = HbUtil.getSession();
		return session.get(Emp.class, empno);
	}
	

}
