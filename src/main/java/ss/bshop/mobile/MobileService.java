/**
 * @author Kostya Tarasov
 */
package ss.bshop.mobile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ss.bshop.dao.IOutletOrder;
import ss.bshop.domain.Outlet;
import ss.bshop.domain.OutletOrder;
import ss.bshop.service.IOutletService;

@Controller
@RequestMapping("/mobile/*")
public class MobileService {

	@Autowired
	private IOutletOrder outletOrderDAO;
	@Autowired
	private IOutletService outletService;

	@RequestMapping(value = "/mobile/helloservice", method = RequestMethod.POST,
			consumes = "text/plain")
	public @ResponseBody String helloService(@RequestBody String name) {
		String answer = "Hello, " + name + "!";
		return answer;
	}

	@RequestMapping(value = "/mobile/addorder", method = RequestMethod.POST, 
			consumes = "application/json") 
	public void addOrder(@RequestBody OutletOrder newOrder) {
		outletOrderDAO.add(newOrder);
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
	public @ResponseBody List<Article>
}
