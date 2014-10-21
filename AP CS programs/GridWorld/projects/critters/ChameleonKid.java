import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class ChameleonKid extends Critter
{
	private static final Color DEFAULT_COLOR = Color.PINK;
    private static final double DARKENING_FACTOR = 0.05;
    public void processActors(ArrayList<Actor> actors)
    {
    	int n = actors.size();
        System.out.println(actors.size());
        if (n == 0) {
        	Color c = getColor();
        	int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
        	int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
        	int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
        	setColor(new Color(red, green, blue));
        	return;
		}
		//int r = (int) (Math.random() * n);
        //System.out.println(r);
        for (int r = 0; r < actors.size(); r++) {
        	Actor other = actors.get(r);
        	if ((other.getLocation()).getDirectionToward(getLocation()) == Location.AHEAD || (other.getLocation()).getDirectionToward(getLocation()) == Location.HALF_CIRCLE) {
        		setColor(other.getColor());
        		break;
			}
		}
	}

    /**
     * Turns towards the new location as it moves.
     */
    public void makeMove(Location loc)
    {
        setDirection(getLocation().getDirectionToward(loc));
        super.makeMove(loc);
        
    }
}

