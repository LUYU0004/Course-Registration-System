package control;

public class StorageMethodFactory {
	public static StorageMethod createStorageMethod(SystemConfig sysc){
		if (sysc.get("StorageMethod").equals("Serialize")){
			return new SerializeStorage();
		}
		else{
			// here return default storage method 
			return new SerializeStorage();
		}
	}
}
