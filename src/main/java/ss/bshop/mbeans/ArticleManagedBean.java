
package ss.bshop.mbeans;

/**
 *
 * @author nick
 */
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="UserArticleBean")
@SessionScoped
public class ArticleManagedBean implements Serializable{

    /**
     * Creates a new instance of ArticleManagedBean
     */
    public ArticleManagedBean() {
    }
}
