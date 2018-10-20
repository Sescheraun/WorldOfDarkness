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
    UserDAO dao;
    GenericDAO genericDAO;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new UserDAO();
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
        logger.debug(users.get(0));
        assertEquals(user, users.get(0));
    }

    /**
     * Gets user by.
     */
    @Test
    void getUserBy() {
        List<User> users = dao.getUserBy("lastName", "a");
        assertEquals(3, users.size());
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

        int id = dao.createUser(newUser);

        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals(newUser, insertedUser);

        List<User> users = dao.getAllUsers();

        assertEquals(5, users.size());
    }

    /**
     * Update user.
     */
    @Test
    void updateUser() {

        String newName = "Super";

        User user = dao.getById(1);

        user.setFirstName(newName);

        dao.updateUser(user);

        User testUser = dao.getById(1);

        assertEquals(testUser, user);


    }

    /**
     * Delete user.
     */
    @Test
    void deleteUser() {
        dao.deleteUser(1);

        //assertEquals(true, user.getIsDeleted());

        List<User> users = dao.getAllUsers();

        assertEquals(3, users.size());
    }
}