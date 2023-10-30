package Lap4;

public class TestAStar {
	public static void main(String[] args) {
		Node s = new Node("S", 6);
		Node b = new Node("B", 4);
		Node a = new Node("A", 4);
		Node c = new Node("C", 4);
		Node d = new Node("D", 3.5);
		Node e = new Node("E", 1);
		Node f = new Node("F", 1);
		Node g = new Node("G", 0);
		
		s.addEdge(b, 3);
		s.addEdge(a, 2);
		a.addEdge(c, 3);
		b.addEdge(d, 3);
		b.addEdge(c, 1);
		c.addEdge(e, 3);
		c.addEdge(d, 1);
		d.addEdge(f, 2);
		f.addEdge(g, 1);
		e.addEdge(g, 2);
		
		GreedyBestFirstSearchAlgo a1 = new GreedyBestFirstSearchAlgo();
		System.out.println(NodeUtils.printPath(a1.execute(s, "G")));
		
		AStarSearchAlgo a2 = new AStarSearchAlgo();
		System.out.println(NodeUtils.printPath(a2.execute(s, "G")));
		AStarSearchAlgo a3 = new AStarSearchAlgo();
		System.out.println(NodeUtils.printPath(a3.execute(s, "S", "G")));
		
		GreedyBestFirstSearchAlgo a4 = new GreedyBestFirstSearchAlgo();
		System.out.println(NodeUtils.printPath(a4.execute(s, "S", "G")));
		
		
		
		
		IInformedSearchAlgo aStar = new AStarSearchAlgo();
		Node res = aStar.execute(s, "G");
		System.out.println(NodeUtils.printPath(res));
		System.out.println(aStar.isAdmissibleH(res, "G"));
	}
	
}














