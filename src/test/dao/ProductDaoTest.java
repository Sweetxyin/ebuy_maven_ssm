package dao;


import com.lcvc.ebuy_maven_ssm.dao.CustomerDao;
import com.lcvc.ebuy_maven_ssm.dao.ProductDao;
import com.lcvc.ebuy_maven_ssm.model.Customer;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.test.SpringJunitTest;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

public class ProductDaoTest extends SpringJunitTest {
    @Resource
    private ProductDao productDao;

    @Test
    public void testGetProductList(){
        List<Product> list=productDao.getProductList();
        for (int i=0;i<list.size();i++){
            Product product=list.get(i);
            System.out.println(product.getName()+"\t");
            System.out.println(product.getProductType().getName()+"\t");

        }
        System.out.println(productDao.getProductList());
    }



}
