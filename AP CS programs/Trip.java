import java.util.ArrayList;

public class Trip   {
	private ArrayList <Flight> flights;
	//  stores the flights (if any) in chronological order.

	public Trip ( )   {
		flights = new ArrayList <Flight> ();
	}

	public Trip ( ArrayList <Flight> f )   {
		flights = f;
	}

	public static void main ( String [] args )   {
		Time defaulttime = new Time();
		Time endofschool = new Time( 3, 0, true );
		Time startofschool = new Time( 7, 35, false );
		System.out.println ( "\n\n\n" );
		startofschool.printTime();
		System.out.println ( );
		endofschool.printTime();
		System.out.println ( "\nThe difference between these two times is " + 
				startofschool.minutesUntil(endofschool) + " minutes.\n\n");

		Flight sanjosetodallas = new Flight (new Time(7,15,false), new Time(11,3,false));
		sanjosetodallas.printFlight();
		System.out.println ( "\nThe duration of this flight is " + 
				sanjosetodallas.getDepartureTime().minutesUntil(sanjosetodallas.getArrivalTime()) + 
				"minutes.\n\n");

		Trip sjtobangalore = new Trip();
		sjtobangalore.AddFlight(new Flight (new Time(12,15,false), new Time(10,30,false)));
		sjtobangalore.AddFlight(new Flight (new Time(11,35,false), new Time(2,30,true)));
		sjtobangalore.AddFlight(new Flight (new Time(3,40,true), new Time(6,30,true)));
		sjtobangalore.AddFlight(new Flight (new Time(7,15,true), new Time(11,50,true)));
		sjtobangalore.printTrip();
		System.out.println ( "The duration of this trip is " + sjtobangalore.getDuration() + " minutes.");
		System.out.println ( "The shortest layover is " + sjtobangalore.getShortestLayover() + " minutes.\n\n");

		ArrayList <Flight> gotoeurope = new ArrayList <Flight> ();
		gotoeurope.add(new Flight (new Time(5,25,false), new Time(8,35,false)));
		gotoeurope.add(new Flight (new Time(10,25,false), new Time(10,35,true)));
		Trip latomadrid = new Trip ( gotoeurope ); 
		latomadrid.printTrip();
		System.out.println ( "The duration of this trip is " + latomadrid.getDuration() + " minutes.");
		System.out.println ( "The shortest layover is " + latomadrid.getShortestLayover() + " minutes.\n\n\n");
	}

	public void AddFlight ( Flight f )   {
		flights.add ( f );
	}

	public void printTrip ( )   {
		for (int i = 0; i < flights.size(); i++ )   {
			flights.get(i).printFlight();
			System.out.println ( );	
		}
	}

	/** @return	the number of minutes from the departure of the first flight to the arrival
	 *		of the last flight if there are one or more flights in the trip;
	 *		0, if there are no flights in the trip
	 */
	public int getDuration ( )   {
		if ( flights.size() == 0 )   {
			return 0;
		}
		else   {
			Time start = flights.get(0).getDepartureTime();
			Time end = flights.get(flights.size()-1).getArrivalTime();
			return start.minutesUntil(end);
		}
	}

	/** Precondition: the departure time for each flight is later than the arrival time of its
	 *		preceding flight
	 *  @return 	the smallest number of minutes between the arrival of a flight and the departure
	 *		of the flight immediately after it, if there are two or more flights in the trip;
	 *		-1, if there are fewer than two flights in the trip
	 */
	public int getShortestLayover ( )   {
		if ( flights.size() < 2 )   {
			return -1;
		}
		else   {
			int shortest = getDuration();
			for ( int i = 0; i < flights.size()-1; i++ )   {
				Time arrive = flights.get(i).getArrivalTime();
				Time leave = flights.get(i+1).getDepartureTime();
				int layover = arrive.minutesUntil(leave);
				if ( layover < shortest )   {
					shortest = layover;
				}
			}
			return shortest;
		}
	}
}

class Flight   {
	private Time departure;
	private Time arrival;

	public Flight ( )   {
		arrival = new Time ( );
		departure = new Time ( );
	}

	public Flight ( Time d, Time a )   {
		departure = d;
		arrival = a;
	}

	public void printFlight ( )   {
		System.out.print ( "Departure: " );
		departure.printTime();
		System.out.print ( "  Arrival: " );
		arrival.printTime();
	}

	/** @return time at which the flight departs
	 */
	public Time getDepartureTime ( )   { 
		return departure;
	}

	/** @return time at which the flight arrives
	 */
	public Time getArrivalTime ( )   { 
		return arrival;
	}
}

class Time   {
	private int hour, minute;
	private boolean pmflag;

	public Time ( )   {
		hour = 9;
		minute = 15;
		pmflag = false;
	}

	public Time ( int h, int m, boolean p )   {
		hour = h;
		minute = m;
		pmflag = p;
	}

	/** @return difference, in minutes, between this time and other;
	 * difference is negative if other is earlier than this time
	 */
	public int minutesUntil ( Time other )   { 
		/* implementation not shown */ 
		return (other.rawMinutes() - rawMinutes());
	}

	public int rawMinutes ( )   {
		if ( pmflag )
			return (12 * 60 + (hour%12) * 60 + minute);
		else
			return ((hour%12) * 60 + minute);
	}

	public void printTime ( )   {
		System.out.print ( hour + ":");
		if (minute < 10)
			System.out.print ( "0" );
		System.out.print ( minute );
		if (pmflag)
			System.out.print ( " p.m." );
		else
			System.out.print ( " a.m." );
	}
}
