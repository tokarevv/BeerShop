
package ss.bshop.mbeans;

/**
 *
 * @author nick
 */
import ss.bshop.mbeans.datamodel.ArticleDataModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;

import ss.bshop.domain.Article;
import ss.bshop.domain.Supplier;
import ss.bshop.service.IArticleService;
import ss.bshop.service.ISupplierService;


@ManagedBean(name="articleMB")
@SessionScoped
public class ArticleMB implements Serializable{

    private static final long serialVersionUID = 1L;
    private List<Article> articleList;
    private Article selected;
    private FacesMessage msg;
    private List<Supplier> suppliers;

    @ManagedProperty(value="#{supplierService}")
    ISupplierService supplierService;

    @ManagedProperty(value = "#{articleService}")
    private IArticleService articleService;

    @ManagedProperty(value = "#{ArticleDataModel}")
    private ArticleDataModel model;
   

    @PostConstruct
    protected void postConstruct() {
        
        articleList = new ArrayList<Article>();
        
        // InitList By articles
        articleList.addAll(getArticleService().getArticles()); 
        
        //Wired List With Data Model Table
        model = new ArticleDataModel(articleList);
        
        // Init list of suppliers
        suppliers = new ArrayList<Supplier>();
        suppliers = supplierService.getAll();
   }  
    
    public String createNew() {
        Article tmp = new Article("<edit>");
        getArticleService().add(tmp);
        articleList.add(tmp);

        msg = new FacesMessage("Article Added", "Edit, please");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  

        return "";
    }
    
    public void onEdit(RowEditEvent event) {  
        
        Article rowItem = (Article) event.getObject();
        getArticleService().update(rowItem);
        
        msg = new FacesMessage("Article Edited", rowItem.getName());   
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  

     public String delete() {
     	if(selected!=null){
            
            getArticleService().remove(selected.getId());
            articleList.remove(selected);
            selected = null;

            msg = new FacesMessage("Article Deleted","");   
            FacesContext.getCurrentInstance().addMessage(null, msg);
     	}
     	return "";
     }

     // ****************************  Getters and setters
     
	public ISupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(ISupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public ArticleDataModel getModel() {
        return model;
    }

    public void setModel(ArticleDataModel model) {
        this.model = model;
    }
    
    public List<Article> getArticleList() {
        return articleList;
    }
    

    public IArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(IArticleService articleService) {
        this.articleService = articleService;
    }
    
    public Article getSelected() {
		return selected;
    }

    public void setSelected(Article selected) {
            this.selected = selected;
    }

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
        
}