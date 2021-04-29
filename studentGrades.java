import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class studentGrades {
	static final int numOfStudent = 20;
	 public static void main(String[] args) throws IOException
	   {
		 studentClass students[] = new studentClass[numOfStudent];;
		 //studentClass[] arrayOfClasses = new studentClass[numberOfStudents];
		 
		 
		 	readStudentData(students);
			assignGrade(students);
			int highestScore = findHighestScore(students);
			displayHighestScore(students, highestScore);
		 
			
	   }
	//A method to print the names of the students having the highest test score.
	 private static void displayHighestScore(studentClass[] students, int highestScore) throws FileNotFoundException {
		
		 PrintWriter outData = new PrintWriter("Out.txt");
	        outData.println("Student Name           Test Score  Grade");
	        //print data to output file with correct formatting
	        for (int i = 0; i < numOfStudent; i++) {
	            outData.printf("%-29s", students[i].StudentLName + ", " + students[i].StudentFName);
	            outData.printf("%-8d", students[i].testScore);
	            outData.println(students[i].grade);
	        }
	        outData.println();
	        outData.println("Highest Test Score: " + highestScore);
	        outData.println("Students having the highest test score:");
	        //print names of students with the highest test score
	        for (int i = 0; i < numOfStudent; i++) {
	            if (students[i].testScore == highestScore) {
	                outData.println(students[i].StudentLName + ", " + students[i].StudentFName);
	            }
	        }
	        outData.close(); //close output file
	        System.out.println("program complete");
	    }
	   
		
	 //A method to find the highest test score
	private static int findHighestScore(studentClass[] students) {
		int highestScore = 0;
        //find the highest test score
        for (int i = 0; i < numOfStudent; i++) {
            if (highestScore < students[i].testScore) {
                highestScore = students[i].testScore;
            }
        }
        return highestScore;
	 }
		
	
	//A method to assign the relevant grade to each student
	private static void assignGrade(studentClass[] students) {
		
		for (int i = 0; i <  numOfStudent; i++)
		{
			if (students[i].testScore >= 90)
			{
				students[i].grade = 'A';
			}
			else if (students[i].testScore >= 80 )
			{
				students[i].grade = 'B';
			}
			else if (students[i].testScore >= 70 )
			{
				students[i].grade = 'C';
			}
			else if (students[i].testScore >= 60)
			{
				students[i].grade = 'D';
			}
			else if (students[i].testScore >= 0 )
			{
				students[i].grade = 'F';
			}
		}
		
	}

	//A method to read the students’ data into the array
	 public static void readStudentData( studentClass student[]) throws IOException
	   {
		 File file = new File("Data.txt");
	       
	      if (file.exists())
	      {
	    	  Scanner inputFile = new Scanner(file);
	    	  
	         while(inputFile.hasNext()) {
	        	 
	         for(int i = 0; i < numOfStudent; i++) {
	        	 
	        	student[i] = new studentClass();
	               //capture each line of text file
	             String data = inputFile.nextLine();
	               //since the first and last names of students and test scores are separated by spaces
	               //use the following statement to split string data into an array of strings delimited by space
	            String[] split = data.split(" ");

	               //the first string separated by first space will be the first names of students
	               student[i].StudentFName = split[0];
	               
	               //the second string separated by second space will be the last names of students
	               student[i].StudentLName = split[1];
	               
	               //the last string will be the test scores of students
	               student[i].testScore = Integer.parseInt(split[2]);                        

	         }
	         
	      }
	         inputFile.close();
	      }
	      else if (!file.exists())
	      {
	         System.out.println("The input file does not exist!");
	         System.exit(0);
	      }
	   }
}
	 


