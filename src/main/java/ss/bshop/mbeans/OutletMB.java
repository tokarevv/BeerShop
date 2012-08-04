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
@ManagedBean(name = "outletMB")
@SessionScoped
public class OutletMB implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{outletService}")
    private IOutletService outletService;
    
    private MapModel mapModel;
    private LatLng curCoord; 
    private double lat;  
    private double lng;

    private List<Outlet> outletList = new ArrayList<Outlet>();
    private List<SalesRep> salesReps = new ArrayList<SalesRep>();
    
    @ManagedProperty(value = "#{OutletDataModel}")
    private OutletDataModel model;
    
    @ManagedProperty(value = "#{SalesRepDataModel}")
    private SalesRepDataModel modelsr;
    
    private Outlet selected;
    
    private FacesMessage msg;

 
    @PostConstruct
    protected void postConstruct() {

        mapModel = new DefaultMapModel();  

    	outletList = new ArrayList<Outlet>();
        outletList.addAll(outletService.getAll());
        model = new OutletDataModel(outletList);

    }  
    
    public String createNew() {
       Outlet outlet=new Outlet();
       outlet.setName("default");
       outletList.add(outlet);
       getOutletService().add(outlet);
       return "";
   }
    
   public String moreDetail(){
       String res = "";
       if(selected!=null ){ 
                 mapModel = new DefaultMapModel();
                 if(selected.getLatitude()!=selected.getLongitude()){
                    curCoord = new LatLng(selected.getLatitude(),selected.getLongitude());
                    mapModel.addOverlay(new Marker(curCoord, selected.getName()));
                }
            res = "outlet_detail";
            
       }
       return res;
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
        
        msg = new FacesMessage("Outlet Edited", rowItem.getName());   
        FacesContext.getCurrentInstance().addMessage(null, msg); 
    }
    
    public String editSelected() {

        getOutletService().update(selected);
        
        msg = new FacesMessage("Outlet Edited", selected.getName());   
        FacesContext.getCurrentInstance().addMessage(null, msg); 
        return "";
    }
    
    public void addMarker(ActionEvent actionEvent) {

        if(selected.getLatitude()==null){
            Marker marker = new Marker(new LatLng(lat, lng), selected.getName());
            marker.setDraggable(true);
            mapModel.addOverlay(marker); 
            selected.setLatitude(lat);
            selected.setLongitude(lng);

        }
    }  
    public void onMarkerDrag(MarkerDragEvent event) {  
        Marker marker = event.getMarker();  
        LatLng lt = marker.getLatlng();
         
        selected.setLatitude(lt.getLat());
        selected.setLongitude(lt.getLng());
    }  

    // setters and getters
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

    public MapModel getMapModel() {
        return mapModel;
    }

    public void setMapModel(MapModel mapModel) {
        this.mapModel = mapModel;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

	

    public SalesRepDataModel getModelsr() {
        return modelsr;
    }

    public void setModelsr(SalesRepDataModel modelsr) {
        this.modelsr = modelsr;
    }
       
 }
