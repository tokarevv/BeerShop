package ss.bshop.dao;

import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.IVisitDAO;
import ss.bshop.domain.Visit;

/**
 * VisitDAO Tester. 
 */
@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class VisitDAOTest {

    @Autowired
    private IVisitDAO daoI;

    /**
     * Method: save(Visit article)
     */
    @Test
	public void testSave() throws Exception {
		Visit visit = new Visit();
		visit.setLat(33);
		visit.setLng(44);

		System.out.println(visit);
		daoI.add(visit);
		List<Visit> visitList = daoI.getAll();

		// for(Visit a : visitList){
		// System.out.println(a);
		// }

		Assert.assertEquals(visit, visitList.get(visitList.size() - 1));
		Assert.assertEquals(visit.getLat(),
				visitList.get(visitList.size() - 1).getLat());
	}
    
    /**
     * Method: get(Integer id)
     */
    @Test
	public void testGet() throws Exception {

    	Visit visit = new Visit();
    	visit.setLat(33);

		daoI.add(visit);
		List<Visit> visitList = daoI.getAll();

		Visit loadedVisit = visitList.get(visitList.size() - 1);
		Long loadedVisitId = loadedVisit.getId();
		Assert.assertEquals(loadedVisit, daoI.get(loadedVisitId));
	}
    

}  
