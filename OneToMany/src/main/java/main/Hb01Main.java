package main;

import daos.EmpDeptDao;
import pojos.Dept;
import pojos.Emp;
import utils.HbUtil;

public class Hb01Main {
	public static void main(String[] args) {
		EmpDeptDao dao = new EmpDeptDao();

		
		//get emp using empno
//		try {
//			HbUtil.beginTransaction();
//			Emp e = dao.getEmp(7900);
//			System.out.println("Found : " + e);
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}
		
		//get dept based on deptno
//		try {
//		HbUtil.beginTransaction();
//		Dept d = dao.getDept(10);
//		System.out.println("Found : " + d);
//		HbUtil.commitTransaction();
//	} catch (Exception e) {
//		e.printStackTrace();
//		HbUtil.rollbackTransaction();
//	}
		
 //OneToMany = one dept has MANY emp
 //get deptno=10 and find all emp with same deptno.
		try {
			HbUtil.beginTransaction();
			Dept d = dao.getDept(10);
			System.out.println("Found : " + d);
			for (Emp e : d.getEmpList())
				System.out.println(e);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
		
		
//		try {
//			HbUtil.beginTransaction();
//			Emp e = dao.getEmp(7900);
//			System.out.println("Found : " + e);
//			int d = e.getDeptno();
//			System.out.println("Found : " + d);
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}
		
		HbUtil.shutdown();
	}
}
