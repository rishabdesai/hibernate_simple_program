package main;

import daos.EmpDeptDao;
import pojos.Dept;
import pojos.Emp;
import utils.HbUtil;

public class Hb01Main {
	public static void main(String[] args) {
		EmpDeptDao dao = new EmpDeptDao();
		
// OneToMany = one dept has MANY emp
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
		
		HbUtil.shutdown();
	}
}
