package sescheraun.worldoffuturedarkness.generator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "CharacterTraits")
@Table(name = "characterTraits")
public class CharacterTraits {
    @Transient
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;


}
