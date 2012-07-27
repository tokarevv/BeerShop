/**
 * @author Kostya Tarasov
 */
package ss.bshop.service;

import java.util.List;

import ss.bshop.domain.Appointment;

public interface IAppointmentService {

	public List<Appointment> getAppointmentsForToday();

}
