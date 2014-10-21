// Changes Actor types of surrounding actors, and teleports after every move
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import info.gridworld.grid.BoundedGrid;

import java.awt.Color;
import java.util.ArrayList;

public class Magician extends Critter {
	
	/*public Magician() {
		setColor(Color.GREEN);
	}*/
	
	public void processActors(ArrayList<Actor> actors) {
		Actor newActor = new Actor();
        for (Actor a : actors) {
        	if (!(a instanceof Magician)) {
            	if (a instanceof Bug)
            		newActor = new Flower();
				else if (a instanceof Critter)
					newActor = new Rock();
				else if (a instanceof Rock)
					newActor = new Bug();
				else if (a instanceof Flower)
					newActor = new Critter();
            }
            if (!(a instanceof Magician)) {	
            	newActor.setDirection(a.getDirection());
            	newActor.setColor(a.getColor());
            	newActor.putSelfInGrid(a.getGrid(), a.getLocation());
			}
			
        }
	}
        
    public ArrayList<Location> getMoveLocations() {
    	ArrayList<Location> theLocations = new ArrayList<Location>();
    	int rows;
    	int cols;
    	if (getGrid() instanceof BoundedGrid) {
    		rows = getGrid().getNumRows();
    		cols = getGrid().getNumCols();
		}
		else {
			rows = getLocation().getRow()+5; cols = getLocation().getCol()+5;
		}
        	for (int r = 0; r < rows; r++) {
        	    for (int c = 0; c < cols; c++) {
        	        Location loc = new Location(r, c);
        	        if (getGrid().get(loc)==null)
        	            theLocations.add(loc);
        	    }
        	}
			return theLocations;
    	}
    }



