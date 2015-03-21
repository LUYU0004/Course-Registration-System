package control;

import java.util.List;

public class StorageManager {
	private StorageMethod storageMethod;
	private SystemConfig config;
	
	public StorageManager(SystemConfig sysc){
		config=sysc;
		storageMethod=StorageMethodFactory.createStorageMethod(config);
	}
	
	public void store(String fileNameKey,List ls){
		String fileName=config.get(fileNameKey);
		storageMethod.writeList(fileName, ls);
	}
	
	public List read(String fileNameKey){
		String fileName=config.get(fileNameKey);
		return storageMethod.readList(fileName);
	}
}
