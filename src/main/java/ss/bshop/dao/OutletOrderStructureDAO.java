/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss.bshop.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import ss.bshop.domain.OutletOrderStructure;
/**
 *
 * @author nick
 */
public class OutletOrderStructureDAO implements IOutletOrderStructure{

    private SessionFactory sessionFactory;
    
    @Override
    public void add(OutletOrderStructure t) {
        sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public OutletOrderStructure get(Long id) {
        return (OutletOrderStructure) sessionFactory.getCurrentSession().get(OutletOrderStructure.class, id);
    }

    @Override
    public List<OutletOrderStructure> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from OutletOrderStructure")
			.list();
    }

    @Override
    public void remove(Long id) {
        OutletOrderStructure t = get(id);
        if (t != null) {
            sessionFactory.getCurrentSession().delete(t);
        }
    }

    @Override
    public void update(OutletOrderStructure t) {
        sessionFactory.getCurrentSession().update(t);
    }


}

