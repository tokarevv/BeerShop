/**
 * @author Kostya Tarasov
 */
package ss.bshop.mobile;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
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
import ss.bshop.domain.SalesRep;
import ss.bshop.domain.Visit;
import ss.bshop.mobile.entities.ArticleMobile;
import ss.bshop.mobile.entities.OutletMobile;
import ss.bshop.mobile.entities.VisitMobile;
import ss.bshop.service.IArticleService;
import ss.bshop.service.IOutletService;
import ss.bshop.service.ISalesRepService;
import ss.bshop.service.IVisitService;

@Controller
@RequestMapping("/mobile")
public class MobileService {

	public IOutletService getOutletService() {
		return outletService;
	}

	public void setOutletService(IOutletService outletService) {
		this.outletService = outletService;
	}

	public IArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}

	public IVisitService getVisitService() {
		return visitService;
	}

	public void setVisitService(IVisitService visitService) {
		this.visitService = visitService;
	}

	public Converters getConverters() {
		return converters;
	}

	public void setConverters(Converters converters) {
		this.converters = converters;
	}

	@Autowired
	private IOutletService outletService;
	@Autowired
	private IArticleService articleService;
	@Autowired
	private IVisitService visitService;
	@Autowired
	private ISalesRepService salesRepService;
	@Autowired
	private Converters converters;

	private Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(value = "helloservice.mob", method = RequestMethod.GET)
	public @ResponseBody String helloService() {
		String answer = "Hello there!";
		return answer;
	}

	@RequestMapping(value = "addvisit.mob",
			method = RequestMethod.POST, consumes = "application/json",
			produces = "text/plain") 
	public @ResponseBody String addOrder(@RequestBody VisitMobile mobileVisit) {
		String response = "OK";
		try {
			Visit visit = converters.convertMobileVisitToVisit(mobileVisit);
			visitService.add(visit);
		} catch (Exception e) {
			response = e.getMessage();
		}
		return response;
	}

	@RequestMapping(value = "getoutlets/{salesRepLogin}.mob",
			method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<OutletMobile> getOutlets(
			@PathVariable String salesRepLogin) {
		List<Outlet> forToday = outletService
				.getForSalesRep(salesRepLogin);
		List<OutletMobile> mobileForToday = new ArrayList<OutletMobile>();
		for (Outlet outlet : forToday) {
			OutletMobile om = new OutletMobile();
			om.setId(outlet.getId());
			om.setName(outlet.getName());
			om.setAddress(outlet.getAddress());
			om.setPhone(outlet.getPhone());
			om.setDiscount(outlet.getDiscount());
			mobileForToday.add(om);
		}
		return mobileForToday;
	}

	@RequestMapping(value = "getgoods.mob", method = RequestMethod.GET,
			produces = "application/json")
	public @ResponseBody List<ArticleMobile> getGoods() {
		logger.debug("Article service: " + articleService);
		List<Article> articles = articleService.getArticles();
		List<ArticleMobile> mobileArticles = new ArrayList<ArticleMobile>();
		try {
			for(Article article : articles) {
				ArticleMobile am = new ArticleMobile();
				am.setId(article.getId());
				am.setName(article.getName());
				am.setType(article.getType());
				am.setPrice(article.getPrice());
				am.setQty(article.getQuantity());
				am.setUnit(article.getUnit());
				mobileArticles.add(am);
			}
		} catch (NullPointerException npe) {
			logger.info("Null objects in list");
		}
		return mobileArticles;
	}

	@RequestMapping(value = "login.mob", method = RequestMethod.POST,
			consumes = "text/plain", produces = "text/plain")
	public @ResponseBody String login(@RequestBody String input) {
		String output = "Not OK";
		String[] data = input.split(":");
		String login = data[0];
		String pwd = data[1];
		SalesRep sr = salesRepService.getSalesRepForLogin(login);
		if (sr != null) {
			if (sr.getUser().getPassword().equals(pwd)) {
				output = "OK";
			}
		}
		return output;
	}
}
