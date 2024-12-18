/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DashBoard;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.codejava.sql.ConnectionToSQL;

/**
 *
 * @author rahat
 */
public class DashBoard extends javax.swing.JFrame {

    /**
     * Creates new form DashBoard
     */
    public DashBoard() {
        initComponents();
        
        home_panel.setVisible(true);
        products_panel.setVisible(false);
        employee_panel.setVisible(false);
        customer_panel.setVisible(false);
        add_product_panel.setVisible(false);
        order_details_panel.setVisible(false);
        payments_panel.setVisible(false);
        supplies_panel.setVisible(false);
        supplier_panel.setVisible(false);
        add_employee_panel.setVisible(false);
        
        homepage_details();
    }
    
    public void homepage_details(){
        try{
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT COUNT(CustomerId) AS total_customer FROM Customer";
            
            ResultSet rs = st.executeQuery(sql);
            
            
            while(rs.next()){
                String total_customer = rs.getString("total_customer");   
                dashBoard_customer_tf.setText(total_customer);
            }
         
            con.close();
            
        }catch(SQLException e){
            
        }
        
        try{
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            
            String sql = "SELECT COUNT (SupplyId) AS total_supplies FROM SUPPLY";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String total_supplies = rs.getString("total_supplies");
                dashboard_supplyDetails_tf.setText(total_supplies);
            }
            con.close();
            
        }catch(SQLException e){
            
        }
        
        try{
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            
            String sql = "SELECT SUM (InStock) AS total_products FROM Product";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String total_products = rs.getString("total_products");
                dashBoard_product_tf.setText(total_products);
            }
            con.close();
            
        }catch(SQLException e){
            
        }
        
        try{
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            
            String sql = "SELECT COUNT (OrderId) AS total_orders FROM Order_Details";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String total_orders = rs.getString("total_orders");
                dashBoard_orderDetails_tf.setText(total_orders);
            }
            con.close();
            
        }catch(SQLException e){
            
        }
        
        try{
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            
            String sql = "SELECT COUNT (Bill_Id) AS total_payments FROM Payment";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String total_payments = rs.getString("total_payments");
                dashBoard_paymentDetails_tf.setText(total_payments);
            }
            con.close();
            
        }catch(SQLException e){
            
        }
        
        try{
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT COUNT(CustomerId) AS total_customer FROM Customer";
            
            ResultSet rs = st.executeQuery(sql);
            
            
            while(rs.next()){
                String total_customer = rs.getString("total_customer");   
                dashBoard_a_customer_tf.setText(total_customer);
            }
         
            con.close();
            
        }catch(SQLException e){
            
        }
        
        try{
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            
            String sql = "SELECT COUNT (SupplyId) AS total_supplies FROM SUPPLY";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String total_supplies = rs.getString("total_supplies");
                dashboard_a_supplyDetails_tf.setText(total_supplies);
            }
            con.close();
            
        }catch(SQLException e){
            
        }
        
        try{
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            
            String sql = "SELECT SUM (InStock) AS total_products FROM Product";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String total_products = rs.getString("total_products");
                dashBoard_a_product_tf.setText(total_products);
            }
            con.close();
            
        }catch(SQLException e){
            
        }
        
        try{
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            
            String sql = "SELECT COUNT (OrderId) AS total_orders FROM Order_Details";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String total_orders = rs.getString("total_orders");
                dashBoard_a_orderDetails_tf.setText(total_orders);
            }
            con.close();
            
        }catch(SQLException e){
            
        }
        
        try{
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            
            String sql = "SELECT COUNT (Bill_Id) AS total_payments FROM Payment";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String total_payments = rs.getString("total_payments");
                dashBoard_a_paymentDetails_tf.setText(total_payments);
            }
            con.close();
            
        }catch(SQLException e){
            
        }
        
        try{
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            
            String sql = "SELECT COUNT (EmployeeId) AS total_employees FROM Employee";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String total_employees = rs.getString("total_employees");
                dashBoard_a_employees_tf.setText(total_employees);
            }
            con.close();
            
        }catch(SQLException e){
            
        }
        
        try{
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            
            String sql = "SELECT COUNT (SupplierId) AS total_supplier FROM SUPPLIER";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String total_supplier = rs.getString("total_supplier");
                dashBoard_a_supplierDetails_tf.setText(total_supplier);
            }
            con.close();
            
        }catch(SQLException e){
            
        }
    }
    
    public void productTable(String sql){
        try{
            productTable.setModel(new DefaultTableModel(null, new String[]{"ID","EmployeeId","Title","Category","SubCategory","Manufacture_country","Description","Imgurl","InStock","CostPrice","SellPrice","AddDate","LastUpdated","Exp_Date","Mfg_Date"}));
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String ID = rs.getString("ProductId");
                String EmployeeId = rs.getString("EmployeeId");
                String Title = rs.getString("Title");
                String Category = rs.getString("Category");
                String SubCategory = rs.getString("SubCategory");
                String Manufacture_country = rs.getString("Manufacture_country");
                String Description = rs.getString("Description");
                String Imgurl = rs.getString("Imgurl");
                String InStock = rs.getString("InStock");
                String CostPrice = rs.getString("CostPrice");
                String SellPrice = rs.getString("SellPrice");
                String AddDate = rs.getString("AddDate");
                String LastUpdated = rs.getString("LastUpdated");
                String Exp_Date = rs.getString("Exp_Date");
                String Mfg_Date = rs.getString("Mfg_Date");
               
                String tbData[] = {ID,EmployeeId,Title,Category,SubCategory,Manufacture_country,Description,Imgurl,InStock,CostPrice,SellPrice,AddDate,LastUpdated,Exp_Date,Mfg_Date};
                DefaultTableModel tblModel = (DefaultTableModel)productTable.getModel();
                tblModel.addRow(tbData);
                
            }
            con.close();
            
        }catch(SQLException e){
            
        }
    }
    
    public void addProduct(){
        try{
            Connection con = ConnectionToSQL.getConnection();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            
            
            String url = "insert into Product (EmployeeId, Title, Category, SubCategory, Manufacture_country, Description, Imgurl, InStock, CostPrice, SellPrice, Mfg_Date, Exp_Date) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = con.prepareStatement(url);
            ps.setString(1, employeeID_tf.getText());
            ps.setString(2, title_tf.getText());
            ps.setString(3, category_tf.getText());
            ps.setString(4, subcategory_tf.getText());
            ps.setString(5, manufacterCountry_tf.getText());
            ps.setString(6, description_ta.getText());
            ps.setString(7, imgurl_tf.getText());
            ps.setString(8, instock_tf.getText());
            ps.setString(9, costPrice_tf.getText());
            ps.setString(10, salePrice_tf.getText());
            ps.setString(11, df.format(mfg_dc.getDate()));
            ps.setString(12, df.format(exp_dc.getDate()));
            
            int i = ps.executeUpdate();
            
            if(i>0){
                JOptionPane.showMessageDialog(this, "Record saved Successfully!!");
            }
            
        }catch(SQLException e){
            
        } 
    }
    
    public void updateProduct(String ProductId){
        try{
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT EmployeeId, Title, Category, SubCategory, Manufacture_country, Description, Imgurl, InStock, CostPrice, SellPrice, Mfg_Date, Exp_Date FROM Product WHERE ProductId = "+ProductId+" ";
            
            ResultSet rs = st.executeQuery(sql);
            
           
            while(rs.next()){
                /*String total_customer = rs.getString("total_customer");   
                dashBoard_customer_tf.setText(total_customer);*/
                //String EmployeeId = rs.getString("EmployeeId");
                employeeID_tf.setText(rs.getString("EmployeeId"));
                title_tf.setText(rs.getString("Title"));
                category_tf.setText(rs.getString("Category"));
                subcategory_tf.setText(rs.getString("SubCategory"));
                manufacterCountry_tf.setText(rs.getString("Manufacture_country"));
                description_ta.setText(rs.getString("Description"));
                imgurl_tf.setText(rs.getString("Imgurl"));
                instock_tf.setText(rs.getString("InStock"));
                costPrice_tf.setText(rs.getString("CostPrice"));
                salePrice_tf.setText(rs.getString("SellPrice"));
                mfgDate_tf.setText(rs.getString("Mfg_Date"));
                expDate_tf.setText(rs.getString("Exp_Date"));
            }
         
            con.close();
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void employeeTable(String sql){
        try{
            employeeTable.setModel(new DefaultTableModel(null, new String[]{"EmployeeId","Name","DOB","NID","PhoneNumber","Email","Address","EmployStatus","Position","JoiningDate","Salary","Experience","Gender"}));
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String EmployeeId = rs.getString("EmployeeId");
                String Name = rs.getString("Name");
                String DOB = rs.getString("DOB");
                String NID = rs.getString("NID");
                String PhoneNumber = rs.getString("PhoneNumber");
                String Email = rs.getString("Email");
                String Address = rs.getString("Address");
                String EmployStatus = rs.getString("EmployStatus");
                String Position = rs.getString("Position");
                String JoiningDate = rs.getString("JoiningDate");
                String Salary = rs.getString("Salary");
                String Experience = rs.getString("Experience");
                String Gender = rs.getString("Gender");
                
               
                String tbData[] = {EmployeeId,Name,DOB,NID,PhoneNumber,Email,Address,EmployStatus,Position,JoiningDate,Salary,Experience,Gender};
                DefaultTableModel tblModel = (DefaultTableModel)employeeTable.getModel();
                tblModel.addRow(tbData);
                
            }
            con.close();
            
        }catch(SQLException e){
            
        }
    }
    
    public void addEmployee(){
        try{
            Connection con = ConnectionToSQL.getConnection();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            
            
            String url = "insert into Employee (EmployeePass, Name, DOB, NID, PhoneNumber, Email, Address, EmployStatus, Position, Salary, Experience, Gender) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = con.prepareStatement(url);
            ps.setString(1, employeePass_tf.getText());
            ps.setString(2, employeeName_tf.getText());
            ps.setString(3, df.format(dob_dc.getDate()));
            ps.setString(4, nid_tf.getText());
            ps.setString(5, phoneNo_tf.getText());
            ps.setString(6, employeeEmail_tf.getText());
            ps.setString(7, employeeaddress_tf.getText());
            ps.setString(8, EmployStatus_tf.getText());
            ps.setString(9, Position_tf.getText());
            ps.setString(10, employeesalary_tf.getText());
            ps.setString(11, Experience_tf.getText());
            ps.setString(12, Gender_tf.getText());
            
            int i = ps.executeUpdate();
            
            if(i>0){
                JOptionPane.showMessageDialog(this, "Record saved Successfully!!");
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void supplyTable(String sql){
        try{
            suppliesTable.setModel(new DefaultTableModel(null, new String[]{"Supply Id","Product Id","Supplier Id","Employee Id","Supply Date","Quantity","Cost Price","Total Cost Price"}));
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String Supply_Id = rs.getString("SupplyId");
                String Product_Id = rs.getString("ProductId");
                String Supplier_Id = rs.getString("SupplierId");
                String Employee_Id = rs.getString("EmployeeId");
                String Supply_Date = rs.getString("SupplyDate");
                String Quantity = rs.getString("Qty");
                String Cost_Price = rs.getString("CostPrice");
                String Total_Cost_Price = rs.getString("Total_CostPrice");
                
               
                String tbData[] = {Supply_Id,Product_Id,Supplier_Id,Employee_Id,Supply_Date,Quantity,Cost_Price,Total_Cost_Price};
                DefaultTableModel tblModel = (DefaultTableModel)suppliesTable.getModel();
                tblModel.addRow(tbData);
                
            }
            con.close();
            
        }catch(SQLException e){
            System.out.println("ERROR! UNSUCCESSFUL QUERY");
        }
    }
    
    public void supplierTable(String sql){
        try{
            supplierTable.setModel(new DefaultTableModel(null, new String[]{"Supplier Id","Name","Address","Phone Number","Email"}));
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String Supplier_Id = rs.getString("SupplierId");
                String name = rs.getString("Name");
                String address = rs.getString("Address");
                String phone_no = rs.getString("PhoneNumber");
                String email = rs.getString("Email");
                
                
               
                String tbData[] = {Supplier_Id,name,address,phone_no,email};
                DefaultTableModel tblModel = (DefaultTableModel)supplierTable.getModel();
                tblModel.addRow(tbData);
                
            }
            con.close();
            
        }catch(SQLException e){
            System.out.println("ERROR! UNSUCCESSFUL QUERY");
        }
    }
    
    public void order_details_table(String sql){
        try{
            order_details_Table.setModel(new DefaultTableModel(null, new String[]{"Order Id","Customer Id","Product Id","Employee Id","Quantity","Total Price","Discount","Tax","Final Price","Sold Date","Paid Status"}));
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String OrderId = rs.getString("OrderId");
                String CustomerId = rs.getString("CustomerId");
                String ProductId = rs.getString("ProductId");
                String EmployeeId = rs.getString("EmployeeId");
                String Qty = rs.getString("Qty");
                String TotalPrice = rs.getString("TotalPrice");
                String Discount = rs.getString("Discount");
                String Tax = rs.getString("Tax");
                String FinalPrice = rs.getString("FinalPrice");
                String SoldDate = rs.getString("SoldDate");
                String PaidStatus = rs.getString("PaidStatus");
                
               
                String tbData[] = {OrderId,CustomerId,ProductId,EmployeeId,Qty,TotalPrice,Discount,Tax,FinalPrice,SoldDate,PaidStatus};
                DefaultTableModel tblModel = (DefaultTableModel)order_details_Table.getModel();
                tblModel.addRow(tbData);
                
            }
            con.close();
            
        }catch(SQLException e){
            System.out.println("ERROR! UNSUCCESSFUL QUERY");
        }
    }
    
    public void order_details_table_2(String sql){
        try{
            order_details_Table.setModel(new DefaultTableModel(null, new String[]{"Goods sold"}));
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String goods_sold = rs.getString("goods_sold");
                
                String tbData[] = {goods_sold};
                DefaultTableModel tblModel = (DefaultTableModel)order_details_Table.getModel();
                tblModel.addRow(tbData);
                
            }
            con.close();
            
        }catch(SQLException e){
            System.out.println("ERROR! UNSUCCESSFUL QUERY");
        }
    }
    
    public void order_details_table_3(String sql){
        try{
            order_details_Table.setModel(new DefaultTableModel(null, new String[]{"Income"}));
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String Income = rs.getString("Income");
                
                String tbData[] = {Income};
                DefaultTableModel tblModel = (DefaultTableModel)order_details_Table.getModel();
                tblModel.addRow(tbData);
                
            }
            con.close();
            
        }catch(SQLException e){
            System.out.println("ERROR! UNSUCCESSFUL QUERY");
        }
    }
    
    public void order_details_table_4(String sql){
        try{
            order_details_Table.setModel(new DefaultTableModel(null, new String[]{"Profit"}));
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String Profit = rs.getString("Profit");
                
                String tbData[] = {Profit};
                DefaultTableModel tblModel = (DefaultTableModel)order_details_Table.getModel();
                tblModel.addRow(tbData);
                
            }
            con.close();
            
        }catch(SQLException e){
            System.out.println("ERROR! UNSUCCESSFUL QUERY");
        }
    }
    
    public void customerTable(String sql){
        try{
            customerTable.setModel(new DefaultTableModel(null, new String[]{"Customer Id","Employee Id","Name","Address","Phone Number","Email","Last Purchase","Purchase Qty","Spent Money","Gender"}));
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String CustomerId = rs.getString("CustomerId");
                String EmployeeId = rs.getString("EmployeeId");
                String Name = rs.getString("Name");
                String Address = rs.getString("Address");
                String PhoneNumber = rs.getString("PhoneNumber");
                String Email = rs.getString("Email");
                String LastPurchase = rs.getString("LastPurchase");
                String PurchaseQty = rs.getString("PurchaseQty");
                String SpentMoney = rs.getString("SpentMoney");
                String Gender = rs.getString("Gender");
                
               
                String tbData[] = {CustomerId,EmployeeId,Name,Address,PhoneNumber,Email,LastPurchase,PurchaseQty,SpentMoney,Gender};
                DefaultTableModel tblModel = (DefaultTableModel)customerTable.getModel();
                tblModel.addRow(tbData);
                
            }
            con.close();
            
        }catch(SQLException e){
            System.out.println("ERROR! UNSUCCESSFUL QUERY");
        }
    }
    
    public void paymentTable(String sql){
        try{
            paymentsTable.setModel(new DefaultTableModel(null, new String[]{"Bill_Id","Employee Id","Order Id","Pay_type","Pay_CardNo","PayDate","Pay_Time","Paid Status"}));
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String Bill_Id = rs.getString("Bill_Id");
                String EmployeeId = rs.getString("EmployeeId");
                String OrderId = rs.getString("OrderId");
                String Pay_type = rs.getString("Pay_type");
                String Pay_CardNo = rs.getString("Pay_CardNo");
                String PayDate = rs.getString("PayDate");
                String Pay_Time = rs.getString("Pay_Time");
                String PaidStatus = rs.getString("PaidStatus");
                
               
                String tbData[] = {Bill_Id,EmployeeId,OrderId,Pay_type,Pay_CardNo,PayDate,Pay_Time,PaidStatus};
                DefaultTableModel tblModel = (DefaultTableModel)paymentsTable.getModel();
                tblModel.addRow(tbData);
                
            }
            con.close();
            
        }catch(SQLException e){
            System.out.println("ERROR! UNSUCCESSFUL QUERY");
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        home_tab_panel = new javax.swing.JPanel();
        home_label = new javax.swing.JLabel();
        product_tab_panel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        employee_tab_panel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        customer_tab_panel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        order_details_tab_panel = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        payments_tab_panel = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        supplies_tab_panel = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        supplier_tab_panel = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        home_panel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        dashBoard_customer_tf = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        dashboard_supplyDetails_tf = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        dashBoard_product_tf = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        dashBoard_orderDetails_tf = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        dashBoard_paymentDetails_tf = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        dashBoard_a_customer_tf = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        dashboard_a_supplyDetails_tf = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        dashBoard_a_product_tf = new javax.swing.JTextField();
        jPanel30 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        dashBoard_a_orderDetails_tf = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        dashBoard_a_paymentDetails_tf = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        dashBoard_a_employees_tf = new javax.swing.JTextField();
        jPanel36 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        dashBoard_a_supplierDetails_tf = new javax.swing.JTextField();
        products_panel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField13 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        employee_panel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        employee_panel_comboBox = new javax.swing.JComboBox<>();
        employee_panel_search_tf = new javax.swing.JTextField();
        employee_panel_searchbutton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        employee_panel_tf2 = new javax.swing.JTextField();
        employee_panel_tf3 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        employee_panel_searchbutton1 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        employee_panel_tf4 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        add_product_panel = new javax.swing.JPanel();
        employeeID_tf = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        title_tf = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        category_tf = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        subcategory_tf = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        manufacterCountry_tf = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        instock_tf = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        costPrice_tf = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        salePrice_tf = new javax.swing.JTextField();
        imgurl_tf = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        description_ta = new javax.swing.JTextArea();
        product_add_btn = new javax.swing.JButton();
        product_reset_btn = new javax.swing.JButton();
        exp_dc = new com.toedter.calendar.JDateChooser();
        mfg_dc = new com.toedter.calendar.JDateChooser();
        productId_tf1 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        addproduct_panel_searchbutton = new javax.swing.JButton();
        expDate_tf = new javax.swing.JTextField();
        mfgDate_tf = new javax.swing.JTextField();
        product_update_btn = new javax.swing.JButton();
        customer_panel = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        customer_panel_tf2 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        customer_panel_comboBox1 = new javax.swing.JComboBox<>();
        customer_panel_search_tf1 = new javax.swing.JTextField();
        customer_panel_searchbutton1 = new javax.swing.JButton();
        customer_panel_comboBox2 = new javax.swing.JComboBox<>();
        jLabel60 = new javax.swing.JLabel();
        customer_panel_searchbutton2 = new javax.swing.JButton();
        customer_DateChooser1 = new com.toedter.calendar.JDateChooser();
        customer_DateChooser2 = new com.toedter.calendar.JDateChooser();
        order_details_panel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        order_details_Table = new javax.swing.JTable();
        order_details_panel_comboBox1 = new javax.swing.JComboBox<>();
        order_details_panel_search_tf1 = new javax.swing.JTextField();
        order_details_panel_searchbutton1 = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        order_details_panel_tf2 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        order_details_panel_comboBox2 = new javax.swing.JComboBox<>();
        jLabel59 = new javax.swing.JLabel();
        order_details_panel_comboBox3 = new javax.swing.JComboBox<>();
        order_details_panel_tf3 = new javax.swing.JTextField();
        order_details_panel_tf4 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        order_details_panel_searchbutton2 = new javax.swing.JButton();
        payments_panel = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        payments_panel_tf2 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        paymentsTable = new javax.swing.JTable();
        payments_panel_comboBox1 = new javax.swing.JComboBox<>();
        payments_panel_search_tf1 = new javax.swing.JTextField();
        payments_panel_searchbutton1 = new javax.swing.JButton();
        payments_panel_comboBox2 = new javax.swing.JComboBox<>();
        payments_panel_searchbutton2 = new javax.swing.JButton();
        supplies_panel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        suppliesTable = new javax.swing.JTable();
        supplies_panel_comboBox1 = new javax.swing.JComboBox<>();
        supplies_panel_search_tf1 = new javax.swing.JTextField();
        supplies_panel_searchbutton = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        supplies_panel_tf5 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        supplier_panel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        supplierTable = new javax.swing.JTable();
        supplier_panel_comboBox = new javax.swing.JComboBox<>();
        supplier_panel_search_tf1 = new javax.swing.JTextField();
        supplier_panel_searchbutton = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        supplier_panel_tf2 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        add_employee_panel = new javax.swing.JPanel();
        employeePass_tf = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        employeeName_tf = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        nid_tf = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        phoneNo_tf = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        employeeEmail_tf = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        Position_tf = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        employeesalary_tf = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        Experience_tf = new javax.swing.JTextField();
        EmployStatus_tf = new javax.swing.JTextField();
        employee_add_btn = new javax.swing.JButton();
        employee_reset_btn = new javax.swing.JButton();
        dob_dc = new com.toedter.calendar.JDateChooser();
        employeeId_tf = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        addemployee_panel_searchbutton = new javax.swing.JButton();
        Gender_tf = new javax.swing.JTextField();
        employee_update_btn = new javax.swing.JButton();
        employeeaddress_tf = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        dob_tf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1024, 600));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 0, 102), new java.awt.Color(204, 0, 204), null, null));
        jPanel1.setForeground(new java.awt.Color(51, 51, 55));
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 600));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setForeground(new java.awt.Color(51, 51, 55));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("MV Boli", 0, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Inventory");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 42, 176, 32));

        jLabel6.setFont(new java.awt.Font("MV Boli", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Management");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 80, 186, 32));

        home_tab_panel.setBackground(new java.awt.Color(0, 102, 102));
        home_tab_panel.setForeground(new java.awt.Color(255, 255, 255));
        home_tab_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home_tab_panelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                home_tab_panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                home_tab_panelMouseExited(evt);
            }
        });
        home_tab_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home_label.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        home_label.setForeground(new java.awt.Color(255, 255, 255));
        home_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home_label.setText("Home");
        home_tab_panel.add(home_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 12, 120, 27));

        jPanel2.add(home_tab_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 250, 50));

        product_tab_panel.setBackground(new java.awt.Color(51, 51, 51));
        product_tab_panel.setForeground(new java.awt.Color(255, 255, 255));
        product_tab_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_tab_panelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                product_tab_panelMouseEntered(evt);
            }
        });
        product_tab_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Products");
        product_tab_panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 12, 120, 27));

        jPanel2.add(product_tab_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 250, 50));

        employee_tab_panel.setBackground(new java.awt.Color(51, 51, 51));
        employee_tab_panel.setForeground(new java.awt.Color(255, 255, 255));
        employee_tab_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employee_tab_panelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                employee_tab_panelMouseEntered(evt);
            }
        });
        employee_tab_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Employee");
        employee_tab_panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 12, 120, 27));

        jPanel2.add(employee_tab_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 250, 50));

        customer_tab_panel.setBackground(new java.awt.Color(51, 51, 51));
        customer_tab_panel.setForeground(new java.awt.Color(255, 255, 255));
        customer_tab_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customer_tab_panelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                customer_tab_panelMouseEntered(evt);
            }
        });
        customer_tab_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Customer");
        customer_tab_panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 12, 190, 27));

        jPanel2.add(customer_tab_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 250, 50));

        jSeparator1.setForeground(new java.awt.Color(222, 222, 222));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 230, 10));

        order_details_tab_panel.setBackground(new java.awt.Color(51, 51, 51));
        order_details_tab_panel.setForeground(new java.awt.Color(255, 255, 255));
        order_details_tab_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                order_details_tab_panelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                order_details_tab_panelMouseEntered(evt);
            }
        });
        order_details_tab_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Order Details");
        order_details_tab_panel.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 12, 200, 27));

        jPanel2.add(order_details_tab_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 250, 50));

        payments_tab_panel.setBackground(new java.awt.Color(51, 51, 51));
        payments_tab_panel.setForeground(new java.awt.Color(255, 255, 255));
        payments_tab_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                payments_tab_panelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                payments_tab_panelMouseEntered(evt);
            }
        });
        payments_tab_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Payments");
        payments_tab_panel.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 12, 190, 27));

        jPanel2.add(payments_tab_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 250, 50));

        supplies_tab_panel.setBackground(new java.awt.Color(51, 51, 51));
        supplies_tab_panel.setForeground(new java.awt.Color(255, 255, 255));
        supplies_tab_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplies_tab_panelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                supplies_tab_panelMouseEntered(evt);
            }
        });
        supplies_tab_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Supplies");
        supplies_tab_panel.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 12, 120, 27));

        jPanel2.add(supplies_tab_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 250, 50));

        supplier_tab_panel.setBackground(new java.awt.Color(51, 51, 51));
        supplier_tab_panel.setForeground(new java.awt.Color(255, 255, 255));
        supplier_tab_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplier_tab_panelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                supplier_tab_panelMouseEntered(evt);
            }
        });
        supplier_tab_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Supplier");
        supplier_tab_panel.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 12, 120, 27));

        jPanel2.add(supplier_tab_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 250, 50));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setPreferredSize(new java.awt.Dimension(774, 600));
        jPanel3.setLayout(new javax.swing.OverlayLayout(jPanel3));

        home_panel.setBackground(new java.awt.Color(0, 102, 102));
        home_panel.setForeground(new java.awt.Color(0, 102, 102));
        home_panel.setPreferredSize(new java.awt.Dimension(774, 600));
        home_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home_panelMouseClicked(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(0, 102, 102));
        jTabbedPane1.setForeground(new java.awt.Color(0, 102, 102));

        jPanel12.setBackground(new java.awt.Color(0, 102, 102));
        jPanel12.setForeground(new java.awt.Color(0, 102, 102));
        jPanel12.setPreferredSize(new java.awt.Dimension(774, 600));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-customer-48.png")); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Customers");

        dashBoard_customer_tf.setEditable(false);
        dashBoard_customer_tf.setBackground(new java.awt.Color(255, 255, 255));
        dashBoard_customer_tf.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        dashBoard_customer_tf.setForeground(new java.awt.Color(51, 51, 51));
        dashBoard_customer_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dashBoard_customer_tf.setBorder(null);
        dashBoard_customer_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashBoard_customer_tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashBoard_customer_tf)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addComponent(dashBoard_customer_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel12.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 120, 72));

        jPanel16.setBackground(new java.awt.Color(0, 51, 51));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-details-48.png")); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Supply-Details");

        dashboard_supplyDetails_tf.setEditable(false);
        dashboard_supplyDetails_tf.setBackground(new java.awt.Color(255, 255, 255));
        dashboard_supplyDetails_tf.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        dashboard_supplyDetails_tf.setForeground(new java.awt.Color(51, 51, 51));
        dashboard_supplyDetails_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dashboard_supplyDetails_tf.setBorder(null);
        dashboard_supplyDetails_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboard_supplyDetails_tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboard_supplyDetails_tf)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addComponent(dashboard_supplyDetails_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel12.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, 72));

        jPanel18.setBackground(new java.awt.Color(0, 51, 51));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-product-48.png")); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, -1, -1));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Products");

        dashBoard_product_tf.setEditable(false);
        dashBoard_product_tf.setBackground(new java.awt.Color(255, 255, 255));
        dashBoard_product_tf.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        dashBoard_product_tf.setForeground(new java.awt.Color(51, 51, 51));
        dashBoard_product_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dashBoard_product_tf.setBorder(null);
        dashBoard_product_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashBoard_product_tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashBoard_product_tf)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addComponent(dashBoard_product_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel12.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 120, 72));

        jPanel20.setBackground(new java.awt.Color(0, 51, 51));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-order-48.png")); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Order-Detais");

        dashBoard_orderDetails_tf.setEditable(false);
        dashBoard_orderDetails_tf.setBackground(new java.awt.Color(255, 255, 255));
        dashBoard_orderDetails_tf.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        dashBoard_orderDetails_tf.setForeground(new java.awt.Color(51, 51, 51));
        dashBoard_orderDetails_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dashBoard_orderDetails_tf.setBorder(null);
        dashBoard_orderDetails_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashBoard_orderDetails_tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashBoard_orderDetails_tf)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addComponent(dashBoard_orderDetails_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(5, 5, 5))
        );

        jPanel12.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, -1, 72));

        jPanel22.setBackground(new java.awt.Color(0, 51, 51));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-paper-money-48.png")); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, -1, -1));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Payment-Detais");

        dashBoard_paymentDetails_tf.setEditable(false);
        dashBoard_paymentDetails_tf.setBackground(new java.awt.Color(255, 255, 255));
        dashBoard_paymentDetails_tf.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        dashBoard_paymentDetails_tf.setForeground(new java.awt.Color(51, 51, 51));
        dashBoard_paymentDetails_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dashBoard_paymentDetails_tf.setBorder(null);
        dashBoard_paymentDetails_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashBoard_paymentDetails_tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashBoard_paymentDetails_tf)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addComponent(dashBoard_paymentDetails_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(5, 5, 5))
        );

        jPanel12.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, 72));

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Reload");
        jButton3.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel12.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 510, 60, 30));

        jTabbedPane1.addTab("Employee", jPanel12);

        jPanel13.setBackground(new java.awt.Color(0, 102, 102));
        jPanel13.setForeground(new java.awt.Color(0, 102, 102));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel24.setBackground(new java.awt.Color(0, 51, 51));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-customer-48.png")); // NOI18N

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Customers");

        dashBoard_a_customer_tf.setEditable(false);
        dashBoard_a_customer_tf.setBackground(new java.awt.Color(255, 255, 255));
        dashBoard_a_customer_tf.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        dashBoard_a_customer_tf.setForeground(new java.awt.Color(51, 51, 51));
        dashBoard_a_customer_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dashBoard_a_customer_tf.setText("123");
        dashBoard_a_customer_tf.setBorder(null);
        dashBoard_a_customer_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashBoard_a_customer_tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashBoard_a_customer_tf)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addComponent(dashBoard_a_customer_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel13.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 140, 72));

        jPanel26.setBackground(new java.awt.Color(0, 51, 51));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-details-48.png")); // NOI18N

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Supply-Details");

        dashboard_a_supplyDetails_tf.setEditable(false);
        dashboard_a_supplyDetails_tf.setBackground(new java.awt.Color(255, 255, 255));
        dashboard_a_supplyDetails_tf.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        dashboard_a_supplyDetails_tf.setForeground(new java.awt.Color(51, 51, 51));
        dashboard_a_supplyDetails_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dashboard_a_supplyDetails_tf.setText("123");
        dashboard_a_supplyDetails_tf.setBorder(null);
        dashboard_a_supplyDetails_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboard_a_supplyDetails_tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboard_a_supplyDetails_tf)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addComponent(dashboard_a_supplyDetails_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel13.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 140, 72));

        jPanel28.setBackground(new java.awt.Color(0, 51, 51));

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-product-48.png")); // NOI18N

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, -1, -1));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Products");

        dashBoard_a_product_tf.setEditable(false);
        dashBoard_a_product_tf.setBackground(new java.awt.Color(255, 255, 255));
        dashBoard_a_product_tf.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        dashBoard_a_product_tf.setForeground(new java.awt.Color(51, 51, 51));
        dashBoard_a_product_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dashBoard_a_product_tf.setText("123");
        dashBoard_a_product_tf.setBorder(null);
        dashBoard_a_product_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashBoard_a_product_tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashBoard_a_product_tf)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addComponent(dashBoard_a_product_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel13.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 130, 72));

        jPanel30.setBackground(new java.awt.Color(0, 51, 51));

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-order-48.png")); // NOI18N

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Order-Detais");

        dashBoard_a_orderDetails_tf.setEditable(false);
        dashBoard_a_orderDetails_tf.setBackground(new java.awt.Color(255, 255, 255));
        dashBoard_a_orderDetails_tf.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        dashBoard_a_orderDetails_tf.setForeground(new java.awt.Color(51, 51, 51));
        dashBoard_a_orderDetails_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dashBoard_a_orderDetails_tf.setText("123");
        dashBoard_a_orderDetails_tf.setBorder(null);
        dashBoard_a_orderDetails_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashBoard_a_orderDetails_tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashBoard_a_orderDetails_tf)
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addComponent(dashBoard_a_orderDetails_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(5, 5, 5))
        );

        jPanel13.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, 72));

        jPanel32.setBackground(new java.awt.Color(0, 51, 51));

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-paper-money-48.png")); // NOI18N

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Payment-Detais");

        dashBoard_a_paymentDetails_tf.setEditable(false);
        dashBoard_a_paymentDetails_tf.setBackground(new java.awt.Color(255, 255, 255));
        dashBoard_a_paymentDetails_tf.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        dashBoard_a_paymentDetails_tf.setForeground(new java.awt.Color(51, 51, 51));
        dashBoard_a_paymentDetails_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dashBoard_a_paymentDetails_tf.setText("123");
        dashBoard_a_paymentDetails_tf.setBorder(null);
        dashBoard_a_paymentDetails_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashBoard_a_paymentDetails_tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashBoard_a_paymentDetails_tf)
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addComponent(dashBoard_a_paymentDetails_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addGap(5, 5, 5))
        );

        jPanel13.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, -1, 72));

        jPanel34.setBackground(new java.awt.Color(0, 51, 51));

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-worker-48.png")); // NOI18N

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, -1, -1));

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));

        jLabel31.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Employees");

        dashBoard_a_employees_tf.setEditable(false);
        dashBoard_a_employees_tf.setBackground(new java.awt.Color(255, 255, 255));
        dashBoard_a_employees_tf.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        dashBoard_a_employees_tf.setForeground(new java.awt.Color(51, 51, 51));
        dashBoard_a_employees_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dashBoard_a_employees_tf.setText("123");
        dashBoard_a_employees_tf.setBorder(null);
        dashBoard_a_employees_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashBoard_a_employees_tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashBoard_a_employees_tf)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addComponent(dashBoard_a_employees_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addGap(5, 5, 5))
        );

        jPanel13.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 130, 72));

        jPanel36.setBackground(new java.awt.Color(0, 51, 51));

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-supplier-48.png")); // NOI18N

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, -1, -1));

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));

        jLabel33.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Supplier-Detais");

        dashBoard_a_supplierDetails_tf.setEditable(false);
        dashBoard_a_supplierDetails_tf.setBackground(new java.awt.Color(255, 255, 255));
        dashBoard_a_supplierDetails_tf.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        dashBoard_a_supplierDetails_tf.setForeground(new java.awt.Color(51, 51, 51));
        dashBoard_a_supplierDetails_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dashBoard_a_supplierDetails_tf.setText("123");
        dashBoard_a_supplierDetails_tf.setBorder(null);
        dashBoard_a_supplierDetails_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashBoard_a_supplierDetails_tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashBoard_a_supplierDetails_tf)
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addComponent(dashBoard_a_supplierDetails_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel33)
                .addGap(5, 5, 5))
        );

        jPanel13.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, -1, 72));

        jTabbedPane1.addTab("Admin", jPanel13);

        javax.swing.GroupLayout home_panelLayout = new javax.swing.GroupLayout(home_panel);
        home_panel.setLayout(home_panelLayout);
        home_panelLayout.setHorizontalGroup(
            home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
        );
        home_panelLayout.setVerticalGroup(
            home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Employee");

        jPanel3.add(home_panel);

        products_panel.setBackground(new java.awt.Color(0, 102, 102));
        products_panel.setPreferredSize(new java.awt.Dimension(774, 600));

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Add Product");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search a product by: ");

        jComboBox1.setBackground(new java.awt.Color(0, 204, 204));
        jComboBox1.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "ProductId", "Title", "Category", "SubCategory", "Manufacture_country", "EmployeeId", "AddDate", "In Stoke less than", "SellPrice less than", "SellPrice higher than", "Supplier ID", "Expires in (days)" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField13.setBackground(new java.awt.Color(0, 255, 255));
        jTextField13.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(51, 51, 51));
        jTextField13.setText("Search");
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-search-24.png")); // NOI18N
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox2.setBackground(new java.awt.Color(0, 204, 204));
        jComboBox2.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "In Stock", "Not In Stock", "Highest sold product", "Expires within a week", "Expires within a month" }));
        jComboBox2.setToolTipText("");
        jComboBox2.setName(""); // NOI18N
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Filter By:");

        productTable.setBackground(new java.awt.Color(0, 204, 204));
        productTable.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        productTable.setForeground(new java.awt.Color(51, 51, 51));
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductId", "EmployeeId", "Title", "Category", "SubCategory", "Manufacture_country", "Description", "Photo", "InStock", "CostPrice", "SellPrice", "AddDate", "LastUpdated", "Exp_Date", "Mfg_Date"
            }
        ));
        jScrollPane1.setViewportView(productTable);

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jDateChooser2.setDateFormatString("yyyy-MM-dd");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("-");

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-search-24.png")); // NOI18N
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox3.setBackground(new java.awt.Color(0, 204, 204));
        jComboBox3.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Added between", "Sold between" }));

        javax.swing.GroupLayout products_panelLayout = new javax.swing.GroupLayout(products_panel);
        products_panel.setLayout(products_panelLayout);
        products_panelLayout.setHorizontalGroup(
            products_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(products_panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(products_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(products_panelLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(products_panelLayout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(products_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(products_panelLayout.createSequentialGroup()
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(products_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        products_panelLayout.setVerticalGroup(
            products_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(products_panelLayout.createSequentialGroup()
                .addGroup(products_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(products_panelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(products_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(products_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, products_panelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(products_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(products_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel34))
                    .addGroup(products_panelLayout.createSequentialGroup()
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(products_panel);

        employee_panel.setBackground(new java.awt.Color(0, 102, 102));

        employeeTable.setBackground(new java.awt.Color(0, 204, 204));
        employeeTable.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        employeeTable.setForeground(new java.awt.Color(51, 51, 51));
        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EmployeeId", "Name", "DOB", "NID", "PhoneNumber", "Email", "Address", "EmployStatus", "Position", "JoiningDate", "Salary", "Experience", "Gender"
            }
        ));
        jScrollPane3.setViewportView(employeeTable);

        employee_panel_comboBox.setBackground(new java.awt.Color(0, 255, 255));
        employee_panel_comboBox.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        employee_panel_comboBox.setForeground(new java.awt.Color(51, 51, 51));
        employee_panel_comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Experience(in months)", "Address", "Gender (M/F)", "Status (employed/fired)", "Position(Manager/ Salesperson/ Cashier)", "Employee ID" }));

        employee_panel_search_tf.setBackground(new java.awt.Color(0, 255, 255));
        employee_panel_search_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        employee_panel_search_tf.setForeground(new java.awt.Color(51, 51, 51));
        employee_panel_search_tf.setText("Search");
        employee_panel_search_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_panel_search_tfActionPerformed(evt);
            }
        });

        employee_panel_searchbutton.setBackground(new java.awt.Color(0, 102, 102));
        employee_panel_searchbutton.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-search-24.png")); // NOI18N
        employee_panel_searchbutton.setBorder(null);
        employee_panel_searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_panel_searchbuttonActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(0, 204, 204));
        jLabel9.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Salary between:");

        employee_panel_tf2.setBackground(new java.awt.Color(0, 255, 255));
        employee_panel_tf2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        employee_panel_tf2.setForeground(new java.awt.Color(51, 51, 51));
        employee_panel_tf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_panel_tf2ActionPerformed(evt);
            }
        });

        employee_panel_tf3.setBackground(new java.awt.Color(0, 255, 255));
        employee_panel_tf3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        employee_panel_tf3.setForeground(new java.awt.Color(51, 51, 51));
        employee_panel_tf3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_panel_tf3ActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("-");

        employee_panel_searchbutton1.setBackground(new java.awt.Color(0, 102, 102));
        employee_panel_searchbutton1.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-search-24.png")); // NOI18N
        employee_panel_searchbutton1.setBorder(null);
        employee_panel_searchbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_panel_searchbutton1ActionPerformed(evt);
            }
        });

        jLabel43.setBackground(new java.awt.Color(0, 204, 204));
        jLabel43.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Employee ID:");

        employee_panel_tf4.setBackground(new java.awt.Color(0, 255, 255));
        employee_panel_tf4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        employee_panel_tf4.setForeground(new java.awt.Color(51, 51, 51));
        employee_panel_tf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_panel_tf4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 102, 102));
        jButton5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 204, 204));
        jButton11.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(51, 51, 51));
        jButton11.setText("Add Employee");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout employee_panelLayout = new javax.swing.GroupLayout(employee_panel);
        employee_panel.setLayout(employee_panelLayout);
        employee_panelLayout.setHorizontalGroup(
            employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employee_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employee_panelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employee_panelLayout.createSequentialGroup()
                        .addComponent(employee_panel_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(employee_panel_search_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(employee_panel_searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(employee_panelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(employee_panel_tf2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(employee_panel_tf3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(employee_panel_searchbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(employee_panelLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(employee_panel_tf4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addGap(33, 33, 33))
        );
        employee_panelLayout.setVerticalGroup(
            employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employee_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employee_panel_searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(employee_panel_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(employee_panel_search_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(employee_panel_tf2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(employee_panel_tf3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(employee_panel_searchbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employee_panel_tf4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(employee_panel);

        add_product_panel.setBackground(new java.awt.Color(0, 102, 102));
        add_product_panel.setForeground(new java.awt.Color(255, 255, 255));

        employeeID_tf.setBackground(new java.awt.Color(0, 255, 255));
        employeeID_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        employeeID_tf.setForeground(new java.awt.Color(51, 51, 51));

        jLabel36.setBackground(new java.awt.Color(0, 102, 102));
        jLabel36.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Employee ID:");

        title_tf.setBackground(new java.awt.Color(0, 255, 255));
        title_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        title_tf.setForeground(new java.awt.Color(51, 51, 51));

        jLabel37.setBackground(new java.awt.Color(0, 102, 102));
        jLabel37.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Title:");

        category_tf.setBackground(new java.awt.Color(0, 255, 255));
        category_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        category_tf.setForeground(new java.awt.Color(51, 51, 51));

        jLabel38.setBackground(new java.awt.Color(0, 102, 102));
        jLabel38.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Category:");

        subcategory_tf.setBackground(new java.awt.Color(0, 255, 255));
        subcategory_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        subcategory_tf.setForeground(new java.awt.Color(51, 51, 51));

        jLabel39.setBackground(new java.awt.Color(0, 102, 102));
        jLabel39.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Sub Category:");

        manufacterCountry_tf.setBackground(new java.awt.Color(0, 255, 255));
        manufacterCountry_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        manufacterCountry_tf.setForeground(new java.awt.Color(51, 51, 51));

        jLabel40.setBackground(new java.awt.Color(0, 102, 102));
        jLabel40.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Manufacture Country:");

        jLabel41.setBackground(new java.awt.Color(0, 102, 102));
        jLabel41.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Description:");

        jLabel42.setBackground(new java.awt.Color(0, 102, 102));
        jLabel42.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Sale price:");

        jLabel44.setBackground(new java.awt.Color(0, 102, 102));
        jLabel44.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("EXP Date:");

        jLabel45.setBackground(new java.awt.Color(0, 102, 102));
        jLabel45.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Image URL:");

        instock_tf.setBackground(new java.awt.Color(0, 255, 255));
        instock_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        instock_tf.setForeground(new java.awt.Color(51, 51, 51));

        jLabel46.setBackground(new java.awt.Color(0, 102, 102));
        jLabel46.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("MFG Date:");

        jLabel47.setBackground(new java.awt.Color(0, 102, 102));
        jLabel47.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("In stock:");

        costPrice_tf.setBackground(new java.awt.Color(0, 255, 255));
        costPrice_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        costPrice_tf.setForeground(new java.awt.Color(51, 51, 51));

        jLabel48.setBackground(new java.awt.Color(0, 102, 102));
        jLabel48.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Cost Price:");

        salePrice_tf.setBackground(new java.awt.Color(0, 255, 255));
        salePrice_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        salePrice_tf.setForeground(new java.awt.Color(51, 51, 51));

        imgurl_tf.setBackground(new java.awt.Color(0, 255, 255));
        imgurl_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        imgurl_tf.setForeground(new java.awt.Color(51, 51, 51));

        description_ta.setBackground(new java.awt.Color(0, 255, 255));
        description_ta.setColumns(20);
        description_ta.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        description_ta.setForeground(new java.awt.Color(51, 51, 51));
        description_ta.setRows(5);
        jScrollPane2.setViewportView(description_ta);

        product_add_btn.setBackground(new java.awt.Color(0, 204, 204));
        product_add_btn.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        product_add_btn.setForeground(new java.awt.Color(51, 51, 51));
        product_add_btn.setText("ADD");
        product_add_btn.setBorder(null);
        product_add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_add_btnActionPerformed(evt);
            }
        });

        product_reset_btn.setBackground(new java.awt.Color(0, 204, 204));
        product_reset_btn.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        product_reset_btn.setForeground(new java.awt.Color(51, 51, 51));
        product_reset_btn.setText("Reset");
        product_reset_btn.setActionCommand("");
        product_reset_btn.setBorder(null);
        product_reset_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_reset_btnMouseClicked(evt);
            }
        });
        product_reset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_reset_btnActionPerformed(evt);
            }
        });

        exp_dc.setBackground(new java.awt.Color(0, 204, 204));
        exp_dc.setForeground(new java.awt.Color(0, 255, 255));
        exp_dc.setToolTipText("");
        exp_dc.setDateFormatString("yyyy/MM/dd");

        mfg_dc.setBackground(new java.awt.Color(0, 204, 204));
        mfg_dc.setForeground(new java.awt.Color(0, 255, 255));
        mfg_dc.setToolTipText("");
        mfg_dc.setDateFormatString("yyyy/MM/dd");

        productId_tf1.setBackground(new java.awt.Color(0, 255, 255));
        productId_tf1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        productId_tf1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel54.setBackground(new java.awt.Color(0, 102, 102));
        jLabel54.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Product ID:");

        addproduct_panel_searchbutton.setBackground(new java.awt.Color(0, 102, 102));
        addproduct_panel_searchbutton.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-search-24.png")); // NOI18N
        addproduct_panel_searchbutton.setBorder(null);
        addproduct_panel_searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addproduct_panel_searchbuttonActionPerformed(evt);
            }
        });

        expDate_tf.setBackground(new java.awt.Color(0, 255, 255));
        expDate_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        expDate_tf.setForeground(new java.awt.Color(51, 51, 51));

        mfgDate_tf.setBackground(new java.awt.Color(0, 255, 255));
        mfgDate_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        mfgDate_tf.setForeground(new java.awt.Color(51, 51, 51));

        product_update_btn.setBackground(new java.awt.Color(0, 204, 204));
        product_update_btn.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        product_update_btn.setForeground(new java.awt.Color(51, 51, 51));
        product_update_btn.setText("Update");
        product_update_btn.setActionCommand("");
        product_update_btn.setBorder(null);
        product_update_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_update_btnMouseClicked(evt);
            }
        });
        product_update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_update_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout add_product_panelLayout = new javax.swing.GroupLayout(add_product_panel);
        add_product_panel.setLayout(add_product_panelLayout);
        add_product_panelLayout.setHorizontalGroup(
            add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, add_product_panelLayout.createSequentialGroup()
                .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(add_product_panelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(manufacterCountry_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                .addComponent(subcategory_tf)
                                .addComponent(category_tf)
                                .addComponent(title_tf)
                                .addComponent(employeeID_tf))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(add_product_panelLayout.createSequentialGroup()
                                .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(exp_dc, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                    .addComponent(salePrice_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mfg_dc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(add_product_panelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(add_product_panelLayout.createSequentialGroup()
                                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(costPrice_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(add_product_panelLayout.createSequentialGroup()
                                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(instock_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(add_product_panelLayout.createSequentialGroup()
                                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(imgurl_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(add_product_panelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(product_reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(product_add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(product_update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(expDate_tf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mfgDate_tf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(27, 27, 27))
            .addGroup(add_product_panelLayout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(jLabel54)
                .addGap(3, 3, 3)
                .addComponent(productId_tf1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addproduct_panel_searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
        );
        add_product_panelLayout.setVerticalGroup(
            add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_product_panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel54)
                        .addComponent(productId_tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addproduct_panel_searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(add_product_panelLayout.createSequentialGroup()
                        .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(imgurl_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45))
                        .addGap(18, 18, 18)
                        .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(instock_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47))
                        .addGap(18, 18, 18)
                        .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(costPrice_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48))
                        .addGap(18, 18, 18)
                        .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salePrice_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42))
                        .addGap(26, 26, 26)
                        .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel44)
                            .addComponent(exp_dc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(expDate_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(mfg_dc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mfgDate_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(product_add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(product_reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(product_update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(add_product_panelLayout.createSequentialGroup()
                        .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeeID_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))
                        .addGap(18, 18, 18)
                        .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(title_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addGap(18, 18, 18)
                        .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(category_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addGap(18, 18, 18)
                        .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(subcategory_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39))
                        .addGap(18, 18, 18)
                        .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(manufacterCountry_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40))
                        .addGap(18, 18, 18)
                        .addGroup(add_product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jPanel3.add(add_product_panel);

        customer_panel.setBackground(new java.awt.Color(0, 102, 102));

        jLabel56.setBackground(new java.awt.Color(0, 204, 204));
        jLabel56.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Customer ID:");

        customer_panel_tf2.setBackground(new java.awt.Color(0, 255, 255));
        customer_panel_tf2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        customer_panel_tf2.setForeground(new java.awt.Color(51, 51, 51));
        customer_panel_tf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_panel_tf2ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(0, 102, 102));
        jButton9.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Delete");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        customerTable.setBackground(new java.awt.Color(0, 204, 204));
        customerTable.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        customerTable.setForeground(new java.awt.Color(51, 51, 51));
        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Id", "Employee Id", "Name", "Address", "Phone Number", "Email", "Last Purchase", "Purchase Qty", "Spent Money", "Gender"
            }
        ));
        jScrollPane7.setViewportView(customerTable);

        customer_panel_comboBox1.setBackground(new java.awt.Color(0, 255, 255));
        customer_panel_comboBox1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        customer_panel_comboBox1.setForeground(new java.awt.Color(51, 51, 51));
        customer_panel_comboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Customer ID", "Customer Name", "Customer Phone no.", "Area", "Employee (handled by)", "Spent more than (tk)", "Bought more than (Qty)" }));

        customer_panel_search_tf1.setBackground(new java.awt.Color(0, 255, 255));
        customer_panel_search_tf1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        customer_panel_search_tf1.setForeground(new java.awt.Color(51, 51, 51));
        customer_panel_search_tf1.setText("Search");
        customer_panel_search_tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_panel_search_tf1ActionPerformed(evt);
            }
        });

        customer_panel_searchbutton1.setBackground(new java.awt.Color(0, 102, 102));
        customer_panel_searchbutton1.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-search-24.png")); // NOI18N
        customer_panel_searchbutton1.setBorder(null);
        customer_panel_searchbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_panel_searchbutton1ActionPerformed(evt);
            }
        });

        customer_panel_comboBox2.setBackground(new java.awt.Color(0, 255, 255));
        customer_panel_comboBox2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        customer_panel_comboBox2.setForeground(new java.awt.Color(51, 51, 51));
        customer_panel_comboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customers who :", "Didn't buy sothing from to (Date)", "Bought somthing from to (Date)" }));

        jLabel60.setBackground(new java.awt.Color(0, 102, 102));
        jLabel60.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("-");

        customer_panel_searchbutton2.setBackground(new java.awt.Color(0, 102, 102));
        customer_panel_searchbutton2.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-search-24.png")); // NOI18N
        customer_panel_searchbutton2.setBorder(null);
        customer_panel_searchbutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_panel_searchbutton2ActionPerformed(evt);
            }
        });

        customer_DateChooser1.setDateFormatString("yyyy-MM-dd");

        customer_DateChooser2.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout customer_panelLayout = new javax.swing.GroupLayout(customer_panel);
        customer_panel.setLayout(customer_panelLayout);
        customer_panelLayout.setHorizontalGroup(
            customer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customer_panelLayout.createSequentialGroup()
                .addGroup(customer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customer_panelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(customer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customer_panelLayout.createSequentialGroup()
                                .addComponent(customer_panel_comboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(customer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(customer_panelLayout.createSequentialGroup()
                                        .addComponent(customer_panel_comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(customer_panel_search_tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customer_panelLayout.createSequentialGroup()
                                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(customer_panel_tf2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton9)
                                        .addGap(18, 18, 18)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customer_panel_searchbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(customer_panelLayout.createSequentialGroup()
                                .addComponent(customer_DateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(customer_DateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(customer_panel_searchbutton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(customer_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7)))
                .addContainerGap())
        );
        customer_panelLayout.setVerticalGroup(
            customer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customer_panelLayout.createSequentialGroup()
                .addGroup(customer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customer_panelLayout.createSequentialGroup()
                        .addContainerGap(100, Short.MAX_VALUE)
                        .addGroup(customer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customer_panel_comboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(customer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(customer_panel_tf2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton9))))
                    .addGroup(customer_panelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(customer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customer_panel_searchbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(customer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(customer_panel_comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(customer_panel_search_tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customer_panel_searchbutton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(customer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(customer_DateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(customer_DateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(customer_panel);

        order_details_panel.setBackground(new java.awt.Color(0, 102, 102));

        order_details_Table.setBackground(new java.awt.Color(0, 204, 204));
        order_details_Table.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        order_details_Table.setForeground(new java.awt.Color(51, 51, 51));
        order_details_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OrderId", "CustomerId", "ProductId", "EmployeeId", "Qty", "TotalPrice", "Discount", "Tax", "FinalPrice", "SoldDate", "PaidStatus"
            }
        ));
        jScrollPane6.setViewportView(order_details_Table);

        order_details_panel_comboBox1.setBackground(new java.awt.Color(0, 255, 255));
        order_details_panel_comboBox1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        order_details_panel_comboBox1.setForeground(new java.awt.Color(51, 51, 51));
        order_details_panel_comboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Order ID", "Employee ID", "Customer name", "Customer Phone Number", "Customer ID", "Unit Price higher than", "Total price higher than" }));

        order_details_panel_search_tf1.setBackground(new java.awt.Color(0, 255, 255));
        order_details_panel_search_tf1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        order_details_panel_search_tf1.setForeground(new java.awt.Color(51, 51, 51));
        order_details_panel_search_tf1.setText("Search");
        order_details_panel_search_tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_details_panel_search_tf1ActionPerformed(evt);
            }
        });

        order_details_panel_searchbutton1.setBackground(new java.awt.Color(0, 102, 102));
        order_details_panel_searchbutton1.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-search-24.png")); // NOI18N
        order_details_panel_searchbutton1.setBorder(null);
        order_details_panel_searchbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_details_panel_searchbutton1ActionPerformed(evt);
            }
        });

        jLabel58.setBackground(new java.awt.Color(0, 204, 204));
        jLabel58.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Order ID:");

        order_details_panel_tf2.setBackground(new java.awt.Color(0, 255, 255));
        order_details_panel_tf2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        order_details_panel_tf2.setForeground(new java.awt.Color(51, 51, 51));
        order_details_panel_tf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_details_panel_tf2ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 102, 102));
        jButton8.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Delete");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        order_details_panel_comboBox2.setBackground(new java.awt.Color(0, 255, 255));
        order_details_panel_comboBox2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        order_details_panel_comboBox2.setForeground(new java.awt.Color(51, 51, 51));
        order_details_panel_comboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Due payment", "Discount", "No discount" }));
        order_details_panel_comboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_details_panel_comboBox2ActionPerformed(evt);
            }
        });

        jLabel59.setBackground(new java.awt.Color(0, 204, 204));
        jLabel59.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Orders with:");

        order_details_panel_comboBox3.setBackground(new java.awt.Color(0, 255, 255));
        order_details_panel_comboBox3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        order_details_panel_comboBox3.setForeground(new java.awt.Color(51, 51, 51));
        order_details_panel_comboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Products sold on a:", "Date", "Month", "Year", "From  to (Date)", "Income From  to (Date)", "Profit From  to (Date)" }));

        order_details_panel_tf3.setBackground(new java.awt.Color(0, 255, 255));
        order_details_panel_tf3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        order_details_panel_tf3.setForeground(new java.awt.Color(51, 51, 51));
        order_details_panel_tf3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_details_panel_tf3ActionPerformed(evt);
            }
        });

        order_details_panel_tf4.setBackground(new java.awt.Color(0, 255, 255));
        order_details_panel_tf4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        order_details_panel_tf4.setForeground(new java.awt.Color(51, 51, 51));
        order_details_panel_tf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_details_panel_tf4ActionPerformed(evt);
            }
        });

        jLabel53.setBackground(new java.awt.Color(0, 102, 102));
        jLabel53.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("-");

        order_details_panel_searchbutton2.setBackground(new java.awt.Color(0, 102, 102));
        order_details_panel_searchbutton2.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-search-24.png")); // NOI18N
        order_details_panel_searchbutton2.setBorder(null);
        order_details_panel_searchbutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_details_panel_searchbutton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout order_details_panelLayout = new javax.swing.GroupLayout(order_details_panel);
        order_details_panel.setLayout(order_details_panelLayout);
        order_details_panelLayout.setHorizontalGroup(
            order_details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(order_details_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(order_details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(order_details_panelLayout.createSequentialGroup()
                        .addComponent(jScrollPane6)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, order_details_panelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(order_details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(order_details_panelLayout.createSequentialGroup()
                                .addComponent(order_details_panel_tf3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(order_details_panel_tf4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(order_details_panel_comboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(order_details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(order_details_panelLayout.createSequentialGroup()
                                .addGap(0, 16, Short.MAX_VALUE)
                                .addComponent(order_details_panel_comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(order_details_panel_search_tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(order_details_panelLayout.createSequentialGroup()
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(order_details_panel_tf2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8))
                            .addGroup(order_details_panelLayout.createSequentialGroup()
                                .addComponent(order_details_panel_searchbutton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(order_details_panel_comboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(order_details_panel_searchbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        order_details_panelLayout.setVerticalGroup(
            order_details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, order_details_panelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(order_details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(order_details_panel_searchbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(order_details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(order_details_panel_comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(order_details_panel_search_tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(order_details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(order_details_panelLayout.createSequentialGroup()
                        .addGroup(order_details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(order_details_panelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(order_details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(order_details_panel_tf2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(order_details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(order_details_panel_comboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, order_details_panelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(order_details_panel_searchbutton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)))
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(order_details_panelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(order_details_panel_comboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(order_details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(order_details_panel_tf3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(order_details_panel_tf4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel3.add(order_details_panel);

        payments_panel.setBackground(new java.awt.Color(0, 102, 102));

        jLabel61.setBackground(new java.awt.Color(0, 204, 204));
        jLabel61.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Payment ID:");

        payments_panel_tf2.setBackground(new java.awt.Color(0, 255, 255));
        payments_panel_tf2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        payments_panel_tf2.setForeground(new java.awt.Color(51, 51, 51));
        payments_panel_tf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payments_panel_tf2ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(0, 102, 102));
        jButton10.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Delete");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        paymentsTable.setBackground(new java.awt.Color(0, 204, 204));
        paymentsTable.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        paymentsTable.setForeground(new java.awt.Color(51, 51, 51));
        paymentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bill_Id", "Employee Id", "Order Id", "Pay_type", "Pay_CardNo", "Pay Date", "Pay_Time", "Paid Status"
            }
        ));
        jScrollPane8.setViewportView(paymentsTable);

        payments_panel_comboBox1.setBackground(new java.awt.Color(0, 255, 255));
        payments_panel_comboBox1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        payments_panel_comboBox1.setForeground(new java.awt.Color(51, 51, 51));
        payments_panel_comboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Bill Id", "Payment Date", "Employee Id (handled by)" }));

        payments_panel_search_tf1.setBackground(new java.awt.Color(0, 255, 255));
        payments_panel_search_tf1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        payments_panel_search_tf1.setForeground(new java.awt.Color(51, 51, 51));
        payments_panel_search_tf1.setText("Search");
        payments_panel_search_tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payments_panel_search_tf1ActionPerformed(evt);
            }
        });

        payments_panel_searchbutton1.setBackground(new java.awt.Color(0, 102, 102));
        payments_panel_searchbutton1.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-search-24.png")); // NOI18N
        payments_panel_searchbutton1.setBorder(null);
        payments_panel_searchbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payments_panel_searchbutton1ActionPerformed(evt);
            }
        });

        payments_panel_comboBox2.setBackground(new java.awt.Color(0, 255, 255));
        payments_panel_comboBox2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        payments_panel_comboBox2.setForeground(new java.awt.Color(51, 51, 51));
        payments_panel_comboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Show all payments that are:", "Paid", "Not paid", "Paid through cash", "Paid through card" }));

        payments_panel_searchbutton2.setBackground(new java.awt.Color(0, 102, 102));
        payments_panel_searchbutton2.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-search-24.png")); // NOI18N
        payments_panel_searchbutton2.setBorder(null);
        payments_panel_searchbutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payments_panel_searchbutton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout payments_panelLayout = new javax.swing.GroupLayout(payments_panel);
        payments_panel.setLayout(payments_panelLayout);
        payments_panelLayout.setHorizontalGroup(
            payments_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payments_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, payments_panelLayout.createSequentialGroup()
                .addGap(0, 238, Short.MAX_VALUE)
                .addGroup(payments_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(payments_panelLayout.createSequentialGroup()
                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(payments_panel_tf2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10))
                    .addGroup(payments_panelLayout.createSequentialGroup()
                        .addComponent(payments_panel_comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(payments_panel_search_tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payments_panel_searchbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(payments_panelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(payments_panel_comboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(payments_panel_searchbutton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        payments_panelLayout.setVerticalGroup(
            payments_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, payments_panelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(payments_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(payments_panel_searchbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(payments_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(payments_panel_comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(payments_panel_search_tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(payments_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(payments_panel_tf2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(payments_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(payments_panelLayout.createSequentialGroup()
                        .addComponent(payments_panel_comboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(payments_panel_searchbutton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.add(payments_panel);

        supplies_panel.setBackground(new java.awt.Color(0, 102, 102));

        suppliesTable.setBackground(new java.awt.Color(0, 204, 204));
        suppliesTable.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        suppliesTable.setForeground(new java.awt.Color(51, 51, 51));
        suppliesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supply Id", "Product Id", "Supplier Id", "Employee Id", "Supply Date", "Quantity", "Cost Price", "Total Cost Price"
            }
        ));
        jScrollPane4.setViewportView(suppliesTable);

        supplies_panel_comboBox1.setBackground(new java.awt.Color(0, 255, 255));
        supplies_panel_comboBox1.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        supplies_panel_comboBox1.setForeground(new java.awt.Color(51, 51, 51));
        supplies_panel_comboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Supply Id", "Product Id", "Supplier Id", "Employee Id", "Cost Price less than" }));

        supplies_panel_search_tf1.setBackground(new java.awt.Color(0, 255, 255));
        supplies_panel_search_tf1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        supplies_panel_search_tf1.setForeground(new java.awt.Color(51, 51, 51));
        supplies_panel_search_tf1.setText("Search");
        supplies_panel_search_tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplies_panel_search_tf1ActionPerformed(evt);
            }
        });

        supplies_panel_searchbutton.setBackground(new java.awt.Color(0, 102, 102));
        supplies_panel_searchbutton.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-search-24.png")); // NOI18N
        supplies_panel_searchbutton.setBorder(null);
        supplies_panel_searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplies_panel_searchbuttonActionPerformed(evt);
            }
        });

        jLabel55.setBackground(new java.awt.Color(0, 204, 204));
        jLabel55.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Supply ID:");

        supplies_panel_tf5.setBackground(new java.awt.Color(0, 255, 255));
        supplies_panel_tf5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        supplies_panel_tf5.setForeground(new java.awt.Color(51, 51, 51));
        supplies_panel_tf5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplies_panel_tf5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 102, 102));
        jButton6.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout supplies_panelLayout = new javax.swing.GroupLayout(supplies_panel);
        supplies_panel.setLayout(supplies_panelLayout);
        supplies_panelLayout.setHorizontalGroup(
            supplies_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(supplies_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplies_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(supplies_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(supplies_panelLayout.createSequentialGroup()
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(supplies_panel_tf5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addGroup(supplies_panelLayout.createSequentialGroup()
                        .addComponent(supplies_panel_comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supplies_panel_search_tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supplies_panel_searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        supplies_panelLayout.setVerticalGroup(
            supplies_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplies_panelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(supplies_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(supplies_panel_searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(supplies_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(supplies_panel_comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(supplies_panel_search_tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(supplies_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supplies_panel_tf5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(supplies_panel);

        supplier_panel.setBackground(new java.awt.Color(0, 102, 102));

        supplierTable.setBackground(new java.awt.Color(0, 204, 204));
        supplierTable.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        supplierTable.setForeground(new java.awt.Color(51, 51, 51));
        supplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier Id", "Name", "Address", "PhoneNumberId", "Email "
            }
        ));
        jScrollPane5.setViewportView(supplierTable);

        supplier_panel_comboBox.setBackground(new java.awt.Color(0, 255, 255));
        supplier_panel_comboBox.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        supplier_panel_comboBox.setForeground(new java.awt.Color(51, 51, 51));
        supplier_panel_comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Supplier Id", "Name", "Address" }));

        supplier_panel_search_tf1.setBackground(new java.awt.Color(0, 255, 255));
        supplier_panel_search_tf1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        supplier_panel_search_tf1.setForeground(new java.awt.Color(51, 51, 51));
        supplier_panel_search_tf1.setText("Search");
        supplier_panel_search_tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplier_panel_search_tf1ActionPerformed(evt);
            }
        });

        supplier_panel_searchbutton.setBackground(new java.awt.Color(0, 102, 102));
        supplier_panel_searchbutton.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-search-24.png")); // NOI18N
        supplier_panel_searchbutton.setBorder(null);
        supplier_panel_searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplier_panel_searchbuttonActionPerformed(evt);
            }
        });

        jLabel57.setBackground(new java.awt.Color(0, 204, 204));
        jLabel57.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Supplier ID:");

        supplier_panel_tf2.setBackground(new java.awt.Color(0, 255, 255));
        supplier_panel_tf2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        supplier_panel_tf2.setForeground(new java.awt.Color(51, 51, 51));
        supplier_panel_tf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplier_panel_tf2ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 102, 102));
        jButton7.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout supplier_panelLayout = new javax.swing.GroupLayout(supplier_panel);
        supplier_panel.setLayout(supplier_panelLayout);
        supplier_panelLayout.setHorizontalGroup(
            supplier_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(supplier_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplier_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(supplier_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(supplier_panelLayout.createSequentialGroup()
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(supplier_panel_tf2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7))
                    .addGroup(supplier_panelLayout.createSequentialGroup()
                        .addComponent(supplier_panel_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supplier_panel_search_tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supplier_panel_searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        supplier_panelLayout.setVerticalGroup(
            supplier_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplier_panelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(supplier_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(supplier_panel_searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(supplier_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(supplier_panel_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(supplier_panel_search_tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(supplier_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supplier_panel_tf2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(supplier_panel);

        add_employee_panel.setBackground(new java.awt.Color(0, 102, 102));
        add_employee_panel.setForeground(new java.awt.Color(255, 255, 255));

        employeePass_tf.setBackground(new java.awt.Color(0, 255, 255));
        employeePass_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        employeePass_tf.setForeground(new java.awt.Color(51, 51, 51));

        jLabel62.setBackground(new java.awt.Color(0, 102, 102));
        jLabel62.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Employee Pass:");

        employeeName_tf.setBackground(new java.awt.Color(0, 255, 255));
        employeeName_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        employeeName_tf.setForeground(new java.awt.Color(51, 51, 51));

        jLabel63.setBackground(new java.awt.Color(0, 102, 102));
        jLabel63.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Name:");

        nid_tf.setBackground(new java.awt.Color(0, 255, 255));
        nid_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        nid_tf.setForeground(new java.awt.Color(51, 51, 51));

        jLabel64.setBackground(new java.awt.Color(0, 102, 102));
        jLabel64.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("NID:");

        phoneNo_tf.setBackground(new java.awt.Color(0, 255, 255));
        phoneNo_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        phoneNo_tf.setForeground(new java.awt.Color(51, 51, 51));

        jLabel65.setBackground(new java.awt.Color(0, 102, 102));
        jLabel65.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("PhoneNumber:");

        employeeEmail_tf.setBackground(new java.awt.Color(0, 255, 255));
        employeeEmail_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        employeeEmail_tf.setForeground(new java.awt.Color(51, 51, 51));

        jLabel66.setBackground(new java.awt.Color(0, 102, 102));
        jLabel66.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("Email:");

        jLabel67.setBackground(new java.awt.Color(0, 102, 102));
        jLabel67.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Address:");

        jLabel68.setBackground(new java.awt.Color(0, 102, 102));
        jLabel68.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Experience:");

        jLabel69.setBackground(new java.awt.Color(0, 102, 102));
        jLabel69.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Gender:");

        jLabel70.setBackground(new java.awt.Color(0, 102, 102));
        jLabel70.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("Employ Status:");

        Position_tf.setBackground(new java.awt.Color(0, 255, 255));
        Position_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        Position_tf.setForeground(new java.awt.Color(51, 51, 51));

        jLabel72.setBackground(new java.awt.Color(0, 102, 102));
        jLabel72.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("Position:");

        employeesalary_tf.setBackground(new java.awt.Color(0, 255, 255));
        employeesalary_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        employeesalary_tf.setForeground(new java.awt.Color(51, 51, 51));

        jLabel73.setBackground(new java.awt.Color(0, 102, 102));
        jLabel73.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Salary:");

        Experience_tf.setBackground(new java.awt.Color(0, 255, 255));
        Experience_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        Experience_tf.setForeground(new java.awt.Color(51, 51, 51));

        EmployStatus_tf.setBackground(new java.awt.Color(0, 255, 255));
        EmployStatus_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        EmployStatus_tf.setForeground(new java.awt.Color(51, 51, 51));

        employee_add_btn.setBackground(new java.awt.Color(0, 204, 204));
        employee_add_btn.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        employee_add_btn.setForeground(new java.awt.Color(51, 51, 51));
        employee_add_btn.setText("ADD");
        employee_add_btn.setBorder(null);
        employee_add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_add_btnActionPerformed(evt);
            }
        });

        employee_reset_btn.setBackground(new java.awt.Color(0, 204, 204));
        employee_reset_btn.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        employee_reset_btn.setForeground(new java.awt.Color(51, 51, 51));
        employee_reset_btn.setText("Reset");
        employee_reset_btn.setActionCommand("");
        employee_reset_btn.setBorder(null);
        employee_reset_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employee_reset_btnMouseClicked(evt);
            }
        });
        employee_reset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_reset_btnActionPerformed(evt);
            }
        });

        dob_dc.setBackground(new java.awt.Color(0, 204, 204));
        dob_dc.setForeground(new java.awt.Color(0, 255, 255));
        dob_dc.setToolTipText("");
        dob_dc.setDateFormatString("yyyy/MM/dd");

        employeeId_tf.setBackground(new java.awt.Color(0, 255, 255));
        employeeId_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        employeeId_tf.setForeground(new java.awt.Color(51, 51, 51));

        jLabel74.setBackground(new java.awt.Color(0, 102, 102));
        jLabel74.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Employee ID:");

        addemployee_panel_searchbutton.setBackground(new java.awt.Color(0, 102, 102));
        addemployee_panel_searchbutton.setIcon(new javax.swing.ImageIcon("D:\\InventoryManagement\\src\\main\\java\\DashBoard\\icons8-search-24.png")); // NOI18N
        addemployee_panel_searchbutton.setBorder(null);
        addemployee_panel_searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addemployee_panel_searchbuttonActionPerformed(evt);
            }
        });

        Gender_tf.setBackground(new java.awt.Color(0, 255, 255));
        Gender_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        Gender_tf.setForeground(new java.awt.Color(51, 51, 51));

        employee_update_btn.setBackground(new java.awt.Color(0, 204, 204));
        employee_update_btn.setFont(new java.awt.Font("MV Boli", 1, 20)); // NOI18N
        employee_update_btn.setForeground(new java.awt.Color(51, 51, 51));
        employee_update_btn.setText("Update");
        employee_update_btn.setActionCommand("");
        employee_update_btn.setBorder(null);
        employee_update_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employee_update_btnMouseClicked(evt);
            }
        });
        employee_update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_update_btnActionPerformed(evt);
            }
        });

        employeeaddress_tf.setBackground(new java.awt.Color(0, 255, 255));
        employeeaddress_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        employeeaddress_tf.setForeground(new java.awt.Color(51, 51, 51));

        jLabel71.setBackground(new java.awt.Color(0, 102, 102));
        jLabel71.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Date of birth:");

        dob_tf.setBackground(new java.awt.Color(0, 255, 255));
        dob_tf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        dob_tf.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout add_employee_panelLayout = new javax.swing.GroupLayout(add_employee_panel);
        add_employee_panel.setLayout(add_employee_panelLayout);
        add_employee_panelLayout.setHorizontalGroup(
            add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_employee_panelLayout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(jLabel74)
                .addGap(3, 3, 3)
                .addComponent(employeeId_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addemployee_panel_searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, add_employee_panelLayout.createSequentialGroup()
                .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(add_employee_panelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(employee_reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(add_employee_panelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(employeeEmail_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(phoneNo_tf)
                            .addComponent(nid_tf)
                            .addComponent(employeeName_tf)
                            .addComponent(employeePass_tf)
                            .addComponent(employeeaddress_tf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                        .addGap(87, 87, 87)))
                .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(add_employee_panelLayout.createSequentialGroup()
                        .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(employeesalary_tf)
                            .addComponent(Experience_tf)
                            .addComponent(Position_tf)
                            .addComponent(EmployStatus_tf)
                            .addComponent(Gender_tf)
                            .addComponent(dob_dc, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dob_tf)))
                    .addGroup(add_employee_panelLayout.createSequentialGroup()
                        .addComponent(employee_add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(employee_update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );
        add_employee_panelLayout.setVerticalGroup(
            add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_employee_panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel74)
                        .addComponent(employeeId_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addemployee_panel_searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(add_employee_panelLayout.createSequentialGroup()
                        .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EmployStatus_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel70))
                        .addGap(18, 18, 18)
                        .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Position_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72))
                        .addGap(18, 18, 18)
                        .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeesalary_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel73))
                        .addGap(18, 18, 18)
                        .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Experience_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel68))
                        .addGap(18, 18, 18)
                        .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Gender_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel69))
                        .addGap(19, 19, 19)
                        .addComponent(dob_dc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(add_employee_panelLayout.createSequentialGroup()
                        .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeePass_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62))
                        .addGap(18, 18, 18)
                        .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeeName_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel63))
                        .addGap(18, 18, 18)
                        .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nid_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64))
                        .addGap(18, 18, 18)
                        .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneNo_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel65))
                        .addGap(18, 18, 18)
                        .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeeEmail_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel66))
                        .addGap(18, 18, 18)
                        .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel67)
                            .addComponent(employeeaddress_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel71))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dob_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addGroup(add_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employee_add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employee_reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employee_update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel3.add(add_employee_panel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void home_tab_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_tab_panelMouseClicked
        home_panel.setVisible(true);
        products_panel.setVisible(false);
        employee_panel.setVisible(false);
        customer_panel.setVisible(false);
        add_product_panel.setVisible(false);
        order_details_panel.setVisible(false);
        payments_panel.setVisible(false);
        supplies_panel.setVisible(false);
        supplier_panel.setVisible(false);
        add_employee_panel.setVisible(false);
        home_tab_panel.setBackground(new Color(0,102,102));
        product_tab_panel.setBackground(new Color(51,51,51));
        employee_tab_panel.setBackground(new Color(51,51,51));
        customer_tab_panel.setBackground(new Color(51,51,51));
        order_details_tab_panel.setBackground(new Color(51,51,51));
        payments_tab_panel.setBackground(new Color(51,51,51));
        supplies_tab_panel.setBackground(new Color(51,51,51));
        supplier_tab_panel.setBackground(new Color(51,51,51));
        
    }//GEN-LAST:event_home_tab_panelMouseClicked

    private void product_tab_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_tab_panelMouseClicked
        home_panel.setVisible(false);
        products_panel.setVisible(true);
        employee_panel.setVisible(false);
        customer_panel.setVisible(false);
        add_product_panel.setVisible(false);
        order_details_panel.setVisible(false);
        payments_panel.setVisible(false);
        supplies_panel.setVisible(false);
        supplier_panel.setVisible(false);
        add_employee_panel.setVisible(false);
        home_tab_panel.setBackground(new Color(51,51,51));
        product_tab_panel.setBackground(new Color(0,102,102));
        employee_tab_panel.setBackground(new Color(51,51,51));
        customer_tab_panel.setBackground(new Color(51,51,51));
        order_details_tab_panel.setBackground(new Color(51,51,51));
        payments_tab_panel.setBackground(new Color(51,51,51));
        supplies_tab_panel.setBackground(new Color(51,51,51));
        supplier_tab_panel.setBackground(new Color(51,51,51));
        
        try{
            productTable.setModel(new DefaultTableModel(null, new String[]{"ID","EmployeeId","Title","Category","SubCategory","Manufacture_country","Description","Imgurl","InStock","CostPrice","SellPrice","AddDate","LastUpdated","Exp_Date","Mfg_Date"}));
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Product";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String ID = rs.getString("ProductId");
                String EmployeeId = rs.getString("EmployeeId");
                String Title = rs.getString("Title");
                String Category = rs.getString("Category");
                String SubCategory = rs.getString("SubCategory");
                String Manufacture_country = rs.getString("Manufacture_country");
                String Description = rs.getString("Description");
                String Imgurl = rs.getString("Imgurl");
                String InStock = rs.getString("InStock");
                String CostPrice = rs.getString("CostPrice");
                String SellPrice = rs.getString("SellPrice");
                String AddDate = rs.getString("AddDate");
                String LastUpdated = rs.getString("LastUpdated");
                String Exp_Date = rs.getString("Exp_Date");
                String Mfg_Date = rs.getString("Mfg_Date");
               
                String tbData[] = {ID,EmployeeId,Title,Category,SubCategory,Manufacture_country,Description,Imgurl,InStock,CostPrice,SellPrice,AddDate,LastUpdated,Exp_Date,Mfg_Date};
                DefaultTableModel tblModel = (DefaultTableModel)productTable.getModel();
                tblModel.addRow(tbData);
                
            }
            con.close();
            
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_product_tab_panelMouseClicked

    private void employee_tab_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employee_tab_panelMouseClicked
        home_panel.setVisible(false);
        products_panel.setVisible(false);
        employee_panel.setVisible(true);
        customer_panel.setVisible(false);
        add_product_panel.setVisible(false);
        order_details_panel.setVisible(false);
        payments_panel.setVisible(false);
        supplies_panel.setVisible(false);
        supplier_panel.setVisible(false);
        add_employee_panel.setVisible(false);
        home_tab_panel.setBackground(new Color(51,51,51));
        product_tab_panel.setBackground(new Color(51,51,51));
        employee_tab_panel.setBackground(new Color(0,102,102));
        customer_tab_panel.setBackground(new Color(51,51,51));
        order_details_tab_panel.setBackground(new Color(51,51,51));
        payments_tab_panel.setBackground(new Color(51,51,51));
        supplies_tab_panel.setBackground(new Color(51,51,51));
        supplier_tab_panel.setBackground(new Color(51,51,51));
        
        try{
            employeeTable.setModel(new DefaultTableModel(null, new String[]{"EmployeeId","Name","DOB","NID","PhoneNumber","Email","Address","EmployStatus","Position","JoiningDate","Salary","Experience","Gender"}));
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM EMPLOYEE";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String EmployeeId = rs.getString("EmployeeId");
                String Name = rs.getString("Name");
                String DOB = rs.getString("DOB");
                String NID = rs.getString("NID");
                String PhoneNumber = rs.getString("PhoneNumber");
                String Email = rs.getString("Email");
                String Address = rs.getString("Address");
                String EmployStatus = rs.getString("EmployStatus");
                String Position = rs.getString("Position");
                String JoiningDate = rs.getString("JoiningDate");
                String Salary = rs.getString("Salary");
                String Experience = rs.getString("Experience");
                String Gender = rs.getString("Gender");
                
               
                String tbData[] = {EmployeeId,Name,DOB,NID,PhoneNumber,Email,Address,EmployStatus,Position,JoiningDate,Salary,Experience,Gender};
                DefaultTableModel tblModel = (DefaultTableModel)employeeTable.getModel();
                tblModel.addRow(tbData);
                
            }
            con.close();
            
        }catch(SQLException e){
            
        }
    }//GEN-LAST:event_employee_tab_panelMouseClicked

    private void customer_tab_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customer_tab_panelMouseClicked
        home_panel.setVisible(false);
        products_panel.setVisible(false);
        employee_panel.setVisible(false);
        customer_panel.setVisible(true);
        add_product_panel.setVisible(false);
        order_details_panel.setVisible(false);
        payments_panel.setVisible(false);
        supplies_panel.setVisible(false);
        supplier_panel.setVisible(false);
        add_employee_panel.setVisible(false);
        home_tab_panel.setBackground(new Color(51,51,51));
        product_tab_panel.setBackground(new Color(51,51,51));
        employee_tab_panel.setBackground(new Color(51,51,51));
        customer_tab_panel.setBackground(new Color(0,102,102));
        order_details_tab_panel.setBackground(new Color(51,51,51));
        payments_tab_panel.setBackground(new Color(51,51,51));
        supplies_tab_panel.setBackground(new Color(51,51,51));
        supplier_tab_panel.setBackground(new Color(51,51,51));
        
        try{
            customerTable.setModel(new DefaultTableModel(null, new String[]{"Customer Id","Employee Id","Name","Address","Phone Number","Email","Last Purchase","Purchase Qty","Spent Money","Gender"}));
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM CUSTOMER";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String CustomerId = rs.getString("CustomerId");
                String EmployeeId = rs.getString("EmployeeId");
                String Name = rs.getString("Name");
                String Address = rs.getString("Address");
                String PhoneNumber = rs.getString("PhoneNumber");
                String Email = rs.getString("Email");
                String LastPurchase = rs.getString("LastPurchase");
                String PurchaseQty = rs.getString("PurchaseQty");
                String SpentMoney = rs.getString("SpentMoney");
                String Gender = rs.getString("Gender");
                
               
                String tbData[] = {CustomerId,EmployeeId,Name,Address,PhoneNumber,Email,LastPurchase,PurchaseQty,SpentMoney,Gender};
                DefaultTableModel tblModel = (DefaultTableModel)customerTable.getModel();
                tblModel.addRow(tbData);
                
            }
            con.close();
            
        }catch(SQLException e){
            System.out.println("ERROR! UNSUCCESSFUL QUERY");
        }
    }//GEN-LAST:event_customer_tab_panelMouseClicked

    private void home_tab_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_tab_panelMouseEntered
        home_tab_panel.setBackground(new Color(0,80,80));
        product_tab_panel.setBackground(new Color(51,51,51));
        employee_tab_panel.setBackground(new Color(51,51,51));
        customer_tab_panel.setBackground(new Color(51,51,51));
        order_details_tab_panel.setBackground(new Color(51,51,51));
        payments_tab_panel.setBackground(new Color(51,51,51));
        supplies_tab_panel.setBackground(new Color(51,51,51));
        supplier_tab_panel.setBackground(new Color(51,51,51));
        
    }//GEN-LAST:event_home_tab_panelMouseEntered

    private void product_tab_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_tab_panelMouseEntered
        home_tab_panel.setBackground(new Color(51,51,51));
        product_tab_panel.setBackground(new Color(0,80,80));
        employee_tab_panel.setBackground(new Color(51,51,51));
        customer_tab_panel.setBackground(new Color(51,51,51));
        order_details_tab_panel.setBackground(new Color(51,51,51));
        payments_tab_panel.setBackground(new Color(51,51,51));
        supplies_tab_panel.setBackground(new Color(51,51,51));
        supplier_tab_panel.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_product_tab_panelMouseEntered

    private void employee_tab_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employee_tab_panelMouseEntered
        home_tab_panel.setBackground(new Color(51,51,51));
        product_tab_panel.setBackground(new Color(51,51,51));
        employee_tab_panel.setBackground(new Color(0,80,80));
        customer_tab_panel.setBackground(new Color(51,51,51));
        order_details_tab_panel.setBackground(new Color(51,51,51));
        payments_tab_panel.setBackground(new Color(51,51,51));
        supplies_tab_panel.setBackground(new Color(51,51,51));
        supplier_tab_panel.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_employee_tab_panelMouseEntered

    private void customer_tab_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customer_tab_panelMouseEntered
        home_tab_panel.setBackground(new Color(51,51,51));
        product_tab_panel.setBackground(new Color(51,51,51));
        employee_tab_panel.setBackground(new Color(51,51,51));
        customer_tab_panel.setBackground(new Color(0,80,80));
        order_details_tab_panel.setBackground(new Color(51,51,51));
        payments_tab_panel.setBackground(new Color(51,51,51));
        supplies_tab_panel.setBackground(new Color(51,51,51));
        supplier_tab_panel.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_customer_tab_panelMouseEntered

    private void home_tab_panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_tab_panelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_home_tab_panelMouseExited

    private void dashBoard_customer_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashBoard_customer_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dashBoard_customer_tfActionPerformed

    private void dashboard_supplyDetails_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboard_supplyDetails_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dashboard_supplyDetails_tfActionPerformed

    private void dashBoard_product_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashBoard_product_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dashBoard_product_tfActionPerformed

    private void dashBoard_orderDetails_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashBoard_orderDetails_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dashBoard_orderDetails_tfActionPerformed

    private void dashBoard_paymentDetails_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashBoard_paymentDetails_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dashBoard_paymentDetails_tfActionPerformed

    private void dashBoard_a_customer_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashBoard_a_customer_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dashBoard_a_customer_tfActionPerformed

    private void dashboard_a_supplyDetails_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboard_a_supplyDetails_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dashboard_a_supplyDetails_tfActionPerformed

    private void dashBoard_a_product_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashBoard_a_product_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dashBoard_a_product_tfActionPerformed

    private void dashBoard_a_orderDetails_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashBoard_a_orderDetails_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dashBoard_a_orderDetails_tfActionPerformed

    private void dashBoard_a_paymentDetails_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashBoard_a_paymentDetails_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dashBoard_a_paymentDetails_tfActionPerformed

    private void dashBoard_a_employees_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashBoard_a_employees_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dashBoard_a_employees_tfActionPerformed

    private void dashBoard_a_supplierDetails_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashBoard_a_supplierDetails_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dashBoard_a_supplierDetails_tfActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        home_panel.setVisible(false);
        products_panel.setVisible(false);
        employee_panel.setVisible(false);
        customer_panel.setVisible(false);
        add_product_panel.setVisible(true);
        order_details_panel.setVisible(false);
        payments_panel.setVisible(false);
        supplies_panel.setVisible(false);
        supplier_panel.setVisible(false);
        add_employee_panel.setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked

    private void product_add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_add_btnActionPerformed
        addProduct();
    }//GEN-LAST:event_product_add_btnActionPerformed

    private void product_reset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_reset_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_product_reset_btnActionPerformed

    private void product_reset_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_reset_btnMouseClicked
        productId_tf1.setText("");
        employeeID_tf.setText("");
        title_tf.setText("");
        category_tf.setText("");
        subcategory_tf.setText("");
        manufacterCountry_tf.setText("");
        description_ta.setText("");
        imgurl_tf.setText("");
        instock_tf.setText("");
        costPrice_tf.setText("");
        salePrice_tf.setText("");
        mfgDate_tf.setText("");
        expDate_tf.setText("");
      //  date_dc.setDateFormatString("");
        exp_dc.setDateFormatString("");
        mfg_dc.setDateFormatString("");
        
    }//GEN-LAST:event_product_reset_btnMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        homepage_details();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedItem = jComboBox1.getSelectedIndex();
        String input_text = jTextField13.getText();
        
        if(selectedItem == 1){
            String sql = "Select * From Product WHERE ProductId = '" + input_text + "' ";
        productTable(sql);
        }
        else if(selectedItem == 2){
            String sql = "Select * From Product WHERE Title = '" + input_text + "' ";
            productTable(sql);
        }
        else if(selectedItem == 3){
            String sql = "Select * From Product WHERE Category = '" + input_text + "' ";
            productTable(sql);
        }
        else if(selectedItem == 4){
            String sql = "Select * From Product WHERE SubCategory = '" + input_text + "' ";
            productTable(sql);
        }
        else if(selectedItem == 5){
            String sql = "Select * From Product WHERE Manufacture_country = '" + input_text + "' ";
            productTable(sql);
        }
        else if(selectedItem == 6){
            String sql = "Select * From Product WHERE EmployeeId = '" + input_text + "' ";
            productTable(sql);
        }
        else if(selectedItem == 7){
            String sql = "Select * From Product WHERE AddDate = '" + input_text + "' ";
            productTable(sql);
        }
        else if(selectedItem == 8){
            String sql = "Select * From Product WHERE InStock < '" + input_text + "' ";
            productTable(sql);
        }
        else if(selectedItem == 9){
            String sql = "Select * From Product WHERE SellPrice < '" + input_text + "' ";
            productTable(sql);
        }
        else if(selectedItem == 10){
            String sql = "Select * From Product WHERE SellPrice > '" + input_text + "' ";
            productTable(sql);
        }
        else if(selectedItem == 11){
            String sql = "SELECT p.* FROM Product p JOIN SUPPLY supply ON supply.ProductId=p.ProductId WHERE supply.SupplierId = '" + input_text + "' ";
            productTable(sql);
        }
        else if(selectedItem == 12){
            String sql = "Select * From Product WHERE DATEDIFF(day,Exp_Date, getdate()) <= '" + input_text + "' ";
            productTable(sql);
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        int selectedItem = jComboBox2.getSelectedIndex();
        
        if(selectedItem == 1){
            String sql = "Select * From Product WHERE InStock >0 ";
        productTable(sql);
        }
        else if(selectedItem == 2){
            String sql = "Select * From Product WHERE InStock <=0 ";
            productTable(sql);
        }
        else if(selectedItem == 3){
            String sql = "SELECT Order_Details.ProductId,SUM(Qty)  FROM Order_Details GROUP BY  Order_Details.ProductId ORDER BY SUM(Qty) DESC";
            productTable(sql);
        }
        else if(selectedItem == 4){
            String sql = "SELECT * FROM Product WHERE DATEDIFF(week,Exp_Date, getdate()) <= 1";
            productTable(sql);
        }
        else if(selectedItem == 5){
            String sql = "SELECT * FROM Product WHERE DATEDIFF(month,Exp_Date, getdate()) <= 1";
            productTable(sql);
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int selectedItem = jComboBox3.getSelectedIndex();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String input_date = df.format(jDateChooser1.getDate());
        String input_date2 = df.format(jDateChooser2.getDate());
        System.out.println(input_date);
        System.out.println(input_date2);
        if(selectedItem == 1){
            String sql = "Select * From Product WHERE AddDate BETWEEN '" + input_date + "'  AND '" + input_date2 + "'";
            productTable(sql);
        }
        else if(selectedItem == 2){
            String sql = "select P.*,Order_Details.SoldDate from Order_Details LEFT JOIN Product P ON Order_details.ProductId=P.ProductId where SoldDate BETWEEN '" + input_date + "'  AND  '" + input_date2 + "' ORDER BY SoldDate DESC ";
            productTable(sql);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void employee_panel_search_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_panel_search_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employee_panel_search_tfActionPerformed

    private void employee_panel_searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_panel_searchbuttonActionPerformed
        int selectedItem = employee_panel_comboBox.getSelectedIndex();
        String input_text = employee_panel_search_tf.getText();
        if(selectedItem == 1){
            String sql = "Select * From Employee WHERE Experience>'" + input_text + "' ";
            employeeTable(sql);
        }
        else if(selectedItem == 2){
            String sql = "Select * From Employee WHERE Address LIKE'" + input_text + "' ";
            employeeTable(sql);
        }
        else if(selectedItem == 3){
            String sql = "Select * From Employee WHERE Gender ='" + input_text + "' ";
            employeeTable(sql);
        }
        else if(selectedItem == 4){
            String sql = "Select * From Employee WHERE EmployStatus ='" + input_text + "' ";
            employeeTable(sql);
        }
        else if(selectedItem == 5){
            String sql = "Select * From Employee WHERE Position ='" + input_text + "' ";
            employeeTable(sql);
        }
        else if(selectedItem == 6){
            String sql = "Select * From Employee WHERE EmployeeId = '" + input_text + "' ";
            employeeTable(sql);
        }

        
    }//GEN-LAST:event_employee_panel_searchbuttonActionPerformed

    private void employee_panel_tf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_panel_tf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employee_panel_tf2ActionPerformed

    private void employee_panel_tf3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_panel_tf3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employee_panel_tf3ActionPerformed

    private void employee_panel_searchbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_panel_searchbutton1ActionPerformed
        String input_text = employee_panel_tf2.getText();
        String input_text2 = employee_panel_tf3.getText();
        
        String sql = "Select * From Employee WHERE Salary BETWEEN '" + input_text + "' AND  '" + input_text2 + "' ";
            employeeTable(sql);
    }//GEN-LAST:event_employee_panel_searchbutton1ActionPerformed

    private void employee_panel_tf4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_panel_tf4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employee_panel_tf4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String input_text = employee_panel_tf4.getText();
        String sql = "DELETE FROM Employee WHERE EmployeeId = '" + input_text + "' ";
            employeeTable(sql);
            employeeTable("Select * FROM Employee");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void order_details_tab_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_order_details_tab_panelMouseClicked
        home_panel.setVisible(false);
        products_panel.setVisible(false);
        employee_panel.setVisible(false);
        customer_panel.setVisible(false);
        add_product_panel.setVisible(false);
        order_details_panel.setVisible(true);
        payments_panel.setVisible(false);
        supplies_panel.setVisible(false);
        supplier_panel.setVisible(false);
        add_employee_panel.setVisible(false);
        home_tab_panel.setBackground(new Color(51,51,51));
        product_tab_panel.setBackground(new Color(51,51,51));
        employee_tab_panel.setBackground(new Color(51,51,51));
        customer_tab_panel.setBackground(new Color(51,51,51));
        order_details_tab_panel.setBackground(new Color(0,102,102));
        payments_tab_panel.setBackground(new Color(51,51,51));
        supplies_tab_panel.setBackground(new Color(51,51,51));
        supplier_tab_panel.setBackground(new Color(51,51,51));
        
        try{
            order_details_Table.setModel(new DefaultTableModel(null, new String[]{"Order Id","Customer Id","Product Id","Employee Id","Quantity","Total Price","Discount","Tax","Final Price","Sold Date","Paid Status"}));
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Order_Details";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String OrderId = rs.getString("OrderId");
                String CustomerId = rs.getString("CustomerId");
                String ProductId = rs.getString("ProductId");
                String EmployeeId = rs.getString("EmployeeId");
                String Qty = rs.getString("Qty");
                String TotalPrice = rs.getString("TotalPrice");
                String Discount = rs.getString("Discount");
                String Tax = rs.getString("Tax");
                String FinalPrice = rs.getString("FinalPrice");
                String SoldDate = rs.getString("SoldDate");
                String PaidStatus = rs.getString("PaidStatus");
                
               
                String tbData[] = {OrderId,CustomerId,ProductId,EmployeeId,Qty,TotalPrice,Discount,Tax,FinalPrice,SoldDate,PaidStatus};
                DefaultTableModel tblModel = (DefaultTableModel)order_details_Table.getModel();
                tblModel.addRow(tbData);
                
            }
            con.close();
            
        }catch(SQLException e){
            System.out.println("ERROR! UNSUCCESSFUL QUERY");
        }
    }//GEN-LAST:event_order_details_tab_panelMouseClicked

    private void order_details_tab_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_order_details_tab_panelMouseEntered
        home_tab_panel.setBackground(new Color(51,51,51));
        product_tab_panel.setBackground(new Color(51,51,51));
        employee_tab_panel.setBackground(new Color(51,51,51));
        customer_tab_panel.setBackground(new Color(51,51,51));
        order_details_tab_panel.setBackground(new Color(0,80,80));
        payments_tab_panel.setBackground(new Color(51,51,51));
        supplies_tab_panel.setBackground(new Color(51,51,51));
        supplier_tab_panel.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_order_details_tab_panelMouseEntered

    private void payments_tab_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payments_tab_panelMouseClicked
         home_panel.setVisible(false);
        products_panel.setVisible(false);
        employee_panel.setVisible(false);
        customer_panel.setVisible(false);
        add_product_panel.setVisible(false);
        order_details_panel.setVisible(false);
        payments_panel.setVisible(true);
        supplies_panel.setVisible(false);
        supplier_panel.setVisible(false);
        add_employee_panel.setVisible(false);
        home_tab_panel.setBackground(new Color(51,51,51));
        product_tab_panel.setBackground(new Color(51,51,51));
        employee_tab_panel.setBackground(new Color(51,51,51));
        customer_tab_panel.setBackground(new Color(51,51,51));
        order_details_tab_panel.setBackground(new Color(51,51,51));
        payments_tab_panel.setBackground(new Color(0,102,102));
        supplies_tab_panel.setBackground(new Color(51,51,51));
        supplier_tab_panel.setBackground(new Color(51,51,51));
        
        try{
            paymentsTable.setModel(new DefaultTableModel(null, new String[]{"Bill_Id","Employee Id","Order Id","Pay_type","Pay_CardNo","PayDate","Pay_Time","Paid Status"}));
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Payment";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String Bill_Id = rs.getString("Bill_Id");
                String EmployeeId = rs.getString("EmployeeId");
                String OrderId = rs.getString("OrderId");
                String Pay_type = rs.getString("Pay_type");
                String Pay_CardNo = rs.getString("Pay_CardNo");
                String PayDate = rs.getString("PayDate");
                String Pay_Time = rs.getString("Pay_Time");
                String PaidStatus = rs.getString("PaidStatus");
                
               
                String tbData[] = {Bill_Id,EmployeeId,OrderId,Pay_type,Pay_CardNo,PayDate,Pay_Time,PaidStatus};
                DefaultTableModel tblModel = (DefaultTableModel)paymentsTable.getModel();
                tblModel.addRow(tbData);
                
            }
            con.close();
            
        }catch(SQLException e){
            System.out.println("ERROR! UNSUCCESSFUL QUERY");
        }
    }//GEN-LAST:event_payments_tab_panelMouseClicked

    private void payments_tab_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payments_tab_panelMouseEntered
        home_tab_panel.setBackground(new Color(51,51,51));
        product_tab_panel.setBackground(new Color(51,51,51));
        employee_tab_panel.setBackground(new Color(51,51,51));
        customer_tab_panel.setBackground(new Color(51,51,51));
        order_details_tab_panel.setBackground(new Color(51,51,51));
        payments_tab_panel.setBackground(new Color(0,80,80));
        supplies_tab_panel.setBackground(new Color(51,51,51));
        supplier_tab_panel.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_payments_tab_panelMouseEntered

    private void supplies_tab_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplies_tab_panelMouseClicked
        home_panel.setVisible(false);
        products_panel.setVisible(false);
        employee_panel.setVisible(false);
        customer_panel.setVisible(false);
        add_product_panel.setVisible(false);
        order_details_panel.setVisible(false);
        payments_panel.setVisible(false);
        supplies_panel.setVisible(true);
        supplier_panel.setVisible(false);
        add_employee_panel.setVisible(false);
        home_tab_panel.setBackground(new Color(51,51,51));
        product_tab_panel.setBackground(new Color(51,51,51));
        employee_tab_panel.setBackground(new Color(51,51,51));
        customer_tab_panel.setBackground(new Color(51,51,51));
        order_details_tab_panel.setBackground(new Color(51,51,51));
        payments_tab_panel.setBackground(new Color(51,51,51));
        supplies_tab_panel.setBackground(new Color(0,102,102));
        supplier_tab_panel.setBackground(new Color(51,51,51));
        
        try{
            suppliesTable.setModel(new DefaultTableModel(null, new String[]{"Supply Id","Product Id","Supplier Id","Employee Id","Supply Date","Quantity","Cost Price","Total Cost Price"}));
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM SUPPLY";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String Supply_Id = rs.getString("SupplyId");
                String Product_Id = rs.getString("ProductId");
                String Supplier_Id = rs.getString("SupplierId");
                String Employee_Id = rs.getString("EmployeeId");
                String Supply_Date = rs.getString("SupplyDate");
                String Quantity = rs.getString("Qty");
                String Cost_Price = rs.getString("CostPrice");
                String Total_Cost_Price = rs.getString("Total_CostPrice");
                
               
                String tbData[] = {Supply_Id,Product_Id,Supplier_Id,Employee_Id,Supply_Date,Quantity,Cost_Price,Total_Cost_Price};
                DefaultTableModel tblModel = (DefaultTableModel)suppliesTable.getModel();
                tblModel.addRow(tbData);
                
            }
            con.close();
            
        }catch(SQLException e){
            System.out.println("ERROR! UNSUCCESSFUL QUERY");
        }
    }//GEN-LAST:event_supplies_tab_panelMouseClicked

    private void supplies_tab_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplies_tab_panelMouseEntered
        home_tab_panel.setBackground(new Color(51,51,51));
        product_tab_panel.setBackground(new Color(51,51,51));
        employee_tab_panel.setBackground(new Color(51,51,51));
        customer_tab_panel.setBackground(new Color(51,51,51));
        order_details_tab_panel.setBackground(new Color(51,51,51));
        payments_tab_panel.setBackground(new Color(51,51,51));
        supplies_tab_panel.setBackground(new Color(0,80,80));
        supplier_tab_panel.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_supplies_tab_panelMouseEntered

    private void supplier_tab_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplier_tab_panelMouseClicked
        home_panel.setVisible(false);
        products_panel.setVisible(false);
        employee_panel.setVisible(false);
        customer_panel.setVisible(false);
        add_product_panel.setVisible(false);
        order_details_panel.setVisible(false);
        payments_panel.setVisible(false);
        supplies_panel.setVisible(false);
        supplier_panel.setVisible(true);
        add_employee_panel.setVisible(false);
        home_tab_panel.setBackground(new Color(51,51,51));
        product_tab_panel.setBackground(new Color(51,51,51));
        employee_tab_panel.setBackground(new Color(51,51,51));
        customer_tab_panel.setBackground(new Color(51,51,51));
        order_details_tab_panel.setBackground(new Color(51,51,51));
        payments_tab_panel.setBackground(new Color(51,51,51));
        supplies_tab_panel.setBackground(new Color(51,51,51));
        supplier_tab_panel.setBackground(new Color(0,102,102));
        
        try{
            supplierTable.setModel(new DefaultTableModel(null, new String[]{"Supplier Id","Name","Address","Phone Number","Email"}));
            
            Connection con = ConnectionToSQL.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM SUPPLIER";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String Supplier_Id = rs.getString("SupplierId");
                String name = rs.getString("Name");
                String address = rs.getString("Address");
                String phone_no = rs.getString("PhoneNumber");
                String email = rs.getString("Email");
                
                
               
                String tbData[] = {Supplier_Id,name,address,phone_no,email};
                DefaultTableModel tblModel = (DefaultTableModel)supplierTable.getModel();
                tblModel.addRow(tbData);
                
            }
            con.close();
            
        }catch(SQLException e){
            System.out.println("ERROR! UNSUCCESSFUL QUERY");
        }
    }//GEN-LAST:event_supplier_tab_panelMouseClicked

    private void supplier_tab_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplier_tab_panelMouseEntered
        home_tab_panel.setBackground(new Color(51,51,51));
        product_tab_panel.setBackground(new Color(51,51,51));
        employee_tab_panel.setBackground(new Color(51,51,51));
        customer_tab_panel.setBackground(new Color(51,51,51));
        order_details_tab_panel.setBackground(new Color(51,51,51));
        payments_tab_panel.setBackground(new Color(51,51,51));
        supplies_tab_panel.setBackground(new Color(51,51,51));
        supplier_tab_panel.setBackground(new Color(0,80,80));
    }//GEN-LAST:event_supplier_tab_panelMouseEntered

    private void home_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_panelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_home_panelMouseClicked

    private void supplies_panel_search_tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplies_panel_search_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplies_panel_search_tf1ActionPerformed

    private void supplies_panel_searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplies_panel_searchbuttonActionPerformed
        String input_text = supplies_panel_search_tf1.getText();
        int selectedItem = supplies_panel_comboBox1.getSelectedIndex();
        
        if(selectedItem == 1){
            String sql = "Select * From SUPPLY WHERE SupplyId = '" + input_text + "' ";
            supplyTable(sql);
        }
        else if(selectedItem == 2){
            String sql = "Select * From SUPPLY WHERE ProductId = '" + input_text + "' ";
            supplyTable(sql);
        }
        else if(selectedItem == 3){
            String sql = "Select * From SUPPLY WHERE SupplierId = '" + input_text + "' ";
            supplyTable(sql);
        }
        else if(selectedItem == 4){
            String sql = "Select * From SUPPLY WHERE EmployeeId = '" + input_text + "' ";
            supplyTable(sql);
        }
        else if(selectedItem == 5){
            String sql = "Select * From SUPPLY WHERE CostPrice < '" + input_text + "' ";
            supplyTable(sql);
        }
    }//GEN-LAST:event_supplies_panel_searchbuttonActionPerformed

    private void supplies_panel_tf5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplies_panel_tf5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplies_panel_tf5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String input_text = supplies_panel_tf5.getText();
        String sql = "DELETE FROM SUPPLY WHERE SupplyID = '" + input_text + "' ";
            supplyTable(sql);
            supplyTable("Select * FROM SUPPLY");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void supplier_panel_search_tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_panel_search_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplier_panel_search_tf1ActionPerformed

    private void supplier_panel_searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_panel_searchbuttonActionPerformed
        String input_text = supplier_panel_search_tf1.getText();
        int selectedItem = supplier_panel_comboBox.getSelectedIndex();
        
        if(selectedItem == 1){
            String sql = "Select * From SUPPLIER WHERE SupplierId = '" + input_text + "' ";
            supplierTable(sql);
        }
        else if(selectedItem == 2){
            String sql = "Select * From SUPPLIER WHERE Name = '" + input_text + "' ";
            supplierTable(sql);
        }
        else if(selectedItem == 3){
            String sql = "Select * From SUPPLIER WHERE Address = '" + input_text + "' ";
            supplierTable(sql);
        }
    }//GEN-LAST:event_supplier_panel_searchbuttonActionPerformed

    private void supplier_panel_tf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_panel_tf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplier_panel_tf2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String input_text = supplier_panel_tf2.getText();
        String sql = "DELETE FROM SUPPLIER WHERE SupplierId = '" + input_text + "' ";
            supplierTable(sql);
            supplierTable("Select * FROM SUPPLIER");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void order_details_panel_search_tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_details_panel_search_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_order_details_panel_search_tf1ActionPerformed

    private void order_details_panel_searchbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_details_panel_searchbutton1ActionPerformed
        String input_text = order_details_panel_search_tf1.getText();
        int selectedItem = order_details_panel_comboBox1.getSelectedIndex();
        
        if(selectedItem == 1){
            String sql = "Select * From Order_Details WHERE OrderId = '" + input_text + "' ";
            order_details_table(sql);
        }
        else if(selectedItem == 2){
            String sql = "Select * From Order_Details WHERE EmployeeId = '" + input_text + "' ";
            order_details_table(sql);
        }
        else if(selectedItem == 3){
            String sql = "Select * From Order_Details WHERE CustomerId IN (SELECT CustomerId FROM Customer WHERE Name = '" + input_text + "' ) ";
            order_details_table(sql);
        }
        else if(selectedItem == 4){
            String sql = "Select * From Order_Details WHERE CustomerId IN (SELECT CustomerId FROM Customer WHERE PhoneNumber = '" + input_text + "' ) ";
            order_details_table(sql);
        }
        else if(selectedItem == 5){
            String sql = "Select * From Order_Details WHERE CustomerId = '" + input_text + "' ";
            order_details_table(sql);
        }
        else if(selectedItem == 6){
            String sql = "SELECT O.* FROM Order_Details O JOIN Product P ON O.ProductId=P.ProductId WHERE P.SellPrice >'" + input_text + "' ";
            order_details_table(sql);
        }
        else if(selectedItem == 7){
            String sql = "SELECT * FROM Order_Details WHERE TotalPrice > '" + input_text + "' ";
            order_details_table(sql);
        }
    }//GEN-LAST:event_order_details_panel_searchbutton1ActionPerformed

    private void order_details_panel_tf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_details_panel_tf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_order_details_panel_tf2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String input_text = order_details_panel_tf2.getText();
        String sql = "DELETE FROM Order_Details WHERE OrderId = '" + input_text + "' ";
            supplierTable(sql);
            supplierTable("Select * FROM Order_Details");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void order_details_panel_comboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_details_panel_comboBox2ActionPerformed
        
        int selectedItem = order_details_panel_comboBox2.getSelectedIndex();
        
        if(selectedItem == 1){
            String sql = "Select * From Order_Details WHERE PaidStatus = 1 ";
            order_details_table(sql);
        }
        else if(selectedItem == 2){
            String sql = "Select * From Order_Details WHERE Discount > 0";
            order_details_table(sql);
        }
        else if(selectedItem == 3){
            String sql = "Select * From Order_Details WHERE Discount = 0";
            order_details_table(sql);
        }    
    }//GEN-LAST:event_order_details_panel_comboBox2ActionPerformed

    private void order_details_panel_tf3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_details_panel_tf3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_order_details_panel_tf3ActionPerformed

    private void order_details_panel_tf4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_details_panel_tf4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_order_details_panel_tf4ActionPerformed

    private void order_details_panel_searchbutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_details_panel_searchbutton2ActionPerformed
        String input_text = order_details_panel_tf3.getText();
        String input_text2 = order_details_panel_tf4.getText();
        int selectedItem = order_details_panel_comboBox3.getSelectedIndex();
        
        if(selectedItem == 1){
            String sql = "SELECT SUM(Qty) AS goods_sold FROM order_details WHERE PaidStatus=1 AND SoldDate = '" + input_text + "' ";
            order_details_table_2(sql);
        }
        else if(selectedItem == 2){
            String sql = "SELECT SUM(Qty) AS goods_sold FROM order_details WHERE PaidStatus=1 AND MONTH(SoldDate) = '" + input_text + "' AND YEAR(SoldDate) = '" + input_text2 + "' ";
            order_details_table_2(sql);
        }
        else if(selectedItem == 3){
            String sql = "SELECT SUM(Qty) AS goods_sold FROM order_details WHERE PaidStatus=1 AND YEAR(SoldDate) = '" + input_text + "' ";
            order_details_table_2(sql);
        }
        else if(selectedItem == 4){
            String sql = "SELECT SUM(Qty) AS goods_sold FROM order_details WHERE PaidStatus=1 AND SoldDate BETWEEN '" + input_text + "' AND  '" + input_text2 + "' ";
            order_details_table_2(sql);
        }
        else if(selectedItem == 5){
            String sql = "SELECT SUM(FinalPrice) AS Income FROM order_details WHERE PaidStatus=1 AND SoldDate BETWEEN '" + input_text + "' AND  '" + input_text2 + "' ";
            order_details_table_3(sql);
        }
        else if(selectedItem == 6){
            String sql = "SELECT SUM(FinalPrice-tax) AS Profit FROM order_details WHERE PaidStatus=1 AND SoldDate BETWEEN '" + input_text + "' AND  '" + input_text2 + "' ";
            order_details_table_4(sql);
        }
    }//GEN-LAST:event_order_details_panel_searchbutton2ActionPerformed

    private void customer_panel_tf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_panel_tf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customer_panel_tf2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String input_text = customer_panel_tf2.getText();
        String sql = "DELETE FROM CUSTOMER WHERE CustomerId = '" + input_text + "' ";
            supplierTable(sql);
            supplierTable("Select * FROM Customer");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void customer_panel_search_tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_panel_search_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customer_panel_search_tf1ActionPerformed

    private void customer_panel_searchbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_panel_searchbutton1ActionPerformed
        String input_text = customer_panel_search_tf1.getText();
 
        int selectedItem = customer_panel_comboBox1.getSelectedIndex();
        
        if(selectedItem == 1){
            String sql = "Select * From Customer WHERE CustomerId = '" + input_text + "' ";
            customerTable(sql);
        }
        else if(selectedItem == 2){
            String sql = "Select * From Customer WHERE Name LIKE'" + input_text + "' ";
            customerTable(sql);
        }
        else if(selectedItem == 3){
            String sql = "Select * From Customer WHERE PhoneNumber = '" + input_text + "' ";
            customerTable(sql);
        }
        else if(selectedItem == 4){
            String sql = "Select * From Customer WHERE Address LIKE '" + input_text + "' ";
            customerTable(sql);
        }
        else if(selectedItem == 5){
            String sql = "Select * From Customer WHERE EmployeeId = '" + input_text + "' ";
            customerTable(sql);
        }
        else if(selectedItem == 6){
            String sql = "Select * From Customer WHERE SpentMoney >'" + input_text + "' ";
            customerTable(sql);
        }
        else if(selectedItem == 7){
            String sql = "Select * From Customer WHERE PurchaseQty >'" + input_text + "' ";
            customerTable(sql);
        }
    }//GEN-LAST:event_customer_panel_searchbutton1ActionPerformed

    private void customer_panel_searchbutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_panel_searchbutton2ActionPerformed
        int selectedItem = customer_panel_comboBox2.getSelectedIndex();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String input_date = df.format(customer_DateChooser1.getDate());
        String input_date2 = df.format(customer_DateChooser2.getDate());
        
        if(selectedItem == 1){
            String sql = "Select * From Customer WHERE customerId NOT IN (SELECT customerId FROM order_details WHERE soldDate BETWEEN '" + input_date + "' AND '" + input_date2 + "' )  ";
            customerTable(sql);
        }
        else if(selectedItem == 2){
            String sql = "Select * From Customer WHERE customerId IN (SELECT customerId FROM order_details WHERE soldDate BETWEEN '" + input_date + "' AND '" + input_date2 + "' )  ";
            customerTable(sql);
        }
    }//GEN-LAST:event_customer_panel_searchbutton2ActionPerformed

    private void payments_panel_tf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payments_panel_tf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payments_panel_tf2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String input_text = payments_panel_tf2.getText();
        String sql = "DELETE FROM CUSTOMER WHERE Bill_Id = '" + input_text + "' ";
            paymentTable(sql);
            paymentTable("Select * FROM Payment");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void payments_panel_search_tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payments_panel_search_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payments_panel_search_tf1ActionPerformed

    private void payments_panel_searchbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payments_panel_searchbutton1ActionPerformed
        String input_text = payments_panel_search_tf1.getText();
        int selectedItem = payments_panel_comboBox1.getSelectedIndex();
        
        if(selectedItem == 1){
            String sql = "Select * From PAYMENT WHERE Bill_Id = '" + input_text + "' ";
            paymentTable(sql);
        }
        else if(selectedItem == 2){
            String sql = "SELECT * FROM PAYMENT  WHERE PayDate = '" + input_text + "'";
            paymentTable(sql);
        }
        else if(selectedItem == 3){
            String sql = "SELECT * FROM PAYMENT WHERE EmployeeId = '" + input_text + "' ";
            paymentTable(sql);
        }
    }//GEN-LAST:event_payments_panel_searchbutton1ActionPerformed

    private void payments_panel_searchbutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payments_panel_searchbutton2ActionPerformed
        
        int selectedItem = payments_panel_comboBox2.getSelectedIndex();
        
        if(selectedItem == 1){
            String sql = "SELECT * FROM PAYMENT WHERE PaidStatus=1";
            paymentTable(sql);
        }
        else if(selectedItem == 2){
            String sql = "SELECT * FROM PAYMENT WHERE PaidStatus=2";
            paymentTable(sql);
        }
        else if(selectedItem == 3){
            String sql = "SELECT * FROM PAYMENT WHERE Pay_Type='Cash' ";
            paymentTable(sql);
        }
        else if(selectedItem == 4){
            String sql = "SELECT * FROM PAYMENT WHERE Pay_Type='Card' ";
            paymentTable(sql);
        }
    }//GEN-LAST:event_payments_panel_searchbutton2ActionPerformed

    private void addproduct_panel_searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addproduct_panel_searchbuttonActionPerformed
        String input = productId_tf1.getText();
        updateProduct(input);
    }//GEN-LAST:event_addproduct_panel_searchbuttonActionPerformed

    private void product_update_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_update_btnMouseClicked
        try{
            Connection con = ConnectionToSQL.getConnection();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            
            
            String url = "UPDATE Product SET EmployeeId = '"+employeeID_tf.getText()+"', Title = '"+title_tf.getText()+"', Category = '"+category_tf.getText()+"', SubCategory = '"+subcategory_tf.getText()+"', Manufacture_country = '"+manufacterCountry_tf.getText()+"', Description = '"+description_ta.getText()+"', Imgurl = '"+imgurl_tf.getText()+"', InStock = '"+instock_tf.getText()+"', CostPrice = '"+costPrice_tf.getText()+"', SellPrice = '"+salePrice_tf.getText()+"', Mfg_Date = '"+mfgDate_tf.getText()+"', Exp_Date = '"+expDate_tf.getText()+"' WHERE ProductId = '"+productId_tf1.getText()+"' ";
            
            PreparedStatement ps = con.prepareStatement(url);
            /*ps.setString(1, employeeID_tf.getText());
            ps.setString(2, title_tf.getText());
            ps.setString(3, category_tf.getText());
            ps.setString(4, subcategory_tf.getText());
            ps.setString(5, manufacterCountry_tf.getText());
            ps.setString(6, description_ta.getText());
            ps.setString(7, imgurl_tf.getText());
            ps.setString(8, instock_tf.getText());
            ps.setString(9, costPrice_tf.getText());
            ps.setString(10, salePrice_tf.getText());
            ps.setString(11, df.format(mfg_dc.getDate()));
            ps.setString(12, df.format(exp_dc.getDate()));*/
            
            int i = ps.executeUpdate();
            
            if(i>0){
                JOptionPane.showMessageDialog(this, "Record Updated Successfully!!");
            }
            
        }catch(SQLException e){
            System.out.println(e);
        } 
    }//GEN-LAST:event_product_update_btnMouseClicked

    private void product_update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_update_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_product_update_btnActionPerformed

    private void employee_add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_add_btnActionPerformed
        addEmployee();
    }//GEN-LAST:event_employee_add_btnActionPerformed

    private void employee_reset_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employee_reset_btnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_employee_reset_btnMouseClicked

    private void employee_reset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_reset_btnActionPerformed
        employeeId_tf.setText("");
        employeePass_tf.setText("");
        employeeName_tf.setText("");
        nid_tf.setText("");
        phoneNo_tf.setText("");
        employeeEmail_tf.setText("");
        employeeaddress_tf.setText("");
        EmployStatus_tf.setText("");
        Position_tf.setText("");
        employeesalary_tf.setText("");
        Experience_tf.setText("");
        Gender_tf.setText("");
        dob_tf.setText("");
      //  date_dc.setDateFormatString("");
        dob_dc.setDateFormatString("");
    }//GEN-LAST:event_employee_reset_btnActionPerformed

    private void addemployee_panel_searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addemployee_panel_searchbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addemployee_panel_searchbuttonActionPerformed

    private void employee_update_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employee_update_btnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_employee_update_btnMouseClicked

    private void employee_update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_update_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employee_update_btnActionPerformed

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        home_panel.setVisible(false);
        products_panel.setVisible(false);
        employee_panel.setVisible(false);
        customer_panel.setVisible(false);
        add_product_panel.setVisible(false);
        order_details_panel.setVisible(false);
        payments_panel.setVisible(false);
        supplies_panel.setVisible(false);
        supplier_panel.setVisible(false);
        add_employee_panel.setVisible(true);
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EmployStatus_tf;
    private javax.swing.JTextField Experience_tf;
    private javax.swing.JTextField Gender_tf;
    private javax.swing.JTextField Position_tf;
    private javax.swing.JPanel add_employee_panel;
    private javax.swing.JPanel add_product_panel;
    private javax.swing.JButton addemployee_panel_searchbutton;
    private javax.swing.JButton addproduct_panel_searchbutton;
    private javax.swing.JTextField category_tf;
    private javax.swing.JTextField costPrice_tf;
    private javax.swing.JTable customerTable;
    private com.toedter.calendar.JDateChooser customer_DateChooser1;
    private com.toedter.calendar.JDateChooser customer_DateChooser2;
    private javax.swing.JPanel customer_panel;
    private javax.swing.JComboBox<String> customer_panel_comboBox1;
    private javax.swing.JComboBox<String> customer_panel_comboBox2;
    private javax.swing.JTextField customer_panel_search_tf1;
    private javax.swing.JButton customer_panel_searchbutton1;
    private javax.swing.JButton customer_panel_searchbutton2;
    private javax.swing.JTextField customer_panel_tf2;
    private javax.swing.JPanel customer_tab_panel;
    private javax.swing.JTextField dashBoard_a_customer_tf;
    private javax.swing.JTextField dashBoard_a_employees_tf;
    private javax.swing.JTextField dashBoard_a_orderDetails_tf;
    private javax.swing.JTextField dashBoard_a_paymentDetails_tf;
    private javax.swing.JTextField dashBoard_a_product_tf;
    private javax.swing.JTextField dashBoard_a_supplierDetails_tf;
    private javax.swing.JTextField dashBoard_customer_tf;
    private javax.swing.JTextField dashBoard_orderDetails_tf;
    private javax.swing.JTextField dashBoard_paymentDetails_tf;
    private javax.swing.JTextField dashBoard_product_tf;
    private javax.swing.JTextField dashboard_a_supplyDetails_tf;
    private javax.swing.JTextField dashboard_supplyDetails_tf;
    private javax.swing.JTextArea description_ta;
    private com.toedter.calendar.JDateChooser dob_dc;
    private javax.swing.JTextField dob_tf;
    private javax.swing.JTextField employeeEmail_tf;
    private javax.swing.JTextField employeeID_tf;
    private javax.swing.JTextField employeeId_tf;
    private javax.swing.JTextField employeeName_tf;
    private javax.swing.JTextField employeePass_tf;
    private javax.swing.JTable employeeTable;
    private javax.swing.JButton employee_add_btn;
    private javax.swing.JPanel employee_panel;
    private javax.swing.JComboBox<String> employee_panel_comboBox;
    private javax.swing.JTextField employee_panel_search_tf;
    private javax.swing.JButton employee_panel_searchbutton;
    private javax.swing.JButton employee_panel_searchbutton1;
    private javax.swing.JTextField employee_panel_tf2;
    private javax.swing.JTextField employee_panel_tf3;
    private javax.swing.JTextField employee_panel_tf4;
    private javax.swing.JButton employee_reset_btn;
    private javax.swing.JPanel employee_tab_panel;
    private javax.swing.JButton employee_update_btn;
    private javax.swing.JTextField employeeaddress_tf;
    private javax.swing.JTextField employeesalary_tf;
    private javax.swing.JTextField expDate_tf;
    private com.toedter.calendar.JDateChooser exp_dc;
    private javax.swing.JLabel home_label;
    private javax.swing.JPanel home_panel;
    private javax.swing.JPanel home_tab_panel;
    private javax.swing.JTextField imgurl_tf;
    private javax.swing.JTextField instock_tf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField manufacterCountry_tf;
    private javax.swing.JTextField mfgDate_tf;
    private com.toedter.calendar.JDateChooser mfg_dc;
    private javax.swing.JTextField nid_tf;
    private javax.swing.JTable order_details_Table;
    private javax.swing.JPanel order_details_panel;
    private javax.swing.JComboBox<String> order_details_panel_comboBox1;
    private javax.swing.JComboBox<String> order_details_panel_comboBox2;
    private javax.swing.JComboBox<String> order_details_panel_comboBox3;
    private javax.swing.JTextField order_details_panel_search_tf1;
    private javax.swing.JButton order_details_panel_searchbutton1;
    private javax.swing.JButton order_details_panel_searchbutton2;
    private javax.swing.JTextField order_details_panel_tf2;
    private javax.swing.JTextField order_details_panel_tf3;
    private javax.swing.JTextField order_details_panel_tf4;
    private javax.swing.JPanel order_details_tab_panel;
    private javax.swing.JTable paymentsTable;
    private javax.swing.JPanel payments_panel;
    private javax.swing.JComboBox<String> payments_panel_comboBox1;
    private javax.swing.JComboBox<String> payments_panel_comboBox2;
    private javax.swing.JTextField payments_panel_search_tf1;
    private javax.swing.JButton payments_panel_searchbutton1;
    private javax.swing.JButton payments_panel_searchbutton2;
    private javax.swing.JTextField payments_panel_tf2;
    private javax.swing.JPanel payments_tab_panel;
    private javax.swing.JTextField phoneNo_tf;
    private javax.swing.JTextField productId_tf1;
    private javax.swing.JTable productTable;
    private javax.swing.JButton product_add_btn;
    private javax.swing.JButton product_reset_btn;
    private javax.swing.JPanel product_tab_panel;
    private javax.swing.JButton product_update_btn;
    private javax.swing.JPanel products_panel;
    private javax.swing.JTextField salePrice_tf;
    private javax.swing.JTextField subcategory_tf;
    private javax.swing.JTable supplierTable;
    private javax.swing.JPanel supplier_panel;
    private javax.swing.JComboBox<String> supplier_panel_comboBox;
    private javax.swing.JTextField supplier_panel_search_tf1;
    private javax.swing.JButton supplier_panel_searchbutton;
    private javax.swing.JTextField supplier_panel_tf2;
    private javax.swing.JPanel supplier_tab_panel;
    private javax.swing.JTable suppliesTable;
    private javax.swing.JPanel supplies_panel;
    private javax.swing.JComboBox<String> supplies_panel_comboBox1;
    private javax.swing.JTextField supplies_panel_search_tf1;
    private javax.swing.JButton supplies_panel_searchbutton;
    private javax.swing.JTextField supplies_panel_tf5;
    private javax.swing.JPanel supplies_tab_panel;
    private javax.swing.JTextField title_tf;
    // End of variables declaration//GEN-END:variables
}
