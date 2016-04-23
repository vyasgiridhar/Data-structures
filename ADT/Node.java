package ADT;

public class Node<K>{
	
	private D data;
	private Node next;

	public Node(D data,Node next){
		this.data = data;
		this.next = next;
	}

	public D getData(){
		return this.data;
	}

	public Node getNext(){
		return this.next;
	}

	public void setNext(Node nextNode){
		this.next = nextNode;
	}
}