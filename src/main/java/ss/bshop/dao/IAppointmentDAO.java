package ss.bshop.dao;

import java.util.List;

import ss.bshop.domain.Appointment;

public interface IAppointmentDAO {

	public void add(Appointment app);

	public Appointment get(Long id);

	public List<Appointment> getAll();

	public void remove(Long id);
	
	public void update(Long id);

}
