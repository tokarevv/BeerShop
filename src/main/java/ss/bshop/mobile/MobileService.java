/**
 * @author Kostya Tarasov
 */
package ss.bshop.mobile;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ss.bshop.dao.IOutletOrder;
import ss.bshop.domain.Article;
import ss.bshop.domain.Outlet;
import ss.bshop.domain.OutletOrder;
import ss.bshop.domain.OutletOrderStructure;
import ss.bshop.mobile.entities.OutletOrderMobile;
import ss.bshop.mobile.entities.OutletOrderStructureMobile;
import ss.bshop.mobile.entities.VisitMobile;
import ss.bshop.service.IArticleService;
import ss.bshop.service.IOutletService;

@Controller
@RequestMapping("/mobile/*")
public class MobileService {

	@Autowired
	private IOutletOrder outletOrderDAO;
	@Autowired
	private IOutletService outletService;
	@Autowired
	private IArticleService articleService;

	@RequestMapping(value = "/mobile/helloservice", method = RequestMethod.POST,
			consumes = "text/plain")
	public @ResponseBody String helloService(@RequestBody String name) {
		String answer = "Hello, " + name + "!";
		return answer;
	}

	@RequestMapping(value = "/mobile/addvisit", method = RequestMethod.POST, 
			consumes = "application/json") 
	public void addOrder(@RequestBody VisitMobile mobileVisit) {
		OutletOrderMobile mobileOO = mobileVisit.getOutletOrder();
		Long outletId = mobileVisit.getOutlet().getId();
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
			// now the Out
			oos.setOutletOrder(outletOrder);
		}
	}

	@RequestMapping(value = "/mobile/getoutlets/(salesRepLogin)",
			method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Outlet> getOutlets(
			@PathVariable String salesRepLogin) {
		List<Outlet> forToday = outletService
				.getForSalesRepToday(salesRepLogin);
		return forToday;
	}

	@RequestMapping(value = "/mobile/getgoods", produces = "application/json")
	public @ResponseBody List<Article> getGoods() {
		return articleService.getArticles();
	}
}
