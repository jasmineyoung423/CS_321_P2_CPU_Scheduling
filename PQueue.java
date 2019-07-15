
public class PQueue
{
	private MaxHeap maxHeap;
	private Process currentProcess;
	private boolean first;
	
	public PQueue()
	{
		maxHeap = new MaxHeap(new Process[100]);
		currentProcess = null;
		first = true;
	}
	
	public void enPQueue(Process p)
	{
		maxHeap.addElement(p);
	}
	
	public boolean isEmpty()
	{
		return (maxHeap.size() == 1);
	}
	
	public Process dePQueue()
	{
		Process data = currentProcess;
		if(first)
		{
			currentProcess = maxHeap.removeMaxElement();
			first = false;
		}
		else if(currentProcess.finish())
		{
			currentProcess = maxHeap.removeMaxElement();
		}
		else
		{
			if(currentProcess != null && currentProcess.compareTo(maxHeap.getMaxElement()) == -1)
			{
				currentProcess = maxHeap.removeMaxElement();
				maxHeap.addElement(data);
			}
			if(currentProcess == null)
			{
				System.out.println("Queue is empty.");
			}
		}
		return currentProcess;
	}
	
	public void update(int timeToIncrementLevel, int maxPriorityLevel)
	{
		maxHeap.update(timeToIncrementLevel, maxPriorityLevel);
		if(currentProcess.finish())
		{
			currentProcess = maxHeap.removeMaxElement();
		}
	}

}
