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
  * @author Vera
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
    private Outlet current;
    
    private FacesMessage msg;

 
    @PostConstruct
    protected void postConstruct() {

        mapModel = new DefaultMapModel();  

    	outletList = new ArrayList<Outlet>();
        outletList.addAll(outletService.getAll());
        model = new OutletDataModel(outletList);

    }  
   
    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook)document;
        HSSFSheet sheet = wb.getSheetAt(0);

        Iterator<Row> rit = sheet.rowIterator();

        if( rit.hasNext() ) {
            rit.next(); // Skip header row
        }

        while( rit.hasNext() ) {
            HSSFRow row = (HSSFRow) rit.next();

            Iterator<Cell> cit = row.cellIterator();

            while( cit.hasNext() ) {
                HSSFCell cell = (HSSFCell) cit.next();

                if( cell.getCellType() == HSSFCell.CELL_TYPE_STRING ) {
                    String content = cell.getRichStringCellValue().toString();

                    int index = content.indexOf( "org.primefaces.component.celleditor" );

                    if( index != -1 ) {
                        content = content.substring( 0, index );
                        cell.setCellValue( new HSSFRichTextString( content ) );
                    }
                }
            }
        }
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
            try {
                // mapModel = new DefaultMapModel();
                 current = selected.clone();
                 if(current.getLatitude()!=current.getLongitude()){
                    curCoord = new LatLng(current.getLatitude(),current.getLongitude());
                    mapModel.addOverlay(new Marker(curCoord, current.getName()));
                }
            res = "outlet_detail";
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(OutletMB.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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

        getOutletService().update(current);
        
        msg = new FacesMessage("Outlet Edited", current.getName());   
        FacesContext.getCurrentInstance().addMessage(null, msg); 
        return "";
    }
    
    public void addMarker(ActionEvent actionEvent) {
        System.out.println("!!!!!!!!!!!!!tryAddMarker");
        if(selected.getLatitude()==null){
//            Marker marker = new Marker(new LatLng(lat, lng), selected.getName());
//            marker.setDraggable(true);
//            mapModel.addOverlay(marker); 
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

    public Outlet getCurrent() {
        return current;
    }

    public void setCurrent(Outlet current) {
        this.current = current;
    }

	public List<SalesRep> getSalesReps() {
		return salesReps;
	}

	public void setSalesReps(List<SalesRep> salesReps) {
		this.salesReps = salesReps;
	}

    public SalesRepDataModel getModelsr() {
        return modelsr;
    }

    public void setModelsr(SalesRepDataModel modelsr) {
        this.modelsr = modelsr;
    }

    
    
 }
