/**
 * @author Kostya Tarasov
 */
package ss.bshop.service;

import java.util.List;

import ss.bshop.domain.Outlet;
import ss.bshop.domain.SalesRep;

public interface IOutletService {

	
	public List<Outlet> getForSalesRep(String salesRepLogin);
	public List<Outlet> getForSalesRepToday(String salesRepLogin);
	
	public List<Outlet> getAll();
	public void add(Outlet outlet);
	public Outlet get(Long id);
	public void remove(Long id);
	public void update(Outlet outlet);
	public Outlet getForId(Long id);

        public List<Outlet> getBySalesRep(SalesRep salesRep);

	
}

