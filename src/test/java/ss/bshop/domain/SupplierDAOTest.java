package ss.bshop.domain;

import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.ISupplierDAO;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class SupplierDAOTest {

    @Autowired
    private ISupplierDAO daoI;

    @Test
	public void testSave() throws Exception {
		Supplier suppl = new Supplier();
		suppl.setAddress("adress");
		suppl.setName("name");

		System.out.println(suppl);
		daoI.add(suppl);
		List<Supplier> supplList = daoI.getAll();

		Assert.assertEquals(suppl, supplList.get(supplList.size() - 1));
		Assert.assertEquals(suppl.getAddress(),
				supplList.get(supplList.size() - 1).getAddress());
	}
 
    @Test
	public void testGet() throws Exception {

    	Supplier suppl = new Supplier();
    	suppl.setAddress("adress");
		suppl.setName("name");
		
		daoI.add(suppl);
		List<Supplier> supplList = daoI.getAll();

		Supplier loadedVisit = supplList.get(supplList.size() - 1);
		Long loadedId = loadedVisit.getId();
		Assert.assertEquals(loadedVisit, daoI.get(loadedId));
	}

}  
