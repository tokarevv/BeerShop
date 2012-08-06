/**
 * @author Kostya Tarasov
 */
package ss.bshop.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
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
	Logger logger = Logger.getLogger(getClass());

	@Override
	public List<Outlet> getAll() {
		return outletDAO.getAll();
	}

	@Override
	public List<Outlet> getForSalesRep(String salesRepLogin) {
		SalesRep salesRep = salesRepService.getSalesRepForLogin(salesRepLogin);
		List<Outlet> all = outletDAO.getAll();
		List<Outlet> forSalesRep = new ArrayList<Outlet>();
		logger.debug("All outlets: " + all);
		logger.debug("Sales rep: " + salesRep);
		for (Outlet outlet : all) {
			try {
				if (outlet.getSalesRep().equals(salesRep)) {
					forSalesRep.add(outlet);
				}
			} catch (NullPointerException npe) {
				logger.warn("Null element in list");
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

	@Override
	public Outlet getForId(Long id) {
		return outletDAO.get(id);
	}

        @Override
        public List<Outlet> getBySalesRep(SalesRep salesRep) {
            return outletDAO.getBySalesRep(salesRep);
        }
}
