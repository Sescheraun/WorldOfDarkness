package sescheraun.worldoffuturedarkness.generator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Sub critter.
 */
@Entity(name = "SubCritter")
@Table(name = "subCritter")
public class SubCritter {

    @Transient
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int subCritterId;

    private String subCritterLabel;

    /**
     * The Sub critters.
     */
    @JsonIgnore
    @ManyToMany(mappedBy = "subCritters")
    Set<Character> characters = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "subCritter")
    private Set<Trait> trait = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "critterID")
    private Critter critter;

    private String critterSubName;

    private String firstAdvantage;

    @Column(name = "secondAdvantage")
    private String secondAdvantage;

    private String flaw;

    private boolean isDeleted;

    /**
     * Instantiates a new Sub critter.
     */
    public SubCritter() {
        this.isDeleted = false;
    }

    /**
     * Instantiates a new Sub critter.
     *
     * @param critter         the critter
     * @param subCritterLabel the sub critter label
     * @param critterSubName  the critter sub name
     * @param firstAdvantage  the first advantage
     * @param secondAdvantage the second advantage
     * @param flaw            the flaw
     */
    public SubCritter(Critter critter, String subCritterLabel, String critterSubName, String firstAdvantage, String secondAdvantage, String flaw) {
        this();
        this.subCritterLabel = subCritterLabel;
        this.critter = critter;
        this.critterSubName = critterSubName;
        this.firstAdvantage = firstAdvantage;
        this.secondAdvantage = secondAdvantage;
        this.flaw = flaw;

        this.isDeleted = false;
    }

//    /**
//     * Add trait.
//     *
//     * @param trait the trait
//     */
//    public void addTrait(Trait trait) {
//        this.trait.add(trait);
//    }
//
//    /**
//     * Get traits set.
//     *
//     * @return the set of traits
//     */
//    public Set<Trait> getTraits(){
//        return this.trait;
//    }

    /**
     * Gets sub critter id.
     *
     * @return the sub critter id
     */
    public int getSubCritterId() {
        return subCritterId;
    }

    /**
     * Sets sub critter id.
     *
     * @param subCritterId the sub critter id
     */
    public void setSubCritterId(int subCritterId) {
        this.subCritterId = subCritterId;
    }

    /**
     * Gets sub critter label.
     *
     * @return the sub critter label
     */
    public String getSubCritterLabel() {
        return subCritterLabel;
    }

    /**
     * Sets sub critter label.
     *
     * @param subCritterLabel the sub critter label
     */
    public void setSubCritterLabel(String subCritterLabel) {
        this.subCritterLabel = subCritterLabel;
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
     * Gets critter sub name.
     *
     * @return the critter sub name
     */
    public String getCritterSubName() {
        return critterSubName;
    }

    /**
     * Sets critter sub name.
     *
     * @param critterSubName the critter sub name
     */
    public void setCritterSubName(String critterSubName) {
        this.critterSubName = critterSubName;
    }

    /**
     * Gets first advantage.
     *
     * @return the first advantage
     */
    public String getFirstAdvantage() {
        return firstAdvantage;
    }

    /**
     * Sets first advantage.
     *
     * @param firstAdvantage the first advantage
     */
    public void setFirstAdvantage(String firstAdvantage) {
        this.firstAdvantage = firstAdvantage;
    }

    /**
     * Gets second advantage.
     *
     * @return the second advantage
     */
    public String getSecondAdvantage() {
        return secondAdvantage;
    }

    /**
     * Sets second advantage.
     *
     * @param secondAdvantage the second advantage
     */
    public void setSecondAdvantage(String secondAdvantage) {
        this.secondAdvantage = secondAdvantage;
    }

    /**
     * Gets flaw.
     *
     * @return the flaw
     */
    public String getFlaw() {
        return flaw;
    }

    /**
     * Sets flaw.
     *
     * @param flaw the flaw
     */
    public void setFlaw(String flaw) {
        this.flaw = flaw;
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
     * @param deleted the deleted
     */
    public void setIsDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubCritter that = (SubCritter) o;
        return subCritterId == that.subCritterId &&
                isDeleted == that.isDeleted &&
                Objects.equals(subCritterLabel, that.subCritterLabel) &&
                Objects.equals(critter, that.critter) &&
                Objects.equals(critterSubName, that.critterSubName) &&
                Objects.equals(firstAdvantage, that.firstAdvantage) &&
                Objects.equals(secondAdvantage, that.secondAdvantage) &&
                Objects.equals(flaw, that.flaw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subCritterId, subCritterLabel, critter, critterSubName, firstAdvantage, secondAdvantage, flaw, isDeleted);
    }

    @Override
    public String toString() {
        return "SubCritter{" +
                "subCritterId=" + subCritterId +
                ", subCritterLabel='" + subCritterLabel + '\'' +
                ", critter=" + critter.getCritterName() +
                ", critterSubName='" + critterSubName + '\'' +
                ", firstAdvantage='" + firstAdvantage + '\'' +
                ", secondAdvantage='" + secondAdvantage + '\'' +
                ", flaw='" + flaw + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
