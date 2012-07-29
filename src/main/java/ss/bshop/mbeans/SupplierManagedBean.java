package ss.bshop.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

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
	List<Supplier> supplierList;
	
	@ManagedProperty(value = "#{SupplierDataModel}")
    private SupplierDataModel model;
	
	@PostConstruct
    protected void postConstruct() {
		supplierList = new ArrayList<Supplier>();
    	supplierList.addAll(getSupplierService().getAll()); 
    	model = new SupplierDataModel(supplierList);
    }  
        
    public void editRow(RowEditEvent event) {
       Supplier rowItem = (Supplier) event.getObject();
       getSupplierService().update(rowItem); 
       selected=null;
    }
    
    public String createNew() {
    	Supplier supplier=new Supplier();
    	supplier.setName("default");
    	supplierList.add(supplier);
    	getSupplierService().add(supplier);  	
        return "";
    }

     public String delete() {
     	if(selected!=null){
     		getSupplierService().remove(selected.getId());
     		supplierList.remove(selected);
     	}
     	return "";
     }
   
	
	public SupplierDataModel getModel() {
		return model;
	}

	public void setModel(SupplierDataModel model) {
		this.model = model;
	}

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

	public List<Supplier> getSupplierList() {
      	return supplierList;
	}

	public void setSupplierList(List<Supplier> supplierList) {
		this.supplierList = supplierList;
	}
	
	
   }
