/**
 * @author Kostya Tarasov
 */
package ss.bshop.service;

import ss.bshop.domain.SalesRep;

public interface ISalesRepService {

	public SalesRep getSalesRepForLogin(String salesRepLogin);

}
