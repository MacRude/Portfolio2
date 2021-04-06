import java.util.ArrayList;
import java.util.PriorityQueue;

public class AdjacencyGraph {
    private ArrayList<Vertex> vertices;

    public AdjacencyGraph(){
        vertices = new ArrayList<Vertex>();
    }
    public void addVertex(Vertex v){
        vertices.add(v);
    }
    public void newEdge(Vertex from, Vertex to, Integer dist){
        if ( ! (vertices.contains(from) && vertices.contains(to))){
            System.out.println(" Vertex not found. ");
            return;
        }
        Edge newEdge = new Edge(from, to, dist);
    }
    public void printGraph(){
        Vertex currentv;
        for (int i = 0; i < vertices.size(); i++){
            currentv = vertices.get(i);
            System.out.println(" Edges from Vertex: " + currentv.getName());
            for (int j = 0; j < currentv.getOutEdges().size();j++){
                Edge currentEdge = currentv.getOutEdges().get(j);
                System.out.println(" To " + currentv.getOutEdges().get(j).getToVertex().getName() + " weight: " + currentEdge.getWeight());

            }
            System.out.println(" ");
        }
    }
    /*
    public void MSTPrims(){
        int[] Distance =new int[matrixegdegraph.length];
        int[] predecessor = new int[matrixegdegraph.length];
        boolean[] visited =  new boolean[matrixegdegraph.length];
        MinHeap<Pair> Q =new MinHeap<>();
        PriorityQueue<Pair> PQ = new PriorityQueue<>(); // offer (add) poll (extactmin)

        ArrayList<Pair> VertexPairs=new ArrayList<>();
        Arrays.fill(Distance, Integer.MAX_VALUE);
        Arrays.fill(predecessor,-1);
        Arrays.fill(visited,false);
        if (matrixegdegraph.length>0)
            Distance[0]=0;
        for(int i=0;i<matrixegdegraph.length;i++) {
            VertexPairs.add(new Pair(Distance[i], i));
            Q.Insert(VertexPairs.get(i));
        }
        int MST=0;
        while(!Q.isEmpty()){
            Pair u=Q.extractMin();
            for(int v=0;v<matrixegdegraph.length;v++){
                if(matrixegdegraph[u.index][v]==1 && matrixweightgraph[u.index][v]<Distance[v])
                {
                    if(!visited[v]) {
                        Distance[v] = matrixweightgraph[u.index][v];
                        predecessor[v] = u.index;
                        int pos = Q.getPosition(VertexPairs.get(v));
                        VertexPairs.get(v).distance = matrixweightgraph[u.index][v];
                        Q.decreasekey(pos);
                    }
                }
            }
            MST+=Distance[u.index];
        }
        System.out.println("Minimum spanning tree Dsitance: " +MST);
        for(int i=0; i< matrixegdegraph.length;i++)
        {
            System.out.println(" parent "+ predecessor[i] + " to " + i + " EdgeWeight: " + Distance[i]);
        }
    }
     */

}


class Vertex implements Comparable<Vertex>{
    private String name;
    private ArrayList<Edge> outEdges;
    Integer distance = Integer.MAX_VALUE;

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