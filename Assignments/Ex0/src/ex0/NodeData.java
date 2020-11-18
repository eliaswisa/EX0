package ex0;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


/***
 * class who represents a node
 * @author Elia Swisa
 *
 */
public class NodeData implements node_data {
    /**
     * key who is also an serial number/id.every node has her own key
     */
    private int key;
    /**
     * collection that representing all the neighbors of this node
     */
    //private ArrayList<node_data> myNeighbors = new ArrayList<node_data>();
    private HashMap<Integer, node_data> myNeighbors = new HashMap<Integer, node_data>();
    /**
     * info of this node
     */
    private String info;
    /**
     * use to tag the node by number or color in future algorithms
     */
    private int tag;
    /**
     * static counter that counts up every time new node is being created
     */
    private static int node_idCounter = 0;

    // TODO: 27/10/2020 check thic constructor .check if we sould add the neighbors list here or only when i adding node  to graph

    /***
     *constructer by given arguments
     * @param key
     * @param myNeighbors
     */
    public NodeData(int key, HashMap<Integer, node_data> myNeighbors) {
        this.key = key;
        this.myNeighbors.putAll(myNeighbors);
        this.tag = 0;

    }

    /**
     * copy construcor
     *
     * @param n is given Node
     */
    public NodeData(node_data n ) {
        this.key = n.getKey();
        for (node_data i: n.getNi()) {
            this.myNeighbors.put(i.getKey(),i);
        }
        this.tag = 0;

    }
    //copy constructor
//    public NodeData(node_data n) {
//       this.key = n.getKey();
//        this.info = n.getInfo();
//        this.tag = n.getTag();
//        // TODO: 07/11/2020 fix to deep copy
  //      this.myNeighbors.putAll(n.getNi());
//        this.myNeighbors.has;
//    }

    /**
     * default constructor
     */
    public NodeData() {

        this.key = node_idCounter;
        node_idCounter++;
    }



    /**
     * authorizing to get the key
     *
     * @return
     */
    @Override
    public int getKey() {
        return this.key;
    }

    /**
     * @return getter for collection of this node neighbors
     */
    @Override
    public Collection<node_data> getNi() {
// TODO: 27/10/2020 check if this is the rigt casting
        return this.myNeighbors.values();
    }

    /**
     * checking if this node is a neighbor or other node by giving her key
     *
     * @param key by this key we can reach the node in the collection
     * @return true if they are neighbors and false if not
     */
    @Override
    public boolean hasNi(int key) {


        if (this.myNeighbors.containsKey(key) )return true;

        return false;
    }

    /**
     * @param t is a node who we adding to the neigbors list
     */
    @Override
    public void addNi(node_data t) {
//
//try {
//    this.myNeighbors.get(t.getKey());
//
//}
//catch (NullPointerException NodeNotExist)
//{
//    System.out.println("");
//}
//        if (myNeighbors.contains(t.getKey())) {}
//        else
//        {this.myNeighbors.add(t);}
        // TODO: 27/10/2020 check if this is the way and see if i need to check doubles
        if (!this.myNeighbors.containsKey(t.getKey()))
        {this.myNeighbors.put(t.getKey(), t);}
else {
            System.out.println("already neighbors");
        }
//        this.myNeighbors.add(t.getKey(), t);
    }

    /**
     * @param node node who will be removed from neighbors list
     */
    @Override
    public void removeNode(node_data node) {
// TODO: 06/11/2020 check/ delete also from the other side
        if(this.hasNi(node.getKey())){
            this.myNeighbors.remove(node.getKey());

        }

//        if (this.myNeighbors.contains(node))
//        {this.myNeighbors.remove(node);}
//        else System.out.println("node doesent exist");
//         this.myNeighbors.remove(node);
    }

    /**
     * info getter
     *
     * @return
     */
    @Override
    public String getInfo() {
        return this.info;
    }

    /**
     * @param s the info String who will be set in the node
     */
    @Override
    public void setInfo(String s) {
        this.info = s;
    }

    /**
     * @return returns the tag field
     */
    @Override
    public int getTag() {
        return this.tag;
    }

    /**
     * @return set the tag field
     */
    @Override
    public void setTag(int t) {
        this.tag = t;
    }
    void setKey(int key)
    {
        this.key=key;
    }

}

