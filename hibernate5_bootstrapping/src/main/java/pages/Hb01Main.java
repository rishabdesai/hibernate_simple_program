package pages;

public class Hb01Main {

	public static void main(String[] args) {

	BookDao dao= new BookDao();
	try {
		HbUtil.beginTransaction();
		Book b=dao.getBook(43);
		System.out.println("found : "+b);
		//HbUtil.commitTransaction();
		
	}catch(Exception e) {
		e.printStackTrace();
		HbUtil.rollbackTransaction();
	}
	HbUtil.shutdown();
	}
}