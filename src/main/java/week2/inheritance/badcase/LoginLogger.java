package week2.inheritance.badcase;

public class LoginLogger {
    public void printLog(LoginWindow prompt){
        User user = prompt.login();
        System.out.println(user.makeLoginLog());
    }
}
