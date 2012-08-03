/**
 * @author Kostya Tarasov
 */
package ss.bshop.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.IAppointmentDAO;
import ss.bshop.domain.Appointment;

@Service
@Transactional(readOnly = true)
public class AppointmentService implements IAppointmentService {

	@Autowired
	private IAppointmentDAO appointmentDAO;
	@Override
	public List<Appointment> getAppointmentsForToday() {
		Calendar rightNow = Calendar.getInstance();
		int today = rightNow.get(Calendar.DAY_OF_WEEK);
		List<Appointment> appointments = appointmentDAO.getAll();
		List<Appointment> forToday = new ArrayList<Appointment>();
		for (Appointment app : appointments) {
			if (app.getWeekDay().intValue() == today) {
				forToday.add(app);
			}
		}
		return forToday;
	}

}
