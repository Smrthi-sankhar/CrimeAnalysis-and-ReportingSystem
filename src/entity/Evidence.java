package entity;

public class Evidence {
	private int evidenceID;
    private String description;
    private int incidentID; // Foreign Key from the incident table
    private String locationFound;

    // Default Constructor
    public Evidence() {}

    // Parameterized Constructor
    public Evidence(int evidenceID , String description, String locationFound,int incidentID) {
        this.evidenceID = evidenceID;
        this.incidentID = incidentID;
        this.locationFound = locationFound;
        this.description = description;
    }

    // Getters and Setters
    public int getEvidenceID() {
        return evidenceID;
    }

    public void setEvidenceID(int evidenceID) {
        this.evidenceID = evidenceID;
    }

    public String getLocationFound() {
        return locationFound;
    }

    public void setLocationFound(String locationFound) {
        this.locationFound = locationFound;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIncidentID() {
        return incidentID;
    }

    public void setIncidentID(int incidentID) {
        this.incidentID = incidentID;
    }

	@Override
	public String toString() {
		return "Evidence [evidenceID=" + evidenceID + ", description=" + description + ", incidentID=" + incidentID
				+ ", locationFound=" + locationFound + "]";
	}
}
