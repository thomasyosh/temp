import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main{
    static Queue<Integer> q = new LinkedList<Integer>();
    static Scanner sc = new Scanner(System.in);

    static void promptMsg(){
        int serviceCode = -1;
        
            while(serviceCode!=0){
            System.out.print("Action [1-New Mem, 2-Gift, 3-Check Bal, 4-Trans Bal]");
            serviceCode = Integer.parseInt(sc.nextLine());
            if (serviceCode>4)
                throw new ArrayIndexOutOfBoundsException();
            
            switch (serviceCode){
                case 1:
                    for (int i=0;i<4;i++){
                        q.add(serviceCode);
                    }                    
                break;
                case 2:
                for(int i=0;i<2;i++){
                    q.add(serviceCode);
                }
                break;
                case 3:
                    q.add(serviceCode);                   
                break;
                case 4:
                for(int i=0;i<3;i++){
                    q.add(serviceCode);
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
            System.out.print("After "+i+" min(s)");
            q.poll();
            System.out.print(" "+q+"\n");
            System.out.println("------------------------------------------------------");
        }
        




        
        
        
    }
    

}
