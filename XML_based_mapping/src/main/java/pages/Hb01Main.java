package pages;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Hb01Main {

	public static void main(String[] args) {
		try (Session session = HbUtil.openSession()) {
			Book b = session.get(Book.class, 43);
			System.out.println("Found : " + b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}