 
public class Products {
 
    String productName;
    int monthOfPurchase;
    int user_id;

    Products(int id,int month,String product){
        this.user_id=id;
        this.monthOfPurchase=month;
        this.productName=product;
    }
  
    @Override
    public String toString()
    {
        return "{" +
                    "product :" + productName  +
                    ", Month of purchase :" + monthOfPurchase +
                    '}';
    }
}