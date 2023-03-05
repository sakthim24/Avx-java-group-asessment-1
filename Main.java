
import java.util.*;
import java.util.function.Function;

public class Main
{
	public static void main(String[] args) {
        int n,m;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        //assigning input containers
        //Users userData[] = new Users[n];
        ArrayList<Users> userData = new ArrayList<Users>();
        //input
        int userId,age;
        String userName;
        char gender;
        for(int i=0;i<n;i++){
           userId = sc.nextInt();
           age = sc.nextInt();
           userName = sc.next();
           //sc.nextLine().; // consume newline character
           gender = sc.next().charAt(0);
           Users tmp = new Users(userId,age,userName,gender);
           userData.add(tmp);
        }
        m=sc.nextInt();
        ArrayList<Products> productData = new ArrayList<Products>();
        String month,bill;
        for(int i=0;i<m;i++){
           bill = sc.next();
           userId = sc.nextInt();
           month = sc.next();
           Products tmp = new Products(bill,userId,month);
           productData.add(tmp);
        }
        
        // System.out.println("size of userDAta = " + userData.size()+ "  size of productData = "+productData.size());
        Map<Integer,Users> userIdToClass = new HashMap<>();
        for(int i=0;i<n;i+=1){
        //   System.out.println(userData.get(i).userId);
           userIdToClass.put(userData.get(i).getUserId(),userData.get(i));
        }
        // for(Map.Entry<Integer, Users> it : userIdToClass.entrySet()){
        //   System.out.println("key = "+it.getKey()+"value = "+it.getValue().getName());
        // }
        
        
        Function<ArrayList<Users>,ArrayList<Users>> function = (ArrayList<Users> tmp) -> {
            ArrayList<Users>resultList = new ArrayList<Users>();
            for(int i=0;i<tmp.size();i++){
                if(i==0)
                    resultList.add(tmp.get(i));
                else if(tmp.get(i-1).getUserId()!=tmp.get(i).getUserId())
                    resultList.add(tmp.get(i));
            }
            tmp = resultList;
            return tmp;
        };
        
        System.out.println("question 1 output = ");
        //question1-
        ArrayList<Users >Q1Users = new ArrayList<Users>();
        for(int i=0;i<productData.size();i++){
        //   System.out.println("pd.get(i).getmon = "+productData.get(i).getMonth()+"userid = "+productData.get(i).getUserId());
           if(productData.get(i).getMonth().equals("jan")){
            //   System.out.println("i am inside the if statement");
               Q1Users.add(userIdToClass.get(productData.get(i).getUserId()));
           }
           
        }
        
        Collections.sort(Q1Users,(Users u1,Users u2) -> u1.getUserId()-u2.getUserId());
        ArrayList A1Users = function.apply(Q1Users);
        Collections.sort(A1Users,(Users u1,Users u2)-> u1.getAge()-u2.getAge());
        System.out.println("unprocessed array = " + Q1Users + "\n sorted by age and removed duplicates = " + A1Users);
        
        
        System.out.println("\n\n question3- output = ");
        //question3-
        ArrayList<String > months= 
            new ArrayList(List.of("jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"));
        ArrayList<Users > Q3Users= new ArrayList<Users >();
        ArrayList<Users > A3Users= new ArrayList<Users >();
        for(int i=0;i<productData.size();i++){
            userIdToClass.get(productData.get(i).getUserId()).update(productData.get(i));
        }
        for(int i=0;i<12;i++){
            System.out.println("for month "+months.get(i)+" the sorted by no of products is = ");
            Q3Users.clear();
            A3Users.clear();
            for(int j=0;j<productData.size();j++){
                if(months.get(i).equals(productData.get(j).getMonth())){
                    Q3Users.add(  userIdToClass.get(productData.get(j).getUserId())  );
                }
            }
            Integer ind=i;
            Collections.sort(Q3Users,(Users u1,Users u2) -> u1.getUserId()-u2.getUserId());
            A3Users = function.apply(Q3Users);
            Collections.sort(Q3Users,(Users u1,Users u2) -> u1.getTotalProductsPerMonth(months.get(ind))-u2.getTotalProductsPerMonth(months.get(ind)));
            System.out.println(Q3Users);
        }
	}
}
/*
input:-
5
1 22 krishna m
2 21 sahi f
3 19 venket m
4 52 anand m
5 47 sreedevi f
5
1111 5 jan
0010 2 feb
0001 3 feb
1010 4 jan
0101 5 jan
output:-

*/