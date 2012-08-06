package ss.bshop.mbeans.datamodel;

import org.primefaces.model.SelectableDataModel;

import ss.bshop.domain.Supplier;
import ss.bshop.domain.User;

import javax.faces.model.ListDataModel;
import java.util.List;

public class SupplierDataModel extends ListDataModel<Supplier> implements SelectableDataModel<Supplier> {    
  
    public SupplierDataModel() {  
    }  
  
    public SupplierDataModel(List<Supplier> data) {  
        super(data);  
    }  

    public Supplier getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
       Long key = Long.parseLong(rowKey);
        List<Supplier> Suppliers = (List<Supplier>) getWrappedData();  
          
        for(Supplier Supplier : Suppliers) {  
            if(Supplier.getId()==key)
                return Supplier;  
        }  
          
        return null;  
    }  
    
    
    public Object getRowKey(Supplier Supplier) {
        return String.valueOf(Supplier.getId());  
    }  
}  

