package gd.rf.gamov.blooddonationcollaborationsystem;



/**
 * Created by 192.168.3.5 on 2/26/2017.
 */

public class UPosts {

    private String name;
    private String bloodgroups;
    private String units;
    private String urgent;
    private String country;
    private String state;
    private String city;
    private String hospital;
    private String relation;
    private String contact;
    private String instructions;

    public UPosts(){}

    public UPosts(String name,String bloodgroups,String units,String urgent,String country,String state,String city,String hospital,String relation,String contact,String instructions)
    {
        this.name = name;
        this.bloodgroups = bloodgroups;
        this.units = units;
        this.urgent = urgent;
        this.country = country;
        this.state =state;
        this.city = city;
        this.hospital = hospital;
        this.relation = relation;
        this.contact = contact;
        this.instructions = instructions;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodgroups() {
        return bloodgroups;
    }

    public void setBloodgroups(String bloodgroups) {
        this.bloodgroups = bloodgroups;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getUrgent() {
        return urgent;
    }

    public void setUrgent(String urgent) {
        this.urgent = urgent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
