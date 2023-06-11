
package edu.ulatina.demodb;

import java.io.Serializable;

/*
    Nwitlyck
 */
public class UserTO implements Serializable{
    
    //atributes
    
    private int id;
    private String name;
    private String lastName;
    private int state;
    
    //contructors
    
    public UserTO() {
    }

    public UserTO(int id, String name, String lastName, int state) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.state = state;
    }
    
    //getters&Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    
}
