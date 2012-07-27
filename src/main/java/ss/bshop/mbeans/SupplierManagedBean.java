package ss.bshop.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import ss.bshop.dao.ISupplierDAO;
import ss.bshop.domain.Supplier;
import ss.bshop.service.ISupplierService;

@ManagedBean(name="supplierMB")
@RequestScoped
public class SupplierManagedBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{supplierService}")
	ISupplierService supplierService;
	
	Supplier selected;
	
	public Supplier getSelected() {
		return selected;
	}

	public void setSelected(Supplier selected) {
		this.selected = selected;
	}

	List<Supplier> supplierList;


	public ISupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(ISupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public List<Supplier> getSupplierList() {
        supplierList=new ArrayList<Supplier>();
        supplierList.addAll(supplierService.getAll());
		return supplierList;
	}

	public void setSupplierList(List<Supplier> supplierList) {
		this.supplierList = supplierList;
	}
	
	

}
