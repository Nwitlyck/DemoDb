
package edu.ulatina.demodb;

import java.io.Serializable;

/*
    Nwitlyck
 */
public class UserTO implements Serializable{
    
    //atributes
    
    private int id;
    private String name;
    
    //contructors
    
    public UserTO() {
    }

    public UserTO(int id, String name) {
        this.id = id;
        this.name = name;
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
    
}
