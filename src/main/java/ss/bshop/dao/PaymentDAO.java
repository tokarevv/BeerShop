package ss.bshop.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ss.bshop.domain.Payment;

@Repository
public class PaymentDAO implements IPaymentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Payment payment) {
		sessionFactory.getCurrentSession().save(payment);
	}

	@Override
	public Payment get(Long id) {
		return (Payment) sessionFactory.getCurrentSession().get(Payment.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> getAll() {

		return sessionFactory.getCurrentSession().createQuery("from Payment")
			.list();
		
	}

	@Override
	public void remove(Long id) {
		Payment payment = (Payment) sessionFactory.getCurrentSession().load(Payment.class, id);
		if (payment != null) {
			sessionFactory.getCurrentSession().delete(payment);
		}
		
	}

	@Override
	public void update(Payment payment) {
		sessionFactory.getCurrentSession().update(payment);
		
	}

}
