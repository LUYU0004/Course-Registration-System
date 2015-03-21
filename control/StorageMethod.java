package control;

import java.util.List;

public interface StorageMethod {
	public List readList(String fileName);
	public boolean writeList(String fileName, List list);
}
