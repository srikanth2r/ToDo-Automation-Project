package com.todopages;

import java.util.Iterator;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.apache.log4j.Logger;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ToDoLaunchPage {

	private WebDriver driver;
Logger log=Logger.getLogger(ToDoLaunchPage.class);
	// 1.By Locators

	private By entertext = By.xpath("//input[@id='todo-input']");
	private By todotext = By.xpath("//h1[normalize-space()='todos']");
	private By todocount = By.xpath("//span[@class='todo-count']");
	private By completedbutton = By.xpath("//a[normalize-space()='Completed']");
	private By allbutton = By.xpath("//a[normalize-space()='All']");
	private By activebutton = By.xpath("//a[normalize-space()='Active']");
	private By selectallbutton = By.xpath("//input[@class='toggle-all']");

	// 2.constructor of the page class

	public ToDoLaunchPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3.page actions= features of the page behaviour fo webelements

	public String getlaunchPageTitle() {
		return driver.getTitle();
	}

	public boolean validateTodoText() {
		return driver.findElement(todotext).isDisplayed();
	}

	public void entertodotext(String task) {
		driver.findElement(entertext).sendKeys(task);
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).build().perform();

	}

	public String todocount() {
		String count = driver.findElement(todocount).getText();
		return count;
	}

	// method to get text for todo tasks
	public String todoText(int index) {
		String text = driver.findElement(By.xpath("(//li//div//label[@data-testid='todo-item-label'])[" + index + "]"))
				.getText();
		// System.out.println(text);
		return text;
	}

	// method to select for todo tasks
	public void todoselection(String text) {

		WebElement todoselect = driver
				.findElement(By.xpath("//label[normalize-space()='" + text + "']//preceding-sibling::input"));

		todoselect.click();

	}

	public void clickcompletebutton() {
		driver.findElement(completedbutton).click();
	}

	public void clickAllButton() {
		driver.findElement(allbutton).click();
	}

	public void selectedtodolist() {
		List<WebElement> selectedtodo = driver.findElements(By.xpath("//li//div//input[@type='checkbox']"));
		int count = selectedtodo.size();
		System.out.println("The selected ToDo list is:" + count);
		for (int i = 0; i < count; i++) {

			Iterator<WebElement> element = selectedtodo.iterator();
			WebElement selectedelement = element.next();
			selectedelement.isSelected();

		}

	}

	public void verifyAllFilter(int index) {
		List<WebElement> listin = driver
				.findElements(By.xpath("(//li//div//label[@data-testid='todo-item-label'])[" + index + "]"));

		int count = listin.size();
		for (int i = 0; i < count; i++) {
			System.out.println(listin.get(i));
		}

	}

	public void clickActiveButton() {
		driver.findElement(activebutton).click();
	}

	public void selectallbutton() {
		driver.findElement(selectallbutton).click();

	}

	public void deletetodo(String text) throws InterruptedException {
		WebElement delecteele = driver.findElement(By.xpath("//label[normalize-space()='" + text + "']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", delecteele);

		WebElement delecteele1 = driver.findElement(By.xpath("//li[1]//div[1]//button[1]"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", delecteele1);
		

	}
}
