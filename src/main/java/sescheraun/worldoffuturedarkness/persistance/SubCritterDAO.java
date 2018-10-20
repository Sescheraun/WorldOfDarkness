package sescheraun.worldoffuturedarkness.persistance;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
import java.util.List;

import sescheraun.worldoffuturedarkness.generator.*;


/**
 * The type SubCritter dao.
 */
public class SubCritterDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get all subCritters list.
     *
     * @return the list
     */
    public List<SubCritter>  getAllSubCritters(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SubCritter> query = builder.createQuery(SubCritter.class);
        Root<SubCritter> root = query.from(SubCritter.class);

        Expression<Boolean> isDeleted = root.get("isDeleted");
        query.select(root).where(builder.isFalse(isDeleted));

        List<SubCritter> subCritters = session.createQuery(query).getResultList();
        session.close();

        return subCritters;
    }

    /**
     * Gets subCritter by.
     *
     * @param field the field
     * @param value the value
     * @return the subCritter by
     */
    public List<SubCritter> getSubCritterBy(String field, String value) {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SubCritter> query = builder.createQuery(SubCritter.class);
        Root<SubCritter> root = query.from(SubCritter.class);
        Expression<Boolean> isDeleted = root.get("isDeleted");
        query.select(root).where(builder.isFalse(isDeleted));

        Expression<String> propertyPath = root.get(field);
        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<SubCritter> subCritters = session.createQuery(query).getResultList();
        session.close();

        return subCritters;
    }

    /**
     * Get subCritter by id
     *
     * @param id the id
     * @return the subCritter that matches the ID
     */
    public SubCritter getById(int id) {
        Session session = sessionFactory.openSession();
        SubCritter subCritter = session.get( SubCritter.class, id );
        session.close();
        return subCritter;
    }

    /**
     * Create subCritter int.
     *
     * @param subCritter the subCritter
     * @return the int
     */
    public int createSubCritter(SubCritter subCritter){
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(subCritter);
        transaction.commit();
        session.close();
         return id;
    }

    /**
     * Delete subCritter.
     *
     * @param id the id
     */
    public void deleteSubCritter(int id){
        SubCritter subCritterToDelete = getById(id);
        subCritterToDelete.setIsDeleted(true);
        updateSubCritter(subCritterToDelete);
    }

    /**
     * Update subCritter.
     *
     * @param subCritter the subCritter
     */
    public void updateSubCritter(SubCritter subCritter){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(subCritter);
        session.getTransaction().commit();
        session.close();
    }
}
