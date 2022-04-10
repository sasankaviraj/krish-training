import java.util.*;

public class DFS {
    LinkedList<Node> visitedList = new LinkedList<>();
    Stack<Node> stack = new Stack<>();

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

    void print(){
        visitedList.forEach(node -> {
            System.out.println(node.value+" is visited");
        });
    }


}
