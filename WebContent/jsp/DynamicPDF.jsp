<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java" errorPage=""%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="id.paulshipley.com.au.DynamicPDF.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	/*
	 * Dynamic PDF
	 *
	 * copyright Paul Shipley, Australia, 2011
	 * 
	 * @author Paul Shipley (pshipley@melbpc.org.au)
	 * @version $Id: DynamicPDF.jsp 32 2012-02-20 02:44:54Z paul $
	 */
%>

<html>
<head>
<title>Dynamic PDF</title>
<link rel="stylesheet" type="text/css" href="DynamicPDF.css" />
</head>

<body>
	<h1>
		Dynamic PDF
	</h1>

	<div class="error">
		<s:actionerror />
		&nbsp;
	</div>

	<div class="input">
		<s:form action="refresh" method="post">
			<div class="optional">
				<fieldset>
					<legend>Enter the text message to display</legend>
					<s:textfield label="Message" name="text" labelposition="left" />
					<s:submit type="button" method="execute" key="label.refresh" />
				</fieldset>
			</div>
		</s:form>
	</div>

	<div class="clear"></div>

	<!-- display PDF inline, refer
	      http://stackoverflow.com/questions/2104608/hiding-the-toolbars-surrounding-an-embedded-pdf
	      http://blogs.adobe.com/pdfdevjunkie/web_designers_guide
		  http://partners.adobe.com/public/developer/en/acrobat/PDFOpenParameters.pdf
		    -->
	<div class="pdfdisplay">
		<table>
			<tr>
				<td><iframe
						name="IframeName"
						src="/DynamicPDFServlet/pdf/<s:text name="text" />.pdf#toolbar=0&navpanes=0&scrollbar=0"
						width="420" height="594" style="border: 0px;">
						<p>IFrames not enabled!</p>
					</iframe>
				</td>
			</tr>
		</table>
	</div>

	<div class="clear"></div>
	<!-- s:debug / -->
</body>
</html>