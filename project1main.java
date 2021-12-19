

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class project1main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner reader = new Scanner(new File(args[0]));
		PrintStream writer = new PrintStream(new File(args[1]));
		
		
		/** That Priority Queues are for sorting Student and House objects by their ids. 
		 * 
		 */
		PriorityQueue<Student> students = new PriorityQueue<Student>();
		PriorityQueue<House> availableHouses = new PriorityQueue<House>();
		PriorityQueue<House> fullHouses = new PriorityQueue<House>();
		PriorityQueue<Student> waitingList = new PriorityQueue<Student>();
		
		/** That while loop reads the inputs.
		 * 
		 */
		while(reader.hasNext()) {
			String line = reader.nextLine();
			
			if (line.startsWith("s")) {
				String split[] = line.split(" ", 5);
				int id = Integer.parseInt(split[1]);
				String name = split[2];
				int duration = Integer.parseInt(split[3]);
				double rating = Double.parseDouble(split[4]);
				students.add(new Student(id, name, duration, rating));

			}
			
			if (line.startsWith("h")) {
				String split[] = line.split(" ", 4);
				int id = Integer.parseInt(split[1]);
				int duration = Integer.parseInt(split[2]);
				double rating = Double.parseDouble(split[3]);
				if (duration==0) {
					availableHouses.add(new House(id, duration, rating));
				}
				else {
					fullHouses.add(new House(id, duration, rating));
				}
			}
		}
		
		
		
		/** that priority queues are for copy and pasting the wished things.
		 * 
		 */
		PriorityQueue<Student> students2 = new PriorityQueue<Student>();
		PriorityQueue<House> availableHouses2 = new PriorityQueue<House>();
		PriorityQueue<House> fullHouses2 = new PriorityQueue<House>();
		
		
		/** that for loop is the main thing in this code.
		 *  it locates the students into the houses for 8 semester.
		 */
		for (int semester = 1; semester<9 ; semester++) {
			
			if (semester==1) {
				for (Student student: students) {
					if (student.getDuration()==0) {
						waitingList.add(student);
						students2.add(student);
					}
				}
			}
			students.removeAll(students2);
			students2.removeAll(students2);
			
			
		for (House house : fullHouses) {
			if(house.getDuration()==0) {
				fullHouses2.add(house);
//				System.out.println(semester +" " + house.getId());
			}
		}
		availableHouses.addAll(fullHouses2);
		fullHouses.removeAll(fullHouses2);
		fullHouses2.removeAll(fullHouses2);
			

		while (!availableHouses.isEmpty()) {
			House currHouse = availableHouses.poll();
			availableHouses2.add(currHouse);
			while (!students.isEmpty()) {
				Student currStudent = students.poll();
				students2.add(currStudent);
				if (currStudent.rateChecker(currHouse.getRating())) {
//					System.out.println("Name: " + currStudent.getName() + " Student duration: " + currStudent.getDuration()+ " House id: " + currHouse.getId()+ " House Duration: " + currHouse.getDuration());
					currHouse.incomingStudent(currStudent.getDuration());
					fullHouses.add(currHouse);
					availableHouses2.remove(currHouse);
					students2.remove(currStudent);
//					System.out.println("Name: " + currStudent.getName() + " Student duration: " + currStudent.getDuration()+ " House id: " + currHouse.getId()+ " House Duration: " + currHouse.getDuration());
					break;
				}
			}
			students.addAll(students2);
			students2.removeAll(students2);	
		}

		availableHouses.addAll(availableHouses2);
		availableHouses2.removeAll(availableHouses2);
		
		for (House house : fullHouses) {
			house.oneSemesterPassed();
		}
		
		
		for (Student student: students) {
			if (!student.semesterChecker()) {
				waitingList.add(student);
				students2.add(student);
			}
			
			else{
				student.oneSemesterPassed();
				if (!student.semesterChecker()) {
//					System.out.println("Semester: "+ semester + " Name: " + student.getName() + " duration: " + student.getDuration());
					waitingList.add(student);
					students2.add(student);
				}
			}
		}
		students.removeAll(students2);
		students2.removeAll(students2);
	}


		/** that while loop is for printing the students names that cannot be located by sorting their ids.
		 * 
		 */
		while(!waitingList.isEmpty()) {
			writer.println(waitingList.poll().getName());
		}
		
		
	}

}
