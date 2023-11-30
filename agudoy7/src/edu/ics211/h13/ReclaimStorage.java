package edu.ics211.h13;

/* the method reclaimUnreachable traverses the graph of objects
 * beginning at root, marking reachable objects as being in use.
 * After this traversal, reclaimUnreachable returns a set of all the
 * objects that are not marked as being in use. */

public class ReclaimStorage {


    /**
     * Unmark all the storage objects, then traverse the graph beginning from the given index (objects[root])
     *      and mark all reachable storage objects. Return the indeces of the objects that are NOT inUse()
     * @param objects, array of StorageObjects to traverse through
     * @param root, the index of starting point of traversal
     * @return set of indeces not in use
     */
    public static java.util.Set<Integer> reclaimUnreachable(StorageObject[] objects, int root) {    // TODO
        java.util.HashSet<Integer> unreachable = new java.util.HashSet<Integer>();

        StorageObject rootNode = objects[root];

        for(int i=0; i<objects.length; i++){
            objects[i].clearInUse();
        }

        help(rootNode);

        for(int i=0; i<objects.length; i++){
            if(!objects[i].isInUse()){
                unreachable.add(i);
            }
        }

        return unreachable;
    }

    private static void help(StorageObject obj){
        obj.markInUse();
        for(int i=0; i<obj.numLinks(); i++){
            if(!obj.getLink(i).isInUse()){ 
                help(obj.getLink(i));
            }
        }
    }
    public static void main(String[] unused) {
        
        // initial unit test: so1 and so2 refer to each other, so3 refers to so1,
        // nobody refers to so4
        java.util.HashSet<StorageObject> set1 = new java.util.HashSet<>();
        java.util.HashSet<StorageObject> set2 = new java.util.HashSet<>();
        StorageObject so1 = new StorageObject("so1", 1);
        set1.add(so1);
        StorageObject so2 = new StorageObject("so2", set1); // so2 refers to so1
        so1.setLink(0, so2); // now so1 also refers to so2
        set1.add(so2);
        StorageObject so3 = new StorageObject("so3", set1); // so3 -> so2 and so1
        StorageObject so4 = new StorageObject("so4", set1); // as does so4
        StorageObject so5 = new StorageObject("so5", 0);
        StorageObject[] storageObjects = { so1, so2, so3, so4, so5 }; // so3 @ index 2
        set1.add(so3); // set1 has so1, so2, so3
        set2.add(so4); // set2 only has so4
        set2.add(so5);
        // traversing the graph beginning with so3 should mark so3, so1, and so2,
        // and leave so4 not inUse
        System.out.println("set1 is " + set1);
        System.out.println("set2 is " + set2);

        java.util.Set<Integer> unreachable = reclaimUnreachable(storageObjects, 2);
        java.util.HashSet<StorageObject> objects = new java.util.HashSet<>();
        System.out.println("reclaiming " + unreachable);


        for(int x : unreachable){
            objects.add(storageObjects[x]);
        }
        System.out.println(set2.equals(objects));
        // for(){

        // }

        assert (set2.equals(reclaimUnreachable(storageObjects, 2)));
        // TODO: additional unit tests

        StorageObject one = new StorageObject("one", 0);
        StorageObject two = new StorageObject("two", 1);
        two.setLink(0, one);
        StorageObject three = new StorageObject("three", 2);
        three.setLink(0, one);
        three.setLink(1, two);
        // StorageObject one = new StorageObject("one", 0);
        // StorageObject one = new StorageObject("one", 0);

    }
}
