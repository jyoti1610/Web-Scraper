import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String urlToScrape = "https://www.1mg.com/all-diseases";

        try {
            // Step 1: Make an HTTP request and get the HTML content
            Document document = Jsoup.connect(urlToScrape).get();

            // Step 2: Extract disease names and details
            Elements diseaseElements = document.select(".style__inner-container___3BZU9 style__product-grid___3noQW style__padding-top-bottom-12px___1-DPF");

            for (Element diseaseElement : diseaseElements) {
                // Extract details
                String diseaseName = diseaseElement.select(".style__card-image___1oz_4").text();
                String overview = diseaseElement.select(".DiseaseList__overview").text();
                String keyfact = diseaseElement.select(".DiseaseList__keyfact").text();
                String symptoms = diseaseElement.select(".DiseaseList__symptoms").text();
                String causes = diseaseElement.select(".DiseaseList__causes").text();

                System.out.println("Disease Name: " + diseaseName);
                System.out.println("overview: " + overview);
                System.out.println("keyfact: " + keyfact);
                System.out.println("symptoms: " + symptoms);
                System.out.println("causes: " + causes);
                System.out.println("----------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
