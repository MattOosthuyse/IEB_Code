/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author moosthuyse
 */
public class Technician {

    private String techID, name, roleSpeciality;
    private int experience, serverCount;
    

    public Technician(String inTID, String inN, int inE, String inR) {
        this.techID = inTID;
        this.name = inN;
        this.experience = inE;
        this.roleSpeciality = inR;
        this.serverCount = 0;
    }

    public String getTechID() {
        return techID;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public String getRoleSpeciality() {
        return roleSpeciality;
    }
    
    public int getServerCount() {
        return serverCount;
    }
    
    public void incServerCount() {
        serverCount++;
    }
    
    @Override
    public String toString() {
        return name + ", " + techID + ", " + experience + " year(s), " + roleSpeciality;
    }
}
