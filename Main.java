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
   
    static int compareByAge(Userdetails c0, Userdetails c1)
    {
        return Integer.compare(c0.age, c1.age);
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
            users.get(current_user-1).purchase(current_user,current_product,current_month);
            System.out.println("product added succesfully! " );
            users.get(current_user-1).display();
            System.out.println("Press 1 if you want to continue! " );
            flag=sc.nextInt();
        } while (flag == 1);
    }


    static void sortbyage( List<Userdetails> users){
      
        List<Userdetails> filterdusers = new ArrayList<>();
        users.forEach((user) -> {
           
         user.products.forEach((product) -> {
           if( product.monthOfPurchase >= 1 && product.monthOfPurchase <=6){
           if(!(filterdusers.contains(user))) filterdusers.add(user);
           
           }
            
         });
        });
        Collections.sort(filterdusers, Comparator.comparingInt(c -> c.age));
        System.out.println("Users sorted by age who purchased products between jan and june\n" + filterdusers);
    }



   

    public static void main(String[] args)
    {
        List<Userdetails> users = new ArrayList<>(Arrays.asList(
                                            new Userdetails(1,"Sakthi", 15,"male"),
                                            new Userdetails(2,"shakshi", 20,"female"),
                                            new Userdetails(3,"sarvesh", 10,"male"),
                                            new Userdetails(4,"santhosh", 18,"male"),
                                            new Userdetails(5,"Krity", 11,"female"),
                                            new Userdetails(6,"Rocky", 25,"male"),
                                            new Userdetails(7,"pratika", 13,"female")
                                            ));
        EnterDetails(users);
        sortbyage(users);
        System.out.println(users);
    }
}
