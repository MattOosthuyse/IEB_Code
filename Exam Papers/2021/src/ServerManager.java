
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author moosthuyse
 */
public class ServerManager {

    private Server[] sArr = new Server[50];
    private int size = 0, tSize = 0;
    private Technician[] aTech = new Technician[100];

    public ServerManager() {
        try {
            Scanner scFile = new Scanner(new File("servers.txt"));
            while (scFile.hasNextLine()) {
                Scanner scLine = new Scanner(scFile.nextLine()).useDelimiter("#");
                String sID = scLine.next();
                String sLocation = scLine.next();
                String sFault = scLine.next();
                String sRole = scLine.next();
                sArr[size++] = new Server(sID, sLocation, sRole, sFault);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File could not be found.");
        }
    }

    public String allServers() {
        String temp = "";
        for (int i = 0; i < size; i++) {
            temp += sArr[i] + "\n";
        }
        return temp;
    }

    public String countServers(String fault, String role) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (sArr[i].getFault().equals(fault) && sArr[i].getRole().equals(role)) {
                count++;
            }
        }
        return "Number of servers with a " + fault + " fault and " + role + " role: " + count;
    }

    public void assignTechnicians() {

        try {
            Scanner scFile = new Scanner(new File("technicians.txt"));
            while (scFile.hasNextLine()) {
                Scanner scLine = new Scanner(scFile.nextLine()).useDelimiter("#");
                String techID = scLine.next();
                String techName = scLine.next();
                int experience = scLine.nextInt();
                String roleSpec = scLine.next();
                aTech[tSize++] = new Technician(techID, techName, experience, roleSpec);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Technician file not found.");
        }

        /*  Technician Rules:
            A technician must be assigned to a maximum of 4 servers.
            Technicians must only work on servers that have the same role as the 
            technician's role speciality.
            The servers do not have any priority and will be assigned in the 
            order they appear in the servers.txt file if it meets the 
            technician's requirements.
         
            Loop through the servers and find the first technician that will 
            apply to that server such that the assigned technician has not been 
            assigned more than 4 servers
         */
        for (int i = 0; i < size; i++) {
            if (sArr[i].getAssignedTech() == null) {
                for (int j = 0; j < tSize; j++) {
                    if (aTech[j].getServerCount() != 4) {
                        if (aTech[j].getRoleSpeciality().equals(sArr[i].getRole())) {
                            sArr[i].setAssignedTech(aTech[j]);
                            aTech[j].incServerCount();
                            break;
                        }
                    }
                }
            }
        }
    }

    public String getTechServerCount() {
        String temp = "";
        for (int i = 0; i < tSize; i++) {
            temp += "TechID: " + aTech[i].getTechID() + "\nName: " + aTech[i].getName() + "\nNumber of servers managed: " + aTech[i].getServerCount() + "\n";
        }
        return temp;
    }
}
