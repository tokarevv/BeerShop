package ss.bshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.IVisitDAO;
import ss.bshop.domain.Visit;

@Service
@Transactional
public class VisitService implements IVisitService {

	@Autowired
	private IVisitDAO visitDAO;

	@Override
	public void add(Visit visit) {
		visitDAO.add(visit);
	}

	@Override
	public Visit get(Long id) {
		return visitDAO.get(id);
	}

	@Override
	public List<Visit> getAll() {
		return visitDAO.getAll();
	}

	@Override
	public void remove(Long id) {
		visitDAO.remove(id);
	}

	@Override
	public void update(Visit entety) {
		visitDAO.update(entety);		
	}

}
