package ss.bshop.mobile;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ss.bshop.domain.Article;
import ss.bshop.domain.OutletOrder;
import ss.bshop.domain.OutletOrderStructure;
import ss.bshop.domain.Visit;
import ss.bshop.mobile.entities.OutletOrderMobile;
import ss.bshop.mobile.entities.OutletOrderStructureMobile;
import ss.bshop.mobile.entities.VisitMobile;
import ss.bshop.service.IArticleService;
import ss.bshop.service.IOutletService;

@Component
public class Converters {

	@Autowired
	private IArticleService articleService;
	@Autowired
	private IOutletService outletService;

	public Visit convertMobileVisitToVisit(VisitMobile mobileVisit) {
		Visit visit = new Visit();
		OutletOrderMobile mobileOO = mobileVisit.getOutletOrder();
		if (mobileOO != null) {
			List<OutletOrderStructureMobile> mobileStructure = mobileOO
					.getStructure();
			List<OutletOrderStructure> structure = 
					new ArrayList<OutletOrderStructure>();
			OutletOrder outletOrder = new OutletOrder();
			for (OutletOrderStructureMobile oosm : mobileStructure) {
				OutletOrderStructure oos = new OutletOrderStructure();
				oos.setAmount(oosm.getAmount());
				// getting correct article from db
				Long articleId = oosm.getArticle().getId();
				Article article = articleService.getById(articleId);
				oos.setArticle(article);
				// done with article
				oos.setPrice(oosm.getPrice());
				// now the OutletOrder
				oos.setOutletOrder(outletOrder);
				structure.add(oos);
			}
			outletOrder.setStructure(structure);
			outletOrder.setPayment(mobileOO.getPayment());
			outletOrder.setDiscount(mobileOO.getDiscount());
			outletOrder.setType(mobileOO.getType());
			outletOrder.setVisit(visit);
			visit.setOrder(outletOrder);
		}
		visit.setLat(mobileVisit.getLat());
		visit.setLng(mobileVisit.getLng());
		Long outletId = mobileVisit.getOutlet().getId();
		visit.setOutlet(outletService.get(outletId));
		visit.setTime(mobileVisit.getTime());
		return visit;
	}
}
