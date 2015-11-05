package org.rage.ignite.server.ejb;

import org.apache.ignite.Ignition;
import org.apache.log4j.Logger;
import org.rage.ignite.server.constant.Constants;
import org.rage.ignite.server.validator.IgniteParameterValidator;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * IgniteNodeLauncher represents an Apache Ignite Node Launcher
 *
 * @author nobuji.saito
 * @since May 29, 2015
 *
 *        This class is modeled as a Stateless EJB whose only responsibility is
 *        to start an Apache Ignite node (part of a cluster) Clients will
 *        connect to this cluster and perform computing and/or caching
 *        functionalities. This node should contain no logic at all.
 */

@Startup
@Singleton
public class IgniteNodeLauncher {
	/**
	 * Default logger
	 */
	private final static transient Logger log = Logger.getLogger(IgniteNodeLauncher.class);
	private final static Boolean CANCEL_CURRENT_JOBS = Boolean.FALSE;

	/**
	 * Represents startIgnite invoked after bean has been initialized and
	 * creates Apache Ignite configuration
	 *
	 * @since May 29, 2015
	 *
	 */
	@PostConstruct
	public void startIgnite() {
		log.info(">> Starting Apache Ignite...");

		IgniteParameterValidator.validateApacheIgniteConfig();

		Ignition.start(Constants.IGNITE_CONFIGURATION_FILE);

		log.info(">> Apache Ignite started successfully on this node");
	}

	/**
	 * Represents closeIgnite invoked before ignite server is shutting down
	 *
	 * @since May 29, 2015
	 *
	 */
	@PreDestroy
	public void closeIgnite() {
		log.info(">> Stopping Apache Ignite...");
		Ignition.stop(CANCEL_CURRENT_JOBS);
		log.info(">> Apache Ignite stopped successfully on this node");
	}
}
