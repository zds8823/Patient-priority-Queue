//----------------------------------------------------------------------
//   Queue.java               by : Eric Lavoie             100122593     
//  
// makes classes for the EmergencyQueue interface. makes methods to 
// remove,isfull,isempty, size, add, list, reset and next in queue
//
//----------------------------------------------------------------------

class Queue
{
    //initializes the two expected inputs
    String name;
    double priority;
 
    //puts the name and priority number into the queueu
    public Queue(String name, double priority)
    {
        this.name = name;
        this.priority = priority; 
    }
    //creates a tostring which formats the output of the queue
    public String toString() 
    {
        return "patient Name : "+ name +"   Priority # : "+ priority;
    }
}

//creates a priority queue class
class PriorityQueue
{
      // calls the queue array and priority heap
      private Queue[] heap; 
      private int heapSize, limit;
 
    //sets the heap size to the queue limit / the number in queue
    public PriorityQueue(int limit)
    {    
        this.limit = limit + 1;
        heap = new Queue[this.limit];
        heapSize = 0;
    }
    //sets the queue to 0 reseting the heap size
    public void reset()
    {
        heap = new Queue[limit];
        heapSize = 0;
    }
    // checks if there are 0 people in queue
    public boolean isEmpty()
    {
        return heapSize == 0;
    }
    // checks if the number of people in the queue is equal to the max number
    //of people in the queue
    public boolean isFull()
    {
        return heapSize == limit - 1;
    }
    
    
    // gets the size of the queue / the number of people in queue
    public int size()
    {
        return heapSize;
    }
    
    
    //  creates add method that will add an inputed name and priority number
    // to the priority queue and increases the heap size
    public void add(String name, int priority)
    {
        Queue newPatient = new Queue(name, priority);
        heap[++heapSize] = newPatient;
        int point = heapSize;
        //comparator sorts the list by priority
        while (point != 1 && newPatient.priority > heap[point/2].priority)
        {
            heap[point] = heap[point/2];
            point /=2;
        }
        //intializes the new patient to the queue
        heap[point] = newPatient;    
    }
    //remove method that will remove the person with the highest priority #
    // and subtract from the heap size
    public Queue remove()
    {
        int last, first;
        Queue out, temp;
        //checks that the queue is not empty
        if (isEmpty() )
        {
            System.out.println("Heap is empty");
            return null;
        }
        //gets the first person in queue
        out = heap[1];
        //removes one from the queue
        temp = heap[heapSize--];
 
        last = 1;
        first = 2;
        //comparator that finds the highest priority in queue
        while (first <= heapSize)
        {
            if (first < heapSize && heap[first].priority < heap[first + 1].priority)
                first++;
            if (temp.priority >= heap[first].priority)
                break;
       
            heap[last] = heap[first];
            last = first;
            first *= 2;
         }
         heap[last] = temp;
         
        return out;
        }
    
        //find the next person in the priority queue
        public Queue next()
        {
           Queue out;
           out = heap[1];
           return out;
        }
     
        //method that generatess a list from the queue
        public Queue list()
        {        
           int last, first;
           Queue out, temp;
           //starts with the firts in queue
           out = heap[1];
           temp = heap[heapSize];
 
           last = 1;
           first = 2;
            //comparator that checks for the largest priority number
           while (first <= heapSize)
           {
               if (first < heapSize && heap[first].priority < heap[first + 1].priority)
                  first++;
               if (temp.priority >= heap[first].priority)
               break;
               heap[last] = heap[first];
               last = first;
               first *= 2;
           }
           heap[last] = temp;
           return out;
           }
}
 
