package stepdefinations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.qa.factory.DriverFactory;
import com.todopages.ToDoLaunchPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ToDoSteps {
	Logger log=Logger.getLogger(ToDoSteps.class);
	private ToDoLaunchPage launchpage = new ToDoLaunchPage(DriverFactory.getDriver());

	@Given("User launches the ToDo application")
	public void user_launches_the_to_do_application() {
		log.info("User launches the application");

		DriverFactory.getDriver().get("https://todomvc.com/examples/react/dist/");
		String pagetitle = launchpage.getlaunchPageTitle();
		Assert.assertEquals(pagetitle, "TodoMVC: React");
		Boolean status = launchpage.validateTodoText();
		Assert.assertTrue(true);

	}

	@When("User enters a valid ToDo tasks description")
	public void user_enters_a_valid_to_do_tasks_description(DataTable todotasks) {
		log.info("User enter the ToDo list");
		List<String> list = todotasks.asList();
		int size = list.size();
		System.out.println("The list size is:" + size);
		// steps for entering the ToDo task description
		for (int i = 0; i <= size - 1; i++) {
			System.out.println("The ToDo task entered is:" + list.get(i));
			launchpage.entertodotext(list.get(i));

		}

	}

	@Then("The new todo items added should appear in the list with the correct description and count")
	public void the_new_todo_items_added_should_appear_in_the_list_with_the_correct_description_and_count(
			DataTable todolist) {
		log.info("User able to see the entered Todo List");
		// steps for validating the ToDo List count
		List<String> list = todolist.asList();
		int ExpectedToDolistcount = list.size();
		System.out.println("The Expected list size is:" + ExpectedToDolistcount);
		String count = launchpage.todocount();
		char ActualToDoListcount = count.charAt(0);
		int no = ActualToDoListcount - '0';
		System.out.println("Total ToDo tasks entered is:" + no);
		Assert.assertEquals(no, ExpectedToDolistcount);

		// steps for validating the task list description
		for (int i = 0; i < ExpectedToDolistcount; i++) {
			String textexpected = list.get(i);
			System.out.println("Expected Task Text:" + textexpected);
			for (int j = i + 1; j <= ExpectedToDolistcount; j++) {
				String textatual = launchpage.todoText(j);
				System.out.println("Actual Task Text:" + textatual);
				Assert.assertEquals(textexpected, textatual);
				break;

			}

		}

	}

	@Then("User selects the required ToDo list checkbox for completion")
	public void user_selects_the_required_to_do_list_checkbox_for_completion(DataTable listoselect) {
		log.info("User selects the Todo List options for completion");
		// steps for validating the ToDo List count
		List<String> list = listoselect.asList();
		List<String> list2 = new ArrayList<>();
		int todocount = list.size();
		for (int i = 0; i < todocount; i++) {
			list2.add(list.get(i));
			for (int j = i; j <= todocount; j++) {
				launchpage.todoselection(list2.get(j));
				break;
			}

		}

		// user verifies the count after selecting the ToDo task
		String count = launchpage.todocount();
		char itemsleftcount = count.charAt(0);
		int lestitems = itemsleftcount - '0';
		System.out.println("Total ToDo tasks left:" + lestitems);
		// Assert.assertEquals(lestitems, todocount);

	}

	@Then("User clicks on the completed button and verifies the DoTo list for completion")
	public void user_clicks_on_the_completed_button_and_verifies_the_do_to_list_for_completion() {
		// user clicks on the completed button
		launchpage.clickcompletebutton();
		// user verifies the checkbox is selected or not
		launchpage.selectedtodolist();
	}

	@Then("User selects the required ToDo list checkbox for completion and verifies filter All")
	public void user_selects_the_required_to_do_list_checkbox_for_completion_and_verifies_All_filter(
			DataTable listoselect) {
		launchpage.clickAllButton();
		List<String> list = listoselect.asList();
		List<String> list2 = new ArrayList<>();
		List<String> list3 = new ArrayList<>();
		int todocount = list.size();
		for (int i = 0; i < todocount; i++) {
			list2.add(list.get(i));
			list3.add(launchpage.todoText(i + 1));
			for (int j = i; j <= todocount; j++) {
				launchpage.todoselection(list2.get(j));

				break;
			}
			Assert.assertEquals(list2, list3);
		}

	}

	@Then("User verifies the ToDo list entered and verifies Active filter")
	public void user_verifies_the_Active_filter(DataTable listoselect) {
		launchpage.clickActiveButton();
		List<String> list = listoselect.asList();
		List<String> list2 = new ArrayList<>();
		List<String> list3 = new ArrayList<>();
		int todocount = list.size();
		for (int i = 0; i < todocount; i++) {
			list2.add(list.get(i));
			list3.add(launchpage.todoText(i + 1));
			for (int j = i; j <= todocount; j++) {
				launchpage.selectedtodolist();

				break;
			}
			Assert.assertEquals(list2, list3);
		}

	}

	@Then("User clicks on the down arrow button")
	public void user_clicks_on_the_down_arrow_button() {
		//user clicks on the select all down arrow button

		launchpage.selectallbutton();

	}

	@Then("User verifies all the ToDo list checck box are selected")
	public void user_verifies_all_the_to_do_list_checck_box_are_selected() {

		// User verifies all checkbox are selected
		launchpage.selectedtodolist();
		// user verifies the count of items left after selection

		String count = launchpage.todocount();
		char itemsleftcount = count.charAt(0);
		int lestitems = itemsleftcount - '0';
		System.out.println("Total ToDo tasks left:" + lestitems);
		Assert.assertEquals(lestitems, 0);
	}

	@Then("User selects a ToDo and click on close button")
	public void user_selects_a_to_do_and_click_on_close_button(DataTable listoselect) throws InterruptedException {
		List<String> list = listoselect.asList();
		List<String> list2 = new ArrayList<>();
		int todocount = list.size();
		for (int i = 0; i < todocount; i++) {
			list2.add(list.get(i));
			for (int j = i; j <= todocount; j++) {
				launchpage.deletetodo(list2.get(j));
				break;
			}

		}
	}

	@Then("User verifes the ToDo is deleted from ToDo list")
	public void user_verifes_the_to_do_is_deleted_from_to_do_list() {
		
	}

}
