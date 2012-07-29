package ss.bshop.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ss.bshop.domain.Outlet;
import ss.bshop.domain.SalesRep;
import ss.bshop.service.IOutletService;
import ss.bshop.service.ISalesRepService;

/**
 * Outlet Managed Bean
  * @author Vera
 */
@ManagedBean(name = "outletMB")
@RequestScoped
public class OutletManagedBean implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{outletService}")
    private IOutletService outletService;
    
    @ManagedProperty(value = "#{salesRepService}")
    private ISalesRepService salesRepService;

    private List<Outlet> outletList = new ArrayList<Outlet>();
    private List<SalesRep> srlst = new ArrayList<SalesRep>();
    
    @ManagedProperty(value = "#{OutletDataModel}")
    private OutletDataModel model;
    private Outlet selected;
    private FacesMessage msg;

 
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
    
    public String createNew() {
       outletList.add(new Outlet());
       getData();
       updateModel();
       return "";
   }
    
   public String moreDetail(){
       return "outlet_detail";
   }

    public String delete() {
        
        if(selected!=null){
            getOutletService().remove(selected.getId());
            outletList.remove(selected);
            selected = null;

            msg = new FacesMessage("Outlet Deleted","");   
            FacesContext.getCurrentInstance().addMessage(null, msg);
     	}
     	return "";
    }
    
    
    public void editRow(RowEditEvent event) {
    	Outlet rowItem = (Outlet) event.getObject();
        getOutletService().update(rowItem);
        
        msg = new FacesMessage("Article Edited", rowItem.getName());   
        FacesContext.getCurrentInstance().addMessage(null, msg); 
    }

    public List<Outlet> getoutletList() {
        return outletList;
    }

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

   

    public List<SalesRep> getSrlst() {
        return getSalesRepService().getAll();
    }

    public void setSrlst(List<SalesRep> srlst) {
        this.srlst = srlst;
    }

    public ISalesRepService getSalesRepService() {
        return salesRepService;
    }

    public void setSalesRepService(ISalesRepService salesRepService) {
        this.salesRepService = salesRepService;
    }
    
    
    
 }
