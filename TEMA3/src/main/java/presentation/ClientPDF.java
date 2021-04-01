package presentation;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import connection.ConnectionFactory;

/**
 * In this class are defined methods for generating a PDF document for 'client' table from database
 * @author Diana Trifu
 *
 */
public class ClientPDF {
	/**
	 * method for creating the SQL command for executing a query without conditions
	 * @return the SQL command
	 */
	private static String createClientQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT");
		sb.append(" * ");
		sb.append(" FROM ");
		sb.append(" client ");
		return sb.toString();
	}
	
	/**
	 * method for generating a PDF document containing the table 'client' from the database
	 * @param i the number of the report
	 */
	public static void query(int i) {
		String query = createClientQuery();
		try {
			String fileName = "raport_client" + i +".pdf ";
			Document doc = new Document();
			PdfWriter.getInstance(doc, new FileOutputStream(fileName));
			doc.open();
			doc.add(new Paragraph("'Client' table from the 'warehouse' data base"));
			doc.add(new Paragraph(" "));
			PdfPTable tab = new PdfPTable(3);
			tab.addCell(new PdfPCell(new Phrase("ID")));
			tab.addCell(new PdfPCell(new Phrase("NUME")));
			tab.addCell(new PdfPCell(new Phrase("ADRESA")));
			Connection connection = ConnectionFactory.createCon();
			PreparedStatement st = connection.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				tab.addCell(rs.getString("id"));
				tab.addCell(rs.getString("nume"));
				tab.addCell(rs.getString("adresa"));
			}
			doc.add(tab);
			doc.close();			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
