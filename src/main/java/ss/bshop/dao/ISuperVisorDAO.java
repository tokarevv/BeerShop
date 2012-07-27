package ss.bshop.dao;

import java.util.List;

import ss.bshop.domain.SuperVisor;

public interface ISuperVisorDAO {
	public void addSuperVisor(SuperVisor superVisor);
	public void updateSuperVisor(SuperVisor superVisor);
	public void removeSuperVisor(Long id);
	public SuperVisor getSuperVisor(Long id);
	public List<SuperVisor> getAllSuperVisors();
}
