package control;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class SerializeStorage implements StorageMethod {
	
	public List readList(String fileName) {

		List pDetails = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		
		try {
			fis = new FileInputStream(fileName);
			in = new ObjectInputStream(fis);
			pDetails = (ArrayList) in.readObject();
			in.close();
		} catch (IOException ex) {
			//ex.printStackTrace();
			return null;
		} catch (ClassNotFoundException ex) {
			//ex.printStackTrace();
			return null;
		}
		// print out the size
		//System.out.println(" Details Size: " + pDetails.size());
		//System.out.println();
		return pDetails;
	}

	public boolean writeList(String fileName, List list) {
		
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);
			out.writeObject(list);
			out.close();
			return true;
		//	System.out.println("Object Persisted");
		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
