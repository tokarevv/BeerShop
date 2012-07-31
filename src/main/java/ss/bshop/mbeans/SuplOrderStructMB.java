package ss.bshop.mbeans;

import ss.bshop.mbeans.datamodel.SuplOrderStructDataModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;

import ss.bshop.domain.SupOrderStructure;
import ss.bshop.service.ISupplierOrderStructureService;

@ManagedBean(name = "suplStructMB")
@SessionScoped
public class SuplOrderStructMB implements Serializable {
	
    private static final long serialVersionUID = 1L;

    //Spring User Service is injected...
    @ManagedProperty(value = "#{supplierOrderStructureService}")
    ISupplierOrderStructureService supplierOrderStructureService;
        
    List<SupOrderStructure> suplStructureList ;;
   
    @ManagedProperty(value = "#{suplOrderStructDataModel}")
    private SuplOrderStructDataModel model;
    
    @ManagedProperty(value = "#{suplOrderManagedBean}")
    SuplOrderMB orderBean;
    
   	public SuplOrderMB getOrderBean() {
		return orderBean;
	}

	public void setOrderBean(SuplOrderMB orderBean) {
		this.orderBean = orderBean;
	}
	
	 @Autowired
	FacesContext context;
    
   
    @PostConstruct
    protected void postConstruct() {
    	suplStructureList = new ArrayList<SupOrderStructure>(); 
    	suplStructureList.add(new SupOrderStructure());
    	//suplStructureList.addAll(orderBean.getSelected().getOrderstruct());
        model = new SuplOrderStructDataModel(suplStructureList);
        
        
    }  
    SupOrderStructure selected;
//	private void getBean(){
//		context=FacesContext.getCurrentInstance();
//		
//		SuplOrderManagedBean  bean= (SuplOrderManagedBean) context.getApplication().evaluateExpressionGet(context, "#{supplierOrderMB}", SuplOrderManagedBean.class);
//		//
//	}
        
     public void editRow(RowEditEvent event) {
    	 SupOrderStructure rowItem = (SupOrderStructure) event.getObject();        	
        	getSupplierOrderStructureService().update(rowItem); 
         
       }
     
    
   public String createNew() {
	   SupOrderStructure structure=new SupOrderStructure();
	   getSupplierOrderStructureService().add(structure);
       suplStructureList.add(structure);
       return "";
   }
   
  
    public String delete() {
    	if(selected!=null){
    		getSupplierOrderStructureService().remove(selected.getId());
            suplStructureList.remove(selected);                      	
            selected = null;
    	}
    	return "";
    }

	public ISupplierOrderStructureService getSupplierOrderStructureService() {
		return supplierOrderStructureService;
	}

	public void setSupplierOrderStructureService(
			ISupplierOrderStructureService supplierOrderStructureService) {
		this.supplierOrderStructureService = supplierOrderStructureService;
	}

	public List<SupOrderStructure> getSuplStructureList() {
		return suplStructureList;
	}

	public void setSuplStructureList(List<SupOrderStructure> suplStructureList) {
		this.suplStructureList = suplStructureList;
	}

	public SuplOrderStructDataModel getModel() {
		return model;
	}

	public void setModel(SuplOrderStructDataModel model) {
		this.model = model;
	}

	public SupOrderStructure getSelected() {
		return selected;
	}

	public void setSelected(SupOrderStructure selected) {
		this.selected = selected;
	}
    
   
	
	
    
 }
