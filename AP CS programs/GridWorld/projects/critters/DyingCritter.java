import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.actor.Rock;
import java.awt.Color;
import java.util.ArrayList;

public class DyingCritter extends Critter {
	private boolean ate = false;
	private int dying = 0;
	private Color colors[] = {Color.BLUE, Color.GREEN, Color.YELLOW, Color.RED, Color.BLACK, Color.BLACK};
  	public void processActors(ArrayList<Actor> actors) {
  		ate = false;
        for (Actor a : actors) {
            if (!(a instanceof Rock) && !(a instanceof Critter)) {
                a.removeSelfFromGrid();
                ate = true;
                dying = 0;
			}
	}
       if (!ate) dying++;
       setColor(colors[dying]);
    }
    public void makeMove(Location loc)
    {
       	if (loc == null || dying==5)
       	    removeSelfFromGrid();
       	else
       	    moveTo(loc);
    }
}

