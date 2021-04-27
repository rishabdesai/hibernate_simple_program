package main;

import java.util.Date;

import daos.EmpDeptDao;
import pojos.Emp;
import pojos.Meeting;
import utils.HbUtil;

public class Hb01Main {
	public static void main(String[] args) {
		EmpDeptDao dao = new EmpDeptDao();
		

		//MantToMany - For given emp, find all meetings
//		try {
//		HbUtil.beginTransaction();
//		Emp e = dao.getEmp(7934);
//		System.out.println(e);
//		for(Meeting m : e.getMeetings())
//			System.out.println(m);
//		HbUtil.commitTransaction();
//	} catch (Exception e) {
//		e.printStackTrace();
//		HbUtil.rollbackTransaction();
//	}
		
		
		// ManyToMany - for given meeting, find all emp names
//		try {
//		HbUtil.beginTransaction();
//		Meeting m = dao.getMeeting(2);
//		System.out.println(m);
//		for(Emp e : m.getEmpList())
//			System.out.println(e);
//		HbUtil.commitTransaction();
//	} catch (Exception e) {
//		e.printStackTrace();
//		HbUtil.rollbackTransaction();
//	}
		
	// add meeting along with emp
		try {
		HbUtil.beginTransaction();
		//add emp in meeting
		Meeting m = new Meeting(3, "Client", new Date());
		m.getEmpList().add(dao.getEmp(7844));
		m.getEmpList().add(dao.getEmp(7934));
		m.getEmpList().add(dao.getEmp(7654));
		//add meeting to emp
		for (Emp e : m.getEmpList())
			e.getMeetings().add(m);
		dao.addMeeting(m);
		HbUtil.commitTransaction();
	} catch (Exception e) {
		e.printStackTrace();
		HbUtil.rollbackTransaction();
	}
		
		
		HbUtil.shutdown();
	}
}
