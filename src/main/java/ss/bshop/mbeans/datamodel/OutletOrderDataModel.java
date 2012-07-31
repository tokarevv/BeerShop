package ss.bshop.mbeans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import ss.bshop.domain.OutletOrder;


public class OutletOrderDataModel extends ListDataModel<OutletOrder> 
	implements SelectableDataModel<OutletOrder> {    
  
    public OutletOrderDataModel() {  
    }  
  
    public OutletOrderDataModel(List<OutletOrder> data) {  
        super(data);  
    }  

    @Override
    public OutletOrder getRowData(String rowKey) {  

        Long key = Long.parseLong(rowKey);
       	List<OutletOrder> orders = (List<OutletOrder>) getWrappedData();  
          
        for(OutletOrder order : orders) {  
            if(order.getId()==key)
                return order;  
        }  
          
        return null;  
    }  
    
    @Override
    public Object getRowKey(OutletOrder order) {
        return String.valueOf(order.getId());  
    }  
}  

