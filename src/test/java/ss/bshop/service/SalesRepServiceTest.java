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
import ss.bshop.domain.SalesRep;
import ss.bshop.domain.Supplier;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class SalesRepServiceTest {

    @Autowired
    private ISalesRepService service;

    @Test
	public void testSave() throws Exception {
		SalesRep sRep = GenereateObjectHelper.getNewSalesRep();

		//System.out.println(sres);
		service.add(sRep);
		List<SalesRep> list = service.getAll();

		Assert.assertEquals(sRep, list.get(list.size() - 1));
		Assert.assertEquals(sRep.getUser().getLogin(),
				list.get(list.size() - 1).getUser().getLogin());
	}
 
    @Test
	public void testGet() throws Exception {

		SalesRep sRep = GenereateObjectHelper.getNewSalesRep();
		
		service.add(sRep);
		List<SalesRep> list = service.getAll();

		SalesRep loaded = list.get(list.size() - 1);
		Long loadedId = loaded.getId();
		Assert.assertEquals(loaded, service.get(loadedId));
	}

}  
