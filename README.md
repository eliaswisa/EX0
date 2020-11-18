# EX0
oop university course assingment -unweighted undirectional graph

**author:**  
Elia Swisa

**summery:**

the project focus an unweighted undirectional graph data structure that has three main classes

1)NodeData-who represents node in a graph who has a field of adjacency list in a form of hashMap of nodes and keys

2.Graph_DS-who represents graph that build from this nodes in data stracture of hashMap of nodes  

3.Graph_Algo-who represents algorithm of shortests path that works on Graph_DS class

***NodeData class methods:***

**hasNI**-boolean method who returns true if given node is a neighbour of this node  

**addNi**-adding a neighbour to  the giving node by adding each other to their adjancecy list  

**removeNode**-removing the giving node from this node by deleting giving node key from this adjacency list and and this node key from giving node list  

*constructors getters and setters defined as well according to need  


***Graph_DS class methods:***  


**hasEdge**-boolean method that returns true if an edge is exist between two given nodes  

**addNode**-adds given node and her key to the graph hashMap  

**connect**-connects between two given nodes in the graph  

**getV**-return a view of collection of the nodes of the graph  

**Collection<node_data> getV(int node_id)**-return a collection of neighbours of given node at the graph  

**removeNode**-removing the node by his key and deleting this node from all  his neighbours adjacency list(detacheing the edges)  

**removeEdge**-deleting the edges between two given nodes if they are neighbours in the graph  

**nodeSize**-return the number of the nodes at the graph  

**get mc**-return mode count of the graph  

 

***Graph_Algo class methods:***

**init**-initiates the graph algo graph  

**copy**-deep copy of the graph in the Graph_Algo class  

**shortestPathDist**-calculating the  smallestnumber of nodes that need to be traveled to reach from source node to destenation node  

**shortestPath**-returnes alist of the nodes that traveled when we used the ShortestPathDist method  
