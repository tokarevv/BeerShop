package ss.bshop.faces.converters;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import ss.bshop.domain.Supplier;
import ss.bshop.service.ISupplierService;


@ManagedBean
@RequestScoped
public class SupplierConverter implements Converter {

	@ManagedProperty(value="#{supplierService}")
	ISupplierService supplierService;

    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
    	//facesContext.addMessage(null, new FacesMessage("Converter - getAsObject"));
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                Long id = Long.parseLong(submittedValue);
                
                return supplierService.get(id);

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
            return String.valueOf(((Supplier) value).getId());
        }
    }
	
    public ISupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(ISupplierService supplierService) {
		this.supplierService = supplierService;
	}

}