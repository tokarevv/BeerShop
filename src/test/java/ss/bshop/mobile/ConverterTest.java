package ss.bshop.mobile;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.domain.Outlet;
import ss.bshop.domain.Visit;
import ss.bshop.mobile.entities.OutletMobile;
import ss.bshop.mobile.entities.OutletOrderMobile;
import ss.bshop.mobile.entities.VisitMobile;
import ss.bshop.service.IOutletService;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ConverterTest {

	@Autowired
	private Converters converters;
	@Autowired
	private IOutletService outletService;
	@Test
	public void testConvertEmptyMobileVisitToVisit() {
		VisitMobile mobileVisit = new VisitMobile();
		mobileVisit.setTime(new Date());
		Outlet outlet = new Outlet();
		outlet.setName("kiosk");
		outletService.add(outlet);
		OutletMobile mobileOutlet = OutletMobile.fromOutlet(outlet);
		mobileVisit.setOutlet(mobileOutlet);
		Visit visit = converters.convertMobileVisitToVisit(mobileVisit);
		Assert.assertEquals(mobileVisit.getTime(), visit.getTime());
		Assert.assertEquals(mobileVisit.getOutlet().getName(),
				visit.getOutlet().getName());
	}
	@Test
	public void testConvertFullMobileVisitToVisit() {
		VisitMobile mobileVisit = new VisitMobile();
		mobileVisit.setTime(new Date());
		mobileVisit.setLat(48);
		mobileVisit.setLng(35);
		mobileVisit.setOutletOrder(new OutletOrderMobile());
		Outlet outlet = new Outlet();
		outlet.setName("kiosk");
		outletService.add(outlet);
		OutletMobile mobileOutlet = OutletMobile.fromOutlet(outlet);
		mobileVisit.setOutlet(mobileOutlet);
		Visit visit = converters.convertMobileVisitToVisit(mobileVisit);
		Assert.assertEquals(mobileVisit.getTime(), visit.getTime());
		Assert.assertEquals(mobileVisit.getOutlet().getName(),
				visit.getOutlet().getName());
		Assert.assertEquals(mobileVisit.getLat(), visit.getLat());
		Assert.assertEquals(mobileVisit.getLng(), visit.getLng());
		Assert.assertEquals(mobileVisit.getOutletOrder().getDiscount(),
				visit.getOrder().getDiscount());
	}
}
