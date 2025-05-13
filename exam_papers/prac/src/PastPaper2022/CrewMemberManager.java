/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PastPaper2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author mat
 */
public class CrewMemberManager {

    /*
    The question mentions that they must not be accessible from outside the class
    which means that they must just be private.
    
    Use the parent datastructure for creating the array
     */
    private crewMember[] cArr = new crewMember[80];
    private int size = 0;

    public CrewMemberManager() {
        try {
            // Scan in the text file using the file package 
            Scanner scFile = new Scanner(new File("crew.txt"));

            // Check if the file has a next line
            while (scFile.hasNextLine()) {
                // Set the next line to a new scanner called scan line (scLine)
                Scanner scLine = new Scanner(scFile.nextLine()).useDelimiter("#");

                // Look at the structure of the text file and set variables accordingly
                /*
                CrewMembers:
                    Fullname
                    crewID
                    Department
                
                    If there is a next entry in the line, then it is an officer:
                        rank
                        dateOfPromotion
                 */
                String fullname = scLine.next();
                int crewID = scLine.nextInt();
                String dept = scLine.next();

                // Check if there is something after the department field in the file 
                if (scLine.hasNext()) {
                    int rank = scLine.nextInt();
                    // read the date as a string and then extract the day, month and year
                    String dateString = scLine.next();

                    // Use string handling to extract the values you want
                    int day = Integer.parseInt(dateString.substring(0, 2));
                    int month = Integer.parseInt(dateString.substring(3, 5));
                    int year = Integer.parseInt(dateString.substring(6, 10));

                    Date date = new Date(day, month, year);
                    cArr[size++] = new Officer(fullname, crewID, dept, rank, date);
                } else {
                    cArr[size++] = new crewMember(fullname, crewID, dept);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File could not be found");
        }
    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < size; i++) {
            temp += cArr[i].toString() + "\n";
        }
        return temp;
    }
}
