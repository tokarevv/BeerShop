package ss.bshop.mbeans;

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
public class SupplierOrderManagedBean{

	@ManagedProperty(value="#{supplierService}")
	ISupplierService supplierService;
	
    @ManagedProperty(value = "#{articleService}")
    IArticleService articleService;
	
	private Supplier selectedSupplier;
	
	private List<Supplier> suppliers;
	
	private String orderType;
	
    private List<Article> articleList = new ArrayList<Article>();

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
		return supplierService.getAll();
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public Supplier getSelectedSupplier() {
		return selectedSupplier;
	}

	public void setSelectedSupplier(Supplier selectedSupplier) {
		this.selectedSupplier = selectedSupplier;
	}

	public List<Article> getArticleList() {
		if (selectedSupplier == null) {
			articleList.clear();
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
