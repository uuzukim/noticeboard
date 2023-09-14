package kr.or.ddit.servlet05;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;

/**
 * FileAdapter - FileWrapper
 * Adapter[Wrapper] pattern
 *  : wrapping 구조를 이용해서 adaptee 에 없는 추가 인터페이스를 구현.
 *
 */
public class FileAdapter extends File implements Serializable, WebResource{

	public FileAdapter(File adaptee, ServletContext application) throws IOException {
		super(adaptee.getCanonicalPath());
		this.clzValue = adaptee.isDirectory() ? "dir" : "file";
		int contextPathLength = application.getRealPath("/").length();
		this.logicalPath = adaptee.getCanonicalPath().substring(contextPathLength-1)
								.replace(File.separator, "/");
		this.mimeType = application.getMimeType(getName());
		
	}
	private String mimeType;
	private String clzValue;
	private String logicalPath;
	
	public String getFancySize() {
		return FileUtils.byteCountToDisplaySize(length());
	}	
	public long getSize() {
		return length();
	}
	
	public String getMimeType() {
		return mimeType;
	}
	public String getClzValue() {
		return clzValue;
	}
	
	@Override
	public String getContextRelativePath() {
		return logicalPath;
	}
	
	public String getLogicalPath() {
		return logicalPath;
	}
	
	@Override
	public String toString() {
		return "FileAdapter [name=" + getName() + ", clzValue=" + clzValue + ", logicalPath=" + logicalPath + "]";
	}
	
	
}












