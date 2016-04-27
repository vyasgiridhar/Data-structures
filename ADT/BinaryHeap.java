package ADT;

import java.util.List;
import java.util.ArrayList;
/*
Children are at 2i+1 and 2i+2
Parent is at floor((i-1)/2)
*/
class BinaryHeap<D extends Comparable<D>>{
	private List<D> list;

	public BinaryHeap(){
		this.list = new ArrayList<D>();
	}	

	public void insert(D val){
		try{
			this.list.add(val);
			this.heapifyUp();
		}
		catch(ClassCastException e){
			System.out.println("Caught");
			this.lis
		}
	}

	public void heapifyUp(){
		int chilIndex = this.list.size()-1;
		int parentIndex = this.getParentIndex(chilIndex);
		
		D child = list.get(chilIndex);
		D parent = list.get(parentIndex);
		
		while(child.compareTo(parent)>0){
		
			D temp = child;
			
			list.set(childIndex,parent);
			list.set(parentIndex,temp);
			
			childIndex = parentIndex;
			parentIndex = this.getParentIndex(childIndex);

			child = list.get(childIndex);
			parent = list.get(parentIndex);
		}
	}	

	public D delete(){
		if(this.list.isEmpty()){
			return null;
		}

		D delete = this.list.get(0);

		this.list.set(0,this.list.get(this.list.size()-1));
		this.list.remove(this.list.size()-1);
		
		if(!this.list.isEmpty()){
			this.heapifyDown(0);
		}
		
		return deleted;
	}

	public void heapifyDown(int index){
		
		D rightChild = this.getRightChild(index);
		D leftChild = this.getLeftChild(index);
		D parent = this.list.get(index);

		int nextIndex = index;

		if(rightChild == null && leftChild == null){
			return;
		}
		else ;if(rightChild == null || leftChild.compareTo(rightChild)>0){
			if(parent.compareTo(leftChild)<0){
				this.list.set(index,leftChild)
				nextIndex = this.getLeftChildIndex(index);
				this.list.set(nextIndex,parent);
			}else{
				return;
			}
		}
		this.heapifyDown(nextIndex);
	}

	public D peek(){
		if(!list.isEmpty()){
			return list.get(0);
		}else{
			return null;
		}
	}

    public void print(){
        System.out.println(this.list.toString());
    }	

    public void traverseBFS(){
    	System.out.println("Heap:");
    	for (int index = 0; index < this.list.size(); index++){
    		D parent = this.getParent(index);
    		System.out.println("Parent: "+ parent);
    		D leftChild = this.getLeftChild(index);
    		System.out.println("Node: "+ this.list.get(index));
    		System.out.println("leftChild: "+ leftChild);
    		D rightChild = this.getRightChild(index);
    		System.out.println("rightChild: " + rightChild);
    		System.out.println();
    	}
    }

    public boolean validChild(int index){
    	if(index < this.list.size()){
    		return true;
    	}
    	else{
    		return false;
    	}
    }

    public D getParent(int index){
    	if(index == 0){
    		return null;
    	}
    	else{
    		return this.list.get(this.getParentIndex(index));
    	}
    }
    public int getLeftChildIndex(int index){
        
        return ((2*index)+1);
    
    }
    public D getLeftChild(int index){
      
        int childIndex = this.getLeftChildIndex(index);
        
        if(this.validChild(childIndex)){
        
            return this.list.get(childIndex);
        
        }
        else{
        
            return null;
        
        }
    }
    public int getRightChildIndex(int index){
        
        return ((2*index)+2);
    
    }
    public D getRightChild(int index){
    
        int childIndex = this.getRightChildIndex(index);
    
        if(this.validChild(childIndex)){
    
            return this.list.get(childIndex);
    
        }
        else{
    
            return null;
    
        }
    }
    public List<D> getArray(){
    
        return this.list;
    
    }
    private void setHeap(List<D> copyList){
    
        for(int i=0;i<copyList.size();i++){
    
            this.list.add(copyList.get(i));
    
        }
    }
}