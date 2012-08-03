/**
 * @author Kostya Tarasov
 */
package ss.bshop.service;

import java.io.Serializable;
import java.util.List;

import ss.bshop.domain.SalesRep;

public interface ISalesRepService extends Serializable{

	public SalesRep getSalesRepForLogin(String salesRepLogin);
	
	public List<SalesRep> getAll();
	public void add(SalesRep salesRep);
	public SalesRep get(Long id);
	public void remove(Long id);
	public void update(SalesRep salesRep);

}
