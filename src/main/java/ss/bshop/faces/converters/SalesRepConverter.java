package ss.bshop.faces.converters;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import ss.bshop.domain.SalesRep;
import ss.bshop.service.ISalesRepService;


@ManagedBean
@RequestScoped
public class SalesRepConverter implements Converter {

    @ManagedProperty(value = "#{salesRepService}")
    private ISalesRepService salesRepService;
 
    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
    	//facesContext.addMessage(null, new FacesMessage("Converter - getAsObject"));
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                Long id = Long.parseLong(submittedValue);
                
                return salesRepService.get(id);

            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid supplier"));
            }
        }

    }

	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
    	//facesContext.addMessage(null, new FacesMessage("Converter - getAsString"));
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((SalesRep) value).getId());
        }
    }

	public ISalesRepService getSalesRepService() {
		return salesRepService;
	}

	public void setSalesRepService(ISalesRepService salesRepService) {
		this.salesRepService = salesRepService;
	}
	

}