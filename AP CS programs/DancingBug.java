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
        for (int loop = 0; loop < numberOfTurns.length; loop++) {
        	for (int loop2 = 0; loop2 < numberOfTurns[loop]; loop2++) {
        		turn();
			}
        	move();
		}
    }
}

