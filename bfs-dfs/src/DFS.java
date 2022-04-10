import java.util.*;

public class DFS {

    private int graph[][] = {{1},{2,4},{3,6,8},{5,7,9},{2,8},{3}};

    void dfsExecute(int rootNode){
        ArrayList<Integer> visitedList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i : graph[rootNode]) {
            stack.add(i);
            visitedList.add(i);
        }

        while(!stack.isEmpty()){
            for (int i = 0; i < graph.length; i++) {
                if(stack.isEmpty()){
                    break;
                }
                stack.pop();
                for (int j : graph[i]) {
                    if (!visitedList.contains(j)) {
                        stack.add(j);
                        visitedList.add(j);
                    }
                }
            }
        }

        visitedList.forEach((v)->{
            System.out.println(v+" is visited");
        });
    }
}
