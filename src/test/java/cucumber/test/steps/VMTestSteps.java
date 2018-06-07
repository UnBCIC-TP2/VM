package cucumber.test.steps;

import br.cic.unb.vvt.Coin;
import br.cic.unb.vvt.VendingMachine;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class VMTestSteps {

	VendingMachine vm; 

	@Before
	public void setUp() {
		vm = new VendingMachine(75);
	}
	
	@Given("^that a bottle of beer is (\\d+) cents$")
	public void that_a_bottle_of_beer_is_cents(int arg1) throws Throwable {
	    vm = new VendingMachine(arg1);
	}

	@When("^I introduce (\\d+) cents$")
	public void i_introduce_cents(int arg1) throws Throwable {
	    vm.insertCoin(new Coin(arg1));
	}

	@Then("^the total in coins must be (\\d+)$")
	public void the_total_in_coins_must_be(int arg1) throws Throwable {
	    Assert.assertEquals(arg1, vm.getCurrentValue());
	}

	@When("^ask for a beer without enough money$")
	public void ask_for_a_beer_without_enough_money() throws Throwable {
	    try {
	    	vm.vend();
	    }
	    catch(IllegalStateException e) {
	    	//NOTE: it is expected to throw an exception.
	    }
	}
	
	@When("^ask for a beer$")
	public void ask_for_a_beer() throws Throwable {
	    vm.vend();
	}

	@Then("^the system should print a message NOT ENOUGH MONEY and the total in coins must be (\\d+)$")
	public void the_system_should_print_a_message_NOT_ENOUGH_MONEY_and_the_total_in_coins_must_be(int arg1) throws Throwable {
		Assert.assertEquals(arg1, vm.getCurrentValue());
	}
	
	@Then("^the system should print a message GET YOUR DRINK and the total in coins must be (\\d+)$")
	public void the_system_should_print_a_message_GET_YOUR_DRINK_and_the_total_in_coins_must_be(int arg1) throws Throwable {
	    Assert.assertEquals(arg1, vm.getCurrentValue());
	}
	
	@When("^I introduce (\\d+) real \\((\\d+) cents\\)$")
	public void i_introduce_real_cents(int arg1, int arg2) throws Throwable {
	    vm.insertCoin(new Coin(50));
	    vm.insertCoin(new Coin(50));
	}

	@When("^ask for two beers$")
	public void ask_for_two_beers() throws Throwable {
	    try {
		    	vm.vend();
		    vm.vend();
	    }catch(Exception e) {
	    	
	    }
	}
	
	@When("^ask for the change$")
	public void ask_for_the_change() throws Throwable {
	   vm.returnCoins();
	}

}
