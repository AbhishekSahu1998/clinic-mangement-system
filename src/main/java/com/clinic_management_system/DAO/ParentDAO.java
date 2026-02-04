package com.clinic_management_system.DAO;

public interface ParentDAO<T> {

	public T insert(T t);

	public T update(T t);

	public T remove(T t);

	public T fetch();

}
