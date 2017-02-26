package gd.rf.gamov.blooddonationcollaborationsystem;

/**
 * Created by 192.168.3.5 on 2/26/2017.
 */

public class Users {
    private String firstname;
    private String lastname;
    private String email;
    private String bloodgroup;

    public Users(){}

    public Users (String firstname,String lastname,String email,String bloodgroup)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.bloodgroup = bloodgroup;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }
}
