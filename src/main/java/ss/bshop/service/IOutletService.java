/**
 * @author Kostya Tarasov
 */
package ss.bshop.service;

import java.util.List;

import ss.bshop.domain.Outlet;

public interface IOutletService {

	public List<Outlet> getAll();
	public List<Outlet> getForSalesRep(String salesRepLogin);
	public List<Outlet> getForSalesRepToday(String salesRepLogin);
}
