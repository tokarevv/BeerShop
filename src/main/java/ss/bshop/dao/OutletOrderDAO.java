/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss.bshop.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ss.bshop.domain.Outlet;
import ss.bshop.domain.OutletOrder;

/**
 *
 * @author nick
 */
@Repository
public class OutletOrderDAO implements IOutletOrder{

	@Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void add(OutletOrder t) {
        sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public OutletOrder get(Long id) {
        return (OutletOrder) sessionFactory.getCurrentSession().get(OutletOrder.class, id);
    }

    @Override
    public List<OutletOrder> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from OutletOrder")
			.list();
    }

    @Override
    public void remove(Long id) {
        OutletOrder t = get(id);
        if (t != null) {
            sessionFactory.getCurrentSession().delete(t);
        }
    }

    @Override
    public void update(OutletOrder t) {
        sessionFactory.getCurrentSession().update(t);
    }

    
    
}

