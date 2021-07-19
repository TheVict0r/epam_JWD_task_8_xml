package by.jwd.pravdivets.task8.xmlmobile.uploder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import by.jwd.pravdivets.task8.xmlmobile.constants.FilePaths;

public class FileUploader {

	private static Logger logger = LogManager.getLogger();

	public void saveFile(String fileType, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		final String path = request.getParameter("destination");
		final Part filePart = request.getPart("file");
		final String fileName = getFileName(filePart);

		String fullPath = path + fileName;
		savePath(fileType, fullPath);

		OutputStream out = null;
		InputStream filecontent = null;
		final PrintWriter writer = response.getWriter();

		try {
			out = new FileOutputStream(new File(path + File.separator + fileName));
			filecontent = filePart.getInputStream();

			int read;
			final byte[] bytes = new byte[1024];

			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			writer.println("New file " + fileName + " created at " + path);
			logger.info("File {0} being uploaded to {1}", new Object[] { fileName, path });

		} catch (FileNotFoundException fne) {
			writer.println("You either did not specify a file to upload or are "
					+ "trying to upload a file to a protected or nonexistent " + "location.");
			writer.println("<br/> ERROR: " + fne.getMessage());

			logger.error("Problems during file upload. Error: {0}", new Object[] { fne.getMessage() });
		} finally {
			if (out != null) {
				out.close();
			}
			if (filecontent != null) {
				filecontent.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
	}

	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		logger.info("Part Header = {0}", partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	private void savePath(String fileType, String path) {
		
		path = path.replace('\\', File.separatorChar);
		
		System.out.println(path);
		
		if ("XML".equals(fileType)) {
			FilePaths.fileName = path;
		} else if ("XSD".equals(fileType)) {
			FilePaths.shemaName = path;
		} else {
			logger.error("Wrong type of saved file. Only *.xml and *.xsd allowed.");
		}
	}

}
