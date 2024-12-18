/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class ConnectDB {

    //Objects 
    static Scanner userInput = new Scanner(System.in);
    static Connection connection;
    //Variables
    static int selectedMenuOption;

    public static void main(String[] args) throws SQLException {
        System.out.println("whatever");

        String url = "jdbc:sqlserver://Rahat-Ashik\\SQLEXPRESS:1433;databaseName=Inventory Management";
        String user = "sa";
        String pass = "rahat073";

        System.out.println(url);
        connection = DriverManager.getConnection(url, user, pass);
            
        queries_10();
       
    }
    
    static void queries_01() {
        /* queries_01 
        How many goods were sold on a
	1)Specific date/month/year
	2)From YYYY-MM-DD to YYYY-MM-DD
         */
        while (true) {

            System.out.println("\nHow many goods were sold on a: \n"
                    + "1.-> Specific date\n"
                    + "2.-> Specific month\n"
                    + "3.-> Specific year\n\n"
                    + "4.-> From YYYY-MM-DD to YYYY-MM-DD\n\n"
                    + "5.-> EXIT\n");
            System.out.println("Select Any Option:");
            selectedMenuOption = userInput.nextInt();

            if (selectedMenuOption == 1) {

                System.out.print("Enter Date: ");
                userInput.nextLine();
                String inputDate = userInput.nextLine();

                try {

                    String sql = "SELECT SUM(Qty) AS goods_sold FROM order_details WHERE PaidStatus=1 AND SoldDate = '" + inputDate + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\ngoods_sold");
                    while (result.next()) {

                        int goodsSold = result.getInt("goods_sold");

                        System.out.println(goodsSold);

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 2) {

                System.out.print("Enter Month: ");
                int inputMonth = userInput.nextInt();
                System.out.print("Enter Year: ");
                int inputYear = userInput.nextInt();

                try {

                    String sql = "SELECT SUM(Qty) AS goods_sold FROM order_details WHERE PaidStatus=1 AND MONTH(SoldDate) = '" + inputMonth + "' AND YEAR(SoldDate) = '" + inputYear + "' ";
                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("\nRESULT:");
                    System.out.println("goods_sold");
                    while (result.next()) {

                        int goodsSold = result.getInt("goods_sold");

                        System.out.println(goodsSold);

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 3) {

                System.out.print("Enter Year: ");
                int inputYear = userInput.nextInt();

                try {

                    String sql = "SELECT SUM(Qty) AS goods_sold FROM order_details WHERE PaidStatus=1 AND YEAR(SoldDate) = '" + inputYear + "' ";
                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("\nRESULT:");
                    System.out.println("goods_sold");
                    while (result.next()) {

                        int goodsSold = result.getInt("goods_sold");

                        System.out.println(goodsSold);

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 4) {

                System.out.print("Enter Date From: ");
                userInput.nextLine();
                String inputDateFrom = userInput.nextLine();
                System.out.print("Enter Date To: ");
                String inputDateTo = userInput.nextLine();
                try {

                    String sql = "SELECT SUM(Qty) AS goods_sold FROM order_details WHERE PaidStatus=1 AND SoldDate BETWEEN '" + inputDateFrom + "' AND  '" + inputDateTo + "' ";
                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("\nRESULT:");
                    System.out.println("goods_sold");
                    while (result.next()) {

                        int goodsSold = result.getInt("goods_sold");

                        System.out.println(goodsSold);

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 5) {
                System.out.println("EXIT PROGRAM SUCCESSFUL");
                break;
            }

        }

    }

    static void queries_02() {
        /* queries_02 
            1.Income from dd/mm/yyyy to dd/mm/yyyy
            2.Profit from dd/mm/yyyy to dd/mm/yyyy
         */
        while (true) {

            System.out.println("\n"
                    + "1.-> Income from dd/mm/yyyy to dd/mm/yyyy\n"
                    + "2.-> Profit from dd/mm/yyyy to dd/mm/yyyy\n"
                    + "3.-> EXIT\n");
            System.out.println("Select Any Option:");
            selectedMenuOption = userInput.nextInt();

            if (selectedMenuOption == 1) {

                System.out.print("Enter Date From: ");
                userInput.nextLine();
                String inputDateFrom = userInput.nextLine();
                System.out.print("Enter Date To: ");
                String inputDateTo = userInput.nextLine();
                try {

                    String sql = "SELECT SUM(FinalPrice) AS Income FROM order_details WHERE PaidStatus=1 AND SoldDate BETWEEN '" + inputDateFrom + "' AND  '" + inputDateTo + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\nIncome");
                    while (result.next()) {

                        int income = result.getInt("Income");

                        System.out.println(income);

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 2) {

                System.out.print("Enter Date From: ");
                userInput.nextLine();
                String inputDateFrom = userInput.nextLine();
                System.out.print("Enter Date To: ");
                String inputDateTo = userInput.nextLine();
                try {

                    String sql = "SELECT SUM(FinalPrice-tax) AS Profit FROM order_details WHERE PaidStatus=1 AND SoldDate BETWEEN '" + inputDateFrom + "' AND  '" + inputDateTo + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n Profit");
                    while (result.next()) {

                        int profit = result.getInt("Profit");

                        System.out.println(profit);

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 3) {
                System.out.println("EXIT PROGRAM SUCCESSFUL");
                break;
            }

        }

    }

    static void queries_03() {
        /* queries_03 
        Select Employees according to
	1.Salary
	2.Experience (in months)
	3.Address
	4.Gender (M/F)
	5.Status (employed/fired)
	6.Position (Manager/ Salesperson/ Cashier)
         */

        while (true) {

            System.out.println(" Select Employees according to: \n"
                    + "1.-> Salary\n"
                    + "2.-> Experience (in months)\n"
                    + "3.-> Address\n"
                    + "4.-> Gender (M/F)\n"
                    + "5.-> Status (employed/fired)\n"
                    + "6.-> Position (Manager/ Salesperson/ Cashier)\n"
                    + "7.-> EXIT\n");
            System.out.println("Select Any Option:");
            selectedMenuOption = userInput.nextInt();

            if (selectedMenuOption == 1) {

                System.out.print("Enter Salary Range From: ");
                int salaryFrom = userInput.nextInt();
                System.out.print("Enter Salary Range From: ");
                int salaryTo = userInput.nextInt();

                try {

                    String sql = "Select * From Employee WHERE Salary BETWEEN '" + salaryFrom + "' AND  '" + salaryTo + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n EmployeeId   "
                            + "EmployeePass    "
                            + "Name    "
                            + "DOB     "
                            + "NID     "
                            + "PhoneNumber     "
                            + "Email       "
                            + "Address    "
                            + "EmployStatus    "
                            + "Position    "
                            + "JoiningDate     "
                            + "Salary      "
                            + "Experience   "
                            + "Gender");
                    while (result.next()) {

                        int employeeID = result.getInt("EmployeeId");
                        String employeePass = result.getString("EmployeePass");
                        String employeeName = result.getString("Name");
                        String employeeDOB = result.getString("DOB");
                        int employeeNID = result.getInt("NID");
                        int employeePhoneNumber = result.getInt("PhoneNumber");
                        String employeeEmail = result.getString("Email");
                        String employeeAddress = result.getString("Address");
                        int employeeStatus = result.getInt("EmployStatus");
                        String employeePosition = result.getString("Position");
                        String employeeJoiningDate = result.getString("JoiningDate");
                        int employeeSalary = result.getInt("Salary");
                        int employeeExperience = result.getInt("Experience");
                        String employeeGender = result.getString("Gender");

                        System.out.println("\n" + employeeID + "    "
                                + employeePass + "    "
                                + employeeName + "  "
                                + employeeDOB + "    "
                                + employeeNID + "    "
                                + employeePhoneNumber + "  "
                                + employeeEmail + "    "
                                + employeeAddress + "    "
                                + employeeStatus + "  "
                                + employeePosition + "    "
                                + employeeJoiningDate + "   "
                                + employeeSalary + "    "
                                + employeeExperience + "    "
                                + employeeGender + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 2) {

                System.out.print("Enter Employee(in Months): ");
                int experienceMonths = userInput.nextInt();

                try {

                    String sql = "Select * From Employee WHERE Experience>'" + experienceMonths + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n EmployeeId   "
                            + "EmployeePass    "
                            + "Name    "
                            + "DOB     "
                            + "NID     "
                            + "PhoneNumber     "
                            + "Email       "
                            + "Address    "
                            + "EmployStatus    "
                            + "Position    "
                            + "JoiningDate     "
                            + "Salary      "
                            + "Experience   "
                            + "Gender");
                    while (result.next()) {

                        int employeeID = result.getInt("EmployeeId");
                        String employeePass = result.getString("EmployeePass");
                        String employeeName = result.getString("Name");
                        String employeeDOB = result.getString("DOB");
                        int employeeNID = result.getInt("NID");
                        int employeePhoneNumber = result.getInt("PhoneNumber");
                        String employeeEmail = result.getString("Email");
                        String employeeAddress = result.getString("Address");
                        int employeeStatus = result.getInt("EmployStatus");
                        String employeePosition = result.getString("Position");
                        String employeeJoiningDate = result.getString("JoiningDate");
                        int employeeSalary = result.getInt("Salary");
                        int employeeExperience = result.getInt("Experience");
                        String employeeGender = result.getString("Gender");

                        System.out.println("\n" + employeeID + "    "
                                + employeePass + "    "
                                + employeeName + "  "
                                + employeeDOB + "    "
                                + employeeNID + "    "
                                + employeePhoneNumber + "  "
                                + employeeEmail + "    "
                                + employeeAddress + "    "
                                + employeeStatus + "  "
                                + employeePosition + "    "
                                + employeeJoiningDate + "   "
                                + employeeSalary + "    "
                                + employeeExperience + "    "
                                + employeeGender + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 3) {

                System.out.print("Enter Address: ");
                userInput.nextLine();
                String address = userInput.nextLine();

                try {

                    String sql = "Select * From Employee WHERE Address LIKE'" + address + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n EmployeeId   "
                            + "EmployeePass    "
                            + "Name    "
                            + "DOB     "
                            + "NID     "
                            + "PhoneNumber     "
                            + "Email       "
                            + "Address    "
                            + "EmployStatus    "
                            + "Position    "
                            + "JoiningDate     "
                            + "Salary      "
                            + "Experience   "
                            + "Gender");
                    while (result.next()) {

                        int employeeID = result.getInt("EmployeeId");
                        String employeePass = result.getString("EmployeePass");
                        String employeeName = result.getString("Name");
                        String employeeDOB = result.getString("DOB");
                        int employeeNID = result.getInt("NID");
                        int employeePhoneNumber = result.getInt("PhoneNumber");
                        String employeeEmail = result.getString("Email");
                        String employeeAddress = result.getString("Address");
                        int employeeStatus = result.getInt("EmployStatus");
                        String employeePosition = result.getString("Position");
                        String employeeJoiningDate = result.getString("JoiningDate");
                        int employeeSalary = result.getInt("Salary");
                        int employeeExperience = result.getInt("Experience");
                        String employeeGender = result.getString("Gender");

                        System.out.println("\n" + employeeID + "    "
                                + employeePass + "    "
                                + employeeName + "  "
                                + employeeDOB + "    "
                                + employeeNID + "    "
                                + employeePhoneNumber + "  "
                                + employeeEmail + "    "
                                + employeeAddress + "    "
                                + employeeStatus + "  "
                                + employeePosition + "    "
                                + employeeJoiningDate + "   "
                                + employeeSalary + "    "
                                + employeeExperience + "    "
                                + employeeGender + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 4) {

                System.out.print("Enter Gender: ");
                userInput.nextLine();
                String gender = userInput.nextLine();

                try {

                    String sql = "Select * From Employee WHERE Gender ='" + gender + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n EmployeeId   "
                            + "EmployeePass    "
                            + "Name    "
                            + "DOB     "
                            + "NID     "
                            + "PhoneNumber     "
                            + "Email       "
                            + "Address    "
                            + "EmployStatus    "
                            + "Position    "
                            + "JoiningDate     "
                            + "Salary      "
                            + "Experience   "
                            + "Gender");
                    while (result.next()) {

                        int employeeID = result.getInt("EmployeeId");
                        String employeePass = result.getString("EmployeePass");
                        String employeeName = result.getString("Name");
                        String employeeDOB = result.getString("DOB");
                        int employeeNID = result.getInt("NID");
                        int employeePhoneNumber = result.getInt("PhoneNumber");
                        String employeeEmail = result.getString("Email");
                        String employeeAddress = result.getString("Address");
                        int employeeStatus = result.getInt("EmployStatus");
                        String employeePosition = result.getString("Position");
                        String employeeJoiningDate = result.getString("JoiningDate");
                        int employeeSalary = result.getInt("Salary");
                        int employeeExperience = result.getInt("Experience");
                        String employeeGender = result.getString("Gender");

                        System.out.println("\n" + employeeID + "    "
                                + employeePass + "    "
                                + employeeName + "  "
                                + employeeDOB + "    "
                                + employeeNID + "    "
                                + employeePhoneNumber + "  "
                                + employeeEmail + "    "
                                + employeeAddress + "    "
                                + employeeStatus + "  "
                                + employeePosition + "    "
                                + employeeJoiningDate + "   "
                                + employeeSalary + "    "
                                + employeeExperience + "    "
                                + employeeGender + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 5) {

                System.out.print("Enter Employee Status: ");
                byte inputEmployeeStatus = userInput.nextByte();

                try {

                    String sql = "Select * From Employee WHERE EmployStatus ='" + inputEmployeeStatus + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n EmployeeId   "
                            + "EmployeePass    "
                            + "Name    "
                            + "DOB     "
                            + "NID     "
                            + "PhoneNumber     "
                            + "Email       "
                            + "Address    "
                            + "EmployStatus    "
                            + "Position    "
                            + "JoiningDate     "
                            + "Salary      "
                            + "Experience   "
                            + "Gender");
                    while (result.next()) {

                        int employeeID = result.getInt("EmployeeId");
                        String employeePass = result.getString("EmployeePass");
                        String employeeName = result.getString("Name");
                        String employeeDOB = result.getString("DOB");
                        int employeeNID = result.getInt("NID");
                        int employeePhoneNumber = result.getInt("PhoneNumber");
                        String employeeEmail = result.getString("Email");
                        String employeeAddress = result.getString("Address");
                        int employeeStatus = result.getInt("EmployStatus");
                        String employeePosition = result.getString("Position");
                        String employeeJoiningDate = result.getString("JoiningDate");
                        int employeeSalary = result.getInt("Salary");
                        int employeeExperience = result.getInt("Experience");
                        String employeeGender = result.getString("Gender");

                        System.out.println("\n" + employeeID + "    "
                                + employeePass + "    "
                                + employeeName + "  "
                                + employeeDOB + "    "
                                + employeeNID + "    "
                                + employeePhoneNumber + "  "
                                + employeeEmail + "    "
                                + employeeAddress + "    "
                                + employeeStatus + "  "
                                + employeePosition + "    "
                                + employeeJoiningDate + "   "
                                + employeeSalary + "    "
                                + employeeExperience + "    "
                                + employeeGender + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 6) {

                System.out.print("Enter Employee Position: ");
                userInput.nextLine();
                String inputEmployeePosition = userInput.nextLine();

                try {

                    String sql = "Select * From Employee WHERE Position ='" + inputEmployeePosition + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n EmployeeId   "
                            + "EmployeePass    "
                            + "Name    "
                            + "DOB     "
                            + "NID     "
                            + "PhoneNumber     "
                            + "Email       "
                            + "Address    "
                            + "EmployStatus    "
                            + "Position    "
                            + "JoiningDate     "
                            + "Salary      "
                            + "Experience   "
                            + "Gender");
                    while (result.next()) {

                        int employeeID = result.getInt("EmployeeId");
                        String employeePass = result.getString("EmployeePass");
                        String employeeName = result.getString("Name");
                        String employeeDOB = result.getString("DOB");
                        int employeeNID = result.getInt("NID");
                        int employeePhoneNumber = result.getInt("PhoneNumber");
                        String employeeEmail = result.getString("Email");
                        String employeeAddress = result.getString("Address");
                        int employeeStatus = result.getInt("EmployStatus");
                        String employeePosition = result.getString("Position");
                        String employeeJoiningDate = result.getString("JoiningDate");
                        int employeeSalary = result.getInt("Salary");
                        int employeeExperience = result.getInt("Experience");
                        String employeeGender = result.getString("Gender");

                        System.out.println("\n" + employeeID + "    "
                                + employeePass + "    "
                                + employeeName + "  "
                                + employeeDOB + "    "
                                + employeeNID + "    "
                                + employeePhoneNumber + "  "
                                + employeeEmail + "    "
                                + employeeAddress + "    "
                                + employeeStatus + "  "
                                + employeePosition + "    "
                                + employeeJoiningDate + "   "
                                + employeeSalary + "    "
                                + employeeExperience + "    "
                                + employeeGender + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 7) {
                System.out.println("EXIT PROGRAM SUCCESSFUL");
                break;
            }

        }

    }

    static void queries_04() {
        /* queries_04 
        Show all Customers  ill do this - ALVEE
            1.in a particular area x
            2.Handled by particular employee (eid)
            3.Who spent more than xx bdt 
            4.Who bought more than x qty of items
            5.Who didn’t buy something from xDate - yDate
            6.Who bought something from xDate-yDate
         */
        while (true) {

            System.out.println(" Show all Customers: \n"
                    + "1.-> In a particular area: \n"
                    + "2.-> Handled by particular employee (eid): \n"
                    + "3.-> Who spent more than(bdt) :\n"
                    + "4.-> Who bought more than x qty of items\n"
                    + "5.-> Who didn’t buy something from xDate - yDate\n"
                    + "6.-> Who bought something from xDate-yDate\n"
                    + "7.-> EXIT\n");
            System.out.println("Select Any Option:");
            selectedMenuOption = userInput.nextInt();

            if (selectedMenuOption == 1) {

                System.out.print("Enter Area: ");
                userInput.nextLine();
                String area = userInput.nextLine();

                try {

                    String sql = "Select * From Customer WHERE Address LIKE '" + area + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n CustomerId   "
                            + "EmployeeId    "
                            + "Name    "
                            + "Address     "
                            + "PhoneNumber     "
                            + "Email       "
                            + "LastPurchase    "
                            + "PurchaseQty    "
                            + "SpentMoney     "
                            + "Gender      ");
                    while (result.next()) {

                        int customerID = result.getInt("CustomerId");
                        int employeeID = result.getInt("EmployeeId");
                        String customerName = result.getString("Name");
                        String customerAddress = result.getString("Address");
                        int customerPhoneNumber = result.getInt("PhoneNumber");
                        String customerEmail = result.getString("Email");
                        String customerLastPurchase = result.getString("LastPurchase");
                        int customerPurchaseQty = result.getInt("PurchaseQty");
                        int customerSpentMoney = result.getInt("SpentMoney");
                        String customerGender = result.getString("Gender");

                        System.out.println("\n" + customerID + "    "
                                + employeeID + "    "
                                + customerName + "  "
                                + customerAddress + "    "
                                + customerPhoneNumber + "    "
                                + customerEmail + "  "
                                + customerLastPurchase + "    "
                                + customerPurchaseQty + "  "
                                + customerSpentMoney + "    "
                                + customerGender + "  ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 2) {

                System.out.print("Enter Exmployee (ID) : ");
                int inputEmployeeID = userInput.nextInt();

                try {

                    String sql = "Select * From Customer WHERE EmployeeId = '" + inputEmployeeID + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n CustomerId   "
                            + "EmployeeId    "
                            + "Name    "
                            + "Address     "
                            + "PhoneNumber     "
                            + "Email       "
                            + "LastPurchase    "
                            + "PurchaseQty    "
                            + "SpentMoney     "
                            + "Gender      ");
                    while (result.next()) {

                        int customerID = result.getInt("CustomerId");
                        int employeeID = result.getInt("EmployeeId");
                        String customerName = result.getString("Name");
                        String customerAddress = result.getString("Address");
                        int customerPhoneNumber = result.getInt("PhoneNumber");
                        String customerEmail = result.getString("Email");
                        String customerLastPurchase = result.getString("LastPurchase");
                        int customerPurchaseQty = result.getInt("PurchaseQty");
                        int customerSpentMoney = result.getInt("SpentMoney");
                        String customerGender = result.getString("Gender");

                        System.out.println("\n" + customerID + "    "
                                + employeeID + "    "
                                + customerName + "  "
                                + customerAddress + "    "
                                + customerPhoneNumber + "    "
                                + customerEmail + "  "
                                + customerLastPurchase + "    "
                                + customerPurchaseQty + "  "
                                + customerSpentMoney + "    "
                                + customerGender + "  ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 3) {

                System.out.print("Enter Amount (BDT): ");
                int spentAmount = userInput.nextInt();

                try {

                    String sql = "Select * From Customer WHERE SpentMoney >'" + spentAmount + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n CustomerId   "
                            + "EmployeeId    "
                            + "Name    "
                            + "Address     "
                            + "PhoneNumber     "
                            + "Email       "
                            + "LastPurchase    "
                            + "PurchaseQty    "
                            + "SpentMoney     "
                            + "Gender      ");
                    while (result.next()) {

                        int customerID = result.getInt("CustomerId");
                        int employeeID = result.getInt("EmployeeId");
                        String customerName = result.getString("Name");
                        String customerAddress = result.getString("Address");
                        int customerPhoneNumber = result.getInt("PhoneNumber");
                        String customerEmail = result.getString("Email");
                        String customerLastPurchase = result.getString("LastPurchase");
                        int customerPurchaseQty = result.getInt("PurchaseQty");
                        int customerSpentMoney = result.getInt("SpentMoney");
                        String customerGender = result.getString("Gender");

                        System.out.println("\n" + customerID + "    "
                                + employeeID + "    "
                                + customerName + "  "
                                + customerAddress + "    "
                                + customerPhoneNumber + "    "
                                + customerEmail + "  "
                                + customerLastPurchase + "    "
                                + customerPurchaseQty + "  "
                                + customerSpentMoney + "    "
                                + customerGender + "  ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 4) {

                System.out.print("Enter Quantity: ");
                int purchaseQty = userInput.nextInt();

                try {

                    String sql = "Select * From Customer WHERE PurchaseQty >'" + purchaseQty + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n CustomerId   "
                            + "EmployeeId    "
                            + "Name    "
                            + "Address     "
                            + "PhoneNumber     "
                            + "Email       "
                            + "LastPurchase    "
                            + "PurchaseQty    "
                            + "SpentMoney     "
                            + "Gender      ");
                    while (result.next()) {

                        int customerID = result.getInt("CustomerId");
                        int employeeID = result.getInt("EmployeeId");
                        String customerName = result.getString("Name");
                        String customerAddress = result.getString("Address");
                        int customerPhoneNumber = result.getInt("PhoneNumber");
                        String customerEmail = result.getString("Email");
                        String customerLastPurchase = result.getString("LastPurchase");
                        int customerPurchaseQty = result.getInt("PurchaseQty");
                        int customerSpentMoney = result.getInt("SpentMoney");
                        String customerGender = result.getString("Gender");

                        System.out.println("\n" + customerID + "    "
                                + employeeID + "    "
                                + customerName + "  "
                                + customerAddress + "    "
                                + customerPhoneNumber + "    "
                                + customerEmail + "  "
                                + customerLastPurchase + "    "
                                + customerPurchaseQty + "  "
                                + customerSpentMoney + "    "
                                + customerGender + "  ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 5) {

                System.out.print("Enter Date from: ");
                userInput.nextLine();
                String dateFrom = userInput.nextLine();
                System.out.print("Enter Date To: ");
                String dateTo = userInput.nextLine();

                try {

                    String sql = "Select * From Customer WHERE customerId NOT IN (SELECT customerId FROM order_details WHERE soldDate BETWEEN '" + dateFrom + "' AND '" + dateTo + "' )  ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n CustomerId   "
                            + "EmployeeId    "
                            + "Name    "
                            + "Address     "
                            + "PhoneNumber     "
                            + "Email       "
                            + "LastPurchase    "
                            + "PurchaseQty    "
                            + "SpentMoney     "
                            + "Gender      ");
                    while (result.next()) {

                        int customerID = result.getInt("CustomerId");
                        int employeeID = result.getInt("EmployeeId");
                        String customerName = result.getString("Name");
                        String customerAddress = result.getString("Address");
                        int customerPhoneNumber = result.getInt("PhoneNumber");
                        String customerEmail = result.getString("Email");
                        String customerLastPurchase = result.getString("LastPurchase");
                        int customerPurchaseQty = result.getInt("PurchaseQty");
                        int customerSpentMoney = result.getInt("SpentMoney");
                        String customerGender = result.getString("Gender");

                        System.out.println("\n" + customerID + "    "
                                + employeeID + "    "
                                + customerName + "  "
                                + customerAddress + "    "
                                + customerPhoneNumber + "    "
                                + customerEmail + "  "
                                + customerLastPurchase + "    "
                                + customerPurchaseQty + "  "
                                + customerSpentMoney + "    "
                                + customerGender + "  ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 6) {

                System.out.print("Enter Date from: ");
                userInput.nextLine();
                String dateFrom = userInput.nextLine();
                System.out.print("Enter Date To: ");
                String dateTo = userInput.nextLine();

                try {

                    String sql = "Select * From Customer WHERE customerId IN (SELECT customerId FROM order_details WHERE soldDate BETWEEN '" + dateFrom + "' AND '" + dateTo + "' )  ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n CustomerId   "
                            + "EmployeeId    "
                            + "Name    "
                            + "Address     "
                            + "PhoneNumber     "
                            + "Email       "
                            + "LastPurchase    "
                            + "PurchaseQty    "
                            + "SpentMoney     "
                            + "Gender      ");
                    while (result.next()) {

                        int customerID = result.getInt("CustomerId");
                        int employeeID = result.getInt("EmployeeId");
                        String customerName = result.getString("Name");
                        String customerAddress = result.getString("Address");
                        int customerPhoneNumber = result.getInt("PhoneNumber");
                        String customerEmail = result.getString("Email");
                        String customerLastPurchase = result.getString("LastPurchase");
                        int customerPurchaseQty = result.getInt("PurchaseQty");
                        int customerSpentMoney = result.getInt("SpentMoney");
                        String customerGender = result.getString("Gender");

                        System.out.println("\n" + customerID + "    "
                                + employeeID + "    "
                                + customerName + "  "
                                + customerAddress + "    "
                                + customerPhoneNumber + "    "
                                + customerEmail + "  "
                                + customerLastPurchase + "    "
                                + customerPurchaseQty + "  "
                                + customerSpentMoney + "    "
                                + customerGender + "  ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 7) {
                System.out.println("EXIT PROGRAM SUCCESSFUL");
                break;
            }

        }

    }

    static void queries_05() {
        /* queries_05 
        Search a customer by   ill do this - ALVEE
            1.Cid
            2.Phone number
            3.Email
            4.Name
         */

        while (true) {

            System.out.println(" Search a customer by: \n"
                    + "1.-> Customer ID: \n"
                    + "2.-> Phone number: \n"
                    + "3.-> Email:\n"
                    + "4.-> Name:\n"
                    + "5.-> EXIT\n");
            System.out.println("Select Any Option:");
            selectedMenuOption = userInput.nextInt();

            if (selectedMenuOption == 1) {

                System.out.print("Enter Customer ID: ");
                int inputCustomerID = userInput.nextInt();

                try {

                    String sql = "Select * From Customer WHERE CustomerId = '" + inputCustomerID + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n CustomerId   "
                            + "EmployeeId    "
                            + "Name    "
                            + "Address     "
                            + "PhoneNumber     "
                            + "Email       "
                            + "LastPurchase    "
                            + "PurchaseQty    "
                            + "SpentMoney     "
                            + "Gender      ");
                    while (result.next()) {

                        int customerID = result.getInt("CustomerId");
                        int employeeID = result.getInt("EmployeeId");
                        String customerName = result.getString("Name");
                        String customerAddress = result.getString("Address");
                        int customerPhoneNumber = result.getInt("PhoneNumber");
                        String customerEmail = result.getString("Email");
                        String customerLastPurchase = result.getString("LastPurchase");
                        int customerPurchaseQty = result.getInt("PurchaseQty");
                        int customerSpentMoney = result.getInt("SpentMoney");
                        String customerGender = result.getString("Gender");

                        System.out.println("\n" + customerID + "    "
                                + employeeID + "    "
                                + customerName + "  "
                                + customerAddress + "    "
                                + customerPhoneNumber + "    "
                                + customerEmail + "  "
                                + customerLastPurchase + "    "
                                + customerPurchaseQty + "  "
                                + customerSpentMoney + "    "
                                + customerGender + "  ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 2) {

                System.out.print("Enter Phone Number: ");
                int inputCustomerPhoneNumber = userInput.nextInt();

                try {

                    String sql = "Select * From Customer WHERE PhoneNumber = '" + inputCustomerPhoneNumber + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n CustomerId   "
                            + "EmployeeId    "
                            + "Name    "
                            + "Address     "
                            + "PhoneNumber     "
                            + "Email       "
                            + "LastPurchase    "
                            + "PurchaseQty    "
                            + "SpentMoney     "
                            + "Gender      ");
                    while (result.next()) {

                        int customerID = result.getInt("CustomerId");
                        int employeeID = result.getInt("EmployeeId");
                        String customerName = result.getString("Name");
                        String customerAddress = result.getString("Address");
                        int customerPhoneNumber = result.getInt("PhoneNumber");
                        String customerEmail = result.getString("Email");
                        String customerLastPurchase = result.getString("LastPurchase");
                        int customerPurchaseQty = result.getInt("PurchaseQty");
                        int customerSpentMoney = result.getInt("SpentMoney");
                        String customerGender = result.getString("Gender");

                        System.out.println("\n" + customerID + "    "
                                + employeeID + "    "
                                + customerName + "  "
                                + customerAddress + "    "
                                + customerPhoneNumber + "    "
                                + customerEmail + "  "
                                + customerLastPurchase + "    "
                                + customerPurchaseQty + "  "
                                + customerSpentMoney + "    "
                                + customerGender + "  ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 3) {

                System.out.print("Enter Email: ");
                userInput.nextLine();
                String inputCustomerEmail = userInput.nextLine();

                try {

                    String sql = "Select * From Customer WHERE Email ='" + inputCustomerEmail + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n CustomerId   "
                            + "EmployeeId    "
                            + "Name    "
                            + "Address     "
                            + "PhoneNumber     "
                            + "Email       "
                            + "LastPurchase    "
                            + "PurchaseQty    "
                            + "SpentMoney     "
                            + "Gender      ");
                    while (result.next()) {

                        int customerID = result.getInt("CustomerId");
                        int employeeID = result.getInt("EmployeeId");
                        String customerName = result.getString("Name");
                        String customerAddress = result.getString("Address");
                        int customerPhoneNumber = result.getInt("PhoneNumber");
                        String customerEmail = result.getString("Email");
                        String customerLastPurchase = result.getString("LastPurchase");
                        int customerPurchaseQty = result.getInt("PurchaseQty");
                        int customerSpentMoney = result.getInt("SpentMoney");
                        String customerGender = result.getString("Gender");

                        System.out.println("\n" + customerID + "    "
                                + employeeID + "    "
                                + customerName + "  "
                                + customerAddress + "    "
                                + customerPhoneNumber + "    "
                                + customerEmail + "  "
                                + customerLastPurchase + "    "
                                + customerPurchaseQty + "  "
                                + customerSpentMoney + "    "
                                + customerGender + "  ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 4) {

                System.out.print("Enter Name: ");
                userInput.nextLine();
                String inputCustomeName = userInput.nextLine();

                try {

                    String sql = "Select * From Customer WHERE Name LIKE'" + inputCustomeName + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n CustomerId   "
                            + "EmployeeId    "
                            + "Name    "
                            + "Address     "
                            + "PhoneNumber     "
                            + "Email       "
                            + "LastPurchase    "
                            + "PurchaseQty    "
                            + "SpentMoney     "
                            + "Gender      ");
                    while (result.next()) {

                        int customerID = result.getInt("CustomerId");
                        int employeeID = result.getInt("EmployeeId");
                        String customerName = result.getString("Name");
                        String customerAddress = result.getString("Address");
                        int customerPhoneNumber = result.getInt("PhoneNumber");
                        String customerEmail = result.getString("Email");
                        String customerLastPurchase = result.getString("LastPurchase");
                        int customerPurchaseQty = result.getInt("PurchaseQty");
                        int customerSpentMoney = result.getInt("SpentMoney");
                        String customerGender = result.getString("Gender");

                        System.out.println("\n" + customerID + "    "
                                + employeeID + "    "
                                + customerName + "  "
                                + customerAddress + "    "
                                + customerPhoneNumber + "    "
                                + customerEmail + "  "
                                + customerLastPurchase + "    "
                                + customerPurchaseQty + "  "
                                + customerSpentMoney + "    "
                                + customerGender + "  ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 5) {
                System.out.println("EXIT PROGRAM SUCCESSFUL");
                break;
            }

        }
    }

    static void queries_06() {
        /* queries_06 
            1. Which items will expire in x days?
            2. Which items will expire in less x days?
         */
        while (true) {

            System.out.println("\n"
                    + "1.-> Which items will expire in x days: \n"
                    + "2.-> Which items will expire in less x days: \n"
                    + "3.-> EXIT\n");
            System.out.println("Select Any Option:");
            selectedMenuOption = userInput.nextInt();

            if (selectedMenuOption == 1) {

                System.out.print("Enter days: ");
                int days = userInput.nextInt();

                try {

                    String sql = "Select * From Product WHERE DATEDIFF(day,Exp_Date, getdate()) <= '" + days + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n ProductId   "
                            + "EmployeeId    "
                            + "Title    "
                            + "Category     "
                            + "SubCategory     "
                            + "Manufacture_country       "
                            + "Description    "
                            + "Imgurl    "
                            + "InStock     "
                            + "CostPrice      "
                            + "SellPrice      "
                            + "AddDate      "
                            + "LastUpdated      "
                            + "Exp_Date      "
                            + "Mfg_Date      ");
                    while (result.next()) {

                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        String productTitle = result.getString("Title");
                        String productCategory = result.getString("Category");
                        String productSubCategory = result.getString("SubCategory");
                        String productManufactureCountry = result.getString("Manufacture_country");
                        String productDescription = result.getString("Description");
                        String productImgurl = result.getString("Imgurl");
                        int productInStock = result.getInt("InStock");
                        float productCostPrice = result.getFloat("CostPrice");
                        float productSellPrice = result.getFloat("SellPrice");
                        String productAddDate = result.getString("AddDate");
                        String productLastUpdated = result.getString("LastUpdated");
                        String productExpDate = result.getString("Exp_Date");
                        String productMfgDate = result.getString("Mfg_Date");

                        System.out.println("\n" + productID + "    "
                                + employeeID + "    "
                                + productTitle + "  "
                                + productCategory + "    "
                                + productSubCategory + "    "
                                + productManufactureCountry + "  "
                                + productDescription + "    "
                                + productImgurl + "  "
                                + productInStock + " "
                                + productCostPrice + "    "
                                + productSellPrice + "  "
                                + productAddDate + "    "
                                + productLastUpdated + "    "
                                + productExpDate + "  "
                                + productMfgDate + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 2) {

                System.out.print("Enter days: ");
                int days = userInput.nextInt();

                try {

                    String sql = "Select * From Product WHERE DATEDIFF(day,Exp_Date, getdate()) <= '" + days + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n ProductId   "
                            + "EmployeeId    "
                            + "Title    "
                            + "Category     "
                            + "SubCategory     "
                            + "Manufacture_country       "
                            + "Description    "
                            + "Imgurl    "
                            + "InStock     "
                            + "CostPrice      "
                            + "SellPrice      "
                            + "AddDate      "
                            + "LastUpdated      "
                            + "Exp_Date      "
                            + "Mfg_Date      ");
                    while (result.next()) {

                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        String productTitle = result.getString("Title");
                        String productCategory = result.getString("Category");
                        String productSubCategory = result.getString("SubCategory");
                        String productManufactureCountry = result.getString("Manufacture_country");
                        String productDescription = result.getString("Description");
                        String productImgurl = result.getString("Imgurl");
                        int productInStock = result.getInt("InStock");
                        float productCostPrice = result.getFloat("CostPrice");
                        float productSellPrice = result.getFloat("SellPrice");
                        String productAddDate = result.getString("AddDate");
                        String productLastUpdated = result.getString("LastUpdated");
                        String productExpDate = result.getString("Exp_Date");
                        String productMfgDate = result.getString("Mfg_Date");

                        System.out.println("\n" + productID + "    "
                                + employeeID + "    "
                                + productTitle + "  "
                                + productCategory + "    "
                                + productSubCategory + "    "
                                + productManufactureCountry + "  "
                                + productDescription + "    "
                                + productImgurl + "  "
                                + productInStock + " "
                                + productCostPrice + "    "
                                + productSellPrice + "  "
                                + productAddDate + "    "
                                + productLastUpdated + "    "
                                + productExpDate + "  "
                                + productMfgDate + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 3) {
                System.out.println("EXIT PROGRAM SUCCESSFUL");
                break;
            }

        }

    }

    static void queries_07() {
        /* queries_07 
        Search an order with    ill do this - ALVEE
            1.order ID
            2.Eid
            3.Customer name
            4.Customer phone number
            5.Cid
         */
        while (true) {

            System.out.println("Search an order with: \n"
                    + "1.-> order ID: \n"
                    + "2.-> Employee id: \n"
                    + "3.-> Customer name: \n"
                    + "4.-> Customer phone number: \n"
                    + "5.-> Customer ID: \n"
                    + "6.-> EXIT\n");
            System.out.println("Select Any Option:");
            selectedMenuOption = userInput.nextInt();

            if (selectedMenuOption == 1) {

                System.out.print("Enter Order ID: ");
                int inputOrderID = userInput.nextInt();

                try {

                    String sql = "Select * From Order_Details WHERE OrderId = '" + inputOrderID + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n OrderId   "
                            + "CustomerId    "
                            + "ProductId    "
                            + "EmployeeId     "
                            + "Qty     "
                            + "TotalPrice       "
                            + "Discount    "
                            + "Tax    "
                            + "FinalPrice     "
                            + "SoldDate      "
                            + "PaidStatus      ");
                    while (result.next()) {

                        int OrderId = result.getInt("OrderId");
                        int CustomerId = result.getInt("CustomerId");
                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        int orderQty = result.getInt("Qty");
                        float orderTotalPrice = result.getFloat("TotalPrice");
                        float orderDiscount = result.getFloat("Discount");
                        float orderTax = result.getFloat("Tax");
                        float orderFinalPrice = result.getFloat("FinalPrice");
                        String orderSoldDate = result.getString("SoldDate");
                        float orderPaidStatus = result.getByte("PaidStatus");

                        System.out.println("\n" + OrderId + "    "
                                + CustomerId + "    "
                                + productID + "  "
                                + employeeID + "    "
                                + orderQty + "    "
                                + orderTotalPrice + "  "
                                + orderDiscount + "    "
                                + orderTax + "  "
                                + orderFinalPrice + " "
                                + orderSoldDate + "    "
                                + orderPaidStatus + "  ");
                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 2) {

                System.out.print("Enter Employee ID: ");
                int inputEmployeeID = userInput.nextInt();

                try {

                    String sql = "Select * From Order_Details WHERE EmployeeId = '" + inputEmployeeID + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n OrderId   "
                            + "CustomerId    "
                            + "ProductId    "
                            + "EmployeeId     "
                            + "Qty     "
                            + "TotalPrice       "
                            + "Discount    "
                            + "Tax    "
                            + "FinalPrice     "
                            + "SoldDate      "
                            + "PaidStatus      ");
                    while (result.next()) {

                        int OrderId = result.getInt("OrderId");
                        int CustomerId = result.getInt("CustomerId");
                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        int orderQty = result.getInt("Qty");
                        float orderTotalPrice = result.getFloat("TotalPrice");
                        float orderDiscount = result.getFloat("Discount");
                        float orderTax = result.getFloat("Tax");
                        float orderFinalPrice = result.getFloat("FinalPrice");
                        String orderSoldDate = result.getString("SoldDate");
                        float orderPaidStatus = result.getByte("PaidStatus");

                        System.out.println("\n" + OrderId + "    "
                                + CustomerId + "    "
                                + productID + "  "
                                + employeeID + "    "
                                + orderQty + "    "
                                + orderTotalPrice + "  "
                                + orderDiscount + "    "
                                + orderTax + "  "
                                + orderFinalPrice + " "
                                + orderSoldDate + "    "
                                + orderPaidStatus + "  ");
                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 3) {

                System.out.print("Enter Customer Name : ");
                userInput.nextLine();
                String inputCustomerName = userInput.nextLine();

                try {

                    String sql = "Select * From Order_Details WHERE CustomerId IN (SELECT CustomerId FROM Customer WHERE Name = '" + inputCustomerName + "' ) ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n OrderId   "
                            + "CustomerId    "
                            + "ProductId    "
                            + "EmployeeId     "
                            + "Qty     "
                            + "TotalPrice       "
                            + "Discount    "
                            + "Tax    "
                            + "FinalPrice     "
                            + "SoldDate      "
                            + "PaidStatus      ");
                    while (result.next()) {

                        int OrderId = result.getInt("OrderId");
                        int CustomerId = result.getInt("CustomerId");
                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        int orderQty = result.getInt("Qty");
                        float orderTotalPrice = result.getFloat("TotalPrice");
                        float orderDiscount = result.getFloat("Discount");
                        float orderTax = result.getFloat("Tax");
                        float orderFinalPrice = result.getFloat("FinalPrice");
                        String orderSoldDate = result.getString("SoldDate");
                        float orderPaidStatus = result.getByte("PaidStatus");

                        System.out.println("\n" + OrderId + "    "
                                + CustomerId + "    "
                                + productID + "  "
                                + employeeID + "    "
                                + orderQty + "    "
                                + orderTotalPrice + "  "
                                + orderDiscount + "    "
                                + orderTax + "  "
                                + orderFinalPrice + " "
                                + orderSoldDate + "    "
                                + orderPaidStatus + "  ");
                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 4) {

                System.out.print("Enter Customer Phone Number: ");
                int inputCustomerPhoneNumber = userInput.nextInt();

                try {

                    String sql = "Select * From Order_Details WHERE CustomerId IN (SELECT CustomerId FROM Customer WHERE PhoneNumber = '" + inputCustomerPhoneNumber + "' ) ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n OrderId   "
                            + "CustomerId    "
                            + "ProductId    "
                            + "EmployeeId     "
                            + "Qty     "
                            + "TotalPrice       "
                            + "Discount    "
                            + "Tax    "
                            + "FinalPrice     "
                            + "SoldDate      "
                            + "PaidStatus      ");
                    while (result.next()) {

                        int OrderId = result.getInt("OrderId");
                        int CustomerId = result.getInt("CustomerId");
                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        int orderQty = result.getInt("Qty");
                        float orderTotalPrice = result.getFloat("TotalPrice");
                        float orderDiscount = result.getFloat("Discount");
                        float orderTax = result.getFloat("Tax");
                        float orderFinalPrice = result.getFloat("FinalPrice");
                        String orderSoldDate = result.getString("SoldDate");
                        float orderPaidStatus = result.getByte("PaidStatus");

                        System.out.println("\n" + OrderId + "    "
                                + CustomerId + "    "
                                + productID + "  "
                                + employeeID + "    "
                                + orderQty + "    "
                                + orderTotalPrice + "  "
                                + orderDiscount + "    "
                                + orderTax + "  "
                                + orderFinalPrice + " "
                                + orderSoldDate + "    "
                                + orderPaidStatus + "  ");
                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 5) {

                System.out.print("Enter Customer ID: ");
                int inputCustomerID = userInput.nextInt();

                try {

                    String sql = "Select * From Order_Details WHERE CustomerId = '" + inputCustomerID + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n OrderId   "
                            + "CustomerId    "
                            + "ProductId    "
                            + "EmployeeId     "
                            + "Qty     "
                            + "TotalPrice       "
                            + "Discount    "
                            + "Tax    "
                            + "FinalPrice     "
                            + "SoldDate      "
                            + "PaidStatus      ");
                    while (result.next()) {

                        int OrderId = result.getInt("OrderId");
                        int CustomerId = result.getInt("CustomerId");
                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        int orderQty = result.getInt("Qty");
                        float orderTotalPrice = result.getFloat("TotalPrice");
                        float orderDiscount = result.getFloat("Discount");
                        float orderTax = result.getFloat("Tax");
                        float orderFinalPrice = result.getFloat("FinalPrice");
                        String orderSoldDate = result.getString("SoldDate");
                        float orderPaidStatus = result.getByte("PaidStatus");

                        System.out.println("\n" + OrderId + "    "
                                + CustomerId + "    "
                                + productID + "  "
                                + employeeID + "    "
                                + orderQty + "    "
                                + orderTotalPrice + "  "
                                + orderDiscount + "    "
                                + orderTax + "  "
                                + orderFinalPrice + " "
                                + orderSoldDate + "    "
                                + orderPaidStatus + "  ");
                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 6) {
                System.out.println("EXIT PROGRAM SUCCESSFUL");
                break;
            }

        }

    }

    static void queries_08() {
        /* queries_08 
        Select Orders   ill do this - ALVEE
            1.Which have payments due
            2.With unitPrice(product.Saleprice) higher than x bdt
            3.With totalPrice higher than x bdt
            4.Which have discount
            5.Which do not have discount
            6.Sold between xDate - yDate
            7.Qty more than x items
            8.Handled by particular Employee (ID)
            9.Handled by particular Employee (NAME)
		
         */
        while (true) {

            System.out.println("Select Orders : \n"
                    + "1.-> Which have payments due: \n"
                    + "2.-> With unitPrice higher than x bdt: \n"
                    + "3.-> With totalPrice higher than x bdt: \n"
                    + "4.-> Which have discount: \n"
                    + "5.-> Which do not have discount: \n"
                    + "6.-> Sold between xDate - yDate: \n"
                    + "7.-> Qty more than x items: \n"
                    + "8.-> Handled by particular Employee (ID): \n"
                    + "9.-> Handled by particular Employee (NAME): \n"
                    + "10.-> EXIT\n"
            );
            System.out.println("Select Any Option:");
            selectedMenuOption = userInput.nextInt();

            if (selectedMenuOption == 1) {
//
//                System.out.print("Enter Order ID: ");
//                int inputOrderID = userInput.nextInt();

                try {

                    String sql = "Select * From Order_Details WHERE PaidStatus = 1 ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n OrderId   "
                            + "CustomerId    "
                            + "ProductId    "
                            + "EmployeeId     "
                            + "Qty     "
                            + "TotalPrice       "
                            + "Discount    "
                            + "Tax    "
                            + "FinalPrice     "
                            + "SoldDate      "
                            + "PaidStatus      ");
                    while (result.next()) {

                        int OrderId = result.getInt("OrderId");
                        int CustomerId = result.getInt("CustomerId");
                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        int orderQty = result.getInt("Qty");
                        float orderTotalPrice = result.getFloat("TotalPrice");
                        float orderDiscount = result.getFloat("Discount");
                        float orderTax = result.getFloat("Tax");
                        float orderFinalPrice = result.getFloat("FinalPrice");
                        String orderSoldDate = result.getString("SoldDate");
                        float orderPaidStatus = result.getByte("PaidStatus");

                        System.out.println("\n" + OrderId + "    "
                                + CustomerId + "    "
                                + productID + "  "
                                + employeeID + "    "
                                + orderQty + "    "
                                + orderTotalPrice + "  "
                                + orderDiscount + "    "
                                + orderTax + "  "
                                + orderFinalPrice + " "
                                + orderSoldDate + "    "
                                + orderPaidStatus + "  ");
                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 2) {

                System.out.print("Enter Unit Price: ");
                int inputUnitPrice = userInput.nextInt();

                try {

                    String sql = "SELECT O.* FROM Order_Details O JOIN Product P ON O.ProductId=P.ProductId WHERE P.SellPrice <'" + inputUnitPrice + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n OrderId   "
                            + "CustomerId    "
                            + "ProductId    "
                            + "EmployeeId     "
                            + "Qty     "
                            + "TotalPrice       "
                            + "Discount    "
                            + "Tax    "
                            + "FinalPrice     "
                            + "SoldDate      "
                            + "PaidStatus      ");
                    while (result.next()) {

                        int OrderId = result.getInt("OrderId");
                        int CustomerId = result.getInt("CustomerId");
                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        int orderQty = result.getInt("Qty");
                        float orderTotalPrice = result.getFloat("TotalPrice");
                        float orderDiscount = result.getFloat("Discount");
                        float orderTax = result.getFloat("Tax");
                        float orderFinalPrice = result.getFloat("FinalPrice");
                        String orderSoldDate = result.getString("SoldDate");
                        float orderPaidStatus = result.getByte("PaidStatus");

                        System.out.println("\n" + OrderId + "    "
                                + CustomerId + "    "
                                + productID + "  "
                                + employeeID + "    "
                                + orderQty + "    "
                                + orderTotalPrice + "  "
                                + orderDiscount + "    "
                                + orderTax + "  "
                                + orderFinalPrice + " "
                                + orderSoldDate + "    "
                                + orderPaidStatus + "  ");
                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 3) {

                System.out.print("Enter Total Price: ");
                int inputTotalPrice = userInput.nextInt();
                try {

                    String sql = "SELECT * FROM Order_Details WHERE TotalPrice > '" + inputTotalPrice + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n OrderId   "
                            + "CustomerId    "
                            + "ProductId    "
                            + "EmployeeId     "
                            + "Qty     "
                            + "TotalPrice       "
                            + "Discount    "
                            + "Tax    "
                            + "FinalPrice     "
                            + "SoldDate      "
                            + "PaidStatus      ");
                    while (result.next()) {

                        int OrderId = result.getInt("OrderId");
                        int CustomerId = result.getInt("CustomerId");
                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        int orderQty = result.getInt("Qty");
                        float orderTotalPrice = result.getFloat("TotalPrice");
                        float orderDiscount = result.getFloat("Discount");
                        float orderTax = result.getFloat("Tax");
                        float orderFinalPrice = result.getFloat("FinalPrice");
                        String orderSoldDate = result.getString("SoldDate");
                        float orderPaidStatus = result.getByte("PaidStatus");

                        System.out.println("\n" + OrderId + "    "
                                + CustomerId + "    "
                                + productID + "  "
                                + employeeID + "    "
                                + orderQty + "    "
                                + orderTotalPrice + "  "
                                + orderDiscount + "    "
                                + orderTax + "  "
                                + orderFinalPrice + " "
                                + orderSoldDate + "    "
                                + orderPaidStatus + "  ");
                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 4) {

                try {

                    String sql = "Select * From Order_Details WHERE Discount > 0";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n OrderId   "
                            + "CustomerId    "
                            + "ProductId    "
                            + "EmployeeId     "
                            + "Qty     "
                            + "TotalPrice       "
                            + "Discount    "
                            + "Tax    "
                            + "FinalPrice     "
                            + "SoldDate      "
                            + "PaidStatus      ");
                    while (result.next()) {

                        int OrderId = result.getInt("OrderId");
                        int CustomerId = result.getInt("CustomerId");
                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        int orderQty = result.getInt("Qty");
                        float orderTotalPrice = result.getFloat("TotalPrice");
                        float orderDiscount = result.getFloat("Discount");
                        float orderTax = result.getFloat("Tax");
                        float orderFinalPrice = result.getFloat("FinalPrice");
                        String orderSoldDate = result.getString("SoldDate");
                        float orderPaidStatus = result.getByte("PaidStatus");

                        System.out.println("\n" + OrderId + "    "
                                + CustomerId + "    "
                                + productID + "  "
                                + employeeID + "    "
                                + orderQty + "    "
                                + orderTotalPrice + "  "
                                + orderDiscount + "    "
                                + orderTax + "  "
                                + orderFinalPrice + " "
                                + orderSoldDate + "    "
                                + orderPaidStatus + "  ");
                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 5) {

                try {

                    String sql = "Select * From Order_Details WHERE Discount = 0 ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n OrderId   "
                            + "CustomerId    "
                            + "ProductId    "
                            + "EmployeeId     "
                            + "Qty     "
                            + "TotalPrice       "
                            + "Discount    "
                            + "Tax    "
                            + "FinalPrice     "
                            + "SoldDate      "
                            + "PaidStatus      ");
                    while (result.next()) {

                        int OrderId = result.getInt("OrderId");
                        int CustomerId = result.getInt("CustomerId");
                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        int orderQty = result.getInt("Qty");
                        float orderTotalPrice = result.getFloat("TotalPrice");
                        float orderDiscount = result.getFloat("Discount");
                        float orderTax = result.getFloat("Tax");
                        float orderFinalPrice = result.getFloat("FinalPrice");
                        String orderSoldDate = result.getString("SoldDate");
                        float orderPaidStatus = result.getByte("PaidStatus");

                        System.out.println("\n" + OrderId + "    "
                                + CustomerId + "    "
                                + productID + "  "
                                + employeeID + "    "
                                + orderQty + "    "
                                + orderTotalPrice + "  "
                                + orderDiscount + "    "
                                + orderTax + "  "
                                + orderFinalPrice + " "
                                + orderSoldDate + "    "
                                + orderPaidStatus + "  ");
                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 6) {

                System.out.print("Enter Date From: ");
                userInput.nextLine();
                String dateFrom = userInput.nextLine();
                System.out.print("Enter Date To: ");
                String dateTo = userInput.nextLine();
                try {

                    String sql = "Select * From Order_Details WHERE SoldDate  BETWEEN '" + dateFrom + "' AND '" + dateTo + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n OrderId   "
                            + "CustomerId    "
                            + "ProductId    "
                            + "EmployeeId     "
                            + "Qty     "
                            + "TotalPrice       "
                            + "Discount    "
                            + "Tax    "
                            + "FinalPrice     "
                            + "SoldDate      "
                            + "PaidStatus      ");
                    while (result.next()) {

                        int OrderId = result.getInt("OrderId");
                        int CustomerId = result.getInt("CustomerId");
                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        int orderQty = result.getInt("Qty");
                        float orderTotalPrice = result.getFloat("TotalPrice");
                        float orderDiscount = result.getFloat("Discount");
                        float orderTax = result.getFloat("Tax");
                        float orderFinalPrice = result.getFloat("FinalPrice");
                        String orderSoldDate = result.getString("SoldDate");
                        float orderPaidStatus = result.getByte("PaidStatus");

                        System.out.println("\n" + OrderId + "    "
                                + CustomerId + "    "
                                + productID + "  "
                                + employeeID + "    "
                                + orderQty + "    "
                                + orderTotalPrice + "  "
                                + orderDiscount + "    "
                                + orderTax + "  "
                                + orderFinalPrice + " "
                                + orderSoldDate + "    "
                                + orderPaidStatus + "  ");
                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 7) {

                System.out.print("Enter Quantity : ");
                int inputQuantity = userInput.nextInt();

                try {

                    String sql = "Select * From Order_Details WHERE Qty > '" + inputQuantity + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n OrderId   "
                            + "CustomerId    "
                            + "ProductId    "
                            + "EmployeeId     "
                            + "Qty     "
                            + "TotalPrice       "
                            + "Discount    "
                            + "Tax    "
                            + "FinalPrice     "
                            + "SoldDate      "
                            + "PaidStatus      ");
                    while (result.next()) {

                        int OrderId = result.getInt("OrderId");
                        int CustomerId = result.getInt("CustomerId");
                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        int orderQty = result.getInt("Qty");
                        float orderTotalPrice = result.getFloat("TotalPrice");
                        float orderDiscount = result.getFloat("Discount");
                        float orderTax = result.getFloat("Tax");
                        float orderFinalPrice = result.getFloat("FinalPrice");
                        String orderSoldDate = result.getString("SoldDate");
                        float orderPaidStatus = result.getByte("PaidStatus");

                        System.out.println("\n" + OrderId + "    "
                                + CustomerId + "    "
                                + productID + "  "
                                + employeeID + "    "
                                + orderQty + "    "
                                + orderTotalPrice + "  "
                                + orderDiscount + "    "
                                + orderTax + "  "
                                + orderFinalPrice + " "
                                + orderSoldDate + "    "
                                + orderPaidStatus + "  ");
                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 8) {

                System.out.print("Enter Employee ID: ");
                int inputEmployeeID = userInput.nextInt();

                try {

                    String sql = "Select * From Order_Details WHERE EmployeeId = '" + inputEmployeeID + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n OrderId   "
                            + "CustomerId    "
                            + "ProductId    "
                            + "EmployeeId     "
                            + "Qty     "
                            + "TotalPrice       "
                            + "Discount    "
                            + "Tax    "
                            + "FinalPrice     "
                            + "SoldDate      "
                            + "PaidStatus      ");
                    while (result.next()) {

                        int OrderId = result.getInt("OrderId");
                        int CustomerId = result.getInt("CustomerId");
                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        int orderQty = result.getInt("Qty");
                        float orderTotalPrice = result.getFloat("TotalPrice");
                        float orderDiscount = result.getFloat("Discount");
                        float orderTax = result.getFloat("Tax");
                        float orderFinalPrice = result.getFloat("FinalPrice");
                        String orderSoldDate = result.getString("SoldDate");
                        float orderPaidStatus = result.getByte("PaidStatus");

                        System.out.println("\n" + OrderId + "    "
                                + CustomerId + "    "
                                + productID + "  "
                                + employeeID + "    "
                                + orderQty + "    "
                                + orderTotalPrice + "  "
                                + orderDiscount + "    "
                                + orderTax + "  "
                                + orderFinalPrice + " "
                                + orderSoldDate + "    "
                                + orderPaidStatus + "  ");
                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 9) {

                System.out.print("Enter Employee Name: ");
                userInput.nextLine();
                String inputEmployeeName = userInput.nextLine();

                try {

                    String sql = "SELECT * FROM Order_Details WHERE EmployeeId IN ( SELECT EmployeeId FROM Employee WHERE Name = '" + inputEmployeeName + "')  ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n OrderId   "
                            + "CustomerId    "
                            + "ProductId    "
                            + "EmployeeId     "
                            + "Qty     "
                            + "TotalPrice       "
                            + "Discount    "
                            + "Tax    "
                            + "FinalPrice     "
                            + "SoldDate      "
                            + "PaidStatus      ");
                    while (result.next()) {

                        int OrderId = result.getInt("OrderId");
                        int CustomerId = result.getInt("CustomerId");
                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        int orderQty = result.getInt("Qty");
                        float orderTotalPrice = result.getFloat("TotalPrice");
                        float orderDiscount = result.getFloat("Discount");
                        float orderTax = result.getFloat("Tax");
                        float orderFinalPrice = result.getFloat("FinalPrice");
                        String orderSoldDate = result.getString("SoldDate");
                        float orderPaidStatus = result.getByte("PaidStatus");

                        System.out.println("\n" + OrderId + "    "
                                + CustomerId + "    "
                                + productID + "  "
                                + employeeID + "    "
                                + orderQty + "    "
                                + orderTotalPrice + "  "
                                + orderDiscount + "    "
                                + orderTax + "  "
                                + orderFinalPrice + " "
                                + orderSoldDate + "    "
                                + orderPaidStatus + "  ");
                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 10) {
                System.out.println("EXIT PROGRAM SUCCESSFUL");
                break;
            }

        }
    }

    static void queries_09() {
        /* queries_09 
        Search a particular Product
            1.Pid
            2.Product Title
            3.imgurl
         */
        while (true) {

            System.out.println("Search a particular Product:\n"
                    + "1.-> With Product ID: \n"
                    + "2.-> With Product Title: \n"
                    + "3.-> With imgurl: \n"
                    + "4.-> EXIT\n");
            System.out.println("Select Any Option:");
            selectedMenuOption = userInput.nextInt();

            if (selectedMenuOption == 1) {

                System.out.print("Enter Produc ID: ");
                int inputProductID = userInput.nextInt();

                try {

                    String sql = "Select * From Product WHERE ProductId = '" + inputProductID + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n ProductId   "
                            + "EmployeeId    "
                            + "Title    "
                            + "Category     "
                            + "SubCategory     "
                            + "Manufacture_country       "
                            + "Description    "
                            + "Imgurl    "
                            + "InStock     "
                            + "CostPrice      "
                            + "SellPrice      "
                            + "AddDate      "
                            + "LastUpdated      "
                            + "Exp_Date      "
                            + "Mfg_Date      ");
                    while (result.next()) {

                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        String productTitle = result.getString("Title");
                        String productCategory = result.getString("Category");
                        String productSubCategory = result.getString("SubCategory");
                        String productManufactureCountry = result.getString("Manufacture_country");
                        String productDescription = result.getString("Description");
                        String productImgurl = result.getString("Imgurl");
                        int productInStock = result.getInt("InStock");
                        float productCostPrice = result.getFloat("CostPrice");
                        float productSellPrice = result.getFloat("SellPrice");
                        String productAddDate = result.getString("AddDate");
                        String productLastUpdated = result.getString("LastUpdated");
                        String productExpDate = result.getString("Exp_Date");
                        String productMfgDate = result.getString("Mfg_Date");

                        System.out.println("\n" + productID + "    "
                                + employeeID + "    "
                                + productTitle + "  "
                                + productCategory + "    "
                                + productSubCategory + "    "
                                + productManufactureCountry + "  "
                                + productDescription + "    "
                                + productImgurl + "  "
                                + productInStock + " "
                                + productCostPrice + "    "
                                + productSellPrice + "  "
                                + productAddDate + "    "
                                + productLastUpdated + "    "
                                + productExpDate + "  "
                                + productMfgDate + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 2) {

                System.out.print("Enter Product Title: ");
                userInput.nextLine();
                String inputProductTitle = userInput.nextLine();

                try {

                    String sql = "Select * From Product WHERE Title = '" + inputProductTitle + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n ProductId   "
                            + "EmployeeId    "
                            + "Title    "
                            + "Category     "
                            + "SubCategory     "
                            + "Manufacture_country       "
                            + "Description    "
                            + "Imgurl    "
                            + "InStock     "
                            + "CostPrice      "
                            + "SellPrice      "
                            + "AddDate      "
                            + "LastUpdated      "
                            + "Exp_Date      "
                            + "Mfg_Date      ");
                    while (result.next()) {

                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        String productTitle = result.getString("Title");
                        String productCategory = result.getString("Category");
                        String productSubCategory = result.getString("SubCategory");
                        String productManufactureCountry = result.getString("Manufacture_country");
                        String productDescription = result.getString("Description");
                        String productImgurl = result.getString("Imgurl");
                        int productInStock = result.getInt("InStock");
                        float productCostPrice = result.getFloat("CostPrice");
                        float productSellPrice = result.getFloat("SellPrice");
                        String productAddDate = result.getString("AddDate");
                        String productLastUpdated = result.getString("LastUpdated");
                        String productExpDate = result.getString("Exp_Date");
                        String productMfgDate = result.getString("Mfg_Date");

                        System.out.println("\n" + productID + "    "
                                + employeeID + "    "
                                + productTitle + "  "
                                + productCategory + "    "
                                + productSubCategory + "    "
                                + productManufactureCountry + "  "
                                + productDescription + "    "
                                + productImgurl + "  "
                                + productInStock + " "
                                + productCostPrice + "    "
                                + productSellPrice + "  "
                                + productAddDate + "    "
                                + productLastUpdated + "    "
                                + productExpDate + "  "
                                + productMfgDate + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 3) {

                System.out.print("Enter imgurl: ");
                userInput.nextLine();
                String inputProductImgurl = userInput.nextLine();
                try {

                    String sql = "Select * From Product WHERE imgurl = '" + inputProductImgurl + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n ProductId   "
                            + "EmployeeId    "
                            + "Title    "
                            + "Category     "
                            + "SubCategory     "
                            + "Manufacture_country       "
                            + "Description    "
                            + "Imgurl    "
                            + "InStock     "
                            + "CostPrice      "
                            + "SellPrice      "
                            + "AddDate      "
                            + "LastUpdated      "
                            + "Exp_Date      "
                            + "Mfg_Date      ");
                    while (result.next()) {

                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        String productTitle = result.getString("Title");
                        String productCategory = result.getString("Category");
                        String productSubCategory = result.getString("SubCategory");
                        String productManufactureCountry = result.getString("Manufacture_country");
                        String productDescription = result.getString("Description");
                        String productImgurl = result.getString("Imgurl");
                        int productInStock = result.getInt("InStock");
                        float productCostPrice = result.getFloat("CostPrice");
                        float productSellPrice = result.getFloat("SellPrice");
                        String productAddDate = result.getString("AddDate");
                        String productLastUpdated = result.getString("LastUpdated");
                        String productExpDate = result.getString("Exp_Date");
                        String productMfgDate = result.getString("Mfg_Date");

                        System.out.println("\n" + productID + "    "
                                + employeeID + "    "
                                + productTitle + "  "
                                + productCategory + "    "
                                + productSubCategory + "    "
                                + productManufactureCountry + "  "
                                + productDescription + "    "
                                + productImgurl + "  "
                                + productInStock + " "
                                + productCostPrice + "    "
                                + productSellPrice + "  "
                                + productAddDate + "    "
                                + productLastUpdated + "    "
                                + productExpDate + "  "
                                + productMfgDate + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 4) {
                System.out.println("EXIT PROGRAM SUCCESSFUL");
                break;
            }

        }

    }

    static void queries_10() {
        /* queries_10 
        Select products based on ?
            1.Country of manufacture
            2.Category
            3.Sub -category
            4.Input by a particular employee (Eid)
            5.Added on a particular date
            6.Added between xDate-yDate
            7.Expires within a week/month	
            8.In stock
            9.Not in stock
            10.Less than x items in stock
            11.SalePrice less/higher than x bdt
            12.Supplied by particular supplier (Sid)
            13.Highest sold product
            14.Sold between xDate-yDate
         */

        while (true) {

            System.out.println("Select products based on:\n"
                    + "1.-> Country of manufacture: \n"
                    + "2.-> Category: \n"
                    + "3.-> Sub -category: \n"
                    + "4.-> Input by a particular employee (Eid): \n"
                    + "5.-> Added on a particular date: \n"
                    + "6.-> Added between xDate-yDate: \n"
                    + "7.-> Expires within a week: \n"
                    + "8.-> Expires within a month: \n"
                    + "9.-> In stock: \n"
                    + "10.-> Not in stock: \n"
                    + "11.-> Less than x items in stock: \n"
                    + "12.-> SalePrice less than x bdt: \n"
                    + "13.-> SalePrice higher than x bdt: \n"
                    + "14.-> Supplied by particular supplier (Sid): \n"
                    + "15.-> Highest sold product: \n"
                    + "16.-> Sold between xDate-yDate: \n"
                    + "17.-> EXIT\n");
            System.out.println("Select Any Option:");
            selectedMenuOption = userInput.nextInt();

            if (selectedMenuOption == 1) {

                System.out.print("Enter Manufacture Country: ");
                userInput.nextLine();
                String inputMfgCountry = userInput.nextLine();

                try {

                    String sql = "Select * From Product WHERE Manufacture_country = '" + inputMfgCountry + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n ProductId   "
                            + "EmployeeId    "
                            + "Title    "
                            + "Category     "
                            + "SubCategory     "
                            + "Manufacture_country       "
                            + "Description    "
                            + "Imgurl    "
                            + "InStock     "
                            + "CostPrice      "
                            + "SellPrice      "
                            + "AddDate      "
                            + "LastUpdated      "
                            + "Exp_Date      "
                            + "Mfg_Date      ");
                    while (result.next()) {

                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        String productTitle = result.getString("Title");
                        String productCategory = result.getString("Category");
                        String productSubCategory = result.getString("SubCategory");
                        String productManufactureCountry = result.getString("Manufacture_country");
                        String productDescription = result.getString("Description");
                        String productImgurl = result.getString("Imgurl");
                        int productInStock = result.getInt("InStock");
                        float productCostPrice = result.getFloat("CostPrice");
                        float productSellPrice = result.getFloat("SellPrice");
                        String productAddDate = result.getString("AddDate");
                        String productLastUpdated = result.getString("LastUpdated");
                        String productExpDate = result.getString("Exp_Date");
                        String productMfgDate = result.getString("Mfg_Date");

                        System.out.println("\n" + productID + "    "
                                + employeeID + "    "
                                + productTitle + "  "
                                + productCategory + "    "
                                + productSubCategory + "    "
                                + productManufactureCountry + "  "
                                + productDescription + "    "
                                + productImgurl + "  "
                                + productInStock + " "
                                + productCostPrice + "    "
                                + productSellPrice + "  "
                                + productAddDate + "    "
                                + productLastUpdated + "    "
                                + productExpDate + "  "
                                + productMfgDate + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 2) {

                System.out.print("Enter Product Category: ");
                userInput.nextLine();
                String inputCategory = userInput.nextLine();

                try {

                    String sql = "Select * From Product WHERE Category = '" + inputCategory + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n ProductId   "
                            + "EmployeeId    "
                            + "Title    "
                            + "Category     "
                            + "SubCategory     "
                            + "Manufacture_country       "
                            + "Description    "
                            + "Imgurl    "
                            + "InStock     "
                            + "CostPrice      "
                            + "SellPrice      "
                            + "AddDate      "
                            + "LastUpdated      "
                            + "Exp_Date      "
                            + "Mfg_Date      ");
                    while (result.next()) {

                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        String productTitle = result.getString("Title");
                        String productCategory = result.getString("Category");
                        String productSubCategory = result.getString("SubCategory");
                        String productManufactureCountry = result.getString("Manufacture_country");
                        String productDescription = result.getString("Description");
                        String productImgurl = result.getString("Imgurl");
                        int productInStock = result.getInt("InStock");
                        float productCostPrice = result.getFloat("CostPrice");
                        float productSellPrice = result.getFloat("SellPrice");
                        String productAddDate = result.getString("AddDate");
                        String productLastUpdated = result.getString("LastUpdated");
                        String productExpDate = result.getString("Exp_Date");
                        String productMfgDate = result.getString("Mfg_Date");

                        System.out.println("\n" + productID + "    "
                                + employeeID + "    "
                                + productTitle + "  "
                                + productCategory + "    "
                                + productSubCategory + "    "
                                + productManufactureCountry + "  "
                                + productDescription + "    "
                                + productImgurl + "  "
                                + productInStock + " "
                                + productCostPrice + "    "
                                + productSellPrice + "  "
                                + productAddDate + "    "
                                + productLastUpdated + "    "
                                + productExpDate + "  "
                                + productMfgDate + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 3) {

                System.out.print("Enter Sub Categgory: ");
                userInput.nextLine();
                String inputSubCategory = userInput.nextLine();
                try {

                    String sql = "Select * From Product WHERE SubCategory = '" + inputSubCategory + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n ProductId   "
                            + "EmployeeId    "
                            + "Title    "
                            + "Category     "
                            + "SubCategory     "
                            + "Manufacture_country       "
                            + "Description    "
                            + "Imgurl    "
                            + "InStock     "
                            + "CostPrice      "
                            + "SellPrice      "
                            + "AddDate      "
                            + "LastUpdated      "
                            + "Exp_Date      "
                            + "Mfg_Date      ");
                    while (result.next()) {

                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        String productTitle = result.getString("Title");
                        String productCategory = result.getString("Category");
                        String productSubCategory = result.getString("SubCategory");
                        String productManufactureCountry = result.getString("Manufacture_country");
                        String productDescription = result.getString("Description");
                        String productImgurl = result.getString("Imgurl");
                        int productInStock = result.getInt("InStock");
                        float productCostPrice = result.getFloat("CostPrice");
                        float productSellPrice = result.getFloat("SellPrice");
                        String productAddDate = result.getString("AddDate");
                        String productLastUpdated = result.getString("LastUpdated");
                        String productExpDate = result.getString("Exp_Date");
                        String productMfgDate = result.getString("Mfg_Date");

                        System.out.println("\n" + productID + "    "
                                + employeeID + "    "
                                + productTitle + "  "
                                + productCategory + "    "
                                + productSubCategory + "    "
                                + productManufactureCountry + "  "
                                + productDescription + "    "
                                + productImgurl + "  "
                                + productInStock + " "
                                + productCostPrice + "    "
                                + productSellPrice + "  "
                                + productAddDate + "    "
                                + productLastUpdated + "    "
                                + productExpDate + "  "
                                + productMfgDate + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 4) {

                System.out.print("Enter EmployeeId: ");
                int inputEmployeeID = userInput.nextInt();
                try {

                    String sql = "Select * From Product WHERE EmployeeId = '" + inputEmployeeID + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n ProductId   "
                            + "EmployeeId    "
                            + "Title    "
                            + "Category     "
                            + "SubCategory     "
                            + "Manufacture_country       "
                            + "Description    "
                            + "Imgurl    "
                            + "InStock     "
                            + "CostPrice      "
                            + "SellPrice      "
                            + "AddDate      "
                            + "LastUpdated      "
                            + "Exp_Date      "
                            + "Mfg_Date      ");
                    while (result.next()) {

                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        String productTitle = result.getString("Title");
                        String productCategory = result.getString("Category");
                        String productSubCategory = result.getString("SubCategory");
                        String productManufactureCountry = result.getString("Manufacture_country");
                        String productDescription = result.getString("Description");
                        String productImgurl = result.getString("Imgurl");
                        int productInStock = result.getInt("InStock");
                        float productCostPrice = result.getFloat("CostPrice");
                        float productSellPrice = result.getFloat("SellPrice");
                        String productAddDate = result.getString("AddDate");
                        String productLastUpdated = result.getString("LastUpdated");
                        String productExpDate = result.getString("Exp_Date");
                        String productMfgDate = result.getString("Mfg_Date");

                        System.out.println("\n" + productID + "    "
                                + employeeID + "    "
                                + productTitle + "  "
                                + productCategory + "    "
                                + productSubCategory + "    "
                                + productManufactureCountry + "  "
                                + productDescription + "    "
                                + productImgurl + "  "
                                + productInStock + " "
                                + productCostPrice + "    "
                                + productSellPrice + "  "
                                + productAddDate + "    "
                                + productLastUpdated + "    "
                                + productExpDate + "  "
                                + productMfgDate + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 5) {

                System.out.print("Enter AddDate: ");
                userInput.nextLine();
                String inputAddDate = userInput.nextLine();
                try {

                    String sql = "Select * From Product WHERE AddDate = '" + inputAddDate + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n ProductId   "
                            + "EmployeeId    "
                            + "Title    "
                            + "Category     "
                            + "SubCategory     "
                            + "Manufacture_country       "
                            + "Description    "
                            + "Imgurl    "
                            + "InStock     "
                            + "CostPrice      "
                            + "SellPrice      "
                            + "AddDate      "
                            + "LastUpdated      "
                            + "Exp_Date      "
                            + "Mfg_Date      ");
                    while (result.next()) {

                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        String productTitle = result.getString("Title");
                        String productCategory = result.getString("Category");
                        String productSubCategory = result.getString("SubCategory");
                        String productManufactureCountry = result.getString("Manufacture_country");
                        String productDescription = result.getString("Description");
                        String productImgurl = result.getString("Imgurl");
                        int productInStock = result.getInt("InStock");
                        float productCostPrice = result.getFloat("CostPrice");
                        float productSellPrice = result.getFloat("SellPrice");
                        String productAddDate = result.getString("AddDate");
                        String productLastUpdated = result.getString("LastUpdated");
                        String productExpDate = result.getString("Exp_Date");
                        String productMfgDate = result.getString("Mfg_Date");

                        System.out.println("\n" + productID + "    "
                                + employeeID + "    "
                                + productTitle + "  "
                                + productCategory + "    "
                                + productSubCategory + "    "
                                + productManufactureCountry + "  "
                                + productDescription + "    "
                                + productImgurl + "  "
                                + productInStock + " "
                                + productCostPrice + "    "
                                + productSellPrice + "  "
                                + productAddDate + "    "
                                + productLastUpdated + "    "
                                + productExpDate + "  "
                                + productMfgDate + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 6) {

                System.out.print("Enter AddDate From: ");
                userInput.nextLine();
                String inputAddDateFrom = userInput.nextLine();
                System.out.print("Enter AddDate To: ");
                String inputAddDateTo = userInput.nextLine();
                try {

                    String sql = "Select * From Product WHERE AddDate BETWEEN '" + inputAddDateFrom + "'  AND '" + inputAddDateTo + "'";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n ProductId   "
                            + "EmployeeId    "
                            + "Title    "
                            + "Category     "
                            + "SubCategory     "
                            + "Manufacture_country       "
                            + "Description    "
                            + "Imgurl    "
                            + "InStock     "
                            + "CostPrice      "
                            + "SellPrice      "
                            + "AddDate      "
                            + "LastUpdated      "
                            + "Exp_Date      "
                            + "Mfg_Date      ");
                    while (result.next()) {

                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        String productTitle = result.getString("Title");
                        String productCategory = result.getString("Category");
                        String productSubCategory = result.getString("SubCategory");
                        String productManufactureCountry = result.getString("Manufacture_country");
                        String productDescription = result.getString("Description");
                        String productImgurl = result.getString("Imgurl");
                        int productInStock = result.getInt("InStock");
                        float productCostPrice = result.getFloat("CostPrice");
                        float productSellPrice = result.getFloat("SellPrice");
                        String productAddDate = result.getString("AddDate");
                        String productLastUpdated = result.getString("LastUpdated");
                        String productExpDate = result.getString("Exp_Date");
                        String productMfgDate = result.getString("Mfg_Date");

                        System.out.println("\n" + productID + "    "
                                + employeeID + "    "
                                + productTitle + "  "
                                + productCategory + "    "
                                + productSubCategory + "    "
                                + productManufactureCountry + "  "
                                + productDescription + "    "
                                + productImgurl + "  "
                                + productInStock + " "
                                + productCostPrice + "    "
                                + productSellPrice + "  "
                                + productAddDate + "    "
                                + productLastUpdated + "    "
                                + productExpDate + "  "
                                + productMfgDate + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 7) {

//                System.out.print("Enter imgurl: ");
//                userInput.nextLine();
//                String inputProductImgurl = userInput.nextLine();
                try {

                    String sql = "SELECT * FROM Product WHERE DATEDIFF(week,Exp_Date, getdate()) <= 1";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n ProductId   "
                            + "EmployeeId    "
                            + "Title    "
                            + "Category     "
                            + "SubCategory     "
                            + "Manufacture_country       "
                            + "Description    "
                            + "Imgurl    "
                            + "InStock     "
                            + "CostPrice      "
                            + "SellPrice      "
                            + "AddDate      "
                            + "LastUpdated      "
                            + "Exp_Date      "
                            + "Mfg_Date      ");
                    while (result.next()) {

                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        String productTitle = result.getString("Title");
                        String productCategory = result.getString("Category");
                        String productSubCategory = result.getString("SubCategory");
                        String productManufactureCountry = result.getString("Manufacture_country");
                        String productDescription = result.getString("Description");
                        String productImgurl = result.getString("Imgurl");
                        int productInStock = result.getInt("InStock");
                        float productCostPrice = result.getFloat("CostPrice");
                        float productSellPrice = result.getFloat("SellPrice");
                        String productAddDate = result.getString("AddDate");
                        String productLastUpdated = result.getString("LastUpdated");
                        String productExpDate = result.getString("Exp_Date");
                        String productMfgDate = result.getString("Mfg_Date");

                        System.out.println("\n" + productID + "    "
                                + employeeID + "    "
                                + productTitle + "  "
                                + productCategory + "    "
                                + productSubCategory + "    "
                                + productManufactureCountry + "  "
                                + productDescription + "    "
                                + productImgurl + "  "
                                + productInStock + " "
                                + productCostPrice + "    "
                                + productSellPrice + "  "
                                + productAddDate + "    "
                                + productLastUpdated + "    "
                                + productExpDate + "  "
                                + productMfgDate + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 8) {

//                System.out.print("Enter imgurl: ");
//                userInput.nextLine();
//                String inputProductImgurl = userInput.nextLine();
                try {

                    String sql = "SELECT * FROM Product WHERE DATEDIFF(month,Exp_Date, getdate()) <= 1";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n ProductId   "
                            + "EmployeeId    "
                            + "Title    "
                            + "Category     "
                            + "SubCategory     "
                            + "Manufacture_country       "
                            + "Description    "
                            + "Imgurl    "
                            + "InStock     "
                            + "CostPrice      "
                            + "SellPrice      "
                            + "AddDate      "
                            + "LastUpdated      "
                            + "Exp_Date      "
                            + "Mfg_Date      ");
                    while (result.next()) {

                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        String productTitle = result.getString("Title");
                        String productCategory = result.getString("Category");
                        String productSubCategory = result.getString("SubCategory");
                        String productManufactureCountry = result.getString("Manufacture_country");
                        String productDescription = result.getString("Description");
                        String productImgurl = result.getString("Imgurl");
                        int productInStock = result.getInt("InStock");
                        float productCostPrice = result.getFloat("CostPrice");
                        float productSellPrice = result.getFloat("SellPrice");
                        String productAddDate = result.getString("AddDate");
                        String productLastUpdated = result.getString("LastUpdated");
                        String productExpDate = result.getString("Exp_Date");
                        String productMfgDate = result.getString("Mfg_Date");

                        System.out.println("\n" + productID + "    "
                                + employeeID + "    "
                                + productTitle + "  "
                                + productCategory + "    "
                                + productSubCategory + "    "
                                + productManufactureCountry + "  "
                                + productDescription + "    "
                                + productImgurl + "  "
                                + productInStock + " "
                                + productCostPrice + "    "
                                + productSellPrice + "  "
                                + productAddDate + "    "
                                + productLastUpdated + "    "
                                + productExpDate + "  "
                                + productMfgDate + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 9) {

                try {

                    String sql = "Select * From Product WHERE InStock >0  ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n ProductId   "
                            + "EmployeeId    "
                            + "Title    "
                            + "Category     "
                            + "SubCategory     "
                            + "Manufacture_country       "
                            + "Description    "
                            + "Imgurl    "
                            + "InStock     "
                            + "CostPrice      "
                            + "SellPrice      "
                            + "AddDate      "
                            + "LastUpdated      "
                            + "Exp_Date      "
                            + "Mfg_Date      ");
                    while (result.next()) {

                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        String productTitle = result.getString("Title");
                        String productCategory = result.getString("Category");
                        String productSubCategory = result.getString("SubCategory");
                        String productManufactureCountry = result.getString("Manufacture_country");
                        String productDescription = result.getString("Description");
                        String productImgurl = result.getString("Imgurl");
                        int productInStock = result.getInt("InStock");
                        float productCostPrice = result.getFloat("CostPrice");
                        float productSellPrice = result.getFloat("SellPrice");
                        String productAddDate = result.getString("AddDate");
                        String productLastUpdated = result.getString("LastUpdated");
                        String productExpDate = result.getString("Exp_Date");
                        String productMfgDate = result.getString("Mfg_Date");

                        System.out.println("\n" + productID + "    "
                                + employeeID + "    "
                                + productTitle + "  "
                                + productCategory + "    "
                                + productSubCategory + "    "
                                + productManufactureCountry + "  "
                                + productDescription + "    "
                                + productImgurl + "  "
                                + productInStock + " "
                                + productCostPrice + "    "
                                + productSellPrice + "  "
                                + productAddDate + "    "
                                + productLastUpdated + "    "
                                + productExpDate + "  "
                                + productMfgDate + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 10) {

                try {

                    String sql = "Select * From Product WHERE InStock <=0  ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n ProductId   "
                            + "EmployeeId    "
                            + "Title    "
                            + "Category     "
                            + "SubCategory     "
                            + "Manufacture_country       "
                            + "Description    "
                            + "Imgurl    "
                            + "InStock     "
                            + "CostPrice      "
                            + "SellPrice      "
                            + "AddDate      "
                            + "LastUpdated      "
                            + "Exp_Date      "
                            + "Mfg_Date      ");
                    while (result.next()) {

                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        String productTitle = result.getString("Title");
                        String productCategory = result.getString("Category");
                        String productSubCategory = result.getString("SubCategory");
                        String productManufactureCountry = result.getString("Manufacture_country");
                        String productDescription = result.getString("Description");
                        String productImgurl = result.getString("Imgurl");
                        int productInStock = result.getInt("InStock");
                        float productCostPrice = result.getFloat("CostPrice");
                        float productSellPrice = result.getFloat("SellPrice");
                        String productAddDate = result.getString("AddDate");
                        String productLastUpdated = result.getString("LastUpdated");
                        String productExpDate = result.getString("Exp_Date");
                        String productMfgDate = result.getString("Mfg_Date");

                        System.out.println("\n" + productID + "    "
                                + employeeID + "    "
                                + productTitle + "  "
                                + productCategory + "    "
                                + productSubCategory + "    "
                                + productManufactureCountry + "  "
                                + productDescription + "    "
                                + productImgurl + "  "
                                + productInStock + " "
                                + productCostPrice + "    "
                                + productSellPrice + "  "
                                + productAddDate + "    "
                                + productLastUpdated + "    "
                                + productExpDate + "  "
                                + productMfgDate + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 11) {

                System.out.print("Enter Instock Number: ");

                int inputInStock = userInput.nextInt();
                try {

                    String sql = "Select * From Product WHERE InStock <= '" + inputInStock + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n ProductId   "
                            + "EmployeeId    "
                            + "Title    "
                            + "Category     "
                            + "SubCategory     "
                            + "Manufacture_country       "
                            + "Description    "
                            + "Imgurl    "
                            + "InStock     "
                            + "CostPrice      "
                            + "SellPrice      "
                            + "AddDate      "
                            + "LastUpdated      "
                            + "Exp_Date      "
                            + "Mfg_Date      ");
                    while (result.next()) {

                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        String productTitle = result.getString("Title");
                        String productCategory = result.getString("Category");
                        String productSubCategory = result.getString("SubCategory");
                        String productManufactureCountry = result.getString("Manufacture_country");
                        String productDescription = result.getString("Description");
                        String productImgurl = result.getString("Imgurl");
                        int productInStock = result.getInt("InStock");
                        float productCostPrice = result.getFloat("CostPrice");
                        float productSellPrice = result.getFloat("SellPrice");
                        String productAddDate = result.getString("AddDate");
                        String productLastUpdated = result.getString("LastUpdated");
                        String productExpDate = result.getString("Exp_Date");
                        String productMfgDate = result.getString("Mfg_Date");

                        System.out.println("\n" + productID + "    "
                                + employeeID + "    "
                                + productTitle + "  "
                                + productCategory + "    "
                                + productSubCategory + "    "
                                + productManufactureCountry + "  "
                                + productDescription + "    "
                                + productImgurl + "  "
                                + productInStock + " "
                                + productCostPrice + "    "
                                + productSellPrice + "  "
                                + productAddDate + "    "
                                + productLastUpdated + "    "
                                + productExpDate + "  "
                                + productMfgDate + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 12) {

                System.out.print("Enter Sell Price (lower) : ");

                int inputSellPrice = userInput.nextInt();
                try {

                    String sql = "Select * From Product WHERE SellPrice <= '" + inputSellPrice + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n ProductId   "
                            + "EmployeeId    "
                            + "Title    "
                            + "Category     "
                            + "SubCategory     "
                            + "Manufacture_country       "
                            + "Description    "
                            + "Imgurl    "
                            + "InStock     "
                            + "CostPrice      "
                            + "SellPrice      "
                            + "AddDate      "
                            + "LastUpdated      "
                            + "Exp_Date      "
                            + "Mfg_Date      ");
                    while (result.next()) {

                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        String productTitle = result.getString("Title");
                        String productCategory = result.getString("Category");
                        String productSubCategory = result.getString("SubCategory");
                        String productManufactureCountry = result.getString("Manufacture_country");
                        String productDescription = result.getString("Description");
                        String productImgurl = result.getString("Imgurl");
                        int productInStock = result.getInt("InStock");
                        float productCostPrice = result.getFloat("CostPrice");
                        float productSellPrice = result.getFloat("SellPrice");
                        String productAddDate = result.getString("AddDate");
                        String productLastUpdated = result.getString("LastUpdated");
                        String productExpDate = result.getString("Exp_Date");
                        String productMfgDate = result.getString("Mfg_Date");

                        System.out.println("\n" + productID + "    "
                                + employeeID + "    "
                                + productTitle + "  "
                                + productCategory + "    "
                                + productSubCategory + "    "
                                + productManufactureCountry + "  "
                                + productDescription + "    "
                                + productImgurl + "  "
                                + productInStock + " "
                                + productCostPrice + "    "
                                + productSellPrice + "  "
                                + productAddDate + "    "
                                + productLastUpdated + "    "
                                + productExpDate + "  "
                                + productMfgDate + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 13) {

                System.out.print("Enter Sell Price (Higher) : ");

                int inputSellPrice = userInput.nextInt();
                try {

                    String sql = "Select * From Product WHERE SellPrice >= '" + inputSellPrice + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n ProductId   "
                            + "EmployeeId    "
                            + "Title    "
                            + "Category     "
                            + "SubCategory     "
                            + "Manufacture_country       "
                            + "Description    "
                            + "Imgurl    "
                            + "InStock     "
                            + "CostPrice      "
                            + "SellPrice      "
                            + "AddDate      "
                            + "LastUpdated      "
                            + "Exp_Date      "
                            + "Mfg_Date      ");
                    while (result.next()) {

                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        String productTitle = result.getString("Title");
                        String productCategory = result.getString("Category");
                        String productSubCategory = result.getString("SubCategory");
                        String productManufactureCountry = result.getString("Manufacture_country");
                        String productDescription = result.getString("Description");
                        String productImgurl = result.getString("Imgurl");
                        int productInStock = result.getInt("InStock");
                        float productCostPrice = result.getFloat("CostPrice");
                        float productSellPrice = result.getFloat("SellPrice");
                        String productAddDate = result.getString("AddDate");
                        String productLastUpdated = result.getString("LastUpdated");
                        String productExpDate = result.getString("Exp_Date");
                        String productMfgDate = result.getString("Mfg_Date");

                        System.out.println("\n" + productID + "    "
                                + employeeID + "    "
                                + productTitle + "  "
                                + productCategory + "    "
                                + productSubCategory + "    "
                                + productManufactureCountry + "  "
                                + productDescription + "    "
                                + productImgurl + "  "
                                + productInStock + " "
                                + productCostPrice + "    "
                                + productSellPrice + "  "
                                + productAddDate + "    "
                                + productLastUpdated + "    "
                                + productExpDate + "  "
                                + productMfgDate + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 14) {

                System.out.print("Enter Supplier ID: ");

                int inputSupplierID = userInput.nextInt();
                try {

                    String sql = "SELECT p.* FROM Product p JOIN SUPPLY supply ON supply.ProductId=p.ProductId WHERE supply.SupplierId = '" + inputSupplierID + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n ProductId   "
                            + "EmployeeId    "
                            + "Title    "
                            + "Category     "
                            + "SubCategory     "
                            + "Manufacture_country       "
                            + "Description    "
                            + "Imgurl    "
                            + "InStock     "
                            + "CostPrice      "
                            + "SellPrice      "
                            + "AddDate      "
                            + "LastUpdated      "
                            + "Exp_Date      "
                            + "Mfg_Date      ");
                    while (result.next()) {

                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        String productTitle = result.getString("Title");
                        String productCategory = result.getString("Category");
                        String productSubCategory = result.getString("SubCategory");
                        String productManufactureCountry = result.getString("Manufacture_country");
                        String productDescription = result.getString("Description");
                        String productImgurl = result.getString("Imgurl");
                        int productInStock = result.getInt("InStock");
                        float productCostPrice = result.getFloat("CostPrice");
                        float productSellPrice = result.getFloat("SellPrice");
                        String productAddDate = result.getString("AddDate");
                        String productLastUpdated = result.getString("LastUpdated");
                        String productExpDate = result.getString("Exp_Date");
                        String productMfgDate = result.getString("Mfg_Date");

                        System.out.println("\n" + productID + "    "
                                + employeeID + "    "
                                + productTitle + "  "
                                + productCategory + "    "
                                + productSubCategory + "    "
                                + productManufactureCountry + "  "
                                + productDescription + "    "
                                + productImgurl + "  "
                                + productInStock + " "
                                + productCostPrice + "    "
                                + productSellPrice + "  "
                                + productAddDate + "    "
                                + productLastUpdated + "    "
                                + productExpDate + "  "
                                + productMfgDate + "    ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 15) {

                try {

                    String sql = "SELECT Order_Details.ProductId,SUM(Qty) as 'Sold Amount' FROM Order_Details GROUP BY  Order_Details.ProductId ORDER BY SUM(Qty) DESC";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n OrderId   "
                            + "CustomerId    "
                            + "ProductId    "
                            + "EmployeeId     "
                            + "Qty     "
                            + "TotalPrice       "
                            + "Discount    "
                            + "Tax    "
                            + "FinalPrice     "
                            + "SoldDate      "
                            + "PaidStatus      ");
                    while (result.next()) {

                        int OrderId = result.getInt("OrderId");
                        int CustomerId = result.getInt("CustomerId");
                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        int orderQty = result.getInt("Qty");
                        float orderTotalPrice = result.getFloat("TotalPrice");
                        float orderDiscount = result.getFloat("Discount");
                        float orderTax = result.getFloat("Tax");
                        float orderFinalPrice = result.getFloat("FinalPrice");
                        String orderSoldDate = result.getString("SoldDate");
                        float orderPaidStatus = result.getByte("PaidStatus");

                        System.out.println("\n" + OrderId + "    "
                                + CustomerId + "    "
                                + productID + "  "
                                + employeeID + "    "
                                + orderQty + "    "
                                + orderTotalPrice + "  "
                                + orderDiscount + "    "
                                + orderTax + "  "
                                + orderFinalPrice + " "
                                + orderSoldDate + "    "
                                + orderPaidStatus + "  ");
                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 16) {

                System.out.print("Enter SoldDate From: ");
                userInput.nextLine();
                String inputSoldDateFrom = userInput.nextLine();
                System.out.print("Enter SoldDate To: ");
                String inputSoldDateTo = userInput.nextLine();

                try {

                    String sql = "select P.*,Order_Details.SoldDate from Order_Details LEFT JOIN Product P ON Order_details.ProductId=P.ProductId where SoldDate BETWEEN '" + inputSoldDateFrom + "'  AND  '" + inputSoldDateTo + "' ORDER BY SoldDate DESC ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n OrderId   "
                            + "CustomerId    "
                            + "ProductId    "
                            + "EmployeeId     "
                            + "Qty     "
                            + "TotalPrice       "
                            + "Discount    "
                            + "Tax    "
                            + "FinalPrice     "
                            + "SoldDate      "
                            + "PaidStatus      ");
                    while (result.next()) {

                        int OrderId = result.getInt("OrderId");
                        int CustomerId = result.getInt("CustomerId");
                        int productID = result.getInt("ProductId");
                        int employeeID = result.getInt("EmployeeId");
                        int orderQty = result.getInt("Qty");
                        float orderTotalPrice = result.getFloat("TotalPrice");
                        float orderDiscount = result.getFloat("Discount");
                        float orderTax = result.getFloat("Tax");
                        float orderFinalPrice = result.getFloat("FinalPrice");
                        String orderSoldDate = result.getString("SoldDate");
                        float orderPaidStatus = result.getByte("PaidStatus");

                        System.out.println("\n" + OrderId + "    "
                                + CustomerId + "    "
                                + productID + "  "
                                + employeeID + "    "
                                + orderQty + "    "
                                + orderTotalPrice + "  "
                                + orderDiscount + "    "
                                + orderTax + "  "
                                + orderFinalPrice + " "
                                + orderSoldDate + "    "
                                + orderPaidStatus + "  ");
                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 17) {
                System.out.println("EXIT PROGRAM SUCCESSFUL");
                break;
            }

        }
    }

    static void queries_11() {
        while (true) {

            System.out.println("Search a payment by:\n"
                    + "1.-> Bill_id: \n"
                    + "2.-> Payment date: \n"
                    + "3->  EXIT: \n");

            System.out.println("Select Any Option:");
            selectedMenuOption = userInput.nextInt();

            if (selectedMenuOption == 1) {

                System.out.print("Enter Bill ID: ");
                int inputBillID = userInput.nextInt();

                try {

                    String sql = "Select * From PAYMENT WHERE Bill_Id = '" + inputBillID + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n Bill_Id   "
                            + "EmployeeId    "
                            + "OrderId    "
                            + "Pay_type     "
                            + "Pay_CardNo     "
                            + "PayDate       "
                            + "Pay_Time    "
                            + "PaidStatus    ");
                    while (result.next()) {

                        int billID = result.getInt("Bill_Id");
                        int employeeID = result.getInt("EmployeeId");
                        int orderID = result.getInt("OrderId");
                        String paymentType = result.getString("Pay_type");
                        String paymentCardNo = result.getString("Pay_CardNo");
                        String paymentDate = result.getString("PayDate");
                        String paymentTime = result.getString("Pay_Time");
                        String paymentStatus = result.getString("PaidStatus");

                        System.out.println("\n" + billID + "    "
                                + employeeID + "    "
                                + orderID + "  "
                                + paymentType + "    "
                                + paymentCardNo + "    "
                                + paymentDate + "  "
                                + paymentTime + "    "
                                + paymentStatus + "  ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 2) {

                System.out.print("Enter Date: ");
                userInput.nextLine();
                String inputDate = userInput.nextLine();
                System.out.print("Enter Time: ");
                String inputTime = userInput.nextLine();
                try {

                    String sql = "SELECT * FROM PAYMENT  WHERE PayDate = '" + inputDate + "' AND DATEDIFF(second, pay_time, '" + inputTime + "')<1  ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n Bill_Id   "
                            + "EmployeeId    "
                            + "OrderId    "
                            + "Pay_type     "
                            + "Pay_CardNo     "
                            + "PayDate       "
                            + "Pay_Time    "
                            + "PaidStatus    ");
                    while (result.next()) {

                        int billID = result.getInt("Bill_Id");
                        int employeeID = result.getInt("EmployeeId");
                        int orderID = result.getInt("OrderId");
                        String paymentType = result.getString("Pay_type");
                        String paymentCardNo = result.getString("Pay_CardNo");
                        String paymentDate = result.getString("PayDate");
                        String paymentTime = result.getString("Pay_Time");
                        String paymentStatus = result.getString("PaidStatus");

                        System.out.println("\n" + billID + "    "
                                + employeeID + "    "
                                + orderID + "  "
                                + paymentType + "    "
                                + paymentCardNo + "    "
                                + paymentDate + "  "
                                + paymentTime + "    "
                                + paymentStatus + "  ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }
            } else if (selectedMenuOption == 3) {
                System.out.println("EXIT PROGRAM SUCCESSFUL");
                break;
            }

        }
    }

    static void queries_12() {
         while (true) {

            System.out.println("Show all payments which:\n"
                    + "1.-> Are paid (paid status): \n"
                    + "2.-> Aren’t paid: \n"
                    + "3.-> Are between xDate-yDate: \n"
                    + "4.-> Handled by particular Employee (Eid): \n"
                    + "5.-> Paid through card: \n"
                    + "6.-> Paid through cash: \n"
                    + "7.-> EXIT: \n");

            System.out.println("Select Any Option:");
            selectedMenuOption = userInput.nextInt();

            if (selectedMenuOption == 1) {
                try {

                    String sql = "SELECT * FROM PAYMENT WHERE PaidStatus=1";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n Bill_Id   "
                            + "EmployeeId    "
                            + "OrderId    "
                            + "Pay_type     "
                            + "Pay_CardNo     "
                            + "PayDate       "
                            + "Pay_Time    "
                            + "PaidStatus    ");
                    while (result.next()) {

                        int billID = result.getInt("Bill_Id");
                        int employeeID = result.getInt("EmployeeId");
                        int orderID = result.getInt("OrderId");
                        String paymentType = result.getString("Pay_type");
                        String paymentCardNo = result.getString("Pay_CardNo");
                        String paymentDate = result.getString("PayDate");
                        String paymentTime = result.getString("Pay_Time");
                        String paymentStatus = result.getString("PaidStatus");

                        System.out.println("\n" + billID + "    "
                                + employeeID + "    "
                                + orderID + "  "
                                + paymentType + "    "
                                + paymentCardNo + "    "
                                + paymentDate + "  "
                                + paymentTime + "    "
                                + paymentStatus + "  ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }

            } else if (selectedMenuOption == 2) {
                try {

                    String sql = "SELECT * FROM PAYMENT WHERE PaidStatus=2 ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n Bill_Id   "
                            + "EmployeeId    "
                            + "OrderId    "
                            + "Pay_type     "
                            + "Pay_CardNo     "
                            + "PayDate       "
                            + "Pay_Time    "
                            + "PaidStatus    ");
                    while (result.next()) {

                        int billID = result.getInt("Bill_Id");
                        int employeeID = result.getInt("EmployeeId");
                        int orderID = result.getInt("OrderId");
                        String paymentType = result.getString("Pay_type");
                        String paymentCardNo = result.getString("Pay_CardNo");
                        String paymentDate = result.getString("PayDate");
                        String paymentTime = result.getString("Pay_Time");
                        String paymentStatus = result.getString("PaidStatus");

                        System.out.println("\n" + billID + "    "
                                + employeeID + "    "
                                + orderID + "  "
                                + paymentType + "    "
                                + paymentCardNo + "    "
                                + paymentDate + "  "
                                + paymentTime + "    "
                                + paymentStatus + "  ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }
            } else if (selectedMenuOption == 3) {

                System.out.print("Enter Date From: ");
                userInput.nextLine();
                String inputDateFrom = userInput.nextLine();
                System.out.print("Enter Date To: ");
                String inputDateToFrom = userInput.nextLine();
                try {

                    String sql = "SELECT * FROM PAYMENT WHERE PayDate BETWEEN '" + inputDateFrom + "' AND '" + inputDateToFrom + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n Bill_Id   "
                            + "EmployeeId    "
                            + "OrderId    "
                            + "Pay_type     "
                            + "Pay_CardNo     "
                            + "PayDate       "
                            + "Pay_Time    "
                            + "PaidStatus    ");
                    while (result.next()) {

                        int billID = result.getInt("Bill_Id");
                        int employeeID = result.getInt("EmployeeId");
                        int orderID = result.getInt("OrderId");
                        String paymentType = result.getString("Pay_type");
                        String paymentCardNo = result.getString("Pay_CardNo");
                        String paymentDate = result.getString("PayDate");
                        String paymentTime = result.getString("Pay_Time");
                        String paymentStatus = result.getString("PaidStatus");

                        System.out.println("\n" + billID + "    "
                                + employeeID + "    "
                                + orderID + "  "
                                + paymentType + "    "
                                + paymentCardNo + "    "
                                + paymentDate + "  "
                                + paymentTime + "    "
                                + paymentStatus + "  ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }
            } else if (selectedMenuOption == 4) {

                System.out.print("Enter Employee ID: ");
                int inputEmployeeId = userInput.nextInt();

                try {

                    String sql = "SELECT * FROM PAYMENT WHERE EmployeeId = '" + inputEmployeeId + "' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n Bill_Id   "
                            + "EmployeeId    "
                            + "OrderId    "
                            + "Pay_type     "
                            + "Pay_CardNo     "
                            + "PayDate       "
                            + "Pay_Time    "
                            + "PaidStatus    ");
                    while (result.next()) {

                        int billID = result.getInt("Bill_Id");
                        int employeeID = result.getInt("EmployeeId");
                        int orderID = result.getInt("OrderId");
                        String paymentType = result.getString("Pay_type");
                        String paymentCardNo = result.getString("Pay_CardNo");
                        String paymentDate = result.getString("PayDate");
                        String paymentTime = result.getString("Pay_Time");
                        String paymentStatus = result.getString("PaidStatus");

                        System.out.println("\n" + billID + "    "
                                + employeeID + "    "
                                + orderID + "  "
                                + paymentType + "    "
                                + paymentCardNo + "    "
                                + paymentDate + "  "
                                + paymentTime + "    "
                                + paymentStatus + "  ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }
            } else if (selectedMenuOption == 5) {

                try {

                    String sql = "SELECT * FROM PAYMENT WHERE Pay_Type='Card' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n Bill_Id   "
                            + "EmployeeId    "
                            + "OrderId    "
                            + "Pay_type     "
                            + "Pay_CardNo     "
                            + "PayDate       "
                            + "Pay_Time    "
                            + "PaidStatus    ");
                    while (result.next()) {

                        int billID = result.getInt("Bill_Id");
                        int employeeID = result.getInt("EmployeeId");
                        int orderID = result.getInt("OrderId");
                        String paymentType = result.getString("Pay_type");
                        String paymentCardNo = result.getString("Pay_CardNo");
                        String paymentDate = result.getString("PayDate");
                        String paymentTime = result.getString("Pay_Time");
                        String paymentStatus = result.getString("PaidStatus");

                        System.out.println("\n" + billID + "    "
                                + employeeID + "    "
                                + orderID + "  "
                                + paymentType + "    "
                                + paymentCardNo + "    "
                                + paymentDate + "  "
                                + paymentTime + "    "
                                + paymentStatus + "  ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }
            } else if (selectedMenuOption == 6) {

                System.out.print("Enter Date: ");
                userInput.nextLine();
                String inputDate = userInput.nextLine();
                System.out.print("Enter Time: ");
                String inputTime = userInput.nextLine();
                try {

                    String sql = "SELECT * FROM PAYMENT WHERE Pay_Type='Cash' ";

                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

//                    int rows = statement.executeUpdate(sql);
//                   
//                    if (rows > 0) {
//                        System.out.println("QUERY SUCCESSFUL");
//                    }
                    System.out.println("RESULT:");
                    System.out.println("\n Bill_Id   "
                            + "EmployeeId    "
                            + "OrderId    "
                            + "Pay_type     "
                            + "Pay_CardNo     "
                            + "PayDate       "
                            + "Pay_Time    "
                            + "PaidStatus    ");
                    while (result.next()) {

                        int billID = result.getInt("Bill_Id");
                        int employeeID = result.getInt("EmployeeId");
                        int orderID = result.getInt("OrderId");
                        String paymentType = result.getString("Pay_type");
                        String paymentCardNo = result.getString("Pay_CardNo");
                        String paymentDate = result.getString("PayDate");
                        String paymentTime = result.getString("Pay_Time");
                        String paymentStatus = result.getString("PaidStatus");

                        System.out.println("\n" + billID + "    "
                                + employeeID + "    "
                                + orderID + "  "
                                + paymentType + "    "
                                + paymentCardNo + "    "
                                + paymentDate + "  "
                                + paymentTime + "    "
                                + paymentStatus + "  ");

                    }

                    //connection.close();
                } catch (SQLException e) {
                    System.out.println("ERROR! UNSUCCESSFUL QUERY");
                    e.printStackTrace();
                }
            } else if (selectedMenuOption == 7) {
                System.out.println("EXIT PROGRAM SUCCESSFUL");
                break;
            }

        }

    
    }

    static Connection getCon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
