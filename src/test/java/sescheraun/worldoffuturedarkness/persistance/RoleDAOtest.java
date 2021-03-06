package sescheraun.worldoffuturedarkness.persistance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import sescheraun.worldoffuturedarkness.test.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sescheraun.worldoffuturedarkness.generator.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Sub critter dao test.
 */
public class RoleDAOtest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Dao.
     */
    /**
     * The User dao.
     */
    GenericDAO userDAO;
    /**
     * The Generic dao.
     */
    GenericDAO roleDAO;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        userDAO = new GenericDAO(User.class);
        roleDAO = new GenericDAO(Role.class);


        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    /**
     * Gets an entity by id.
     */
    @Test
    void getByID() {
        Role role = (Role) roleDAO.getByID(1);
        assertEquals("Nerf Herder", role.getRoleName());
    }


    /**
     * Get all subUsers.
     */
    @Test
    void getAllRoles() {
        List<Role> roles = (List<Role>) roleDAO.getAll();
        assertEquals(3, roles.size());
        Role role = (Role)roleDAO.getByID(1);
        logger.debug(roles.get(0));
        assertEquals(role, roles.get(0));
    }

    /**
     * Get all subUsers.
     */
    @Test
    void getDeletedRole() {
        List<Role> roles = (List<Role>) roleDAO.getDeleted();
        assertEquals(1, roles.size());
    }

    /**
     * Gets critter by a specific category and value.
     */
    @Test
    void getUserBy() {
        List<Role> users = (List<Role>) roleDAO.getEntityBy("roleName", "o");
        assertEquals(1, users.size());
    }


    /**
     * Verify successful insert
     */
    @Test
    void insertSuccess() {

        User user = (User)userDAO.getByID(1);

        String roleName = "Admin";


        Role newRole = new Role(user, roleName);
        user.addRole(newRole);

        int id = roleDAO.create(newRole);
        assertNotEquals(0, id);

        Role validationRole = (Role)roleDAO.getByID(id);
        assertNotNull(validationRole);
        assertEquals(validationRole, newRole);
        assertNotNull(newRole.getUser());
        assertEquals(user, newRole.getUser());
    }

    /**
     * Update Role.
     */
    @Test
    void updateRole() {
        String newName = "igNoble";
        Role role = (Role)roleDAO.getByID(1);
        role.setRoleName(newName);
        roleDAO.update(role);
        Role newRole = (Role) roleDAO.getByID(1);
        Assertions.assertEquals(newRole, role);
    }

    /**
     * Delete role.
     */
    @Test
    void deleteRole() {
        Role role = (Role) roleDAO.getByID(1);

        role.setIsDeleted(true);

        roleDAO.update(role);

        List<Role> roles = (List<Role>) roleDAO.getAll();
        Assertions.assertEquals(2, roles.size());
    }

    /**
     * Get role.
     */
    @Test
    void getRoleBy() {
        List<Role> roles = roleDAO.getEntityBy("userName", "Negaduck");
        assertEquals(2, roles.size());
    }
}