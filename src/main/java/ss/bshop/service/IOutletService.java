/**
 * @author Kostya Tarasov
 */
package ss.bshop.service;

import java.util.List;

import ss.bshop.domain.Outlet;

public interface IOutletService {

	
	public List<Outlet> getForSalesRep(String salesRepLogin);
	public List<Outlet> getForSalesRepToday(String salesRepLogin);
	
	public List<Outlet> getAll();
	public void add(Outlet outlet);
	public Outlet get(Long id);
	public void remove(Long id);
	public void update(Outlet outlet);
	
}
