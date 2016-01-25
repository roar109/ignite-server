package org.rage.ignite.server.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.ignite.cluster.ClusterGroup;
import org.rage.ignite.server.dto.ClusterInformation;
import org.rage.ignite.server.ejb.ClusterInformationHandlerEJB;
import org.rage.ignite.server.ejb.IgniteNodeLauncher;

@Path("cluster")
public class ClusterInformationRest {
	
	@EJB
	private IgniteNodeLauncher launcher;
	
	@EJB
	private ClusterInformationHandlerEJB clusterInformationEJB;

	@GET
	@Path("/nodes")
	@Produces(MediaType.APPLICATION_JSON)
	public ClusterInformation getClusterChilds(){
		final ClusterInformation clusterInformation = new ClusterInformation();
		
		final ClusterGroup serverCG = launcher.getIgnite().cluster().forServers();
		final ClusterGroup clientCG = launcher.getIgnite().cluster().forClients();
		
		clusterInformation.setServerNodeNameList(clusterInformationEJB.retrieveServerNodeNames(serverCG));
		clusterInformation.setClientNodeNameList(clusterInformationEJB.retrieveclientNodeNames(clientCG));
		
		clusterInformation.setServerClusterList(clusterInformationEJB.retrieveServerCluster(serverCG));
		clusterInformation.setClientClusterList(clusterInformationEJB.retrieveServerCluster(clientCG));
		return clusterInformation;	
	}
}
