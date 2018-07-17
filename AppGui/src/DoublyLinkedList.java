/**
 * 
 * @author Zaheer 216001758
 *
 */
public class DoublyLinkedList <E> 
{
	
	private DLLNode <E> head,tail;
	private int size;
	
	/**
	 * Constructor
	 */
	public DoublyLinkedList()
	{
		size = 0;
		head = null;
		tail = null;
	}
	
	/**
	 * Mutator to add to tail
	 * @param data
	 * @return node added
	 */
	public DLLNode<E> add(E data)
	{
		DLLNode<E> node = new DLLNode<E>(data);
		
		if(size == 0){
			head = node;
		}else{
			tail.next = node;
			node.previous = tail;
		}
		
		tail = node;
		size++;
		return node;
	}
	
	/**
	 * Mutator to add to head
	 * @param data
	 * @return node added
	 */
	public DLLNode<E> addFirst(E data)
	{
		DLLNode<E> node = new DLLNode<E>(data);
	
		if(size > 0)
			head.previous = node;
		
		node.next = head;
		head = node;
		
		size++;
		return node;
	}
	
	/**
	 * Remove node
	 * @param node
	 */
	public void remove(DLLNode<E> node)
	{
		
		if(head == node){
			
			if(size == 1){
				head = null;
			
			}else{
				node.next.previous = null;
				head = node.next;
			}
			
		}else if(tail == node){
			node.previous.next = null;
			tail = node.previous;
			
		}else{
			node.previous.next = node.next;
			node.next.previous =  node.previous;
		}
		
	    node.destroy();
		size--;
	}
	
	/**
	 * Acessor for DLL size
	 * @return size
	 */
	public int size()
	{
		return size;
	}
	
	/**
	 * Acessor for head
	 * @return head
	 */
	public DLLNode<E> first()
	{
		return head;
	}
	
	/**
	 * ToString
	 */
	public String toString()
	{
		String output = "[";
		DLLNode<E> list = head;
		
		while(list != null){
			output += list.toString();
			if(list.next != null)
				output += ", ";
			list = list.next;
		}
		output += "]";
		return output;
	}
	
	/**
	 * Get Iterator
	 * @return iterator
	 */
	public NodeIterator<E> iterator()
	{
		
		return new NodeIterator<E>() 
		{
			private DLLNode<E> position = head;
			
			public E next()
			{
				DLLNode<E> node = position;
				position = position.next;
				return node.getData();
			}
			
			public boolean hasNext()
			{
				return position != null;
			}
			
			public NodeIterator<E> concatenate(NodeIterator<E> secondIter)
			{
				DoublyLinkedList<E> newList = new DoublyLinkedList<E>();
				while(this.hasNext())
					newList.add(this.next());
				while(secondIter.hasNext())
					newList.add(secondIter.next());
				return newList.iterator();
			}
			
			public int size()
			{
				return DoublyLinkedList.this.size();
			}
			
			public String toString()
			{
				return DoublyLinkedList.this.toString();
			}
		};
	}
}