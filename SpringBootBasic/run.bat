set PATH=C:\Develop\runtimes\jdk1.8\bin;%PATH%
set PATH=D:\MyDevelop\gradle-4.10.2\bin;%PATH%
set JAVA_HOME=C:\Develop\runtimes\jdk1.8
set GRADLE_HOME=D:\MyDevelop\gradle-4.10.2
set GRADLE_USER_HOME=D:\MyDevelop\gradle-user-home
C:
cd C:\gitee\teach\SpringBootBasic
call gradle clean
call gradle  build
cd build\libs
java -jar SpringBootBasic-1.0.0.0.jar
pause
