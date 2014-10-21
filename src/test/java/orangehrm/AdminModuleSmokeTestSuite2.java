package orangehrm;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AdminModuleSmokeTestSuite2 extends BaseTest {



        // -------------------Test Data----------------------
        String loginUsername = "admin";
        String loginPassword = "admin";
        Random random = new Random();
        int a = random.nextInt();
        String firstname = "Liju123242" + a;
        String lastname = "lal";
        String skillname = "Test Engineer" + a;
        String skilldesc = "Skill Desc";
        String jobTitle = "Test Analyst" + a;
        String jobDesc = "Software Test Engineer";
        String jobNotes = "Sample Notes";

        //Create an Object for Business Library
        BusinessLibrary blib = new BusinessLibrary();
        Utils util = new Utils();


        @Test
        public void verifyAdminCanAddEmp() {
            blib.login(loginUsername, loginPassword);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //-------------------Checkpoint-------------------------
            Assert.assertEquals("Welcome Admin", driver.findElement(By.id("welcome")).getText());
            blib.addEmp(firstname, lastname);
            blib.logout();
        }

        @Test
        public void verifyAdminCanAddSkills() throws InterruptedException {
            blib.login(loginUsername, loginPassword);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //-------------------Checkpoint-------------------------
            Assert.assertEquals("Welcome Admin", driver.findElement(By.id("welcome")).getText());
            blib.addSkills(skillname, skilldesc);
            blib.logout();
        }


        @Test
        public void verifyAdminCanAddJobTitles() {
            blib.login(loginUsername, loginPassword);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //-------------------Checkpoint-------------------------
            Assert.assertEquals("Welcome Admin", driver.findElement(By.id("welcome")).getText());
            blib.addJobTitle(jobTitle, jobDesc, jobNotes);
            blib.logout();
        }

    }

}
