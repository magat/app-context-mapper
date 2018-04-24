package info.magat.appcxmapper.graph;

import java.util.Objects;

public class Link {

    private final Node src;
    private final Node dest;

    public Link(Node src, Node dest) {
        this.src = src;
        this.dest = dest;
    }

    public Node getSrc() {
        return src;
    }

    public Node getDest() {
        return dest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(src, link.src) &&
                Objects.equals(dest, link.dest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(src, dest);
    }
}
