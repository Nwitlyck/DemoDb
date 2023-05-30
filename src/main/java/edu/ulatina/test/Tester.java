package edu.ulatina.test;

import com.mycompany.demodb.*;
import java.util.*;

/*
 * @author Nwitlyck
 */
public class Tester {

    public static void main(String[] args) {

        ServiceUser felipe = new ServiceUser();
        
        for(UserTO userTO: felipe.select())
        {
            System.out.println("Id: " + userTO.getId() + " Name: " + userTO.getName());
        }

    }

}
