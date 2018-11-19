package sescheraun.worldoffuturedarkness.generator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

/**
 * The type Trait.
 */
@Entity(name = "Trait")
@Table(name = "trait")
public class Trait {

    @Transient
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    @JoinColumn(name = "openTo")
    private Critter openTo;

    @ManyToOne
    @JoinColumn(name = "goodAt")
    private SubCritter goodAt;

    private String traitName;
    private boolean specialtyAllowed;
    private int minimumScore;
    private int maximumScore;
    private String traitType;
    private String newCost;
    private int cheapCost;
    private int normalCost;
    private int expensiveCost;
    private int freebieCost;
    private String descriptionFile;
    private boolean isDeleted;

    /**
     * Instantiates a new Trait.
     */
    public Trait() {
        this.isDeleted = false;
    }

    /**
     * Gets logger.
     *
     * @return the logger
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets open to critter id.
     *
     * @return the open to critter id
     */
    public Critter getOpenTo() {
        return openTo;
    }

    /**
     * Sets open to critter id.
     *
     * @param openTo the open to critter id
     */
    public void setOpenTo(Critter openTo) {
        this.openTo = openTo;
    }

    /**
     * Gets good at sub critter id.
     *
     * @return the good at sub critter id
     */
    public SubCritter getGoodAt() {
        return goodAt;
    }

    /**
     * Sets good at sub critter id.
     *
     * @param goodAt the good at sub critter id
     */
    public void setGoodAt(SubCritter goodAt) {
        this.goodAt = goodAt;
    }

    /**
     * Gets trait name.
     *
     * @return the trait name
     */
    public String getTraitName() {
        return traitName;
    }

    /**
     * Sets trait name.
     *
     * @param traitName the trait name
     */
    public void setTraitName(String traitName) {
        this.traitName = traitName;
    }

    /**
     * Is specialty allowed boolean.
     *
     * @return the boolean
     */
    public boolean isSpecialtyAllowed() {
        return specialtyAllowed;
    }

    /**
     * Sets specialty allowed.
     *
     * @param specialtyAllowed the specialty allowed
     */
    public void setSpecialtyAllowed(boolean specialtyAllowed) {
        this.specialtyAllowed = specialtyAllowed;
    }

    /**
     * Gets minimum score.
     *
     * @return the minimum score
     */
    public int getMinimumScore() {
        return minimumScore;
    }

    /**
     * Sets minimum score.
     *
     * @param minimumScore the minimum score
     */
    public void setMinimumScore(int minimumScore) {
        this.minimumScore = minimumScore;
    }

    /**
     * Gets maximum score.
     *
     * @return the maximum score
     */
    public int getMaximumScore() {
        return maximumScore;
    }

    /**
     * Sets maximum score.
     *
     * @param maximumScore the maximum score
     */
    public void setMaximumScore(int maximumScore) {
        this.maximumScore = maximumScore;
    }

    /**
     * Gets trait type.
     *
     * @return the trait type
     */
    public String getTraitType() {
        return traitType;
    }

    /**
     * Sets trait type.
     *
     * @param traitType the trait type
     */
    public void setTraitType(String traitType) {
        this.traitType = traitType;
    }

    /**
     * Gets new cost.
     *
     * @return the new cost
     */
    public String getNewCost() {
        return newCost;
    }

    /**
     * Sets new cost.
     *
     * @param newCost the new cost
     */
    public void setNewCost(String newCost) {
        this.newCost = newCost;
    }

    /**
     * Gets cheap cost.
     *
     * @return the cheap cost
     */
    public int getCheapCost() {
        return cheapCost;
    }

    /**
     * Sets cheap cost.
     *
     * @param cheapCost the cheap cost
     */
    public void setCheapCost(int cheapCost) {
        this.cheapCost = cheapCost;
    }

    /**
     * Gets normal cost.
     *
     * @return the normal cost
     */
    public int getNormalCost() {
        return normalCost;
    }

    /**
     * Sets normal cost.
     *
     * @param normalCost the normal cost
     */
    public void setNormalCost(int normalCost) {
        this.normalCost = normalCost;
    }

    /**
     * Gets expensive cost.
     *
     * @return the expensive cost
     */
    public int getExpensiveCost() {
        return expensiveCost;
    }

    /**
     * Sets expensive cost.
     *
     * @param expensiveCost the expensive cost
     */
    public void setExpensiveCost(int expensiveCost) {
        this.expensiveCost = expensiveCost;
    }

    /**
     * Gets freebie cost.
     *
     * @return the freebie cost
     */
    public int getFreebieCost() {
        return freebieCost;
    }

    /**
     * Sets freebie cost.
     *
     * @param freebieCost the freebie cost
     */
    public void setFreebieCost(int freebieCost) {
        this.freebieCost = freebieCost;
    }

    /**
     * Gets description file.
     *
     * @return the description file
     */
    public String getDescriptionFile() {
        return descriptionFile;
    }

    /**
     * Sets description file.
     *
     * @param descriptionFile the description file
     */
    public void setDescriptionFile(String descriptionFile) {
        this.descriptionFile = descriptionFile;
    }

    /**
     * Gets is deleted.
     *
     * @return the is deleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * Sets is deleted.
     *
     * @param delete the delete
     */
    public void setIsDeleted(boolean delete) {
        this.isDeleted = delete;
    }

    @Override
    public String toString() {
        return "Trait{"
                + "logger=" + logger
                + ", id=" + id
                + ", openToCritterID=" + openTo
                + ", goodAtSubCritterID=" + goodAt
                + ", traitName='" + traitName + '\''
                + ", specialtyAllowed=" + specialtyAllowed
                + ", minimumScore=" + minimumScore
                + ", maximumScore=" + maximumScore
                + ", traitType='" + traitType + '\''
                + ", newCost='" + newCost + '\''
                + ", cheapCost=" + cheapCost
                + ", normalCost=" + normalCost
                + ", expensiveCost=" + expensiveCost
                + ", freebieCost=" + freebieCost
                + ", descriptionFile='" + descriptionFile + '\''
                + ", isDeleted=" + isDeleted
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trait trait = (Trait) o;
        return id == trait.id &&
                openTo == trait.openTo &&
                goodAt == trait.goodAt &&
                specialtyAllowed == trait.specialtyAllowed &&
                minimumScore == trait.minimumScore &&
                maximumScore == trait.maximumScore &&
                cheapCost == trait.cheapCost &&
                normalCost == trait.normalCost &&
                expensiveCost == trait.expensiveCost &&
                freebieCost == trait.freebieCost &&
                isDeleted == trait.isDeleted &&
                Objects.equals(traitName, trait.traitName) &&
                Objects.equals(traitType, trait.traitType) &&
                Objects.equals(newCost, trait.newCost) &&
                Objects.equals(descriptionFile, trait.descriptionFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, openTo, goodAt, traitName, specialtyAllowed, minimumScore, maximumScore, traitType, newCost, cheapCost, normalCost, expensiveCost, freebieCost, descriptionFile, isDeleted);
    }

}
