![](http://i.imgur.com/qkiAZJi.png)
# A JavaFx Library For Making MVC Type Desktop Applications ![](https://img.shields.io/badge/othree-codes-yellowgreen.svg) ![](https://scrutinizer-ci.com/g/othreecodes/APX/badges/build.png?b=master) [![Say Thanks!](https://img.shields.io/badge/Say%20Thanks-!-1EAEDB.svg)](https://saythanks.io/to/othreecodes)
### Installation
 - requires Java jdk > 7 for windows
 - requres openjdk-7 or 8 and openjfx for linux

### Download the Binaries and Jar file
 - [apx + apx.jar Linux (.tar.gz file)](https://github.com/othreecodes/APX/releases/download/v0.0.2/apx-linux.tar.xz)
 - [apx.exe + apx.jar for for Windows OS (.7z file) ](https://github.com/othreecodes/APX/releases/download/v0.0.2/apx-windows.7z)

## Or Clone the repo
```sh
git clone https://github.com/othreecodes/APX.git
```
## Demo Project
For a sample project check out this repo
[othreecodes/apxdemo](https://github.com/othreecodes/apxdemo)

#### Adding Directory to PATH
After cloning the repo, Open the binaries folder and add the correct folder to path for your corresponing OS

 - [How to add a directory to path (Linux)](http://unix.stackexchange.com/questions/26047/how-to-correctly-add-a-path-to-path)
 
 - [How to add a directory to path (Windows)](http://windowsitpro.com/systems-management/how-can-i-add-new-folder-my-system-path)

Also, You will need to add the apx.jar file to your library class path

### Starting a new project
Open a terminal (cmd for windows users) in the directory in which you want to start the project and run

```sh
apx start MySampleProject
```
MySampleProject Being the name of your project
NB: Do not use java keywords to create a project

### Directory Structure
![](http://i.imgur.com/Krwj9qM.png)
              
The Project is Structured in such a way as to help you keep track of your where all files are being placed.


 - layout (FXML files) go in the views directory

 - controllers go in the controllers directory

 - Stylesheets go in the stylesheet directory

You get the point eh?
Your Project can then be easily imported into your favourite IDE without stress

### Heres the best part
There's a project.apxprop file that marks the project as an apx project (Do Not delete or Edit !!!)
It contains basic info about your project. With that in place, you can

#### Generate pages
```sh
apx g page Login
```
This will generate 3 files.

 - A LoginView.fxml automatically Linked to
 - A LoginController.java
 - A LoginStylesheet.css already linked to the LoginView.fxml


#### Create tables in database (db.sqlite)
[Using Sqlite with Java](http://www.sqlitetutorial.net/sqlite-java/)
NB: No need to download the jDBC sqlite Driver. Its already included in apx.jar
```sh
apx create model database.json
```
The next parameter after model is the file location of the json file to read from
##### sample database.json
```json
{
    "table": "user",
    "properties": {
        "username": {
            "type": "string",
            "null": true,
            "unique": true,
            "default":"Anonymous",
            "title":"The Username of the LoggedIn individual",
            "description":"Whatever This is meant to do"
        },
        "pin": {
            "type": "integer",
             "null": true,
            "unique": false,
            "default":1234
        },
        "number": {
            "type":"number",
             "null": true,
            "unique": false
        }

    }
}

```
will generate 
```java

package com.othree.apx;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "user")
public class User {

    /**
     * This is compulsory for both the database and to access models
     * 
     */
    @DatabaseField(generatedId = true, columnName = "id")
    @SerializedName("id")
    private int id;
    /**
     * The Username of the LoggedIn individual
     * <p>
     * Whatever This is meant to do
     * 
     */
    @DatabaseField(columnName = "username", canBeNull = true, unique = true)
    @SerializedName("username")
    private String username = "Anonymous";
    @DatabaseField(columnName = "pin", canBeNull = true, unique = false)
    @SerializedName("pin")
    private int pin = 1234;
    @DatabaseField(columnName = "number", canBeNull = true, unique = false)
    @SerializedName("number")
    private double number;

    /**
     * No args constructor for use in serialization
     * 
     */
    public User() {
    }

    /**
     * 
     * @param number
     * @param pin
     * @param username
     */
    public User(String username, int pin, double number) {
        super();
        this.username = username;
        this.pin = pin;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
    }

    /**
     * The Username of the LoggedIn individual
     * <p>
     * Whatever This is meant to do
     * 
     * @return
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * The Username of the LoggedIn individual
     * <p>
     * Whatever This is meant to do
     * 
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The pin
     */
    public int getPin() {
        return pin;
    }

    /**
     * 
     * @param pin
     *     The pin
     */
    public void setPin(int pin) {
        this.pin = pin;
    }

    /**
     * 
     * @return
     *     The number
     */
    public double getNumber() {
        return number;
    }

    /**
     * 
     * @param number
     *     The number
     */
    public void setNumber(double number) {
        this.number = number;
    }

}


```

This command will create a single Table with corresponding columns
And also create a model file as seen above

## Why is apx.jar ~7mb?
This is because in contains certain libraries needed for a simple MVC REST applictaion 

  1. GSON: A Java serialization/deserialization library that can convert Java Objects into JSON and back.
  link to project: [Google Gson](https://github.com/google/gson)
  2. SQLite JDBC Driver: SQLite JDBC, developed by Taro L. Saito, is a library for accessing and creating SQLite database files   in Java. link to project [Xserial SQLite JDBC](https://github.com/xerial/sqlite-jdbc)
  3. Unirest: Unirest in Java: Simplified, lightweight HTTP client library. http://unirest.io/java
  link to project [Mashape Unirest-java](https://github.com/Mashape/unirest-java)
  4. ORMLite Database Library [ORMlite.com](http://ormlite.com/)
  5. JSONSchema2pojo Generates Java types from JSON Schema (or example JSON) and annotates those types for data-binding with Jackson 1.x or 2.x, Gson, etc http://www.jsonschema2pojo.org   [Project Link](https://github.com/joelittlejohn/jsonschema2pojo)
  
All Libraries Remain work of the original Author

### Useful Links and resources
 - [ORM Lite Documantation](http://ormlite.com/javadoc/ormlite-core/doc-files/ormlite_2.html#Class-Setup)
 - [JSONSchema2pojo Wiki reference](https://github.com/joelittlejohn/jsonschema2pojo/wiki/Reference)
 - [othreecodes/apxdemo (Demo)](https://github.com/othreecodes/apxdemo)
 
### Todos

 - Generate Models (done)
 - Include support for Other databases
 - Make http connections neater
 - A lot...
Feel free to contribute.

License
-------

The MIT License (MIT). Please see LICENSE.md for more information.


    Copyright (c) 2016 Obi Uchenna David

    Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
    files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy,
    modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software
    is furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
    OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
    LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
