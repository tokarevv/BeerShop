package ss.bshop.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import ss.bshop.dao.ISupplierDAO;
import ss.bshop.domain.Supplier;
import ss.bshop.domain.User;
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
	
	@PostConstruct
    protected void postConstruct() {
        getData();
        updateModel();
    }  
    
    private void getData() {
    	supplierList = new ArrayList<Supplier>();
    	supplierList.addAll(getSupplierService().getAll()); 
    }
    
    private void updateModel() {
        model = new SupplierDataModel(supplierList);
        selected=null;
    }
    
    public void editRow(RowEditEvent event) {
        Supplier rowItem = (Supplier) event.getObject();
        if(rowItem.getId()==0) {getSupplierService().add(rowItem);}
        {getSupplierService().update(rowItem); }
        getData();
        updateModel();
    }
    
    public String createNew() {
    	supplierList.add(new Supplier());
    	getData();
        updateModel();
        return "";
    }

     public String delete() {
     	if(selected!=null){
     		getSupplierService().remove(selected.getId());
        	    getData();
             updateModel();
     	}
     	return "";
     }
   }
