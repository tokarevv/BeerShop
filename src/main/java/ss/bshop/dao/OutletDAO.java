/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss.bshop.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ss.bshop.domain.Article;
import ss.bshop.domain.Outlet;
import ss.bshop.domain.Payment;
import ss.bshop.domain.SalesRep;

/**
 *
 * @author nick
 */

@Repository
public class OutletDAO implements IOutletDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void add(Outlet t) {
        sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public Outlet get(Long id) {
        return (Outlet) sessionFactory.getCurrentSession().get(Outlet.class, id);
    }

    @Override
    public List<Outlet> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Outlet")
			.list();
    }

    @Override
    public void remove(Long id) {
        Outlet t = get(id);
		if (t != null) {
			sessionFactory.getCurrentSession().delete(t);
		}
    }

    @Override
    public void update(Outlet t) {
        sessionFactory.getCurrentSession().update(t);
    }

    @Override
    public List<Outlet> getBySalesRep(SalesRep salesRep) {
        List<Outlet> res = new ArrayList<Outlet>();
        Query q = sessionFactory.getCurrentSession().createQuery("from Outlet where SalesRep_id = :SalesRep_id");
        q.setParameter("SalesRep_id", salesRep.getId());
        res = q.list();

        return res;

    }
    
}

