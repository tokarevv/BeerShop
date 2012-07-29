package ss.bshop.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;

import ss.bshop.domain.Manager;
import ss.bshop.domain.SalesRep;
import ss.bshop.domain.SuperVisor;
import ss.bshop.domain.User;
import ss.bshop.service.IManagerService;
import ss.bshop.service.ISalesRepService;
import ss.bshop.service.ISuperVisorService;
import ss.bshop.service.IUserService;


/**
 * User Managed Bean
 *
 * @Vera
 */
@ManagedBean(name = "userMB")
@SessionScoped
public class UserManagedBean implements Serializable {
	
    private static final long serialVersionUID = 1L;

    //Spring User Service is injected...
    @ManagedProperty(value = "#{userService}")
    IUserService userService;
    
    @ManagedProperty(value = "#{suppervisorService}")
    ISuperVisorService suppervisorService;
    
    @ManagedProperty(value = "#{managerService}")
    IManagerService managerService;
    
    @ManagedProperty(value = "#{salesRepService}")
    ISalesRepService salesRepService;
    
    List<User> userList = new ArrayList<User>();
    @ManagedProperty(value = "#{UserDataModel}")
    private UserDataModel model;
    User selected;

 
    @PostConstruct
    protected void postConstruct() {
    	userList = new ArrayList<User>();
        userList.addAll(getUserService().getUsers());
        model = new UserDataModel(userList);
    }  
        
     public void editRow(RowEditEvent event) {
        User rowItem = (User) event.getObject();
        if(rowItem.getId()==null) {
        	getUserService().addUser(rowItem);
        	userList.add(rowItem);
        	}
        else{
        	getUserService().updateUser(rowItem); 
        	}
        
        addRoles(rowItem);
       
    }
     
     private void addRoles(User rowItem){
    	 if(rowItem.getPost().equals("supervisor")) {
      	   SuperVisor supervisor=new SuperVisor();
      	   supervisor.setUser(rowItem);
      		 getSuppervisorService().add(supervisor);
      		 }
         else if (rowItem.getPost().equals("manager")){ 
      	   Manager manager=new Manager();
      	   manager.setUser(rowItem);
      	   getManagerService().add(manager);
      	   }
         else if (rowItem.getPost().equals("sales rep")){ 
      	   SalesRep salesRep=new SalesRep();
      	   salesRep.setUser(rowItem);
      	   getSalesRepService().add(salesRep);
      	   } 
     }

    public ISuperVisorService getSuppervisorService() {
		return suppervisorService;
	}

	public void setSuppervisorService(ISuperVisorService suppervisorService) {
		this.suppervisorService = suppervisorService;
	}

	

	public IManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(IManagerService managerService) {
		this.managerService = managerService;
	}

	public ISalesRepService getSalesRepService() {
		return salesRepService;
	}

	public void setSalesRepService(ISalesRepService salesRepService) {
		this.salesRepService = salesRepService;
	}

	public List<User> getUserList() {
        return userList;
    }

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
	   User user=new User();
	   user.setLogin("default");
	   getUserService().addUser(user);
       userList.add(user);
       return "";
   }

    public String delete() {
    	if(selected!=null){
            getUserService().deleteUser(selected);
            userList.remove(selected);
            selected = null;
    	}
    	return "";
    }
    
   
	public String[] getPosts() {
        String[] posts = {"none","admin","supervisor","manager","sales rep"};
        return posts;
    }
    
 }
