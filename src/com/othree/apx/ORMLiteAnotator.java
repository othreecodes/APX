/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.othree.apx;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldRef;
import com.sun.codemodel.JFieldVar;
import org.jsonschema2pojo.AbstractAnnotator;

/**
 *
 * @author root
 */
public class ORMLiteAnotator extends AbstractAnnotator{

    @Override
    public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {
        try {
            
            field.annotate(DatabaseField.class).param("columnName", propertyName)
                    .param("canBeNull", propertyNode.get("null").asBoolean())           
                    .param("unique", propertyNode.get("unique").asBoolean());
            
            field.annotate(SerializedName.class).param("value", propertyName);
            
        } catch (Exception e) {
        }
        
        
        
    }
    
    @Override
    public void propertyInclusion(JDefinedClass clazz, JsonNode schema) {
       clazz.annotate(DatabaseTable.class).param("tableName", schema.get("table").asText());
       
        
    }

    
    
}
