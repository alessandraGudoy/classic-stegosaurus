package edu.ics211.h13;

/* This is an abstraction of an object in a language such as Java.
 * Each such object has 0 or more links to other objects.
 * When reclaiming storage, all objects reachable from the root
 * must be marked as being in use.
 * At the end of the graph traversal, any object that is not
 * marked as being in use may be reclaimed.
 */

public class GraphNode {
    private String id;
    private GraphNode[] links; // the number of links never changes
    private boolean inUse;

    public GraphNode(String id, java.util.Set<GraphNode> linkedObjects) {
        this.id = id;
        inUse = false;
        links = new GraphNode[linkedObjects.size()];
        int index = 0;
        for (GraphNode so : linkedObjects) {
            links[index++] = so;
        }
    }

    // links are created, but must be initialized by calling setLink
    public GraphNode(String id, int numLinks) {
        this.id = id;
        inUse = false;
        links = new GraphNode[numLinks];
        for (int index = 0; index < numLinks; index++) {
            links[index] = this; // link to self
        }
    }

    // accessor and mutator methods
    public int numLinks() {
        return links.length;
    }

    public GraphNode getLink(int i) {
        return links[i]; // throws an exception if i is not a valid index
    }

    public void setLink(int i, GraphNode o) {
        links[i] = o; // throws an exception if i is not a valid index
    }

    public boolean isInUse() {
        return inUse;
    }

    public void markInUse() {
        inUse = true;
    }

    public void clearInUse() {
        inUse = false;
    }

    public String toString() {
        return id + "/" + (links.length);
    }
}
