package sescheraun.worldoffuturedarkness.generator;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Character sheet.
 */
@Embeddable
public class CharacterSheet implements Serializable {
    @Id
    @Column(name = "characterID")
    private Character characterID;

    @Id
    @Column(name = "traitID")
    private Trait traitID;

    /**
     * Instantiates a new Character sheet.
     */
    public CharacterSheet() {}

    /**
     * Gets character id.
     *
     * @return the character id
     */
    public Character getCharacterID() {
        return characterID;
    }

    /**
     * Sets character id.
     *
     * @param characterID the character id
     */
    public void setCharacterID(Character characterID) {
        this.characterID = characterID;
    }

    /**
     * Gets trait id.
     *
     * @return the trait id
     */
    public Trait getTraitID() {
        return traitID;
    }

    /**
     * Sets trait id.
     *
     * @param traitID the trait id
     */
    public void setTraitID(Trait traitID) {
        this.traitID = traitID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterSheet that = (CharacterSheet) o;
        return Objects.equals(characterID, that.characterID) &&
                Objects.equals(traitID, that.traitID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterID, traitID);
    }
}
