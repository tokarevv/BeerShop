package ss.bshop.mbeans;

import java.util.List;

import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import ss.bshop.domain.SupOrderStructure;


public class SuplOrderStructDataModel extends ListDataModel<SupOrderStructure> 
implements SelectableDataModel<SupOrderStructure> {    
  
    public SuplOrderStructDataModel() {  
    }  
  
    public SuplOrderStructDataModel(List<SupOrderStructure> data) {  
        super(data);  
    }  

    public SupOrderStructure getRowData(String rowKey) {  
    	
    	Long key = Long.parseLong(rowKey);
        List<SupOrderStructure> orders = (List<SupOrderStructure>) getWrappedData();  
          
        for(SupOrderStructure order : orders) {  
            if(order.getId()==key)
                return order;  
        }  
          
        return null;  
    }  
    
    
    public Object getRowKey(SupOrderStructure orderStruct) {
        return String.valueOf(orderStruct.getId());  
    }  
}  

