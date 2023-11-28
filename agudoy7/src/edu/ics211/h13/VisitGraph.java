package edu.ics211.h13;

/* the method findUnreachable traverses the graph of objects
 * beginning at root, marking reachable objects as being in use.
 * After this traversal, findUnreachable returns a set of all the
 * objects that are not marked as being in use. */

public class VisitGraph {

  public static java.util.Set<Integer>
    findUnreachable(GraphNode[] objects, int root) {
    // TODO: unmark all the storage objects, then
    // traverse the graph beginning from objects[root] and mark all
    // reachable storage objects, and finally
    // return the indices of the objects that are NOT inUse

    return new java.util.HashSet<Integer>();
  }

  public static void main(String[] unused) {
    // initial unit test: gn1 and gn2 refer to each other, gn3 refers to gn1,
    // nobody refers to gn4
    java.util.HashSet<GraphNode> set1 = new java.util.HashSet<>();
    java.util.HashSet<GraphNode> set2 = new java.util.HashSet<>();
    GraphNode gn1 = new GraphNode("gn1", 1);
    set1.add(gn1);
    GraphNode gn2 = new GraphNode("gn2", set1);   // gn2 refers to gn1
    gn1.setLink(0, gn2);    // now gn1 algn refers to gn2
    set1.add(gn2);
    GraphNode gn3 = new GraphNode("gn3", set1);   // gn3 -> gn2 and gn1
    GraphNode gn4 = new GraphNode("gn4", set1);   // as does gn4
    GraphNode[] storageObjects = { gn1, gn2, gn3, gn4 };  // gn3 @ index 2
    set1.add(gn3);   // set1 has gn1, gn2, gn3
    set2.add(gn4);   // set2 only has gn4
    // traversing the graph beginning with gn3 should mark gn3, gn1, and gn2,
    // and leave gn4 not inUse
    System.out.println("set1 is " + set1);
    System.out.println("set2 is " + set2);
    System.out.println("found " + findUnreachable(storageObjects, 2));
    assert (set2.equals(findUnreachable(storageObjects, 2)));
    // TODO: additional unit tests
   
  }
}

