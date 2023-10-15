package lap2_3k21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearch implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.getPathCost() < o2.getPathCost()?-1: o1.getLabel().compareTo(o2.getLabel());
			}
		});
		frontier.add(root);
		List<Node> explore = new ArrayList<Node>();
		
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) {
				return current;
			}else {
				explore.add(current);
				List<Edge> children = current.getChildren();
				for (Edge child : children) {
					Node end = child.getEnd();
					double newPathCost = current.getPathCost() + child.getWeight();
					if(!frontier.contains(end) || !explore.contains(end)) {
						frontier.add(end);
						System.out.println(frontier + "????????????");
						end.setParent(current);
						end.setPathCost(newPathCost);
					}
					else if (end.getPathCost()>newPathCost) {
						end.setPathCost(newPathCost);
						end.setParent(current);
					}
				}
			}
			}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		boolean started = false;
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {		
				return o1.getPathCost() <o2.getPathCost()?-1: o1.getLabel().compareTo(o2.getLabel());
			}
		});
		frontier.add(root);
		List<Node> exployerd = new ArrayList<Node>();
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(start)) {
				started = true;
				frontier.clear();
				exployerd.clear();
				current.setParent(null);
				current.setPathCost(0);
			}
			if(current.getLabel().equals(goal) && started == true) {
				return current;
			}else {
				exployerd.add(current);
				List<Edge> children = current.getChildren();
				for (Edge child : children) {
					Node end = child.getEnd();
					double newPathCost = current.getPathCost() + child.getWeight();
					if(!frontier.contains(end) || !exployerd.contains(end)) {
						frontier.add(end);
						end.setParent(current);
						end.setPathCost(newPathCost);
					}else if(end.getPathCost()>newPathCost){
						end.setParent(current);
						end.setPathCost(newPathCost);
					}
				}
			}
		}
		return null;
		
	}
	@Override
	public Node execute(Node root, String start, int limit) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A"); Node nodeB = new Node("B");
		Node nodeC = new Node("C"); Node nodeD = new Node("D");
		Node nodeE = new Node("E"); Node nodeF = new Node("F");
		Node nodeG = new Node("G"); Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5); nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4); nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4); nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2); nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6); nodeF.addEdge(nodeG, 1);
//		
		

		UniformCostSearch a = new UniformCostSearch();
//		System.out.println(NodeUtils.printPath(a.execute(nodeS, "G")));
		System.out.println(NodeUtils.printPath(a.execute(nodeS, "S", "G")));
	}

	
}
