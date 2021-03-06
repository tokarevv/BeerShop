package ss.bshop.mbeans;

import ss.bshop.mbeans.datamodel.SuplOrderDataModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.event.RowEditEvent;

import ss.bshop.domain.SupOrderStructure;
import ss.bshop.domain.SupplierOrder;
import ss.bshop.service.ISupplierOrderService;
import ss.bshop.service.ISupplierOrderStructureService;
import ss.bshop.service.SupplierOrderStructureService;


@ManagedBean(name="suplOrderMB")
@RequestScoped
public class SuplOrderMB  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{supplierOrderService}")
	ISupplierOrderService supplierOrderService;
	
	SupplierOrder selected;
	
	List<SupplierOrder> supplierOrderList;
	
	@ManagedProperty(value = "#{SuplOrderDataModel}")
    private SuplOrderDataModel model;
	
	@PostConstruct
    protected void postConstruct() {
		supplierOrderList = new ArrayList<SupplierOrder>();
		supplierOrderList.addAll(getSupplierOrderService().getAll()); 
    	model = new SuplOrderDataModel(supplierOrderList);
    }  
        
    public void editRow(RowEditEvent event) {
    	SupplierOrder rowItem = (SupplierOrder) event.getObject();
       getSupplierOrderService().update(rowItem); 
       selected=null;
    }
    
    public String createNew() {
    	SupplierOrder order=new SupplierOrder();
    	//order.setName("default");
    	supplierOrderList.add(order);
    	getSupplierOrderService().add(order);  	
        return "";
    }

     public String delete() {
     	if(selected!=null){
     		getSupplierOrderService().remove(selected.getId());
     		supplierOrderList.remove(selected);
     	}
     	return "";
     }
     
//     public String moreDetail(){
//         String res = "";
//         if(selected!=null ){ 
//        uploadStructure();
//          res = "suplOrder";                        
//         }
//         return res;
//     }
   
	
	public SuplOrderDataModel getModel() {
		return model;
	}

	public void setModel(SuplOrderDataModel model) {
		this.model = model;
	}

	public SupplierOrder getSelected() {
		return selected;
	}

	public void setSelected(SupplierOrder selected) {
		this.selected = selected;
	}

	public ISupplierOrderService getSupplierOrderService() {
		return supplierOrderService;
	}

	public void setSupplierOrderService(ISupplierOrderService supplierOrderService) {
		this.supplierOrderService = supplierOrderService;
	}

	public List<SupplierOrder> getSupplierOrderList() {
		return supplierOrderList;
	}

	public void setSupplierOrderList(List<SupplierOrder> supplierOrderList) {
		this.supplierOrderList = supplierOrderList;
	}

	//-----------------------------


	@ManagedProperty(value="#{supplierOrderStructService}")
	ISupplierOrderStructureService supplierOrderStructService;
	
	List<SupOrderStructure> supplierOrderStructList ;
	
	private void uploadStructure(){
		List<SupOrderStructure> allStruct=new ArrayList<SupOrderStructure>();
		allStruct.addAll(getSupplierOrderStructService().getAll());
		for(SupOrderStructure structure: allStruct){
			if(selected.equals(structure.getSupplierOrder())){
				supplierOrderStructList.add(structure);
			}
		}
	}

	public ISupplierOrderStructureService getSupplierOrderStructService() {
		return supplierOrderStructService;
	}

	public void setSupplierOrderStructService(
			ISupplierOrderStructureService supplierOrderStructService) {
		this.supplierOrderStructService = supplierOrderStructService;
	}

	public List<SupOrderStructure> getSupplierOrderStructList() {
		return supplierOrderStructList;
	}

	public void setSupplierOrderStructList(
			List<SupOrderStructure> supplierOrderStructList) {
		this.supplierOrderStructList = supplierOrderStructList;
	}

	public String addToBase(){
		Long id=selected.getId();
		for(SupOrderStructure structure : getSupplierOrderStructList() ){
		//	if()
			
		}
		return "recept";
	}
	
		
	
   }
