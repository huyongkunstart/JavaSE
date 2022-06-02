/**
 * @author huyongkun
 * @ClassName CustomerList
 * @create 2022-05-14 14:49
 * @Version 1.0
 * @description: 数组的增删改查操作
 */
public class CustomerList {

    private Customer[] customers; //客户数组
    private int total = 0;  //用来记录存入数组的客户

    //构造器 初始化数组长度为totalCustomer
    public CustomerList(int totalCustomer){
        this.customers = new Customer[totalCustomer];
    }
    /*
     * @Author huyongkun
     * @Date 14:57 2022/5/14
     * @Param [customer]
     * @return boolean
     * @Description //添加客户对象到数组，成功返回true，失败返回false
     **/
    public boolean addCustomer(Customer customer){
        if(total>customers.length-1){
            return false;
        }
        customers[total++] = customer;
        return true;
    }
    /*
     * @Author huyongkun
     * @Date 14:58 2022/5/14
     * @Param [index, cust]
     * @return boolean
     * @Description //替换客户，将索引index位置的客户替换为cust
     **/
    public boolean replaceCustomer(int index, Customer cust){
        if(index < 0 || index >total-1){
            return false;
        }
        customers[index] = cust;
        return true;
    }
    /*
     * @Author huyongkun
     * @Date 14:59 2022/5/14
     * @Param [index]
     * @return boolean
     * @Description //删除客户 删除index索引位置的客户
     **/
    public boolean deleteCustomer(int index){
        if (index < 0 || index > total-1){
            return false;
        }
        for (int i = index ; i<total-1;i++){
            customers[i] = customers[i+1];
        }
        customers[--total] = null;
        return true;
    }
    /*
     * @Author huyongkun
     * @Date 14:59 2022/5/14
     * @Param []
     * @return Customer[]
     * @Description //获取所有客户对象，存放到数组中并返回
     **/
    public Customer[] getAllCustomers(){
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }
    /*
     * @Author huyongkun
     * @Date 15:01 2022/5/14
     * @Param [index]
     * @return Customer
     * @Description //获取指定index索引处的客户对象
     **/
    public Customer getCustomer(int index){
        if(index <0 || index > total-1){
            return null;
        }
        return customers[index];
    }
    /*
     * @Author huyongkun
     * @Date 15:01 2022/5/14
     * @Param []
     * @return int
     * @Description //返回记录的客户数量
     **/
    public int getTotal(){
        return total;
    }

}
