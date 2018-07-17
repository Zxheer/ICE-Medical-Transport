/**
 * 
 * @author Zaheer 216001758
 *
 * 
 */
	public class Vertex <E,T> implements Comparable<Vertex<E,T>>
	{
		
		private E data;
		private DoublyLinkedList<Edge<E,T>> insideEdges;
		private DoublyLinkedList<Edge<E,T>> outsideEdges;
		private DLLNode<Vertex<E,T>> positionNode;
		private int status;
		private final int id;
		private Vertex<E,T> dijkstraP;
		private double dijkstraV;
		private Edge<E,T> dijkstraE;
		
		public static final int UNVISITED = 0;
		public static final int VISITING = 1;
		public static final int VISITED = 2;
		
	
		/**
		 * Vertex Constructor 
		 * @param data = name of hospital
		 * @param id = unique Primary Key of hospital
		 */
		public Vertex(E data, int id) 
		{
			this.data = data;
			this.status = UNVISITED;
			this.id = id;
			insideEdges = new DoublyLinkedList<Edge<E,T>>();
			outsideEdges = new DoublyLinkedList<Edge<E,T>>();
		}
		
		/**
		 * Constructor without the primary key
		 * @param data
		 */
		public Vertex(E data) 
		{
			this(data,0);
		}
		
		
		/**
		 * Get outsideEdges edges
		 * @return iterator
		 */
		public NodeIterator<Edge<E,T>> getOutsideEdges()
		{
			return outsideEdges.iterator();
		}
		
		/**
		 * Get insideEdges edges
		 * @return iterator
		 */
		public NodeIterator<Edge<E,T>> getInsideEdges()
		{
			return insideEdges.iterator();
		}
		
		/**
		 * Add outsideEdges
		 * @param e
		 * @return node
		 */
		public DLLNode<Edge<E,T>> addOutEdge(Edge<E,T> e)
		{
			return outsideEdges.add(e);
		}
		
		/**
		 * Add insideEdge
		 * @param e
		 * @return node 
		 */
		public DLLNode<Edge<E,T>> addInEdge(Edge<E,T> e)
		{
			return insideEdges.add(e);
		}
		
		/**
		 * Remove insideEdge
		 * @param node
		 */
		public void removeInEdge(DLLNode <Edge<E,T>> node)
		{
			insideEdges.remove(node);
		}
		
		/**
		 * Remove outSideEdge
		 * @param node
		 */
		public void removeOutEdge(DLLNode <Edge<E,T>> node)
		{
			outsideEdges.remove(node);
		}
		
		/**
		 * Accessor for VertexData
		 * @return data
		 */
		public E getData()
		{
			return data;
		}
		
		/**
		 * Acessor for node with chosen vertex
		 * @return node
		 */
		public DLLNode<Vertex<E,T>> getPositionNode() 
		{
			return positionNode;
		}
		
		/**
		 * Mutator fo node that stores chosen vertex
		 * @param positionNode
		 */
		public void setPositionNode(DLLNode<Vertex<E,T>> positionNode)
		{
			this.positionNode = positionNode;
		}

		/**
		 * Mutator for data of vertex
		 * @param data
		 */
		public void setData(E data) 
		{
			this.data = data;
		}
		
		/**
		 * Acessor for vertex status
		 * @return status
		 */
		public int getStatus() 
		{
			return status;
		}

		/**
		 * Mutator for vertex status
		 * @param status
		 */
		public void setStatus(int status) 
		{
			this.status = status;
		}

	
		/**
		 * Acessor for vertexP
		 * @return parent of vertex
		 */
		public Vertex<E,T> getDijkstraP() 
		{
			return dijkstraP;
		}

		/**
		 * Mutator to set vertexP
		 * @param dijkstraP
		 */
		public void setDijkstraP(Vertex<E,T> dijkstraP) 
		{
			this.dijkstraP = dijkstraP;
		}

		/**
		 * Acessor for value of vertex
		 * @return accumulated value of a vertex
		 */
		public double getDijkstraV()
		{
			return dijkstraV;
		}

		/**
		 * Mutator for value of a vertex
		 * @param dijkstraV
		 */
		public void setDijkstraV(double dijkstraV) 
		{
			this.dijkstraV = dijkstraV;
		}
		
		/**
		 * Acessor for edge of curruent vertex length to DikstraP
		 * @return edge
		 */
		public Edge<E,T> getDijkstraE()
		{
			return dijkstraE;
		}

		/**
		 * Mutator for edge of curruent vertex length to DikstraP
		 * @param dijkstraE
		 */
		public void setDijkstraE(Edge<E,T> dijkstraE) 
		{
			this.dijkstraE = dijkstraE;
		}
		
		/**
		 * Acessor of PK
		 * @return id
		 */
		public int getID()
		{
			return id;
		}

		
		/**
		 * Gives data as String
		 */
		public String toString()
		{
			return String.format("<%s>", data.toString());
		}
		
		/**
		 * compareFn
		 */
		@Override
		public int compareTo(Vertex<E, T> arg0) 
		{
			return 0;
		}

	}


