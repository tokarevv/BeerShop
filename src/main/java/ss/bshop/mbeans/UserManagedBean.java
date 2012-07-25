package ss.bshop.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.SelectableDataModel;
import org.springframework.dao.DataAccessException;

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
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    //Spring User Service is injected...
    @ManagedProperty(value = "#{UserService}")
    IUserService userService;

    List<User> userList;
    private UserDataModel model;
    User selected;
    @PostConstruct
//   @RolesAllowed({"ADMIN"})
   protected void postConstruct() {}  //
    /**
     * Add User
     *
     * @return String - Response Message
     */
    public String addUser() {
        try {
            //         User user = new User();
            //        user.setId(getId());
            //         user.setName(getName());
            //         user.setSurname(getSurname());
            getUserService().addUser(selected);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return ERROR;
    }

    public void editRow(RowEditEvent event) {
        User rowItem = (User) event.getObject();
        getUserService().updateUser(rowItem);        //endEditItem(rowItem);
        //saveSelected();
        //endSelect();
    }

    /**
     * Reset Fields
     */
    public void reset() {
    }

    /**
     * Get User List
     *
     * @return List - User List
     */
    public List<User> getUserList() {
        return userList;
    }

    public UserDataModel getModel() {
        userList = new ArrayList<User>();
        userList.addAll(getUserService().getUsers());
        model = new UserDataModel(userList);
        return model;
    }

    public void setModel(UserDataModel model) {
        this.model = model;
    }

    /**
     * Get User Service
     *
     * @return IUserService - User Service
     */
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
        return "recept";
    }

    public String delete() {
        return "removal";
    }
    public boolean isEnableDelete() {
        return !(selected==null);
    }
}
