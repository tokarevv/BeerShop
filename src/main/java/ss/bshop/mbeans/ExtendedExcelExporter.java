package ss.bshop.mbeans;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.context.FacesContext;
import org.primefaces.component.celleditor.CellEditor;
import org.primefaces.component.export.ExcelExporter;

 public class ExtendedExcelExporter extends ExcelExporter {

        @Override
        protected String exportValue(FacesContext context, UIComponent component) {
            if (component instanceof CellEditor) {
                return exportValue(context, ((CellEditor) component).getFacet("output"));
            }
            else if (component instanceof HtmlGraphicImage) {
                return (String) component.getAttributes().get("alt");
            }
            else {
                return super.exportValue(context, component);
            }
        }

}