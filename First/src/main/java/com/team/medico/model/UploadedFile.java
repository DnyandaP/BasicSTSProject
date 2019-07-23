package com.team.medico.model;

import org.springframework.web.multipart.MultipartFile;

public class UploadedFile {    
    
	 private MultipartFile fileLicense;
	 private MultipartFile fileDegree;
	public MultipartFile getFileLicense() {
		return fileLicense;
	}
	public void setFileLicense(MultipartFile fileLicense) {
		this.fileLicense = fileLicense;
	}
	public MultipartFile getFileDegree() {
		return fileDegree;
	}
	public void setFileDegree(MultipartFile fileDegree) {
		this.fileDegree = fileDegree;
	}
	    
	   
}    