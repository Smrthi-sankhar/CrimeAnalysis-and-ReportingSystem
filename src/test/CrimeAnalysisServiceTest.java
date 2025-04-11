package test;

import dao.CrimeAnalysisServiceImpl;
import dao.CrimeAnalysisService;
import entity.Incident;
import exception.IncidentNumberNotFoundException;

import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CrimeAnalysisServiceTest {

    private static CrimeAnalysisService service;

    @BeforeAll
    public static void setUp() throws SQLException {
        service = new CrimeAnalysisServiceImpl();
    }

    @Test
    public void testCreateIncident() {
        Incident inc = new Incident(0, "Test Type", LocalDate.now(), "Test Location", "Test Description", "Open", 1, 1, 1);
        boolean result = service.createIncident(inc);
        assertTrue(result, "Incident should be created successfully");
    }

    @Test
    public void testUpdateIncidentStatus() throws IncidentNumberNotFoundException {
        boolean result = service.updateIncidentStatus(4, "Closed"); 
        assertTrue(result, "Status should be updated");
    }
}

