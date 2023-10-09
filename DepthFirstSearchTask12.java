package lap23.k21;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchTask12 implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		Stack<Node> frontier = new Stack<Node>();
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while(!frontier.isEmpty()) {
			Node current = frontier.pop();
			
			if(current.getLabel().equals(goal)) {
				return current;
			}else {
				List<Node> children = current.getChildrenNodes();
				for (Node node : children) {
					if(!explored.contains(node) && !frontier.contains(node)) {
						
						frontier.push(node);
						node.setParent(current);
					}
				}
					
				
			}}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		boolean started = true;
		Stack<Node> frontier = new Stack<Node>();
		frontier.push(root);
		List<Node>exployred = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node curr = frontier.pop();
			if(curr.getLabel().equals(goal)) {
				started = true;
				frontier.clear();
				exployred.clear();
				curr.setParent(null);
			}
			if(curr.getLabel().equals(goal) && started) {
				return curr;
			}else {
				exployred.add(curr);
				List<Node> children = curr.getChildrenNodes();
				for (Node node : children) {
					if(!frontier.contains(node) && !exployred.contains(node)) {
						frontier.push(node);
						node.setParent(curr);
					}
				}
			}
		} 
		return null;
	}

}
