package com.seleniumtests.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.seleniumtests.core.SelTestCase;
import com.seleniumtests.dataobject.RegistrationData;
import com.seleniumtests.pageobject.NewRegistrationPage;

public class WebDriverTest extends SelTestCase {

	@Test(dataProvider = "regData", dataProviderClass = RegistrationData.class)
	public void testRegistrationNew(RegistrationData registrationData) {

		driver.get(appURL);
		NewRegistrationPage registration = PageFactory.initElements(driver,
				NewRegistrationPage.class);
		registration.registerNewUser(registrationData);
		assert driver
				.findElement(By.tagName("body"))
				.getText()
				.contains("Thank you for registering. "
								+ "You may now sign-in using the user name and password you've just entered.");
	}
}
