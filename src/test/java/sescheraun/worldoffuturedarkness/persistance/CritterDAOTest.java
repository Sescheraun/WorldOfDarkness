package sescheraun.worldoffuturedarkness.persistance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sescheraun.worldoffuturedarkness.test.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sescheraun.worldoffuturedarkness.generator.Critter;
import sescheraun.worldoffuturedarkness.generator.SubCritter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CritterDAOTest {

    /**
     * The Dao.
     */
    CritterDAO dao;
    GenericDAO genericDAO;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new CritterDAO();
        genericDAO = new GenericDAO(Critter.class);

        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    /**
     * Gets an entity by id.
     */
    @Test
    void getByID() {
        Critter critter = (Critter)genericDAO.getByID(4);
        assertEquals("Mage", critter.getCritterName());
    }

    /**
     * Get all critters.
     */
    @Test
    void getAllCritters(){
        List<Critter> critters = (List<Critter>)genericDAO.getAll();
        assertEquals(10, critters.size());
        Critter critter = (Critter)genericDAO.getByID(1);
        logger.debug(critters.get(0));
        assertEquals(critter, critters.get(0));
    }

    /**
     * Gets critter by.
     */
    @Test
    void getCritterBy() {
        List<Critter> critters = dao.getCritterBy("critterName", "a");
        assertEquals(7, critters.size());
    }

    /**
     * Create critter.
     */
    @Test
    void createCritter() {
        Critter newCritter = new Critter();
        newCritter.setCritterName("Duck");
        newCritter.setImplemented(false);
        newCritter.setIsDeleted(false);

        int id = dao.createCritter(newCritter);

        assertNotEquals(0,id);
        Critter insertedCritter = dao.getById(id);
        assertEquals(insertedCritter, insertedCritter);

        List<Critter> critters = dao.getAllCritters();

        assertEquals(11, critters.size());
   }

    @Test
    void createCritterWithSubCritter() {
        Critter newCritter = new Critter();
        newCritter.setCritterName("Duck");
        newCritter.setImplemented(false);
        newCritter.setIsDeleted(false);

        String subCritterLabel = "Breed";
        String critterSubName = "Mallard";
        String firstAdvantage = "";
        String secondAdvantage = "Talks like a duck";
        String flaw = "Flaws - Nockers are cynical because they're such perfectionists. They can always see ways for things to work better, but they can never quite achieve their ideals. Some say this is a curse from the First Artisan; oters claim it's a karmic debt for their attitude problem. Regardless, anything a Nocker creates will have one trivial (but irreparable) flaw. This serves as a constant frustration to the artisan who's crafted it. Even if the nocker scores five or more successes on a creation roll (a complete success), there will still be an elusive, annoying fault.";


        SubCritter subCritter = new SubCritter(newCritter, subCritterLabel, critterSubName, firstAdvantage, secondAdvantage, flaw);

        newCritter.addSubCritter(subCritter);

        int id = dao.createCritter(newCritter);

        assertNotEquals(0,id);
        Critter insertedCritter = dao.getById(id);
        assertEquals(insertedCritter, insertedCritter);
        assertEquals(1, newCritter.getSubCritters().size());

        List<Critter> critters = dao.getAllCritters();

        assertEquals(11, critters.size());
    }

    /**
     * Update critter.
     */
    @Test
    void updateCritter() {

        String newName = "Garou";

        Critter critter = dao.getById(3);

        critter.setCritterName(newName);

        dao.updateCritter(critter);

        dao.getById(1);

        assertEquals(critter, critter);


    }

    /**
     * Delete critter.
     */
    @Test
    void deleteCritter() {
        dao.deleteCritter(1);

        //assertEquals(true, critter.getIsDeleted());

        List<Critter> critters = dao.getAllCritters();

        assertEquals(9, critters.size());
    }
}
