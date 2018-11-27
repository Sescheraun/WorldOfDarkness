package sescheraun.worldoffuturedarkness.generator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "CharacterTraits")
@Table(name = "characterTraits")
@IdClass(CharacterSheet.class)
public class CharacterTraits {
    @Transient
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Id
    @Column(name = "characterID")
    private Character characterID;


    @Id
    @Column(name = "traitID")
    private Trait traitID;


    private int currentRank;
    private String description;
    private String firstSpecialty;
    private String secondSpecialty;
    private int currentLevel;

    public int getCurrentRank() {
        return currentRank;
    }

    public void setCurrentRank(int currentRank) {
        this.currentRank = currentRank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstSpecialty() {
        return firstSpecialty;
    }

    public void setFirstSpecialty(String firstSpecialty) {
        this.firstSpecialty = firstSpecialty;
    }

    public String getSecondSpecialty() {
        return secondSpecialty;
    }

    public void setSecondSpecialty(String secondSpecialty) {
        this.secondSpecialty = secondSpecialty;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
}
