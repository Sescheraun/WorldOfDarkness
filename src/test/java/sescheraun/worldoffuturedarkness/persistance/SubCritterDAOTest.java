package sescheraun.worldoffuturedarkness.persistance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import sescheraun.worldoffuturedarkness.test.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sescheraun.worldoffuturedarkness.generator.Critter;
import sescheraun.worldoffuturedarkness.generator.SubCritter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Sub critter dao test.
 */
public class SubCritterDAOTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Dao.
     */
//    SubCritterDAO dao;
    /**
     * The Critter dao.
     */
    GenericDAO critterDao;
    /**
     * The Generic dao.
     */
    GenericDAO genericDAO;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
//        dao = new SubCritterDAO();
        genericDAO = new GenericDAO(SubCritter.class);
        critterDao = new GenericDAO(Critter.class);


        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        populateSubCritters();
    }

    /**
     * Gets an entity by id.
     */
    @Test
    void getByID() {
        SubCritter subCritter = (SubCritter)genericDAO.getByID(1);
        assertEquals("Sidhe", subCritter.getCritterSubName());
    }


    /**
     * Get all subCritters.
     */
    @Test
    void getAllSubCritters(){
        List<SubCritter> subCritters = (List<SubCritter>)genericDAO.getAll();
        assertEquals(3, subCritters.size());
        SubCritter subCritter = (SubCritter)genericDAO.getByID(1);
        logger.debug(subCritters.get(0));
        assertEquals(subCritter, subCritters.get(0));
    }

    /**
     * Get all subCritters.
     */
    @Test
    void getDeletedSubCritters(){
        List<SubCritter> subCritters = (List<SubCritter>)genericDAO.getDeleted();
        assertEquals(0, subCritters.size());

    }

    /**
     * Gets critter by a specific category and value.
     */
    @Test
    void getCritterBy() {
        List<SubCritter> subCritters = (List<SubCritter>)genericDAO.getEntityBy("critterSubName", "o");
        assertEquals(2, subCritters.size());
    }


    /**
     * Verify successful insert
     */
    @Test
    void insertSuccess() {

        critterDao = new GenericDAO(Critter.class);
        Critter critter = (Critter)critterDao.getByID(1);

        String subCritterLabel = "Breed";
        String critterSubName = "Mallard";
        String firstAdvantage = "";
        String secondAdvantage = "Talks like a duck";
        String flaw = "Flaws - Nockers are cynical because they're such perfectionists. They can always see ways for things to work better, but they can never quite achieve their ideals. Some say this is a curse from the First Artisan; oters claim it's a karmic debt for their attitude problem. Regardless, anything a Nocker creates will have one trivial (but irreparable) flaw. This serves as a constant frustration to the artisan who's crafted it. Even if the nocker scores five or more successes on a creation roll (a complete success), there will still be an elusive, annoying fault.";


        SubCritter subCritter = new SubCritter(critter, subCritterLabel, critterSubName, firstAdvantage, secondAdvantage, flaw);
        critter.addSubCritter(subCritter);

        int id = genericDAO.create(subCritter);
        assertNotEquals(0, id);

        SubCritter newSubCritter = (SubCritter)genericDAO.getByID(id);
        assertNotNull(newSubCritter);
        assertEquals(subCritter, newSubCritter);
        assertNotNull(newSubCritter.getCritter());
        assertEquals(critter, newSubCritter.getCritter());

        System.out.println(newSubCritter.getCritter());
    }

    /**
     * Update sub critter.
     */
    @Test
    void updateSubCritter() {
        String newName = "igNoble";
        SubCritter subCritter = (SubCritter)genericDAO.getByID(1);
        subCritter.setCritterSubName(newName);
        genericDAO.update(subCritter);
        SubCritter newSubCritter = (SubCritter)genericDAO.getByID(1);
        Assertions.assertEquals(newSubCritter, subCritter);
    }

    /**
     * Delete sub critter.
     */
    @Test
    void deleteSubCritter() {
        SubCritter subCritter = (SubCritter)genericDAO.getByID(1);

        subCritter.setIsDeleted(true);

        genericDAO.update(subCritter);

        List<SubCritter> subCritters = (List<SubCritter>)genericDAO.getAll();
        Assertions.assertEquals(2, subCritters.size());
    }

    /**
     * Get sub critter by.
     */
    @Test
    void getSubCritterBy(){
        List<SubCritter> subCritters = genericDAO.getEntityBy("critterSubName", "Sid");
        assertEquals(1, subCritters.size());
    }

    /**
     * Populate sub critters list for testing.
     */
    private void populateSubCritters() {
        Critter critter = (Critter)critterDao.getByID(5);
        List<String> subCritterLabels = new ArrayList<>();
        List<String> critterSubNames = new ArrayList<>();
        List<String> firstAdvantages = new ArrayList<>();
        List<String> secondAdvantages = new ArrayList<>();
        List<String> flaws = new ArrayList<>();

        subCritterLabels.add("Kith");
        critterSubNames.add("Sidhe");
        firstAdvantages.add("Awe and Beauty: Sidhe get two extra dots of Appearance during character creation, even if this increases their score above 5. They cannot help but stand out in a crowd. The fury of a sidhe scorned is a majestic and terrifying sight. When impassioned, all their Social rolls (especially Empathy or Intimidation rolls) are at a -2 difficulty. Anyone who tries to attack an angry sidhe head-on must make a Willpower roll; the difficulty ranges from 6 (for the average sidhe) to an 8 or 9 (for one of suitable high station). This birthright only affects other Kithain and the Enchanted, unless the sidhe calls upon the Wyrd.");
        secondAdvantages.add("Noble Bearing: Whether heroes or villains, all sidhe are dignified. Any cantrip that would directly make them look foolish immediately fails.   Further, Sidhe cannot botch Etiquette rolls.");
        flaws.add("Banality's Curse: Sidhe are not truly of this world. The taint of Banality affects them more strongly than it does other fae. Each temporary point of Banality that a Dream Lord gains becomes two points. If a sidhe character must make a roll at a difficulty equal their Banality (or a roll resisted by Banality), treat it as one level higher.");


        subCritterLabels.add("Kith");
        critterSubNames.add("Troll");
        firstAdvantages.add("Titan's Power: Wilders gain an additional Bruised Health Level and an additional dot of Strength during character creation, even if this raises the Trait above 5. Grumps get two extra dots in Strength and two additional Bruised Levels (for a total of 9 Health levels). Grumps, though, also add a +1 difficulty to all Dexterity-based rolls. This extra strength does not function in the presence of mortals to the unenchanted unless the troll has called upon the Wyrd, further, No troll can botch an Athletics of Alertness roll.");
        secondAdvantages.add("Stubbornness: Nothing can interfere with a troll's devotion to duty. When in the service of a cause, they get an extra two dice to any Willpower roll to resist temptation or distraction. This Birthright is always in effect.");
        flaws.add("Bond of Duty: Any troll who dares to renege on a sworn contract or oath becomes sickly and looses their Titan's Power. Only by atoning for the lapse of trust can they regain their strength. Usually this involves fulfilling a new oath. Seelie trolls never lie to fae they are protecting; Unseelie ogres uphold their bond of duty, but usually prefer to support more disreputable fae. This trust must extend both ways; if a troll's trust is betrayed, they will be filled with anger and must roll Willpower, difficulty 8, to avoid becoming violent. Their stoicism belies great rage, perhaps one that has been with them since the Earth was young.");


        subCritterLabels.add("Kith");
        critterSubNames.add("Boggan");
        firstAdvantages.add("Titan's Power: Wilders gain an additional Bruised Health Level and an additional dot of Strength during character creation, even if this raises the Trait above 5. Grumps get two extra dots in Strength and two additional Bruised Levels (for a total of 9 Health levels). Grumps, though, also add a +1 difficulty to all Dexterity-based rolls. This extra strength does not function in the presence of mortals to the unenchanted unless the troll has called upon the Wyrd, further, No troll can botch an Athletics of Alertness roll.");
        secondAdvantages.add("Stubbornness: Nothing can interfere with a troll's devotion to duty. When in the service of a cause, they get an extra two dice to any Willpower roll to resist temptation or distraction. This Birthright is always in effect.");
        flaws.add("Bond of Duty: Any troll who dares to renege on a sworn contract or oath becomes sickly and looses their Titan's Power. Only by atoning for the lapse of trust can they regain their strength. Usually this involves fulfilling a new oath. Seelie trolls never lie to fae they are protecting; Unseelie ogres uphold their bond of duty, but usually prefer to support more disreputable fae. This trust must extend both ways; if a troll's trust is betrayed, they will be filled with anger and must roll Willpower, difficulty 8, to avoid becoming violent. Their stoicism belies great rage, perhaps one that has been with them since the Earth was young.");


        SubCritter subCritter;
        logger.debug(flaws.size());

        for (int index = 0; index < flaws.size(); index++) {
            subCritter = new SubCritter(critter, subCritterLabels.get(index), critterSubNames.get(index), firstAdvantages.get(index), secondAdvantages.get(index), flaws.get(index));
            critter.addSubCritter(subCritter);

            int id = genericDAO.create(subCritter);

            logger.debug(index + "===================================================================");
        }
    }
}
