package ADT;

public class Stack{
	private Node head;

	public Stack(){
		
		this.head = null;
	
	}

	public <K> void push(K data){
		
		Node<k> node = new Node(data,this.head);
		this.head = node;
	
	}

	public Node pop(){

		if(this.head != null){

			Node oldData = this.head;
			this.head = this.head.getNext();
			return oldData;

		}

		return null;
	}

	public void print(){

		System.out.println("Stack Data:\nTOP");
		Node current = this.head;
		while(current != null){

			System.out.println("Data = "+current.getData());
			current = current.getNext();

		}
		System.out.println("END");

	}

}