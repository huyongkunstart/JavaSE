package exer4;

import java.util.List;

/**
 * 定义一个测试类：
 *  * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方
 *  * 法来操作 User 对象，
 *  * 使用 Junit 单元测试类进行测试
 * @author hu
 * @create 2022-01-22 23:11
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();

        dao.save("1001",new User(1001,18,"hu"));
        dao.save("1002",new User(1002,23,"wang"));
        dao.save("1003",new User(1003,14,"dan"));

        dao.update("1003",new User(1005,99,"zhongg"));

        dao.delete("1001");

        List<User> list = dao.list();
        list.forEach(System.out::println);

    }
}
