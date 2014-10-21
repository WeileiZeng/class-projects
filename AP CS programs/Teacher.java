// Venkata Poreddy
// 1/10/10
// Period 3
// Provides basic variables for a Teacher object; extends the Person class

public class Teacher extends Person {
	private String mySubject; 
	private double mySalary; 
	
	public Teacher (String name, int age, String gender, String subject, double salary) {
		super(name, age, gender);
		mySubject = subject;
		mySalary = salary;
	}
	
	public String getSubject () {
		return mySubject;
	}
	
	public double getSalary () {
		return mySalary;
	}
	
	public void setSubject(String subject){
        mySubject = subject;
      }

    public void setSalary(double salary) {
        mySalary = salary;
      }
	
	public String toString(){
        return super.toString() + ", subject: " + mySubject + ", salary: " + mySalary;
      }
  }
