import java.util.Random;

public class ProcessGenerator
{
	private double probability;
	
	public ProcessGenerator(double probability)
	{
		this.probability = probability;
	}
	
	public boolean query()
	{
		Random rand = new Random();
		if(rand.nextDouble() <= probability)
		{
			return true;
		}
		return false;
	}

	public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel)
	{
		Random rand = new Random();
		return new Process(currentTime, rand.nextInt(maxProcessTime)+1, rand.nextInt(maxLevel)+1);
	}
	
	
}
