/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.othree.apx;
import com.othree.apx.apxTable;
/**
 *
 * @author root
 */
@apxTable(name = "users")
public class models {

     
    String name;
    
    public models() {
        
    }
    
    
    public String getDbName(){
        
    return this.getClass().getAnnotation(apxTable.class).name();   
    }
    
    
    
    
}
