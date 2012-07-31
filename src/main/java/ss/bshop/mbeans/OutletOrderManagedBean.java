package ss.bshop.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import ss.bshop.domain.OutletOrder;
import ss.bshop.service.IOutletOrderService;


@ManagedBean(name="outletOrderMB")
@RequestScoped
public class OutletOrderManagedBean  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{outletOrderService}")
	IOutletOrderService outletOrderService;
	OutletOrder selected;
	List<OutletOrder> outletOrderList;
	
	@ManagedProperty(value = "#{OutletOrderDataModel}")
    private OutletOrderDataModel model;
	
	@PostConstruct
    protected void postConstruct() {
		outletOrderList = new ArrayList<OutletOrder>();
		outletOrderList.addAll(getOutletOrderService().getAll()); 
    	model = new OutletOrderDataModel(outletOrderList);
    }  
        
    public void editRow(RowEditEvent event) {
    	OutletOrder rowItem = (OutletOrder) event.getObject();
       getOutletOrderService().update(rowItem); 
       selected=null;
    }
    
    public String createNew() {
    	OutletOrder order=new OutletOrder();
    	//order.setName("default");
    	outletOrderList.add(order);
    	getOutletOrderService().add(order);  	
        return "";
    }

     public String delete() {
     	if(selected!=null){
     		getOutletOrderService().remove(selected.getId());
     		outletOrderList.remove(selected);
     	}
     	return "";
     }
     
     public String moreDetail(){
         String res = "";
         if(selected!=null ){ 
          res = "outletOrder";
                          
         }
         return res;
     }

	public IOutletOrderService getOutletOrderService() {
		return outletOrderService;
	}

	public void setOutletOrderService(IOutletOrderService outletOrderService) {
		this.outletOrderService = outletOrderService;
	}

	public OutletOrder getSelected() {
		return selected;
	}

	public void setSelected(OutletOrder selected) {
		this.selected = selected;
	}

	public List<OutletOrder> getOutletOrderList() {
		return outletOrderList;
	}

	public void setOutletOrderList(List<OutletOrder> outletOrderList) {
		this.outletOrderList = outletOrderList;
	}

	public OutletOrderDataModel getModel() {
		return model;
	}

	public void setModel(OutletOrderDataModel model) {
		this.model = model;
	}

	
   }
