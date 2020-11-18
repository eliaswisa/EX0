import ex0.NodeData;
import ex0.node_data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NodeDataTest {
    ArrayList<node_data> a = new ArrayList<node_data>();
    node_data nod1 = new NodeData(1,a);

    ArrayList<node_data> b = new ArrayList<node_data>();
    node_data nod2 = new NodeData(2, b);

    @org.junit.jupiter.api.Test
    void getKey() {

        assertEquals(1, nod1.getKey());
    }

    @org.junit.jupiter.api.Test
    void getNi() {
        assertEquals(a, nod1.getNi());
    }

    @Test
    void hasNi() {
        ArrayList<node_data> a = new ArrayList<node_data>();
        ArrayList<node_data> b = new ArrayList<node_data>();
        node_data nod1 = new NodeData();
        node_data nod2 = new NodeData();

        nod1.addNi(nod2);

       boolean asser= nod1.hasNi(2);

       assertTrue(asser);
//boolean flag=hasNi(1);

    }

    @org.junit.jupiter.api.Test
    void addNi() {
        node_data nod1 = new NodeData();
        node_data nod2 = new NodeData();
        nod1.addNi(nod2);
    }

    @org.junit.jupiter.api.Test
    void removeNode() {
    }

    @org.junit.jupiter.api.Test
    void getInfo() {
    }

    @org.junit.jupiter.api.Test
    void setInfo() {
    }

    @org.junit.jupiter.api.Test
    void getTag() {
    }

    @org.junit.jupiter.api.Test
    void setTag() {
    }
}