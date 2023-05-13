package ua.ithillel.hw12.phonebook;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
	
	private List<Record> records;

	public Phonebook() {
		records = new ArrayList<>();
	}
	
	public void add(Record rec) {
		records.add(rec);
	}
	
	public Record find(String name) {	
		var res = findHelper(name,true);	
		return res.size() > 0 ? res.get(0) : null;
	}
	
	public List<Record> findAll(String name) {
		var res = findHelper(name,false);	
		return res.size() > 0 ? res : null;
	}
	
	public List<Record> findHelper(
			String name, boolean firstOnly) {
		
		var res = new ArrayList<Record>();
		
		for (var record : records) {
			
			if(!record.getName().equals(name)) 
				{continue;}
			
			 res.add(record.clone());
			 
			 if(firstOnly) break;
		}
		
		return res;
	}
	
}
