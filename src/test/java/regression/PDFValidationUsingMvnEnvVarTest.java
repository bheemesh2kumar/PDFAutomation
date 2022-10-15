package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.PDFUtilities;

import java.util.Properties;

public class PDFValidationUsingMvnEnvVarTest {
    WebDriver driver;
    String pdfPath;
    PDFUtilities pdfUtilities;

    @BeforeMethod
    public void setup() throws Exception {

        Properties properties = new Properties();
        properties.load(PDFValidationUsingMvnEnvVarTest.class.getClassLoader().
                getResourceAsStream("config.properties"));
        String pathway = properties.getProperty("path");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(pathway);
        pdfPath = driver.getCurrentUrl();
        pdfUtilities = new PDFUtilities();

    }

    @Test
    public void pdfTest() throws Exception {

        System.out.println("hey i try open PDF File for you and located at >>>>>" + pdfPath);
        String pdfData = pdfUtilities.getPDFfiledata(pdfPath);
        System.out.println("hey iam here  PDF data >>>>>>>>>>>>");
        System.out.println(pdfData);
        Assert.assertTrue(pdfData.contains("HackThon"));


    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }


}
