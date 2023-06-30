
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
    private int size = 0;

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
        return "Number of servers with a " + fault + " fault and "+ role + " role: " + count;
    }
}
