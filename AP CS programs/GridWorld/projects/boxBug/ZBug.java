import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class ZBug extends Bug
{
 	private int steps;
    private int sideLength;
    private int segment;
    
    public ZBug(int length)
    {
    	setDirection(Location.EAST);
    	segment = 1;
		steps = 0;
        sideLength = length;
	}
	
    public void act()
	{
		if (segment <= 3 && steps < sideLength)
		{
			if (canMove())
			{
				move();
				steps++;
			}
		}
		else if (segment == 1)
		{
			setDirection(Location.SOUTHWEST);
			steps = 0;
			segment++;
		}
		else if (segment == 2)
		{
			setDirection(Location.EAST);
			steps = 0;
			segment++;
		}
	}

}

