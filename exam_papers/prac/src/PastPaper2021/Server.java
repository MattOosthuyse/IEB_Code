package PastPaper2021;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author moosthuyse
 */
public class Server {

    private String serverID, location, role, fault;
    private Technician assignedTech;

    public static final String ROLETYPE_EMAIL = "Email";
    public static final String ROLETYPE_FILE = "File";
    public static final String ROLETYPE_PRINT = "Print";
    public static final String ROLETYPE_CUSTOM = "Custom";

    public Server(String inSID, String inLo, String inRo, String inFa) {
        this.serverID = inSID;
        this.location = inLo;
        this.role = inRo;
        this.fault = inFa;
        assignedTech = null;
    }

    public String getServerID() {
        return serverID;
    }

    public String getLocation() {
        return location;
    }

    public String getRole() {
        return role;
    }

    public String getFault() {
        return fault;
    }

    public Technician getAssignedTech() {
        return assignedTech;
    }

    public void setAssignedTech(Technician inTech) {
        this.assignedTech = inTech;
    }

    @Override
    public String toString() {
        String temp = "Server: " + serverID + "(Role: " + role + ")\n";
        temp += "Fault: " + fault + " @ " + location + "\nAssigned to: ";

        if (assignedTech == null) {
            temp += "none assigned";
        } else {
            temp += assignedTech.toString();
        }
        return temp;
    }

}
