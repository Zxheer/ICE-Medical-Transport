/**
 * 
 * @author Zaheer 21600175
 *
 */
public interface NodeIterator <E> 
{  //Used to iterate over List
	
	public E next();
	public boolean hasNext();
	public NodeIterator<E> concatenate(NodeIterator<E> secondIter);
	public int size();
	
}