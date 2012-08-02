package ss.bshop.mbeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import ss.bshop.service.IUserService;


/**
 * User Managed Bean
 *
 * @Vera
 */
@ManagedBean(name = "authMB")
@SessionScoped
public class AuthorisationMB implements Serializable {
	
    private static final long serialVersionUID = 1L;
    private FacesMessage msg;

    //Spring User Service is injected...
    @ManagedProperty(value = "#{userService}")
    IUserService userService;
    
    private String name;
    private String password;
    

    public String onSubmit(){
        msg = new FacesMessage("Article Added", "Edit, please");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
   	
    	SecurityContext securityContext = SecurityContextHolder.getContext();
    	Authentication auth = securityContext.getAuthentication();
    	for(GrantedAuthority ga : auth.getAuthorities()){
    		ga.getAuthority();
    	}
   	
		return "";
    	
    }
    
    
    //getters and setters
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

 }
