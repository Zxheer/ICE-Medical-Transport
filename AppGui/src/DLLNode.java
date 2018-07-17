/**
 * 
 * @author Zaheer 216001758
 *
 */
public class DLLNode<E>
{
	
	protected DLLNode<E> next, previous;
	private E data;
	
	/**
	 * Constructor
	 * @param data
	 * @param previous
	 * @param next
	 */
	protected DLLNode(E data, DLLNode<E> previous, DLLNode<E> next)
	{
		this.data = data;
		this.previous = previous;
		this.next = next;
	}

	protected DLLNode(E data)
	{
		this(data,null,null);
	}
	
	/**
	 * HAs next node?
	 * @return boolean
	 */
	public boolean hasNext()
	{
		return next != null;
	}
	
	/**
	 * has prev node?
	 * @return boolean
	 */
	public boolean hasPrevious()
	{
		return previous != null;
	}
	
	/**
	 * Acessor for data
	 * @return data in the node
	 */
	public E getData() 
	{
		return data;
	}
	
	/**
	 * Mutator for data
	 * @param data
	 */
	public void setData(E data) 
	{
		this.data = data;
	}
	
	/**
	 * Acessor for next node
	 * @return next
	 */
	public DLLNode<E> next()
	{
		return next;
	}
	
	/**
	 * Mutator for previous node
	 * @return previous
	 */
	public DLLNode<E> previous()
	{
		return previous;
	}
	
	/**
	 * Delete node
	 */
	protected void destroy()
	{
		data = null;
		next = null;
		previous = null;
	}
	
	/** 
	 * To string
	 */
	public String toString()
	{
		return String.format("%s", data.toString());
	}
}