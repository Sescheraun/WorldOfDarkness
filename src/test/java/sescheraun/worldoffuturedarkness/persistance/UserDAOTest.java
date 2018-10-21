package sescheraun.worldoffuturedarkness.persistance;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sescheraun.worldoffuturedarkness.generator.User;
import sescheraun.worldoffuturedarkness.test.util.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
class UserDAOTest {
    /**
     * The Dao.
     */
    GenericDAO genericDAO;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        genericDAO = new GenericDAO(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }


    /**
     * Gets by id.
     */
    @Test
    void getByID() {
        User user = (User)genericDAO.getByID(4);
        assertEquals("Allard", user.getLastName());
    }

    /**
     * Get all users.
     */
    @Test
    void getAllUsers(){
        List<User> users = (List<User>)genericDAO.getAll();
        assertEquals(4, users.size());
        User user = (User)genericDAO.getByID(1);
        assertEquals(user, users.get(0));
    }

    /**
     * Get deleted users.
     */
    @Test
    void getDeletedUsers(){
        List<User> users = (List<User>)genericDAO.getDeleted();
        assertEquals(1, users.size());
    }

    /**
     * Gets critter by a specific category and value.
     */
    @Test
    void getUserBy() {
        List<User> users = (List<User>)genericDAO.getEntityBy("phoneNumber", "555");
        assertEquals(2, users.size());
    }

    /**
     * Create user.
     */
    @Test
    void createUser() {
        User newUser = new User();
        newUser.setFirstName("Captain");
        newUser.setLastName("Caveman");
        newUser.setUserName("CaveyWavey");
        newUser.setAuthenticator("cowabunga");
        newUser.setEmailAddress("TalkToTheClub@OneMillion.BC");
        newUser.setPhoneNumber("608-555-1234");
        newUser.setIsDeleted(false);

        int id = genericDAO.create(newUser);

        assertNotEquals(0,id);
        User insertedUser = (User)genericDAO.getByID(id);
        assertEquals(newUser, insertedUser);

        List<User> users = (List<User>)genericDAO.getAll();

        assertEquals(5, users.size());
    }

    /**
     * Update user.
     */
    @Test
    void updateUser() {

        String newName = "Super";

        User user = (User)genericDAO.getByID(1);

        user.setFirstName(newName);

        genericDAO.update(user);

        User testUser = (User)genericDAO.getByID(1);

        assertEquals(testUser, user);

    }

    /**
     * Delete user.
     */
    @Test
    void deleteUser() {
        User user = (User)genericDAO.getByID(1);

        user.setIsDeleted(true);

        genericDAO.update(user);
        //assertEquals(true, user.getIsDeleted());

        List<User> users = (List<User>)genericDAO.getAll();

        assertEquals(3, users.size());
    }
}