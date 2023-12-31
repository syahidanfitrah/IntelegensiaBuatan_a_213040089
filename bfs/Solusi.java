package id.bfs;
import id.Node;

import java.util.List;
import java.util.ArrayList;

public class Solusi {
    private List<Node> nodes;
    private Node node;

    public Solusi() {
        nodes = new ArrayList<>();
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Node getNode() {
        return node;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = new ArrayList<>(nodes);
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
