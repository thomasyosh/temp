import java.util.*;

class Main{
    static Queue<Integer> q = new LinkedList<Integer>();
    static String currentTaskName = "";
    static Scanner sc = new Scanner(System.in);
    static String x = "[";
    static RandomSeed r;
    static boolean auto = false;

    static void promptMsg(){
        int serviceCode = -1;
        
            while(serviceCode!=0){
                System.out.print("Action [1-New Mem, 2-Gift, 3-Check Bal, 4-Trans Bal]");
                if (!auto){
                    serviceCode = sc.nextInt();
                    if (serviceCode>4 || serviceCode<0)
                        throw new ArrayIndexOutOfBoundsException();
                }
                    
                else{
                    serviceCode = r.getSeed();
                    System.out.println (serviceCode);
                }
                
                

            
            
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
                x += "(3 trans bal)";
                break;
                case 0:
                    x += "]";
            }                   
        }
    }
    public static void main(String[] args) {
        System.out.print("Input simulation time (mins):");
        int minutes = sc.nextInt();
        if (minutes == 0){
            auto = true;
            minutes = 10;
            System.out.print("Input seed number");
            int seed = sc.nextInt();
            if (seed == 0)
                System.out.print("Input seed number");
            r = new RandomSeed(seed);
        }
        
        System.out.println("---------------- START OF SIMULATION -----------------");
    
        for (int i=1;i<minutes+1;i++){
            promptMsg();
            
            if(i != 1)
                x = x.replaceFirst("]","");
           
 
            if (!q.isEmpty()){
                if (q.element()!=0){
                    int res = new Scanner(x).useDelimiter("\\D+").nextInt();
                    x = x.replaceFirst(String.valueOf(res),String.valueOf(res-1));
                }
                
            else if(q.element()==0){
                x =x.replaceFirst("\\(.*?\\)","");
            }
                
            }
            

            System.out.print("After "+i+" min(s)");
            //System.out.println(q+"\n");
            System.out.println(x);
            q.poll();
            System.out.println("------------------------------------------------------");
        }
 
    }
    

}