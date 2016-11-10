![](http://i.imgur.com/qkiAZJi.png)
# A JavaFx Library For Making MVC Type Applications![](https://img.shields.io/badge/othree-codes-yellowgreen.svg)

### Installation
 - requires Java jdk > 7 for windows
 - requres openjdk-7 or 8 and openjfx for linux

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
![](http://i.imgur.com/a3mLiW0.png)
              
The Project is Structured in such a way as to help you keep track of your where all files are being placed.


 - layout (FXML files) go in the views directory

 - controllers go in the controllers directory

 - Stylesheets go in the stylesheet directory

You get the point eh?

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
apx create table database.json
```
The next parameter after table is the file location of the json file to read from
##### sample database.json
```json
{
    "table": "users",
    "columns":[
            {
              "name":"name",
              "type":"String",
              "null":"true",
              "unique":"false"
            },
            {
              "name":"age",
              "type":"Integer",
              "null":"true",
              "unique":"false"
            }
                          
    ]
}

```
This command will create a single Table with corresponding columns
(NB: I Plan to automatically create models matching to the table being created in a future release)

## Why is apx.jar 4mb?
This is because in contains certain libraries needed for a simple MVC REST applictaion 

  1. GSON: A Java serialization/deserialization library that can convert Java Objects into JSON and back.
  link to project: [Google Gson](https://github.com/google/gson)
  2. SQLite JDBC Driver: SQLite JDBC, developed by Taro L. Saito, is a library for accessing and creating SQLite database files   in Java. link to project [Xserial SQLite JDBC](https://github.com/xerial/sqlite-jdbc)
  3. Unirest: Unirest in Java: Simplified, lightweight HTTP client library. http://unirest.io/java
  link to project [Mashape Unirest-java](https://github.com/Mashape/unirest-java)
  
All Libraries Remain work of the original Author

### Todos

 - Generate Models
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














