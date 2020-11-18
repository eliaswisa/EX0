package ex0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;

/**
 * un-weighted and un-directional graph that builed up from nodes
 */
// TODO: 06/11/2020 create copy constructor 
public class Graph_DS implements graph {
    /**
     * hash map that contains nodes and keys and fine a node value by mapping a key
     * the hash map containing all the graph nodes
     */
    private HashMap<Integer, node_data> allNodesMap = new HashMap<Integer, node_data>();
    private Collection<node_data> nada = new ArrayList<node_data>();
    /**
     * mc=mode count that changes when
     */
    private int mc = 0;
    private int edge_number = 0;
    private int node_number = 0;
    public Graph_DS(Graph_DS gra) {

    }

    public Graph_DS() {
      //  this.allNodesMap = null;

    }
    //private int MC;//the changes of the version of the original graph

    /**
     * getter for the node
     *
     * @param key - the node_id
     * @return a node in the hash map by key mapping
     */
    @Override
    public node_data getNode(int key) {
        if (this.allNodesMap.get(key) == null) {
            return null;
        } else
            return this.allNodesMap.get(key);

    }

    /**
     * checking if an edge existing between two nodes
     * if and only if one node is existing in the other neighbors list
     *
     * @param node1 first node input
     * @param node2 second node input
     * @return
     */
    @Override
    public boolean hasEdge(int node1, int node2) {

            if (this.allNodesMap.get(node1).hasNi(node2) && this.allNodesMap.get(node2).hasNi(node1)) {

                return true;
            }


        return false;
    }

    /**
     * adding node to the hash graph by adding this node to the hash map
     *
     * @param n the node we aree adding
     */
    @Override
    public void addNode(node_data n) {
        if (this.allNodesMap == null) {
            //System.out.println("its empty"
            this.allNodesMap.put(n.getKey(), n);
            node_number++;
            mc++;
            return;
        }
       if (!this.allNodesMap.containsKey(n.getKey())) {
            this.allNodesMap.put(n.getKey(), n);
            node_number++;
           mc++;
        } else {
            System.out.println("key already exist");
        }
    }

    /**
     * method who connects between two nodes contained in the graph
     *
     * @param node1 first node
     * @param node2 second node
     */
    @Override
    public void connect(int node1, int node2) {
        if (this.allNodesMap.containsKey(node1) && this.allNodesMap.containsKey(node2) && !(node1==node2)) {
            if (hasEdge(node1, node2)&&hasEdge(node2, node1)) {
                return;
            } else {
                this.allNodesMap.get(node1).addNi(this.allNodesMap.get(node2));
                this.allNodesMap.get(node2).addNi(this.allNodesMap.get(node1));
                edge_number++;
            }
        }
    }

    /**
     * return a pointer of collection of all the values from the hash map
     *
     * @return collection of values(nodes)
     */
    @Override
    public Collection<node_data> getV() {

        if (this.allNodesMap == null) return nada;
        return this.allNodesMap.values();
    }

    /**
     * method that returns a collection of all nodes that connected to given node in the graph
     *
     * @param node_id given node
     * @return
     */
    @Override
    public Collection<node_data> getV(int node_id) {
        if (this.allNodesMap.get(node_id).getNi().isEmpty()) {
            System.out.println("no neighbors");
            return null;

        } else
            return this.allNodesMap.get(node_id).getNi();
    }

    /**
     * method that removing node from the graph by given key
     *
     * @param key given key for mapping
     * @return the node that have been removed
     */
    @Override
    public node_data removeNode(int key) {

        if (this.allNodesMap.containsKey(key)) {
            //node_data tempNode = new NodeData();
            if(this.allNodesMap.get(key)==null)return null;
            node_data tempNode = new NodeData(this.allNodesMap.get(key));
            for (node_data i : this.allNodesMap.values()) {
                if (i.hasNi(key)) {
                    i.removeNode(allNodesMap.get(key));
                    edge_number--;
                }
            }
            this.allNodesMap.remove(key);
            node_number--;
            mc++;
            return tempNode;
        }
        return null;
    }

    /**
     * method that detached two nodes one from each other by removing theirs edge
     *
     * @param node1 first node
     * @param node2 second node
     */
    @Override
    public void removeEdge(int node1, int node2) {

        if (allNodesMap.get(node1).hasNi(node2) & allNodesMap.get(node2).hasNi(node1)) {
            allNodesMap.get(node1).removeNode(allNodesMap.get(node2));
            allNodesMap.get(node2).removeNode(allNodesMap.get(node1));
            edge_number--;

        } else System.out.println("they are not neighbors by if and only if definition");
    }

    /**
     * checking amount of nodes in the graph
     *
     * @return number of nodes in the graph
     */
    @Override
    public int nodeSize() {
        if (this.allNodesMap == null) return 0;
        //return this.allNodesMap.size();
    return node_number;
    }

    /**
     * calculating the number of the edges in the graph-any change in the graph increment the mc by one.
     *
     * @return
     */
    @Override
    public int edgeSize() {
        return edge_number;
    }

    /**
     * -any changes in the graph increment the mc by one.(removing or adding node)
     *
     * @return mode count number
     */
    @Override
    // TODO: 09/11/2020  check what is inner state?!
    public int getMC() {
        return this.mc;

    }
//    public void setNi(HashMap<Integer, node_data> ni){
//        this.allNodesMap.putAll(ni);
//    }
//    public HashMap<Integer, node_data> getNiHashMap(){
//        return this.allNodesMap;
//
//    }

}
