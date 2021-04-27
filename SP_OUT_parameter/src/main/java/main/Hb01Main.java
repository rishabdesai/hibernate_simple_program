package main;

import daos.BookDao;
import utils.HbUtil;

public class Hb01Main {
	public static void main(String[] args) {

		BookDao dao = new BookDao();
		try {
			HbUtil.beginTransaction();
			Double price = dao.getBookPrice5(11);
			System.out.println("Book Price : " + price);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}

		HbUtil.shutdown();
	}
}
