//package com.paladin.daos;
//
//import java.io.Serializable;
//import java.util.List;
//
//import org.hibernate.criterion.Criterion;
//import org.springframework.data.repository.CrudRepository;
//
//public interface GenericDAO<T, ID extends Serializable> extends CrudRepository<T, ID> {
//	
//	T findById(ID id, boolean lock);  
//	  
//    List<T> findAll(); 
//    
//    void delete(T entity);
//    
//    List<T> findByCriteria(Criterion... criterion);
//    
//    T findUniqueByCriteria(Criterion... criterion);
//    
//    void saveOrUpdate(T entity);
//
//}
