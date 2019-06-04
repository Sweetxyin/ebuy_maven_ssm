package com.lcvc.ebuy_maven_ssm.test;

import com.lcvc.ebuy_maven_ssm.model.Admin;

import java.util.*;

public class Test {
    public static void main(String[] args) {
      /*  //建立一个List集合
        List <Admin> list=new ArrayList<Admin>();
        list.add(new Admin(31));
        list.add(new Admin(41));
        list.add(new Admin(51));
        list.add(new Admin(61));
        for (int i=0;i<list.size();i++){
            Admin admin=list.get(i);
            System.out.println(admin.getId());
        }*/

      /*//建立一个Map集合
        Map<String,Integer> map=new HashMap<String ,Integer>();
        map.put("张三",52);
        map.put("小红",52);
        map.put("小青",87);
        map.put("小绿",65);
        Set keys=map.keySet();//map。keySet返回map集合的键集合
        Iterator it=keys.iterator();
        while (it.hasNext()){//it.hasNext()表示如果还有下一条记录
            String key=(String)it.next();//it.next()表示下一条记录具体的值
            Integer value=map.get(key);//map.get(key)表示获取主键对应的值
            System.out.println(key+"->"+value);

        }*/


        Map<String,Integer> map=new HashMap<String ,Integer>();
        map.put("红烧肉",2);
        map.put("螺蛳粉",1);
        map.put("南瓜饼",3);
        map.put("奶茶",1);
        System.out.println("第一次购买"+map);
        //再次购买3个南瓜饼
        int newNumber=3;//将放入购物车中的南瓜饼是三个
        if (map.containsKey("南瓜饼")){//如果包含南瓜饼
            int number=map.get("南瓜饼");//获取原来购物车的南瓜饼的数量
            number=number+newNumber;//计算出购物车中南瓜饼的最终数量
            map.put("南瓜饼",number);
        }else {
            map.put("南瓜饼",newNumber);

        }
        System.out.println("第二次购买："+map);
    }
}
