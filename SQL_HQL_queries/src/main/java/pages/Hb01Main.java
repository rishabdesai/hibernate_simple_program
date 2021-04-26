package pages;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class Hb01Main {

	public static void main(String[] args) {

//1. using SQL query
//	try {
//		BookDao dao= new BookDao();
//		HbUtil.beginTransaction();
//		List<String> list = dao.getAuthors();
//		System.out.println(list);
//		HbUtil.commitTransaction();
//		
//	}catch(Exception e) {
//		e.printStackTrace();
//		HbUtil.rollbackTransaction();
//		}
		
//2. HQL query for select	
//		BookDao dao = new BookDao();
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
		
//3 HQL	query -select book by subject 
//		BookDao dao = new BookDao();
//		try {
//			HbUtil.beginTransaction();
//			List<Book> list = dao.getSubjectBooks("OS");
//			for (Book b : list)
//				System.out.println(b);
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}
		
//4 HQL query - slect by subject and author name 
//		BookDao dao = new BookDao();
//		try {
//			HbUtil.beginTransaction();
//			List<Book> list = dao.getSubjectAuthorBooks("C", "Kanetkar");
//			for (Book b : list)
//				System.out.println(b);
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}
		
//5 select distinct subject using namedQuery
//		BookDao dao = new BookDao();
//		try {
//			HbUtil.beginTransaction();
//			List<String> list = dao.getDistinctSubjects();
//			System.out.println(list);
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}
		
//6 using constructor - get id, name and price of Book		
//		BookDao dao = new BookDao();
//		try {
//			HbUtil.beginTransaction();
//			List<Book> list = dao.getBooksInfo3();
//			for (Book b : list)
//				System.out.println(b);
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}
		
//7analytical query
//		BookDao dao = new BookDao();
//		try {
//			HbUtil.beginTransaction();
//			Map<String, Double> map = dao.getSubjectwiseBooksAvgPrice();
//			for (Entry<String, Double> e : map.entrySet())
//				System.out.println(e.getKey() + " => " + e.getValue());
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}

//update
//		BookDao dao = new BookDao();
//		try {
//			HbUtil.beginTransaction();
//			int cnt = dao.increaseBookPriceOfSubject("Novell");
//			System.out.println("Books updated : " + cnt);
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}
		
//delete
		BookDao dao = new BookDao();
		try {
			HbUtil.beginTransaction();
			int cnt = dao.deleteBooksOfSubject("Novell");
			System.out.println("Books deleted : " + cnt);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
	
	HbUtil.shutdown();
	}
}