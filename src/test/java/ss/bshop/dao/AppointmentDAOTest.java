package ss.bshop.dao;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ss.bshop.dao.IAppointmentDAO;
import ss.bshop.domain.Appointment;


@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class AppointmentDAOTest {

    @Autowired
    private IAppointmentDAO daoI;

    @Test
	public void testSave() throws Exception {
		Appointment app = new Appointment();
		//app.setOutlet(new Outlet());
		//app.setSalesRep(new SalesRep());
		app.setWeekDay(1);

		System.out.println(app);
		daoI.add(app);
		List<Appointment> appList = daoI.getAll();

		Assert.assertEquals(app, appList.get(appList.size() - 1));
		Assert.assertEquals(app.getWeekDay(),
				appList.get(appList.size() - 1).getWeekDay());
	}
 
    @Test
	public void testGet() throws Exception {

    	Appointment app = new Appointment();
    	//app.setOutlet(new Outlet());
		//app.setSalesRep(new SalesRep());
		app.setWeekDay(1);
		
		daoI.add(app);
		List<Appointment> appList = daoI.getAll();

		Appointment loadedVisit = appList.get(appList.size() - 1);
		Long loadedId = loadedVisit.getId();
		Assert.assertEquals(loadedVisit, daoI.get(loadedId));
	}

}  