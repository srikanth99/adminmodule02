package orangehrm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class AdminModuleSmokeTestSuite {


            //Create a Firefox WebDriver Object
        static WebDriver driver;

        @Before
        public void startBrowser() {
            driver = new FirefoxDriver();
            //opening the Firefox Browser
            driver.get("http://demo.orangehrmlive.com/");
            //Maximise he Window
            driver.manage().window().maximize();
            //Wait for page to load
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }

        @After
        public void stopBrowser() {
            //Killing the Driver object
            driver.quit();
        }


        public void login() {
            //------------------Login--------------------------
            //Enter username into username textbox
            WebElement username = driver.findElement(By.id("txtUsername"));
            username.sendKeys("admin");

            //Enter the password into the password textbox
            WebElement pwd = driver.findElement(By.id("txtPassword"));
            pwd.sendKeys("admin");

            //Click on the loging button
            WebElement login = driver.findElement(By.id("btnLogin"));
            login.click();
        }

        public void logout() {
            //logout
            driver.findElement(By.id("welcome")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.linkText("Logout")).click();
        }

        public void addEmp() {
            //-----------------Add an Employee-------------------

            driver.findElement(By.id("menu_pim_viewPimModule")).click();
            driver.findElement(By.id("btnAdd")).click();
            driver.findElement(By.id("firstName")).sendKeys("Liju12300");
            driver.findElement(By.id("lastName")).sendKeys("lal");
            driver.findElement(By.id("btnSave")).click();
            //Checkpoint (Verifying the Successfully Saved Message is displayed or not)
            Assert.assertTrue(driver.findElement(By.id("profile-pic")).getText().contains("Liju12300"));
        }

        private void addSkills() {
            //--------------Add Skills-----------------------------

            driver.findElement(By.id("menu_admin_viewAdminModule")).click();
            driver.findElement(By.id("menu_admin_Qualifications")).click();
            driver.findElement(By.id("menu_admin_viewSkills")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.id("btnAdd")).click();
            driver.findElement(By.id("skill_name")).sendKeys("SkillName");
            driver.findElement(By.id("skill_description")).sendKeys("Skill Desc");
            driver.findElement(By.id("btnSave")).click();

            //Checkpoint (Verifying the Successfully Saved Message is displayed or not)
            Assert.assertTrue(driver.findElement(By.cssSelector("body")).getText().contains("Successfully Saved"));
        }

        public void addJobTitle() {
            //------------Add jobTitle-------------------

            driver.findElement(By.id("menu_admin_viewAdminModule")).click();
            driver.findElement(By.id("menu_admin_Job")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
            driver.findElement(By.id("btnAdd")).click();

            driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("JOb Title Name");
            driver.findElement(By.id("jobTitle_jobDescription")).sendKeys("Job Desc details");
            driver.findElement(By.id("jobTitle_note")).sendKeys("JObTitle Notes");

            driver.findElement(By.id("btnSave")).click();
            //Checkpoint (Verifying the Successfully Saved Message is displayed or not)
            Assert.assertTrue(driver.findElement(By.cssSelector("body")).getText().contains("Successfully Saved"));

        }

        @Test
        public void verifyAdminCanAddEmp() {
            this.login();
            //-------------------Checkpoint-------------------------
            Assert.assertEquals("Welcome Admin", driver.findElement(By.id("welcome")).getText());
            this.addEmp();
            this.logout();
        }

        @Test
        public void verifyAdminCanAddSkills() {
            this.login();
            //-------------------Checkpoint-------------------------
            Assert.assertEquals("Welcome Admin", driver.findElement(By.id("welcome")).getText());
            this.addSkills();
            this.logout();
        }


        @Test
        public void verifyAdminCanAddJobTitles() {
            this.login();
            //-------------------Checkpoint-------------------------
            Assert.assertEquals("Welcome Admin", driver.findElement(By.id("welcome")).getText());
            this.addJobTitle();
            this.logout();
        }

    }

}
