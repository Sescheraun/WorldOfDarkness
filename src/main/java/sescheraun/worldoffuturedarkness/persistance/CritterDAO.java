package sescheraun.worldoffuturedarkness.persistance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
import java.util.List;
import sescheraun.WorldOfFutureDarkness.generator.*;
import sescheraun.worldoffuturedarkness.generator.Critter;

public class CritterDAO {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get all critters list.
     *
     * @return the list
     */
    public List<Critter>  getAllCritters(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Critter> query = builder.createQuery(Critter.class);
        Root<Critter> root = query.from(Critter.class);

        Expression<Boolean> isDeleted = root.get("isDeleted");
        query.select(root).where(builder.isFalse(isDeleted));

        List<Critter> critters = session.createQuery(query).getResultList();
        session.close();



        return critters;
    }

    /**
     * Gets critter by.
     *
     * @param field the field
     * @param value the value
     * @return the critter by
     */
    public List<Critter> getCritterBy(String field, String value) {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Critter> query = builder.createQuery(Critter.class);
        Root<Critter> root = query.from(Critter.class);


        Expression<Boolean> isDeleted = root.get("isDeleted");
        query.select(root).where(builder.isFalse(isDeleted));

        Expression<String> propertyPath = root.get(field);
        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Critter> critters = session.createQuery(query).getResultList();
        session.close();



        return critters;
    }

    /**
     * Get critter by id
     *
     * @param id the id
     * @return the critter that matches the ID
     */
    public Critter getById(int id) {
        Session session = sessionFactory.openSession();
        Critter critter = session.get( Critter.class, id );
        session.close();
        return critter;
    }

    /**
     * Create critter int.
     *
     * @param critter the critter
     * @return the int
     */
    public int createCritter(Critter critter){
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(critter);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete critter.
     *
     * @param id the id
     */
    public void deleteCritter(int id){
        Critter critterToDelete = getById(id);
        critterToDelete.setIsDeleted(true);
        updateCritter(critterToDelete);
    }

    /**
     * Update critter.
     *
     * @param critter the critter
     */
    public void updateCritter(Critter critter){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(critter);
        session.getTransaction().commit();
        session.close();
    }
}
