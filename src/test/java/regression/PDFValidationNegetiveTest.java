package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.PDFUtilities;

public class PDFValidationNegetiveTest {
    WebDriver driver;
    String pdfPath;
    PDFUtilities pdfUtilities;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/lenovo/Desktop/Bheemesh_Resume.pdf");
        pdfPath = driver.getCurrentUrl();
        pdfUtilities = new PDFUtilities();

    }

    @Test
    public void pdfTest() throws Exception {

        System.out.println("hey i try open PDF File for you and located at >>>>>" + pdfPath);
        String pdfData = pdfUtilities.getPDFfiledata(pdfPath);
        System.out.println("hey iam here  PDF data >>>>>>>>>>>>");
        System.out.println(pdfData);
        Assert.assertFalse(pdfData.contains("HackThon123"));
        System.out.println("successfully asserted negitive case also");


    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }


}
