import java.util.Arrays;

public class MaxHeap
{
	 private Process[] heap;
	 private int rear;
	
	public MaxHeap(Process[] h)
	{
		heap = h;
		rear = 1;
	}
	
	public void maxHeapifyUp(int i)
	{
		int p = getParent(i);
		if(rear != 1 && i < rear && p > 0)
		{
			if(heap[p].compareTo(heap[i]) == -1)
			{
				Process temp = heap[i];
				heap[i] = heap[p];
				heap[p] = temp;
				maxHeapifyDown(p);
			}
		}
	}
	
	public void maxHeapifyDown(int i)
	{
		/*if(i < rear)
		{*/
			int l = getLeftChild(i);
			int r = l+1;
			int largest = i;
			if(l < rear && heap[l].compareTo(heap[i]) == 1)
			{
				largest = l;
			}
			
			if(r < rear && heap[r].compareTo(heap[largest]) == 1)
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
		//}
	}
	
	public void addElement(Process element)
	{
		increaseSize();
		heap[rear] = element;
		maxHeapifyUp(rear);
		rear++;
	}
	
	public Process removeMaxElement()
	{
		if(rear == 0)
		{
			return null;
		}
		Process data = heap[1];
		heap[1] = heap[rear-1];
		heap[rear-1] = null;
		rear--;
		maxHeapifyDown(1);
		return data;
	}
	
	public Process getMaxElement()
	{
		if(rear == 1)
		{
			return null;
		}
		return heap[1];
	}
	
	private void increaseSize()
	{
		if (heap.length == rear)
	    {
	        heap = Arrays.copyOf(heap, heap.length*2);
	    }
	}
	
	public int size()
	{
		return rear;
	}
	
	public void update(int timeToIncrementLevel, int maxPriorityLevel)
	{
		for(int i = 1; i < rear; i++)
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
	
	private int getParent(int i)
	{
		if(i == 2)
		{
			return 1;
		}
		return (i/2);
	}
	
	private int getLeftChild(int i)
	{
		return 2*i;
	}
}
