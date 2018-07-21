package com.example.blogReadMale.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	/*파일은 C드라이브의 Logo 폴더에 저장됩니다.*/
	private static String SAVE_PATH="/Logo";
	//private static String SAVE_PATH="/Lb";
	
	public String save(MultipartFile file) {
		String fileName="";
		
		try {
			String originalFilename = file.getOriginalFilename();
			String extensionName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());	//파일 확장자 저장
			Long size = file.getSize();
			fileName = getSaveFilename(extensionName);	// 파일명을 변경한다.
			writeFile(file,fileName);
		}catch(IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return fileName;
	}
	
	/*시스템의 시간을 초로 변환하여 이름으로 부여*/
	public String getSaveFilename(String extensionName) {
		Calendar cal = Calendar.getInstance();
		String fileName = String.valueOf(cal.getTimeInMillis()/1000 + extensionName.toLowerCase());
		return fileName;
	}
		
	private void writeFile(MultipartFile file, String fileName) throws IOException {
		byte[] fileData = file.getBytes();	// 스트림을 열어 file을 스트링으로 저장
		
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + fileName);
		fos.write(fileData);
		fos.close();
	}
}
