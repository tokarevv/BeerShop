package ss.bshop.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ss.bshop.domain.Appointment;

public class AppointmentDAO implements IAppointmentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Appointment app) {
		sessionFactory.getCurrentSession().save(app);
	}

	@Override
	public Appointment get(Long appId) {
		return (Appointment) sessionFactory.getCurrentSession().get(Appointment.class, appId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAll() {

		return sessionFactory.getCurrentSession().createQuery("from Appointment")
			.list();
		
	}

	@Override
	public void remove(Long id) {
		Appointment app = (Appointment) sessionFactory.getCurrentSession().load(
				Appointment.class, id);
		if (app != null) {
			sessionFactory.getCurrentSession().delete(app);
		}
		
	}

	@Override
	public void update(Long id) {
		Appointment app = (Appointment) sessionFactory.getCurrentSession().load(
				Appointment.class, id);
		if (app != null) {
			sessionFactory.getCurrentSession().delete(app);
		}
		sessionFactory.getCurrentSession().save(app);
		
	}
}
