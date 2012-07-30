package ss.bshop.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

import ss.bshop.domain.Article;
import ss.bshop.domain.SupOrderStructure;
import ss.bshop.domain.Supplier;
import ss.bshop.domain.SupplierOrder;
import ss.bshop.service.IArticleService;
import ss.bshop.service.ISupplierOrderService;
import ss.bshop.service.ISupplierOrderStructureService;
import ss.bshop.service.ISupplierService;

@ManagedBean(name="supplierOrderMB")
@ViewScoped
public class SupplierOrderManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private FacesMessage msg;

    //fields
	@ManagedProperty(value="#{supplierOrderService}")
	ISupplierOrderService supplierOrderService;
	
	@ManagedProperty(value="#{supplierOrderStructureService}")
	ISupplierOrderStructureService supplierOrderStructureService;
	
	@ManagedProperty(value="#{supplierService}")
	ISupplierService supplierService;
	
    @ManagedProperty(value = "#{articleService}")
    IArticleService articleService;
	
	private Supplier selectedSupplier;
	
	private List<Supplier> suppliers = new ArrayList<Supplier>();
	
	private String orderType = "Type is not selected";
	
    private List<SupOrderStructure> orderLineList = new ArrayList<SupOrderStructure>();
    
    private SupOrderStructure orderLine;
    
    private String comment;
    
    public String placeOrder(){
    	//FacesContext.getCurrentInstance().setProcessingEvents(true);
    	
    	SupplierOrder order = new SupplierOrder();
    	order.setComment(comment);
    	//order.setManager(manager); ???????????????
    	order.setOrderDate(new Date());
    	order.setType(orderType);
    	order.setStatus(false);
    	supplierOrderService.add(order);
    	
    	for (SupOrderStructure row : orderLineList){
    		if (row.getAmount() > 0){
    			row.setSupplierOrder(order);
    			supplierOrderStructureService.add(row);
    		}
    	}
    	return "base_manager";
    	
    }
    
	public ISupplierOrderService getSupplierOrderService() {
		return supplierOrderService;
	}

	public void setSupplierOrderService(ISupplierOrderService supplierOrderService) {
		this.supplierOrderService = supplierOrderService;
	}

	public ISupplierOrderStructureService getSupplierOrderStructureService() {
		return supplierOrderStructureService;
	}

	public void setSupplierOrderStructureService(
			ISupplierOrderStructureService supplierOrderStructureService) {
		this.supplierOrderStructureService = supplierOrderStructureService;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void editRow(RowEditEvent event){
//		SupOrderStructure row = (SupOrderStructure) event.getObject();
//		orderLineList.add(row);

	}
	
	public void handleSupplierChange() {
		orderLineList.clear();
		if (selectedSupplier != null) {
			List<Article> articleList = articleService.getArticlesBySupplier(selectedSupplier);
			for (Article a : articleList){
				orderLineList.add(getNewOrderLine(a));
			}
		}
	}

	//getters and setters
	public List<SupOrderStructure> getOrderLineList() {
		return orderLineList;
	}

	public void setOrderLineList(List<SupOrderStructure> orderLineList) {
		this.orderLineList = orderLineList;
	}

    private SupOrderStructure getNewOrderLine(Article a) {
    	SupOrderStructure orderLine = new SupOrderStructure();
    	orderLine.setArticle(a);
    	orderLine.setPrice(a.getPrice());
    	orderLine.setAmount(0);
		return orderLine;
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

	public SupOrderStructure getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(SupOrderStructure orderLine) {
		this.orderLine = orderLine;
	}


}
