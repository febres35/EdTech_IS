package cienciasucv.certicomp.Controllers;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfCreator {

	public static void createCertificate(String nameU, String courseN) {
		try {
			String outputPath = "certificado_"+courseN+"_"+nameU+".pdf";
			Document document = new Document(PageSize.A4.rotate(), 50, 50, 50, 50);
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputPath));
			nameU = "Vanesssa Valentina Silvera Gonzalez"; // Esto se quita, solo era para el ejemplo
			courseN = "Lenguaje de Programación Java: Nivel Básico"; // Esto se quita, solo era para el ejemplo
			document.open();

			Paragraph title1 = new Paragraph("UNIVERSIDAD CENTRAL DE VENEZUELA",
					FontFactory.getFont("Arial", 12, Font.NORMAL));
			Paragraph title2 = new Paragraph("FACULTAD DE CIENCIAS", FontFactory.getFont("Arial", 12, Font.NORMAL));
			Paragraph title3 = new Paragraph("ESCUELA DE COMPUTACION", FontFactory.getFont("Arial", 12, Font.NORMAL));
			title1.setAlignment(Element.ALIGN_CENTER);
			title2.setAlignment(Element.ALIGN_CENTER);
			title3.setAlignment(Element.ALIGN_CENTER);
			title3.setSpacingAfter(PageSize.A4.getWidth() / 4 - 20);
			document.add(title1);
			document.add(title2);
			document.add(title3);

			Paragraph name = new Paragraph(nameU.toUpperCase(), FontFactory.getFont("Times-Bold", 20));
			name.setAlignment(Element.ALIGN_CENTER);
			name.setSpacingAfter(20);
			document.add(name);

			Paragraph course = new Paragraph(
					"Recibe este certificado por haber finalizado con exito el examen de certificacion de:",
					FontFactory.getFont("Arial", 12));
			course.setAlignment(Element.ALIGN_CENTER);
			document.add(course);

			Paragraph course2 = new Paragraph(courseN, FontFactory.getFont("Times-Bold", 14));
			course2.setAlignment(Element.ALIGN_CENTER);
			course2.setSpacingAfter(PageSize.A4.getWidth() / 4 - 50);
			document.add(course2);

			Paragraph line = new Paragraph(
					"_______________                                                                                                                                                                  _______________",
					FontFactory.getFont("Arial", 12));
			line.setAlignment(Element.ALIGN_BOTTOM);
			document.add(line);

			Paragraph firma = new Paragraph(
					"Firma Docente                                                                                                                                                                              Firma Decano",
					FontFactory.getFont("Arial", 12));
			firma.setAlignment(Element.ALIGN_BOTTOM);
			document.add(firma);

			document.close();

		} catch (DocumentException | IOException e) {
			System.err.println("Error creating certificate: " + e.getMessage());
		}
	}
}