package main.service;

import javafx.scene.Parent;

public interface OpenService {

	void openLogin(Parent mainForm);

	void openJoin(Parent mainForm);

	void openSearch(Parent mainForm);

	void openNewBest(Parent mainform);
	
	void openIntro(Parent mainForm);

	void openNotice(Parent mainForm);

	void openBookPage();
	
	void openNotiPage();

	void openRule(Parent mainForm);

	void openInterior(Parent mainForm);

	void openRoot(Parent mainForm);

	void openEvent(Parent mainForm);

	void openPreview1(SetViewService setSvc);

	void openPreview2(SetViewService setSvc);

	void openPreview3(SetViewService setSvc);

	void openPreview4(SetViewService setSvc);

	void openNew(Parent mainForm);

	void openBest1(Parent mainForm);

	void openBest2(Parent mainForm);

	void openEventPage();

	void openPart(Parent mainForm);
	
	void openPart(Parent form ,Parent mainForm);





}
