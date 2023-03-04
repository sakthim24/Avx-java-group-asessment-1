import java.util.*;
 


 class Userdetails 
{
    int user_id;
    String user_name;
    int age;
    String gender ;
    
    List<Products> products =new  ArrayList<Products>();
    public Userdetails(int id,String user_name, int age,String gender)
    {
        this.user_id=id;
        this.user_name = user_name;
        this.age = age;
        this.gender =gender;
    }
 
    void purchase(int id,String product,int month){
        products.add(new Products(user_id,month,product));

    }
    void display(){
       System.out.println(user_name + " /n" + products);
    }
 
    public String getuser_name() {
        return user_name;
    }
 
    public int getAge() {
        return age;
    }
    @Override
    public String toString()
    {
        return "{" +
                    "user_name='" + user_name + '\'' +
                    ", age=" + age +
                    ", purchase=" + products +
                    '}';
    }
   

}



class Main 
{
    static void EnterDetails( List<Userdetails> users){
       
        int flag=1;
        Scanner sc=new Scanner(System.in);
        do {
        
            System.out.println("Enter user_id");
            int current_user=sc.nextInt();
            System.out.println("Enter product");
            String current_product=sc.next();
            System.out.println("Enter month");
            int current_month=sc.nextInt();
            users.get(current_user).purchase(current_user,current_product,current_month);
            System.out.println("product added succesfully! " );
            users.get(current_user).display();
            System.out.println("Press 1 if you want to continue! " );
            flag=sc.nextInt();
        } while (flag == 1);
    }
    public static void main(String[] args)
    {
        List<Userdetails> users = new ArrayList<>(Arrays.asList(
                                            new Userdetails(1,"John", 15,"male"),
                                            new Userdetails(2,"Sam", 20,"female"),
                                            new Userdetails(3,"Joe", 10,"male")
    
                                            ));
        EnterDetails(users);
        System.out.println(users);
    }
}
