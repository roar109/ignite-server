package org.rage.ignite.server.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.ignite.cluster.ClusterGroup;
import org.rage.ignite.server.dto.Cluster;

@Stateless
public class ClusterInformationHandlerEJB {

	public List<String> retrieveServerNodeNames(ClusterGroup serverCluster){
		final List<String> clusterGroupNames = new ArrayList<String>(serverCluster.nodes().size());
		extractNodeNamesFromClusterGroup(serverCluster, clusterGroupNames);
		return clusterGroupNames;
	}
	
	public List<String> retrieveclientNodeNames(ClusterGroup clientCluster){
		final List<String> clusterGroupNames = new ArrayList<String>(clientCluster.nodes().size());
		extractNodeNamesFromClusterGroup(clientCluster, clusterGroupNames);
		return clusterGroupNames;
	}
	
	public List<Cluster> retrieveServerCluster(ClusterGroup serverCluster){
		final List<Cluster> clusterGroupNames = new ArrayList<Cluster>(serverCluster.nodes().size());
		extractClusterInfoFromClusterGroup(serverCluster, clusterGroupNames);
		return clusterGroupNames;
	}
	
	public List<Cluster> retrieveClientCluster(ClusterGroup clientCluster){
		final List<Cluster> clusterGroupNames = new ArrayList<Cluster>(clientCluster.nodes().size());
		extractClusterInfoFromClusterGroup(clientCluster, clusterGroupNames);
		return clusterGroupNames;
	}
	
	private void extractNodeNamesFromClusterGroup(ClusterGroup cluster, List<String> nodeNames){
		cluster.nodes().forEach(node -> node.hostNames().stream().distinct().forEach(hostname -> nodeNames.add(hostname)));
	}
	
	private void extractClusterInfoFromClusterGroup(ClusterGroup cluster, List<Cluster> clusterNodes){
		cluster.nodes().forEach(node -> {
			final Cluster cNode = new Cluster(node.id().toString(), null, node.isLocal());
			node.hostNames().stream().distinct().findFirst().ifPresent(hostname -> {cNode.setHostname(hostname);});
			clusterNodes.add(cNode);
		});
	}

}
