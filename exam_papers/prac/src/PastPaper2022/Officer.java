/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PastPaper2022;

import java.util.Date;

/**
 *
 * @author mat
 */
public class Officer extends crewMember {

    /*
    – rank : integer
    – datePromoted : Date
    + numPromotedOfficers: integer = 0
     */
    private int rank;
    private Date datePromoted;
    public static int numPromotedOfficers = 0;

    /*
    Constructor(inFN : string, inCID : integer, inDT : string, inRK : integer, inDP : Date)
     */
    public Officer(String fullname, int crewID, String department, int rank, Date datePromoted) {
        super(fullname, crewID, department);
        this.rank = rank;
        this.datePromoted = datePromoted;
    }

    public int getRank() {
        return rank;
    }

    public Date getDatePromoted() {
        return datePromoted;
    }

    /*
    This method can be a switch statement which I will add later if anyone is interested
     */
    public String getTitle() {
        /*
        Ensign 1
        Lieutenant 2
        Lt Commander 3
        Commander 4
        Captain 5
         */
        if (rank == 1) {
            return "Ensign";
        } else if (rank == 2) {
            return "Lieutenant";
        } else if (rank == 3) {
            return "Lt Commander";
        } else if (rank == 4) {
            return "Commander";
        } else if (rank == 5) {
            return "Captain";
        }
        return "Rank level not within scope (rank < 1 or rank > 5)";
    }

    @Override
    public String toString() {
        /*
        Because the class extends "crewMember", you are able to access 
        the public methods without having to reference the parent class
         */
        return getFullname() + "\t Crew ID: " + getCrewID() + "\t[" + getDepartment() + "] " + this.getTitle();
    }

}
