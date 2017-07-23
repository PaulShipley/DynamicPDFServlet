package id.paulshipley.com.au.DynamicPDF;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The Class PdfServlet.
 * 
 * see iText in Action, Second Edition, Creating a PDF from a servlet, page 284
 *       http://itextpdf.com/book/chapter.php?id=9
 * 
 * @author Paul Shipley (pshipley@melbpc.org.au)
 * @version $Id: PdfServlet.java 32 2012-02-20 02:44:54Z paul $
 */
public class PdfServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The logger. */
	private Log log = LogFactory.getLog(getClass());

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/pdf");
		try {
			DynamicPDF dpdf = DynamicPDF.getInstance();
			dpdf.setOs(response.getOutputStream());
			dpdf.makePDF();
			log.info(dpdf.toString());

		} catch (Exception e) {
			log.error(e);
			log.error(Arrays.toString(e.getStackTrace()));
		}
	}
}