package lap23.k21;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DFSTask3 implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		Stack<Node> fronier = new Stack<Node>();
		fronier.add(root);
		while(!fronier.isEmpty()) {
			Node curr = fronier.pop();
			if(curr.getLabel().equals(goal)) {
				return curr;
			}
			for (Node node : curr.getChildrenNodes()) {
				fronier.add(node);
				node.setParent(curr);
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		boolean started = false;
		Stack<Node> fronier = new Stack<Node>();
		fronier.add(root);
		while(!fronier.isEmpty()) {
			Node curr = fronier.pop();
			if(curr.getLabel().equals(goal)) {
				started = true;
				fronier.clear();
				curr.setParent(null);
			}
			if(curr.getLabel().equals(goal)) {
				return curr;
			}else {
				List<Node> children = curr.getChildrenNodes();
				for (Node node : children) {
					if(!fronier.contains(node)) {
						fronier.add(node);
						node.setParent(curr);
					}
				}
			}
		}
		return null;
	}

}
