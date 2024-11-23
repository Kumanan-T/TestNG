package com.pageobjectmanager;

import com.baseclass.BaseClass;
import com.pageobjectmodel.OpenHMRSLogin;
import com.srcfilereadermanager.FileReaderManager;

public class PageObjectManager extends BaseClass {

	private FileReaderManager fileReader;

	private OpenHMRSLogin loginpage;

	public FileReaderManager getFileReader() {
		if (fileReader == null) {
			fileReader = new FileReaderManager();
		}
		return fileReader;
	}

	public OpenHMRSLogin getLoginpage() {
		if (loginpage == null) {
			loginpage = new OpenHMRSLogin(driver);
		}
		return loginpage;
	}

}
