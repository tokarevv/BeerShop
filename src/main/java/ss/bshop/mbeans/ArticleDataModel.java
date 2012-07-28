package ss.bshop.mbeans;

import org.primefaces.model.SelectableDataModel;

import ss.bshop.domain.User;

import javax.faces.model.ListDataModel;
import java.util.List;
import ss.bshop.domain.Article;

public class ArticleDataModel extends ListDataModel<Article> implements SelectableDataModel<Article> {    
  
    public ArticleDataModel() {  
    }  
  
    public ArticleDataModel(List<Article> data) {  
        super(data);  
    }  

    @Override
    public Article getRowData(String rowKey) {  

        Long key = Long.parseLong(rowKey);
        List<Article> articles = (List<Article>) getWrappedData();  
          
        for(Article article : articles) {  
            if(article.getId()==key)
                return article;  
        }  
          
        return null;  
    }  
    
    @Override
    public Object getRowKey(Article article) {
        return String.valueOf(article.getId());  
    }  
}  

