package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload() {
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("/Users/iv_di/IdeaProjects/selenium-webdriver-java-framework/src/main/resources/drivers/chromedriver");
        assertEquals(uploadPage.getUploadedFiles(), "chromedriver", "Uploaded files incorrect");
    }
}
