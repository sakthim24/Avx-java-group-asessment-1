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
       System.out.println(user_name + " : " + products);
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


