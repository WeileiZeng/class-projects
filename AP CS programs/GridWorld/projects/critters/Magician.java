import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import java.awt.Color;
import java.util.ArrayList;

public class Magician extends Critter {
	
	public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if (a instanceof Bug)
            	Flower newActor = new Flower();
			else if (a instanceof Critter)
				Rock newActor = new Rock();
			else if (a instanceof Rock)
				Bug newActor = new Bug();
			else if (a instanceof Flower)
				Critter newActor = new Critter();
            	
            newActor.setGrid(a.getGrid());
            newActor.setColor(a.getColor());
            newActor.setDirection(a.getDirection());
            newActor.setLocation(a.getLocation());
            a.removeSelfFromGrid();
            newActor.putSelfInGrid();
			
        }
    }
}

