package com.lcvc.ebuy_maven_ssm.service.impl;


import com.lcvc.ebuy_maven_ssm.dao.ProductDao;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Resource
    private ProductDao productDao;



    public List<Product> getProductList(){
        return productDao.getProductList();
    }



    public boolean deleteProduct(Integer id){
        Boolean status=false;//默认删除失败
        if (id!=null){
                int n=productDao.deleteProduct(id);
                if (n==1){
                    status=true;
                }
            }
        return status;
    }


    public boolean saveProduct(Product product){
        Boolean status=false;//默认添加失败
        product.setCreateTime(new Date());
        int i=productDao.saveProduct(product);
        if (i>0){
            status=true;
        }
        return status;
    }

    public boolean updateProduct(Product product){
        Boolean status=false;//默认编辑失败

            if (productDao.updateProduct(product)==1){
                status=true;
            }else {
                status=false;
            }
        return false;
    }


    public Product getProduct(Integer id){
       Product product=null;
        if (id!=null){
          product=productDao.getProduct(id);
        }
        return product;
    }

    @Override
    public List<Product> getProductList(Integer page) {
        int pagesize=10;//每页显示10条记录
        if (page==null){
            page=1;
        }else {
            if (page<1){
                page=1;
            }
        }
        int offset=(page-1)*pagesize+1;//数据库开始的记录
        //int end=offset+pagesize-1;//数据库结束的记录
        return productDao.getPartlst(offset-1,pagesize);
    }

    @Override
    public int maxPage() {
        int maxPage=0;//默认为0
        int pagesize=10;//每页显示10条记录
        int total=productDao.total();//最大记录数
        if (total%pagesize==0){//%表示取余数，比如35%10=5
            maxPage=total/pagesize;

        }else {
            maxPage=total/pagesize+1;
        }
        return maxPage;
    }

    @Override
    public List<Product> getNewTopProductList(Integer pageSize) {
        return productDao.getNewTopProductList(pageSize);
    }

    @Override
    public List<Product> getHotProductList(int pageSize) {
        return productDao.getHotProductList(pageSize);
    }

    @Override
    public List<Product> getTimerProduct(int pageSize) {
        return productDao.getTimerProduct(pageSize);
    }

    @Override
    public List<Product> searchProduct(Product product) {
        return productDao.searchProduct(product);
    }

    @Override
    public List<Product> getProductTypeList(int id) {
        return productDao.getProductTypeList(id);
    }


}
