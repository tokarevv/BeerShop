
package ss.bshop.mbeans;

/**
 *
 * @author nick
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import javax.annotation.PostConstruct;

import org.primefaces.event.RowEditEvent;

import ss.bshop.domain.Article;
import ss.bshop.service.IArticleService;


@ManagedBean(name="articleMB")
@RequestScoped
public class ArticleManagedBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{articleService}")
    IArticleService articleService;
    
    Article selected;

    @ManagedProperty(value = "#{ArticleDataModel}")
    private ArticleDataModel model;
   
    private List<Article> articleList;

    @PostConstruct
    protected void postConstruct() {
        
        articleList = new ArrayList<Article>();
        
        // InitList By articles
        articleList.addAll(getArticleService().getArticles()); 
        
        //Wired List With Data Model Table
        model = new ArticleDataModel(articleList);
    }  
    
    public void onEdit(RowEditEvent event) {  
        
        Article rowItem = (Article) event.getObject();
        getArticleService().update(rowItem);
        
        FacesMessage msg = new FacesMessage("Percent Edited", 
                ((Article) event.getObject()).getPercent().toString());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
    
    
    public String createNew() {
    	Article tmp = new Article("Input Name");
        getArticleService().add(tmp);
        articleList.add(tmp);
        
        FacesMessage msg = new FacesMessage("Article Added");  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  

        return "";
    }

     public String delete() {
     	if(selected!=null){
                
            getArticleService().remove(selected.getId());
            articleList.remove(selected);
            selected = null;

            FacesMessage msg = new FacesMessage("Article Deleted");   
            FacesContext.getCurrentInstance().addMessage(null, msg);
     	}
     	return "";
     }

     // ****************************  Getters and setters
     
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
}