
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

    public List<Article> getArticleList() {
        return articleList;
    }
    
    public void onEdit(RowEditEvent event) {  
        
        Article rowItem = (Article) event.getObject();
        getArticleService().update(rowItem);
        
        FacesMessage msg = new FacesMessage("Percent Edited", 
                ((Article) event.getObject()).getPercent().toString());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
 
    public ArticleDataModel getModel() {
        return model;
    }

    public void setModel(ArticleDataModel model) {
        this.model = model;
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
    
    @PostConstruct
    protected void postConstruct() {
        getData();
        updateModel();
    }  
    
    private void getData() {
    	articleList = new ArrayList<Article>();
    	articleList.addAll(getArticleService().getArticles()); 
    }
    
    private void updateModel() {
        model = new ArticleDataModel(articleList);
        selected=null;
    }
    
    public void editRow(RowEditEvent event) {
    	Article rowItem = (Article) event.getObject();
        if(rowItem.getId()==0) {
            getArticleService().add(rowItem);
        }
        {getArticleService().update(rowItem); }
        getData();
        updateModel();
    }
    
    public String createNew() {
    	articleList.add(new Article());
    	getData();
        updateModel();
        return "";
    }

     public String delete() {
     	if(selected!=null){
     		getArticleService().remove(selected.getId());
        	 getData();
             updateModel();
     	}
     	return "";
     }
      
}