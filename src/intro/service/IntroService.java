package intro.service;

import javafx.scene.Parent;

public interface IntroService {
	
	void openIntroForm(Parent introForm);

	void openIntro2Box(Parent introForm);
	
	void openIntro3Box(Parent introForm);
	
	void openIntro4Box(Parent introForm);

	void labelSizeUp(Parent noticeForm, String labelName);
	
	void labelSizeDown(Parent noticeForm, String labelName);
	
}
