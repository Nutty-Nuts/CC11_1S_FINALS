package modules.helper;

/**
 * ErrorMessageHelper
 */
public class ErrorMessageHelper {

    public void notAnOptionError() {
        System.out.printf("ERROR  Not an Option \n"); 
    }
    public void notANumberError() {
        System.out.printf("ERROR  Please enter a Number \n"); 
    }
    public void quittingProgram() {
        System.out.printf("WARN  Quitting Program");
    }
    public void noPasswords() {
        System.out.printf("WARN No Exsisting Passwords \n");
    }
}
