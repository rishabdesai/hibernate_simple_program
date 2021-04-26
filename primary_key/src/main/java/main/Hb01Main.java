package main;

import daos.BookDao;
import daos.StudentDao;
import pojos.Book;
import pojos.Student;
import utils.HbUtil;

public class Hb01Main {
	public static void main(String[] args) {
		
		BookDao dao = new BookDao();
		try {
			HbUtil.beginTransaction();
			Book b = new Book(0, "Atlas Shrugged", "Rand", "Novell", 723.23);
			dao.addBook(b);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
		
//		try {
//			HbUtil.beginTransaction();
//			List<Book> list = dao.getBooks();
//			for (Book b : list)
//				System.out.println(b);
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}
		
		
//		StudentDao dao = new StudentDao();
//		try {
//			HbUtil.beginTransaction();
//			Student st = dao.getStudent(2, 1);
//			System.out.println("Found : " + st);
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}
		HbUtil.shutdown();
	}
}
