package business.actions;
import pages.LoginPage;

public class LoginActions {
    private final LoginPage loginPage = new LoginPage();

    public void loginEmailAccount(String login, String password) {
        loginPage.submitLogin(login);
        loginPage.submitPassword(password);
    }
}
