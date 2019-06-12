package com.lcvc.ebuy_maven_ssm.service.impl;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.service.AdminService;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{


    @Resource
    private AdminDao adminDao;



    public Admin login(String username, String password){
        if (password.length()!=32){
            //将密码加密后再进行比对
            password= SHA.getResult(password);
        }
        Admin admin=adminDao.login(username, password);
        return admin;
    }


    public boolean updatePassword(String newPass,Integer id){
        Boolean status=false;//默认编辑失败
        newPass= SHA.getResult(newPass);
        Admin admin=new Admin();
        admin.setId(id);
        admin.setPassword(newPass);
        if(adminDao.updateAdmin(admin)>0){
            status=true;
        }
        return status;
    }



    public boolean updateAdmin(Admin admin){
        Boolean status=false;//默认编辑失败
        if (adminDao.existsAdmin(admin.getUsername(),admin.getId())==0){
            if (adminDao.updateAdmin(admin)>0){
                status=true;
            }else {
                status=false;
            }
        }
            return false;
        }


    public List<Admin> getAdminList(){
        return adminDao.getAdminList();
    }


    public boolean deleteAdmin(Integer id,Integer adminId){
        Boolean status=false;//默认删除失败
        if (id!=null&&adminId!=null){
            if(adminId!=id.intValue()){//如果不是自己删自己
                int n=adminDao.deleteAdmin(id);
                if (n==1){
                    status=true;
                }
            }
        }

        return status;
    }

    public boolean existsAdmin(String username,Integer id){
        if (adminDao.existsAdmin(username,id)==0){
            return false;
        }else{
            return true;
        }
    }


    public boolean existsUsername(String username){
        if (adminDao.existsUsername(username)==0){
            return false;
        }else{
            return true;
        }
    }


    public boolean saveAdmin(Admin admin){
        Boolean status=false;//默认添加失败
        admin.setPassword(SHA.getResult(admin.getPassword()));
        admin.setCreateTime(new Date());
        int i=adminDao.saveAdmin(admin);
        if (i>0){
                status=true;
            }
        return status;
    }


     public Admin getAdmin(Integer id){
         Admin admin=null;
         if (id!=null){
             admin=adminDao.getAdmin(id);
         }
             return admin;
         }

    @Override
    public List<Admin> getAdminList(Integer page) {
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
        return adminDao.getPartlst(offset-1,pagesize);
    }

    @Override
    public int maxPage() {
        int maxPage=0;//默认为0
        int pagesize=10;//每页显示10条记录
        int total=adminDao.total();//最大记录数
        if (total%pagesize==0){//%表示取余数，比如35%10=5
            maxPage=total/pagesize;

        }else {
            maxPage=total/pagesize+1;
        }
        return maxPage;
    }


}
