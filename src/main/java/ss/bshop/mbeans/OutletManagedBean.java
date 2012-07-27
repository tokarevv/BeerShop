package ss.bshop.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import ss.bshop.domain.Outlet;
import ss.bshop.service.IOutletService;

/**
 * Outlet Managed Bean
  * @author Vera
 */
@ManagedBean(name = "outletMB")
@RequestScoped
public class OutletManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{outletService}")
    IOutletService outletService;

    List<Outlet> outletList = new ArrayList<Outlet>();
    @ManagedProperty(value = "#{OutletDataModel}")
    private OutletDataModel model;
    Outlet selected;

 
    @PostConstruct
    protected void postConstruct() {
        getData();
        updateModel();
    }  
    
    private void getData() {
        outletList = new ArrayList<Outlet>();
        outletList.addAll(getOutletService().getAll()); 
    }
    
    private void updateModel() {
        model = new OutletDataModel(outletList);
        selected=null;
    }
    
     public void editRow(RowEditEvent event) {
    	 Outlet rowItem = (Outlet) event.getObject();
        if(rowItem.getId()==0) {getOutletService().add(rowItem);}
        {getOutletService().update(rowItem); }
        getData();
        updateModel();
    }

    public List<Outlet> getoutletList() {
        return outletList;
    }

    // 
    public OutletDataModel getModel() {
        return model;
    }
    
    public void setModel(OutletDataModel model) {
        this.model = model;
    }

     public IOutletService getOutletService() {
		return outletService;
	}

	public void setOutletService(IOutletService outletService) {
		this.outletService = outletService;
	}

	public void setoutletList(List<Outlet> outletList) {
        this.outletList = outletList;
    }


    public Outlet getSelected() {
        return selected;
    }

    public void setSelected(Outlet selected) {
        this.selected = selected;
    }

   public String createNew() {
       outletList.add(new Outlet());
       getData();
       updateModel();
       return "";
   }

    public String delete() {
    	if(selected!=null){
            getOutletService().remove(selected.getId());
       	    getData();
            updateModel();
    	}
    	return "";
    }
    
 }
