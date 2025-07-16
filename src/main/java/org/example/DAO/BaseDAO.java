package org.example.DAO;

import org.example.utils.DatabaseManager;

import javax.persistence.EntityManager;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public abstract class BaseDAO<T> {

        protected  EntityManager em;
        protected  Class<T> tClass;

        public BaseDAO(Class<T> tClass) {
            this.em = DatabaseManager.getEntityManager();
            this.tClass = tClass;
        }

        public T save (T element){
            try{
                em.getTransaction().begin();
                em.persist(element);
                em.getTransaction().commit();
                return element;
            }catch (Exception e){
                em.getTransaction().rollback();
                return null;
            }
        }

        public T get (long id){
            return em.find(tClass,id);
        }

        public boolean delete (long id){
            try{
                T elementFound = get(id);
                if(elementFound != null){
                    em.getTransaction().begin();
                    em.remove(elementFound);
                    em.getTransaction().commit();
                    return true;
                }
                return false;
            }catch (Exception e){
                em.getTransaction().rollback();
                return false;
            }
        }


    public T update(T entity) {
        return em.merge(entity);
    }


}
