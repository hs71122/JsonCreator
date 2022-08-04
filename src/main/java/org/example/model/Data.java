package org.example.model;

import java.util.List;
import java.util.Set;

public class Data {
    private Set<Node> nodes;
    private List<Link> links;

    public Data() {
    }

    public Data(Set<Node> nodes, List<Link> links) {
        this.nodes = nodes;
        this.links = links;
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
