package pl.sobczak.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.sobczak.automation.utils.Wait;

import javax.annotation.PostConstruct;

public class BasePage {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected Wait wait;

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    @PostConstruct
    private void setUp() {
        PageFactory.initElements(driver, this);
    }

    public void waitAndClick(WebElement element) {
        wait.forElementToBeClickable(element);
        element.click();
    }

    public String getElementAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

}
