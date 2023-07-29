package LabProgram510;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class CourseGrade {
	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);

		/* TODO: Declare any necessary variables here. */
		String[] firstName = new String[20];
		String[] lastName = new String[20];
		String[] midTerm_Exam1 = new String[20];
		String[] midTerm_Exam2 = new String[20];
		String[] final_Exam = new String[20];
		
		int[] average_Exam = new int[20];
		char[] grade = new char[20];
		int i = 0;
		double allMidTerm1 = 0, allMidTerm2 = 0, allFinal = 0;

		/* TODO: Read a file name from the user and read the tsv file here. */
		//String filename = "src/LabProgram510/StudentInfo.tsv";
		String filename = scnr.next();
		FileInputStream fileByteStream = new FileInputStream(filename);
		Scanner fileScanner = new Scanner(fileByteStream);

		while (fileScanner.hasNext()) {
			firstName[i] = fileScanner.next();
			lastName[i] = fileScanner.next();
			midTerm_Exam1[i] = fileScanner.next();
			midTerm_Exam2[i] = fileScanner.next();
			final_Exam[i] = fileScanner.next();
			i++;
		}
		/*
		 * TODO: Compute student grades and exam averages, then output results to a text
		 * file here.
		 */
		for (int j = 0; j < i; j++) {
			average_Exam[j] = (Integer.valueOf(midTerm_Exam1[j]) + Integer.valueOf(midTerm_Exam2[j])
					+ Integer.valueOf(final_Exam[j])) / 3;
			if (average_Exam[j] >= 90)
				grade[j] = 'A';
			else if (average_Exam[j] >= 80)
				grade[j] = 'B';
			else if (average_Exam[j] >= 70)
				grade[j] = 'C';
			else if (average_Exam[j] >= 60)
				grade[j] = 'D';
			else
				grade[j] = 'F';
		}
		// all midterm_1
		for (int j = 0; j < i; j++) {
			allMidTerm1 += Integer.valueOf(midTerm_Exam1[j]);
		}
		// all midterm_2
		for (int j = 0; j < i; j++) {
			allMidTerm2 += Integer.valueOf(midTerm_Exam2[j]);
		}
		// all final
		for (int j = 0; j < i; j++) {
			allFinal += Integer.valueOf(final_Exam[j]);
		}
		FileOutputStream fileStream = new FileOutputStream("src/LabProgram510/report.txt");
		PrintWriter outFS = new PrintWriter(fileStream);
		for (int k = 0; k < i; k++)
			outFS.println(firstName[k] + "	" + lastName[k] + "	" + midTerm_Exam1[k] + "	" + 
					      midTerm_Exam2[k] + "	" + final_Exam[k] + "	" + grade[k]);
		outFS.printf("\nAverages: Midterm1 %.2f, Midterm2 %.2f, Final %.2f\n", 
					(allMidTerm1 / i), (allMidTerm2 / i), (allFinal / i));
		outFS.close();
	}
}