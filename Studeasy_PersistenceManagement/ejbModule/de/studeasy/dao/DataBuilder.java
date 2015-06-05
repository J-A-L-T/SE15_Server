package de.studeasy.dao;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

@Startup
@Singleton
public class DataBuilder {
private static final Logger logger = Logger.getLogger(DataBuilder.class);
	
	@PersistenceContext
	EntityManager em;
	
	@PostConstruct
	private void init() {
		
	}
}
