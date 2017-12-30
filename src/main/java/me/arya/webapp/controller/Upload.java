package me.arya.webapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

@WebServlet("/upload")
public class Upload extends HttpServlet {
	private static final Logger logger = Logger.getLogger("Upload");
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("Welcome doPost entered..");

		if (!ServletFileUpload.isMultipartContent(request)) {
			logger.error("Content type is not multipart/form-data");
			response.getWriter().print("Invalid request");
			return;
		}
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload uploader = new ServletFileUpload(factory);
		
		try {
			List<FileItem> parseRequest = uploader.parseRequest(request);
			for (FileItem fileItem : parseRequest) {
				if (!fileItem.isFormField()) {
					String contextPath = getServletContext().getRealPath("/");
					File uploadDir = new File (contextPath + "/tempfiles");
					if (!uploadDir.exists()) {
						uploadDir.mkdirs();
					}
					File uploadedFile = new File (uploadDir.getPath() + File.separator + fileItem.getName());
					logger.info("Uploading file: " + fileItem.getName() + " to " + uploadedFile.getAbsolutePath());
					fileItem.write(uploadedFile);
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}
}
