package lap23.k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchTask12 implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) {
				return current;
			}else {
				explored.add(current);

				List<Node> children = current.getChildrenNodes();
				for (Node node : children) {
					if(!explored.contains(node) && !frontier.contains(node)) {
						frontier.add(node);
						node.setParent(current);
					}
					
				}
			}
		}
		return null ;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		boolean started = false;
		Queue<Node> frontier = new LinkedList<>();
		frontier.add(root);
		List<Node> exployred = new ArrayList<Node>();
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(start)) {
				started = true;
				frontier.clear();
				exployred.clear();
				current.setParent(null);
			}
			if(current.getLabel().equals(goal) && started) {
				return current;
			}else {
				exployred.add(current);
				List<Node> children = current.getChildrenNodes();
				for (Node node : children) {
					if(!frontier.contains(node) && !exployred.contains(node)) {
						frontier.add(node);
						node.setParent(current);
					}
				}
			}
		}
		
		return null;
	}

}
