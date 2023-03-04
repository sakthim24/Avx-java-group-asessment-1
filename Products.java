 
public class Products {
 
    String product;
    int monthOfPurchase;
    int user_id;

    Products(int id,int month,String product){
        this.user_id=id;
        this.monthOfPurchase=month;
        this.product=product;
    }
  
    @Override
    public String toString()
    {
        return "{" +
                    "product :" + product + '\'' +
                    ", Month of purchase :" + monthOfPurchase +
                    '}';
    }
}