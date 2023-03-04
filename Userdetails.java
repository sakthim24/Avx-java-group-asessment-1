
public class Userdetails extends products
{
    int user_id;
    String user_name;
    int age;
    String gender ;
 
    public Userdetails(int id,String user_name, int age,String gender)
    {
        this.user_id=id;
        this.user_name = user_name;
        this.age = age;
    }
 
    void purchase(int id,String product,int month){
        this.user_id=id;
        this.monthOfPurchase=month;
        this.product=product;
    }
    void display(){
       System.out.println();
    }
 
    public String getuser_name() {
        return user_name;
    }
 
    public int getAge() {
        return age;
    }
 
   

}