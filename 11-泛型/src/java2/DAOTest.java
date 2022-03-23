package java2;

import org.junit.Test;

/**
 * @author hu
 * @create 2022-01-09 17:18
 */
public class DAOTest {
    @Test
    public void Test1(){
        CustomerDAO dao1 = new CustomerDAO();
        dao1.add(new Customer());
    }
    @Test
    public void Test2(){
        StudentDAO dao2 = new StudentDAO();
        dao2.add(new Student());
    }
}
