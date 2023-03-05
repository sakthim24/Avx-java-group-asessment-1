import java.util.*;
import java.util.function.Function;
class Products{
    private String bill;
    private int userId;
    private String month;
    public Products(String bill,int userId,String month){
        this.bill=bill;
        this.month=month;
        this.userId=userId;
    }
    public Products(){
        
    }
    public String getBill(){
        return this.bill;
    }
    public int getCount(){
        int cnt=0;
        for(int i=0;i<4;i++)if(Character.compare(bill.charAt(i),'1')==0)cnt++;
        return cnt;
    }
    public String getMonth(){
        return month;
    }
    public int getUserId(){
        return userId;
    }
}