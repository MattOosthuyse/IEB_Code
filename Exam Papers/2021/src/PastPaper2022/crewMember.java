package PastPaper2022;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mat
 */
public class crewMember {

    /*
    fullname : string
– crewID : integer
– department : string
+ numPromotedCrew : integer = 0
     */
    private String fullname;
    private int crewID;
    private String department;
    public static int numPromotedCrew = 0;

    public crewMember(String fullname, int crewID, String department) {
        this.fullname = fullname;
        this.crewID = crewID;
        this.department = department;
    }

    public String getFullname() {
        return fullname;
    }

    public int getCrewID() {
        return crewID;
    }

    public String getDepartment() {
        return department;
    }

    /*
    fullname<tab>'Crew ID:'<space>crewID<tab>'['department']'
    For example,
    Lamla Weston Crew ID: 270 [Flight]
     */
    @Override
    public String toString() {
        return "fullname " + fullname + "\t Crew ID: " + crewID + "\t [" + department + "]";
    }

}
