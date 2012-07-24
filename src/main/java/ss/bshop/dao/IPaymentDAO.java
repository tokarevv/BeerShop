package ss.bshop.dao;

import java.util.List;

import ss.bshop.domain.Payment;
import ss.bshop.domain.Visit;

public interface IPaymentDAO {

	public void add(Payment payment);

	public Payment get(Long id);

	public List<Payment> getAll();

	public void remove(Long id);
	
	public void update(Long id);
}
