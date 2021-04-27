package main;

import java.util.List;

import org.hibernate.query.Query;

import org.hibernate.Session;

import pojos.Item;
import pojos.NonVegItem;
import pojos.VegItem;
import utils.HbUtil;

public class Hb01Main {
	public static void main(String[] args) {
		try {
			HbUtil.beginTransaction();
			String hql = "from Item i";
			Session session = HbUtil.getSession();
			Query<Item> q = session.createQuery(hql);
			List<Item> list = q.getResultList();
			for (Item i : list) {
				if (i instanceof VegItem)
					System.out.println("Veg" + i);
				else if (i instanceof NonVegItem)
					System.out.println("NonVeg" + i);
			}
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
		HbUtil.shutdown();
	}
}
