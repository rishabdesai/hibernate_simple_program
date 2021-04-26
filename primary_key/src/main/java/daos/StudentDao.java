package daos;

import org.hibernate.Session;

import pojos.StudStdRoll;
import pojos.Student;
import utils.HbUtil;

public class StudentDao {
	public Student getStudent(int std, int roll) {
		Session session = HbUtil.getSession();
		StudStdRoll id = new StudStdRoll(std, roll);
		return session.get(Student.class, id);
	}
}
