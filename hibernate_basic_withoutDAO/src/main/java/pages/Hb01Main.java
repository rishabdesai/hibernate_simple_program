package pages;

import org.hibernate.Session;

public class Hb01Main {
	
	public static void main(String[] args) {
		//without dao
		try(Session session = HbUtil.openSession()){
		Book b = session.get(Book.class, 21);
		System.out.println("Found : "+b);
		}catch (Exception e ){
			e.printStackTrace();
		}
	}

}
