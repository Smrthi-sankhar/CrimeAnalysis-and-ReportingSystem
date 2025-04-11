package main;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import dao.CrimeAnalysisServiceImpl;
import dao.CrimeAnalysisService;
import entity.Incident;
import entity.Report;
import exception.IncidentNumberNotFoundException;

public class mainModule {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CrimeAnalysisService service;

        try {
            try {
                service = new CrimeAnalysisServiceImpl();
            } catch (SQLException e) {
                System.out.println("oh...know!!!Failed to connect to database: " + e.getMessage());
                return;
            }

            String continueChoice;
            do {
                System.out.println("\n---  Helooo!! welcome to Crime Analysis and Reporting System ---");
                System.out.println("1. Create Incident");
                System.out.println("2. Update Incident Status");
                System.out.println("3. Get Incidents in Date Range");
                System.out.println("4. Search Incidents by Type");
                System.out.println("5. Generate Report");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); // Clear buffer

                try {
                    switch (choice) {
                        case 1:
                            System.out.print("Enter Incident Type: ");
                            String type = sc.nextLine();
                            System.out.print("Enter Date (yyyy-mm-dd): ");
                            String dateStr = sc.nextLine();
                            System.out.print("Enter Location: ");
                            String location = sc.nextLine();
                            System.out.print("Enter Description: ");
                            String desc = sc.nextLine();
                            System.out.print("Enter Status: ");
                            String status = sc.nextLine();
                            System.out.print("Enter Victim ID: ");
                            int vid = sc.nextInt();
                            System.out.print("Enter Suspect ID: ");
                            int sid = sc.nextInt();
                            System.out.print("Enter Officer ID: ");
                            int oid = sc.nextInt();
                            sc.nextLine();

                            Incident inc = new Incident(0, type, LocalDate.parse(dateStr), location, desc, status, vid, sid, oid);
                            boolean created = service.createIncident(inc);
                            System.out.println(created ? "Incident created successfully." : "Failed to create incident.");
                            break;

                        case 2:
                            System.out.print("Enter Incident ID to update: ");
                            int incidentId = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter new status: ");
                            String newStatus = sc.nextLine();
                            boolean updated = service.updateIncidentStatus(incidentId, newStatus);
                            System.out.println(updated ? "Status updated." : "Incident not found.");
                            break;

                        case 3:
                            System.out.print("Enter Start Date (yyyy-mm-dd): ");
                            LocalDate start = LocalDate.parse(sc.nextLine());
                            System.out.print("Enter End Date (yyyy-mm-dd): ");
                            LocalDate end = LocalDate.parse(sc.nextLine());

                            if (start.isAfter(end)) {
                                System.out.println("Start date must be before end date.");
                                break;
                            }

                            List<Incident> rangeList = (List<Incident>) service.getIncidentsInDateRange(start, end);
                            if (rangeList.isEmpty()) {
                                System.out.println("No incidents found in this date range.");
                            } else {
                                rangeList.forEach(System.out::println);
                            }
                            break;

                        case 4:
                            System.out.print("Enter Incident Type: ");
                            String iType = sc.nextLine();
                            List<Incident> found = (List<Incident>) service.searchIncidents(iType);
                            found.forEach(System.out::println);
                            break;

                        case 5:
                            try {
                                System.out.print("Enter Incident ID for report: ");
                                int rid = sc.nextInt();
                                Incident incForReport = new Incident();
                                incForReport.setIncidentID(rid);
                                System.out.print("Enter Officer ID: ");
                                int reportOfficerId = sc.nextInt();
                                incForReport.setOfficerID(reportOfficerId);
                                sc.nextLine();
                                System.out.print("Enter Type: ");
                                incForReport.setIncidentType(sc.nextLine());
                                System.out.print("Enter Description: ");
                                incForReport.setDescription(sc.nextLine());

                                Report report = service.generateIncidentReport(incForReport);
                                if (report != null)
                                    System.out.println("Report generated:\n" + report);
                                else
                                    System.out.println("Failed to generate report.");
                            } catch (IncidentNumberNotFoundException e) {
                                System.out.println(" " + e.getMessage());
                            }
                            break;

                        case 6:
                            System.out.println("Exiting... Goodbye!");
                            return;

                        default:
                            System.out.println("Invalid choice.");
                    }
                } catch (Exception e) {
                    System.out.println("Unexpected Error: " + e.getMessage());
                    e.printStackTrace();
                }

                System.out.print("Do you want to continue (yes/no)? ");
                continueChoice = sc.nextLine();

            } while (continueChoice.equalsIgnoreCase("yes"));

        } finally {
            sc.close();
            System.out.println("byebye............");
        }
    }
}







