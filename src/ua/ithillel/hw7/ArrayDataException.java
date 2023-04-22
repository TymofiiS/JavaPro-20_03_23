package ua.ithillel.hw7;

import java.text.MessageFormat;

public class ArrayDataException extends RuntimeException {
	
	private int rowInd;
	private int columnInd;
	
	public ArrayDataException(int row, int column) {
		rowInd = row;
		columnInd = column;
	}
	
	public String getMessage() {
		return MessageFormat.format(
				"Data in cell [ {0}, {1} ] is not Int type", 
				rowInd, 
				columnInd);
	}
}
