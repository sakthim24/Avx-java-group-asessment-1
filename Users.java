import java.util.*;
import java.util.function.Function;
public class Users extends Products{
    //improtant information
    private int userId;
    private int age;
    private String userName;
    private char gender;
    
    //optional information
    private ArrayList<Integer > noTransactionPerMonth = new ArrayList(
        List.of(0,0,0,0,0,0,0,0,0,0,0,0)
        );
    private ArrayList<Integer > totalProductsPerMonth = (ArrayList<Integer>)noTransactionPerMonth.clone();  
    public static final Map<String, Integer> monthsToNo = new HashMap<String, Integer>();
    static{
        monthsToNo.put("jan",1);
        monthsToNo.put("feb",2);
        monthsToNo.put("mar",3);
        monthsToNo.put("apr",4);
        monthsToNo.put("may",5);
        monthsToNo.put("jun",6);
        monthsToNo.put("jul",7);
        monthsToNo.put("aug",8);
        monthsToNo.put("sep",9);
        monthsToNo.put("oct",10);
        monthsToNo.put("nov",11);
        monthsToNo.put("dec",12);
    }
    public static final ArrayList<String > noToMonths=
             new ArrayList(List.of("jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"));
    
    //methods
    public Users(int userId,int age,String userName,char gender){
        super();
        this.userId=userId;
        this.age=age;
        this.userName=userName;
        this.gender=gender;
        // mapIdToAge.put(userId,age);
    }
    public int getAge(){
        return age;
    }
    public int getUserId(){
        return userId;
    }
    public char getGender(){
        return gender;
    }
    public String getName(){
        return userName;
    }
    
    @Override
    public String toString(){
        return "{" + "name ="+userName+" Id = "+userId+" age = "+age+" gender = "+gender+"}";
    }
    
    public void update(Products data){
        totalProductsPerMonth.add(monthsToNo.get(data.getMonth()),data.getCount());
        noTransactionPerMonth.add(monthsToNo.get(data.getMonth()),1);
    }
    
    public Integer getTranctionPerMonth(String str){
        return noTransactionPerMonth.get(Users.monthsToNo.get(str));
    }
    public Integer getTotalProductsPerMonth(String month){
        return totalProductsPerMonth.get( Users.monthsToNo.get(month) );
    }
    public Integer getTotalTranction(){
        Integer result = 0;
        for(int i=0;i<12;i++){
            result+=noTransactionPerMonth.get(i);
        }
        return result;
    }
    public Integer getTotalProducts(){
        // return totalProductsPerMonth.stream().mapToInt(Integer::intValue).sum();
        Integer result = 0;
        for(int i=0;i<12;i++)result+=totalProductsPerMonth.get(i);
        return result;
    }
    
    // public int getAge(int userId){
    //     return mapIdToAge.get(userId);
    // }
}