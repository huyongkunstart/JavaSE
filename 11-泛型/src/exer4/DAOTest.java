package exer4;

import org.junit.Test;

import java.util.List;

/**
 * @author huyongkun
 * @ClassName DAOTest
 * @create 2022-05-18 9:53
 * @Version 1.0
 * @description: TODO
 */
public class DAOTest {
    @Test
    public void test1(){
        DAO<User> userDAO = new DAO<User>();
        userDAO.save("AA",new User(1001,18,"guoshuhao"));
        userDAO.save("BB",new User(1002,23,"walfawf"));

        User aa = userDAO.get("AA");
        System.out.println("AA--->"+aa);

        userDAO.update("BB",new User(1011,99,"张三"));

        List<User> list = userDAO.list();
        for (User user : list) {
            System.out.println(user);
        }
        System.out.println("-----------------------------------");
        list.forEach(System.out::println);

        userDAO.delete("AA");



    }
}
