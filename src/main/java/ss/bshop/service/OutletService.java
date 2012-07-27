/**
 * @author Kostya Tarasov
 */
package ss.bshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.IOutletDAO;
import ss.bshop.domain.Appointment;
import ss.bshop.domain.Outlet;
import ss.bshop.domain.SalesRep;

@Service
@Transactional(readOnly = true)
public class OutletService implements IOutletService {

	@Autowired
	private IOutletDAO outletDAO;
	@Autowired
	private ISalesRepService salesRepService;
	
	@Autowired
	private IAppointmentService appointmentService;

	@Override
	public List<Outlet> getAll() {
		return outletDAO.getAll();
	}

	@Override
	public List<Outlet> getForSalesRep(String salesRepLogin) {
		SalesRep salesRep = salesRepService.getSalesRepForLogin(salesRepLogin);
		List<Outlet> all = outletDAO.getAll();
		List<Outlet> forSalesRep = new ArrayList<Outlet>();
		for (Outlet outlet : all) {
			if (outlet.getSalesRep().equals(salesRep)) {
				forSalesRep.add(outlet);
			}
		}
		return forSalesRep;
	}

	@Override
	public List<Outlet> getForSalesRepToday(String salesRepLogin) {
		SalesRep salesRep = salesRepService.getSalesRepForLogin(salesRepLogin);
		List<Appointment> todayAppointments = appointmentService
				.getAppointmentsForToday();
		List<Outlet> forToday = new ArrayList<Outlet>();
		for (Appointment app : todayAppointments) {
			if (app.getSalesRep().equals(salesRep)) {
				forToday.add(app.getOutlet());
			}
		}
		return forToday;
	}

	@Transactional(readOnly = false)
	@Override
	public void add(Outlet outlet) {
		outletDAO.add(outlet);
		
	}

	@Override
	public Outlet get(Long id) {
	return outletDAO.get(id);
	}

	@Transactional(readOnly = false)
	@Override
	public void remove(Long id) {
		outletDAO.remove(id);
		
	}

	@Transactional(readOnly = false)
	@Override
	public void update(Outlet outlet) {
		outletDAO.update(outlet);
		
	}


}
