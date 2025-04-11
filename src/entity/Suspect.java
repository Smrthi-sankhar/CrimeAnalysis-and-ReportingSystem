package entity;
import java.time.LocalDate;

public class Suspect {
	private int suspectID;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String contactInfo;

    // Constructors
    public Suspect() {}

    public Suspect(int suspectID, String firstName, String lastName, LocalDate dateOfBirth, String gender, String contactInfo) {
        this.suspectID = suspectID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactInfo = contactInfo;
    }

    // Getters and Setters
    public int getSuspectID() { 
        return suspectID; 
    }
    public void setSuspectID(int suspectID) { 
        this.suspectID = suspectID; 
    }

    public String getFirstName() { 
        return firstName; 
    }
    public void setFirstName(String firstName) { 
        this.firstName = firstName; 
    }

    public String getLastName() { 
        return lastName; 
    }
    public void setLastName(String lastName) { 
        this.lastName = lastName; 
    }

    public LocalDate getDateOfBirth() { 
        return dateOfBirth; 
    }
    public void setDateOfBirth(LocalDate dateOfBirth) { 
        this.dateOfBirth = dateOfBirth; 
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
		return "Suspect [suspectID=" + suspectID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", contactInfo=" + contactInfo + "]";
	}
}
