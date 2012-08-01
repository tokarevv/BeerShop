package ss.bshop.mbeans.datamodel;

import org.primefaces.model.SelectableDataModel;

import ss.bshop.domain.SupplierOrder;
import javax.faces.model.ListDataModel;
import java.util.List;


public class SuplOrderDataModel extends ListDataModel<SupplierOrder> 
	implements SelectableDataModel<SupplierOrder> {    
  
    public SuplOrderDataModel() {  
    }  
  
    public SuplOrderDataModel(List<SupplierOrder> data) {  
        super(data);  
    }  

    @Override
    public SupplierOrder getRowData(String rowKey) {  

        Long key = Long.parseLong(rowKey);
        List<SupplierOrder> orders = (List<SupplierOrder>) getWrappedData();  
          
        for(SupplierOrder order : orders) {  
            if(order.getId()==key)
                return order;  
        }  
          
        return null;  
    }  
    
    @Override
    public Object getRowKey(SupplierOrder order) {
        return String.valueOf(order.getId());  
    }  
}  

