package ss.bshop.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import ss.bshop.domain.User;
import ss.bshop.service.IUserService;


/**
 * User Managed Bean
 *
 * @author onlinetechvision.com
 * @version 1.0.0
 * @since 25 Mar 2012
 */
@ManagedBean(name = "userMB")
@RequestScoped
public class UserManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

    //Spring User Service is injected...
    @ManagedProperty(value = "#{userService}")
    IUserService userService;

    List<User> userList = new ArrayList<User>();
    @ManagedProperty(value = "#{UserDataModel}")
    private UserDataModel model;
    User selected;

 
    @PostConstruct
    protected void postConstruct() {
        getData();
        updateModel();
    }  
    
    private void getData() {
        userList = new ArrayList<User>();
        userList.addAll(getUserService().getUsers()); 
    }
    
    private void updateModel() {
        model = new UserDataModel(userList);
        selected=null;
    }
    
     public void editRow(RowEditEvent event) {
        User rowItem = (User) event.getObject();
        if(rowItem.getId()==0) {getUserService().addUser(rowItem);}
        {getUserService().updateUser(rowItem); }
        getData();
        updateModel();
    }

    public List<User> getUserList() {
        return userList;
    }

    // 
    public UserDataModel getModel() {
        return model;
    }
    
    public void setModel(UserDataModel model) {
        this.model = model;
    }

    public IUserService getUserService() {
        return userService;
    }


    public void setUserService(IUserService userService) {
        this.userService = userService;
    }


    public void setUserList(List<User> userList) {
        this.userList = userList;
    }


    public User getSelected() {
        return selected;
    }

    public void setSelected(User selected) {
        this.selected = selected;
    }

   public String createNew() {
       userList.add(new User());
       getData();
       updateModel();
       return "";
   }

    public String delete() {
    	if(selected!=null){
            getUserService().deleteUser(selected);
       	    getData();
            updateModel();
    	}
    	return "";
    }
    
 }
