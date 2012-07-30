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
import javax.faces.event.ActionEvent;

import org.primefaces.event.RowEditEvent;
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
@ManagedBean(name = "outletMB")
@RequestScoped
public class OutletManagedBean implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{outletService}")
    private IOutletService outletService;
    
    private MapModel mapModel;
    private LatLng curCoord; 
    private double lat;  
    private double lng;  

    private List<Outlet> outletList = new ArrayList<Outlet>();
    
    @ManagedProperty(value = "#{OutletDataModel}")
    private OutletDataModel model;
    private Outlet selected;
    private FacesMessage msg;

 
    @PostConstruct
    protected void postConstruct() {

        mapModel = new DefaultMapModel();  

    	outletList = new ArrayList<Outlet>();
        outletList.addAll(getOutletService().getAll());
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
       if(selected!=null){ 
           // mapModel = new DefaultMapModel();
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
    
    public void editSelected() {

        getOutletService().update(selected);
        
        msg = new FacesMessage("Outlet Edited", selected.getName());   
        FacesContext.getCurrentInstance().addMessage(null, msg); 
    }
    
    public void addMarker(ActionEvent actionEvent) {
        if(selected.getLatitude()!=selected.getLongitude()){
            Marker marker = new Marker(new LatLng(lat, lng), selected.getName());  
            mapModel.addOverlay(marker); 
            selected.setLatitude(lat);
            selected.setLongitude(lng);

            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng);  
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
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

    
    
 }
