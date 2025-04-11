package entity;
import java.time.LocalDate;

public class Report {
	private int reportID;
    private int incidentID; // Foreign Key
    private int reportingOfficer; // Foreign Key
    private LocalDate reportDate;
    private String reportDetails;
    private String status;

    // Constructors
    public Report() {}

    public Report(int reportID, int incidentID, int reportingOfficer, LocalDate reportDate, String reportDetails, String status) {
        this.reportID = reportID;
        this.incidentID = incidentID;
        this.reportingOfficer = reportingOfficer;
        this.reportDate = reportDate;
        this.reportDetails = reportDetails;
        this.status = status;
    }

    // Getters and Setters
    public int getReportID() { 
        return reportID; 
    }
    public void setReportID(int reportID) { 
        this.reportID = reportID; 
    }

    public int getIncidentID() { 
        return incidentID;
    }
    public void setIncidentID(int incidentID) { 
        this.incidentID = incidentID;
    }

    public int getReportingOfficer() { 
        return reportingOfficer; 
    }
    public void setReportingOfficer(int reportingOfficer) { 
        this.reportingOfficer = reportingOfficer; 
    }

    public LocalDate getReportDate() { 
        return reportDate; 
    }
    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate; 
    }

    public String getReportDetails() { 
        return reportDetails; 
    }
    public void setReportDetails(String reportDetails) { 
        this.reportDetails = reportDetails; 
    }

    public String getStatus() { 
        return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }

	@Override
	public String toString() {
		return "Report [reportID=" + reportID + ", incidentID=" + incidentID + ", reportingOfficer=" + reportingOfficer
				+ ", reportDate=" + reportDate + ", reportDetails=" + reportDetails + ", status=" + status + "]";
	}
}
