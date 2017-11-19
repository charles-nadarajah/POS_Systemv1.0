/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author Deshan
 */
public class User {
    private String username;
    private String password;
    
    /**
     * Constructor: assigns User's username and password
     * @param username
     * @param password
     */
    public User(String username, String password){
        this.username=username;
        this.password=password;
    }
    
    /**
     * Returns User's username
     * @return username
     */
    public String getUserName(){
        return username;
    }
    
    /**
     * Returns User's Password
     * @return password
     */
    protected String getPassword(){
        return password;
    }
    
    /**
     * Sets User's username
     * @param username 
     */
    private void setUsername(String username){
        this.username=username;
    }
    
    /**
     * Sets User's password
     * @param password 
     */
    private void setPassword(String password){
        this.password=password;
    }
    
     //Implements Representation Invariant of class User
    public boolean repOk(){
        if(username==null) return false;
        if(password==null) return false;
        return true;
    }
}
