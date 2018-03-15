package org.kipres.www.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.kipres.www.domain.Path;
import org.kipres.www.service.UploadFileException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class UtilFile {
	//단일파일 업로드
		public Path singleUploadFile(MultipartHttpServletRequest request, String classNum, String type){
			//호스팅
			/*String rootPath = "/home/hosting_users/kis0488/tomcat/webapps/survey/resources/files/"+classNum+"/";*/
			
			//로컬
			String rootPath = "C:\\Users\\202\\Desktop\\uploadFile\\"+classNum+"\\";
			System.out.println("rootPath 값: " + rootPath);
			if(type.equals("notice")) {
				Path resultPath = uploadFile(request.getFile("noticeFile"), rootPath, 1, classNum);
				System.out.println("resultPath 값 : " + resultPath);
				return resultPath;
			} else if(type.equals("reference")) {
				return uploadFile(request.getFile("refFile"), rootPath, 2, classNum);
			} else if(type.equals("thesis")) {
				return uploadFile(request.getFile("thFile"), rootPath, 3, classNum);
			} else if(type.equals("gallery")){
				return uploadFile(request.getFile("galFile"), rootPath, 4, classNum);
			} else {
				throw new UploadFileException();
			}
		}
		
		
		//파일업로드 메소드 (DTO반환)
		private Path uploadFile(MultipartFile multipartFile, String rootPath, int type, String path){
			Path uploadFile = new Path();
			try {
				String originalName = multipartFile.getOriginalFilename(); //원래 파일명
				int index = originalName.lastIndexOf("."); //확장자 구분을 위한 (.)인덱스 찾기
				String extension = "."+originalName.substring(index+1); //. 뒤의 확장자를 저장.일단안씀
				String subExtension = originalName.substring(0, index); // 확장자 제거 한 파일명
		        subExtension = UUID.randomUUID().toString().replaceAll("-", "");//확장자 제거한 파일명으로 랜덤파일명 생성
		        String fileNamePlus = subExtension + extension; // 랜덤파일명에 확장자 추가
		        String savePath = rootPath + fileNamePlus;
		        File destFile = new File(savePath); //최종파일을 업로드 패쓰에 업로드
		        multipartFile.transferTo(destFile);
		        uploadFile.setFilePath(path);
		        uploadFile.setFileName(originalName);
		        uploadFile.setFileRandomName(subExtension);
		        uploadFile.setFileType(type);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return uploadFile;
		}
		//파일 삭제
		public boolean deleteImage(String path){
			File destFile = new File(path);
			boolean result = destFile.delete();
			return result;
		}
}
