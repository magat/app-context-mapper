package info.magat.appcxmapper.graph;

import org.junit.jupiter.api.Test;

public class DrawGraphTest {

    @Test
    public void draw_wip(){
        Graph g = buildGraph();

    }

    /*

     A -> B -> C

     */
    private Graph buildGraph() {
        Graph g = new Graph();

        g.addLink("a", "b");
        g.addLink("b", "c");
        g.addLink("d", "b");
        return g;
    }
}
