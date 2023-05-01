package ua.ithillel.hw9;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;

import ua.ithillel.hw7.ArrayDataException;

public class FileLogger {

	public FileLogger(
			FileLoggerConfiguration loggerConfiguration) {
		_config = loggerConfiguration;		
	}
	
	public void debug(String data) {
		helper("DEBUG", data);
	};
	
	public  void info(String data) {
		helper("INFO", data);
	};
	
	private void helper(String name, String data) {
		String str =  
				LocalDateTime.now() + " " +
				name + " " +
				_config.getWriteFormat() + ": " +
				data + '\n';
		try {
			write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void write(String messageLine) throws IOException {
		Writer output;
		String file_name = 
				_config.getFile().getAbsolutePath();
		
		output = new BufferedWriter(new FileWriter(file_name, true));
		output.append(messageLine);
		output.close();
		
		if(_config.getFile().length() >= _config.getMaxSizeInBites())
		{throw new FileMaxSizeReachedException(_config);}
	}
	
	private FileLoggerConfiguration _config;
}
