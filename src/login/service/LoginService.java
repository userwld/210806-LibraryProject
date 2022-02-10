package login.service;

import javafx.scene.Parent;
import login.LoginController;
import main.MainController;

public interface LoginService {

	public boolean LoginProc(Parent loginForm);

	public void findPwProc(LoginController loginController);


}
