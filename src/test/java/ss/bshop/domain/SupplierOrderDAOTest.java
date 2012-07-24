package ss.bshop.domain;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.ISupplierOrderDAO;
import java.util.List;

/**
 * ArticleDAO Tester. 
 * 
 * author: Victor
 */
@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class SupplierOrderDAOTest {

    @Autowired
    private ISupplierOrderDAO dao;

    /**
     * Method: add(Article article)
     */
    @Test
	public void testAdd() throws Exception {
		SupplierOrder order = GenereateObjectHelper.getNewSupplierOrder();

		dao.add(order);
		List<SupplierOrder> orderList = dao.getAll();

		Assert.assertEquals(order, orderList.get(orderList.size() - 1));
	}
    
    /**
     * Method: getArticle(Integer articleId)
     */
    @Test
	public void testGetOrder() throws Exception {
		SupplierOrder order = GenereateObjectHelper.getNewSupplierOrder();

		dao.add(order);
		List<SupplierOrder> orderList = dao.getAll();
		SupplierOrder loadedOrder = orderList.get(orderList.size() - 1);
		Long loadedOrderId = loadedOrder.getId();
		Assert.assertEquals(loadedOrder, dao.get(loadedOrderId));
	}
    

}  
