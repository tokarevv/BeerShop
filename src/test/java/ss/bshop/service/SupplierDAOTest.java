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
import ss.bshop.dao.ISupplierDAO;
import ss.bshop.domain.Supplier;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class SupplierDAOTest {

    @Autowired
    private ISupplierService service;

    @Test
	public void testSave() throws Exception {
		Supplier suppl = GenereateObjectHelper.getNewSupplier();
		suppl.setAddress("adress");
		suppl.setName("name");

		System.out.println(suppl);
		service.add(suppl);
		List<Supplier> supplList = service.getAll();

		Assert.assertEquals(suppl, supplList.get(supplList.size() - 1));
		Assert.assertEquals(suppl.getAddress(),
				supplList.get(supplList.size() - 1).getAddress());
	}
 
    @Test
	public void testGet() throws Exception {

    	Supplier suppl = GenereateObjectHelper.getNewSupplier();
    	suppl.setAddress("adress");
		suppl.setName("name");
		
		service.add(suppl);
		List<Supplier> supplList = service.getAll();

		Supplier loadedVisit = supplList.get(supplList.size() - 1);
		Long loadedId = loadedVisit.getId();
		Assert.assertEquals(loadedVisit, service.get(loadedId));
	}

}  
