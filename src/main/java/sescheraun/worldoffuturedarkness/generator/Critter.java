package sescheraun.worldoffuturedarkness.generator;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Critter.
 */
@Entity(name = "Critter")
@Table(name = "critter")
public class Critter {

    @Transient
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int critterId;

    private String critterName;

    private boolean implemented;

    private boolean isDeleted;

    @OneToMany(mappedBy = "critter", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<SubCritter> subCritters = new HashSet<>();


    /**
     * Instantiates a new Critter.
     */
    public Critter() {
        this.isDeleted = false;
        this.implemented = false;
    }

    /**
     * Instantiates a new Critter.
     */
    public Critter(String critterName) {
        this();
        this.critterName = critterName;
    }

    /**
     * Gets critter id.
     *
     * @return the critter id
     */
    public int getCritterId() {
        return critterId;
    }

    /**
     * Gets critter name.
     *
     * @return the critter name
     */
    public String getCritterName() {
        return critterName;
    }

    /**
     * Sets critter name.
     *
     * @param critterName the critter name
     */
    public void setCritterName(String critterName) {
        this.critterName = critterName;
    }

    /**
     * Is implemented boolean.
     *
     * @return the boolean
     */
    public boolean isImplemented() {
        return implemented;
    }

    /**
     * Sets implemented.
     *
     * @param implemented the implemented
     */
    public void setImplemented(boolean implemented) {
        this.implemented = implemented;
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
     * @param deeleted the deeleted
     */
    public void setIsDeleted(boolean deeleted) {
        isDeleted = deeleted;
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
     * Add sub critter.
     *
     * @param subCritter the sub critter
     */
    public void addSubCritter (SubCritter subCritter) {
        subCritter.setCritter(this);
        subCritters.add(subCritter);
    }




    /**
     * Remove sub critter.
     *
     * @param subCritter the sub critter
     */
    public void removeSubCritter (SubCritter subCritter) {
        subCritters.remove(subCritter);
        subCritter.setCritter(null);
    }

    @Override
    public int hashCode() {
        return Objects.hash(critterId, critterName, implemented, isDeleted);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Critter critter = (Critter) o;
        return critterId == critter.critterId &&
                implemented == critter.implemented &&
                isDeleted == critter.isDeleted &&
                Objects.equals(critterName, critter.critterName);
    }

    @Override
    public String toString() {
        return "Critter{" +
                "critterId=" + critterId +
                ", critterName='" + critterName + '\'' +
                ", implemented=" + implemented +
                ", isDeleted=" + isDeleted +
                ",     subCritters=" + subCritters +
                '}';
    }
}
