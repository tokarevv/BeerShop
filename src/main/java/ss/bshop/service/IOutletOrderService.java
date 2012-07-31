package ss.bshop.service;

import java.util.List;
import ss.bshop.domain.OutletOrder;

public interface IOutletOrderService {
	
	public void add(OutletOrder outletOrder);

	public OutletOrder get(Long id);

	public List<OutletOrder> getAll();

	public void remove(Long id);
	
	public void update(OutletOrder outletOrder);

}
