package dao;
import entity.Incident;
import entity.Report;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDate;
import exception.IncidentNumberNotFoundException;
import util.DBConnUtil;


public class CrimeAnalysisServiceImpl implements CrimeAnalysisService {

    private static Connection connection;

    public CrimeAnalysisServiceImpl()  throws SQLException {
        connection =DBConnUtil.getDbConnection();
    }

    @Override
    public boolean createIncident(Incident incident) {
        // DB logic to insert incident
		try {
		PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Incidents (IncidentID, IncidentType, IncidentDate, Location, Description, Status, VictimID, SuspectID, OfficerID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		pstmt.setInt(1, incident.getIncidentID());
		pstmt.setString(2, incident.getIncidentType());
		pstmt.setDate(3, java.sql.Date.valueOf(incident.getIncidentDate()));
		pstmt.setString(4, incident.getLocation());
		pstmt.setString(5, incident.getDescription());
		pstmt.setString(6, incident.getStatus());
		pstmt.setInt(7, incident.getVictimID());
		pstmt.setInt(8, incident.getSuspectID());
		pstmt.setInt(9, incident.getOfficerID());

		int rows = pstmt.executeUpdate();
		return rows > 0;

		} 
		catch (SQLException e) 
		{
		e.printStackTrace();
		}
        return false; // placeholder
    }

    @Override
    public boolean updateIncidentStatus(int incidentId, String status) throws IncidentNumberNotFoundException {
        // DB logic to update status    	
        try {
        	PreparedStatement pstmt = connection.prepareStatement("UPDATE Incidents SET Status = ? WHERE IncidentID = ?"); 
            pstmt.setString(1, status);
            pstmt.setInt(2, incidentId);

            int rows = pstmt.executeUpdate();

            if (rows == 0) {
                throw new IncidentNumberNotFoundException("Incident with ID " + incidentId + " not found.");
            }

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return false;
    }

    @Override
    public Collection<Incident> getIncidentsInDateRange(LocalDate startDate, LocalDate endDate) {
        // DB logic to fetch by date range
    	 List<Incident> incidents = new ArrayList<>();
    	    try {
    	    	PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Incidents WHERE IncidentDate BETWEEN ? AND ?"); 
    	        pstmt.setDate(1, java.sql.Date.valueOf(startDate));
    	        pstmt.setDate(2, java.sql.Date.valueOf(endDate));

    	        ResultSet rs = pstmt.executeQuery();

    	        while (rs.next()) {
    	            Incident incident = new Incident(
    	                rs.getInt("IncidentID"),
    	                rs.getString("IncidentType"),
    	                rs.getDate("IncidentDate").toLocalDate(),
    	                rs.getString("Location"),
    	                rs.getString("Description"),
    	                rs.getString("Status"),
    	                rs.getInt("VictimID"),
    	                rs.getInt("SuspectID"),
    	                rs.getInt("OfficerID")
    	            );
    	            incidents.add(incident);
    	        }

    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	    return incidents;
    }

    @Override
    public Collection<Incident> searchIncidents(String incidentType) {
        // DB logic to fetch by incident type
    	List<Incident> incidents = new ArrayList<>();       
        try {
        	PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Incidents WHERE IncidentType = ?"); 
            pstmt.setString(1, incidentType);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Incident incident = new Incident(
                    rs.getInt("IncidentID"),
                    rs.getString("IncidentType"),
                    rs.getDate("IncidentDate").toLocalDate(),
                    rs.getString("Location"),
                    rs.getString("Description"),
                    rs.getString("Status"),
                    rs.getInt("VictimID"),
                    rs.getInt("SuspectID"),
                    rs.getInt("OfficerID")
                );
                incidents.add(incident);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return incidents;
    
    }

    @Override
    public Report generateIncidentReport(Incident incident) {
        // DB logic to generate and return report
    	
        String reportDetails = "Incident Type: " + incident.getIncidentType() + ", Description: " + incident.getDescription();

        try {
        	PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Reports (IncidentID, ReportingOfficer, ReportDate, ReportDetails, Status) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS); 
        
            pstmt.setInt(1, incident.getIncidentID());
            pstmt.setInt(2, incident.getOfficerID()); // assuming officer who reported
            pstmt.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            pstmt.setString(4, reportDetails);
            pstmt.setString(5, "Draft");

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    int reportId = rs.getInt(1);
                    return new Report(reportId, incident.getIncidentID(), incident.getOfficerID(), LocalDate.now(), reportDetails, "Draft");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

