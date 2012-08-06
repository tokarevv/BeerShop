package ss.bshop.mbeans;

import ss.bshop.mbeans.datamodel.OutletDataModel;
import ss.bshop.mbeans.datamodel.SalesRepDataModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import ss.bshop.domain.Outlet;
import ss.bshop.domain.SalesRep;
import ss.bshop.service.IOutletService;

/**
 * Outlet Managed Bean
  * @author Nick
 */
@ManagedBean(name = "outletDetailMB")
@SessionScoped
public class OutletDetailMB implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{outletService}")
    private IOutletService outletService;
   
    private Outlet selected;
        
    private FacesMessage msg;

 
    @PostConstruct
    protected void postConstruct() {
//        selected = (Outlet) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selected");
       
    }  
    
   
    public String editSelected() {

       outletService.update(selected);
        
        msg = new FacesMessage("Outlet Edited", selected.getName());   
        FacesContext.getCurrentInstance().addMessage(null, msg); 
        return "";
    }
    

    
    public Outlet getSelected() {
        return selected;
    }

    public void setSelected(Outlet selected) {
        this.selected = selected;
    }

    public IOutletService getOutletService() {
        return outletService;
    }

    public void setOutletService(IOutletService outletService) {
        this.outletService = outletService;
    }

    
    
 }
