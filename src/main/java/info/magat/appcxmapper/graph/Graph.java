package info.magat.appcxmapper.graph;

import java.util.*;

public class Graph {

    private final Set<Link> links;
    private final Map<String, Node> nodes;

    public Graph() {
        links = new HashSet<>();
        nodes = new HashMap<>();
    }

    public void addLink(String src, String dest){
        Node s = nodes.computeIfAbsent(src, Node::new);
        Node d = nodes.computeIfAbsent(dest, Node::new);
        links.add(new Link(s, d));
    }

    public Collection<Link> getLinks() {
        return links;
    }

    public Map<String, Node> getNodes() {
        return nodes;
    }
}
