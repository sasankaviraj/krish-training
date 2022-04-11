public class Application {

    public static void main(String[] args) {
        Node i = new Node("I");
        Node h =new Node("H",i,null);
        Node g = new Node("G",h,i);
        Node f = new Node("F",g,null);
        Node e = new Node("E",f,
                null);
        Node c = new Node("C",e,f);
        Node b = new Node("B",c, null);
        Node d = new Node("D",c, null);
        Node rootNode = new Node("A",d,b);

        Articulation articulation = new Articulation();
        articulation.traverse(rootNode);
        articulation.setSpanningTree();
        articulation.populateSpanningTree();
        articulation.findArticulationPoints(c,e);
    }
}
