/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss.bshop.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import util.HibernateUtil;

/**
 *
 * @author nick
 */
public class HiberTest {
    
    public HiberTest() {
    }



    @Test
    public void testSomeMethod() {
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Supplier p1 = new Supplier("Chernigiv");
//        p1.addPhone(new Phone("13455"));
//        p1.addPhone(new Phone("53455"));
//        p1.addAddress(new Adress("st.skjfjdf 16"));
        session.save( p1 );
        
        session.getTransaction().commit();
    }
}
