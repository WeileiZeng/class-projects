import info.gridworld.actor.Bug;

public class OctoBug extends Bug
{
 	private int steps;
    private int sideLength;
    
    public OctoBug(int length)
    {
		steps = 0;
        sideLength = length;
	}
	
    public void act()
    {
         if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            steps = 0;
        }
    }
}

