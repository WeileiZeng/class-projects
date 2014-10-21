// Venkata Poreddy
// 1/10/10
// Period 3
// Provides basic variables for a College Student object; extends the Student class

public class CollegeStudent extends Student {
	public String myMajor;
	public int myYear;
	
	public CollegeStudent(String name, int age, String gender, String idNum, double gpa, int year, String major){
        super(name, age, gender, idNum, gpa);
        myMajor = major;
        myYear = year;
      }

	public String getMajor(){
        return myMajor;
      }

    public int getYear(){
        return myYear;
      }

    public void setMajor(String major){
        myMajor = major;
      }

    public void setYear(int year){
        myYear = year;
      }
      
    public String toString() {
      	return super.toString() + ", year: " + myYear + ", major: " + myMajor;
	}
}
