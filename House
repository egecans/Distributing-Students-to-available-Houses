

/** House is a class that has some methods and implements Comparable<T> 
 * 
 * @author egecans
 *
 */
public class House implements Comparable<House>{
	
	private int id, duration;
	private double rating;
	
	/** Constructor of a House class which has a signature with 3 parameters
	 * 
	 * @param id    id of a house
	 * @param duration  a duration that how many semester that house will be used
	 * @param rating    rate of that house
	 */
	public House(int id, int duration, double rating) {
		this.id=id;
		this.duration=duration;
		this.rating=rating;
	
	}

	/** this method is designed for adding the suitable student's duration to the houses.
	 * 	
	 * @param duration  a duration that how many semester suitable student will study.
	 */
	public void incomingStudent(int duration) {
		this.duration+=duration;
	}
	
	
	/** this method is designed for one Semester passed. 
	 * if the duration of the house is not 0, then that duration will decrease by 1.
	 */
	public void oneSemesterPassed() {
		if (this.duration!=0)
			this.duration = duration-1;
	}
	
	
	/** this is comparable method for using Priority Queues in main class
	 *  it compares the classes with respect to their ids.
	 */
	public int compareTo(House other) {
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


	
	
	
	
	
	
	
	
}
