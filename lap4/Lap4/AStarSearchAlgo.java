package Lap4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class AStarSearchAlgo implements IInformedSearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> fronder = new PriorityQueue<Node>(new NodeComparatorByGn());
		fronder.add(root);
		ArrayList<Node> explore = new ArrayList<Node>();
		while(!fronder.isEmpty()) {
			Node curr = fronder.poll();
			if(curr.getLabel().equals(goal)) {
				return curr;
			}else {
				explore.add(curr);
				List<Edge> child = curr.getChildren();
				for (Edge edge : child) {
					Node end = edge.getEnd();
					double newCost = curr.getG() + edge.getWeight();
					if(!fronder.contains(end) && !explore.contains(end)){
						end.setParent(curr);
						end.setG(newCost);
						fronder.add(end);

					}else if(fronder.contains(end) && newCost < end.getG()) {
						fronder.remove(end);
						end.setG(newCost);
						end.setParent(curr);
						fronder.add(end);
					}
				}
				
			}
		}
		return null;
	}
	
	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> fronder = new PriorityQueue<Node>(new NodeComparatorByGn());
		List<Node> explorer = new ArrayList<Node>();
		boolean started = false;
		fronder.add(root);
		while(!fronder.isEmpty()) {
			Node curr = fronder.poll();
			if(curr.getLabel().equals(start)) {
				fronder.clear();
				explorer.clear();
				curr.setParent(null);
				curr.setG(0);
				started = true;
			}
			if(curr.getLabel().equals(goal) && started == true) {
				return curr;
			}else {
				explorer.add(curr);
				List<Edge> children = curr.getChildren();
				for (Edge edge : children) {
					Node child = edge.getEnd();
					double newCost = curr.getG() + edge.getWeight();
					if(!fronder.contains(child) && !explorer.contains(child)) {
						child.setParent(curr);
						child.setG(newCost);
						fronder.add(child);
					}else if(fronder.contains(child) && newCost < child.getG()) {
						fronder.remove(child);
						child.setG(newCost);
						child.setParent(curr);
						fronder.add(child);
					}
				}
			}
		}
		
		return null;
	}
	class NodeComparatorByGn implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
		Double h1 = o1.getG() +o1.getH();
		Double h2 = o2.getG() + o2.getH();
		int result = h1.compareTo(h2);
		if (result == 0)
		return o1.getLabel().compareTo(o2.getLabel());
		else
		return result;
		}
		}


	@Override
	public boolean isAdmissibleH(Node root, String goal) {
		List<Node> explored = new ArrayList<Node>();
		Stack<Node> frontier = new Stack<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (!current.getLabel().equals(goal)) {
				explored.add(current);
				Node g = execute(current, goal);
				// nếu như g k null và H tại g > pathcost của g thì k admissible
				if (g != null && current.getH() > g.getG()) {
					System.out.println(current.getLabel() + ", H: " + current.getH() + ", G: " + g.getG());
					return false;
				}
			// mo rong cac node con khac
				List<Edge> children = current.getChildren();
				for (int i = 0; i < children.size(); i++) {
					Node child = children.get(i).getEnd();
					if (!frontier.contains(child) && !explored.contains(child)) {
						frontier.add(child);
						child.setG(0);
					}
				}

			}

		}
		return true;
	}
	

}
