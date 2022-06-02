/**
 * @author huyongkun
 * @ClassName CustomerView
 * @create 2022-05-14 15:35
 * @Version 1.0
 * @description: 系统的展示界面
 */
public class CustomerView {

    CustomerList customerList = new CustomerList(10);

    public void enterMainMenu(){
        boolean flag = true;
        while (flag){
            System.out.println("-------------------客户信息管理软件--------------------");
            System.out.println("                   1 添 加 客 户                      ");
            System.out.println("                   2 修 改 客 户                      ");
            System.out.println("                   3 删 除 客 户                      ");
            System.out.println("                   4 客 户 列 表                      ");
            System.out.println("                   5 退      出                      ");
            System.out.print("请选择(1-5):");
            char c = CMUtility.readMenuSelection();
            switch (c){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.println("确认是否要退出(Y/N):");
                    char a = CMUtility.readConfirmSelection();
                    if(a == 'Y'){
                        flag = false;
                        System.out.println("已成功退出5");
                    }

            }
        }
    }
    //添加客户
    private void addNewCustomer(){
        System.out.println("-----------------------添 加 客 户------------------------------");
        System.out.print("姓名:");
        String name = CMUtility.readString(10);
        System.out.print("性别:");
        char gender = CMUtility.readChar();
        System.out.print("年龄:");
        int age = CMUtility.readInt();
        System.out.print("电话:");
        String phone = CMUtility.readString(15);
        System.out.print("邮箱:");
        String email = CMUtility.readString(15);
        Customer cust = new Customer(name, gender, age, phone, email);
        boolean flag = customerList.addCustomer(cust);
        if(flag){
            System.out.println("添加成功");
        }else {
            System.out.println("人员已满，添加失败");
        }
    }
    //修改客户
    private void modifyCustomer(){
        System.out.println("-----------------------修 改 客 户------------------------------");
        //记录修改客户的索引
        int index;
        while (true){
            System.out.println("请输入待修改的客户编号(-1退出):");
            index = CMUtility.readInt();
            if(index == -1){
                return;
            }
            if(index < 1 || index > customerList.getTotal()){
                System.out.println("没有找到此客户");
            }else{
                break;
            }
        }
        Customer cust = customerList.getCustomer(index-1);
        System.out.print("姓名:");
        String name = CMUtility.readString(10,cust.getName());
        System.out.print("性别:");
        char gender = CMUtility.readChar(cust.getGender());
        System.out.print("年龄:");
        int age = CMUtility.readInt(cust.getAge());
        System.out.print("电话:");
        String phone = CMUtility.readString(15,cust.getPhone());
        System.out.print("邮箱:");
        String email = CMUtility.readString(15,cust.getEmail());
        cust = new Customer(name,gender,age,phone,email);
        boolean b = customerList.replaceCustomer(index - 1, cust);
        if(b){
            System.out.println("修改成功");
        }else {
            //此处永远不会运行,b一定为true
            System.out.println("没有找到此客户，修改失败");
        }
    }
    //删除客户
    private void deleteCustomer(){
        System.out.println("-----------------------删 除 客 户------------------------------");
        int index;//记录要删除客户的索引
        while (true){
            System.out.println("请输入待删除的客户编号(-1退出):");
            index = CMUtility.readInt();
            if(index == -1){
                return;
            }
            if(index < 1 || index > customerList.getTotal()){
                System.out.println("没有找到此客户");
            }else{
                break;
            }
        }
        boolean b = customerList.deleteCustomer(index - 1);
        if(b){
            System.out.println("删除成功");
        }else {
            //此处永远不会运行,b一定为true
            System.out.println("没有找到此客户，删除失败");
        }
    }
    //客户信息列表
    private void listAllCustomers(){
        System.out.println("-----------------------客 户 列 表------------------------------");
        Customer[] custs = customerList.getAllCustomers();
        if (custs.length == 0){
            System.out.println("没有客户记录");
        }else{
            System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t邮箱");
            for (int i = 0; i < custs.length; i++) {
                System.out.println(i+1+"\t"+custs[i].toString());
            }
        }
    }
    public static void main(String[] args){
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }







}
