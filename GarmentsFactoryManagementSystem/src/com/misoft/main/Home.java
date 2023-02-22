/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misoft.main;

import com.misoft.gui.DeliveryForm;
import com.misoft.gui.DepartmentForm;
import com.misoft.gui.EmployeeForm;
import com.misoft.gui.InStockMaterials;
import com.misoft.gui.InStockProductForm;
import com.misoft.gui.ProductForm;
import com.misoft.gui.PurchaseOrderForm;
import com.misoft.gui.RawMaterialOrder;
import com.misoft.gui.RawMaterialPurchase;
import com.misoft.gui.SellingForm;
import com.misoft.gui.SupplierForm;
import com.misoft.util.DBConnection;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class Home extends javax.swing.JFrame {
    DefaultTableModel model;

    public Home() {
        initComponents();
        Toolkit tk = getToolkit();
        Dimension size = tk.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        purchaseOrderView();
        productView();
        rawMaterialOrderView();
        rawMaterialPurchaseView();
        rawMaterialInstockView();
        sellingView();
        deliveryView();
        supplierView();
        billingView();
        employeeView();
        departmentView();
        productionView();
        inStockProductView();
        productCostView();
    }
    
    public void productCostView(){
        model = new DefaultTableModel();
        model.addColumn("SL");
        model.addColumn("Product ID");
        model.addColumn("Import Cost");
        model.addColumn("Material Cost");
        model.addColumn("Production Cost");
        model.addColumn("Delivery Cost");
        model.addColumn("Wage Cost");
        model.addColumn("Total Cost");
        
        
        
        String sql = "select * from product_cost";
        try {
              Connection con = DBConnection.getConnection();
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
             
              while(rs.next()){ 
                  String sl = rs.getString("id");
                  String productId = rs.getString("product_id");
                  String importCost = rs.getString("import_cost");
                  String materialCost = rs.getString("material_cost");
                  String ProductionCost = rs.getString("production_cost");
                  String deliveryCost = rs.getString("delivery_cost");
                  String wageCost = rs.getString("wage_cost");
                  String totalCost = rs.getString("total_cost");
                  
                  
                  
                  Object[] rowData = {sl, productId, importCost, materialCost, ProductionCost, deliveryCost, wageCost, totalCost};
                  model.addRow(rowData);
              }        
              jTableProductCost.setModel(model);
              
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void inStockProductView(){
        model = new DefaultTableModel();
        model.addColumn("SL");
        model.addColumn("Product ID");
        model.addColumn("Color");
        model.addColumn("Item");
        model.addColumn("Material");
        model.addColumn("Category");
        model.addColumn("Quantity");
        model.addColumn("Size");
        model.addColumn("Cost");
        model.addColumn("Description");
        
        
        String sql = "select * from instock_products";
        try {
              Connection con = DBConnection.getConnection();
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
             
              while(rs.next()){ 
                  String sl = rs.getString("id");
                  String productId = rs.getString("product_id");
                  String color = rs.getString("color");
                  String item = rs.getString("item");
                  String material = rs.getString("material");
                  String category = rs.getString("category");
                  String quantity = rs.getString("quantity");
                  String size = rs.getString("size");
                  String cost = rs.getString("cost");
                  String description = rs.getString("description");
                  
                  
                  
                  Object[] rowData = {sl, productId, color, item, material, category, quantity, size, cost, description};
                  model.addRow(rowData);
              }        
              jTableInstockProduct.setModel(model);
              
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void productionView(){
        model = new DefaultTableModel();
        model.addColumn("SL");
        model.addColumn("Product ID");
        model.addColumn("Category");
        model.addColumn("Stage");
        model.addColumn("Description");
        
        
        String sql = "select * from production";
        try {
              Connection con = DBConnection.getConnection();
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
             
              while(rs.next()){ 
                  String sl = rs.getString("id");
                  String productId = rs.getString("product_id");
                  String category = rs.getString("category");
                  String stage = rs.getString("stage");
                  String description = rs.getString("description");
                  
                  
                  
                  Object[] rowData = {sl ,productId, category, stage, description};
                  model.addRow(rowData);
              }        
              jTableProduction.setModel(model);
              
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void departmentView(){
        model = new DefaultTableModel();
        model.addColumn("SL");
        model.addColumn("Department ID");
        model.addColumn("Department Name");
        model.addColumn("Manager Id");
        model.addColumn("Manager Name");
        
        
        String sql = "select * from department";
        try {
              Connection con = DBConnection.getConnection();
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
             
              while(rs.next()){ 
                  String sl = rs.getString("id");
                  String deptId = rs.getString("department_id");
                  String deptName = rs.getString("department_name");
                  String managerId = rs.getString("manager_id");
                  String managerName = rs.getString("manager_name");
                  
                  
                  
                  Object[] rowData = {sl ,deptId, deptName, managerId, managerName};
                  model.addRow(rowData);
              }        
              jTableDepartment.setModel(model);
              
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void employeeView(){
        model = new DefaultTableModel();
        model.addColumn("SL");
        model.addColumn("Employee_id");
        model.addColumn("Name");
        model.addColumn("Phone");
        model.addColumn("Email");
        model.addColumn("Hire Date");
        model.addColumn("Designation");
        model.addColumn("Department");
        model.addColumn("Basic Pay");
        model.addColumn("Country");
        model.addColumn("City");
        model.addColumn("District");
        model.addColumn("Village/Area");
        
        
        String sql = "select * from employee";
        try {
              Connection con = DBConnection.getConnection();
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
             
              while(rs.next()){ 
                  String sl = rs.getString("id");
                  String empId = rs.getString("employee_id");
                  String name = rs.getString("name");
                  String phone = rs.getString("phone");
                  String email = rs.getString("email");
                  String hireDate = rs.getString("hire_date");
                  String designation = rs.getString("designation");
                  String department = rs.getString("department");
                  String basicPay = rs.getString("basic_pay");
                  String country = rs.getString("country");
                  String city = rs.getString("city");
                  String district = rs.getString("district");
                  String area = rs.getString("village_area");
                  
                  
                  Object[] rowData = {sl ,empId, name, phone, email, hireDate, designation, department, basicPay, country, city, district, area};
                  model.addRow(rowData);
                  
              }        
              jTableEmployee.setModel(model);
              //jTableEmployee.removeColumn(jTableEmployee.getColumn(0));
              
        } catch (Exception e) {
            System.out.println(e);
        }
    }
   
    public void billingView(){
        model = new DefaultTableModel();
        model.addColumn("SL");
        model.addColumn("Date");
        model.addColumn("Product ID");
        model.addColumn("Buyer Name");
        model.addColumn("Location");
        model.addColumn("Amount");
        model.addColumn("Due");
        model.addColumn("Payment Method");
        model.addColumn("Remarks");
        
        String sql = "select * from billing";
        try {
              Connection con = DBConnection.getConnection();
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
             
              while(rs.next()){ 
                  String sl = rs.getString("id");
                  String date = rs.getString("date");
                  String productId = rs.getString("product_id");
                  String buyerName = rs.getString("buyer_name");
                  String location = rs.getString("location");
                  String amount = rs.getString("amount");
                  String due = rs.getString("due");
                  String paymentMethod = rs.getString("payment_method");
                  String remarks = rs.getString("remarks");
                  
                  
                  Object[] rowData = {sl ,date, productId, buyerName, location, amount, due, paymentMethod, remarks};
                  model.addRow(rowData);
              }        
              jTableBilling.setModel(model);
              
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void supplierView(){
        model = new DefaultTableModel();
        model.addColumn("SL");
        model.addColumn("Supplier ID");
        model.addColumn("Name");
        model.addColumn("Phone");
        model.addColumn("Email");
        model.addColumn("Address");
        
        String sql = "select * from supplier";
        try {
              Connection con = DBConnection.getConnection();
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
             
              while(rs.next()){ 
                  String sl = rs.getString("id");
                  String supplierId = rs.getString("supplier_id");
                  String name = rs.getString("name");
                  String company = rs.getString("company");
                  String phone = rs.getString("phone");
                  String email = rs.getString("email");
                  String address = rs.getString("address");
                  
                  
                  Object[] rowData = {sl ,supplierId, name, company, phone, email, address};
                  model.addRow(rowData);
              }        
              jTableSupplier.setModel(model);
              
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void deliveryView(){
        model = new DefaultTableModel();
        model.addColumn("SL");
        model.addColumn("Delivery No");
        model.addColumn("Delivery Date");
        model.addColumn("Buyer");
        model.addColumn("Product Id");
        model.addColumn("Item");
        model.addColumn("Quantity");
        model.addColumn("Delivery Cost");
        model.addColumn("Supplier ID");
        model.addColumn("Location");
        
        String sql = "select * from delivery";
        try {
              Connection con = DBConnection.getConnection();
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
             
              while(rs.next()){ 
                  String sl = rs.getString("id");
                  String deliveryNo = rs.getString("delivery_no");
                  String deliveryDate = rs.getString("delivery_date");
                  String buyer = rs.getString("buyer");
                  String productId = rs.getString("product_id");
                  String item = rs.getString("item");
                  String quantity = rs.getString("quantity");
                  String cost = rs.getString("delivery_cost");
                  String supplierId = rs.getString("supplier_id");
                  String location = rs.getString("location");
                  
                  String description = rs.getString("description");
                  
                  jLabelDelivery.setText(description);
                  
                  Object[] rowData = {sl ,deliveryNo, deliveryDate, buyer, productId, item, quantity, cost, supplierId, location};
                  model.addRow(rowData);
              }        
              jTableDelivery.setModel(model);
              
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void sellingView(){
        model = new DefaultTableModel();
        model.addColumn("SL");
        model.addColumn("Selling No");
        model.addColumn("Selling Date");
        model.addColumn("Buyer");
        model.addColumn("Product Id");
        model.addColumn("Item");
        model.addColumn("Quantity");
        model.addColumn("TotalPrice");
        
        String sql = "select * from selling";
        try {
              Connection con = DBConnection.getConnection();
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
             
              while(rs.next()){ 
                  String sl = rs.getString("id");
                  String ordeNo = rs.getString("selling_no");
                  String sellingDate = rs.getString("selling_date");
                  String buyer = rs.getString("buyer");
                  String productId = rs.getString("product_id");
                  String item = rs.getString("item");
                  String quantity = rs.getString("quantity");
                  String totalPrice = rs.getString("total_price");
                  
                  String description = rs.getString("description");
                  
                  jLabelSelling.setText(description);
                  
                  Object[] rowData = {sl ,ordeNo, sellingDate, buyer, productId, item, quantity, totalPrice};
                  model.addRow(rowData);
              }        
              jTableSelling.setModel(model);
              
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void rawMaterialInstockView(){
        model = new DefaultTableModel();
        model.addColumn("SL");
        model.addColumn("Material Id");
        model.addColumn("Item");
        model.addColumn("Category");
        
        String sql = "select * from raw_materials";
        try {
              Connection con = DBConnection.getConnection();
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
             
              while(rs.next()){ 
                  String sl = rs.getString("id");
                  String materialId = rs.getString("material_id");
                  String item = rs.getString("item");
                  String category = rs.getString("category");
                  String description = rs.getString("description");
                  
                  jLabelRawMaterial.setText(description);
                  
                  Object[] rowData = {sl , materialId, item, category, description};
                  model.addRow(rowData);
              }        
              jTableRawMaterialInstock.setModel(model);
              
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void rawMaterialPurchaseView(){
        model = new DefaultTableModel();
        model.addColumn("SL");
        model.addColumn("Date");
        model.addColumn("Order No");
        model.addColumn("Supplier");
        model.addColumn("Item");
        model.addColumn("Category");
        model.addColumn("Color");
        model.addColumn("Size");
        model.addColumn("quantity");
        model.addColumn("Unit Price");
        model.addColumn("Total Price");
        
        String sql = "select * from raw_material_purchase";
        try {
              Connection con = DBConnection.getConnection();
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
             
              while(rs.next()){ 
                  String sl = rs.getString("id");
                  String orderDate = rs.getString("purchase_date");
                  String ordeNo = rs.getString("order_no");
                  String supplier = rs.getString("supplier");
                  String item = rs.getString("item");
                  String category = rs.getString("category");
                  String color = rs.getString("color");
                  String size = rs.getString("size");
                  String quantity = rs.getString("quantity");
                  String unitPrice = rs.getString("unit_price");
                  String totalPrice = rs.getString("total_price");
                  String description = rs.getString("description");
                  
                  jLabelRawMaterialPurchase.setText(description);
                  
                  Object[] rowData = {sl , orderDate, ordeNo, supplier, item, category, color, size, quantity, unitPrice, totalPrice};
                  model.addRow(rowData);
              }        
              jTableRawMaterialPurchase.setModel(model);
              inventoryRawMaterial.setModel(model);
              
        } catch (Exception e) {
            System.out.println(e);
        }
}
    
    public void rawMaterialOrderView(){
        model = new DefaultTableModel();
        model.addColumn("SL");
        model.addColumn("Date");
        model.addColumn("Order No");
        model.addColumn("Supplier");
        model.addColumn("Item");
        model.addColumn("Category");
        model.addColumn("Color");
        model.addColumn("Size");
        model.addColumn("quantity");
        model.addColumn("Unit Price");
        model.addColumn("Total Price");
        
        String sql = "select * from raw_material_order";
        try {
              Connection con = DBConnection.getConnection();
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
             
              while(rs.next()){ 
                  String sl = rs.getString("id");
                  String orderDate = rs.getString("order_date");
                  String ordeNo = rs.getString("order_no");
                  String supplier = rs.getString("supplier");
                  String item = rs.getString("item");
                  String category = rs.getString("category");
                  String color = rs.getString("color");
                  String size = rs.getString("size");
                  String quantity = rs.getString("quantity");
                  String unitPrice = rs.getString("unit_price");
                  String totalPrice = rs.getString("total_price");
                  String description = rs.getString("description");
                  
                  jLabelMaterialDescription.setText(description);
                  
                  Object[] rowData = {sl , orderDate, ordeNo, supplier, item, category, color, size, quantity, unitPrice, totalPrice};
                  model.addRow(rowData);
              }        
              rawMaterialOrder.setModel(model);
              
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void productView(){
        model = new DefaultTableModel();
        model.addColumn("SL");
        model.addColumn("Product ID");
        model.addColumn("Item");
        model.addColumn("Category");
        model.addColumn("Description");
        
        
        String sql = "select * from products";
        try {
              Connection con = DBConnection.getConnection();
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
             
              while(rs.next()){ 
                  String sl = rs.getString("id");
                  String productId = rs.getString("product_id");
                  String item = rs.getString("item");
                  String category = rs.getString("category");
                  String description = rs.getString("description");
                  
                  
                  
                  
                  Object[] rowData = {sl , productId, item, category, description};
                  model.addRow(rowData);
              }        
              jTableProduct.setModel(model);
              
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public  void purchaseOrderView(){
        model = new DefaultTableModel();
        model.addColumn("SL");
        model.addColumn("Order No");
        model.addColumn("orderDate");
        model.addColumn("deliveryDate");
        model.addColumn("buyer");
        model.addColumn("productId");
        model.addColumn("item");
        model.addColumn("quantity");
        model.addColumn("totalPrice");
        
        String sql = "select * from purchase_order";
        try {
              Connection con = DBConnection.getConnection();
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
             
              while(rs.next()){ 
                  String sl = rs.getString("id");
                  String ordeNo = rs.getString("order_no");
                  String orderDate = rs.getString("order_date");
                  String deliveryDate = rs.getString("delivery_date");
                  String buyer = rs.getString("buyer");
                  String productId = rs.getString("product_id");
                  String item = rs.getString("item");
                  String quantity = rs.getString("quantity");
                  String totalPrice = rs.getString("total_price");
                  
                  String description = rs.getString("description");
                  
                  jLabelDescription.setText(description);
                  
                  Object[] rowData = {sl ,ordeNo, orderDate, deliveryDate, buyer, productId, item, quantity, totalPrice};
                  model.addRow(rowData);
              }        
              purchaseOrder.setModel(model);
              
        } catch (Exception e) {
            System.out.println(e);
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

        homeBtn = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        homeTab = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        dashboard = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        products = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableProduct = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        purchaseOrders = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        purchaseOrder = new javax.swing.JTable();
        jButton46 = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabelDescription = new javax.swing.JLabel();
        rawMaterial = new javax.swing.JPanel();
        JTabbedPane = new javax.swing.JTabbedPane();
        Order = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButtonOrder = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        rawMaterialOrder = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabelMaterialDescription = new javax.swing.JLabel();
        Purchase = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableRawMaterialPurchase = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabelRawMaterialPurchase = new javax.swing.JLabel();
        addMaterial = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jButton67 = new javax.swing.JButton();
        jButton68 = new javax.swing.JButton();
        jButton69 = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTableRawMaterialInstock = new javax.swing.JTable();
        jLabel52 = new javax.swing.JLabel();
        jLabelRawMaterial = new javax.swing.JLabel();
        production = new javax.swing.JPanel();
        jTextField8 = new javax.swing.JTextField();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTableProduction = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        _pId = new javax.swing.JTextField();
        _category = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        _stage = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        _description = new javax.swing.JTextArea();
        jButton18 = new javax.swing.JButton();
        selling = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton55 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTableSelling = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabelSelling = new javax.swing.JLabel();
        delivery = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jButton58 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTableDelivery = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabelDelivery = new javax.swing.JLabel();
        supplier = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jButton73 = new javax.swing.JButton();
        jButton74 = new javax.swing.JButton();
        jButton75 = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        jTableSupplier = new javax.swing.JTable();
        inventory = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        rawMaterials = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        inventoryRawMaterial = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        manufacturedProduct = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jButton64 = new javax.swing.JButton();
        jButton65 = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTableInstockProduct = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        accounts = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        bill = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableBilling = new javax.swing.JTable();
        jLabel65 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        bDate = new javax.swing.JTextField();
        bName = new javax.swing.JTextField();
        bAmount = new javax.swing.JTextField();
        pMethod = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        pId = new javax.swing.JTextField();
        bLocation = new javax.swing.JTextField();
        bDue = new javax.swing.JTextField();
        bRemarks = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        cost = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTableProductCost = new javax.swing.JTable();
        jLabel85 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        profit = new javax.swing.JPanel();
        employees = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        employeeList = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTableEmployee = new javax.swing.JTable();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        department = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jTableDepartment = new javax.swing.JTable();
        jButton70 = new javax.swing.JButton();
        jButton71 = new javax.swing.JButton();
        jButton72 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Garment Factory Management");

        homeBtn.setBackground(new java.awt.Color(0, 0, 51));

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Delivery");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(102, 102, 102));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton9.setText("Accounts");
        jButton9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(102, 102, 102));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton10.setText("Employees");
        jButton10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 102, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Raw Material");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Admin");

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Products");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(102, 102, 102));
        jButton12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton12.setText("Dashboard");
        jButton12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton11.setText("Log out");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/misoft/icons/admin.png"))); // NOI18N

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Purchase Order");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(102, 102, 102));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("Selling");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(102, 102, 102));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setText("Supplier");
        jButton7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(102, 102, 102));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton8.setText("Inventory");
        jButton8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(102, 102, 102));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setText("Production");
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout homeBtnLayout = new javax.swing.GroupLayout(homeBtn);
        homeBtn.setLayout(homeBtnLayout);
        homeBtnLayout.setHorizontalGroup(
            homeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(homeBtnLayout.createSequentialGroup()
                .addGroup(homeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homeBtnLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jButton11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(homeBtnLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(homeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(homeBtnLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addGap(8, 8, 8))
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(homeBtnLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(homeBtnLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(homeBtnLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(homeBtnLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        homeBtnLayout.setVerticalGroup(
            homeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeBtnLayout.createSequentialGroup()
                .addGroup(homeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homeBtnLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeBtnLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(homeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton11)
                .addContainerGap())
        );

        homeTab.setBackground(new java.awt.Color(51, 0, 102));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 204));
        jLabel4.setText("Garment Factory Management");

        javax.swing.GroupLayout homeTabLayout = new javax.swing.GroupLayout(homeTab);
        homeTab.setLayout(homeTabLayout);
        homeTabLayout.setHorizontalGroup(
            homeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeTabLayout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homeTabLayout.setVerticalGroup(
            homeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        mainPanel.setLayout(new java.awt.CardLayout());

        dashboard.setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Product Orders");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel13.setText("120");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel13)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel10)
                .addContainerGap(48, Short.MAX_VALUE))
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 0, 153));

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setText("InStock Products");

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel83.setText("150");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel83)
                .addGap(87, 87, 87))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel83)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel80)
                .addContainerGap(44, Short.MAX_VALUE))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel80)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 0, 153));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Material Orders");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel14.setText("240");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel11)
                .addContainerGap(46, Short.MAX_VALUE))
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(153, 0, 153));

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setText("Production Running");

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel84.setText("100");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel84)
                .addGap(87, 87, 87))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel84)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel82)
                .addGap(19, 19, 19))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel82)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(153, 0, 153));

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("InStock Materials");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel15.setText("130");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(75, 75, 75))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel76)
                .addContainerGap(23, Short.MAX_VALUE))
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel76)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(153, 0, 153));

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setText("Total Employees");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel12.setText("250");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(70, 70, 70))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel81)
                .addGap(19, 19, 19))
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel81)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("Dashboard");

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(374, 374, 374))
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboardLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel9)
                .addGap(79, 79, 79)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        mainPanel.add(dashboard, "card2");

        products.setBackground(new java.awt.Color(153, 153, 153));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Search");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setText("Product List");

        jTableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(jTableProduct);

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton14.setText("Add");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton41.setText("Edit");

        jButton45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton45.setText("Delete");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout productsLayout = new javax.swing.GroupLayout(products);
        products.setLayout(productsLayout);
        productsLayout.setHorizontalGroup(
            productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(productsLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(productsLayout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jButton14)
                .addGap(89, 89, 89)
                .addComponent(jButton41)
                .addGap(83, 83, 83)
                .addComponent(jButton45)
                .addContainerGap(246, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(281, 281, 281))
        );
        productsLayout.setVerticalGroup(
            productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productsLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(23, 23, 23)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14)
                    .addComponent(jButton41)
                    .addComponent(jButton45))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        mainPanel.add(products, "card3");

        purchaseOrders.setBackground(new java.awt.Color(153, 153, 153));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("Search");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel29.setText("Purchase Order List");

        purchaseOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(purchaseOrder);

        jButton46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton46.setText("Add");
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("Category");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Description");

        jLabelDescription.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDescription.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout purchaseOrdersLayout = new javax.swing.GroupLayout(purchaseOrders);
        purchaseOrders.setLayout(purchaseOrdersLayout);
        purchaseOrdersLayout.setHorizontalGroup(
            purchaseOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(purchaseOrdersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(purchaseOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(purchaseOrdersLayout.createSequentialGroup()
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jButton46)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(95, 95, 95))
                    .addGroup(purchaseOrdersLayout.createSequentialGroup()
                        .addGroup(purchaseOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addGroup(purchaseOrdersLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel28)
                                .addGap(189, 189, 189)
                                .addComponent(jLabel30))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabelDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        purchaseOrdersLayout.setVerticalGroup(
            purchaseOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(purchaseOrdersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(purchaseOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(purchaseOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton46)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(purchaseOrders, "card4");

        rawMaterial.setBackground(new java.awt.Color(153, 153, 153));

        JTabbedPane.setBackground(new java.awt.Color(153, 153, 153));
        JTabbedPane.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        Order.setBackground(new java.awt.Color(153, 153, 153));
        Order.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("Search");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("Item");

        jButton49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton49.setText("Add");
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });

        jButton50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton50.setText("Edit");

        jButtonOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonOrder.setText("Delete");
        jButtonOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrderActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setText("Order List");

        rawMaterialOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(rawMaterialOrder);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Description");

        javax.swing.GroupLayout OrderLayout = new javax.swing.GroupLayout(Order);
        Order.setLayout(OrderLayout);
        OrderLayout.setHorizontalGroup(
            OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelMaterialDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, OrderLayout.createSequentialGroup()
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jButton49)
                        .addGap(18, 18, 18)
                        .addComponent(jButton50)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonOrder)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, OrderLayout.createSequentialGroup()
                        .addGroup(OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel7)
                            .addGroup(OrderLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel31)
                                .addGap(197, 197, 197)
                                .addComponent(jLabel32)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        OrderLayout.setVerticalGroup(
            OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton49)
                    .addComponent(jButton50)
                    .addComponent(jButtonOrder)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMaterialDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        JTabbedPane.addTab("Order", Order);

        Purchase.setBackground(new java.awt.Color(153, 153, 153));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("Search");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("Item");

        jButton52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton52.setText("Add");
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });

        jButton53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton53.setText("Edit");

        jButton54.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton54.setText("Delete");
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel36.setText("Purchase Material List");

        jTableRawMaterialPurchase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(jTableRawMaterialPurchase);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Description");

        javax.swing.GroupLayout PurchaseLayout = new javax.swing.GroupLayout(Purchase);
        Purchase.setLayout(PurchaseLayout);
        PurchaseLayout.setHorizontalGroup(
            PurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PurchaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelRawMaterialPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PurchaseLayout.createSequentialGroup()
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jButton52)
                        .addGap(18, 18, 18)
                        .addComponent(jButton53)
                        .addGap(18, 18, 18)
                        .addComponent(jButton54)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PurchaseLayout.createSequentialGroup()
                        .addGroup(PurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel8)
                            .addGroup(PurchaseLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel34)
                                .addGap(198, 198, 198)
                                .addComponent(jLabel35)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PurchaseLayout.setVerticalGroup(
            PurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PurchaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton52)
                    .addComponent(jButton53)
                    .addComponent(jButton54)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelRawMaterialPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addContainerGap())
        );

        JTabbedPane.addTab("Purchase", Purchase);

        addMaterial.setBackground(new java.awt.Color(153, 153, 153));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setText("Search");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setText("Item");

        jButton67.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton67.setText("Add");
        jButton67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton67ActionPerformed(evt);
            }
        });

        jButton68.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton68.setText("Edit");

        jButton69.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton69.setText("Delete");
        jButton69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton69ActionPerformed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel51.setText("Raw Material List");

        jTableRawMaterialInstock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane10.setViewportView(jTableRawMaterialInstock);

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel52.setText("Description");

        jLabelRawMaterial.setText("jLabel67");

        javax.swing.GroupLayout addMaterialLayout = new javax.swing.GroupLayout(addMaterial);
        addMaterial.setLayout(addMaterialLayout);
        addMaterialLayout.setHorizontalGroup(
            addMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addMaterialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelRawMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addMaterialLayout.createSequentialGroup()
                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jButton67)
                        .addGap(18, 18, 18)
                        .addComponent(jButton68)
                        .addGap(18, 18, 18)
                        .addComponent(jButton69)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addMaterialLayout.createSequentialGroup()
                        .addGroup(addMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52)
                            .addGroup(addMaterialLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel49)
                                .addGap(197, 197, 197)
                                .addComponent(jLabel50)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        addMaterialLayout.setVerticalGroup(
            addMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addMaterialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton67)
                    .addComponent(jButton68)
                    .addComponent(jButton69)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel52)
                .addGap(18, 18, 18)
                .addComponent(jLabelRawMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addContainerGap())
        );

        JTabbedPane.addTab("In Stock Materials", addMaterial);

        javax.swing.GroupLayout rawMaterialLayout = new javax.swing.GroupLayout(rawMaterial);
        rawMaterial.setLayout(rawMaterialLayout);
        rawMaterialLayout.setHorizontalGroup(
            rawMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTabbedPane)
        );
        rawMaterialLayout.setVerticalGroup(
            rawMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTabbedPane)
        );

        mainPanel.add(rawMaterial, "card5");

        production.setBackground(new java.awt.Color(153, 153, 153));
        production.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField8.setText("Search");
        production.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 275, 135, -1));

        jButton35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton35.setText("Save");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        production.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 230, -1, -1));

        jButton36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton36.setText("Edit");
        production.add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 551, -1, -1));

        jButton37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton37.setText("Delete");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        production.add(jButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 551, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setText("Production Stage");
        production.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 271, -1, -1));

        jTableProduction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane11.setViewportView(jTableProduction);

        production.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 313, 790, 220));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setText("Production Details");
        production.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 25, -1, -1));

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel67.setText("Product ID");
        production.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 94, -1, -1));
        production.add(_pId, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 94, 166, -1));
        production.add(_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 94, 166, -1));

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel68.setText("Category");
        production.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 94, -1, -1));

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel69.setText("Description");
        production.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 151, -1, -1));

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel70.setText("Stage");
        production.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 151, -1, -1));
        production.add(_stage, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 151, 166, -1));

        _description.setColumns(20);
        _description.setRows(5);
        jScrollPane1.setViewportView(_description);

        production.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 151, -1, 48));

        jButton18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton18.setText("Update");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        production.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 230, -1, -1));

        mainPanel.add(production, "card8");

        selling.setBackground(new java.awt.Color(153, 153, 153));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setText("Search");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setText("Category");

        jButton55.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton55.setText("Add");
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });

        jButton56.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton56.setText("Edit");

        jButton57.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton57.setText("Delete");
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setText("Selling Product List");

        jTableSelling.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane15.setViewportView(jTableSelling);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Description");

        javax.swing.GroupLayout sellingLayout = new javax.swing.GroupLayout(selling);
        selling.setLayout(sellingLayout);
        sellingLayout.setHorizontalGroup(
            sellingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sellingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sellingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSelling, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sellingLayout.createSequentialGroup()
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jButton55)
                        .addGap(18, 18, 18)
                        .addComponent(jButton56)
                        .addGap(18, 18, 18)
                        .addComponent(jButton57)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sellingLayout.createSequentialGroup()
                        .addGroup(sellingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addGroup(sellingLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel37)
                                .addGap(189, 189, 189)
                                .addComponent(jLabel38))
                            .addComponent(jLabel16))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        sellingLayout.setVerticalGroup(
            sellingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sellingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sellingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sellingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton55)
                    .addComponent(jButton56)
                    .addComponent(jButton57)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jLabelSelling, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(selling, "card7");

        delivery.setBackground(new java.awt.Color(153, 153, 153));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setText("Search");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setText("Category");

        jButton58.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton58.setText("Add");
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });

        jButton59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton59.setText("Edit");

        jButton60.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton60.setText("Delete");
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel42.setText("Deliverd Product List");

        jTableDelivery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane17.setViewportView(jTableDelivery);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Description");

        javax.swing.GroupLayout deliveryLayout = new javax.swing.GroupLayout(delivery);
        delivery.setLayout(deliveryLayout);
        deliveryLayout.setHorizontalGroup(
            deliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deliveryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(deliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelDelivery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, deliveryLayout.createSequentialGroup()
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jButton58)
                        .addGap(18, 18, 18)
                        .addComponent(jButton59)
                        .addGap(18, 18, 18)
                        .addComponent(jButton60)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, deliveryLayout.createSequentialGroup()
                        .addGroup(deliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addGroup(deliveryLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel40)
                                .addGap(189, 189, 189)
                                .addComponent(jLabel41))
                            .addComponent(jLabel17))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        deliveryLayout.setVerticalGroup(
            deliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deliveryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(deliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(deliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton58)
                    .addComponent(jButton59)
                    .addComponent(jButton60)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDelivery, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(delivery, "card6");

        supplier.setBackground(new java.awt.Color(153, 153, 153));

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel56.setText("Search");

        jButton73.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton73.setText("Add");
        jButton73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton73ActionPerformed(evt);
            }
        });

        jButton74.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton74.setText("Edit");

        jButton75.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton75.setText("Delete");
        jButton75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton75ActionPerformed(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel58.setText("Supplier List");

        jTableSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane23.setViewportView(jTableSupplier);

        javax.swing.GroupLayout supplierLayout = new javax.swing.GroupLayout(supplier);
        supplier.setLayout(supplierLayout);
        supplierLayout.setHorizontalGroup(
            supplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(supplierLayout.createSequentialGroup()
                .addGroup(supplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplierLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane23))
                    .addGroup(supplierLayout.createSequentialGroup()
                        .addGroup(supplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(supplierLayout.createSequentialGroup()
                                .addGap(301, 301, 301)
                                .addGroup(supplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, supplierLayout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(jLabel56))))
                            .addGroup(supplierLayout.createSequentialGroup()
                                .addGap(266, 266, 266)
                                .addComponent(jButton73)
                                .addGap(18, 18, 18)
                                .addComponent(jButton74)
                                .addGap(18, 18, 18)
                                .addComponent(jButton75))
                            .addGroup(supplierLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel58)))
                        .addGap(0, 298, Short.MAX_VALUE)))
                .addContainerGap())
        );
        supplierLayout.setVerticalGroup(
            supplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(supplierLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel58)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(supplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton73)
                    .addComponent(jButton74)
                    .addComponent(jButton75))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        mainPanel.add(supplier, "card9");

        inventory.setBackground(new java.awt.Color(153, 153, 153));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        rawMaterials.setBackground(new java.awt.Color(153, 153, 153));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setText("Search");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setText("Category");

        jButton61.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton61.setText("Add");
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });

        jButton62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton62.setText("Edit");

        jButton63.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton63.setText("Delete");
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton63ActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel45.setText("Purchase Material List");

        inventoryRawMaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane9.setViewportView(inventoryRawMaterial);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("Description");

        jTextArea6.setColumns(20);
        jTextArea6.setRows(5);
        jScrollPane19.setViewportView(jTextArea6);

        javax.swing.GroupLayout rawMaterialsLayout = new javax.swing.GroupLayout(rawMaterials);
        rawMaterials.setLayout(rawMaterialsLayout);
        rawMaterialsLayout.setHorizontalGroup(
            rawMaterialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rawMaterialsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rawMaterialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane19)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rawMaterialsLayout.createSequentialGroup()
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jButton61)
                        .addGap(18, 18, 18)
                        .addComponent(jButton62)
                        .addGap(18, 18, 18)
                        .addComponent(jButton63)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rawMaterialsLayout.createSequentialGroup()
                        .addGroup(rawMaterialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45)
                            .addGroup(rawMaterialsLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel43)
                                .addGap(189, 189, 189)
                                .addComponent(jLabel44))
                            .addComponent(jLabel18))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        rawMaterialsLayout.setVerticalGroup(
            rawMaterialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rawMaterialsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rawMaterialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rawMaterialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton61)
                    .addComponent(jButton62)
                    .addComponent(jButton63)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Raw Materials", rawMaterials);

        manufacturedProduct.setBackground(new java.awt.Color(153, 153, 153));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setText("Search");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setText("Category");

        jButton64.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton64.setText("Add");
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton64ActionPerformed(evt);
            }
        });

        jButton65.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton65.setText("Edit");

        jButton66.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton66.setText("Delete");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel48.setText("In Stock Product List");

        jTableInstockProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane20.setViewportView(jTableInstockProduct);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Description");

        jTextArea7.setColumns(20);
        jTextArea7.setRows(5);
        jScrollPane21.setViewportView(jTextArea7);

        javax.swing.GroupLayout manufacturedProductLayout = new javax.swing.GroupLayout(manufacturedProduct);
        manufacturedProduct.setLayout(manufacturedProductLayout);
        manufacturedProductLayout.setHorizontalGroup(
            manufacturedProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manufacturedProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manufacturedProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane21)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, manufacturedProductLayout.createSequentialGroup()
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jButton64)
                        .addGap(18, 18, 18)
                        .addComponent(jButton65)
                        .addGap(18, 18, 18)
                        .addComponent(jButton66)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, manufacturedProductLayout.createSequentialGroup()
                        .addGroup(manufacturedProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addGroup(manufacturedProductLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel46)
                                .addGap(189, 189, 189)
                                .addComponent(jLabel47))
                            .addComponent(jLabel19))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        manufacturedProductLayout.setVerticalGroup(
            manufacturedProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manufacturedProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manufacturedProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(manufacturedProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton64)
                    .addComponent(jButton65)
                    .addComponent(jButton66)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("In Stock Product", manufacturedProduct);

        javax.swing.GroupLayout inventoryLayout = new javax.swing.GroupLayout(inventory);
        inventory.setLayout(inventoryLayout);
        inventoryLayout.setHorizontalGroup(
            inventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        inventoryLayout.setVerticalGroup(
            inventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        mainPanel.add(inventory, "card10");

        accounts.setBackground(new java.awt.Color(153, 153, 153));

        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        bill.setBackground(new java.awt.Color(153, 153, 153));

        jTableBilling.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableBilling.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBillingMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableBilling);

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel65.setText("Billing Information");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Date");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Product ID");

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel57.setText("Amount");

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel59.setText("Buyer Name");

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel60.setText("Location");

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel61.setText("Remarks");

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel62.setText("Due");

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel63.setText("Payment Method");

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton13.setText("Pay");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel64.setText("Billing List");

        jLabel66.setText("Search");

        jButton15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton15.setText("Update");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Edit");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("Delete");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout billLayout = new javax.swing.GroupLayout(bill);
        bill.setLayout(billLayout);
        billLayout.setHorizontalGroup(
            billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billLayout.createSequentialGroup()
                .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(billLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, billLayout.createSequentialGroup()
                                .addComponent(jLabel64)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(billLayout.createSequentialGroup()
                                .addGap(0, 16, Short.MAX_VALUE)
                                .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(billLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(42, 42, 42)
                                        .addComponent(bDate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(billLayout.createSequentialGroup()
                                        .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel63)
                                            .addComponent(jLabel57)
                                            .addComponent(jLabel59))
                                        .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(billLayout.createSequentialGroup()
                                                    .addGap(42, 42, 42)
                                                    .addComponent(bName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billLayout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(bAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billLayout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addComponent(pMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jButton13))))
                        .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(billLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton15)
                                    .addGroup(billLayout.createSequentialGroup()
                                        .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel60)
                                            .addComponent(jLabel61)
                                            .addComponent(jLabel62))
                                        .addGap(34, 34, 34)
                                        .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(bLocation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                            .addComponent(bDue, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bRemarks)))))
                            .addGroup(billLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel66))
                            .addGroup(billLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel6)
                                .addGap(34, 34, 34)
                                .addComponent(pId, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 96, Short.MAX_VALUE))
                    .addGroup(billLayout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jLabel65)
                        .addGap(64, 64, 64)))
                .addContainerGap())
            .addGroup(billLayout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(jButton16)
                .addGap(90, 90, 90)
                .addComponent(jButton17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        billLayout.setVerticalGroup(
            billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel65)
                .addGap(33, 33, 33)
                .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(billLayout.createSequentialGroup()
                        .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(bDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(pId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel59)
                                .addComponent(bName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel60)
                                .addComponent(bLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50))
                    .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel62)
                        .addComponent(bDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel57)))
                .addGap(28, 28, 28)
                .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel63))
                    .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel61)
                        .addComponent(bRemarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13)
                    .addComponent(jButton15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel66))
                    .addGroup(billLayout.createSequentialGroup()
                        .addComponent(jLabel64)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton16)
                    .addComponent(jButton17))
                .addGap(21, 21, 21))
        );

        jTabbedPane3.addTab("Bill", bill);

        cost.setBackground(new java.awt.Color(153, 153, 153));

        jTableProductCost.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane12.setViewportView(jTableProductCost);

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel85.setText("Search");

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel86.setText("Purchase Material List");

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel87.setText("Total cost of Product");

        javax.swing.GroupLayout costLayout = new javax.swing.GroupLayout(cost);
        cost.setLayout(costLayout);
        costLayout.setHorizontalGroup(
            costLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(costLayout.createSequentialGroup()
                .addGroup(costLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(costLayout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jLabel87))
                    .addGroup(costLayout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addGroup(costLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, costLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel85)))))
                .addContainerGap(356, Short.MAX_VALUE))
            .addGroup(costLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(costLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(costLayout.createSequentialGroup()
                        .addComponent(jScrollPane12)
                        .addContainerGap())
                    .addGroup(costLayout.createSequentialGroup()
                        .addComponent(jLabel86)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        costLayout.setVerticalGroup(
            costLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(costLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel87)
                .addGap(41, 41, 41)
                .addComponent(jLabel85)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel86)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Cost", cost);

        profit.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout profitLayout = new javax.swing.GroupLayout(profit);
        profit.setLayout(profitLayout);
        profitLayout.setHorizontalGroup(
            profitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        profitLayout.setVerticalGroup(
            profitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Profit", profit);

        javax.swing.GroupLayout accountsLayout = new javax.swing.GroupLayout(accounts);
        accounts.setLayout(accountsLayout);
        accountsLayout.setHorizontalGroup(
            accountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        accountsLayout.setVerticalGroup(
            accountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        mainPanel.add(accounts, "card11");

        employees.setBackground(new java.awt.Color(153, 153, 153));

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        employeeList.setBackground(new java.awt.Color(153, 153, 153));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Search");

        jTextField10.setText("Search");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Department");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setText("Employee list");

        jTableEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane13.setViewportView(jTableEmployee);

        jButton42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton42.setText("Add");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jButton43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton43.setText("Edit");

        jButton44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton44.setText("Delete");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout employeeListLayout = new javax.swing.GroupLayout(employeeList);
        employeeList.setLayout(employeeListLayout);
        employeeListLayout.setHorizontalGroup(
            employeeListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeListLayout.createSequentialGroup()
                .addGroup(employeeListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeeListLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane13))
                    .addGroup(employeeListLayout.createSequentialGroup()
                        .addGroup(employeeListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(employeeListLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel25))
                            .addGroup(employeeListLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(employeeListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(98, 98, 98)
                                .addGroup(employeeListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(employeeListLayout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel24))))
                            .addGroup(employeeListLayout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addComponent(jButton42)
                                .addGap(100, 100, 100)
                                .addComponent(jButton43)
                                .addGap(92, 92, 92)
                                .addComponent(jButton44)))
                        .addGap(0, 219, Short.MAX_VALUE)))
                .addContainerGap())
        );
        employeeListLayout.setVerticalGroup(
            employeeListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(employeeListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeeListLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(employeeListLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(employeeListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton42)
                    .addComponent(jButton44)
                    .addComponent(jButton43))
                .addGap(61, 61, 61))
        );

        jTabbedPane2.addTab("Emoloyee List", employeeList);

        department.setBackground(new java.awt.Color(153, 153, 153));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel53.setText("Search");

        jTextField23.setText("Search");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel54.setText("Department");

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel55.setText("Department List");

        jTableDepartment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane22.setViewportView(jTableDepartment);

        jButton70.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton70.setText("Add");
        jButton70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton70ActionPerformed(evt);
            }
        });

        jButton71.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton71.setText("Edit");

        jButton72.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton72.setText("Delete");
        jButton72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton72ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout departmentLayout = new javax.swing.GroupLayout(department);
        department.setLayout(departmentLayout);
        departmentLayout.setHorizontalGroup(
            departmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(departmentLayout.createSequentialGroup()
                .addGroup(departmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(departmentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane22))
                    .addGroup(departmentLayout.createSequentialGroup()
                        .addGroup(departmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(departmentLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel55))
                            .addGroup(departmentLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(departmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel53)
                                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(98, 98, 98)
                                .addGroup(departmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(departmentLayout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel54))))
                            .addGroup(departmentLayout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addComponent(jButton70)
                                .addGap(100, 100, 100)
                                .addComponent(jButton71)
                                .addGap(92, 92, 92)
                                .addComponent(jButton72)))
                        .addGap(0, 219, Short.MAX_VALUE)))
                .addContainerGap())
        );
        departmentLayout.setVerticalGroup(
            departmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(departmentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(departmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(departmentLayout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(departmentLayout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(departmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton70)
                    .addComponent(jButton72)
                    .addComponent(jButton71))
                .addGap(61, 61, 61))
        );

        jTabbedPane2.addTab("Department", department);

        javax.swing.GroupLayout employeesLayout = new javax.swing.GroupLayout(employees);
        employees.setLayout(employeesLayout);
        employeesLayout.setHorizontalGroup(
            employeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        employeesLayout.setVerticalGroup(
            employeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        mainPanel.add(employees, "card12");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(homeTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        products.setVisible(true);
        dashboard.setVisible(false);
        purchaseOrders.setVisible(false);
        rawMaterial.setVisible(false);
        delivery.setVisible(false);
        selling.setVisible(false);
        production.setVisible(false);
        supplier.setVisible(false);
        inventory.setVisible(false);
        accounts.setVisible(false);
        employees.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        dashboard.setVisible(true);
        products.setVisible(false);
        purchaseOrders.setVisible(false);
        rawMaterial.setVisible(false);
        delivery.setVisible(false);
        selling.setVisible(false);
        production.setVisible(false);
        supplier.setVisible(false);
        inventory.setVisible(false);
        accounts.setVisible(false);
        employees.setVisible(false);
        
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        purchaseOrders.setVisible(true);
        dashboard.setVisible(false);
        products.setVisible(false);
        
        rawMaterial.setVisible(false);
        delivery.setVisible(false);
        selling.setVisible(false);
        production.setVisible(false);
        supplier.setVisible(false);
        inventory.setVisible(false);
        accounts.setVisible(false);
        employees.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        rawMaterial.setVisible(true);
        dashboard.setVisible(false);
        products.setVisible(false);
        purchaseOrders.setVisible(false);
        
        delivery.setVisible(false);
        selling.setVisible(false);
        production.setVisible(false);
        supplier.setVisible(false);
        inventory.setVisible(false);
        accounts.setVisible(false);
        employees.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        delivery.setVisible(true);
        dashboard.setVisible(false);
        products.setVisible(false);
        purchaseOrders.setVisible(false);
        rawMaterial.setVisible(false);
        
        selling.setVisible(false);
        production.setVisible(false);
        supplier.setVisible(false);
        inventory.setVisible(false);
        accounts.setVisible(false);
        employees.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        selling.setVisible(true);
        dashboard.setVisible(false);
        products.setVisible(false);
        purchaseOrders.setVisible(false);
        rawMaterial.setVisible(false);
        delivery.setVisible(false);
        
        production.setVisible(false);
        supplier.setVisible(false);
        inventory.setVisible(false);
        accounts.setVisible(false);
        employees.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        production.setVisible(true);
        dashboard.setVisible(false);
        products.setVisible(false);
        purchaseOrders.setVisible(false);
        rawMaterial.setVisible(false);
        delivery.setVisible(false);
        selling.setVisible(false);
        
        supplier.setVisible(false);
        inventory.setVisible(false);
        accounts.setVisible(false);
        employees.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        supplier.setVisible(true);
        dashboard.setVisible(false);
        products.setVisible(false);
        purchaseOrders.setVisible(false);
        rawMaterial.setVisible(false);
        delivery.setVisible(false);
        selling.setVisible(false);
        production.setVisible(false);
        
        inventory.setVisible(false);
        accounts.setVisible(false);
        employees.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        inventory.setVisible(true);
        dashboard.setVisible(false);
        products.setVisible(false);
        purchaseOrders.setVisible(false);
        rawMaterial.setVisible(false);
        delivery.setVisible(false);
        selling.setVisible(false);
        production.setVisible(false);
        supplier.setVisible(false);
        
        accounts.setVisible(false);
        employees.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        accounts.setVisible(true);
        dashboard.setVisible(false);
        products.setVisible(false);
        purchaseOrders.setVisible(false);
        rawMaterial.setVisible(false);
        delivery.setVisible(false);
        selling.setVisible(false);
        production.setVisible(false);
        supplier.setVisible(false);
        inventory.setVisible(false);
        
        employees.setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        employees.setVisible(true);
        dashboard.setVisible(false);
        products.setVisible(false);
        purchaseOrders.setVisible(false);
        rawMaterial.setVisible(false);
        delivery.setVisible(false);
        selling.setVisible(false);
        production.setVisible(false);
        supplier.setVisible(false);
        inventory.setVisible(false);
        accounts.setVisible(false);
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        ProductForm pf = new ProductForm();
        pf.setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        // TODO add your handling code here:
        PurchaseOrderForm pof = new PurchaseOrderForm();
        pof.setVisible(true);
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        // TODO add your handling code here:
        RawMaterialOrder rmo = new RawMaterialOrder();
        rmo.setVisible(true);
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        // TODO add your handling code here:
        RawMaterialPurchase rmp = new RawMaterialPurchase();
        rmp.setVisible(true);
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton67ActionPerformed
        // TODO add your handling code here:
        InStockMaterials ism = new InStockMaterials();
        ism.setVisible(true);
    }//GEN-LAST:event_jButton67ActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        // TODO add your handling code here:
        SellingForm sf = new SellingForm();
        sf.setVisible(true);
    }//GEN-LAST:event_jButton55ActionPerformed

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        // TODO add your handling code here:
        DeliveryForm df = new DeliveryForm();
        df.setVisible(true);
    }//GEN-LAST:event_jButton58ActionPerformed

    private void jButton73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton73ActionPerformed
        // TODO add your handling code here:
        SupplierForm sf = new SupplierForm();
        sf.setVisible(true);
    }//GEN-LAST:event_jButton73ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
        EmployeeForm ef = new EmployeeForm();
        ef.setVisible(true);
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton70ActionPerformed
        // TODO add your handling code here:
        DepartmentForm df = new DepartmentForm();
        df.setVisible(true);
    }//GEN-LAST:event_jButton70ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int delete = purchaseOrder.getSelectedRow();
        String cell = purchaseOrder.getModel().getValueAt(delete, 0).toString();
        String sql = "delete from purchase_order where id = " + cell;
        try {
              Connection con = DBConnection.getConnection();
              PreparedStatement psmt = con.prepareStatement(sql);
              psmt.execute();
              JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } catch (Exception e) {
        }
        purchaseOrderView();
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        PurchaseOrderForm psf = new PurchaseOrderForm();
        psf.showData(purchaseOrder);
        psf.setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        // TODO add your handling code here:
        deleteProducts();
        productView();
    }//GEN-LAST:event_jButton45ActionPerformed
    
    public void deleteProducts(){
        int delete = jTableProduct.getSelectedRow();
        String cell = jTableProduct.getModel().getValueAt(delete, 0).toString();
        String sql = "delete from products where id = " + cell;
        try {
              Connection con = DBConnection.getConnection();
              PreparedStatement psmt = con.prepareStatement(sql);
              psmt.execute();
              JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } catch (Exception e) {
        }
    }
    private void jButtonOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrderActionPerformed
        // TODO add your handling code here:
        int delete = rawMaterialOrder.getSelectedRow();
        String cell = rawMaterialOrder.getModel().getValueAt(delete, 0).toString();
        String sql = "delete from raw_material_order where id = " + cell;
        try {
              Connection con = DBConnection.getConnection();
              PreparedStatement psmt = con.prepareStatement(sql);
              psmt.execute();
              JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } catch (Exception e) {
        }
        
        rawMaterialOrderView();
        
    }//GEN-LAST:event_jButtonOrderActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        String date = bDate.getText();
        String productId = pId.getText();
        String buyerName = bName.getText();
        String location = bLocation.getText();
        String amount = bAmount.getText();
        String due = bDue.getText();
        String payment = pMethod.getText();
        String remarks = bRemarks.getText();
        
        
        String sql = "insert into billing (date, product_id, buyer_name, location, amount, due, payment_method, remarks) values (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, date);
            psmt.setString(2, productId);
            psmt.setString(3, buyerName);
            psmt.setString(4, location);
            psmt.setString(5, amount);
            psmt.setString(6, due);
            psmt.setString(7, payment);
            psmt.setString(8, remarks);
            
            psmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Paid");
 
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        String date = bDate.getText();
        String productId = pId.getText();
        String buyerName = bName.getText();
        String location = bLocation.getText();
        String amount = bAmount.getText();
        String due = bDue.getText();
        String payment = pMethod.getText();
        String remarks = bRemarks.getText();
        
        
        String sql = "update billing set date=?, product_id=?, buyer_name=?, location=?, amount=?, due=?, payment_method=?, remarks=? where product_id=?";
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, date);
            psmt.setString(2, productId);
            psmt.setString(3, buyerName);
            psmt.setString(4, location);
            psmt.setString(5, amount);
            psmt.setString(6, due);
            psmt.setString(7, payment);
            psmt.setString(8, remarks);
            psmt.setString(9, productId);
            
            psmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Updated");
 
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        // TODO add your handling code here:
        int delete = jTableRawMaterialPurchase.getSelectedRow();
        String cell = jTableRawMaterialPurchase.getModel().getValueAt(delete, 0).toString();
        String sql = "delete from raw_material_purchase where id = " + cell;
        try {
              Connection con = DBConnection.getConnection();
              PreparedStatement psmt = con.prepareStatement(sql);
              psmt.execute();
              JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
        
        rawMaterialPurchaseView();
        
    }//GEN-LAST:event_jButton54ActionPerformed

    private void jButton69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton69ActionPerformed
        // TODO add your handling code here:
        int delete = jTableRawMaterialInstock.getSelectedRow();
        String cell = jTableRawMaterialInstock.getModel().getValueAt(delete, 0).toString();
        String sql = "delete from raw_materials where id = " + cell;
        try {
              Connection con = DBConnection.getConnection();
              PreparedStatement psmt = con.prepareStatement(sql);
              psmt.execute();
              JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
        rawMaterialInstockView();
        
    }//GEN-LAST:event_jButton69ActionPerformed

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
        // TODO add your handling code here:
        int delete = jTableSelling.getSelectedRow();
        String cell = jTableSelling.getModel().getValueAt(delete, 0).toString();
        String sql = "delete from selling where id = " + cell;
        try {
              Connection con = DBConnection.getConnection();
              PreparedStatement psmt = con.prepareStatement(sql);
              psmt.execute();
              JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
        sellingView();
        
    }//GEN-LAST:event_jButton57ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        // TODO add your handling code here:
        int delete = jTableDelivery.getSelectedRow();
        String cell = jTableDelivery.getModel().getValueAt(delete, 0).toString();
        String sql = "delete from delivery where id = " + cell;
        try {
              Connection con = DBConnection.getConnection();
              PreparedStatement psmt = con.prepareStatement(sql);
              psmt.execute();
              JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
        deliveryView();
        
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jButton75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton75ActionPerformed
        // TODO add your handling code here:
        int delete = jTableSupplier.getSelectedRow();
        String cell = jTableSupplier.getModel().getValueAt(delete, 0).toString();
        String sql = "delete from supplier where id = " + cell;
        try {
              Connection con = DBConnection.getConnection();
              PreparedStatement psmt = con.prepareStatement(sql);
              psmt.execute();
              JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
        supplierView();
        
    }//GEN-LAST:event_jButton75ActionPerformed

    private void jButton63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton63ActionPerformed
        // TODO add your handling code here:
        int delete = inventoryRawMaterial.getSelectedRow();
        String cell = inventoryRawMaterial.getModel().getValueAt(delete, 0).toString();
        String sql = "delete from raw_material_purchase where id = " + cell;
        try {
              Connection con = DBConnection.getConnection();
              PreparedStatement psmt = con.prepareStatement(sql);
              psmt.execute();
              JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
        
        rawMaterialPurchaseView();
        
    }//GEN-LAST:event_jButton63ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        int delete = jTableBilling.getSelectedRow();
        String cell = jTableBilling.getModel().getValueAt(delete, 0).toString();
        String sql = "delete from billing where id = " + cell;
        try {
              Connection con = DBConnection.getConnection();
              PreparedStatement psmt = con.prepareStatement(sql);
              psmt.execute();
              JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
        billingView();
        
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton72ActionPerformed
        // TODO add your handling code here:
        int delete = jTableDepartment.getSelectedRow();
        String cell = jTableDepartment.getModel().getValueAt(delete, 0).toString();
        String sql = "delete from department where id = " + cell;
        try {
              Connection con = DBConnection.getConnection();
              PreparedStatement psmt = con.prepareStatement(sql);
              psmt.execute();
              JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
        
        departmentView();
    }//GEN-LAST:event_jButton72ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        // TODO add your handling code here:
        int delete = jTableEmployee.getSelectedRow();
        String cell = jTableEmployee.getModel().getValueAt(delete, 0).toString();
        String sql = "delete from employee where id = " + cell;
        try {
              Connection con = DBConnection.getConnection();
              PreparedStatement psmt = con.prepareStatement(sql);
              psmt.execute();
              JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
        employeeView();
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        // TODO add your handling code here:
        String productId = _pId.getText();
        String category = _category.getText();
        String stage = _stage.getText();
        String description = _description.getText();
        
        
        String sql = "insert into production (product_id, category, stage, description) values (?, ?, ?, ?)";
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement psmt = con.prepareStatement(sql);
            
            psmt.setString(1, productId);
            psmt.setString(2, category);
            psmt.setString(3, stage);
            psmt.setString(4, description);
            psmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved Successfully");
 
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        String productId = _pId.getText();
        String category = _category.getText();
        String stage = _stage.getText();
        String description = _description.getText();
        
        
        String sql = "update production set product_id=?, category=?, stage=?, description=? where product_id=?";
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement psmt = con.prepareStatement(sql);
            
            psmt.setString(1, productId);
            psmt.setString(2, category);
            psmt.setString(3, stage);
            psmt.setString(4, description);
            psmt.setString(5, productId);
            
            psmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated Successfully");
 
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        // TODO add your handling code here:
        int delete = jTableProduction.getSelectedRow();
        String cell = jTableProduction.getModel().getValueAt(delete, 0).toString();
        String sql = "delete from production where id = " + cell;
        try {
              Connection con = DBConnection.getConnection();
              PreparedStatement psmt = con.prepareStatement(sql);
              psmt.execute();
              JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
        productionView();
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jTableBillingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBillingMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableBillingMouseClicked

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel)jTableBilling.getModel();
        
        String date = model.getValueAt(jTableBilling.getSelectedRow(), 1).toString();
        String productId = model.getValueAt(jTableBilling.getSelectedRow(), 2).toString();
        String buyerName = model.getValueAt(jTableBilling.getSelectedRow(), 3).toString();
        String location = model.getValueAt(jTableBilling.getSelectedRow(), 4).toString();
        String amount = model.getValueAt(jTableBilling.getSelectedRow(), 5).toString();
        String due = model.getValueAt(jTableBilling.getSelectedRow(), 6).toString();
        String paymentMethod = model.getValueAt(jTableBilling.getSelectedRow(), 7).toString();
        String remarks = model.getValueAt(jTableBilling.getSelectedRow(), 8).toString();
        
        bDate.setText(date);
        pId.setText(productId);
        bName.setText(buyerName);
        bLocation.setText(location);
        bAmount.setText(amount);
        bDue.setText(due);
        pMethod.setText(paymentMethod);
        bRemarks.setText(remarks);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        // TODO add your handling code here:
        RawMaterialPurchase rmp = new RawMaterialPurchase();
        rmp.setVisible(true);
    }//GEN-LAST:event_jButton61ActionPerformed

    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
        // TODO add your handling code here:
        InStockProductForm ipf = new InStockProductForm();
        ipf.setVisible(true);
    }//GEN-LAST:event_jButton64ActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTabbedPane;
    private javax.swing.JPanel Order;
    private javax.swing.JPanel Purchase;
    private javax.swing.JTextField _category;
    private javax.swing.JTextArea _description;
    private javax.swing.JTextField _pId;
    private javax.swing.JTextField _stage;
    private javax.swing.JPanel accounts;
    private javax.swing.JPanel addMaterial;
    private javax.swing.JTextField bAmount;
    private javax.swing.JTextField bDate;
    private javax.swing.JTextField bDue;
    private javax.swing.JTextField bLocation;
    private javax.swing.JTextField bName;
    private javax.swing.JTextField bRemarks;
    private javax.swing.JPanel bill;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JPanel cost;
    private javax.swing.JPanel dashboard;
    private javax.swing.JPanel delivery;
    private javax.swing.JPanel department;
    private javax.swing.JPanel employeeList;
    private javax.swing.JPanel employees;
    private javax.swing.JPanel homeBtn;
    private javax.swing.JPanel homeTab;
    private javax.swing.JPanel inventory;
    private javax.swing.JTable inventoryRawMaterial;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton72;
    private javax.swing.JButton jButton73;
    private javax.swing.JButton jButton74;
    private javax.swing.JButton jButton75;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonOrder;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDelivery;
    private javax.swing.JLabel jLabelDescription;
    private javax.swing.JLabel jLabelMaterialDescription;
    private javax.swing.JLabel jLabelRawMaterial;
    private javax.swing.JLabel jLabelRawMaterialPurchase;
    private javax.swing.JLabel jLabelSelling;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTableBilling;
    private javax.swing.JTable jTableDelivery;
    private javax.swing.JTable jTableDepartment;
    private javax.swing.JTable jTableEmployee;
    private javax.swing.JTable jTableInstockProduct;
    private javax.swing.JTable jTableProduct;
    private javax.swing.JTable jTableProductCost;
    private javax.swing.JTable jTableProduction;
    private javax.swing.JTable jTableRawMaterialInstock;
    private javax.swing.JTable jTableRawMaterialPurchase;
    private javax.swing.JTable jTableSelling;
    private javax.swing.JTable jTableSupplier;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel manufacturedProduct;
    private javax.swing.JTextField pId;
    private javax.swing.JTextField pMethod;
    private javax.swing.JPanel production;
    private javax.swing.JPanel products;
    private javax.swing.JPanel profit;
    private javax.swing.JTable purchaseOrder;
    private javax.swing.JPanel purchaseOrders;
    private javax.swing.JPanel rawMaterial;
    private javax.swing.JTable rawMaterialOrder;
    private javax.swing.JPanel rawMaterials;
    private javax.swing.JPanel selling;
    private javax.swing.JPanel supplier;
    // End of variables declaration//GEN-END:variables
}
