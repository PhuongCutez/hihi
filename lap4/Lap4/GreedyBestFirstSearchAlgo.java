package Lap4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {
	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> fronder = new PriorityQueue<Node>(new NodeComparatorByHn());
		
		fronder.add(root);
		ArrayList<Node> explore = new ArrayList<Node>();
		while(!fronder.isEmpty()) {
			Node curr = fronder.poll();
			explore.add(curr);
			if(curr.getLabel().equals(goal)) {
				return curr;
			}else {
				List<Node> child = curr.getChildrenNodes();
				for (Node node : child) {
					if(!fronder.contains(node) || !explore.contains(node)) {
						fronder.add(node);
						node.setParent(curr);
						
					}
				}
				
			}
		}
		return null;
	}
	
	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> fronder = new PriorityQueue<Node>(new NodeComparatorByHn());
		fronder.add(root);
		boolean started = false;
		List<Node> explore = new ArrayList<Node>();
		while(!fronder.isEmpty()) {
			Node curr = fronder.poll();
			if(curr.getLabel().equals(start)) {
				fronder.clear();
				explore.clear();
				curr.setParent(null);
				started = true;
			}
			if(curr.getLabel().equals(goal) && started == true) {
				return curr;
			}else {
				explore.add(curr);
				List<Node> children = curr.getChildrenNodes();
				for (Node node : children) {
					if(!fronder.contains(node) && !explore.contains(node)) {
						node.setParent(curr);
						fronder.add(node);
					}
				}
			}
		}
		return null;
	}
	class NodeComparatorByHn implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
		Double h1 = o1.getH();
		Double h2 = o2.getH();
		int result = h1.compareTo(h2);
		if (result == 0)
		return o1.getLabel().compareTo(o2.getLabel());
		else
		return result;
		}
		}



	@Override
	public boolean isAdmissibleH(Node root, String goal) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
