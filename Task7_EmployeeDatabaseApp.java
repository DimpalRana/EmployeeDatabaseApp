/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hell;

/**
 *
 * @author HITESH RANA
 */
import java.sql.*;
import java.util.Scanner;

public class Task7_EmployeeDatabaseApp {
    // Database connection details
    static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    static final String USER = "root";   // change if needed
    static final String PASS = "";       // add your MySQL password

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("✅ Connected to Database");

            while (true) {
                System.out.println("\n--- Employee Menu ---");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee Salary");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addEmployee(conn, sc);
                        break;
                    case 2:
                        viewEmployees(conn);
                        break;
                    case 3:
                        updateEmployee(conn, sc);
                        break;
                    case 4:
                        deleteEmployee(conn, sc);
                        break;
                    case 5:
                        System.out.println("👋 Exiting...");
                        return;
                    default:
                        System.out.println("❌ Invalid choice!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add Employee
    private static void addEmployee(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        String sql = "INSERT INTO employees (id, name, salary) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setDouble(3, salary);
        ps.executeUpdate();
        System.out.println("✅ Employee Added!");
    }

    // View Employees
    private static void viewEmployees(Connection conn) throws SQLException {
        String sql = "SELECT * FROM employees";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        System.out.println("\n--- Employee List ---");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") +
                               ", Name: " + rs.getString("name") +
                               ", Salary: " + rs.getDouble("salary"));
        }
    }

    // Update Employee
    private static void updateEmployee(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter Employee ID to Update: ");
        int id = sc.nextInt();
        System.out.print("Enter New Salary: ");
        double salary = sc.nextDouble();

        String sql = "UPDATE employees SET salary=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDouble(1, salary);
        ps.setInt(2, id);
        int rows = ps.executeUpdate();

        if (rows > 0) System.out.println("✅ Salary Updated!");
        else System.out.println("❌ Employee Not Found!");
    }

    // Delete Employee
    private static void deleteEmployee(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter Employee ID to Delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM employees WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int rows = ps.executeUpdate();

        if (rows > 0) System.out.println("✅ Employee Deleted!");
        else System.out.println("❌ Employee Not Found!");
    }
}
