package ADTs;
 
public class Queue{
	private Node head;
	
	public Queue(){
		this.head = null;
	}
	
	public <D> void enQueue(D data){
		if(this.head == null){
			this.head = new Node(data,null);
		}
		else{
			Node current = this.head;
			while(current.getNext() != null){
				current = current.getNext();
			}
			current.setNext(new Node(data,null));
		}
	}

	public Node deQueue(){
		Node returnNode = this.head;

		if(this.head != null){
			this.head = this.head.getNext();
		}
		return returnNode;
	}

	public void printQueue(){
		Node current = this.head;
		System.out.println("Queue");
		while(current != null){
			System.out.println("Data: " + current.getData())
			current = current.getNext();
		}
		System.out.println("END");
	}
	
}