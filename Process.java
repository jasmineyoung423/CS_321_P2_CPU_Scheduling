
public class Process implements Comparable<Process>
{
	private int arrivalTime, processTime, priority, timeNotProcessed;
	
	public Process(int arrivalTime, int processTime, int priority)
	{
		this.arrivalTime = arrivalTime;
		this.processTime = processTime;
		this.priority = priority;
		this.timeNotProcessed = 0;
	}

	public int getArrivalTime()
	{
		return arrivalTime;
	}
	
	public int getTimeNotProcessed()
	{
		return timeNotProcessed;
	}
	
	public int getPriority()
	{
		return priority;
	}
	
	public void increasePriority()
	{
		this.priority++;
	}
	
	public void increaseTimeNotProcessed()
	{
		timeNotProcessed++;
	}
	
	public void resetTimeNotProcessed()
	{
		timeNotProcessed = 0;
	}
	
	public int getTimeRemaining()
	{
		return processTime;
	}

	public void reduceTimeRemaining()
	{
		if(processTime > 0)
		{
			processTime--;
		}
	}
	
	public boolean finish()
	{
		return (processTime==0);
	}

	@Override
	public int compareTo(Process o)
	{
		// NOT FINISHED
		if(this.priority > o.getPriority())
		{
			return 1;
		}
		else if(this.priority < o.getPriority())
		{
			return -1;
		}
		else
		{
			if(this.arrivalTime < o.arrivalTime)
			{
				return 1;
			}
			else if(this.arrivalTime > o.arrivalTime)
			{
				return -1;
			}
		}
		return 0;
	}
}
