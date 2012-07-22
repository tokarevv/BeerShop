package ss.bshop.domain;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import junit.framework.Assert;

import org.junit.runner.RunWith;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ss.bshop.dao.IAppointmentDAO;

@ContextConfiguration("/WEB-INF/spring/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AppointmentDAOTest {

		@Autowired
		private IAppointmentDAO appointmentDao;
	   
		@Test
		public void sampleTest() {
			Appointment app = new Appointment();
			app.setOutlet(new Outlet());
			app.setSalesRep(new SalesRep());
			List<Date> datelist = new ArrayList<Date>();
			datelist.add(new Date());
			app.setDateList(datelist);
			appointmentDao.add(app);
			Collection<Appointment> result = appointmentDao.getAll();
			Assert.assertEquals(1, result.size());
			Assert.assertTrue(result.contains(app));
		}
}


