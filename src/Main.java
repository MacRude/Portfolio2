//Made by Hennis and Mennis

public class Main {

    public static void main(String[] args) {
        // write your code here

        AdjacencyGraph thisGraph = new AdjacencyGraph();
        Vertex A = new Vertex("Eskildstrup");
        Vertex B = new Vertex("Maribo");
        Vertex C = new Vertex("Nykøbing F");
        Vertex D = new Vertex("Vordingborg");
        Vertex E = new Vertex("Haslev");
        Vertex F = new Vertex("Køge");
        Vertex G = new Vertex("Næstved");
        Vertex H = new Vertex("Ringsted");
        Vertex I = new Vertex("Roskilde");
        Vertex J = new Vertex("Slagelse");
        Vertex K = new Vertex("Sorø");
        Vertex L = new Vertex("Jægerspris");
        Vertex M = new Vertex("Kalundborg");
        Vertex N = new Vertex("Holbæk");
        Vertex O = new Vertex("Korsør");
        Vertex P = new Vertex("Nakskov");
        thisGraph.addVertex(A);
        thisGraph.addVertex(B);
        thisGraph.addVertex(C);
        thisGraph.addVertex(D);
        thisGraph.addVertex(E);
        thisGraph.addVertex(F);
        thisGraph.addVertex(G);
        thisGraph.addVertex(H);
        thisGraph.addVertex(I);
        thisGraph.addVertex(J);
        thisGraph.addVertex(K);
        thisGraph.addVertex(L);
        thisGraph.addVertex(M);
        thisGraph.addVertex(N);
        thisGraph.addVertex(O);
        thisGraph.addVertex(P);
        thisGraph.newEdge(A,B,28);
        thisGraph.newEdge(A,C,13);
        thisGraph.newEdge(A,D,24);
        thisGraph.newEdge(E,O,60);
        thisGraph.newEdge(E,F,24);
        thisGraph.newEdge(E,G,25);
        thisGraph.newEdge(E,H,19);
        thisGraph.newEdge(E,I,47);
        thisGraph.newEdge(E,J,48);
        thisGraph.newEdge(E,K,34);
        thisGraph.newEdge(E,D,40);
        thisGraph.newEdge(N,L,34);
        thisGraph.newEdge(N,M,44);
        thisGraph.newEdge(N,O,66);
        thisGraph.newEdge(N,H,36);
        thisGraph.newEdge(N,I,32);
        thisGraph.newEdge(N,J,46);
        thisGraph.newEdge(N,K,34);
        thisGraph.newEdge(L,O,95);
        thisGraph.newEdge(L,F,58);
        thisGraph.newEdge(L,H,56);
        thisGraph.newEdge(L,I,33);
        thisGraph.newEdge(L,J,74);
        thisGraph.newEdge(L,K,63);
        thisGraph.newEdge(M,H,62);
        thisGraph.newEdge(M,I,70);
        thisGraph.newEdge(M,J,39);
        thisGraph.newEdge(M,K,51);
        thisGraph.newEdge(O,G,45);
        thisGraph.newEdge(O,J,20);
        thisGraph.newEdge(F,G,45);
        thisGraph.newEdge(F,H,28);
        thisGraph.newEdge(F,I,25);
        thisGraph.newEdge(F,D,60);
        thisGraph.newEdge(B,P,27);
        thisGraph.newEdge(B,C,26);
        thisGraph.newEdge(G,I,57);
        thisGraph.newEdge(G,H,26);
        thisGraph.newEdge(G,J,37);
        thisGraph.newEdge(G,K,32);
        thisGraph.newEdge(G,D,28);
        thisGraph.newEdge(H,I,31);
        thisGraph.newEdge(H,K,15);
        thisGraph.newEdge(H,D,58);
        thisGraph.newEdge(J,K,14);
        //thisGraph.printGraph();
        thisGraph.printMST();
        thisGraph.MSTPrims();

    }
}
