package store.dao;

import java.util.List;

public interface DataAccess <TYPE>{
	
    public List<TYPE> getAll();
    public TYPE getItem(int key);
    public void update(TYPE item);
    public void delete(TYPE item);
    public void insert(TYPE item);
    
}
