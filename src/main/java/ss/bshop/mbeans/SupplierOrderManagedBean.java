package ss.bshop.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import ss.bshop.domain.Supplier;
import ss.bshop.service.ISupplierService;

@ManagedBean(name="supplierOrderMB")
@RequestScoped
public class SupplierOrderManagedBean{

	@ManagedProperty(value="#{supplierService}")
	ISupplierService supplierService;
	
	private Supplier selected;
	
	private String orderType;
	
	public Supplier getSelected() {
		return selected;
	}

	public void setSelected(Supplier selected) {
		this.selected = selected;
	}

	public ISupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(ISupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
}
