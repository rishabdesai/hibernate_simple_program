package main;

import daos.EmpDeptDao;
import pojos.Address;
import pojos.Emp;
import utils.HbUtil;

public class Hb01Main {
	public static void main(String[] args) {
		EmpDeptDao dao = new EmpDeptDao();
		

		try {
			HbUtil.beginTransaction();
			Emp e = dao.getEmp(7900);
			System.out.println(e);
			Address a = e.getAddr();
			System.out.println(a);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
		
		HbUtil.shutdown();
	}
}
