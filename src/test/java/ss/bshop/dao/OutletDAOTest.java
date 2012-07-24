/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss.bshop.dao;

import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import ss.bshop.domain.Article;
import ss.bshop.domain.Outlet;

/**
 *
 * @author nick
 */
public class OutletDAOTest {
    
    //@Autowired
    private IOutletDAO daoI;

    @Ignore
    @Test
    public void testSaveAndGet() {

        final int outletesCount = 10;
        List<Outlet> employees = new ArrayList<Outlet>(outletesCount);
        for (int i = 0; i < outletesCount; i++) {
            Outlet olt= new Outlet();
           olt.setName("Outlet" + i);
            employees.add(olt);
        }
        
        for (Outlet employee : employees) {
    //        daoI.save(employee);
        }
        
        // check db data
        //Iterable<Outlet> actualEmployees = daoI.findAll();
//        int idx = 0;
//        for (Outlet actualEmployee : actualEmployees) {
//            assertEquals(employees.get(idx), actualEmployee);
//            idx++;
//        }
    }
    
}
