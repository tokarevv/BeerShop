package ss.bshop.dao;

import java.io.Serializable;
import java.util.List;
import ss.bshop.domain.SupplierOrder;
import ss.bshop.domain.Article;
import ss.bshop.domain.Outlet;
import ss.bshop.domain.SalesRep;

public interface IOutletDAO extends ICRUDGeneral <Outlet, Long>{

    public List<Outlet> getBySalesRep(SalesRep salesRep);

}
