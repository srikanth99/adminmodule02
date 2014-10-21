package orangehrm;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BusinessLibrary extends BaseClass {



        public void login(String loginUsername, String loginPassword) {
            //------------------Login--------------------------
            //Enter username into username textbox
            WebElement username = driver.findElement(By.id("txtUsername"));
            username.sendKeys(loginUsername);

            //Enter the password into the password textbox
            WebElement pwd = driver.findElement(By.id("txtPassword"));
            pwd.sendKeys(loginPassword);

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

        public void addEmp(String firstname, String lastname) {
            //-----------------Add an Employee-------------------
            driver.findElement(By.id("menu_pim_viewPimModule")).click();

            driver.findElement(By.id("btnAdd")).click();
            driver.findElement(By.id("firstName")).sendKeys(firstname);
            driver.findElement(By.id("lastName")).sendKeys(lastname);
            driver.findElement(By.id("btnSave")).click();

            //Checkpoint (Verifying the Successfully Saved Message is displayed or not)
            Assert.assertTrue(driver.findElement(By.id("profile-pic")).getText().contains(firstname));
        }

        public void addSkills(String skillname, String skilldesc) {
            //--------------Add Skills-----------------------------
            driver.findElement(By.id("menu_admin_viewAdminModule")).click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.findElement(By.id("menu_admin_Qualifications")).click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.findElement(By.id("menu_admin_viewSkills")).click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            driver.findElement(By.id("btnAdd")).click();
            driver.findElement(By.id("skill_name")).sendKeys(skillname);
            driver.findElement(By.id("skill_description")).sendKeys(skilldesc);
            driver.findElement(By.id("btnSave")).click();
            //Checkpoint (Verifying the Successfully Saved Message is displayed or not)
            Assert.assertTrue(driver.findElement(By.cssSelector("body")).getText().contains("Successfully Saved"));
        }

        public void addJobTitle(String jobTitle, String jobDesc, String jobNotes) {
            //------------Add jobTitle-------------------
            driver.findElement(By.id("menu_admin_viewAdminModule")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.id("menu_admin_Job")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.id("menu_admin_viewJobTitleList")).click();

            driver.findElement(By.id("btnAdd")).click();
            driver.findElement(By.id("jobTitle_jobTitle")).sendKeys(jobTitle);
            driver.findElement(By.id("jobTitle_jobDescription")).sendKeys(jobDesc);
            driver.findElement(By.id("jobTitle_note")).sendKeys(jobNotes);

            driver.findElement(By.id("btnSave")).click();

            //Checkpoint (Verifying the Successfully Saved Message is displayed or not)
            Assert.assertTrue(driver.findElement(By.cssSelector("body")).getText().contains("Successfully Saved"));

        }
    }


}