//----------------------------------------------------------------------
// EmergencyQueueTest.java       by : Eric Lavoie             100122593     
// 
//creates a simple user interface that can creates a queue for an 
// emergency room. the interface can add, remove, find next in queue and
// create a list. as well as display stats of the queue
//----------------------------------------------------------------------

import java.util.Scanner;
  
public class EmergencyQueueTest
{
    public static void main(String[] args)
    {   
       //initializes total patients served, total patients waiting and
       // a temperary value
       int tps, tpw, temp ;
       //initializes total number of patients served and in queue
       tps = 0; 
       tpw = 0;
       //initializes scanner 
       Scanner scan = new Scanner(System.in);
 
        
       System.out.println("Enter maximum occupants in waiting room ");
       PriorityQueue pq = new PriorityQueue(scan.nextInt() );
       //initializes char for the continue option
       char option;
       //outputs a list of options the user can use by entering the correspondin g number 
       //corresponding number 
       do    
       {
            System.out.println("\nEmergency clerk options\n");
            System.out.println("1. add a patient to priority queue");
            System.out.println("2. remove a treated patient");
            System.out.println("3. check if queue is empty");
            System.out.println("4. check if queue is full");
            System.out.println("5. next in priority queue");
            System.out.println("6. number of people in queue");
            System.out.println("7. stats");
            System.out.println("8. List");
            System.out.println("9. reset queue");
            // asks for the option the user would like to use
            int choice = scan.nextInt();            
            switch (choice) 
            {
            //ask the user to enter a name and a priority number
            // to enter a full name the name must be sperate by "_"
            // ie(tom_johnson 10)
            case 1 : 
                //scaner asks for the patients name and priority number
                System.out.println("Enter name and priority");
                pq.add(scan.next(), scan.nextInt() );   
                tpw++ ;
                break;
            // calls on the remove method and removes a patient from queue 
            //and add to the patients served stats
            case 2 : 
                System.out.println("\n Patient has been treated \n"+ pq.remove());
                tpw-- ;
                tps++ ;
                break;
                // states if the queue is empty
            case 3 : 
                System.out.println("\nEmpty Status : "+ pq.isEmpty() );
                break; 
               // states if the queue is full
            case 4 : 
                System.out.println("\nFull Status : "+ pq.isFull() );
                break; 
            case 5 : 
                System.out.println("\n next patient is :  = "+ pq.next());
              //creates spacing for the outputs in the interface  
             default : 
                System.out.println(" \n ");
                break; 
             // Outputs the number of patients in queue
             case 6 : 
                System.out.println("\nSize = "+ pq.size() );
                break; 
              //outputs the # of patients removed and in queue
              case 7 : 
                System.out.println("\n patients waiting  = "+ tpw
                                  +"\n patients served  = "+ tps);
                break;
              // calls the list method and loops for the # of patints 
              case 8 :  
                temp =tpw;
                System.out.println( "List of patients in Queue" );
                while (temp > 0){
                System.out.println(" \n"+pq.list () );
                temp--;
                }
              
               break;
              //  Resets the Queue and stats
              case 9 :
                System.out.println("\nPriority Queue reset");
                pq.reset();
                tpw = 0 ;
                tps = 0 ;
                break;   

            }    
            // asks the user if they want to continue using the interface
            System.out.println("\nDo you want to continue (Type y or n) \n");
            option = scan.next().charAt(0);
           //checks for y 
        } while (option == 'Y'|| option == 'y');   
    }
    
}