package ss.bshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.ISuperVisorDAO;
import ss.bshop.domain.SuperVisor;

@Service
@Transactional(readOnly = true)
public class SuperVisorService implements ISuperVisorService{
	
	@Autowired
	private ISuperVisorDAO superVisorDAO;
	
	public ISuperVisorDAO getSuperVisorDAO() {
		return superVisorDAO;
	}

	public void setSuperVisorDAO(ISuperVisorDAO superVisorDAO) {
		this.superVisorDAO = superVisorDAO;
	}

	@Transactional(readOnly = false)
	@Override
	public void add(SuperVisor superVisor) {
		superVisorDAO.addSuperVisor(superVisor);
		
	}

	@Override
	public SuperVisor get(Long id) {
		return (SuperVisor) superVisorDAO.getSuperVisor(id);
	}

	@Override
	public List<SuperVisor> getAll() {
		return superVisorDAO.getAllSuperVisors();
	}

	@Transactional(readOnly = false)
	@Override
	public void remove(Long id) {
		superVisorDAO.removeSuperVisor(id);
		
	}
	
	@Transactional(readOnly = false)
	@Override
	public void update(SuperVisor superVisor) {
		superVisorDAO.updateSuperVisor(superVisor);
	}

}
