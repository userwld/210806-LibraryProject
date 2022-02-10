package join.service;

import javafx.scene.Parent;
import main.MainController;

public interface JoinService {

	void gotoJoin2(Parent joinFrom);

	void checkAll1(Parent joinForm);
	
	void checkAll2(Parent joinForm);
	
	void checkAgree(Parent joinForm);

	boolean confirmIdProc(Parent joinForm);

	void joinButtonProc(Parent joinForm, MainController mainCtrl);

	

}
