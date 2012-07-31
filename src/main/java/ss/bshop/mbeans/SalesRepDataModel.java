package ss.bshop.mbeans;

import org.primefaces.model.SelectableDataModel;
import ss.bshop.domain.Outlet;


import javax.faces.model.ListDataModel;
import java.util.List;
import ss.bshop.domain.SalesRep;

/**
 * Outlet Managed Bean
  * @author Nck
 */

public class SalesRepDataModel extends ListDataModel<SalesRep> implements SelectableDataModel<SalesRep> {    
  
    public SalesRepDataModel() {  
    }  
  
    public SalesRepDataModel(List<SalesRep> data) {  
        super(data);  
    }  

    public SalesRep getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
       Long key = Long.parseLong(rowKey);
        List<SalesRep> srlst= (List<SalesRep>) getWrappedData();  
          
        for(SalesRep sr : srlst) {  
            if(sr.getId()==key)
                return sr;  
        }  
          
        return null;  
    }  
    
    
    public Object getRowKey(SalesRep sr) {
        return String.valueOf(sr.getId());  
    }


}  

