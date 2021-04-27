package main;

import java.util.List;

import daos.BookDao;
import pojos.Book;
import utils.JpaUtil;

public class Hb01Main {
	public static void main(String[] args) {

//		//1. get Book using ID	
//	try(BookDao dao= new BookDao()){
//		dao.open();
//		Book b= dao.getBook(11);
//		System.out.println(b);
//	}catch (Exception e) {
//		e.printStackTrace();
//	}
		
//		//2. get book by subject using @NamedQuery in Book.java
//		try(BookDao dao = new BookDao()) {
//			dao.open();
// 			List<Book> list = dao.getBookBySubject("C");
// 			for (Book b : list)
// 				System.out.println(b);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	
//		//3. add book
//		try(BookDao dao = new BookDao()) {
//			dao.open();
// 			Book b = new Book(51, "Sherlock Homes", "Unknown", "Novell", 434.23);
// 			dao.addBook(b);
// 			System.out.println(b);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	

		//4. update book
//		try(BookDao dao = new BookDao()) {
//			dao.open();
// 			Book b = dao.getBook(51);
// 			b.setPrice(823.34);
// 			dao.updateBook(b);
// 			System.out.println(b);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		//5. delete book
//		try(BookDao dao = new BookDao()) {
//			dao.open();
// 			dao.deleteBook(51);
// 			System.out.println("Deleted.");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
//		//6. Get book price by book-ID using Stored procedure
//		try(BookDao dao = new BookDao()) {
//			dao.open();
// 			double price = dao.getBookPrice(11);
// 			System.out.println("Book Price : " + price);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//7. get book by author using CriteriaQuery
//		try(BookDao dao = new BookDao()) {
//			dao.open();
// 			List<Book> list = dao.getBooksByAuthor("Kanetkar");
// 			for (Book b : list)
// 				System.out.println(b);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		JpaUtil.shutdown();
	}
}
