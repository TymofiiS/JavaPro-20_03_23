package ua.ithillel.hw13;

public class FileData {

	private String name;
	private Integer size;
	private String path;
	
	public FileData(
			String name, 
			String path, 
			Integer size) {
		this.name = name;
		this.path = path;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public Integer getSize() {
		return size;
	}
	
	public String toString() {
		return path + name+ " (" + size + ")";
	}
}
