package entity;
import java.time.LocalDate;

public class Victim {
	//instance variable
	private int victimID;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String gender;
	private String contactInfo;
	
	//default constructor
	public Victim()  {}
	
	//parameterized constructor
	public Victim(int victimID,String firstName,String lastName,LocalDate dateOfBirth,String gender,String contactInfo) {
		this.victimID=victimID;
		this.firstName=firstName;
		this.dateOfBirth=dateOfBirth;
		this.gender=gender;
		this.contactInfo=contactInfo;
	}
	
	//getter and setter
	public int getVictimID() {
		return victimID;
	}
	public void setVictimID(int victimID) {
		this.victimID=victimID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth=dateOfBirth;
	}
	public String getGender() { 
        return gender; 
    }
    public void setGender(String gender) { 
        this.gender = gender; 
    }

    public String getContactInfo() { 
        return contactInfo; 
    }
    public void setContactInfo(String contactInfo) { 
        this.contactInfo = contactInfo; 
    }

	@Override
	public String toString() {
		return "Victim [victimID=" + victimID + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", contactInfo=" + contactInfo + "]";
	}
    
}
