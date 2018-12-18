package sescheraun.worldoffuturedarkness.generator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

/**
 * The type Character.
 */
@Entity(name = "Character")
@Table(name = "character")
public class Character {
    @Transient
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "userID")
    private User player;

    /**
     * The Sub critters.
     */
    @JsonIgnore
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
                          name = "characterSubCritter",
                   joinColumns = { @JoinColumn(name = "characterId") },
            inverseJoinColumns = { @JoinColumn(name = "subCritterId") }
    )
    Set<SubCritter> subCritters = new HashSet<>();

    @OneToMany(mappedBy = "primaryKey.characterID", cascade = CascadeType.ALL)
    private Set<CharacterTraits> characterTraits = new HashSet<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "critterId")
    private Critter critter;

    private String firstName;
    private String middleName;
    private String lastName;
    private int unspentExperience;
    private boolean approved;
    private boolean isDeleted;


    /**
     * Gets traits.
     *
     * @return the traits
     */
    public Set<CharacterTraits> getTraits() {
        return characterTraits;
    }

    /**
     * Sets character traits.
     *
     * @param characterTraits the character traits
     */
    public void setCharacterTraits(Set<CharacterTraits> characterTraits) {
        this.characterTraits = characterTraits;
    }

    /**
     * Sets traits.
     *
     * @param characterTrait the character trait
     */
    public void addCharacterTraits(CharacterTraits characterTrait) {
        this.characterTraits.add(characterTrait);
    }

    /**
     * Instantiates a new Character.
     */
    public Character() {
        this.isDeleted = false;
    }

    /**
     * Instantiates a new Character.
     *
     * @param firstName  the first name
     * @param middleName the middle name
     * @param lastName   the last name
     * @param subCritter the sub critter
     */
    public Character(String firstName, String middleName, String lastName, SubCritter subCritter) {
        this();
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.subCritters.add(subCritter);
        this.critter = subCritter.getCritter();
    }

    /**
     * Gets player.
     *
     * @return the player
     */
    public User getPlayer() {
        return player;
    }

    /**
     * Sets player.
     *
     * @param player the player
     */
    public void setPlayer(User player) {
        this.player = player;
    }

    /**
     * Gets sub critters.
     *
     * @return the sub critters
     */
    public Set<SubCritter> getSubCritters() {
        return subCritters;
    }

    /**
     * Sets sub critters.
     *
     * @param subCritters the sub critters
     */
    public void setSubCritters(Set<SubCritter> subCritters) {
        this.subCritters = subCritters;
    }

    /**
     * Gets critter.
     *
     * @return the critter
     */
    public Critter getCritter() {
        return critter;
    }

    /**
     * Sets critter.
     *
     * @param critter the critter
     */
    public void setCritter(Critter critter) {
        this.critter = critter;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets middle name.
     *
     * @return the middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets middle name.
     *
     * @param middleName the middle name
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets unspent experience.
     *
     * @return the unspent experience
     */
    public int getUnspentExperience() {
        return unspentExperience;
    }

    /**
     * Sets unspent experience.
     *
     * @param unspentExperience the unspent experience
     */
    public void setUnspentExperience(int unspentExperience) {
        this.unspentExperience = unspentExperience;
    }

    /**
     * Is approved boolean.
     *
     * @return the boolean
     */
    public boolean isApproved() {
        return approved;
    }

    /**
     * Sets approved.
     *
     * @param approved the approved
     */
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    /**
     * Is deleted boolean.
     *
     * @return the boolean
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * Sets deleted.
     *
     * @param deleted the deleted
     */
    public void setIsDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", player=" + player.getUserName() +
                ", subCritters=" + subCritters +
                ", critter=" + critter.getCritterName() +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", unspentExperience=" + unspentExperience +
                ", approved=" + approved +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return id == character.id &&
                unspentExperience == character.unspentExperience &&
                approved == character.approved &&
                //Objects.equals(player, character.player) &&
                Objects.equals(subCritters, character.subCritters) &&
                Objects.equals(critter, character.critter) &&
                Objects.equals(firstName, character.firstName) &&
                Objects.equals(middleName, character.middleName) &&
                Objects.equals(lastName, character.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, /*player,*/ subCritters, critter, firstName, middleName, lastName, unspentExperience, approved);
    }
}
