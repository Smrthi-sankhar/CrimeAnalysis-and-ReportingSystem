package dao;
import entity.Incident;
import java.util.Collection;
import entity.Report;
import exception.IncidentNumberNotFoundException;

import java.time.LocalDate;


public interface CrimeAnalysisService {
	

    // Create a new incident
    public boolean createIncident(Incident incident);

    // Update the status of an incident
    public boolean updateIncidentStatus(int incidentId, String status)  throws IncidentNumberNotFoundException;

    // Get a list of incidents within a date range
    public Collection<Incident> getIncidentsInDateRange(LocalDate startDate, LocalDate endDate);

    // Search for incidents based on various criteria (e.g., incident type)
    public Collection<Incident> searchIncidents(String incidentType);

    // Generate incident report
    public Report generateIncidentReport(Incident incident) throws IncidentNumberNotFoundException;

}
