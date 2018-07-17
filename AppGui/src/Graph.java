import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Zaheer 216001758
 *
 */
public class Graph <E,T>
{
	
	public static Integer sizeDijkstra;
	private DoublyLinkedList<Vertex <E,T>> vertexList;
	private DoublyLinkedList<Edge<E,T>> edgeList;
	private static ArrayList<String> hospitals = new ArrayList<String>();
	public static Integer vertexSize = 0;
	public static Integer PK = 0;
	private static ArrayList<String> arrTo = new ArrayList<String>();
	private static ArrayList<String> arrFrom = new ArrayList<String>();
	private static ArrayList<String> arrWeight = new ArrayList<String>();

	
	/**
	 * Constructor
	 * @param directed true if the graph is directed, false if undirected
	 */
	public Graph()
	{
		vertexList = new DoublyLinkedList<Vertex<E,T>>();
		edgeList = new DoublyLinkedList<Edge<E,T>>();
	}
	
	
	/**
	 * Add Edge between two vertices
	 * @param vFrom
	 * @param vTo
	 * @param label
	 * @param weight
	 * @return Array of these from and to vertcies
	 */
	public Edge<E,T>[] addEdge(Vertex<E,T> vFrom, Vertex<E,T> vTo, double weight)
	{		
		Edge<E,T> edges[] = new Edge[2];
		
		edges[0] = new Edge<E,T>(vFrom, vTo);
		edges[0].setEdgeWeight(weight);
		edges[0].setPositionNode(edgeList.add(edges[0]));
		edges[1] = new Edge<E,T>(vTo, vFrom);
		edges[1].setEdgeWeight(weight);
		edges[1].setPositionNode(edgeList.add(edges[1]));
		
		return edges;
	}
		
	
	/**
	 * Return iterator for the list of vertices
	 * @return NodeIterator
	 */
	public NodeIterator<Vertex<E,T>> vertices() 
	{
		return vertexList.iterator();
	}

	/**
	 * Return iterator for the list of edges
	 * @return NodeIterator
	 */
	public NodeIterator<Edge<E,T>> edges()
	{
		return edgeList.iterator();
	}
	
	/**
	 * Get arrray of verticies to display
	 * @return Array of vertices
	 */
	public Vertex<E,T>[] getVertexArray()
	{
		Vertex<E,T>[] display = new Vertex[vertexList.size()];
		NodeIterator<Vertex<E,T>> iterator = vertices();
		int index = 0;
		while(iterator.hasNext())
			display[index++] = iterator.next();
		return display;
	}

	/**
	 * Create the shortest path to other vertcies
	 * @param vFrom
	 */
	public void dijkstra(Vertex<E,T> vertex)
	{
		
		// Mark all vertices as unvisited and reset Dijkstra options
		NodeIterator<Vertex<E,T>> vertexIterator = vertices();
		
		while(vertexIterator.hasNext())
		{
			Vertex<E,T> currentV = vertexIterator.next();
			currentV.setStatus(Vertex.UNVISITED);
			currentV.setDijkstraV(Double.MAX_VALUE);
			currentV.setDijkstraP(null);
		}
		
		// Mark all edges as undiscovered
		NodeIterator<Edge<E,T>> edgeIterator = edges();
		
		while(edgeIterator.hasNext())
		{
			edgeIterator.next().setStatus(Edge.UNDISCOVERED);
		}
		
		// Mark the starting vertex
		vertex.setDijkstraV(0);
		
		// Create the Priority Queue (Using a heap)
		PriorityQueue<Vertex<E,T>> pQue = new PriorityQueue<>();
		
		// Start from the starting vertex by putting it in the Priority queue
		pQue.offer(vertex);
		
		vertex.setStatus(Vertex.VISITING);
		vertex.setDijkstraP(vertex);
		
		while(!(pQue.isEmpty()))
		{			
			// Remove the vertex with minimum Dijkstra value
			Vertex<E,T> vertexPoll = pQue.poll();
			vertex.setStatus(Vertex.VISITED);
			NodeIterator<Edge<E,T>> iteratorIncidentEdges = vertexPoll.getOutsideEdges();
			
			// Put all the neighbors of the removed vertex in the Priority queue and adjust their Dijkstra value and parent
			while(iteratorIncidentEdges.hasNext())
			{
				Edge<E,T> edge = iteratorIncidentEdges.next();
				Vertex<E,T> oppositeVertex = edge.getvTo();
				double pathCost = edge.getEdgeWeight() + vertexPoll.getDijkstraV();
				
				// If the neighbor has not been visited, mark it visiting and adjust its configuration
				if(oppositeVertex.getStatus() == Vertex.UNVISITED)
				{
					oppositeVertex.setDijkstraV(pathCost);
					oppositeVertex.setDijkstraE(edge);
					edge.setStatus(Edge.DISCOVERED);
					oppositeVertex.setStatus(Vertex.VISITING);
					oppositeVertex.setDijkstraP(vertexPoll);
					pQue.offer(oppositeVertex);
				
				// If the neighbor is still in the priority queue, check for minimum path cost, adjust if the cost can be reduced
				}else if(oppositeVertex.getStatus() == Vertex.VISITING)
				{					
					if(oppositeVertex.getDijkstraV() > pathCost){
						oppositeVertex.setDijkstraV(pathCost);
						edge.setStatus(Edge.DISCOVERED);
						oppositeVertex.setDijkstraP(vertexPoll);
						oppositeVertex.getDijkstraE().setStatus(Edge.FORWARD); // Mark previous edge as FORWARD
						oppositeVertex.setDijkstraE(edge); // Update edge that makes it shortest path
					}
				}
			}
		}
	}
	
	/**
	 * Get shortest path to specific vertcies
	 * @param vFrom
	 * @param vTo
	 * @return Array of shortest edges to go from vFrom to vTo
	 */
	public Edge<E,T>[] dijkstra(Vertex<E,T> vFrom, Vertex<E,T> vTo)
	{
		this.dijkstra(vFrom);
		
		Stack<Edge<E,T>> stackClosestPath = new Stack<>();
		Vertex<E,T> vertexUsing = vTo;
		
		// Push the path in the stack in backward direction
		while(vertexUsing.getDijkstraE() != null)
		{
			stackClosestPath.push(vertexUsing.getDijkstraE());
			vertexUsing = vertexUsing.getDijkstraP();
		}
		
		// Store path, in the correct direction, in an array
		Edge<E,T>[] edgeUsing = new Edge[stackClosestPath.size()];
		int index =  0;
		while(!stackClosestPath.isEmpty())
		{
			edgeUsing[index++] = stackClosestPath.pop();
			sizeDijkstra++;
		}			
		return edgeUsing;
	}

	
	/**
	 * Get Vetcies / To From and weights
	 * 
	 * @return Graph created
	 * @throws FileNotFoundException
	 */
	public static Graph<String,String> inParser () throws FileNotFoundException
	{
		Integer counter = 0;
		File userFile = new File("data/Hospitals - Copy.txt");
		try
		{
		    Scanner scan = new Scanner(userFile);
		    while(scan.hasNextLine())
		    {
		    	String line = scan.nextLine();
		    	hospitals.add(line);	
		    	counter++;	
		    }
		    scan.close();
		}
		catch(IOException ex)
		{
		    ex.printStackTrace();
		}

        Graph<String,String> graph = new Graph<String,String>();
		
		File userFile2 = new File("data/weights.txt");
		
		try
		{
		    Scanner scan = new Scanner(userFile2);
		    while(scan.hasNextLine())
		    {
		    	String line = scan.nextLine();
		    	String[] segments = line.split("-");
		    	arrTo.add(segments[0]);
		    	arrFrom.add(segments[1]);
		    	arrWeight.add(segments[2]);
		    		    	
		    	
		    }
		    scan.close();
		}
		catch(IOException ex)
		{
		    ex.printStackTrace();
		}
		
		vertexSize = counter;
	
		Vertex<String,String> vertices[] = new Vertex[vertexSize];
		
		
		for (int k = 0; k < vertexSize; k++) 
		{
			vertices[k] = graph.addVertex(hospitals.get(k), PK++);
		}
		
		for (int k = 0; k < vertices.length; k++) 
		{
			double weight = Double.parseDouble(arrWeight.get(k));
			int vFromIndex = Integer.parseInt(arrTo.get(k));
			int vToIndex = Integer.parseInt(arrFrom.get(k));  //Populate parallel arrays and make vertcies and edges
			graph.addEdge(vertices[vFromIndex],vertices[vToIndex],weight);
		}		
		
		return graph;
	}

	/**
	 * Add vertex
	 * @param data
	 * @return Vertex
	 */
	private Vertex<E,T> addVertex(E data, int PK)
	{
		Vertex<E,T> addVertexs = new Vertex<E,T>(data, PK);
		DLLNode<Vertex<E,T>> addNode = vertexList.add(addVertexs);
		addVertexs.setPositionNode(addNode);
		return addVertexs;
	}
}