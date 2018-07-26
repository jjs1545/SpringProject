package com.example.myportal.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static String SAVE_PATH = "/upload"; /*: 실제 파일을 저장하는 위치*/
	
	// 저장 로직
	public String store(MultipartFile mFile) {
		// 저장
		// 저장된 파일의 이름을 리턴
		
		String saveFilename = "";
		// 1. china, japan, Korea의 파일명을 알파벳으로 변경하기 위함
		// 2. 같은 이름의 파일로 저장할 수 있는 상황이 발생할 수 있으므로 이름을 새로 저장한다. (중복x)
		
		try { 
			String originalFilename = mFile.getOriginalFilename();
			// Rename
			
			String extName = originalFilename.substring(	 //extName -> 확장자
					originalFilename.lastIndexOf("."),		 // ~.png or ~.jpg 등등 .뒤에 확장자를 제외하고 리네임 하기 위함
					originalFilename.length());
			
			Long size = mFile.getSize();		//파일 사이즈
			
			//파일명을 변경 (실제 저장할 파일명을 얻어오는 함수)
			saveFilename = getSaveFilename(extName);
			
			//파일을 저장
			writeFile(mFile, saveFilename);		// 멀티파트 파일을 변경한 이름으로 저장
		}catch(IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		
		return saveFilename;
	}
	
	public String getSaveFilename(String extName) {
		//시스템의 시간을 초로 변환하여 이름으로 부여
		Calendar cal = Calendar.getInstance();
		String newFilename = String.valueOf(cal.getTimeInMillis( )/ 1000) + extName.toLowerCase(); 
		/* : 시스템의 시간을 초로 변환하여 이름으로 부여하고 확장자를 소문자로 변환한다*/
		
		return newFilename;
	}
	
	// 파일 저장 로직
	private void writeFile(MultipartFile mFile, String saveFilename) throws IOException {
		//mFile 스트링으로 저장
		byte[] fileData = mFile.getBytes();	//스트림을 열어 저장한다.
		
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFilename);		// 저장위치를 지정한다.
		fos.write(fileData);
		fos.close();
 	}
}
