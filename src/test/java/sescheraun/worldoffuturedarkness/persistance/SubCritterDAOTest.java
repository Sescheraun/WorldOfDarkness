package sescheraun.worldoffuturedarkness.persistance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import sescheraun.worldoffuturedarkness.test.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sescheraun.worldoffuturedarkness.generator.Critter;
import sescheraun.worldoffuturedarkness.generator.SubCritter;

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
    SubCritterDAO dao;
    /**
     * The Critter dao.
     */
    CritterDAO critterDao;
    GenericDAO genericDAO;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new SubCritterDAO();
        genericDAO = new GenericDAO(SubCritter.class);


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
    void getAllCritters(){
        List<SubCritter> subCritters = (List<SubCritter>)genericDAO.getAll();
        assertEquals(2, subCritters.size());
        SubCritter subCritter = (SubCritter)genericDAO.getByID(1);
        logger.debug(subCritters.get(0));
        assertEquals(subCritter, subCritters.get(0));
    }

    /**
     * Get all sub critters.
     */
    @Test
    void getAllSubCritters(){

        List<SubCritter> subCritters = dao.getAllSubCritters();
        assertEquals(2, subCritters.size());

    }


    /**
     * Verify successful insert
     */
    @Test
    void insertSuccess() {

        critterDao = new CritterDAO();
        Critter critter = critterDao.getById(1);

        String subCritterLabel = "Breed";
        String critterSubName = "Mallard";
        String firstAdvantage = "";
        String secondAdvantage = "Talks like a duck";
        String flaw = "Flaws - Nockers are cynical because they're such perfectionists. They can always see ways for things to work better, but they can never quite achieve their ideals. Some say this is a curse from the First Artisan; oters claim it's a karmic debt for their attitude problem. Regardless, anything a Nocker creates will have one trivial (but irreparable) flaw. This serves as a constant frustration to the artisan who's crafted it. Even if the nocker scores five or more successes on a creation roll (a complete success), there will still be an elusive, annoying fault.";


        SubCritter subCritter = new SubCritter(critter, subCritterLabel, critterSubName, firstAdvantage, secondAdvantage, flaw);
        critter.addSubCritter(subCritter);

        int id = dao.createSubCritter(subCritter);
        assertNotEquals(0, id);

        SubCritter newSubCritter = dao.getById(id);
        assertNotNull(newSubCritter);
        assertEquals(subCritter, newSubCritter);
        assertNotNull(newSubCritter.getCritter());
        assertEquals(critter, newSubCritter.getCritter());
    }

    @Test
    void updateSubCritter() {
        String newName = "igNoble";
        SubCritter subCritter = dao.getById(1);
        subCritter.setCritterSubName(newName);
        dao.updateSubCritter(subCritter);
        SubCritter newSubCritter = dao.getById(1);
        Assertions.assertEquals(newSubCritter, subCritter);
    }

    @Test
    void deleteSubCritter() {
        dao.deleteSubCritter(1);
        List<SubCritter> subCritters = this.dao.getAllSubCritters();
        Assertions.assertEquals(1, subCritters.size());
    }
    @Test
    void getSubCritterBy(){
        List<SubCritter> subCritters = dao.getSubCritterBy("critterSubName", "Sid");
        assertEquals(1, subCritters.size());
    }

    /**
     * Populate sub critters list for testing.
     */
    private void populateSubCritters() {
        critterDao = new CritterDAO();
        Critter critter = critterDao.getById(4);
        String subCritterLabel[] = new String[2];
        String critterSubName[] = new String[2];
        String firstAdvantage[] = new String[2];
        String secondAdvantage[] = new String[2];
        String flaw[] = new String[2];

        subCritterLabel[0] = "Kith";
        critterSubName[0] = "Sidhe";
        firstAdvantage[0] = "Awe and Beauty: Sidhe get two extra dots of Appearance during character creation, even if this increases their score above 5. They cannot help but stand out in a crowd. The fury of a sidhe scorned is a majestic and terrifying sight. When impassioned, all their Social rolls (especially Empathy or Intimidation rolls) are at a -2 difficulty. Anyone who tries to attack an angry sidhe head-on must make a Willpower roll; the difficulty ranges from 6 (for the average sidhe) to an 8 or 9 (for one of suitable high station). This birthright only affects other Kithain and the Enchanted, unless the sidhe calls upon the Wyrd.";
        secondAdvantage[0] = "Noble Bearing: Whether heroes or villains, all sidhe are dignified. Any cantrip that would directly make them look foolish immediately fails.   Further, Sidhe cannot botch Etiquette rolls.";
        flaw[0] = "Banality's Curse: Sidhe are not truly of this world. The taint of Banality affects them more strongly than it does other fae. Each temporary point of Banality that a Dream Lord gains becomes two points. If a sidhe character must make a roll at a difficulty equal their Banality (or a roll resisted by Banality), treat it as one level higher.";


        subCritterLabel[1] = "Kith";
        critterSubName[1] = "Troll";
        firstAdvantage[1] = "Titan's Power: Wilders gain an additional Bruised Health Level and an additional dot of Strength during character creation, even if this raises the Trait above 5. Grumps get two extra dots in Strength and two additional Bruised Levels (for a total of 9 Health levels). Grumps, though, also add a +1 difficulty to all Dexterity-based rolls. This extra strength does not function in the presence of mortals to the unenchanted unless the troll has called upon the Wyrd, further, No troll can botch an Athletics of Alertness roll.";
        secondAdvantage[1] = "Stubbornness: Nothing can interfere with a troll's devotion to duty. When in the service of a cause, they get an extra two dice to any Willpower roll to resist temptation or distraction. This Birthright is always in effect.";
        flaw[1] = "Bond of Duty: Any troll who dares to renege on a sworn contract or oath becomes sickly and looses their Titan's Power. Only by atoning for the lapse of trust can they regain their strength. Usually this involves fulfilling a new oath. Seelie trolls never lie to fae they are protecting; Unseelie ogres uphold their bond of duty, but usually prefer to support more disreputable fae. This trust must extend both ways; if a troll's trust is betrayed, they will be filled with anger and must roll Willpower, difficulty 8, to avoid becoming violent. Their stoicism belies great rage, perhaps one that has been with them since the Earth was young.";


        subCritterLabel[2] = "Kith";
        critterSubName[2] = "Boggan";
        firstAdvantage[2] = "Titan's Power: Wilders gain an additional Bruised Health Level and an additional dot of Strength during character creation, even if this raises the Trait above 5. Grumps get two extra dots in Strength and two additional Bruised Levels (for a total of 9 Health levels). Grumps, though, also add a +1 difficulty to all Dexterity-based rolls. This extra strength does not function in the presence of mortals to the unenchanted unless the troll has called upon the Wyrd, further, No troll can botch an Athletics of Alertness roll.";
        secondAdvantage[2] = "Stubbornness: Nothing can interfere with a troll's devotion to duty. When in the service of a cause, they get an extra two dice to any Willpower roll to resist temptation or distraction. This Birthright is always in effect.";
        flaw[2] = "Bond of Duty: Any troll who dares to renege on a sworn contract or oath becomes sickly and looses their Titan's Power. Only by atoning for the lapse of trust can they regain their strength. Usually this involves fulfilling a new oath. Seelie trolls never lie to fae they are protecting; Unseelie ogres uphold their bond of duty, but usually prefer to support more disreputable fae. This trust must extend both ways; if a troll's trust is betrayed, they will be filled with anger and must roll Willpower, difficulty 8, to avoid becoming violent. Their stoicism belies great rage, perhaps one that has been with them since the Earth was young.";


        SubCritter subCritter;
        logger.debug(flaw.length);

        for (int index = 0; index < flaw.length; index++) {
            subCritter = new SubCritter(critter, subCritterLabel[index], critterSubName[index], firstAdvantage[index], secondAdvantage[index], flaw[index]);
            critter.addSubCritter(subCritter);

            int id = dao.createSubCritter(subCritter);

            logger.debug(index + "===================================================================");
        }
    }
}
