package main;

import daos.EmpDeptDao;
import pojos.Dept;
import pojos.Emp;
import utils.HbUtil;

public class Hb01Main {
	public static void main(String[] args) {
		EmpDeptDao dao = new EmpDeptDao();
		

		try {
			HbUtil.beginTransaction();
			Emp e = dao.getEmp(7900);
			System.out.println("Found : " + e);
			Dept d = e.getDept();
			System.out.println("Found : " + d);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
		
		HbUtil.shutdown();
	}
}
