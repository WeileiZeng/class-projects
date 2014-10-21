import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class StockpileCritter extends Critter {
	private int energy = 0;
	public void processActors (ArrayList <Actor> actors) {
		for (Actor a: actors) {
			a.removeSelfFromGrid();
			energy++;
		}
	}
	public void makeMove (Location loc) {
		if (loc == null || energy == 0) 
			removeSelfFromGrid();
		else {
			moveTo (loc);
			energy--;
		}
	}
}

