import java.util.*;
 

class Main 
{
    static void EnterDetails( List<Userdetails> users){
       
        int flag=1;
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome shopping! \n");
        do {
          
            System.out.println("*********************************************************************** \n");
            System.out.println("Enter user_id");
            int current_user=sc.nextInt();
            System.out.println("Enter product [mobile,watch,tv,laptop]");
            String current_product=sc.next();
            System.out.println("Enter month [In number]");
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
           if( product.productName.equals("mobile") && product.monthOfPurchase >= 1 && product.monthOfPurchase <=6){
           if(!(filterdusers.contains(user))) filterdusers.add(user);
           
           }
            
         });
        });
        Collections.sort(filterdusers, Comparator.comparingInt(c -> c.age));
        System.out.println("\nUsers sorted by age who purchased mobiles between jan and june\n" );
        filterdusers.forEach((user) -> 
        {
        System.out.println(user.user_name + "  " + user.age);
        });
       
    }

    static void sortfemales( List<Userdetails> users){
      
        List<Userdetails> filterdusers = new ArrayList<>();
        users.forEach((user) -> {
          if(user.gender.equals("female")){ 
         user.products.forEach((product) -> {
           if( product.monthOfPurchase >= 3 && product.monthOfPurchase <=7){
           if(!(filterdusers.contains(user))) filterdusers.add(user);
           
           }
            
         });
        }
        });
        
        System.out.println("\nFemales who purchased watch between March and july\n" );
        filterdusers.forEach((user) -> 
        {
        System.out.println(user.user_name );
        });
       
    }


    static void sortbymonth( List<Userdetails> users){
      
        //List<Userdetails> filterdusers = new ArrayList<>();
        HashMap<Integer,List<Userdetails>> filterdusers =new HashMap<Integer,List<Userdetails>>();
        users.forEach((user) -> {
         
         user.products.forEach((product) -> {
                      
           if(filterdusers.containsKey(product.monthOfPurchase))
          filterdusers.get(product.monthOfPurchase).add(user);
          else{
          filterdusers.put(product.monthOfPurchase, new ArrayList<>(Arrays.asList(user)));
          }
         });
        });
      
        System.out.println("\nsorted list of people who purchased products by month\n" );


        TreeMap<Integer, List<Userdetails>> sorted = new TreeMap<>();
 
        
        sorted.putAll(filterdusers);
 
        // Display the TreeMap which is naturally sorted
        for (Map.Entry<Integer, List<Userdetails>> entry : sorted.entrySet())
            System.out.println("Month = " + entry.getKey() +
                         ", Users = " + entry.getValue());   

       
       
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
        sortfemales(users);
        sortbymonth(users);
       // System.out.println(users);
    }
}
