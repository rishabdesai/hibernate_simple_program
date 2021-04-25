package pages;

public class Hb01Main {
	
	public static void main(String[] args) {
		
		//Search book by ID
		try(BookDao dao = new BookDao()) {
			dao.open();
			Book b = dao.getBook(43);
			System.out.println("Book found : "+b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		//INSERT book
//		try (BookDao dao = new BookDao()){
//			dao.open();
//			Book b = new Book(99,"xyz","abc","prq",123.45);
//			dao.addBook(b);
//			System.out.println("Added : "+b);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		//UPDATE
//		try(BookDao dao = new BookDao()) {
//			dao.open();
//			Book b = dao.getBook(99);
//			b.setCost(999.9);
//			dao.updateBook(b);
//			System.out.println("Updated : " + b);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		//DELETE
//		try(BookDao dao = new BookDao()) {
//			dao.open();
//			dao.deleteBook(61);
//			System.out.println("Deleted.");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		HbUtil.shutdown();
	}

}
