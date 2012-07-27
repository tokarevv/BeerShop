/**
 * @author Kostya Tarasov
 */
package ss.bshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.ISalesRepDAO;
import ss.bshop.domain.SalesRep;

@Service
@Transactional(readOnly = true)
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

	@Transactional(readOnly = false)
	@Override
	public void add(SalesRep salesRep) {
		salesRepDAO.addSalesRep(salesRep);
		
	}

	@Override
	public SalesRep get(Long id) {
		return (SalesRep) salesRepDAO.getSalesRep(id);
	}

	@Override
	public List<SalesRep> getAll() {
		return salesRepDAO.getAllSalesReps();
	}

	@Transactional(readOnly = false)
	@Override
	public void remove(Long id) {
		salesRepDAO.removeSalesRep(id);
		
	}
	
	@Transactional(readOnly = false)
	@Override
	public void update(SalesRep salesRep) {
		salesRepDAO.updateSalesRep(salesRep);
	}

}
