package ss.bshop.mbeans;

import ss.bshop.mbeans.datamodel.UserDataModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
public class UserMB implements Serializable {
	
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
    
    private List<User> userList = new ArrayList<User>();
    
    @ManagedProperty(value = "#{UserDataModel}")
    private UserDataModel model;
    
    private User selected;
    private FacesMessage msg;

 
    @PostConstruct
    protected void postConstruct() {
    	userList = new ArrayList<User>();
        userList.addAll(getUserService().getUsers());
        model = new UserDataModel(userList);
    }  
        
     public void editRow(RowEditEvent event) {
        User rowItem = (User) event.getObject();
        getUserService().updateUser(rowItem); 
        addRoles(rowItem);    	 
     }
     
     private void addRoles(User rowItem){
   	    if(("supervisor").equals(rowItem.getPost())) {
    		SuperVisor supervis=getUserService().supervisorByUserId(rowItem.getId());
    		if(supervis!=null){
    			getSuppervisorService().remove(rowItem.getId());
    			}
    		SuperVisor supervisor=new SuperVisor();
    		supervisor.setUser(rowItem);
      		 getSuppervisorService().add(supervisor);
      		 	
      		 }
    
         else if (("manager").equals(rowItem.getPost())){ 
        	 Manager man=getUserService().managerByUserId(rowItem.getId());
     		if(man!=null){
     			getManagerService().remove(man.getId());
     			}
     			Manager manager=new Manager();
           	   manager.setUser(rowItem);
           	   getManagerService().add(manager);
     		
      	  }
    
         else if (("sales rep").equals(rowItem.getPost())){ 
        	 SalesRep sales=getUserService().salesrepByUserId(rowItem.getId());
      		if(sales!=null){
      			getSalesRepService().remove(sales.getId());
      			}
      	   SalesRep salesRep=new SalesRep();
      	   salesRep.setUser(rowItem);
      	   getSalesRepService().add(salesRep);
      	   
    	 }
     }

   

   public String createNew() {
        User user=new User();
        user.setLogin("default");
        getUserService().addUser(user);
        userList.add(user);
        
        msg = new FacesMessage("User Added", "Edit, please");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        
        return "";
   }
   
   public void delFromRelatedTables(User user){
	 
	   if(("manager").equals(user.getPost()))  {
		   List<Manager> list=getManagerService().getAll();
		   for(Manager manager: list) {
			   if (user.equals(manager.getUser()))
			   getManagerService().remove(manager.getId());
			   }
	   }
       else if (("supervisor").equals(user.getPost())){
    	   List<SuperVisor> list=getSuppervisorService().getAll();
		   for(SuperVisor supervisor: list) {
			   if (user.equals(supervisor.getUser()))
				   getSuppervisorService().remove(supervisor.getId());
			   }  
       }
       else if (("sales rep").equals(user.getPost())){
    	   List<SalesRep> list=getSalesRepService().getAll();
		   for(SalesRep salesRep: list) {
			   if (user.equals(salesRep.getUser()))
				   getSalesRepService().remove(salesRep.getId());
			   }  
       } 
   }

    public String delete() {
    	if(selected!=null){
    		delFromRelatedTables(selected);
            getUserService().deleteUser(selected);
            userList.remove(selected);                      	
            selected = null;
            
            msg = new FacesMessage("User Deleted","");   
            FacesContext.getCurrentInstance().addMessage(null, msg);
    	}
    	return "";
    }
    
   
	public String[] getPosts() {
        String[] posts = {"none","admin","supervisor","manager","sales rep"};
        return posts;
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


            
    
 }
