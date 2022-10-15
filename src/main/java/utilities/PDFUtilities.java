package utilities;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

public class PDFUtilities {


    public String getPDFfiledata(String path) {
        try {

            URL url = new URL(path);
            InputStream inputStream = url.openStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            PDDocument pdDocument = null;
            pdDocument = PDDocument.load(bufferedInputStream);
            String pdfText = new PDFTextStripper().getText(pdDocument);
            return pdfText;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }


}
