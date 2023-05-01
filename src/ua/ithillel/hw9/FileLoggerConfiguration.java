package ua.ithillel.hw9;

import java.io.File;

public class FileLoggerConfiguration{
	
	private String writeFormat;
	private File file;
	private LoggingLevel loggingLevel;
	private Integer maxSizeInBites;
	
	public FileLoggerConfiguration(
			File file,
			LoggingLevel loggingLevel,
			Integer maxSizeInBites,
			String writeFormat) {
		this.file = file;
		this.writeFormat = writeFormat;
		this.maxSizeInBites = maxSizeInBites;
		this.loggingLevel = loggingLevel;	
	}
	
	
	public File getFile() {
		// TODO Auto-generated method stub
		return file;
	}
	
	public LoggingLevel getLoggingLevel() {
		// TODO Auto-generated method stub
		return loggingLevel;
	}
	
	public Integer getMaxSizeInBites() {
		// TODO Auto-generated method stub
		return maxSizeInBites;
	}
	
	public String getWriteFormat() {
		// TODO Auto-generated method stub
		return writeFormat;
	}
	
	public static enum LoggingLevel{
		INFO, 
		DEBUG
	}
	
}
