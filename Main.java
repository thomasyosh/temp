import java.util.*;

class Main{
    static Queue q = new LinkedQueue();
    static Scanner sc = new Scanner(System.in);
    static String x = "[";
    static RandomSeed r;
    static boolean auto = false;
    static int actionComplete = 0;
    static int totalActionCount = 0;

    static void promptMsg() throws InputMismatchException{
        int serviceCode = -1;
        
           
        while(serviceCode!=0){
                System.out.print("Action [1-New Mem, 2-Gift, 3-Check Bal, 4-Trans Bal]");
                if (!auto){                       
                    try{
                      serviceCode = sc.nextInt();
                       
                        if (!Integer.toString(serviceCode).matches("[0-4]")){
                            throw new ArrayIndexOutOfBoundsException();
                        }
                    }catch(InputMismatchException e){
                        System.out.println("Not a valid input, please input numbers only");
                        sc.next();

                    }catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Please input a number ranged from 0 and 4");
                    }

                   
                }
                    
                else{
                    serviceCode = r.getSeed();
                    System.out.println (serviceCode);
                }          
            
            switch (serviceCode){
                case 1:
                    for (int i=3;i>=0;i--){
                        q.enqueue(i);
                    }
                    x += "(4 new member)";
                    totalActionCount++;
                break;
                case 2:
                for(int i=1;i>=0;i--){
                    q.enqueue(i);
                }
                    x += "(2 gift)";
                    totalActionCount++;
                break;
                case 3:
                    q.enqueue(0);
                    x += "(1 check bal)";
                    totalActionCount++;                
                break;
                case 4:
                for(int i=2;i>=0;i--){
                    q.enqueue(i);
                }
                x += "(3 trans bal)";
                totalActionCount++;
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
            System.out.print("Input seed number: ");
            int seed = sc.nextInt();
            r = new RandomSeed(seed);
        }
        
        System.out.println("---------------- START OF SIMULATION -----------------");
    
        for (int i=1;i<minutes+1;i++){
            promptMsg();
            
            if(i != 1)
                x = x.replaceFirst("]","");
           
 
            if (!q.isEmpty()){
                if ((int) q.front()!=0){
                    int res = new Scanner(x).useDelimiter("\\D+").nextInt();
                    x = x.replaceFirst(String.valueOf(res),String.valueOf(res-1));
                }
                
            else if((int)q.front()==0){
                x =x.replaceFirst("\\(.*?\\)","");
                actionComplete++;
            }
                
            }
            

            System.out.print("After "+i+" min(s)");
            //System.out.println(q+"\n");
            System.out.println(x);
            if (!q.isEmpty())
                q.dequeue();
            System.out.println("------------------------------------------------------");           
        }
        System.out.println("----------------- END OF SIMULATION ------------------");
            System.out.println("Total mins simulated: " + minutes + " minutes");
            System.out.println("Number of members served: "+actionComplete);
            System.out.println("Action queued during the simulation: "+totalActionCount);
            System.out.println("Outstanding item at the end of simulation: "+ (totalActionCount-actionComplete));
 
    }
    

}