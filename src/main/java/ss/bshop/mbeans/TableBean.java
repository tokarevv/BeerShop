/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss.bshop.mbeans;

import java.io.Serializable;  
import java.util.ArrayList;  
import java.util.List;  
import java.util.UUID;  
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
  
import javax.faces.context.FacesContext;  
import org.primefaces.event.RowEditEvent;
  
/**
 *
 * @author primeFace
 */
@ManagedBean(name="tableBean")
@RequestScoped
public class TableBean implements Serializable {  
  
    private final static String[] colors;  
  
    private final static String[] manufacturers;  
  
    private List<Car> carsSmall;  
  
    static {  
        colors = new String[10];  
        colors[0] = "Black";  
        colors[1] = "White";  
        colors[2] = "Green";  
        colors[3] = "Red";  
        colors[4] = "Blue";  
        colors[5] = "Orange";  
        colors[6] = "Silver";  
        colors[7] = "Yellow";  
        colors[8] = "Brown";  
        colors[9] = "Maroon";  
  
        manufacturers = new String[10];  
        manufacturers[0] = "Mercedes";  
        manufacturers[1] = "BMW";  
        manufacturers[2] = "Volvo";  
        manufacturers[3] = "Audi";  
        manufacturers[4] = "Renault";  
        manufacturers[5] = "Opel";  
        manufacturers[6] = "Volkswagen";  
        manufacturers[7] = "Chrysler";  
        manufacturers[8] = "Ferrari";  
        manufacturers[9] = "Ford";  
    }  
  
    public TableBean() {  
        carsSmall = new ArrayList<Car>();  
  
        populateRandomCars(carsSmall, 9);  
    }  
  
    private void populateRandomCars(List<Car> list, int size) {  
        for(int i = 0 ; i < size ; i++)  
            list.add(new Car(getRandomModel(), getRandomYear(), getRandomManufacturer(), getRandomColor()));  
    }  
  
    public List<Car> getCarsSmall() {  
        return carsSmall;  
    }  
  
    private int getRandomYear() {  
        return (int) (Math.random() * 50 + 1960);  
    }  
  
    private String getRandomColor() {  
        return colors[(int) (Math.random() * 10)];  
    }  
  
    private String getRandomManufacturer() {  
        return manufacturers[(int) (Math.random() * 10)];  
    }  
  
    private String getRandomModel() {  
        return UUID.randomUUID().toString().substring(0, 8);  
    }  
  
    public String[] getManufacturers() {  
        return manufacturers;  
    }  
  
    public String[] getColors() {  
        return colors;  
    }  
  
    public void onEdit(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Car Edited", ((Car) event.getObject()).getModel());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
      
    public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Car Cancelled", ((Car) event.getObject()).getModel());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    } 
    
}  

