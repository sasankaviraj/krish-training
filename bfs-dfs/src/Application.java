public class Application {

    public static void main(String[] args) {
        System.out.println("-----------BFS------------");
        BFS bfs = new BFS();
        long startBfs = System.currentTimeMillis();
        bfs.bfsExecute(2);
        long endBfs = System.currentTimeMillis();
        System.out.println("Time gap for bfs: "+(endBfs-startBfs));

        System.out.println("-----------DFS------------");
        DFS dfs = new DFS();
        long startDfs = System.currentTimeMillis();
        dfs.dfsExecute(2);
        long endDfs = System.currentTimeMillis();
        System.out.println("Time gap for dfs: "+(endDfs-startDfs));
    }
}
