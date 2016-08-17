package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Iterator;



public class Sorting {
    private static Random randomGenerator=new Random();
    
    public  Integer[] createRandomIntArray(int arrayLength)
    {
	Integer[] resultArray=new Integer[arrayLength];
	Random r=new Random();
	for (int i = 0; i < resultArray.length; i++) {
	    resultArray[i]=new Integer(r.nextInt(100));
	}
	return resultArray;
    }
    
    public Integer[] createBadIntArray(int arrayLength)
    {
	Integer[] resultArray=new Integer[arrayLength];
	for (int i = 0; i < resultArray.length; i++) {
	    resultArray[i]=new Integer(i);
	}
	return resultArray;
    }
    
    public List<Integer> createRandomIntList(int listLength)
    {
	List<Integer> resultList=new LinkedList<Integer>();
	Random r=new Random();
	for (int i = 0; i < listLength; i++) {
	    resultList.add(new Integer(r.nextInt(100)));
	}
	return resultList;
    }
    
    public List<Integer> createBadIntList(int listLength)
    {
	List<Integer> resultList=new LinkedList<Integer>();
	for (int i = 0; i < listLength; i++) {
	    resultList.add(new Integer(listLength-i));
	}
	return resultList;
    }
    

    
    
    private String getArrayString(Object[] array)
    {
	String resultString="";
	for(int i=0;i<array.length;i++)
	{
	    resultString+=array[i].toString()+" ";
	}
	return resultString;
    }
    
    
    public  <T extends Comparable<T>>void  bubleSort(T[] sortedArray)
    {
	int steps=0;
	for(int i=0;i<sortedArray.length-1;i++)
	{
	    for (int j=i+1;j<sortedArray.length;j++)
	    {
		steps+=1;
		if(sortedArray[i].compareTo(sortedArray[j])<0)
		{
		    steps+=1;
		    swapElements(sortedArray,i,j);
		}
		
	    }
	}
	System.out.println("buble sort steps count:"+steps);
    }
    
    public <T extends Comparable<T>> void wikiBubleSort(T[] arr) {
	int steps=0;   
	for (int i = 0; i < arr.length - 1; i++) {
	        boolean swapped = false;
	        for (int j = 0; j < arr.length - i - 1; j++) {
	            steps+=1;
	            if (arr[j].compareTo(arr[j + 1])< 0) {
	        	steps+=1;
	        	swapElements(arr, j, j+1);
	        	swapped = true;
	            }
	        }            
	        
	        if(!swapped)
	            break;
	    }
	
	System.out.println("Wiki buble sort steps count:"+steps);
	}
    
    private static <T extends Comparable<T>> void swapElements(T[] array,int index1,int index2)
    {
	if (index1==index2)
	    return;
	T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
        
    }
    
    private <T extends Comparable<T>> void insertSort(List<T> sortedList,int borderIndex)
    {
	
	T insertedElement=sortedList.get(borderIndex);
	
	for(int i=0;i<borderIndex;i++)
	{
	    if(sortedList.get(i).compareTo(insertedElement)>=0)
	    {
		sortedList.remove(borderIndex);	
		sortedList.add(i, insertedElement);
		break;
	    }
	    
	}
	
	
    }
   
    public <T extends Comparable<T>> void insertSort(List<T> sortedList)
    {
	for(int i=1;i<sortedList.size();i++)
	    insertSort(sortedList,i);
    }

    
    
    public <T extends Comparable<T>> void shakeBubleSort(T[] sortedArray)
    {
	int steps=0;
	int indexOfRightBorder=sortedArray.length-1;
	int indexOfLeftBorder=0;
	while(indexOfLeftBorder<indexOfRightBorder)
	{
	    for(int i=indexOfLeftBorder;i<indexOfRightBorder;i++)
	    {steps+=1;
		if(sortedArray[i].compareTo(sortedArray[i+1])<0)
		{steps+=1;
		   swapElements(sortedArray, i, i+1);
		}
	    }
	    
	    for(int i=indexOfRightBorder-1;i>indexOfLeftBorder;i--)
	    {steps+=1;
		if(sortedArray[i].compareTo(sortedArray[i-1])>0)
		{steps+=1;
		   swapElements(sortedArray, i, i-1);
		}
	    }
	    indexOfLeftBorder++;
	    indexOfRightBorder--;
	}
	System.out.println("shake sort steps:"+steps);
    }
    
    public <T extends Comparable<T>> void quickSort(T[] sortedArray,int startIndex, int endIndex) {
	int leftElementIndex = startIndex;
	int rightElementIndex = endIndex;
	T baseElement = sortedArray[leftElementIndex+ randomGenerator.nextInt(rightElementIndex - leftElementIndex) + 1];

	while (leftElementIndex <= rightElementIndex) {
	    while (sortedArray[leftElementIndex].compareTo(baseElement) < 0) {
		leftElementIndex++;
	    }

	    while (sortedArray[rightElementIndex].compareTo(baseElement) > 0) {
		rightElementIndex--;
	    }

	    if (leftElementIndex <= rightElementIndex) {
		swapElements(sortedArray, leftElementIndex, rightElementIndex);
		leftElementIndex++;
		rightElementIndex--;
	    }
	}
	
	if(startIndex<rightElementIndex)
	{
	    quickSort(sortedArray, startIndex, rightElementIndex);
	}
	
	if(leftElementIndex<endIndex)
	{
	    quickSort(sortedArray, leftElementIndex, endIndex);
	}
    }
    
    public <T extends Comparable<T>> void quickSort(T[] sortedArray)
    {
	quickSort(sortedArray, 0, sortedArray.length-1);
    }
    
    public <T extends Comparable<T>> List<T> mergerSort(List<T> sortedList)
    {
	if(sortedList.size()<2)
	    return sortedList;
	
	int midleIndex=sortedList.size()/2;
	return mergeLists(mergerSort(sortedList.subList(0, midleIndex)), mergerSort(sortedList.subList(midleIndex, sortedList.size())));
	
    }
    private <T extends Comparable<T>> List<T> mergeLists(List<T> list1, List<T> list2)
    {
	if (list1.size()==0)
	{
	    return list2;
	}
	if(list2.size()==0)
	{
	    return list1;
	}
	List<T> resultList=new LinkedList<T>();
	int list1Position=0;
	int list2Position=0;
	
	while(list1Position<list1.size()&&list2Position<list2.size())
	{
	    if(list1.get(list1Position).compareTo(list2.get(list2Position))<0){
		resultList.add(list1.get(list1Position++));
	    }
	    else{
		resultList.add(list2.get(list2Position++));
	    }
	}
	
	if(list1Position>=list1.size())
	    resultList.addAll(list2.subList(list2Position,list2.size()));
	else
	    resultList.addAll(list1.subList(list1Position,list1.size()));
	
	return resultList;
    }

    

    public static void main(String[] args) {	
	Sorting sort=new Sorting();
	List integerRandomList=sort.createRandomIntList(1000000);
	//List list2=sort.createRandomIntList(5);
	//System.out.println(list1);
	//System.out.println(list2);
	//System.out.println(sort.mergeLists(list1, list2));
	TimeMeter timer=new TimeMeter();
	//System.out.println(integerRandomList);
	timer.start();
	sort.mergerSort(integerRandomList);
	timer.stop();
	
	System.out.println(timer.getProcessTime());
	//return;
	
	Integer[] sortedArray=sort.createRandomIntArray(1000000);
	
	timer.start();
	//sort.bubleSort(sortedArray);
	sort.quickSort(sortedArray);
	timer.stop();
	System.out.println("Sort time:"+timer.getProcessTime());
    }
   }

class TimeMeter
{
	private long startTime=0;
	private long processTime=0;
	void start()
	{
	    startTime=System.currentTimeMillis();
	}
	void stop()
	{
	    processTime=System.currentTimeMillis()-startTime;
	}
	
	long getProcessTime()
	{
	    return processTime;
	}
	
	
}

