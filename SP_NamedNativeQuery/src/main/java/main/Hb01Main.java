package main;

import java.util.List;

import daos.BookDao;
import pojos.Book;
import utils.HbUtil;

public class Hb01Main {
	public static void main(String[] args) {

		BookDao dao = new BookDao();
		try {
			HbUtil.beginTransaction();
			List<Book> list = dao.getBooksByAuthor("Kanetkar");
			for (Book b : list)
				System.out.println(b);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}

		HbUtil.shutdown();
	}
}
