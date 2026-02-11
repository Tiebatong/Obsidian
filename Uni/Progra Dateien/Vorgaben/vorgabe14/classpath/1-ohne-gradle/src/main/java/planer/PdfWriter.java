package planer;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;

class PdfWriter {
    private PdfWriter() {
    }

    public static void writeToPdf(String outputFilename, SortedMap<Integer, String> personsPerWeek) {
        PDDocument document = new PDDocument();
        PDPage pdfPage = new PDPage();

        try (PDPageContentStream contentStream = new PDPageContentStream(document, pdfPage)) {
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 72.0f);

            document.addPage(pdfPage);
            addFormatting(contentStream);
            addHeading(contentStream);

            addPersonsToPlan(contentStream, personsPerWeek);

            contentStream.endText();
        } catch (IOException e) {
            System.out.println("Error while creating PDF");
            System.out.print(e.getMessage());
            return;
        }

        try {
            document.save(outputFilename);
            document.close();
        } catch (IOException e) {
            System.out.println("Error while saving document");
            System.out.print(e.getMessage());
        }
    }

    private static void addPersonsToPlan(PDPageContentStream contentStream, SortedMap<Integer, String> personsPerWeek) throws IOException {
        for (Map.Entry<Integer, String> entry : personsPerWeek.entrySet()) {
            Integer week = entry.getKey();
            String name = entry.getValue();
            addPersonToPlan(contentStream, week, name);
        }
    }

    private static void addHeading(PDPageContentStream contentStream) throws IOException {
        contentStream.showText("WG Putzplan");
        contentStream.setFont(PDType1Font.TIMES_ROMAN, (float) 16.0);
        contentStream.newLine();
    }

    private static void addFormatting(PDPageContentStream contentStream) throws IOException {
        contentStream.beginText();
        contentStream.setLeading(20f);
        contentStream.newLineAtOffset(25, 725);
    }

    private static void addPersonToPlan(PDPageContentStream contentStream, int weekNumber, String name) throws IOException {
        contentStream.showText("Woche " + weekNumber);
        contentStream.showText(" ");
        contentStream.showText(name);
        contentStream.newLine();
    }
}
