
package ss.bshop.mbeans;

/**
 *
 * @author nick
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import ss.bshop.domain.Article;
import ss.bshop.domain.User;
import ss.bshop.service.IArticleService;


@ManagedBean(name="articleMB")
@SessionScoped
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

    public ArticleDataModel getModel() {
        articleList = new ArrayList<Article>();
        articleList.addAll(getArticleList());
        model = new ArticleDataModel(articleList);
        return model;
    }

}
