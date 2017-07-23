package id.paulshipley.com.au.DynamicPDF;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * The Class DynamicPDF.
 * 
 * see iText in Action, Second Edition, Creating a PDF from a servlet, page 284
 *       http://itextpdf.com/book/chapter.php?id=9
 * 
 * @author Paul Shipley (pshipley@melbpc.org.au)
 * @version $Id: DynamicPDF.java 32 2012-02-20 02:44:54Z paul $
 */
public class DynamicPDF {
	/** The Constant INSTANCE. */
	private static final DynamicPDF INSTANCE = new DynamicPDF();
	
	/** The Output Stream. */
	private OutputStream os = System.out;

	/** The text to display. */
	private String text = "";

	/**
	 * Instantiates a new Dynamic PDF.
	 */
	private DynamicPDF() {
		super();
	}

	/**
	 * Gets the single instance of DynamicPDF.
	 * 
	 * @return single instance of DynamicPDF
	 */
	public static DynamicPDF getInstance() {
		return INSTANCE;
	}

	/**
	 * Sets the output stream.
	 *
	 * @param os the new os
	 */
	public void setOs(OutputStream os) {
		this.os = os;
	}

	/**
	 * Gets the output stream.
	 * 
	 * @return the os
	 */
	public OutputStream getOs() {
		return os;
	}

	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the text.
	 * 
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Make pdf.
	 * 
	 * @throws DocumentException
	 *             the document exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void makePDF() throws DocumentException, IOException {
		BaseColor COLOR = BaseColor.BLACK;
		Font NORMAL = new Font(FontFamily.HELVETICA, 36);
		NORMAL.setColor(COLOR);

		// create new document
		Rectangle PAGESIZE = new Rectangle(PageSize.A4);
		Document document = new Document();
		document.setPageSize(PAGESIZE);

		PdfWriter writer = PdfWriter.getInstance(document, getOs());
		writer.setPdfVersion(PdfWriter.VERSION_1_3);

		document.open();
		document.addAuthor("Paul Shipley");
		document.addCreationDate();
		document.addCreator("iText library");
		document.addTitle("Dynamic PDF Servlet");

		Phrase title = new Phrase(getText(), NORMAL);
		document.add(title);

		// complete and close document
		document.close();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DynamicPDF [os=" + os + ", text=" + text + "]";
	}

	/**
	 * Test stub main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("test.pdf");
			
			DynamicPDF dpdf = DynamicPDF.getInstance();
			dpdf.setOs(os);
			dpdf.setText("Hello world");
			dpdf.makePDF();
			System.out.println(dpdf.toString());

		} catch (Exception e) {
			e.printStackTrace();

		}

		System.exit(0);
	}
}
