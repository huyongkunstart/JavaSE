package exer4;

import java.util.*;

/**
 * @author huyongkun
 * @ClassName DAO
 * @create 2022-05-18 9:52
 * @Version 1.0
 * @description: TODO
 */
public class DAO<T> {

    private Map<String,T> map = new HashMap<>();

    //保存T类型的对象到Map成员变量中
    public void save(String id,T entity){
        map.put(id,entity);
    }
    //从map中获取id对应的对象
    public T get(String id){
        return map.get(id);
    }
    //替换map中key为id的内容，改为entity对象
    public void update(String id, T entity){
        if (map.containsKey(id)){
            map.put(id,entity);
        }
    }
    //返回map中存放的所有T对象
    public List<T> list(){
        /*Collection<T> values = map.values();
        return new ArrayList<T>(values);*/

        Collection<T> values = map.values();
        ArrayList<T> ts = new ArrayList<>();
        for (T value : values) {
            ts.add(value);
        }
        return ts;
    }

    //删除指定id对象
    public void delete(String id){
        map.remove(id);
    }
}
