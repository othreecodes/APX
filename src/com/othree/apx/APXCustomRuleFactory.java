/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.othree.apx;

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JType;
import java.time.LocalDate;
import org.jsonschema2pojo.Annotator;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Schema;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.rules.FormatRule;
import org.jsonschema2pojo.rules.PropertiesRule;
import org.jsonschema2pojo.rules.Rule;
import org.jsonschema2pojo.rules.RuleFactory;

/**
 *
 * @author root
 */
public class APXCustomRuleFactory extends RuleFactory{

    public APXCustomRuleFactory(GenerationConfig generationConfig, Annotator annotator, SchemaStore schemaStore) {
        super(generationConfig, annotator, schemaStore);
    } 

    @Override
    public Rule<JDefinedClass, JDefinedClass> getPropertiesRule() {
        return new PropertiesRule(this){

            @Override
            public JDefinedClass apply(String nodeName, JsonNode node, JDefinedClass jclass, Schema schema) {
                new APXCustomRule(APXCustomRuleFactory.this).apply(nodeName, node, jclass, schema);
                return super.apply(nodeName, node, jclass, schema);  
            }
        
        };
    }

    
    
    

    
    
     


    
    
}
