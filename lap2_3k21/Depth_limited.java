package lap2_3k21;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Depth_limited implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node execute(Node root, String goal, int limit) {
		Stack<Node> frontier = new Stack<Node>();
		frontier.add(root);
		List<Node> explorer = new ArrayList<Node>();
		while(!frontier.isEmpty()) {
			Node current = frontier.pop();
			if(current.getLabel().equals(goal)) {
				return current;
			}else {
				explorer.add(current);
				if(current.getDepth() < limit) {
					List<Node> children = current.getChildrenNodes();
					for (Node node : children) {
						if(!explorer.contains(node) || !frontier.contains(node)) {
							frontier.add(node);
							node.setDepth(current.getDepth() +1);
							node.setParent(current);
						}
							
					}
				}
			}
			
		}
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
		

		Depth_limited depth = new Depth_limited();
		System.out.println(NodeUtils.printPath(depth.execute(nodeS, "G", 2)));
		
	}
	

}
