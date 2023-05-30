package edu.ulatina.test;

import edu.ulatina.demodb.UserTO;
import edu.ulatina.demodb.ServiceUser;
import java.util.*;

/*
 * @author Nwitlyck
 */
public class Tester {

    public static void main(String[] args) {

        ServiceUser felipe = new ServiceUser();
        
        List<UserTO> userTOList;
        
        try {
            userTOList = felipe.select();
            
        } catch (Exception e) {
            userTOList = new ArrayList<UserTO>();
            System.out.println("Notice there was a problem collecting the date from the db check log file to see more");
            //e.printStackTrace(); this should be change to a funcion which write a log file with the exeption
        }
        
        for(UserTO userTO: userTOList)
        {
            System.out.println("Id: " + userTO.getId() + " Name: " + userTO.getName());
        }

    }

}
