import java.util.Arrays;
/** MaxHeap defines a max-heap. Each node in the max-heap contains a process.
 * @author Jasmine Young*/

public class MaxHeap
{
	 private Process[] heap;
	 private int heapSize;
	
	 /** Constructor uses given Process array as the heap
	  * @param Process[] h*/
	public MaxHeap(Process[] h)
	{
		heap = h;
		heapSize = 0;
	}
	
	/** maxHeapifyUp heapifies up from the given index
	 * @param int i (starting index)*/
	public void maxHeapifyUp(int i)
	{
		int p = getParent(i);
		if(heapSize != 1 && i <= heapSize && p > 0)
		{
			if(heap[p].compareTo(heap[i]) == -1)
			{
				Process temp = heap[i];
				heap[i] = heap[p];
				heap[p] = temp;
				maxHeapifyUp(p);
			}
		}
	}
	
	/** maxHeapifyDown heapifies down from the given index
	 * @param int i (starting index)*/
	public void maxHeapifyDown(int i)
	{
		int l = getLeftChild(i);
		int r = l+1;
		int largest = i;
		if(l <= heapSize && heap[l].compareTo(heap[i]) == 1)
		{
			largest = l;
		}
		
		if(r <= heapSize && heap[r].compareTo(heap[largest]) == 1)
		{
			largest = r;
		}
		
		if(largest != i)
		{
			Process temp = heap[i];
			heap[i] = heap[largest];
			heap[largest] = temp;
			maxHeapifyDown(largest);
		}
	}
	
	/** addElement adds an element into the heap and moves it to the correct index
	 * @param Process element (Process to be added to the heap)*/
	public void addElement(Process element)
	{
		increaseSize();
		heapSize++;
		heap[heapSize] = element;
		maxHeapifyUp(heapSize);
	}
	
	/** removeMaxElement removes the maximal element from the heap and restores max heap order to the heap
	 * @return Process (maximal element from the heap)*/
	public Process removeMaxElement()
	{
		if(heapSize < 1)
		{
			return null;
		}
		Process data = heap[1];
		heap[1] = heap[heapSize];
		heap[heapSize] = null;
		heapSize--;
		if(heapSize != 0)
		{
			maxHeapifyDown(1);
		}
		return data;
	}
	
	/** getMaxElement returns the maximal element from the heap without removing it
	 * @return Process (maximal element in the heap)*/
	public Process getMaxElement()
	{
		if(heapSize < 1)
		{
			return null;
		}
		return heap[1];
	}
	
	/** increaseSize increases the size of the array if it is full*/
	private void increaseSize()
	{
		if (heap.length == heapSize+1)
	    {
	        heap = Arrays.copyOf(heap, heap.length*2);
	    }
	}
	
	/** size returns the number of elements currently in the heap
	 * @return int (current size)*/
	public int size()
	{
		return heapSize;
	}
	
	/** update updates each Process as defined in PQueue.java
	 * @param int timeToIncrementLevel
	 * @param int maxPriorityLevel*/
	public void update(int timeToIncrementLevel, int maxPriorityLevel)
	{
		for(int i = 1; i <= heapSize; i++)
		{
			heap[i].increaseTimeNotProcessed();
			if(heap[i].getTimeNotProcessed() >= timeToIncrementLevel)
			{
				heap[i].resetTimeNotProcessed();
				if(heap[i].getPriority() < maxPriorityLevel)
				{
					heap[i].increasePriority();
					maxHeapifyUp(i);
				}
			}
		}
	}
	
	/** returns the index of the parent of Process at given index
	 * @param int i (Process index)
	 * @return int (parent index)*/
	private int getParent(int i)
	{
		if(i == 2)
		{
			return 1;
		}
		return (i/2);
	}
	
	/** returns the index of the left child of Process at given index
	 * @param int i (Process index)
	 * @return int (left child index)*/
	private int getLeftChild(int i)
	{
		return 2*i;
	}
}
