package id.paulshipley.com.au.DynamicPDF.struts2;

import id.paulshipley.com.au.DynamicPDF.DynamicPDF;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

/**
 * The Class RefreshAction.
 * 
 * copyright Paul Shipley, Australia, 2011
 * 
 * @author Paul Shipley (pshipley@melbpc.org.au)
 * @version $Id: RefreshAction.java 22 2011-06-03 05:34:06Z paul $
 */
public class RefreshAction extends ActionSupport {
	/** The Dynamic PDF. */
	private static DynamicPDF dpdf = DynamicPDF.getInstance();

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The logger. */
	private Log log = LogFactory.getLog(getClass());

	/** The text. */
	private String text = "";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Action(value = "refresh", results = {
			@Result(name = "success", location = "/jsp/DynamicPDF.jsp"),
			@Result(name = "input", location = "/jsp/DynamicPDF.jsp") })
	public String execute() {
		// display page with text

		return SUCCESS;
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
	 * Sets the text.
	 * 
	 * @param text
	 *            the new text
	 */
	@RequiredStringValidator(message = "Please enter message")
	public void setText(String text) {
		this.text = text;
		log.info("set Text= " + text);

		try {
			dpdf.setText(text);

		} catch (Exception e) {
			log.error(e);
			log.error(Arrays.toString(e.getStackTrace()));
			addActionError(e.getMessage());
		}
	}
}
