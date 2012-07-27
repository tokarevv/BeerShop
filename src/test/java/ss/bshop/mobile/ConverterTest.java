package ss.bshop.mobile;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.domain.Visit;
import ss.bshop.mobile.entities.OutletMobile;
import ss.bshop.mobile.entities.VisitMobile;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ConverterTest {

	@Autowired
	private Converters converters;
	@Test
	public void testConvertEmptyMobileVisitToVisit() {
		VisitMobile mobileVisit = new VisitMobile();
		mobileVisit.setTime(new Date());
		OutletMobile mobileOutlet = new OutletMobile();
		mobileOutlet.setName("kiosk");
		mobileVisit.setOutlet(mobileOutlet);
		Visit visit = converters.convertMobileVisitToVisit(mobileVisit);
		Assert.assertEquals(mobileVisit.getTime(), visit.getTime());
		Assert.assertEquals(mobileVisit.getOutlet().getName(), visit.getOutlet().getName());
	}
}
