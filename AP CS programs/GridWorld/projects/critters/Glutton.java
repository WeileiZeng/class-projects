import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class Glutton extends Critter {
	public void processActors (ArrayList <Actor> actors) {
		for (Actor a: actors) {
			a.removeSelfFromGrid();
		}
	}
}

