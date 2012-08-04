package ss.bshop.service;

import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.GenereateObjectHelper;
import ss.bshop.dao.ISalesRepDAO;
import ss.bshop.dao.ISupplierDAO;
import ss.bshop.domain.Outlet;
import ss.bshop.domain.SalesRep;
import ss.bshop.domain.Supplier;
import ss.bshop.domain.User;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class OutletServiceTest {

    @Autowired
    private IOutletService service;
    @Autowired
    private ISalesRepDAO sRDao;

    @Test
	public void testSave() throws Exception {
		Outlet outlet = GenereateObjectHelper.getNewOutlet();

		//System.out.println(sres);
		service.add(outlet);
		List<Outlet> list = service.getAll();

		Assert.assertEquals(outlet, list.get(list.size() - 1));
	}
 
    @Test
	public void testGet() throws Exception {

		Outlet outlet = GenereateObjectHelper.getNewOutlet();

		//System.out.println(sres);
		service.add(outlet);
		List<Outlet> list = service.getAll();

		Outlet loaded = list.get(list.size() - 1);
		Long loadedId = loaded.getId();
		Assert.assertEquals(loaded, service.get(loadedId));
	}
    
    
    @Test
	public void testGetBySalesRep() throws Exception {
    	
    	SalesRep salesRep  = new SalesRep();
    	User u = new User();
    	u.setLogin("s");
    	u.setFullname("dsf");
    	u.setPassword("dsf");
    	u.setPost("manager");
    	salesRep.setUser(u);
    	sRDao.addSalesRep(salesRep);
    	

		Outlet outlet1 = GenereateObjectHelper.getNewOutlet();
		outlet1.setSalesRep(salesRep);
		service.add(outlet1);
		Outlet outlet2 = GenereateObjectHelper.getNewOutlet();
		outlet2.setSalesRep(salesRep);
		service.add(outlet2);
		Outlet outlet3 = GenereateObjectHelper.getNewOutlet();
		service.add(outlet3);

		//System.out.println(sres);
		//service.add(outlet);
		List<Outlet> list = service.getBySalesRep(salesRep);

		//Outlet loaded = list.get(list.size() - 1);
		//Long loadedId = loaded.getId();
		Assert.assertEquals(2, list.size());
	}
    

}  
