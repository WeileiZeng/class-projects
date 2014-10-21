import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class MagicianRunner
{
    public static void main(String[] args)
    {
	ActorWorld world = new ActorWorld();
	world.add(new Location(7, 5), new Rock());
	world.add(new Location(5, 4), new Rock());
	world.add(new Location(5, 7), new Rock());
	world.add(new Location(0, 5), new Bug());
	world.add(new Location(0, 9), new Bug());
	world.add(new Location(0, 0), new Bug());
	world.add(new Location(7, 3), new Critter());
	world.add(new Location(5, 9), new Critter());
	world.add(new Location(2, 9), new Critter());
	world.add(new Location(3, 3), new Flower());
	world.add(new Location(2, 2), new Flower());
	world.add(new Location(5, 0), new Flower());
	world.add(new Location(6, 5), new Magician());
	world.add(new Location(1, 5), new Magician());
	world.show();
    }
}

