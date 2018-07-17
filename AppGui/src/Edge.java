/**
 * 
 * @author Zaheer 216001758
 *
 * 
 */
	public class Edge <E,T> 
	{
		private Vertex<E,T> vFrom;
		private Vertex<E,T> vTo;
		private double edgeWeight;
		private DLLNode<Edge<E,T>> positionNode;
		private int status;
		
		public static final int UNDISCOVERED = 0;
		public static final int DISCOVERED = 1;
		public static final int BACK = 2;
		public static final int FORWARD = 3;
		
		/**
		 * Constructor for an Edge
		 * @param vFrom From which vertex is this edge 
		 * @param vTo To which vertex is this edge 
		 */
		public Edge(Vertex<E,T> vFrom, Vertex<E,T> vTo)
		{
			this.vFrom = vFrom;
			this.vTo = vTo;
			this.vFrom.addOutEdge(this);
			this.vTo.addInEdge(this);
		}		

		/**
		 * Acessor for vTO vertex
		 * @return vTo
		 */
		public Vertex<E,T> getvTo() 
		{
			return vTo;
		}
		
		/**
		 * Acessor for vFrom vertex
		 * @return vTo
		 */
		public Vertex<E,T> getvFrom()
		{
			return vFrom;
		}

		/**
		 * Acessor for edgeWeight
		 * @return edgeWeight
		 */
		public double getEdgeWeight() 
		{
			return edgeWeight;
		}

		/**
		 * Mutaotr for edgeWeight
		 * @param edgeWeight
		 */
		public void setEdgeWeight(double edgeWeight) 
		{
			this.edgeWeight = edgeWeight;
		}
		
		/**
		 * Acessor for positon of edge
		 * @return positionNode
		 */
		public DLLNode<Edge<E,T>> getPositionNode() 
		{
			return positionNode;
		}

		/**
		 * Mutator for positon of edge
		 * @param positionNode
		 */
		public void setPositionNode(DLLNode<Edge<E,T>> positionNode)
		{
			this.positionNode = positionNode;
		}

		/**
		 * Acessor for status edge
		 * @return edge status
		 */
		public int getStatus() 
		{
			return status;
		}		
		
		/**
		 * Mutator for status
		 * @param status Edge status
		 */
		public void setStatus(int status)
		{
			this.status = status;
		}
	}


