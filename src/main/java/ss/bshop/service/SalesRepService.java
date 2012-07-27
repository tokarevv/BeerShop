/**
 * @author Kostya Tarasov
 */
package ss.bshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ss.bshop.dao.ISalesRepDAO;
import ss.bshop.domain.SalesRep;

public class SalesRepService implements ISalesRepService {

	@Autowired
	private ISalesRepDAO salesRepDAO;

	@Override
	public SalesRep getSalesRepForLogin(String salesRepLogin) {
		List<SalesRep> salesReps = salesRepDAO.getAllSalesReps();
		SalesRep forLogin = null;
		for (SalesRep salesRep : salesReps) {
			if (salesRep.getUser().getLogin().equals(salesRepLogin)) {
				forLogin = salesRep;
				break;
			}
		}
		return forLogin;
	}

}
