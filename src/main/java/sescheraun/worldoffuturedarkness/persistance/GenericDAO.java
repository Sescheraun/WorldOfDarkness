package sescheraun.worldoffuturedarkness.persistance;

import org.apache.logging.log4j.*;
import org.hibernate.Session;


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
