import java.util.*;

public class BFS {

    private int graph[][] = {{1},{2,4},{3,6,8},{5,7,9},{2,8},{3}};

    void bfsExecute(int rootNode){
        ArrayList<Integer> visitedList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i : graph[rootNode]) {
            queue.add(i);
            visitedList.add(i);
        }

        while(!queue.isEmpty()){
            for (int i = 0; i < graph.length; i++) {
                for (int j : graph[i]) {
                    if (!visitedList.contains(j)) {
                        queue.add(j);
                        visitedList.add(j);
                    }
                    queue.poll();
                }
            }
        }

        visitedList.forEach((v)->{
            System.out.println(v+" is visited");
        });
    }
}
