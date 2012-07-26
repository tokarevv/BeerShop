package ss.bshop.mbeans;

import org.primefaces.model.SelectableDataModel;

import ss.bshop.domain.User;

import javax.faces.model.ListDataModel;
import java.util.List;

public class UserDataModel extends ListDataModel<User> implements SelectableDataModel<User> {    
  
    public UserDataModel() {  
    }  
  
    public UserDataModel(List<User> data) {  
        super(data);  
    }  

    @Override
    public User getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
        int key = Integer.parseInt(rowKey);
        List<User> Users = (List<User>) getWrappedData();  
          
        for(User User : Users) {  
            if(User.getId()==key)
                return User;  
        }  
          
        return null;  
    }  
    
    @Override
    public Object getRowKey(User User) {
        return String.valueOf(User.getId());  
    }  
}  

