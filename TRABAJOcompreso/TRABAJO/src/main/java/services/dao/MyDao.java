package services.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import services.interfaces.ICRUD;
import util.JPAConexion;
import java.util.List;

public class MyDao<T> implements ICRUD<T> {

    // ----- GET ALL (usa NamedQuery tal como en las slides) -----
    @Override
    public <T> List<T> getALL(String nameQuery, Class<T> clazz) {
        EntityManager em = JPAConexion.getEntityManager();
        try {
            TypedQuery<T> query = em.createNamedQuery(nameQuery, clazz);
            return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    // ----- INSERT -----
    @Override
    public <T> void insert(T entity) {
        EntityManager em = JPAConexion.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    // ----- UPDATE -----
    @Override
    public <T> void update(T entity) {
        EntityManager em = JPAConexion.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    // ----- DELETE -----
    @Override
    public <T> void delete(T entity) {
        EntityManager em = JPAConexion.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(entity));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    // ----- FIND BY ID -----
    @Override
    public <T> T findById(Integer id, Class<T> clazz) {
        EntityManager em = JPAConexion.getEntityManager();
        try {
            T entity = em.find(clazz, id);
            return entity;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }
}
