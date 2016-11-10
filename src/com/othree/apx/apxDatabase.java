/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.othree.apx;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author root
 */
@interface apxDatabase {
   
    
    
}
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.TYPE)
@interface apxTable{
    String name();
}

@Retention(RetentionPolicy.RUNTIME)  
@interface apxColumn{
    String name();
}