package lap23.k21;

public class Test {
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
//		ISearchAlgo algo1 = new BreadthFirstSearchTask12();
//		NodeUtils n1 = new NodeUtils();
//		Node result = algo1.execute(nodeS, "G");
//		System.out.println(n1.printPath(result)); // BFS 
//		Node re = algo1.execute(nodeS, "A", "G"); // BFS
//		System.out.println(n1.printPath(re));
//		
//		ISearchAlgo algo2 = new DepthFirstSearchTask12();
//		NodeUtils n2 = new NodeUtils();
//		Node r1 = algo2.execute(nodeS, "G");
//		System.out.println(n2.printPath(r1));
//		
//		Node r2 = algo2.execute(nodeS, "A", "H");
//		System.out.println(n2.printPath(r2));
		
		ISearchAlgo algo3 = new BFSTask3();
		NodeUtils n3 = new NodeUtils();
		Node r3 = algo3.execute(nodeS, "G");
		System.out.println(n3.printPath(r3)); // BFS ok
		Node r4 = algo3.execute(nodeS, "S", "E");
		System.out.println(n3.printPath(r4));
		
		
		ISearchAlgo algo4 = new DFSTask3();
		NodeUtils n4 = new NodeUtils();
		Node r5 = algo4.execute(nodeS, "G");
		System.out.println(n4.printPath(r5));
		Node r6 = algo4.execute(nodeS, "S", "G");
		
		
	}

}
