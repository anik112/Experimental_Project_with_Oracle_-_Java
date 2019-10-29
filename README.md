# Experimental_Project_with_Oracle_-_Java
Try to solve some payroll problem in java ( Office Work )


There have all Java work which done with Vistasoft IT bangladesh Ltd.


### Run jar file using CMD
Open CMD and type
<code>java -jar location\[file-name].jar</code>

> if you want to run your jar file using exe file here i write some C code which help's
to run jar file using cmd mode.

<code>
#include<windows.h> // call header file\n
// main function\n
int main(){\n
  	HWND window; // call window object\n
	AllocConsole(); // find console\n
	window = FindWindowA("ConsoleWindowClass", NULL); // get current console\n
	ShowWindow(window, 0); // hide console\n
  	// run jar file using CMD\n
	system("java -jar DeleteTrcFileFromOracleDatabase.jar");\n
  return 0; // return\n
}\n
</code>

> Now you compile your program and run 
> myApp.exe
