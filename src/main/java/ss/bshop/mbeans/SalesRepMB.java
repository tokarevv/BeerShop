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
import org.primefaces.event.SelectEvent;
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
    
    @ManagedProperty(value = "#{outletService}")
    private IOutletService outletService;

    @ManagedProperty(value = "#{SalesRepDataModel}")
    private SalesRepDataModel modelsr;
    
    private SalesRep selected;
    private List<Outlet> outletList;
    private List<SalesRep> salesReps;
 
    @PostConstruct
    protected void postConstruct() {
        modelsr = new SalesRepDataModel(salesRepService.getAll());
        salesReps = salesRepService.getAll();
    }  
    
    public void onRowSelect(SelectEvent event){
        setOutletList(outletService.getBySalesRep(selected));
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

    public IOutletService getOutletService() {
        return outletService;
    }

    public void setOutletService(IOutletService outletService) {
        this.outletService = outletService;
    }
    
    public SalesRep getSelected() {
        return selected;
    }

    public void setSelected(SalesRep selected) {
        this.selected = selected;
    }

	public List<SalesRep> getSalesReps() {
		return salesReps;
	}

	public void setSalesReps(List<SalesRep> salesReps) {
		this.salesReps = salesReps;
	}

	public List<Outlet> getOutletList() {
		return outletList;
	}

	public void setOutletList(List<Outlet> outletList) {
		this.outletList = outletList;
	}

    
    
 }
