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
import ss.bshop.domain.Visit;
import ss.bshop.mobile.entities.ArticleMobile;
import ss.bshop.mobile.entities.OutletMobile;
import ss.bshop.mobile.entities.VisitMobile;
import ss.bshop.service.IArticleService;
import ss.bshop.service.IOutletService;
import ss.bshop.service.IVisitService;

@Controller
@RequestMapping(value = "/mobile")
public class MobileService {

	@Autowired
	private IOutletOrder outletOrderDAO;
	@Autowired
	private IOutletService outletService;
	@Autowired
	private IArticleService articleService;
	@Autowired
	private IVisitService visitService;
	@Autowired
	private Converters converters;

	@RequestMapping(value = "helloservice", method = RequestMethod.GET)
	public @ResponseBody String helloService() {
		String answer = "Hello there!";
		return answer;
	}

	@RequestMapping(value = "addvisit",
			method = RequestMethod.POST, consumes = "application/json") 
	public void addOrder(@RequestBody VisitMobile mobileVisit) {
		Visit visit = converters.convertMobileVisitToVisit(mobileVisit);
		visitService.add(visit);
	}

	@RequestMapping(value = "getoutlets/(salesRepLogin)",
			method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<OutletMobile> getOutlets(
			@PathVariable String salesRepLogin) {
		List<Outlet> forToday = outletService
				.getForSalesRepToday(salesRepLogin);
		List<OutletMobile> mobileForToday = new ArrayList<OutletMobile>();
		for (Outlet outlet : forToday) {
			mobileForToday.add(OutletMobile.fromOutlet(outlet));
		}
		return mobileForToday;
	}

	@RequestMapping(value = "getgoods", method = RequestMethod.GET,
			produces = "application/json")
	public @ResponseBody List<ArticleMobile> getGoods() {
		List<Article> articles = articleService.getArticles();
		List<ArticleMobile> mobileArticles = new ArrayList<ArticleMobile>();
		for(Article article : articles) {
			mobileArticles.add(ArticleMobile.fromArticle(article));
		}
		return mobileArticles;
	}
}
