public class Passenger {
    private String name;
    private String contactInfo;
    private int iD;

    public Passenger(String name, String contactInfo, int iD){
        this.name= name;
        this.contactInfo= contactInfo;
        this.iD= iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getId() {
        return iD;
    }

    public void setId(int iD) {
        this.iD = iD;
    }

}
