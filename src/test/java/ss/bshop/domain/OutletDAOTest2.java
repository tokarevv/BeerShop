///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
package ss.bshop.domain;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ss.bshop.dao.IOutletDAO;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class OutletDAOTest2 {
    
    @Autowired
    private IOutletDAO daoI;

    @Test
    public void someTest(){
        
    }
//    @Test
//    public void testSaveAndGet() throws Exception{
//
//        final int outletesCount = 10;
//        List<Outlet> employees = new ArrayList<Outlet>(outletesCount);
//        for (int i = 0; i < outletesCount; i++) {
//            Outlet olt= new Outlet();
//            olt.setName("Outlet" + i);
//            employees.add(olt);
//        }
//        
//        for (Outlet employee : employees) {
//            daoI.save(employee);
//        }
//        
//        // check db data
//        Iterable<Outlet> actualEmployees = daoI.findAll();
//        int idx = 0;
//        for (Outlet actualEmployee : actualEmployees) {
//            assertEquals(employees.get(idx), actualEmployee);
//            idx++;
//        }
//   }
    
}
