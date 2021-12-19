

/** Student is a class that has some methods and implements Comparable<T>
 * 
 * @author egecans
 *
 */
public class Student implements Comparable<Student>{
	
	private String name;
	private int id, duration;
	private double rating;
	
	/** Constructor of Student class which has a signature with 4 parameters.
	 * 
	 * @param id   id of Student
	 * @param name  Student's name 
	 * @param duration  a duration that student will study
	 * @param rating   a minimum rate of house that requires that student could stay.
	 */
	public Student (int id, String name, int duration, double rating) {
		this.name=name;
		this.id=id;
		this.duration=duration;
		this.rating=rating;
		
	}
	
	/** that method checks whether student could stay a house (that has a parameter rate) or not.
 	 * 
	 * @param rate  rate of the house checked
	 * @return  boolean
	 */
	public Boolean rateChecker(double rate){
		if (rate>=this.rating) 
			return true;
		return false;
	}
	
	
	/**  after 1 semester passed that method decrease a duration by 1.
	 * 
	 */
	public void oneSemesterPassed() {
		this.duration = duration-1;
	}
	
	/** that method checks the semester whether it's 0 or not.
	 *  if it's zero that returns false and in main class it is useful for some operations.
	 * @return  boolean
	 */
	public Boolean semesterChecker() {
		if (this.duration==0) {
			return false;
		}
		return true;
	}
	
	/** the method compares Students with respect to their ids.
	 * 
	 */
	public int compareTo(Student other) {
		return this.id-other.getId();
	}
	
	public int getDuration() {
		return duration;
	}

	public int getId() {
		return id;
	}

	public double getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}
	
	
	
	
	
}



	