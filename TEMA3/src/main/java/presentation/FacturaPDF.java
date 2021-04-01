package presentation;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * In this class are defined methods for generating PDF documents for 'factura' table from database
 * @author Diana Trifu
 *
 */
public class FacturaPDF {
	
	/**
	 * method for generating a PDF document in which an under-stock message is written
	 * @param i the number of the under-stock message
	 * @param nume the client's name
	 * @param produs the name of the product
	 */
	public static void stocInsuficient(int i, String nume, String produs) {
		try {
			String fileName = "stocInsuficient" + i +".pdf ";
			Document doc = new Document();
			PdfWriter.getInstance(doc, new FileOutputStream(fileName));
			doc.open();
			doc.add(new Paragraph());
			doc.add(new Paragraph(nume + "'s order cannot be registered because there are not enough pieces of " + produs + " in the warehouse at the moment"));
			doc.add(new Paragraph(" "));
			doc.add(new Paragraph("Thank you for understanding!"));
			doc.close();			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * method for generating a PDF document representing the bill for the order made by the client
	 * @param i the number of the bill
	 * @param nume the client's name
	 * @param produs the name of the product
	 * @param cantitate the number of pieces
	 * @param pret the price
	 */
	public static void facturare(int i, String nume, String produs, String cantitate, float pret) {
		try {
			String fileName = "factura" + i +".pdf ";
			Document doc = new Document();
			PdfWriter.getInstance(doc, new FileOutputStream(fileName));
			doc.open();
			doc.add(new Paragraph());
			doc.add(new Paragraph("It has been issued the bill with the number " + i));
			doc.add(new Paragraph(" "));
			doc.add(new Paragraph("Client " + nume + " has ordered " + cantitate + " piece/pieces of "+ produs));
			doc.add(new Paragraph(" "));
			doc.add(new Paragraph(" TOTAL: " + pret));
			doc.close();			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
