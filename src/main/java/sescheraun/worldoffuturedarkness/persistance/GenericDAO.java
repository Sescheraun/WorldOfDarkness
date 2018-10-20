package sescheraun.worldoffuturedarkness.persistance;

import org.apache.logging.log4j.*;
import org.hibernate.Session;
import sescheraun.worldoffuturedarkness.generator.Critter;

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
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

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
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }
}
