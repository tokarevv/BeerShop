package ss.bshop.service;

import java.util.List;

import ss.bshop.domain.SupOrderStructure;

public interface ISupplierOrderStructureService {
	
	public void add(SupOrderStructure orderStructure);

	public SupOrderStructure get(Long orgerId);

	public List<SupOrderStructure> getAll();

	public void remove(Long id);
	
	public void update(SupOrderStructure orderStructure);
}
