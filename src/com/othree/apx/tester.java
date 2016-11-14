/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.othree.apx;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JPrimitiveType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 *
 * @author root
 */
public class tester {

//    public static void main(String[] args) throws FileNotFoundException {
//        
//       File jsonFile = new File("/root/NetBeansProjects/apx/src/com/othree/apx/database.json");
//       
//       ObservableList<SQLParams> columns = FXCollections.observableArrayList();
//        JsonParser parse = new JsonParser();
//        JsonElement ele = parse.parse(new FileReader(jsonFile));
//
//        JsonObject dbfile = ele.getAsJsonObject();
//
////        JsonArray array = dbfile.getAsJsonArray("properties");
//        
//        JsonObject obj = dbfile.getAsJsonObject("properties");
//        ArrayList<String> list = new ArrayList<>();
//        obj.entrySet();
//        for(Map.Entry<String,JsonElement> entry : obj.entrySet()){
//        
//             SQLParams params = new SQLParams();
//            params.setName(entry.getKey());
//            params.setType(obj.get(entry.getKey()).getAsJsonObject().get("type").getAsString());
//            params.setIsNull(obj.get(entry.getKey()).getAsJsonObject().get("null").getAsBoolean());
//            params.setIsUnique(obj.get(entry.getKey()).getAsJsonObject().get("unique").getAsBoolean());
//            columns.add(params);
//        
//        }
//
////        for (int i = 0; i < array.size(); i++) {
////            JsonObject obj = array.get(i).getAsJsonObject();
////            SQLParams params = new SQLParams();
////            params.setName(obj.get("name").getAsString().replace(" ", "_"));
////            params.setType(obj.get("type").getAsString());
////            params.setIsNull(obj.get("null").getAsBoolean());
////            params.setIsUnique(obj.get("unique").getAsBoolean());
////            columns.add(params);
////        }
////        System.out.println("Creating table ---" + dbfile.getAsJsonPrimitive("table").getAsString());
////        
////        
//        
//    }
//    
//    
//    public static void main(String[] args) throws Exception {
//
//        JCodeModel codeModel = new JCodeModel();
//        GenerationConfig config = new DefaultGenerationConfig() {
//
//            @Override
//            public boolean isIncludeConstructors() {
//                return true;
//            }
//
//            @Override
//            public boolean isUseDoubleNumbers() {
//                return true;
//            }
//
//            @Override
//            public boolean isUsePrimitives() {
//                return true;
//            }
//
//            @Override
//            public boolean isIncludeToString() {
//                return false; //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public boolean isIncludeHashcodeAndEquals() {
//                return false; //To change body of generated methods, choose T   ools | Templates.
//            }
//
//            @Override
//            public boolean isIncludeAdditionalProperties() {
//                return false;
//            
//            }
//
//            @Override
//            public Class<? extends RuleFactory> getCustomRuleFactory() {
//                return APXCustomRuleFactory.class;
//            }
//
//            
//           
//            
//            
//            
//  
//            
//
//        };
//
//        File jsonFile = new File("/root/NetBeansProjects/apx/src/com/othree/apx/database.json");
//
////        String sou = "\n"
////                + "{\n"
////                + "    \"table\": \"users\",\n"
////                + "    \"properties\": {\n"
////                + "        \"username\": {\n"
////                + "            \"type\": \"string\",\n"
////                + "            \"null\": \"true\",\n"
////                + "            \"unique\": \"true\"\n"
////                + "        },\n"
////                + "        \"password\": {\n"
////                + "            \"type\": \"integer\",\n"
////                + "             \"null\": \"true\",\n"
////                + "            \"unique\": \"false\"\n"
////                + "        },\n"
////                + "        \"date\": {\n"
////                + "            \"type\":\"string\",\n"
////                + "             \"null\": \"true\",\n"
////                + "            \"unique\": \"false\"\n"
////                + "        }\n"
////                + "\n"
////                + "    }\n"
////                + "}\n"
////                + "";
////        APXCustomRuleFactory apxf = new APXCustomRuleFactory);
//        
//        SchemaMapper mapper = new SchemaMapper(new APXCustomRuleFactory(config, new ORMLiteAnotator(), new SchemaStore()), new SchemaGenerator());
//        
//        JType m= mapper.generate(codeModel, "User", "com.othree.apx", jsonFile.toURI().toURL());
//         
//        File f = new File("src");
//        f.mkdirs();
//        f.createNewFile();
//
//        codeModel.build(f);
//         System.out.println(m.fullName().replace('.', File.separatorChar)+".java");
//
//         
//    }
//    private static Dao<User, Integer> userDao;
    public static void main(String[] args) throws SQLException {
//        ConnectionSource connectionSource = null;
//        try {
//            String databaseUrl = "jdbc:sqlite:/root/NetBeansProjects/apx/store/demoproject/src/com/root/demoproject/database/db.sqlite";
//            connectionSource
//                    = new JdbcConnectionSource(databaseUrl);
//        } catch (SQLException ex) {
//            Logger.getLogger(tester.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        userDao = DaoManager.createDao(connectionSource, User.class);
//        User u = new User("Admin'",657, 12.34);
//        
         
           

           JCodeModel codeModel = new JCodeModel();
           codeModel._package("com.r.r");
        try {
            codeModel._class("USerP");
            codeModel._package("com.othree.apx");
        } catch (JClassAlreadyExistsException ex) {
            Logger.getLogger(tester.class.getName()).log(Level.SEVERE, null, ex);
        }
           JPrimitiveType clazz = JDefinedClass.parse(codeModel, "int");
 
        try {
            codeModel.build(new File("src"));
        } catch (IOException ex) {
            Logger.getLogger(tester.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void printe() {

    }

}
