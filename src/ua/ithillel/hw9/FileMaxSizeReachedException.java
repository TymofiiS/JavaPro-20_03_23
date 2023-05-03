package ua.ithillel.hw9;

public class FileMaxSizeReachedException extends RuntimeException {

	private FileLoggerConfiguration _loggerConfiguration;
	
	public FileMaxSizeReachedException(
			FileLoggerConfiguration loggerConfiguration) {
		_loggerConfiguration = loggerConfiguration;
	}
	
	public String getMessage() {
		return "Max file size: " + _loggerConfiguration.getMaxSizeInBites() +
				"; Current file size: " + _loggerConfiguration.getFile().length() +
				"; Path: " + _loggerConfiguration.getFile().getAbsolutePath();
	}
}
