import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class TestResults   {

	private ArrayList <StudentAnswerSheet> sheets;
	private ArrayList <String> key;

	public TestResults ( )   {
		sheets = new ArrayList <StudentAnswerSheet> ();

		String [] april = { "?", "B", "?", "?", "B" };
		sheets.add ( new StudentAnswerSheet ( "April Scott", april ) );

		String [] dennis = { "A", "?", "B", "D", "A" };
		sheets.add ( new StudentAnswerSheet ( "Dennis Plaza", dennis ) );

		String [] brad = { "?", "B", "C", "D", "C" };
		sheets.add ( new StudentAnswerSheet ( "Brad Metheany", brad ) );

		String [] trudy = { "A", "B", "?", "?", "D" };
		sheets.add ( new StudentAnswerSheet ( "Trudy Gross", trudy ) );

		String [] stringkey = { "A", "B", "C", "D", "B" };
		key = new ArrayList <String> ();
		for ( int i = 0; i < stringkey.length; i++ )
			key.add ( stringkey[i] );
	}

	public static void main ( String [] args )   {
		TestResults run = new TestResults ( );

		run.PrintScoresAndHighest ( );
	}

	public void PrintScoresAndHighest ( )   {
		System.out.println ( "\n\n\n" );
		System.out.println ( "KEY: " + key + "\n\n" );
		for ( int i = 0; i < sheets.size(); i++ )   {
			System.out.println ( sheets.get(i).getName() + ": " + sheets.get(i).studentAnswers() );
			System.out.print ( sheets.get(i).getScore(key) + " for " );
			System.out.println ( sheets.get(i).getName() + "\n" );
		}
		System.out.println ( highestScoringStudent (key) + " was the highest scoring student." );
		System.out.println ( "\n\n\n" );
	}

	public String highestScoringStudent ( ArrayList <String> key )   {
		String bestStudent = new String();
		for (int loop = 0; loop<sheets.size(); loop++) {
			if (sheets.get(loop).getScore(key)>sheets.get(loop+1).getScore(key)) {
				if (sheets.get(loop).getScore(key)>sheets.get(loop+1).getScore(key)) {
					bestStudent = sheets.get(loop).getName();
				}
			}
			return bestStudent;
		}
	}
}

class StudentAnswerSheet   {

	private ArrayList <String> answers;
	private String name;

	public StudentAnswerSheet ( String n, String [] a )   {
		name = n;
		answers = new ArrayList <String> ();
		for ( int i = 0; i < a.length; i++ )
			answers.add ( a[i] );
	}

	/** @param key the list of correct answers, represented as Strings of length
	 *  one
	 *  Precondition:  key.size() is equal to the number of answers in this
	 *  answer sheet
	 * @return this student's test score
	 */
	public double getScore ( ArrayList <String> key )   {
		double score = 0.0;
		for ( int i = 0; i < answers.size(); i++ )   {
			if ( answers.get(i).equals ( key.get(i) ) )    {
				score += 1.0;
			}
			else if ( !answers.get(i).equals ( "?" ) )   {
				score -= 0.25;
			}
		}
		return score;
	}

	/** @return  the name of the student
	 */
	public String getName ( )   {
		return name;
	}

	public ArrayList <String> studentAnswers ( )   {
		return answers;
	}
}
