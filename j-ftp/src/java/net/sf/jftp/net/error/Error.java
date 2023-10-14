package net.sf.jftp.net.error;

/**
* The basic Transfer interface.
* You probably don't have to use it directly.
*/
public abstract class Error
{
    public String error;

    public void printError() {
    	System.out.println(error);
    }

    public abstract String getErrorType();
}
