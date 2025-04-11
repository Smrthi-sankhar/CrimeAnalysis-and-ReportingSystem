package entity;

public class LawEnforcementAgency {
	private int agencyID;
    private String agencyName;
    private String jurisdiction;
    private String contactInfo;

    // Constructors
    public LawEnforcementAgency() {}

    public LawEnforcementAgency(int agencyID, String agencyName, String jurisdiction, String contactInfo) {
        this.agencyID = agencyID;
        this.agencyName = agencyName;
        this.jurisdiction = jurisdiction;
        this.contactInfo = contactInfo;
    }

    // Getters and Setters
    public int getAgencyID() { 
        return agencyID;
     }
    public void setAgencyID(int agencyID) { 
        this.agencyID = agencyID; 
    }

    public String getAgencyName() { 
        return agencyName; 
    }
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName; 
    }

    public String getJurisdiction() { 
        return jurisdiction;
    }
    public void setJurisdiction(String jurisdiction) { 
        this.jurisdiction = jurisdiction; 
    }

    public String getContactInfo() { 
        return contactInfo; 
    }
    public void setContactInfo(String contactInfo) { 
        this.contactInfo = contactInfo; 
    }

	@Override
	public String toString() {
		return "LawEnforcementAgency [agencyID=" + agencyID + ", agencyName=" + agencyName + ", jurisdiction="
				+ jurisdiction + ", contactInfo=" + contactInfo + "]";
	}
}
