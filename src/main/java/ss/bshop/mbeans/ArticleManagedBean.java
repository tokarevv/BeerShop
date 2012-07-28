
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
import org.primefaces.event.RowEditEvent;

import ss.bshop.domain.Article;
import ss.bshop.service.IArticleService;


@ManagedBean(name="articleMB")
@RequestScoped
public class ArticleManagedBean implements Serializable{

    //Spring User Service is injected...
    @ManagedProperty(value = "#{articleService}")
    IArticleService articleService;

    @ManagedProperty(value = "#{ArticleDataModel}")
    private ArticleDataModel model;
   
    private List<Article> articleList;

    public List<Article> getArticleList() {
        return articleList;
    }
    
    public void onEdit(RowEditEvent event) {  
        
        Article rowItem = (Article) event.getObject();
        getArticleService().updateArticle(rowItem);
        
        FacesMessage msg = new FacesMessage("Percent Edited", 
                ((Article) event.getObject()).getPercent().toString());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
      
    public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Edit percent Cancelled", 
                ((Article) event.getObject()).getPercent().toString());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
    
    public ArticleDataModel getModel() {
        articleList = new ArrayList<Article>();
        articleList.addAll(getArticleService().getArticles());
        model = new ArticleDataModel(articleList);
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
    
}
