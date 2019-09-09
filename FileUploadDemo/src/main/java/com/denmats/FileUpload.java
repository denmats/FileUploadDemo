package com.denmats;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;


public class FileUpload extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> multifiles = sf.parseRequest(request);
			
			for(FileItem item: multifiles) {
				item.write(new File("C:\\Users\\Denys\\git\\fileUpload\\FileUploadDemo\\src\\main\\java\\com\\denmats\\"+item.getName()));
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("File upload");
	}

}
