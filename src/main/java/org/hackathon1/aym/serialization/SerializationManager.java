package org.hackathon1.aym.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.hackathon1.aym.model.Organization;

public class SerializationManager {
	
	private static SerializationManager instance;
	private static final String SERIALIZATION_FOLDER = "sers/";
	
	public static SerializationManager getInstance() {
		if(instance == null)
			instance = new SerializationManager();
		return instance;
	}
	
	private SerializationManager() {
	}
	
	public void serializeObject(Object o,String fileName) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERIALIZATION_FOLDER+fileName));
			oos.writeObject(o);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Organization> deserializeListOfOrganizations(String fileName){
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SERIALIZATION_FOLDER+ fileName));
			List<Organization> organizations = (List<Organization>) ois.readObject();
			ois.close();
			return organizations;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
				
		
	}

}
