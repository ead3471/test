package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.dom4j.tree.ElementIterator;

import com.sun.javafx.scene.traversal.WeightedClosestCorner;



public class Graph<T> {
//some test for git
    static Integer vertexCount=1;
    
    public Graph() {
	// TODO Auto-generated constructor stub
    }
    
    
    public static void main(String[] args) {
	
	GraphVertex<Integer> root=new GraphVertex<Integer>(0, "root");
	
	addIntegerLevels(root, 2,4);
	System.out.println(vertexCount);
	printGraph(root);
	
	
	GraphVertex<Integer> newVertex=new GraphVertex<Integer>(155, "root123");
	
	root.addTwoDirectionEdge(newVertex);
	System.out.println(root.getChildElements());
	System.out.println(newVertex.getChildElements());
	
	
	
    }
    private static void addIntegerLevels(GraphVertex<Integer> rootVertex, int deep, int childsNumber)
    {
	if(deep==0) return;
	Random rnd= new Random();
	int rootChildsnumber=childsNumber;
	while(rootChildsnumber-->0)
	{
	    rootVertex.addOneDirectionEdge(new GraphVertex<Integer>(new Integer(rnd.nextInt(16)), (++vertexCount).toString()));
	}
	
	deep--;
		
	Set<GraphVertex<Integer>> childsSet=rootVertex.getChildElements();
	    for(GraphVertex<Integer> child:childsSet)
	    {
		addIntegerLevels(child, deep, childsNumber);
	    }
	
    }
    private static<T> void printGraph(GraphVertex<T> rootVertex)
    {
	String result=rootVertex.getVertexID()+"=>";
	Set<GraphVertex<T>> currentVertexChilds=rootVertex.getChildElements();
	if(currentVertexChilds.size()==0)return;
	for(GraphVertex<T> currentVertex:currentVertexChilds)
	{
	    result=result+":"+currentVertex;
	}
	System.out.println(result);
	
	for(GraphVertex<T> currentVertex:currentVertexChilds)
	{
	    printGraph(currentVertex);
	}	
    }
}

interface WeightedParameter
{
    public int getWeight();
}

class IntegerWeight implements WeightedParameter
{
    public static final IntegerWeight ONE_WEIGHTED=new IntegerWeight(1);
    private Integer weight=1;
    public IntegerWeight(int weight)
    {
	this.weight=weight;
    }
    @Override
    public int getWeight() {
	return weight;
    }
      
}

class GraphVertex<T>
{
    private Set<GraphVertex<T>> elementChilds=new HashSet<GraphVertex<T>>();
    private Map<String,WeightedParameter> edgesWeights=new HashMap<String,WeightedParameter>();    
    private T elementValue=null;
    private boolean thisVertexIsVisited=false;
    private String vertexID="noID";
    
    public GraphVertex(T elementValue, String vertexID)
    {
	this.elementValue=elementValue;
	this.vertexID=vertexID;
    }

    @Override
    public boolean equals(Object obj)
    {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (!(obj instanceof GraphVertex))
		return false;
	
	return ((GraphVertex<?>)obj).vertexID==vertexID;
    }
    
    @Override
    public int hashCode() {
        return vertexID.hashCode();
    }
    
    
    public boolean addOneDirectionEdge(GraphVertex<T> newChild, WeightedParameter edgeWeight)
    {
	if(newChild.equals(this))
	    return false;
	
	 elementChilds.add(newChild);
	 edgesWeights.put(newChild.getVertexID(), edgeWeight);
	 
	 return true;
    }
    
    public boolean addOneDirectionEdge(GraphVertex<T> newChild)
    {
	return addOneDirectionEdge(newChild,IntegerWeight.ONE_WEIGHTED);
    }
    
    public boolean addTwoDirectionEdge(GraphVertex<T> newChild, WeightedParameter edgeWeightTo, WeightedParameter edgeFrom)
    {
	if(newChild.equals(this))
	    return false;
	
	addOneDirectionEdge(newChild,edgeWeightTo);	
	newChild.addOneDirectionEdge(this,edgeFrom);
	return true;
    }
    
    public boolean addTwoDirectionEdge(GraphVertex<T> newChild)
    {
	return addTwoDirectionEdge(newChild, IntegerWeight.ONE_WEIGHTED, IntegerWeight.ONE_WEIGHTED);
    }
    
    public boolean removeChild(GraphVertex<T> child)
    {
	return elementChilds.remove(child);
    }
    
    public void setVisited(boolean visitedFlag)
    {
	thisVertexIsVisited=visitedFlag;
    }
    
    public boolean isVisited()
    {
	return thisVertexIsVisited;
    }
    
    public Set<GraphVertex<T>> getChildElements()
    {
	return (Set<GraphVertex<T>>) Collections.unmodifiableSet(elementChilds);
    }
    
    public T getVertexValue()
    {
	return elementValue;
    }
    
    public String getVertexID()
    {
	return vertexID;
    }
    
    public String toString()
    {
	return vertexID+"("+elementValue+")";
    }
}
 
