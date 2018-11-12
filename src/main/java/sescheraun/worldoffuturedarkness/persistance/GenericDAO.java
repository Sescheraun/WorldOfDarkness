package sescheraun.worldoffuturedarkness.persistance;

import org.apache.logging.log4j.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sescheraun.worldoffuturedarkness.generator.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;


/**
 * The type Generic dao.
 *
 * @param <T> the type parameter
 */
public class GenericDAO<T> {
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new Generic dao.
     *
     * @param type the entity type
     */
    public GenericDAO(Class<T> type) {
        this.type = type;
    }


    /**
     * Sets up and returns the session for hibernate to use.
     *
     * @return the session
     */
    private Session getSession() { return SessionFactoryProvider.getSessionFactory().openSession();  }

/* ********************************************************************************************************************/
/*                                                   Create Methods                                                   */
/* ********************************************************************************************************************/

    /**
     * Create entity int.
     *
     * @param critter the critter
     * @return the int
     */
    public int create(T entity){
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

/* ********************************************************************************************************************/
/*                                                    Read Methods                                                    */
/* ********************************************************************************************************************/
    /**
     * Gets a list of entities.
     *
     * @return the list
     */
    public List<T> getAll(){
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);

        Root<T> root = query.from(type);

        Expression<Boolean> isDeleted = root.get("isDeleted");
        query.select(root).where(builder.isFalse(isDeleted));

        List<T> entities = session.createQuery(query).getResultList();
        session.close();
        return entities;
    }

    /**
     * Get by id t.
     *
     * @param <T> the type of entity
     * @param id  the id
     * @return the entity that was searched for.
     */
    public <T>T getByID(int id){
        logger.debug("Inside: type = " + type);
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

    /**
     * Gets entity by.
     *
     * @param field the field
     * @param value the value
     * @return the entity by
     */
    public List<T> getEntityBy(String field, String value) {

        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);

        Root<T> root = query.from(type);


        Expression<Boolean> isDeleted = root.get("isDeleted");

        Expression<String> propertyPath = root.get(field);
        query.select(root).where(builder.like(propertyPath, "%" + value + "%"), builder.isFalse(isDeleted));

        List<T> entities = session.createQuery(query).getResultList();
        session.close();

        return entities;
    }

    /**
     * Gets entity by.
     *
     * @param field the field
     * @param value the value
     * @return the entity by
     */
    public List<T> getEntityByEqual(String field, String value) {

        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);

        Root<T> root = query.from(type);


        Expression<Boolean> isDeleted = root.get("isDeleted");

        Expression<String> propertyPath = root.get(field);
        query.select(root).where(builder.equal(propertyPath, value), builder.isFalse(isDeleted));

        List<T> entities = session.createQuery(query).getResultList();
        session.close();

        return entities;
    }

    /**
     * Gets a list of entities.
     *
     * @return the list
     */
    public List<T> getDeleted(){
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);

        Root<T> root = query.from(type);

        Expression<Boolean> isDeleted = root.get("isDeleted");
        query.select(root).where(builder.isTrue(isDeleted));

        List<T> entities = session.createQuery(query).getResultList();
        session.close();

        return entities;
    }

/* ********************************************************************************************************************/
/*                                                  Delete Methods                                                    */
/* ********************************************************************************************************************/

    /**
     * Update critter.
     *
     * @param entity the entity to be altered
     */
    public void update(T entity){
        Session session = getSession();

        session.beginTransaction();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
        session.close();
    }


//    /**
//     * Undelete an entity
//     *
//     * @param id the id
//     */
//    public void undelete(int id){
//        T  entityToDelete = getByID(id);
//        entityToDelete.setIsDeleted(false);
//        update(entityToDelete);
//    }

/* ********************************************************************************************************************/
/*                                                  Delete Methods                                                    */
/* ********************************************************************************************************************/
//    /**
//     * Delete an entity
//     *
//     * @param id the id
//     */
//    public void delete(int id){
//        T  entityToDelete = getByID(id);
//        entityToDelete.setIsDeleted(true);
//        update(entityToDelete);
//    }

}
