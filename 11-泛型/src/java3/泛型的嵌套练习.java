package java3;

import exer3.Citizen;

import java.util.*;

/**
 * @author huyongkun
 * @ClassName 泛型的嵌套练习
 * @create 2022-05-18 9:41
 * @Version 1.0
 * @description: TODO
 */
public class 泛型的嵌套练习 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Citizen>> map = new HashMap<>();
        ArrayList<Citizen> list = new ArrayList<>();
        list.add(new Citizen("刘恺威"));
        list.add(new Citizen("杨幂"));
        list.add(new Citizen("小糯米"));
        map.put("刘恺威",list);


        Set<Map.Entry<String, ArrayList<Citizen>>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, ArrayList<Citizen>>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, ArrayList<Citizen>> next = iterator.next();
            String key = next.getKey();
            ArrayList<Citizen> value = next.getValue();
            System.out.println("户主:"+key);
            System.out.print("家庭成员: ");
            for (Citizen citizen : value) {
                System.out.print(citizen.getName()+" ");
            }

        }
    }
}
