package info.magat.appcxmapper.graph;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DrawGraphTest {

    @Test
    public void draw_wip(){
        Graph g = buildGraph();

        // let's try a simple algorithm, where every node is part of a column
        // Columns are numbered
        // 0 1 2 3 .. N
        // roots (nodes with only outgoing links ) are in column 0
        // leaves (nodes with only incoming links ) are in column N
        // other nodes are placed in intermediary columns
        // (in this model the number of columns is not a constraint)
        // nodes that are only reachable from column X are in column X+1
        // nodes that only reach nodes from column X are in column X-1

        // nodes that don't match these are placed with best effort depending on the number of nodes they have links/to from that are in a predetermined column
        // should these nodes be placed depending on the number of adjacent nodes that already have a position ?

        // Problems :
        // - we don't know the number of columns before the end of the column placement
        // - how can we choose the target row of a node ?
        // - we don't try to reduce the number of crossings...

        // find the number of links from a node
        Function<Node, Long> fromCount = n -> g.getLinks().stream().map(Link::getSrc).map(Node::getName).filter(n.getName()::equals).count();
        // find the number of links to a node
        Function<Node, Long> toCount = n -> g.getLinks().stream().map(Link::getDest).map(Node::getName).filter(n.getName()::equals).count();

        Map<String, Node> nodes = g.getNodes();
        Set<DrawableNode> drawableNodes = nodes.values().stream().map(n -> new DrawableNode(n.getName(), fromCount.apply(n), toCount.apply(n))).collect(Collectors.toSet());

        // in this map we will store nodes by column
        // Column 0 is now column 1
        // Column N is now column -1
        // then we can compute N :
        // N = abs(min(column)) + max(column)
        Map<Integer, Collection<Node>> nodesByColumn = new HashMap<>();

        // first place roots
        List<Node> roots = drawableNodes.stream().filter(n -> n.getToCount() == 0L).collect(Collectors.toList());
        nodesByColumn.put(1, roots);

        
    }

    public class DrawableNode extends Node {

        private final Long fromCount;
        private final Long toCount;

        public DrawableNode(String name, Long fromCount, Long toCount) {
            super(name);
            this.fromCount = fromCount;
            this.toCount = toCount;
        }

        public Long getFromCount() {
            return fromCount;
        }

        public Long getToCount() {
            return toCount;
        }
    }

    /*
     A -> B -> C
     */
    private Graph buildGraph() {
        Graph g = new Graph();

        g.addLink("a", "b");
        g.addLink("b", "c");
        return g;
    }
}
