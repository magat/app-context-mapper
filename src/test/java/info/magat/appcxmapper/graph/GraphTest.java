package info.magat.appcxmapper.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    public void test_create_Graph_and_add_Links(){
        Graph g = new Graph();

        g.addLink("a", "b");
        g.addLink("b", "c");

        assertEquals(2, g.getLinks().size());
        assertEquals(3, g.getNodes().size());

        g.addLink("a", "c");

        assertEquals(3, g.getLinks().size());
        assertEquals(3, g.getNodes().size());

        g.addLink("c", "a");

        assertEquals(4, g.getLinks().size());
        assertEquals(3, g.getNodes().size());
    }

    @Test
    public void test_create_Graph_duplicate_Link_should_not_count(){
        Graph g = new Graph();

        g.addLink("a", "b");
        g.addLink("b", "c");

        assertEquals(2, g.getLinks().size());
        assertEquals(3, g.getNodes().size());

        g.addLink("a", "b");

        assertEquals(2, g.getLinks().size());
        assertEquals(3, g.getNodes().size());
    }

    @Test
    public void test_create_Graph_reverse_Link_should_count(){
        Graph g = new Graph();

        g.addLink("a", "b");
        g.addLink("b", "c");

        assertEquals(2, g.getLinks().size());
        assertEquals(3, g.getNodes().size());

        g.addLink("b", "a");

        assertEquals(3, g.getLinks().size());
        assertEquals(3, g.getNodes().size());
    }

}