package com.othree.apx;

 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class Main {

    /**
     * Main class that handles all the arguements from commandline
     *
     * @param args
     */
    public static void main(String[] args) {
        
        System.out.println(System.getProperty("os.name"));
        Operations operations = new Operations();

         

        //If the arguements are empty show sample usage
        if (args.length < 1) {
             System.out.println("\n\t\t\t\t\tSample Usage\n\n");
            
            System.out.println("\t\tapx start ${Projectname} - Creates a new Apx project\n");
            System.out.println("\t\tapx g page ${PageName} - Creates a new page\n\t\twith the .fxml, .css and Controller files");
            System.out.println("\t\tapx create model ${Location of JSON File} - Creates a model corresponding\n\t\tto the JSON. Also creates a matching table in database");
            
             
        } else if ("start".equalsIgnoreCase(args[0])) {
            String projectName = args[1];
            operations.startProject(projectName);
        } else if ("g".equalsIgnoreCase(args[0])) {
            File f = new File("project.apxprop");
            if (!f.exists()) {
                System.out.println("Not an APX Project!!!\n");
                
                System.exit(0);
            }
            
            try {
                if ("page".equalsIgnoreCase(args[1])) {
                    try {
                        operations.generatePage(args[2], f);
                    } catch (Exception e) {
                        System.out.println("Exception at ");
                        e.printStackTrace();
                    }
                    
                }
            } catch (Exception e) {
                System.out.println("Exception at ");
                e.printStackTrace();
                 
            }
            
        } else if ("create".equalsIgnoreCase(args[0])) {
            File f = new File("project.apxprop");
            if (!f.exists()) {
                System.out.println("Not an APX Project!!!\n");
                
                System.exit(0);
            }
            
            if ("model".equalsIgnoreCase(args[1])) {
                
                //File loction of the json file Containing the Json File to 
                String fileLocation = args[2];
                try {
                    operations.tableFromJson(fileLocation, f);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }
        
    }
    
}
