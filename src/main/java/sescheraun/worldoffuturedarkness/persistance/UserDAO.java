package sescheraun.worldoffuturedarkness.persistance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
import java.util.List;
import sescheraun.WorldOfFutureDarkness.generator.*;
import sescheraun.worldoffuturedarkness.generator.User;


/**
 * The type User dao.
 */
public class UserDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();


    /**
     * Get all users list.
     *
     * @return the list
     */
    public List<User>  getAllUsers(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        Expression<Boolean> isDeleted = root.get("isDeleted");
        query.select(root).where(builder.isFalse(isDeleted));

        List<User> users = session.createQuery(query).getResultList();
        session.close();

        return users;
    }

    /**
     * Gets user by.
     *
     * @param field the field
     * @param value the value
     * @return the user by
     */
    public List<User> getUserBy(String field, String value) {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<Boolean> isDeleted = root.get("isDeleted");
        query.select(root).where(builder.isFalse(isDeleted));

        Expression<String> propertyPath = root.get(field);
        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<User> users = session.createQuery(query).getResultList();
        session.close();

        return users;
    }

    /**
     * Get user by id
     *
     * @param id the id
     * @return the user that matches the ID
     */
    public User getById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get( User.class, id );
        session.close();
        return user;
    }

    /**
     * Create user int.
     *
     * @param user the user
     * @return the int
     */
    public int createUser(User user){
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(user);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete user.
     *
     * @param id the id
     */
    public void deleteUser(int id){
        User userToDelete = getById(id);
        userToDelete.setIsDeleted(true);
        updateUser(userToDelete);
    }

    /**
     * Update user.
     *
     * @param user the user
     */
    public void updateUser(User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();
    }

}
