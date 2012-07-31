package ss.bshop.mbeans;

import ss.bshop.mbeans.datamodel.SalesRepDataModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import ss.bshop.domain.Outlet;
import ss.bshop.domain.SalesRep;
import ss.bshop.service.IOutletService;
import ss.bshop.service.ISalesRepService;

/**
 * Outlet Managed Bean
  * @author Vera
 */
@ManagedBean(name = "salesRepMB")
@ViewScoped
public class SalesRepMB implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @ManagedProperty(value = "#{salesRepService}")
    private ISalesRepService salesRepService;

    @ManagedProperty(value = "#{SalesRepDataModel}")
    private SalesRepDataModel modelsr;
    
    private SalesRep selected;
 
    @PostConstruct
    protected void postConstruct() {
        modelsr = new SalesRepDataModel(salesRepService.getAll());
    }  
    
    public void onSelectSR(){
        //outletList = outletService.getBySalesRep(selectedSalesRep);
    }
    
    //************************************* setters and getters

    public SalesRepDataModel getModelsr() {
        return modelsr;
    }

    public void setModelsr(SalesRepDataModel modelsr) {
        this.modelsr = modelsr;
    }

    public ISalesRepService getSalesRepService() {
        return salesRepService;
    }

    public void setSalesRepService(ISalesRepService salesRepService) {
        this.salesRepService = salesRepService;
    }

    public SalesRep getSelected() {
        return selected;
    }

    public void setSelected(SalesRep selected) {
        this.selected = selected;
    }

    
    
 }
