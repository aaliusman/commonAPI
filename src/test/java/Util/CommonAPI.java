 package Util;

//import org.apache.commons.configuration.ConfigurationException;
//import org.apache.commons.configuration.PropertiesConfiguration;
//import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
//import encryption.Encrypt;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import org.testng.asserts.SoftAssert;
//import reporting.ExtentManager;
//import reporting.ExtentTestManager;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

//import reporting.ExtentManager;
//import reporting.ExtentTestManager;

    public class CommonAPI {

        SoftAssert softAssert = new SoftAssert();
        public static WebDriver driver = null;
        public String browserstack_username = "";
        public String browserstack_accesskey = "";
        public String saucelabs_username = "";
        public String saucelabs_accesskey = "";


        //ExtentReport
        public static ExtentReports extent;

//        @BeforeSuite
//        public void extentSetup(ITestContext context) {
//            ExtentManager.setOutputDirectory(context);
//            extent = ExtentManager.getInstance();
//        }

//        @BeforeMethod
//        public void startExtent(Method method) {
//            String className = method.getDeclaringClass().getSimpleName();
//            String methodName = method.getName().toLowerCase();
//            ExtentTestManager.startTest(method.getName());
//            ExtentTestManager.getTest().assignCategory(className);
//        }

        protected String getStackTrace(Throwable t) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            return sw.toString();
        }

//        @AfterMethod
//        public void afterEachTestMethod(ITestResult result) {
//            ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
//            ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));
//
//            for (String group : result.getMethod().getGroups()) {
//                ExtentTestManager.getTest().assignCategory(group);
//            }
//
//            if (result.getStatus() == 1) {
//                ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
//            } else if (result.getStatus() == 2) {
//                ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
//            } else if (result.getStatus() == 3) {
//                ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
//            }
//            ExtentTestManager.endTest();
//            extent.flush();
//            if (result.getStatus() == ITestResult.FAILURE) {
//                captureScreenshot(driver, result.getName());
//            }
////        driver.quit();
//        }

        @AfterSuite
        public void generateReport() {
            extent.close();
        }


        private Date getTime(long millis) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(millis);
            return calendar.getTime();
        }


        @Parameters({"useCloudEnv", "cloudEnvName", "os", "os_version", "browserName", "browserVersion", "url"})
        @BeforeMethod
        public void setUp(@Optional("false") boolean useCloudEnv, @Optional("false") String cloudEnvName,
                          @Optional("OS X") String os, @Optional("10") String os_version, @Optional("firefox") String browserName, @Optional("34")
                                  String browserVersion, @Optional("https://staging-ec.comcast.com/provide-chat-support") String url) throws IOException {
            System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, SECONDS);
            driver.manage().timeouts().pageLoadTimeout(10, SECONDS);
            driver.get(url);
            driver.manage().window().maximize();
        }

//    public WebDriver getLocalDriver(@Optional("mac") String OS, String browserName){
//        if(browserName.equalsIgnoreCase("chrome")){
//            if(OS.equalsIgnoreCase("OS X")){
//                System.setProperty("webdriver.chrome.driver", "../Generic/browser-driver/chromedriver");
//            }else if(OS.equalsIgnoreCase("Windows")){
//                System.setProperty("webdriver.chrome.driver", "C:\\Users\\malius932\\IdeaProjects\\iChatApp\\InitiateChat\\drivers\\chromedriver.exe");
//            }
//            driver = new ChromeDriver();
//        }else if(browserName.equalsIgnoreCase("firefox")){
//            if(OS.equalsIgnoreCase("OS X")){
//                System.setProperty("webdriver.gecko.driver", "../Generic/browser-driver/geckodriver");
//            }else if(OS.equalsIgnoreCase("Windows")) {
//                System.setProperty("webdriver.gecko.driver", "C:\\Users\\malius932\\IdeaProjects\\iChatApp\\InitiateChat\\drivers\\geckodriver.exe");
//            }
//            driver = new FirefoxDriver();
//
//        } else if(browserName.equalsIgnoreCase("ie")) {
//            System.setProperty("webdriver.ie.driver", "../Generic/browser-driver/IEDriverServer.exe");
//            driver = new InternetExplorerDriver();
//        }
//        return driver;
//
//    }

        public WebDriver getCloudDriver(String envName, String envUsername, String envAccessKey, String os, String os_version, String browserName,
                                        String browserVersion) throws IOException {

            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("browser", browserName);
            cap.setCapability("browser_version", browserVersion);
            cap.setCapability("os", os);
            cap.setCapability("os_version", os_version);
            if (envName.equalsIgnoreCase("Saucelabs")) {
                //resolution for Saucelabs
                driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
                        "@ondemand.saucelabs.com:80/wd/hub"), cap);
            } else if (envName.equalsIgnoreCase("Browserstack")) {
                cap.setCapability("resolution", "1024x768");
                driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
                        "@hub-cloud.browserstack.com/wd/hub"), cap);
            }
            return driver;
        }

        @AfterMethod
        public void afterMethod() {
            driver.manage().deleteAllCookies();
            // driver.close();
            driver.quit();
        }

        public void switchWindow() {
            String currentWindow = driver.getWindowHandle();
            Set<String> allWindow = driver.getWindowHandles();
            for (String child : allWindow) {
                if (!currentWindow.equalsIgnoreCase(child)) {
                    driver.switchTo().window(child);
                }
            }
        }

        public static void waitBeforeClick(WebElement locator, int timeout) {
            new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(locator));
            locator.click();
        }

        public void openRequesterWindow() {
            String fixAgentWindow = driver.getWindowHandle();
            Set<String> allWindow = driver.getWindowHandles();
//        int count = ((Set) allWindow).size();
//        System.out.println("window size: " + count);

            for (String child : allWindow) {
                if (!fixAgentWindow.equalsIgnoreCase(child)) {
                    driver.switchTo().window(child);
                }
            }
        }

        public void scrollWithInWebElement() {

            EventFiringWebDriver firingWebDriver = new EventFiringWebDriver(driver);
            firingWebDriver.executeScript("document.getElementByXpath('//button[text()='LOAD MORE']').scrollTop = 500");
        }

        public void openFixAgentWindow() {
            String adminWindow = driver.getWindowHandle();
            Set<String> allWindow = driver.getWindowHandles();
            for (String child : allWindow) {
                if (!adminWindow.equalsIgnoreCase(child)) {
                    driver.switchTo().window(child);
                }
            }
        }

        public void openAdminWindow() {
            String requesterWindow = driver.getWindowHandle();

            Set<String> allWindow = driver.getWindowHandles();
//        int count = ((Set) allWindow).size();
//        System.out.println("window size: " + count);

            for (String parent : allWindow) {
                if (!requesterWindow.equalsIgnoreCase(parent)) {
                    driver.switchTo().window(parent);
                }
            }
        }

        public void getURL(String url) {
            driver.get(url);
        }


        public void openBlankTabbyJavaScript() {

            ((JavascriptExecutor) driver).executeScript("window.open('','_blank');");
        }

        public void switchToFA(String faWindow) {
            driver.switchTo().window(faWindow);
        }

        public void switchtoRequester(String requesterWin) {
            driver.switchTo().window(requesterWin);
        }

        public void switchtoAdmin(String adminWin) {
            driver.switchTo().window(adminWin);
        }

        public void switchToChatVolue(String chatVol) {
            driver.switchTo().window(chatVol);
        }

        public List<String> getTextList(String locator) {
            List<WebElement> elementList = new LinkedList<WebElement>();
            List<String> textList = new LinkedList<String>();
            elementList = driver.findElements(By.xpath(locator));
            for (WebElement element : elementList) {
                textList.add(element.getText());
            }
            return textList;
        }

        public void enterTextById(String locator, String value) {
            driver.findElement(By.id(locator)).sendKeys(value);
        }

        public void enterTextByXpath(String locator, String value) {
            driver.findElement(By.xpath(locator)).sendKeys(value);
        }

        public void clickWebElement(String locator) {

            driver.findElement(By.id(locator)).click();
        }

        public void clearWebElement(String locator) {
            driver.findElement(By.id(locator)).clear();
        }

        public void closePopUpWindow(String locator1, String locator2) {
            if (driver.findElement(By.xpath(locator1)).isDisplayed()) {
                driver.findElement(By.xpath(locator2)).click();
            }
        }

        public void enterTextByJavaScript() {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("document.getElementById('Creditamount').value = '.01';");
        }

        public void softTrue(Boolean val, String value) {
            SoftAssert soft = new SoftAssert();
            soft.assertTrue(val, value);
        }

        public void softFalse(Boolean val, String Value) {
            SoftAssert soft = new SoftAssert();
            soft.assertFalse(val, Value);
        }

        public void assertAll() {
            SoftAssert soft = new SoftAssert();
            soft.assertAll();
        }

        public void allAssert() {
            SoftAssert soft = new SoftAssert();
            soft.assertAll();
        }

        public void enterTextByXpathJs(String locator) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = '.02';", driver.findElement(By.xpath(locator)));
        }

        public void enterTextByJS(String locator, String value) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("document.getElementByID(locator).value = value;");
        }

        public void clickOnElement(String locator) {
            try {
                driver.findElement(By.cssSelector(locator)).click();
            } catch (Exception ex1) {
                try {
                    driver.findElement(By.xpath(locator)).click();
                } catch (Exception ex2) {
                    try {
                        driver.findElement(By.id(locator)).click();
                    } catch (Exception ex3) {
                        driver.findElement(By.name(locator)).click();
                    }
                }
            }
        }

        //type on input field located with cssSelector, xpath, id, or name
        public void typeOnInputField(String locator, String value) {
            try {
                driver.findElement(By.cssSelector(locator)).sendKeys(value);
            } catch (Exception ex1) {
                try {
                    driver.findElement(By.xpath(locator)).sendKeys(value);
                } catch (Exception ex2) {
                    try {
                        driver.findElement(By.id(locator)).sendKeys(value);
                    } catch (Exception ex3) {
                        driver.findElement(By.name(locator)).sendKeys(value);
                    }
                }
            }
        }

        //return the list of Web Elements located by locator
        public List<WebElement> getWebElementList(String locator) {
            List<WebElement> list = new ArrayList<WebElement>();
            try {
                list = driver.findElements(By.cssSelector(locator));
            } catch (Exception ex1) {
                try {
                    list = driver.findElements(By.xpath(locator));
                } catch (Exception ex2) {
                    try {
                        list = driver.findElements(By.id(locator));
                    } catch (Exception ex3) {
                        list = driver.findElements(By.name(locator));
                    }
                }
            }
            return list;
        }

        //find web elements, return the string list
        public List<String> getStringListFromWebElements(String locator) {
            List<WebElement> element = new ArrayList<WebElement>();
            List<String> text = new ArrayList<String>();
            element = getWebElementList(locator);
            for (WebElement web : element) {
                String st = web.getText();
                text.add(st);
            }
            return text;
        }

        public void typeOnCss(String locator, String value) {
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        }

        public void clickByXpath(String locator) {
            driver.findElement(By.xpath(locator)).click();
        }

        public void elementSize(String locator) {
//        driver.findElements(By.xpath(locator)).size() == 0;
        }

        public void typeByCss(String locator, String value) {
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        }

        public void typeByCssNEnter(String locator, String value) {
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        }

        public void typeByXpath(String locator, String value) {
            driver.findElement(By.xpath(locator)).sendKeys(value);
        }

        public void takeEnterKeys(String locator) {
            driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
        }

        public void clearInputByXpath(String locator) {
            driver.findElement(By.xpath(locator)).clear();
        }

        public void clearFieldById(String locator) {
            driver.findElement(By.id(locator)).clear();
        }

        public List<WebElement> getListOfWebElementsById(String locator) {
            List<WebElement> list = new ArrayList<WebElement>();
            list = driver.findElements(By.id(locator));
            return list;
        }

        public List<String> getTextFromWebElements(String locator) {
            List<WebElement> element = new ArrayList<WebElement>();
            List<String> text = new ArrayList<String>();
            element = driver.findElements(By.xpath(locator));
            for (WebElement web : element) {
                String st = web.getText();
                text.add(st);
            }
            return text;
        }


        //the upload will only work If the element you send a file should be in the form  <input type="file">
        public void uploadImage(String locator, String filepath) {
            WebElement uploadElement = driver.findElement(By.id(locator));
            // enter the file path onto the file-selection input field
//        uploadElement.sendKeys("C:\\Users\\malius932\\Documents\\ScreenShotsforTestingPurpose\\ByFixAgent-7-23-18.png");
            uploadElement.sendKeys(filepath);
        }

        public List<WebElement> getListOfWebElementsByCss(String locator) {
            List<WebElement> list = new ArrayList<WebElement>();
            list = driver.findElements(By.cssSelector(locator));
            return list;
        }

        public List<WebElement> getListOfWebElementsByXpath(String locator) {
            List<WebElement> list = new ArrayList<WebElement>();
            list = driver.findElements(By.xpath(locator));
            return list;
        }

        public String getCurrentPageUrl() {
            String url = driver.getCurrentUrl();
            return url;
        }

        public void navigateBack() {
            driver.navigate().back();
        }

        public void navigateForward() {
            driver.navigate().forward();
        }

        public void navigateRefresh() {
            driver.navigate().refresh();
        }

        public String getTextByCss(String locator) {
            String st = driver.findElement(By.cssSelector(locator)).getText();
            return st;
        }

        public String readProp(String key) throws IOException {
            InputStream fis = new FileInputStream("src.properties");
            Properties pro = new Properties();
            pro.load(fis);
            String value = pro.getProperty(key);
            return value;
        }

        public String readPass() throws IOException {
            InputStream fis = new FileInputStream("src.properties");
            Properties pro = new Properties();
            pro.load(fis);
            byte[] decodedPassword = Base64.decodeBase64(pro.getProperty("password").getBytes());
            String val = new String(decodedPassword);
            return val;
        }

        public static String decodePassword() {
            String pass = "cGFzUzIwMTA=";
            byte[] decodedPassword = Base64.decodeBase64(pass);
            return new String(decodedPassword);
        }

        public String readURL(String key) throws IOException {

            InputStream fis = new FileInputStream("url.properties");
            Properties pro = new Properties();
            pro.load(fis);
            String value = pro.getProperty(key);
            return value;

        }

        public String getTextByXpath(String locator) {
            String st = driver.findElement(By.xpath(locator)).getText();
            return st;
        }

        public String getTextById(String locator) {
            String text = driver.findElement(By.id(locator)).getText();
            return text;
        }

        public String getTextByName(String locator) {
            String st = driver.findElement(By.name(locator)).getText();
            return st;
        }

        public List<String> getListOfString(List<WebElement> list) {
            List<String> items = new ArrayList<String>();
            for (WebElement element : list) {
                items.add(element.getText());
            }
            return items;
        }

        public void selectOptionByVisibleText(String locator, String value) {
            Select select = new Select(driver.findElement(By.xpath(locator)));
            select.selectByVisibleText(value);
        }


        public static void sleepFor(int sec) throws InterruptedException {
            Thread.sleep(sec * 1000);
        }

        public void mouseHoverByCSS(String locator) {
            try {
                WebElement element = driver.findElement(By.cssSelector(locator));
                Actions action = new Actions(driver);
                Actions hover = action.moveToElement(element);
            } catch (Exception ex) {
                System.out.println("First attempt has been done, This is second try");
                WebElement element = driver.findElement(By.cssSelector(locator));
                Actions action = new Actions(driver);
                action.moveToElement(element).perform();

            }

        }

        public boolean checkVisibilityofElement(WebElement element) {
            try {
                element.isDisplayed();
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        public void windowsID() {
            Set<String> allWindows = driver.getWindowHandles();
            int windowsSize = allWindows.size();
            System.out.println("Nummber of Windows Open" + windowsSize);
            int i = 1;
            for (String window : allWindows) {
                System.out.println("Window id:" + i + window);
                i++;
            }
        }

        public void clickUntilDisappear() throws InterruptedException {
            for (int i = 0; i < 3; i++) {
                if (driver.findElements(By.xpath("//*[contains(text(),'Accept Next Ch')]")).size() > 0) {
                    driver.findElement(By.xpath("//*[contains(text(),'Accept Next Ch')]")).click();
                    waitUntilClickAble(By.xpath("//*[contains(@id,'ChatInstance_')]/div/div[2]/div[1]/div/table[2]/tbody/tr[2]/td[2]/span/span/span[2]/span"));
                    fluentWait("//*[contains(@id,'ChatInstance_')]/div/div[2]/div[1]/div/table[2]/tbody/tr[2]/td[2]/span/span/span[2]/span");
                    sleepFor(1);
                    clickByXpath("//*[contains(@id,'ChatInstance_')]/div/div[2]/div[1]/div/table[2]/tbody/tr[2]/td[2]/span/span/span[2]/span");
                    waitUntilClickAble(By.xpath("//li[text()='Invalid Request']"));
                    clickByXpath("//li[text()='Invalid Request']");
                    waitUntilClickAble(By.xpath("//*[@class='invalid']"));
                    clickByXpath("//*[@class='invalid']");
                }
            }
        }

        public void clickTillAcceptDisappear() throws InterruptedException {

//        Set<Integer> elem = driver.findElements(By.xpath("//*[contains(text(),'Accept Next Ch')]")).size();
            int ele = driver.findElements(By.xpath("//*[contains(text(),'Accept Next Ch')]")).size();
//        for(int i=0; i<ele.)
            if (driver.findElements(By.xpath("//*[contains(text(),'Accept Next Ch')]")).size() > 0) {
                driver.findElement(By.xpath("//*[contains(text(),'Accept Next Ch')]")).click();
                waitUntilClickAble(By.xpath("//*[contains(@id,'ChatInstance_')]/div/div[2]/div[1]/div/table[2]/tbody/tr[2]/td[2]/span/span/span[2]/span"));
                fluentWait("//*[contains(@id,'ChatInstance_')]/div/div[2]/div[1]/div/table[2]/tbody/tr[2]/td[2]/span/span/span[2]/span");
                sleepFor(1);
                clickByXpath("//*[contains(@id,'ChatInstance_')]/div/div[2]/div[1]/div/table[2]/tbody/tr[2]/td[2]/span/span/span[2]/span");
                waitUntilClickAble(By.xpath("//li[text()='Invalid Request']"));
                clickByXpath("//li[text()='Invalid Request']");
                waitUntilClickAble(By.xpath("//*[@class='invalid']"));
                clickByXpath("//*[@class='invalid']");
            }
        }

        public void useTabByAction() {
            Actions action = new Actions(driver);
            action.sendKeys(Keys.TAB).build().perform();
        }

        public void useCtrlAlt(String locator, String value) {
            driver.findElement(By.xpath(locator)).
                    sendKeys(Keys.chord(Keys.CONTROL, Keys.ALT, value), Keys.ENTER);
        }


//    public void mouseHoverByXpath(String locator) {
//        try {
//            WebElement element = driver.findElement(By.xpath(locator));
//            Actions action = new Actions(driver);
//            Actions hover = action.moveToElement(element);
//        } catch (Exception ex) {
//            System.out.println("First attempt has been done, This is second try");
//            WebElement element = driver.findElement(By.cssSelector(locator));
//            Actions action = new Actions(driver);
//            action.moveToElement(element).perform();
//
//        }
//
//    }

        public void mouseHoverByXpath(String locator) {
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(By.xpath(locator))).build().perform();

        }

        //handling Alert
        public void okAlert() {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }

        public void cancelAlert() {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }

        public void selectType(String locator, String value) {
            Select select = new Select(driver.findElement(By.id(locator)));
            select.selectByVisibleText(value);
        }

        public void selectByVisible(String locator, String value) {
            Select select = new Select(driver.findElement(By.xpath(locator)));
            select.selectByVisibleText(value);
        }

        public void selectByVisibleId(String locator, String value) {
            Select select = new Select(driver.findElement(By.id(locator)));
            select.selectByVisibleText(value);
        }

        //iFrame Handle
        public void iframeHandle(int index) {
            driver.switchTo().frame(index);
        }

        public void goBackToHomeWindow() {
            driver.switchTo().defaultContent();
        }

        //get Links
        public void getLinks(String locator) {
            driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
        }

        public int findNumberOfLinks() {
            int numOfLinks = driver.findElements(By.tagName("a")).size();
            return numOfLinks;
        }

        public static void captureScreenshot(WebDriver driver, String screenshotName) {
            DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
            Date date = new Date();
            df.format(date);

            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenshots/" + screenshotName + " " + df.format(date) + ".png"));
                System.out.println("Screenshot captured");
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }

        //Taking Screen shots
        public void takeScreenShot(String ssName) throws IOException {
            DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
            Date date = new Date();
            df.format(date);
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("src\\" + ssName + " " + new Date().getTime() + ".png"));
        }

        //Synchronization
        public void waitUntilClickAble(By locator) {
            WebDriverWait wait = new WebDriverWait(driver, 50);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        }

        public void waitTillClickable(By locator) {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        }

        public void waitUntilDisappear(By locator) {
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }

        public void waitUntilPopUpVisible(By locator) {
            WebDriverWait wait = new WebDriverWait(driver, 70);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        public void waitUntilVisible(By locator) {
            WebDriverWait wait = new WebDriverWait(driver, 50);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        public void waitUntilSelectable(By locator) {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            Boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
        }


        public void upLoadFile(String locator, String path) {
            driver.findElement(By.cssSelector(locator)).sendKeys(path);
        /* path example to upload a file/image
           path= "C:\\Users\\rrt\\Pictures\\ds1.png";
         */
        }

        public void clearInput(String locator) {
            driver.findElement(By.cssSelector(locator)).clear();
        }

        public void keysInput(String locator) {
            driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
        }

        public void fluentWait(final String locator) {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(30, TimeUnit.SECONDS)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);
            wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.xpath(locator));
                }
            });
        }

        public static void clickElementByJs(WebElement element) {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("arguments[0].click", element);
        }

        public void scrollByVisible(String locator) {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(locator)));

        }

        public void scrollDownByCordinator(String locator) {
            WebElement element = driver.findElement(By.xpath(locator));
            Coordinates coordinate = ((Locatable) element).getCoordinates();
            coordinate.inViewPort();
        }

        public void scrollDownByJs() {
            JavascriptExecutor jsx = (JavascriptExecutor) driver;
            jsx.executeScript("window.scrollBy(0,450)", "");
        }

        public static String convertToString(String st) {
            String splitString;
            splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
            return splitString;
        }

        //Handling New Tabs
        public static WebDriver handleNewTab(WebDriver driver1) {
            String oldTab = driver1.getWindowHandle();
            List<String> newTabs = new LinkedList<String>(driver1.getWindowHandles());
            //newTabs.remove(oldTab);
            driver1.switchTo().window(newTabs.get(1));
            return driver1;
        }

        public List<String> getTextLists(WebDriver driver, String locator) {
            List<WebElement> elementList = new ArrayList<WebElement>();
            List<String> textList = new ArrayList<String>();
            elementList = driver.findElements(By.cssSelector(locator));
            for (WebElement element : elementList) {
                textList.add(element.getText());
            }
            return textList;

        }

        public String getTitle(WebDriver driver1) {
            String title = driver1.getTitle();
            System.out.println(title);
            return title;
        }

        public static boolean isPopUpWindowDisplayed(WebDriver driver1, String locator) {
            boolean value = driver1.findElement(By.cssSelector(locator)).isDisplayed();
            return value;
        }

        public boolean isPopupWindowDisplayed(String locator) {
            boolean value = driver.findElement(By.xpath(locator)).isDisplayed();
            return value;
        }

        public void selectByIndex(String locator, int index) {
            Select select = new Select(driver.findElement(By.id(locator)));
            select.selectByIndex(index);
        }

        public void selectByIndexXpath(String locator, int index) {
            Select select = new Select(driver.findElement(By.xpath(locator)));
            select.selectByIndex(index);
        }

        public void clickById(WebDriver driver1, String locator) {
            driver1.findElement(By.id(locator)).click();
        }


        public void loadFullPage() throws InterruptedException {

            while (driver.findElement(By.xpath("//button[text()='LOAD MORE']")).isDisplayed()) {
                scrollDownByAction();
                driver.findElement(By.xpath("//button[text()='LOAD MORE']")).click();
            }

            if (driver.findElements(By.xpath("//button[text()='LOAD MORE']")).size() == 1) {
                System.out.println(driver.findElements(By.xpath("//button[text()='LOAD MORE']")).size());
                scrollByVisible("//button[text()='LOAD MORE']");
                waitUntilClickAble(By.xpath("//button[text()='LOAD MORE']"));
                sleepFor(1);
                driver.findElement(By.xpath("//button[text()='LOAD MORE']")).click();

            }
        }

        public void checkIfUserNameAlreadyExist() throws InterruptedException {

            if (driver.findElement(By.xpath("//td[text()='Chirla Venkata, Sasidhar Reddy']")).isDisplayed()) {
                scrollByVisible("//td[text()='Chirla Venkata, Sasidhar Reddy']");
                waitUntilClickAble(By.xpath("//td[text()='Chirla Venkata, Sasidhar Reddy']//following::td[4]/ul/li/a/i"));
                sleepFor(1);
                clickByXpath("//td[text()='Chirla Venkata, Sasidhar Reddy']//following::td[4]/ul/li/a/i");
                waitUntilClickAble(By.xpath("//td[text()='Chirla Venkata, Sasidhar Reddy']//following::td[4]/ul/li/ul/li[2]/a"));
                clickByXpath("//td[text()='Chirla Venkata, Sasidhar Reddy']//following::td[4]/ul/li/ul/li[2]/a");
                waitUntilClickAble(By.xpath("//*[@id=\"yesNoModal\"]/div/div/div[2]/button[2]"));
                clickByXpath("//*[@id=\"yesNoModal\"]/div/div/div[2]/button[2]");
            }
        }

        public void scrollDownByAction() {
            Actions action = new Actions(driver);
            action.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
        }

        public void clickUntilDisappears(String locator) {

            while (driver.findElement(By.xpath(locator)).isDisplayed()) {
                scrollDownByAction();
                driver.findElement(By.xpath(locator)).click();
            }
        }

//        public void passEncrypt() {
//            Encrypt enc = new Encrypt();
//            String password = "abcd123";
//            System.out.println("MD5" + enc.MD5(password));
//        }

        public void ifAvailableFaIs0() throws InterruptedException {
            String availAgent = driver.findElement(By.xpath("//*[@id=\"NumberOfAgentsAvailable\"]")).getText();
            if (availAgent.equalsIgnoreCase("0")) {
                waitUntilVisible(By.xpath("//*[@id='PopUpMessage']"));
                String popupMessage = driver.findElement(By.xpath("//*[@id='PopUpMessage']/div")).getText();
                waitUntilClickAble(By.xpath("//button[text()='Ok']"));
                sleepFor(1);
                clickByXpath("//button[text()='Ok']");
            }
        }

        public void codeCoverage() {
//        Viewing Code Coverage Results
//        ctrl+alt+f6
        }

        public WebElement waitForRefresh(By by) {
            return new WebDriverWait(driver, 30)
                    .until(ExpectedConditions.refreshed(
                            ExpectedConditions.elementToBeClickable(by)));
        }

        public void verifyAutoRefreshButton() throws InterruptedException {
            waitUntilVisible(By.xpath("//*[@id=\"body-wrapper\"]/section[2]/div/div/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[4]"));
            String b = getTextByXpath("//*[@id=\"body-wrapper\"]/section[2]/div/div/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[4]");
            String a = getTextByXpath("//*[@id=\"body-wrapper\"]/section[2]/div/div/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[4]");
            while (a.equalsIgnoreCase(b)) {
                sleepFor(1);
                b = getTextByXpath("//*[@id=\"body-wrapper\"]/section[2]/div/div/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[4]");
            }
        }

        public void typeAndEnter(String locator, String text) {
            driver.findElement(By.id(locator)).sendKeys(text, Keys.ENTER);
        }

        public void typeAndEnterXpath(String locator, String text) {
            driver.findElement(By.xpath(locator)).sendKeys("text", Keys.ENTER);
        }

        public void verify5Results() {
            if (driver.findElements(By.xpath("//*[@id=\"ChatHistoryDiv\"]/div/table/tbody/tr[5]/td[1]")).size() > 0) ;

        }

        public void arrowDownKey(By by) {
//        driver.findElement(by).sendKeys(Keys.DOWN, Keys.RETURN);
            driver.findElement(by).sendKeys(Keys.ARROW_DOWN);
        }

        public void pressEnterAfterPressDown(By by) {
            driver.findElement(by).sendKeys(Keys.RETURN);
        }

        public Boolean verifyWaitingChatOnDashboard() {
            Boolean booleam = driver.findElement(By.xpath("//div[text()='WAITING CHATS']")).isDisplayed();
            return booleam;
        }

        public void ifAcceptChatIsDispalyed() throws InterruptedException {
            if (driver.findElement(By.xpath("//a[text()='Accept Next Chat']")).isDisplayed()) {
                clickByXpath("//a[text()='Accept Next Chat']");
                waitUntilClickAble(By.xpath("//*[contains(@id,'CloseInvalidBtn_')]"));
                sleepFor(1);
                clickByXpath("//*[contains(@id,'CloseInvalidBtn_')]");
            }

        }

        public static String currentDate(){
            Date date = new Date();
            DateFormat df = new SimpleDateFormat("EEEE MMMM, dd yyyy");
            String strDate = df.format(date);
            return strDate;
        }
    }





