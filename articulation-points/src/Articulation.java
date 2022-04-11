import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Articulation {

    LinkedList<Node> visitedList = new LinkedList<>();
    Stack<Node> stack = new Stack<>();
    LinkedHashMap<Integer,Node> spanningTree = new LinkedHashMap<>();
    LinkedHashMap<Node,Integer> lowestPoints = new LinkedHashMap<>();

    void traverse(Node rootNode) {
        stack.add(rootNode);
        if(!visitedList.contains(rootNode)){
            visitedList.add(rootNode);
        }
        while(!stack.isEmpty()){
            if(rootNode.left!=null){
                if(!visitedList.contains(rootNode.left)){
                    visitedList.add(rootNode.left);
                    traverse(rootNode.left);
                }
            }
            if(rootNode.right!=null){
                if(!visitedList.contains(rootNode.right)){
                    visitedList.add(rootNode.right);
                    traverse(rootNode.right);
                }
                else {
                    if(!stack.isEmpty()){
                        stack.pop();
                        if(!stack.isEmpty()){
                            rootNode = stack.peek();
                        }
                    }
                }
            }
            else {
                if(!stack.isEmpty()){
                    stack.pop();
                    if(!stack.isEmpty()){
                        rootNode = stack.peek();
                    }
                }
            }
        }
    }

    void setSpanningTree(){
        visitedList.forEach(node -> {
            if(!spanningTree.containsValue(node)){
                spanningTree.put(visitedList.indexOf(node)+1,node);
            }
        });
    };

    void populateSpanningTree(){
        spanningTree.forEach((key,value)->{
            findLowestPoints(value);
            System.out.println(key+" : "+value.value);
        });
    }

    void findLowestPoints(Node node){
        List<Integer> points = new ArrayList<>();
        AtomicReference<Integer> nodeKey = new AtomicReference<>();
        AtomicReference<Integer> countLeft = new AtomicReference<>(0);
        AtomicReference<Integer> countRight = new AtomicReference<>(0);
        spanningTree.forEach((key,value)->{
            if(value.left == node){
                points.add(key);
                countLeft.getAndSet(countLeft.get() + 1);
            }
            if(value.right == node){
                points.add(key);
                countRight.getAndSet(countRight.get() + 1);
            }
            if(value.equals(node)){
                nodeKey.set(key);
            }
        });

        if(!(countLeft.get() > 1 || countRight.get() > 1)){
            if(spanningTree.get(nodeKey.get()).right!=null){
                points.clear();
                points.add(nodeKey.get());
            }
        }

        if(!points.isEmpty()){
            spanningTree.forEach((key,value)->{
                if(value.right == spanningTree.get(points.get(points.size()-1))){
                    points.add(key);
                }
            });
            Collections.sort(points);
            lowestPoints.put(node,points.get(0));
        }
    }

    void print(){
        lowestPoints.forEach((key,value)->{
            System.out.println("key: "+key.value+" value: "+value);
        });
    }

    void findArticulationPoints(Node parent,Node child){
        AtomicReference<Integer> depthIndex = new AtomicReference<>();
        spanningTree.forEach((key,value)->{
            if(value.equals(parent)){
                depthIndex.set(key);
            }
        });

        if(lowestPoints.get(child) >= depthIndex.get()){
            System.out.println(parent.value+" is an articulation point");
        }
        else {
            System.out.println(parent.value+" is not an articulation point");
        }
    }


}
