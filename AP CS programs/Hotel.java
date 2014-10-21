import java.util.ArrayList;

public class Hotel
{
	private Reservation [] rooms;
	//  each element corresponds to a room in the hotel;  if rooms[index] is null, the room is empty;
	//  otherwise, it contains a reference to the Reservation for that room such that
	//  rooms[index].getRoomNumber()  returns index

	private ArrayList <String> waitList;
	//  contains names of guests who have not yet been assigned a room because all rooms are full

	public Hotel ( )   {
		rooms = new Reservation [100];
		for ( int i = 0; i < rooms.length; i++ )
		{
			rooms[i] = null;
		}
		waitList = new ArrayList <String> ();
	}

	public static void main ( String [] args )   {
		Hotel theritz = new Hotel ( );

		theritz.requestRoom ( "Skip Mueller" );
		theritz.requestRoom ( "Colin Anderson" );
		theritz.requestRoom ( "Joe Kim" );
		theritz.requestRoom ( "Emmett Powers" );
		theritz.requestRoom ( "Sushma Bana" );

		System.out.println ( "\n\n" );
		theritz.printAllReservations ( );

		theritz.addToWaitList ( "Debbie Frazier" );
		theritz.addToWaitList ( "Jon Stark" );
		theritz.addToWaitList ( "Jeff Payne" );

		System.out.println ( "\n\n" );
		theritz.cancelAndReassign ( theritz.getReservationNum(2) );
		theritz.printAllReservations ( );

		System.out.println ( "\n\n" );
		theritz.cancelAndReassign ( theritz.getReservationNum(2) );
		theritz.printAllReservations ( );

		System.out.println ( "\n\n" );
		theritz.cancelAndReassign ( theritz.getReservationNum(2) );
		theritz.printAllReservations ( );

		System.out.println ( "\n\n" );
		theritz.cancelAndReassign ( theritz.getReservationNum(2) );
		theritz.printAllReservations ( );
		System.out.println ( "\n\n" );
	}

	public void addToWaitList ( String name )
	{
		waitList.add(name);
	}

	public void printAllReservations ( )
	{
		for ( int i = 0; i < rooms.length; i++ )
			if ( rooms[i] != null )
				rooms[i].printReservation();
	}

	public Reservation getReservationNum ( int i )
	{
		return rooms[i];
	}

	//  if there are any empty rooms (rooms with no reservation), then create a reservation for an empty room for
	//  the specified guest and return the new Reservation;  otherwise, add the guest to the end of waitList and
	//  return null
	public Reservation requestRoom (String guestName)
	{
		/*for ( int i = 0; i < rooms.length; i++ )
		{
			if ( rooms[i] == null )
			{
				rooms[i] = new Reservation(guestName, i);
				return rooms[i];
			}
		}
		waitList.add(guestName);
		return null;*/
		
		for (int loop = 0; loop <= rooms.length; loop++) {
			if (rooms[loop] != null) {
				Reservation request = new Reservation (guestName, loop);
				return request;
			}
			else {
				waitList.add(guestName);
				return null;
			}
		}
	}

	//  release the room associated with parameter res, effectively canceling the reservation;  if any names are
	//  stored in waitList, remove the first name and create a Reservation for this person in the room reserved by
	//  res;  return the new Reservation;  if waitList is empty, mark the room specified by res as empty and return 
	//  null
	//  precondition:    res  is a valid  Reservation  for some room in this hotel
	public Reservation cancelAndReassign (Reservation res)
	{
		int roomNum = res.getRoomNumber();
		if (waitList.isEmpty())
		{
			rooms[roomNum] = null;
		}
		else
		{
			rooms[roomNum] = new Reservation ( (String)waitList.get(0), roomNum );
			waitList.remove(0);
		}
		return rooms[roomNum];
	}
}

class Reservation
{
	String NameOfGuest;
	int NumberOfRoom;

	public Reservation (String guestName, int roomNumber)
	{
		NameOfGuest = guestName;
		NumberOfRoom = roomNumber;
	}

	public void printReservation ( )   {
		System.out.println ( "Room number " + NumberOfRoom +
			" is reserved under the name " + NameOfGuest );
	}

	public int getRoomNumber()
	{
		return NumberOfRoom;
	}
}
