import java.util.*;

class Main{
    static Queue<Integer> q = new LinkedList<Integer>();

    static String currentTaskName = "";
    static Scanner sc = new Scanner(System.in);
    //static String [] service = {"New Mem", "Gift", "Check Bal", "Trans Bal"};
    static String x = "[";

    static void promptMsg(){
        int serviceCode = -1;
        
            while(serviceCode!=0){
            System.out.print("Action [1-New Mem, 2-Gift, 3-Check Bal, 4-Trans Bal]");
            serviceCode = Integer.parseInt(sc.nextLine());
            if (serviceCode>4)
                throw new ArrayIndexOutOfBoundsException();
            
            
            switch (serviceCode){
                case 1:
                    for (int i=3;i>=0;i--){
                        q.add(i);
                    }
                    x += "(4 new member) ";
                break;
                case 2:
                for(int i=1;i>=0;i--){
                    q.add(i);
                }
                    x += "(2 gift) ";
                break;
                case 3:
                    q.add(0);
                    x += "(1 check bal) ";                
                break;
                case 4:
                for(int i=2;i>=0;i--){
                    q.add(i);
                }
                break;
            }                   
        }
    }
    public static void main(String[] args) {
        System.out.print("Input simulation time (mins):");
        int minutes = Integer.parseInt(sc.nextLine());



        System.out.println("---------------- START OF SIMULATION -----------------");
    
        for (int i=1;i<minutes+1;i++){
            promptMsg();
            q.poll();
            if (q.element()!=0){
                x.replaceFirst("[0-9]","3");
            }

            System.out.print("After "+i+" min(s)");
            System.out.println(q+"\n");
            System.out.println(x);
            System.out.println("------------------------------------------------------");
        }
 
    }
    

}
