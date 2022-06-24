package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import okhttp3.Address;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.List;

public class TestScriptHappyFlow {
    WebDriver driver;

    @Test(priority = 1)
    void Webpage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");

        //WebDriverManager.firefoxdriver().setup();
        //  driver = new FirefoxDriver();
        // driver.get("https://demo.nopcommerce.com/");

        // WebDriverManager.edgedriver().setup();
        //driver = new EdgeDriver();
        // driver.get("https://demo.nopcommerce.com/");

    }

    @Test(priority = 2)
    void navigation() {
        driver.findElement(By.xpath("//a[@href='/computers']")).click();
        driver.findElement(By.xpath("//a[@href='/desktops'][@ title='Show products in category Desktops']")).click();
        driver.findElement(By.xpath("//img[@alt='Picture of Lenovo IdeaCentre 600 All-in-One PC']")).click();
    }

    @Test(priority = 3)
    void addcart() {
        driver.findElement(By.id("add-to-cart-button-3")).click();
        driver.findElement(By.xpath("//span[@class='cart-label']")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr/td[5]/input")).clear();
    }

    @Test(priority = 4)
    void update() {
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr/td[5]/input")).sendKeys("3");
        driver.findElement(By.id("updatecart")).click();

    }

    @Test(priority = 5)
    void checkout() {
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']")).click();

    }

    @Test(priority = 6)
    void Billing() throws InterruptedException {
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Dipa");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Prajapati");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("dips.prajapti@gmail.com");
        driver.findElement(By.id("BillingNewAddress_Company")).sendKeys("IBM");
        WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select select = new Select(country);
        select.selectByVisibleText("United States");
        Thread.sleep(2000);
        WebElement county = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/form/div/div/div[2]/div/div/div[6]/select"));
        Select select1 = new Select(county);
        select1.selectByVisibleText("Alaska");
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("New york");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("New York");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("NY 10022");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("1-888-746-7426");
        driver.findElement(By.xpath("//button[@type='button'][@class='button-1 new-address-next-step-button']")).click();

    }

    @Test(priority = 7)
    void Shipping() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='shippingoption_1'][@value='Next Day Air___Shipping.FixedByWeightByTotal']")).click();
        driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button'][@onclick='ShippingMethod.save()']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("paymentmethod_1")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='button-1 payment-method-next-step-button'][@onclick='PaymentMethod.save()']")).click();
    }


}

