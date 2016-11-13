package com.othree.apx;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryNotEmptyException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author root
 */
public class Operations {

    //All Project Directories
    String PROJECT_DIRS[] = {"models", "views", "controllers", "database", "http", "styles", "providers"};
    String PROJECT_NAME = "";
    String PACKAGE_NAME = "";
    String PROJECT_ROOT = "";
    String PROJECT_SRC = "";
    String PROJECT_WORK_DIR = "";

    /**
     *
     * @param projectName The name of the project to create
     *
     */
    public void startProject(String projectName) {
        PROJECT_NAME = projectName;
        File projectFolder = new File(projectName);
        if (projectFolder.exists()) {
            try {
                throw new DirectoryNotEmptyException(projectName);
            } catch (DirectoryNotEmptyException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            projectFolder.mkdir();
            System.out.println("Project " + projectName + " Successfully Created at " + projectFolder.getAbsolutePath());
            PROJECT_ROOT = projectFolder.getAbsolutePath() + File.separatorChar;
            createWorkingPackages(projectFolder.getAbsolutePath() + File.separatorChar);
        }

    }

    public void createWorkingPackages(String projectLocation) {
        String username = System.getProperty("user.name").toLowerCase();
        File src = new File(projectLocation + "src");
        PROJECT_SRC = src.getAbsolutePath() + File.separatorChar;
        src.mkdir();
        File mainPackage = new File(src.getAbsolutePath() + File.separatorChar + "com" + File.separatorChar + username + File.separatorChar + PROJECT_NAME.toLowerCase());
        mainPackage.mkdirs();
        PROJECT_WORK_DIR = mainPackage.getAbsolutePath() + File.separatorChar;
        PACKAGE_NAME = "com." + username + "." + PROJECT_NAME.toLowerCase();
        initProject(mainPackage.getAbsolutePath() + File.separatorChar);

    }

    public void initProject(String directory) {

        try {

            for (String folder : PROJECT_DIRS) {
                File fileFolder = new File(directory + folder);
                fileFolder.mkdir();

            }

            InputStream stream = this.getClass().getResourceAsStream("/resources/projectName.apxt");
//          BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            File mainClass = new File(PROJECT_WORK_DIR + "Main.java");

            mainClass.createNewFile();

            mainClass.setWritable(true);
            FileWriter writer = null;

            writer = new FileWriter(mainClass);

            writer.write("package " + PACKAGE_NAME + ";\n\n");
            Scanner in = new Scanner(stream);

            while (in.hasNextLine()) {
                writer.write(in.nextLine().replace("apxmarkup", "Main") + "\n");
            }
            in.close();
            writer.close();
            createView("Main");
            System.out.println("************************************************");
            createController("Main");
            System.out.println("************************************************");
            createStylesheet("Main");
            System.out.println("************************************************");
            createPropertiesFile();
            System.out.println("************************************************");
            createDatabase();
            System.out.println("************************************************");

        } catch (IOException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void createPropertiesFile() throws IOException {
        //If not windows OS
        if (!System.getProperty("os.name").toLowerCase().contains("win")) {
            File props = new File(PROJECT_ROOT + "project.apxprop");
            props.createNewFile();
            props.setWritable(true);
            FileWriter pWriter = new FileWriter(props);
            pWriter.write("{ " + "\n");
            pWriter.write("\"name\": \"" + PROJECT_NAME + "\",\n");
            pWriter.write("\"package\": \"" + PACKAGE_NAME + "\",\n");
            pWriter.write("\"location\": \"" + PROJECT_ROOT + "\",\n");
            pWriter.write("\"src\": \"" + PROJECT_SRC + "\",\n");
            pWriter.write("\"work\": \"" + PROJECT_WORK_DIR + "\"\n");
            pWriter.write("}");
            pWriter.close();

        }
        //Now for the windows OS we need to escape '\' as '\\' before storing the project props
        else{
            File props = new File(PROJECT_ROOT + "project.apxprop");
            props.createNewFile();
            props.setWritable(true);
            FileWriter pWriter = new FileWriter(props);
            pWriter.write("{ " + "\n");
            pWriter.write("\"name\": \"" + PROJECT_NAME.replace("\\", "\\\\") + "\",\n");
            pWriter.write("\"package\": \"" + PACKAGE_NAME.replace("\\", "\\\\") + "\",\n");
            pWriter.write("\"location\": \"" + PROJECT_ROOT.replace("\\", "\\\\") + "\",\n");
            pWriter.write("\"src\": \"" + PROJECT_SRC.replace("\\", "\\\\") + "\",\n");
            pWriter.write("\"work\": \"" + PROJECT_WORK_DIR.replace("\\", "\\\\") + "\"\n");
            pWriter.write("}");
            pWriter.close();
        
        }
        
        

    }

    public void createView(String viewName) throws IOException {
        InputStream stream = this.getClass().getResourceAsStream("/resources/apxview.apxt");

        File view = new File(PROJECT_WORK_DIR + "views" + File.separatorChar + viewName + "View.fxml");

        view.createNewFile();

        view.setWritable(true);
        FileWriter writer = null;

        writer = new FileWriter(view);

        Scanner in = new Scanner(stream);

        while (in.hasNextLine()) {
            writer.write(in.nextLine().replace("package", PACKAGE_NAME + ".controllers").replace("apxmarkup", viewName) + "\n");
        }
        in.close();
        writer.close();

        System.out.println("View created at " + view.getAbsolutePath());
    }

    public void createController(String ControllerName) throws IOException {

        InputStream stream = this.getClass().getResourceAsStream("/resources/apxcontroller.apxt");

        File controller = new File(PROJECT_WORK_DIR + "controllers" + File.separatorChar + ControllerName + "Controller.java");

        controller.createNewFile();

        controller.setWritable(true);
        FileWriter writer = null;

        writer = new FileWriter(controller);

        writer.write("package " + PACKAGE_NAME + ".controllers;\n\n");
        Scanner in = new Scanner(stream);

        while (in.hasNextLine()) {
            writer.write(in.nextLine().replace("apxmarkup", ControllerName) + "\n");
        }
        in.close();
        writer.close();
        System.out.println("Controller created at " + controller.getAbsolutePath());
    }

    public void createStylesheet(String sheetName) throws IOException {

        InputStream stream = this.getClass().getResourceAsStream("/resources/apxstyle.apxt");

        File sheet = new File(PROJECT_WORK_DIR + "styles" + File.separatorChar + sheetName + "Stylesheet.css");

        sheet.createNewFile();

        sheet.setWritable(true);
        FileWriter writer = null;

        writer = new FileWriter(sheet);

        Scanner in = new Scanner(stream);

        while (in.hasNextLine()) {
            writer.write(in.nextLine().replace("apxmarkup", sheetName) + "\n");
        }
        in.close();
        writer.close();
        System.out.println("Stylesheet created at " + sheet.getAbsolutePath());

    }

    void getAllProperties(File propd) {

        try {
            JsonParser parser = new JsonParser();
            //Create a new Instance of JSONReader
            JsonReader read = new JsonReader(new FileReader(propd));
            //Path Bug in windows Throws malformed JSON Exception
            read.setLenient(true);
            JsonElement ele = parser.parse(read);
            JsonObject prop = ele.getAsJsonObject();

            String work = prop.get("work").getAsString();
            String packagename = prop.get("package").getAsString();
            String name = prop.get("name").getAsString();
            String location = prop.get("location").getAsString();
            String src = prop.get("src").getAsString();
            System.out.println(work);
            PROJECT_WORK_DIR = work;
            PROJECT_NAME = name;
            PACKAGE_NAME = packagename;
            PROJECT_SRC = src;
            PROJECT_ROOT = location;

        } catch (JsonSyntaxException | FileNotFoundException js) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, js);
        }

    }

    void generatePage(String arg, File propd) {

        getAllProperties(propd);
        try {
            createController(arg);
            createStylesheet(arg);
            createView(arg);
        } catch (IOException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void createDatabase() {

        Database db = new Database();
        db.create(PROJECT_WORK_DIR + "database" + File.separatorChar + "db.sqlite");
        db.closeDB();

    }

    void tableFromJson(String src, File f) throws FileNotFoundException {

        getAllProperties(f);
        ObservableList<SQLParams> columns = FXCollections.observableArrayList();
        JsonParser parse = new JsonParser();
        JsonElement ele = parse.parse(new FileReader(src));

        JsonObject dbfile = ele.getAsJsonObject();

        JsonArray array = dbfile.getAsJsonArray("columns");

        for (int i = 0; i < array.size(); i++) {
            JsonObject obj = array.get(i).getAsJsonObject();
            SQLParams params = new SQLParams();
            params.setName(obj.get("name").getAsString().replace(" ", "_"));
            params.setType(obj.get("type").getAsString());
            params.setIsNull(obj.get("null").getAsBoolean());
            params.setIsUnique(obj.get("unique").getAsBoolean());
            columns.add(params);
        }
        System.out.println("Creating table ---" + dbfile.getAsJsonPrimitive("table").getAsString());
        createTable(dbfile.getAsJsonPrimitive("table").getAsString(), columns);

    }

    public void createTable(String tableName, ObservableList<SQLParams> lParamses) {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("CREATE TABLE ")
                .append(tableName)
                .append(" ( ")
                .append("id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ");

        for (SQLParams col : lParamses) {
            String type = null;
            try {
                type = new Role().get(col.getType().toLowerCase()).toString();
            } catch (Exception e) {
                type = "TEXT";
            }

            sqlQuery.append(", ");
            sqlQuery.append(col.getName());
            sqlQuery.append(" ");
            sqlQuery.append(type);

            if (col.isNull == false) {
                sqlQuery.append(" NOT NULL");
            }

            if (col.isUnique == true) {
                sqlQuery.append(" UNIQUE ");
            }

        }

        sqlQuery.append(");");
        System.out.println("SQL query");
        System.out.println(sqlQuery.toString());

        new Database().createTable(PROJECT_WORK_DIR + "database" + File.separatorChar + "db.sqlite", sqlQuery.toString());
    }

    private class Role extends HashMap<Object, Object> {

        public Role() {
            this.put("int", "INTEGER");
            this.put("integer", "INTEGER");
            this.put("double", "REAL");
            this.put("float", "REAL");
            this.put("long", "NUMERIC");
            this.put("byte", "BLOB");
            this.put("string", "TEXT");

        }

        @Override
        public Object get(Object key) {
            return super.get(key); //To change body of generated methods, choose Tools | Templates.
        }

    }

}
