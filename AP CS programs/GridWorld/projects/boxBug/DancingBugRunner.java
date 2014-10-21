import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;

public class DancingBugRunner
{
        public static void main(String[] args)
        {
                ActorWorld world = new ActorWorld();

                int[] turns = {2,2,1,3};
                DancingBug ballerina = new DancingBug(turns);
                ballerina.setColor(Color.ORANGE);
                world.add(new Location(5, 6), ballerina);

                int[] box = {2,2,2,3,1,1,3};
                DancingBug wozniak = new DancingBug(box);
                wozniak.setColor(Color.GREEN);
                world.add(new Location(4, 3), wozniak);

                world.show();
        }
}



