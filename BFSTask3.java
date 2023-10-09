package lap23.k21;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class BFSTask3 implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new LinkedBlockingDeque<Node>();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node curr = frontier.poll();
			if(curr.getLabel().equals(goal)) {
				return curr;
			}
			for (Node node : curr.getChildrenNodes()) {
				frontier.add(node);
				node.setParent(curr);
			}
			
			}
		
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		boolean started = false;
		Queue<Node> fronier = new LinkedList<Node>();
		fronier.add(root);
		while(!fronier.isEmpty()) {
			Node curr = fronier.poll();
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
