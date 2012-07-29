package ss.bshop.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import ss.bshop.domain.Article;
import ss.bshop.domain.Supplier;
import ss.bshop.service.IArticleService;
import ss.bshop.service.ISupplierService;

@ManagedBean(name="supplierOrderMB")
@RequestScoped
public class SupplierOrderManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private FacesMessage msg;

	@ManagedProperty(value="#{supplierService}")
	ISupplierService supplierService;
	
    @ManagedProperty(value = "#{articleService}")
    IArticleService articleService;
	
	private Supplier selectedSupplier;
	
	private List<Supplier> suppliers = new ArrayList<Supplier>();
	
	private String orderType = "Type is not selected";
	
    private List<Article> articleList = new ArrayList<Article>();

    public void handleOrderTypeChange(){
        msg = new FacesMessage("order type is changed");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    public void handleSupplierChange(){
    	String supName = "";
    	if (selectedSupplier == null){
    		supName = "null";
    	}
    	else{
    		supName = selectedSupplier.getName();
    	}
        FacesMessage msg = new FacesMessage("supplier is "+supName);  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
       if(selectedSupplier !=null)  
            articleList = articleService.getArticlesBySupplier(selectedSupplier);  
        else  
			articleList.clear();
			Article newOne = new Article();
			newOne.setName("Supplier is STILL not selected"+articleList.size());
			articleList.add(newOne);
    }
    
    public IArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}

	public ISupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(ISupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public List<Supplier> getSuppliers() {
		suppliers = supplierService.getAll();
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public Supplier getSelectedSupplier() {
		return selectedSupplier;//new Supplier("Some test supplier");//
	}

	public void setSelectedSupplier(Supplier selectedSupplier) {
		this.selectedSupplier = selectedSupplier;
	}

	public List<Article> getArticleList() {

//		String supName = "";
//		if (selectedSupplier == null) {
//			//articleList.clear();
//			Article newOne = new Article();
//			newOne.setName("Supplier is not selected1"+articleList.size());
//			articleList.add(newOne);
//		}
//		else {
//			supName = selectedSupplier.getName();
//			articleList = articleService.getArticlesBySupplier(selectedSupplier);
//		}
//        FacesMessage msg = new FacesMessage("get Article list"+supName);  
//        
//        FacesContext.getCurrentInstance().addMessage(null, msg);  
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

}
