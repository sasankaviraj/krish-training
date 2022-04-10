import java.util.*;

public class BFS {

    void traverse(Node rootNode){
        ArrayList<Node> visitedList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);
        while(queue.iterator().hasNext()){
            if(queue.iterator().next().right!=null){
                queue.add(queue.iterator().next().right);
            }
            if(queue.iterator().next().left!=null){
                queue.add(queue.iterator().next().left);
            }
            Node poll = queue.poll();
            visitedList.add(poll);
        }

        visitedList.forEach((v)->{
            System.out.println(v.value + " is visited");
        });
    }









//    private int graph[][] = {{1},{2,4},{3,6,8},{5,7,9},{2,8},{3}};
//
//    void bfsExecute(int rootNode){
//        ArrayList<Integer> visitedList = new ArrayList<>();
//        Queue<Integer> queue = new LinkedList<>();
//
//        for (int i : graph[rootNode]) {
//            queue.add(i);
//            visitedList.add(i);
//        }
//
//        while(!queue.isEmpty()){
//            for (int i = 0; i < graph.length; i++) {
//                for (int j : graph[i]) {
//                    if (!visitedList.contains(j)) {
//                        queue.add(j);
//                        visitedList.add(j);
//                    }
//                    queue.poll();
//                }
//            }
//        }
//
//        visitedList.forEach((v)->{
//            System.out.println(v+" is visited");
//        });
//    }


}
