package Saucelabs;

import Saucelabs.util.Capabilities;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;

public class homepageSteps extends Capabilities {

    @Before
    public void setup()throws Exception{
        preparation();
    }

    @Given("^user is on homepage$")
    public void isOnHomepage() {
        androidDriver.findElementById("com.saucelabs.mydemoapp.android:id/mTvTitle");
    }

    @When("^user click product image$")
    public void clickProduct() {
        androidDriver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Sauce Lab Back Packs\"]").click();
        androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @And("^user choose blue color$")
    public void chooseColor() {
        androidDriver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays available colors of selected product\"]/android.view.ViewGroup[2]").click();
    }

    @And("^user update quantity$")
    public void updateQuantity(){
        androidDriver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Increase item quantity\"]").click();
    }

    @And("^user click Buy button$")
    public void clickBuyButton() {
        androidDriver.findElementByXPath("//android.widget.Button[@content-desc=\"Tap to add product to cart\"]").click();
    }

    @Then("^user validate product added to cart successfully$")
    public void validateProductAdded() {
        androidDriver.findElementById("com.saucelabs.mydemoapp.android:id/cartIV").click();
        androidDriver.findElementById("com.saucelabs.mydemoapp.android:id/titleTV").getText().equals("Sauce Lab Back Packs");
        androidDriver.findElementById("com.saucelabs.mydemoapp.android:id/colorIV");
        androidDriver.findElementById("com.saucelabs.mydemoapp.android:id/noTV").getText().equals("2");
    }
}
