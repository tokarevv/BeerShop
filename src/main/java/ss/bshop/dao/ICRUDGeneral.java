/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss.bshop.dao;

import java.io.Serializable;
import java.util.List;

public interface ICRUDGeneral <T, ID extends Serializable> {
                        
    
        public void add(T t);

	public T get(ID id);

	public List<T> getAll();

	public void remove(ID id);
	
	public void update(T entety);
}
