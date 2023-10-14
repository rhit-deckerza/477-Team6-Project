package net.sf.jftp.net.error;

public class UploadError extends Error {

	public int LargeFilesize() {
		getErrorType();
		return -100;
	}
	@Override
	public String getErrorType() {
		// TODO Auto-generated method stub
		return "Upload Error";
	}
	
}