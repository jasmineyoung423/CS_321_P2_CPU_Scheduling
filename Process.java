/** Process defines a Process. Implements Comparable Interface
 * Each Process has a priority level, time remaining to finish, and arrival time.
 * @author Jasmine Young*/

public class Process implements Comparable<Process>
{
	private int arrivalTime, processTime, priority, timeNotProcessed;
	
	/** Constructor takes in arrivalTime, processTime, and priority and assigns them to Process attributes
	 * @param int arrivalTime (time of arrival)
	 * @param int processTime (time it takes to process)
	 * @param int priority (priority level)*/
	public Process(int arrivalTime, int processTime, int priority)
	{
		this.arrivalTime = arrivalTime;
		this.processTime = processTime;
		this.priority = priority;
		this.timeNotProcessed = 0;
	}

	/** getArrivalTime gets arrival time
	 * @return int (arrival time)*/
	public int getArrivalTime()
	{
		return arrivalTime;
	}
	
	/** getTimeNotProcessed gets time not processed
	 * @return int (time not processed)*/
	public int getTimeNotProcessed()
	{
		return timeNotProcessed;
	}
	
	/** getPriority gets priority level
	 * @return int (priority)*/
	public int getPriority()
	{
		return priority;
	}
	
	/** getTimeRemaining gets time remaining to complete process
	 * @return int (time remaining)*/
		public int getTimeRemaining()
	{
		return processTime;
	}
		
	/** increasePriority increases priority level by 1*/
	public void increasePriority()
	{
		this.priority++;
	}
	
	/** increaseTimeNotProcessed increases time not processed by 1*/
	public void increaseTimeNotProcessed()
	{
		timeNotProcessed++;
	}
	
	/** resetTimeNotProcessed resets time not processed to 0*/
	public void resetTimeNotProcessed()
	{
		timeNotProcessed = 0;
	}
	

	/** increaseTimeRemaining reduces time remaining by 1 if not already 0*/
	public void reduceTimeRemaining()
	{
		if(processTime > 0)
		{
			processTime--;
		}
	}
	
	/** finish returns if the time remaining to complete process is equal to 0
	 * @return boolean (time remaining to process equal to 0)*/
	public boolean finish()
	{
		return (processTime==0);
	}

	@Override
	public int compareTo(Process o)
	{
		if(this.finish())
		{
			return -1;
		}
		else if(o.finish())
		{
			return 1;
		}
		else if(this.priority > o.getPriority())
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
