package com.api.book.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;

//import java.io.FileOutputStream;
//import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class fileUploadHelper {

	
	//for static path in only my computer
//	public final String UPLOAD_DIR="C:\\Users\\Divyanshu\\Documents\\workspace-spring-tool-suite-4-4.16.1.RELEASE\\SpringCreatingapi\\src\\main\\resources\\static\\image";

	//for dynamic path for every computer
	public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();

	public fileUploadHelper()throws IOException
	{
		
	}
	
public boolean uploadFile(MultipartFile multipart) {
	boolean f =false; 
	try {

		Files.copy(multipart.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multipart.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		
		
		
//		 
//		InputStream is=file.getInputStream();
//		byte data[]=new byte[is.available()];
//		is.read();
//		
//		//write
//		FileOutputStream foi= new FileOutputStream(UPLOAD_DIR+"File.separator"+file.getOriginalFilename());
//		foi.write(data);
//		foi.flush();
//		foi.close();
	f=true;
	} catch (Exception e) {
		// TODO: handle exception
     e.printStackTrace();
	}
	return f;
}
}
