package ss.bshop.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

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

	@ManagedProperty(value="#{supplierService}")
	ISupplierService supplierService;
	
    @ManagedProperty(value = "#{articleService}")
    IArticleService articleService;
	
	private Supplier selectedSupplier;
	
	private List<Supplier> suppliers = new ArrayList<Supplier>();
	
	private String orderType;
	
    private List<Article> articleList = new ArrayList<Article>();

    private String firstname;  
    
    public String getFirstname() {  
        return firstname;  
    }  
  
    public void setFirstname(String firstname) {  
        this.firstname = firstname;  
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
		return new Supplier("Some test supplier");//selectedSupplier;
	}

	public void setSelectedSupplier(Supplier selectedSupplier) {
		this.selectedSupplier = selectedSupplier;
	}

	public List<Article> getArticleList() {
		if (selectedSupplier == null) {
			//articleList.clear();
			Article newOne = new Article();
			newOne.setName("Supplier is not selected");
			articleList.add(newOne);
		}
		else {
			articleList = articleService.getArticlesBySupplier(selectedSupplier);
		}
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
}
