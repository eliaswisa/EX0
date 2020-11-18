package ex0;

import java.util.List;
import java.util.*;

public class Graph_Algo implements graph_algorithms {
    graph gr;


//        Queue<node_data> queue = new PriorityQueue<node_data> ();

    @Override
    public void init(graph g) {
        this.gr = g;
    }

    @Override
    public graph copy() {
        graph tempGr = new Graph_DS();
        if(gr.getV()!=null) {


            for (node_data i : gr.getV()) {
                NodeData newNode=new NodeData();
                newNode.setInfo(i.getInfo());
                newNode.setTag(i.getTag());
                newNode.setKey(i.getKey());
                tempGr.addNode(newNode);
            }

            for (node_data i : gr.getV()) {
                Collection niColl;
                niColl= i.getNi();
                Iterator it=niColl.iterator();
                while(it.hasNext()){
                   NodeData original= (NodeData) it.next();
                   NodeData clone= (NodeData) tempGr.getNode(i.getKey());
                   clone.addNi( tempGr.getNode(original.getKey()));

                }

            }

        }
// TODO: 16/11/2020 check how can i copy the mc and the number of the edges 

        return tempGr;
    }


    @Override
    public boolean isConnected() {
        Iterator it=gr.getV().iterator();
        if(it.hasNext()) {
            node_data node = (node_data) it.next();
            BFS(node);
        }
        Iterator isTaggedNode=gr.getV().iterator();
        while(isTaggedNode.hasNext()){
            if(((node_data) isTaggedNode.next()).getTag()==0)return false;
        }


        return true;
    }
    void BFS(node_data node)
    {
        LinkedList<node_data> queue = new LinkedList<node_data>();
        for(node_data i:gr.getV()){
            i.setTag(0);
        }
        node.setTag(1);
        queue.add(node);

        while (queue.size() != 0)
        {
            node = queue.poll();

            Iterator<node_data> it = node.getNi().iterator();
            while (it.hasNext())
            {
                node_data  no = it.next();
                if (no.getTag()==0)
                {
                    no.setTag(1);
                    queue.add(no);
                }
            }
        }
    }

public void dijkstra(int src, int dest){
    node_data node1 =  this.gr.getNode(src);
    node_data node2 =  this.gr.getNode(dest);
    if(node1==null||node2==null)return;
    for(node_data i: this.gr.getV()){
        if(i.getKey()==node1.getKey()){
            i.setTag(0);
            i.setInfo(i.getKey()+"");
        }else{
            i.setTag(Integer.MAX_VALUE);
            i.setInfo("");
        }
    }
    Queue<node_data> queue=new ArrayDeque<>();
    queue.add(node1);
    while (!queue.isEmpty()){
        node_data temp = queue.poll();
        for(node_data i : temp.getNi()){
            if(i.getTag()>temp.getTag()+1){
                i.setTag(temp.getTag()+1);
                i.setInfo(temp.getInfo()+","+i.getKey());
                queue.add(i);
            }
        }
    }
}
    @Override
    public int shortestPathDist(int src, int dest) {
        node_data node2 = this.gr.getNode(dest);
        if(node2==null)return -1;
        dijkstra(src,dest);
        int ans=  node2.getTag();
        for(node_data i: this.gr.getV()){
            i.setTag(0);
            i.setInfo("");
        }
        return ans;
    }

    @Override
    public List<node_data> shortestPath(int src, int dest) {
        List<node_data> ans=new ArrayList<node_data>();
        node_data node2 = this.gr.getNode(dest);
        if(node2==null)return ans;
        dijkstra(src,dest);
        String [] path=node2.getInfo().split(",");
        System.out.println(node2.getInfo());
        for(int i =0; i<path.length;i++){
            ans.add(this.gr.getNode(Integer.parseInt(path[i])));
        }
        for(node_data i: this.gr.getV()){
            i.setTag(0);
            i.setInfo("");
        }

        return ans;
    }
}
