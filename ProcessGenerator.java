import java.util.Random;
/** ProcessGenerator randomly generates Processes with a given probability. At beginning
 *  of each time unit, whether a Process will arrive is decided by the given probability.
 *  In addition, while generating a new Process, both its priority and the required time 
 *  units to finish the Process are randomly generated within given ranges.
 *  @author Jasmine Young*/

public class ProcessGenerator
{
	private double probability;
	
	/** Constructor
	 * @param double probability*/
	public ProcessGenerator(double probability)
	{
		this.probability = probability;
	}
	
	/** query uses class probability attribute to determine if a new Process is created
	 * @return boolean*/
	public boolean query()
	{
		Random rand = new Random();
		if(rand.nextDouble() <= probability)
		{
			return true;
		}
		return false;
	}

	/** getNewProcess creates and returns a new Process with currentTime,
	 *  a processTime value within the given range,
	 *  and a priority level within the given range
	 *  @param int currentTime (new Process arrivalTime)
	 *  @param int maxProcessTime (max value for new Process timeToProcess)
	 *  @param int maxLevel (max value for new Process priority)
	 *  @return Process (newly constructed Process)*/
	public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel)
	{
		Random rand = new Random();
		return new Process(currentTime, rand.nextInt(maxProcessTime)+1, rand.nextInt(maxLevel)+1);
	}
	
	
}
