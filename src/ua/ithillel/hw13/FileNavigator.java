package ua.ithillel.hw13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FileNavigator {
	
	private HashMap<String, List<FileData>> filesData;

	public FileNavigator() {
		filesData = 
				new HashMap<String, List<FileData>>();
	}
	
	public List<FileData> filterBySize(Integer size){
		
		if(size == null) {return null;}
		
		var allFilesData = sortBySize();
		if(allFilesData == null) {return null;}
		
		var res = new ArrayList<FileData>();
		
		for (FileData data : allFilesData) {
			if(data.getSize() > size) {break;}
			res.add(data);
		}

		return res;
	}
	
	public List<FileData> sortBySize(){
		
		var res = new ArrayList<FileData>();
		var allFilesData = filesData.values();
		
		for (List<FileData> list : allFilesData) {
			for (FileData data : list) {
				res.add(data);
			}
		}
		
		if(res.size() == 0) {return null;}
		
		Collections.sort(res, (s1, s2) -> { 
			return s1.getSize().compareTo(s2.getSize()); 
		});
		
		return res;
	}
	
	public List<FileData> find(String path) {
		
		if(path == null) {return null;}
		
		var existingList = filesData.get(path);
		
		return existingList == null 
				? null 
				: existingList;
	}
	
	public void remove(String path) {
	
		if(path == null) {return;}
		
		filesData.remove(path);
	}

	public void add(String path, FileData fileData) {
		
		if(path == null) {return;}
		if(fileData == null) {return;}
		if(!fileData.getPath().equals(path)){
			System.out.println(
					fileData.getPath() + " and " + path +
					" must be the same. Operation canceled.");
			return;
		}
		
		add(fileData);
	}
	
	public void add(FileData fileData) {
		
		if(fileData == null) {return;}
		
		var path = fileData.getPath();
		if(path == null) {return;}
		
		filesData.computeIfAbsent(
				fileData.getPath(), k -> new ArrayList<>())
			.add(fileData);
	}
	
}
