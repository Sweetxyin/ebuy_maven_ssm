package service;

import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.service.ProductService;
import com.lcvc.ebuy_maven_ssm.service.ShoppingCartService;
import com.lcvc.ebuy_maven_ssm.test.SpringJunitTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class ShoppingCartServiceTest extends SpringJunitTest {
    @Resource
    private ShoppingCartService shoppingCartService;

    @Test
    public void  testCart(){
     shoppingCartService.putProduct(1,5);
     shoppingCartService.putProduct(2,2);
     shoppingCartService.putProduct(3,1);
     shoppingCartService.putProduct(4,1);
     shoppingCartService.putProduct(1,1);
     System.out.println(shoppingCartService.getShoppingCart());

    }


}
