import java.util.ArrayList;
import java.util.PriorityQueue;
//Lave an arraylist der består af Vertex, som har kanter til og fra disse vertex'
public class AdjacencyGraph {

    private ArrayList<Vertex> vertices;


    public AdjacencyGraph() {
        vertices = new ArrayList<Vertex>();
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
    }


    public void newEdge(Vertex from, Vertex to, Integer dist) {
        if (!(vertices.contains(from) && vertices.contains(to))) {
            System.out.println(" Vertex not found. ");
            return;
        }
        Edge newEdge = new Edge(from, to, dist);
        Edge newEdge2 = new Edge(to, from, dist);
    }

    public void printGraph() {
        Vertex currentv;
        for (int i = 0; i < vertices.size(); i++) {
            currentv = vertices.get(i);
            System.out.println(" Edges from Vertex: " + currentv.getName());
            for (int j = 0; j < currentv.getOutEdges().size(); j++) {
                Edge currentEdge = currentv.getOutEdges().get(j);
                System.out.println(" To " + currentv.getOutEdges().get(j).getToVertex().getName() + " distance: " + currentEdge.getWeight());

            }
            System.out.println(" ");
        }
    }
//Sætter start distances lig med 0, og adderer distancen fra get(i) til predecessor
    //MST er kun de distancer som bliver hevet ud af Q
    public void MSTPrims() {

        PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();

        if (vertices.size() > 0) {
            vertices.get(0).distance = 0;
            Q.offer(vertices.get(0));
        }

        //MST bliver lavet når den hiver en vertex ud, da den kun hiver den ud med den korteste distance, PQ er bare en liste
        //MST bliver "lavet" via predecessor og distance, distance er kun den distance i vores MST, dvs. de elementer der bliver hevet ud

        int counter = 0;
        int MST = 0;


        while (!Q.isEmpty() && counter < vertices.size()) {
            Vertex u = Q.poll();
            if (!u.visited) {
                for (int i = 0; i < u.getOutEdges().size(); i++) {
                    if ((!u.getOutEdges().get(i).getToVertex().visited) && u.getOutEdges().get(i).getWeight() <
                            u.getOutEdges().get(i).getToVertex().distance) {
                        u.getOutEdges().get(i).getToVertex().distance = u.getOutEdges().get(i).getWeight();
                        u.getOutEdges().get(i).getToVertex().predecessor = u;
                        Q.offer(u.getOutEdges().get(i).getToVertex());
                    }
                }

                u.visited = true;
                counter++;  //Counter bliver lavet for at stoppe vores while loop, da Q har flere af de samme elementer
                MST += u.distance; //Kun distance mellem de vertices vi har hevet ud

            }
        }
        int finalPrice = MST * 100000;
        System.out.println("Weight of the MST is: " + MST + "km \n" +
                "The final price of the grid is: " + finalPrice + "kr \n" );

    }
    public void printMST() {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).predecessor != null) {
                System.out.println(vertices.get(i).predecessor.getName() + " to " + vertices.get(i).getName() + " Edge Weight: " + vertices.get(i).distance + "km");
            }
        }
    }
}
class Vertex implements Comparable<Vertex>{
    private String name;
    private ArrayList<Edge> outEdges;
    Integer distance = Integer.MAX_VALUE;
    Vertex predecessor = null;
    Boolean visited = false;

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Edge> getOutEdges() {
        return outEdges;
    }

    public void setOutEdges(ArrayList<Edge> outEdges) {
        this.outEdges = outEdges;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Vertex(String ID){
        this.name=ID;
        outEdges = new ArrayList<>();
    }
    public void addOutEdge(Edge outEdge){
        outEdges.add(outEdge);
    }
    @Override
    public int compareTo(Vertex o) {
        if (this.distance<o.distance){
            return -1;
        }
        if(this.distance>o.distance){
            return 1;
        }

        return 0;
    }
}
class Edge{
    private Vertex fromVertex;
    private Vertex toVertex;
    private Integer weight;

    public Vertex getFromVertex() {
        return fromVertex;
    }

    public void setFromVertex(Vertex fromVertex) {
        this.fromVertex = fromVertex;
    }

    public Vertex getToVertex() {
        return toVertex;
    }

    public void setToVertex(Vertex toVertex) {
        this.toVertex = toVertex;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Edge(Vertex from, Vertex to, Integer cost){
        fromVertex = from;
        toVertex = to;
        weight = cost;
        from.addOutEdge(this);
    }

}
class Pair implements Comparable<Pair>{
    Integer distance;
    Integer index;

    public Pair(Integer distance, Integer index){
        this.distance=distance;
        this.index = index;
    }

    @Override
    public int compareTo(Pair o){
        return this.distance.compareTo(o.distance);
    }
}