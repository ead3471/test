package graph;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

class GraphLoader
{
    public  GraphVertex<String> loadFromXml(String filePath) throws FileNotFoundException, DocumentException
    {
	SAXReader reader = new SAXReader();
        Document document = reader.read(new FileInputStream(new File(filePath)));
        Iterator vertexIterator=document.getRootElement().elementIterator("vertex");
        
        
	
        
        
        return null;
    }
    
    
    private Set<GraphVertex<String>> getUsedGraphSet(Document document)
    {
	Iterator<Element> vertexIterator=document.getRootElement().elementIterator("vertex");
	Set<GraphVertex<String>> resultSet=new HashSet<GraphVertex<String>>();
	while(vertexIterator.hasNext())
	{
	    Element curentVertex=vertexIterator.next();
	    resultSet.add(new GraphVertex<String>(curentVertex.attributeValue("value"), curentVertex.attributeValue("id")));
	}
	
	return resultSet;
    }
    
    private void createEdges(Document document, GraphVertex rootVertex, Set<GraphVertex<String>> vertexSet )
    {
	Iterator<Element> vertexIterator=document.getRootElement().elementIterator("vertex");
	while(vertexIterator.hasNext())
	{
	    Element curentVertex=vertexIterator.next();
	    Iterator<Element> edgeIterator=curentVertex.elementIterator("edge");
	    while(edgeIterator.hasNext())
	    {
		Element currentEdge=edgeIterator.next();
		String edgeToVertex=currentEdge.getText();
		int edgeWeight=1;
		try
		{
		    edgeWeight=Integer.parseInt(currentEdge.attributeValue("weight"));
		}
		catch(Exception ex)
		{
		    
		}
		
		if()
		
	    }
	}
	
	
    }
    
    
    
}