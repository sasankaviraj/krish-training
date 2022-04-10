public class Application {

    public static void main(String[] args) {

        Node rootNodeBfs = new Node("A",new Node("C",new Node("G"),new Node("E",new Node("F"),
                null)),new Node("B",new Node("D"),null));

        Node rootNodeDfs = new Node("0",new Node("3",new Node("7",new Node("4"),null),
                new Node("5",new Node("6",new Node("2",new Node("1"),null),null),null)),null);

        System.out.println("-----------BFS------------");
        BFS bfs = new BFS();
        long startBfs = System.currentTimeMillis();
        bfs.traverse(rootNodeBfs);
        long endBfs = System.currentTimeMillis();
        System.out.println("Time gap for bfs: "+(endBfs-startBfs));

        System.out.println("-----------DFS------------");
        DFS dfs = new DFS();
        long startDfs = System.currentTimeMillis();
        dfs.traverse(rootNodeDfs);
        dfs.print();
        long endDfs = System.currentTimeMillis();
        System.out.println("Time gap for dfs: "+(endDfs-startDfs));
    }
}
