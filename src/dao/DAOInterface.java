package dao;

import java.util.ArrayList;

public interface DAOInterface<T> {
	
	public boolean insert(T t);
	
	public boolean delete(T t);
	
	public boolean update(T t);
	
	public T selectById(T t);
	
	public ArrayList<T> getAll();

	public T selectByCondition(String con);
	
}
