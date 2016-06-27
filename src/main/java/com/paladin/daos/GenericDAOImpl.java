//package com.paladin.daos;
//
//import java.io.Serializable;
//import java.lang.reflect.ParameterizedType;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.hibernate.Criteria;
///**
// * Created by meghandow on 3/25/16.
// */
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.criterion.Criterion;
//import org.springframework.beans.factory.annotation.Autowired;
//
//@Transactional
//public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID>  {
//	
//	private Class<T> persistentClass;
//	
//	@Autowired
//    private SessionFactory sessionFactory;  
//  
//    @SuppressWarnings("unchecked")
//    public GenericDAOImpl() {  
//        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()  
//                                .getGenericSuperclass()).getActualTypeArguments()[0];  
//     }  
//  
//    protected Session getSession() {  
//        return sessionFactory.getCurrentSession();
//    }  
//  
//    public Class<T> getPersistentClass() {  
//        return persistentClass;  
//    }  
//  
//    @SuppressWarnings("unchecked")  
//    public T findById(ID id, boolean lock) {  
//        return (T) getSession().load(getPersistentClass(), id);  
//      }  
//  
//    public List<T> findAll() {  
//        return findByCriteria();  
//    } 
//    
//    public void saveOrUpdate(T entity) {
//        getSession().saveOrUpdate(entity);
//    }
//
//
//    public void delete(T entity) {
//        getSession().delete(entity);
//    }
//    
//    @SuppressWarnings("unchecked")
//	public List<T> findByCriteria(Criterion... criterion) {  
//        Criteria crit = getSession().createCriteria(getPersistentClass());  
//        for (Criterion c : criterion) {  
//            crit.add(c);  
//        }  
//        return crit.list();  
//   }
//    
//    @SuppressWarnings("unchecked")
//	public T findUniqueByCriteria(Criterion... criterion) {  
//        Criteria crit = getSession().createCriteria(getPersistentClass());  
//        for (Criterion c : criterion) {  
//            crit.add(c);  
//        }  
//        return (T) crit.uniqueResult();  
//   }
//
//	@Override
//	public <S extends T> S save(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends T> Iterable<S> save(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public T findOne(ID id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean exists(ID id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public Iterable<T> findAll(Iterable<ID> ids) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public long count() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void delete(ID id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void delete(Iterable<? extends T> entities) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAll() {
//		// TODO Auto-generated method stub
//		
//	}
//}