package daos;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;

import utils.HbUtil;

public class BookDao {

	// hibernate 5
	public Double getBookPrice5(int id) {
		Session session = HbUtil.getSession();
		ProcedureCall sp = session.createStoredProcedureCall("SP_GET_PRICE");
		sp.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
		sp.registerStoredProcedureParameter(1, Double.class, ParameterMode.OUT);
		sp.setParameter(0, id);
		sp.execute();
		return (Double) sp.getOutputParameterValue(1);
	}

}
