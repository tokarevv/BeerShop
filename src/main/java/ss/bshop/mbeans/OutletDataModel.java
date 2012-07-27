package ss.bshop.mbeans;

import org.primefaces.model.SelectableDataModel;
import ss.bshop.domain.Outlet;


import javax.faces.model.ListDataModel;
import java.util.List;

/**
 * Outlet Managed Bean
  * @author Vera
 */

public class OutletDataModel extends ListDataModel<Outlet> implements SelectableDataModel<Outlet> {    
  
    public OutletDataModel() {  
    }  
  
    public OutletDataModel(List<Outlet> data) {  
        super(data);  
    }  

    public Outlet getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
       Long key = Long.parseLong(rowKey);
        List<Outlet> outlets = (List<Outlet>) getWrappedData();  
          
        for(Outlet outlet : outlets) {  
            if(outlet.getId()==key)
                return outlet;  
        }  
          
        return null;  
    }  
    
    
    public Object getRowKey(Outlet outlet) {
        return String.valueOf(outlet.getId());  
    }

}  

