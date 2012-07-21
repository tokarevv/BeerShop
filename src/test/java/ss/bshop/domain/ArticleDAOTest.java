package ss.bshop.domain;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ss.bshop.dao.IArticleDAO;
import ss.bshop.domain.Article;

import java.util.List;

/**
 * MedicineDAO Tester. 
 *
 * @author <Authors name> 
 * @since <pre>��� 3, 2012</pre> 
 * @version 1.0
 */
@ContextConfiguration("/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ArticleDAOTest {

    @Autowired
    private IArticleDAO daoI;
    //@Autowired
    //private IMedicineTypeDAO mtDAOI;

    @Rollback(false)
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: save(Medicine medicine)
     *
     */
    @Test
    public void testSave() throws Exception {
//TODO: Test goes here...
       Article article = new Article();
       article.setName("Snicks");
       article.setBarcode("831418518");
       daoI.addArticle(article);
        List<Article> medicineList = daoI.getAll();
       Assert.assertEquals("Name",medicineList.get(medicineList.size()-1).getName());
    }
//
//    /**
//     *
//     * Method: load(String barCode)
//     *
//     */
//    @Test
//    public void testLoad() throws Exception {
////TODO: Test goes here...
//
//        Medicine medicine = new Medicine("9999999999999","Name", mtDAOI.getList().get(0),false);
//        daoI.save(medicine);
//        Thread.sleep(500);
//        List<Medicine> medicineList = daoI.getList();
//        System.out.println("medicineList(n-1) component: "+medicineList.get(medicineList.size()-1).getName());
//        Medicine testMedicine = daoI.load(medicineList.get(medicineList.size()-1).getBarCode());
//        Assert.assertEquals("Name", testMedicine.getName());
//
//    }
//    /**
//     *
//     * Method: GetListByBarCode(String barCode)
//     *
//     */
//    @Test
//    public void testGetListByBarCode() throws Exception
//    {
//        List<MedicineType> mtList = mtDAOI.getList();
//        Medicine medicine1 = new Medicine("999999777","Test1",mtList.get(0),false);
//        Medicine medicine2 = new Medicine("999999666","Test2",mtList.get(0),false);
//        Medicine medicine3 = new Medicine("999999555","Test3",mtList.get(0),false);
//        daoI.save(medicine1);
//        daoI.save(medicine2);
//        daoI.save(medicine3);
//
//        List<Medicine> medList = daoI.getListByBarCode("999999");
//       /* for(Medicine m:medList)
//        {
//            System.out.println(m.toString());
//        }   */
//
//        Assert.assertEquals(3,medList.size());
//       
//
//    }
//    /**
//     *
//     * Method: getListByName(String name)
//     *
//     */
//    @Test
//    public void getListByName() throws Exception{
//        List<MedicineType> mtList = mtDAOI.getList();
//        Medicine medicine1 = new Medicine("999999777","TestName1",mtList.get(0),false);
//        Medicine medicine2 = new Medicine("999999666","TestName2",mtList.get(0),false);
//        Medicine medicine3 = new Medicine("999999555","TestName3",mtList.get(0),false);
//        daoI.save(medicine1);
//        daoI.save(medicine2);
//        daoI.save(medicine3);
//
//        List<Medicine> medList = daoI.getListByName("TestName");
//        /* for(Medicine m:medList)
//     {
//         System.out.println(m.toString());
//     }   */
//
//        Assert.assertEquals(3,medList.size());
//
//    }
//    /**
//     *
//     * Method: update(Medicine medicine)
//     *
//     */
//    @Test
//    public void testUpdate() throws Exception {
////TODO: Test goes here...
//        Medicine medicine = new Medicine("123456789","Name", mtDAOI.getList().get(0),false);
//        daoI.save(medicine);
//        List<Medicine> medicineList = daoI.getList();
//        Medicine toSave = medicineList.get(medicineList.size()-1);
//        toSave.setName("NewNameAfterUpdate");
//        daoI.update(toSave);
//        medicineList = daoI.getList();
//        Assert.assertEquals("NewNameAfterUpdate",medicineList.get(medicineList.size()-1).getName());
//
//    }
//
//    /**
//     *
//     * Method: delete(Medicine medicine)
//     *
//     */
//    @Test
//    public void testDelete() throws Exception {
////TODO: Test goes here...
//        Medicine medicine = new Medicine("9999999999999","Name", mtDAOI.getList().get(0),false);
//        daoI.save(medicine);
//        List<Medicine> medicineList = daoI.getList();
//        daoI.delete(medicineList.get(medicineList.size()-1));
//        if(medicineList.size()> daoI.getList().size())
//        {
//            Assert.assertTrue(true);
//        }
//        
//        
//
//    }
//
//    /**
//     *
//     * Method: getList()
//     *
//     */
//    @Test
//    public void testGetList() throws Exception {
////TODO: Test goes here...
//        Medicine medicine = new Medicine("123456789","Name",new MedicineType(1,"Snotvornoe"),false);
//        daoI.save(medicine);
//        List<Medicine> medicineList = daoI.getList();
//        if(medicineList.size()>0)
//        {
//            Assert.assertTrue(true);
//        }
//    }
//
//    @Test
//    public void testEmptyOne()
//    {
//        org.junit.Assert.assertTrue(true);
//    }
}  
