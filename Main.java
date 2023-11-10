import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main{
    static final String [] action  = {"1-New Mem","2-Gift","3-Check Bal","4-Trans Bal"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input simulation time (mins):");
        int minutes = Integer.parseInt(sc.nextLine());
        Queue<String> q = new LinkedList<String>();
        printMsg();
        int choice = Integer.parseInt(sc.nextLine());
        
        if (choice !=0)
            q.add(action[choice-1]);

        q.poll();
        while(!q.isEmpty()){
            switch(q.peek()){
                        case "1-New Mem":
                        try {
                            Thread.sleep(40000);
                            q.poll();
                        }catch(InterruptedException ex) {
                        
                        }
                        break;
                        case "2-Gift":
                                    try {
                            Thread.sleep(20000);
                            q.poll();
                        } catch(InterruptedException ex) {
                        
                        }
                        break;
                        case "3-Check Bal":
                                    try {
                            Thread.sleep(10000);
                            q.poll();
                        } catch(InterruptedException ex) {
                        
                        }
                        break;
                        case "4-Trans Bal":
                                    try {
                            Thread.sleep(30000);
                            q.poll();
                        } catch(InterruptedException ex) {
                        
                        }
                        break;
                    }
        };


        
        System.out.println("finished");
        };


    static void printMsg(){
        System.out.print("Action [");
        for (int i=0;i<action.length;i++){
            if(i!=action.length-1)
                System.out.print(action[i]+", ");
            else
                System.out.print(action[i]);
        }
        System.out.print("]");
    }

    }
