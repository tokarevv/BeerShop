package ss.bshop.faces.converters;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import ss.bshop.domain.Supplier;
import ss.bshop.service.ISupplierService;

public class SupplierConverter implements Converter {

	@ManagedProperty(value = "#{supplierService}")
	ISupplierService supplierService;

    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
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
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Supplier) value).getId());
        }
    }
	
	
//	@Override
//	public Object getAsObject(FacesContext context, UIComponent component,
//			String value) {
//		//return supplierService.get(Long.parseLong(value));
//		//return supplierService.get((long) 4);
//		return supplierService.getAll().get(0);
//	}
//
//	@Override
//	public String getAsString(FacesContext context, UIComponent component,
//			Object value) {
//		return new Long(4).toString();//((Supplier) value).getId().toString(); // --> convert to a unique
//														// string.
//	}
}
