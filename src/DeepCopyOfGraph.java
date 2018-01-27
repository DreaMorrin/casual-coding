/*
 * write a method to deep copy a graph
 */

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class DeepCopyOfGraph {
	
	static class Node {
		int value;
		List<Node> neighbors;
		
		Node(int value) {
			this.value = value;
			neighbors = new ArrayList<Node>();
		}
	}
	
	static class Graph {
		List<Node> nodes;
		
		Graph() {
			nodes = new ArrayList<Node>();
		}
	}	
	
	static Node createNode(Node oldNode, Hashtable<Node, Node> oldNodeMapsNewNodeTable) {
		Node potentialNewNode = oldNodeMapsNewNodeTable.get(oldNode); 
		if (potentialNewNode != null) {
			return potentialNewNode;
		}
		else {
			Node newNode = new Node(oldNode.value);
			oldNodeMapsNewNodeTable.put(oldNode, newNode);
			
			for (Node neighbor : oldNode.neighbors) {
				newNode.neighbors.add(createNode(neighbor, oldNodeMapsNewNodeTable));
			}
			
			return newNode;
		}
	}
	
	static Graph deepCopy(Graph graph) {
		Graph newGraph = new Graph();
		
		Hashtable<Node, Node> oldNodeMapsNewNodeTable = new Hashtable<Node, Node>();
		
		for (Node node : graph.nodes) {
			newGraph.nodes.add(createNode(node, oldNodeMapsNewNodeTable));
		}
		
		return newGraph;
	}
	

	public static void main(String[] args) {
		
		Graph newGraph = deepCopy(createTestGraph());
		printGraph(newGraph);
	}

	/*
	 * A --> C
	 * |     ^
	 * v     |
	 * B --> D
	 */
	static Graph createTestGraph() {
		
		Node A = new Node(1);
		Node B = new Node(2);
		Node C = new Node(3);
		Node D = new Node(4);
		
		A.neighbors.add(B);
		A.neighbors.add(C);
		B.neighbors.add(D);
		D.neighbors.add(C);
	
		Graph graph = new Graph();
		graph.nodes.add(A);
		graph.nodes.add(B);
		graph.nodes.add(C);
		graph.nodes.add(D);
		
		return graph; 
	}
	
	static void printGraph(Graph graph) {
		for (Node node : graph.nodes) {
			System.out.print("Node " + node.value + " has neighbors: ");
			for (Node neighbor : node.neighbors) {
				System.out.print(neighbor.value + " ");
			}
			System.out.println();
		}
	}
}
