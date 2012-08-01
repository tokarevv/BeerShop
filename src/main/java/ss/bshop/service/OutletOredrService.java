package ss.bshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.IOutletOrder;
import ss.bshop.domain.OutletOrder;

@Service
@Transactional(readOnly = true)
public class OutletOredrService implements IOutletOrderService{
	
	@Autowired
	private IOutletOrder outletOrderDAO;

	public IOutletOrder getOutletOrderDAO() {
		return outletOrderDAO;
	}

	public void setOutletOrderDAO(IOutletOrder outletOrderDAO) {
		this.outletOrderDAO = outletOrderDAO;
	}

	@Transactional(readOnly = false)
	@Override
	public void add(OutletOrder outletOrder) {
		getOutletOrderDAO().add(outletOrder);
		
	}

	@Override
	public OutletOrder get(Long id) {
		return getOutletOrderDAO().get(id);
	}

	@Override
	public List<OutletOrder> getAll() {
	return getOutletOrderDAO().getAll();
	}

	@Transactional(readOnly = false)
	@Override
	public void remove(Long id) {
		getOutletOrderDAO().remove(id);
		
	}

	@Transactional(readOnly = false)
	@Override
	public void update(OutletOrder outletOrder) {
		getOutletOrderDAO().update(outletOrder);
		
	}

}
