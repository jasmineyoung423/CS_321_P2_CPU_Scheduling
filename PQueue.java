/** PQueue defines a priority queue using a max-heap.
 * @author Jasmine Young*/

public class PQueue
{
	private MaxHeap maxHeap;
	private Process currentProcess;
	
	/** Constructor creates a new MaxHeap with Process[101]*/
	public PQueue()
	{
		maxHeap = new MaxHeap(new Process[101]);
		currentProcess = null;
	}
	
	/** enPQueue adds the input Process to the Priority Queue (MaxHeap)
	 * @param Process p (Process to be added to the Priority Queue (MaxHeap)*/
	public void enPQueue(Process p)
	{
		maxHeap.addElement(p);
	}
	
	/** isEmpty returns true if the Priority Queue (MaxHeap) is empty, otherwise returns false
	 * @return boolean*/
	public boolean isEmpty()
	{
		return (maxHeap.size() == 0);
	}
	
	/** dePQueue removes the next Process from the Priority Queue (MaxHeap) and returns it
	 * @return Process (removed Process from the Priority Queue (MaxHeap))*/
	public Process dePQueue()
	{
		if(currentProcess == null)
		{
			currentProcess = maxHeap.removeMaxElement();
		}
		else if(currentProcess != null && currentProcess.compareTo(maxHeap.getMaxElement()) < 1)
		{
			currentProcess = maxHeap.removeMaxElement();
		}
		return currentProcess;
	}
	
	/** update updates each Process in the Priority Queue (MaxHeap) based on input params
	 * @param int timeToIncrementLevel (how much time should have passed to increment priority level of the Process)
	 * @param int maxPriorityLevel (the max level the priority of the Process can be)*/
	public void update(int timeToIncrementLevel, int maxPriorityLevel)
	{
		maxHeap.update(timeToIncrementLevel, maxPriorityLevel);

	}
}
