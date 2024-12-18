/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.sql;

/**
 *
 * @author HP
 */
public class Customer {
    private int CustomerId, EmployeeId, PurchaseQty, SpentMoney;
    private long PhoneNumber;
    private char Gender;
    private String Name, Address, Email, LastPurchase;

    public Customer() {
    }

    //constructor with all
    public Customer(int CustomerId, int EmployeeId, int PurchaseQty, int SpentMoney, long PhoneNumber, char Gender, String Name, String Address, String Email, String LastPurchase) {
        this.CustomerId = CustomerId;
        this.EmployeeId = EmployeeId;
        this.PurchaseQty = PurchaseQty;
        this.SpentMoney = SpentMoney;
        this.PhoneNumber = PhoneNumber;
        this.Gender = Gender;
        this.Name = Name;
        this.Address = Address;
        this.Email = Email;
        this.LastPurchase = LastPurchase;
    }

    //minimum constructor (must values only)
    public Customer(int EmployeeId, long PhoneNumber, String Name) {
        this.EmployeeId = EmployeeId;
        this.PhoneNumber = PhoneNumber;
        this.Name = Name;
    }

    public Customer(int EmployeeId, int PurchaseQty, int SpentMoney, long PhoneNumber, char Gender, String Name, String Address, String Email) {
        this.EmployeeId = EmployeeId;
        this.PurchaseQty = PurchaseQty;
        this.SpentMoney = SpentMoney;
        this.PhoneNumber = PhoneNumber;
        this.Gender = Gender;
        this.Name = Name;
        this.Address = Address;
        this.Email = Email;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public int getPurchaseQty() {
        return PurchaseQty;
    }

    public int getSpentMoney() {
        return SpentMoney;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public char getGender() {
        return Gender;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getEmail() {
        return Email;
    }

    public String getLastPurchase() {
        return LastPurchase;
    }

    public void setCustomerId(int CustomerId) {
        this.CustomerId = CustomerId;
    }

    public void setEmployeeId(int EmployeeId) {
        this.EmployeeId = EmployeeId;
    }

    public void setPurchaseQty(int PurchaseQty) {
        this.PurchaseQty = PurchaseQty;
    }

    public void setSpentMoney(int SpentMoney) {
        this.SpentMoney = SpentMoney;
    }

    public void setPhoneNumber(long PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setLastPurchase(String LastPurchase) {
        this.LastPurchase = LastPurchase;
    }
    
      
    
    
}


