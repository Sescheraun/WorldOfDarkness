package sescheraun.worldoffuturedarkness.generator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Character traits.
 */
@Entity(name = "CharacterTraits")
@Table(name = "characterTraits")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.characterID",
                joinColumns = @JoinColumn(name = "characterTraits_character")),
        @AssociationOverride(name = "primaryKey.traitID",
                joinColumns = @JoinColumn(name = "characterTraits_Traits"))
})
public class CharacterTraits {
    @Transient
    private final Logger logger = LogManager.getLogger(this.getClass());

    @EmbeddedId
    private CharacterSheet primaryKey = new CharacterSheet();


    private int currentRank;
    private String description;
    private String firstSpecialty;
    private String secondSpecialty;
    private int currentLevel;

    /**
     * Gets primary key.
     *
     * @return the primary key
     */
    public CharacterSheet getPrimaryKey() {
        return primaryKey;
    }

    /**
     * Sets primary key.
     *
     * @param primaryKey the primary key
     */
    public void setPrimaryKey(CharacterSheet primaryKey) {
        this.primaryKey = primaryKey;
    }

    /**
     * Gets character.
     *
     * @return the character
     */
    @Transient
    public Character getCharacter() {
        return getPrimaryKey().getCharacterID();
    }

    /**
     * Set character.
     *
     * @param character the character
     */
    public void setCharacter(Character character){
        getPrimaryKey().setCharacterID(character);
    }

    /**
     * Gets trait.
     *
     * @return the trait
     */
    @Transient
    public Trait getTrait() {
        return getPrimaryKey().getTraitID();
    }

    /**
     * Set trait.
     *
     * @param trait the trait
     */
    public void setTrait(Trait trait){
        getPrimaryKey().setTraitID(trait);
    }

    /**
     * Gets current rank.
     *
     * @return the current rank
     */
    public int getCurrentRank() {
        return currentRank;
    }

    /**
     * Sets current rank.
     *
     * @param currentRank the current rank
     */
    public void setCurrentRank(int currentRank) {
        this.currentRank = currentRank;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets first specialty.
     *
     * @return the first specialty
     */
    public String getFirstSpecialty() {
        return firstSpecialty;
    }

    /**
     * Sets first specialty.
     *
     * @param firstSpecialty the first specialty
     */
    public void setFirstSpecialty(String firstSpecialty) {
        this.firstSpecialty = firstSpecialty;
    }

    /**
     * Gets second specialty.
     *
     * @return the second specialty
     */
    public String getSecondSpecialty() {
        return secondSpecialty;
    }

    /**
     * Sets second specialty.
     *
     * @param secondSpecialty the second specialty
     */
    public void setSecondSpecialty(String secondSpecialty) {
        this.secondSpecialty = secondSpecialty;
    }

    /**
     * Gets current level.
     *
     * @return the current level
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Sets current level.
     *
     * @param currentLevel the current level
     */
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
}