# Experimental_Project_with_Oracle_-_Java
Try to solve some payroll problem in java ( Office Work )


There have all Java work which done with Vistasoft IT bangladesh Ltd.


### Run jar file using CMD
Open CMD and type
>java -jar location\[file-name].jar

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
