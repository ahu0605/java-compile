# java-compile

## 项目编译
- |-src/
    - |-com/
        - |-mvn/
            - |-Run.java  //package com.mvn;
    - |-com/
        - |-model/
            - |-Person.java  //dependence
- |-bin/
    - |-com/
        - |-mvn/
            - |-Run.class
    - |-com/
        - |-mvn/
            - |-Person.class
- |-lib/
    - |-*.jar
- |-log4j.properties
```
#javac -d bin/  src/com/model/Person.java
#javac -d bin/ -cp bin/ src/com/mvn/Run.java
#-sourcepath 与 -cp 可同时应用
javac -d bin/ -sourcepath src/ -classpath lib/log4j-1.2.17.jar src/com/mvn/Run.java
java -cp bin/;lib/log4j-1.2.17.jar -Dlog4j.configuration=file:log4j.properties com.mvn.Run
```
#### 参数
javac [ options ] [ sourcefiles ] [ @files ]
- options 命令行选项。 
- sourcefiles一个或多个要编译的源文件（例如 MyClass.java）。 
- @files 一个或多个对源文件进行列表的文件。
- options[-d] 编译的目标路径

## 项目打包
- |-src/
    - |-com/
        - |-mvn/
            - |-Run.java  //package com.mvn;
    - |-com/
        - |-model/
            - |-Person.java  //dependence
- |-bin/
    - |-com/
        - |-mvn/
            - |-Run.class
    - |-com/
        - |-mvn/
            - |-Person.class
- |-lib/
    - |-*.jar
- |-log4j.properties
```
jar cvfm run.jar manifest.mf -C bin/ .
```
#### META-INF/manifest.mf 属性
* Manifest-Version
    * 用来定义manifest文件的版本，例如：Manifest-Version: 1.0
* Created-By
    * 声明该文件的生成者，一般该属性是由jar命令行工具生成的，例如：Created-By: Apache Ant 1.5.1
* Signature-Version
    * 定义jar文件的签名版本
* Class-Path
    * 应用程序或者类装载器使用该值来构建内部的类搜索路径
* Main-Class
    * 定义jar文件的入口类，该类必须是一个可执行的类，一旦定义了该属性即可通过 java -jar x.jar来运行该jar文件。
    * 格式如下：
```
Manifest-Version: 1.0
Class-Path: lib/log4j-1.2.17.jar
Main-Class: com.mvn.Run

```
#### 命令
```
* java -cp run.jar -Dlog4j.configuration=file:log4j.properties com.mvn.Run
* java -jar -Dlog4j.configuration=file:log4j.properties run.jar
```