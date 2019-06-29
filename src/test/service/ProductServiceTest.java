package service;

import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.service.ProductService;
import com.lcvc.ebuy_maven_ssm.test.SpringJunitTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class ProductServiceTest extends SpringJunitTest {
    @Resource
    private ProductService productService;
    Product product=new Product();
    @Test
    public void  testProductList(){
        List<Product> list=productService.getProductList(2);
        for (int i=0;i<list.size();i++){
            Product product=list.get(i);
            System.out.println(product.getName());
        }
    }

    @Test
    public void  testSaveProduct(){


        product.setName("芒果芋圆");
        product.setNumber(20);
        product.setClick(10);
        product.setOnSale(true);
       productService.saveProduct(product);
    }

    @Test
    public void  searchProduct(){

       product.setName("冰淇淋");
       System.out.println( productService.searchProduct(product));
    }
}
