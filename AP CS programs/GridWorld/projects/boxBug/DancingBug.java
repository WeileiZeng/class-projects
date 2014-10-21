import info.gridworld.actor.Bug;

public class DancingBug extends Bug
{
 	private int steps;
    private int[] numberOfTurns;
    
    public DancingBug(int turns[])
    {
		steps = 0;
        numberOfTurns = turns;
	}
	
    public void act()
    {
    	for (int loop = 1; loop <= numberOfTurns[steps]; loop++)
    		turn();
		steps++;
		super.act();
        if (steps >= numberOfTurns.length)
        	steps = 0;
	}
}


