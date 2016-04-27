package ADT;

class Priority_Queue<D extends Comparable<D>>{
    private Binary_Heap_Array_Structure <D> bh;
    
    public Priority_Queue(){
        
        bh = new Binary_Heap_Array_Structure<>();
    
    }
    public void enQueue(D data){
    
        this.bh.insert(data);
    
    }
    public D deQueue(){
    
        return this.bh.delete();
    
    }
    public void print(){
    
        Binary_Heap_Array_Structure copy = this.bh.copyHeap();
        
        System.out.print("FRONT < "+copy.delete());
    
        while(copy.peek()!=null){
    
            System.out.print(", " + copy.delete());
    
        }
        
    }
}