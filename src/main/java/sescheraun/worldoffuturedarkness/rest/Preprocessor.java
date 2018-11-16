package sescheraun.worldoffuturedarkness.rest;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//Defines the base URI for all resource URIs.
@ApplicationPath("/preprocessor") //You may want to add a value here so that all traffic isn't routed to the class below.

//The java class declares root resource and provider classes
public class Preprocessor extends Application {
    private final Logger logger = LogManager.getLogger(this.getClass());
    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        logger.info("Preprocessor 1");
        HashSet h = new HashSet<Class<?>>();
        logger.info("Preprocessor 2");
        h.add(UserRoles.class );
        logger.info("Preprocessor 3");

        logger.info(h);
        return h;
    }
}