# Experimental_Project_with_Oracle_-_Java
Try to solve some payroll problem in java ( Office Work )


There have all Java work which done with Vistasoft IT bangladesh Ltd.


### Run jar file using CMD
Open CMD and type
>java -jar location/[file-name].jar

> if you want to run your jar file using exe file here i write some C code which help's
to run jar file using cmd mode.

``` C
#include<windows.h> // call header file
// main function
int main(){
  HWND window; // call window object
  AllocConsole(); // find console
  window = FindWindowA("ConsoleWindowClass", NULL); // get current console
  ShowWindow(window, 0); // hide console
  // run jar file using CMD
  system("java -jar DeleteTrcFileFromOracleDatabase.jar");
  return 0; // return
}
```

> Now you compile your program and run 
> myApp.exe



### Uses Driver List
>-------------------
**- commons-daemon-1.2.2-bin
**- mySQL_and_Oracle_connector_driver_for_java
**- sqljdbc_6.0
**- UCanAccess-4.0.4-bin
**- ZKFingerSDK+5.3_ZK10.0
**- itextpdf-5.5.9
**- itextpdf-5.1.0
**- javax.mail
**- jdk-8u231-windows-x64
**- jna-5.5.0
**- ZKFingerReader

