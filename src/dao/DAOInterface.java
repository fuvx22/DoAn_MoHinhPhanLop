package dao;

import java.util.ArrayList;

public interface DAOInterface<T> {
	
	public boolean insert(T t);
	
	public boolean delete(T t);
	
	public boolean update(T t);
	
	public T selectById(int id);
	
	public ArrayList<T> getAll();

	public ArrayList<T> selectByCondition(String condition);
	
}
