/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.othree.apx;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import org.jsonschema2pojo.Schema;
import org.jsonschema2pojo.rules.Rule;

/**
 *
 * @author root
 */
public class APXCustomRule implements Rule<JDefinedClass, JDefinedClass> {

    APXCustomRuleFactory fx;

    APXCustomRule(APXCustomRuleFactory aThis) {
        this.fx = aThis;

    }

    @Override
    public JDefinedClass apply(String string, JsonNode jn, JDefinedClass t, Schema schema) {

         

        JFieldVar idField = t.field(JMod.PRIVATE, int.class, "id");
        JMethod getter = t.method(JMod.PUBLIC, idField.type(), "getId");
        getter.body()._return(idField);
         
        idField.javadoc().add("This is compulsory for both the database and to access models");

        
        JMethod setter = t.method(JMod.PUBLIC, void.class, "setId");
        setter.param(idField.type(), idField.name())
                .assign(idField);

        idField.annotate(DatabaseField.class)
                .param("generatedId", true)
                .param("columnName", idField.name());
        
        idField.annotate(SerializedName.class)
                .param("value", "id");

        return t;
    }
}
