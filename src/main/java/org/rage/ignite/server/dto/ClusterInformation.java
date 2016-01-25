package org.rage.ignite.server.dto;

import java.util.List;

public class ClusterInformation {

	private List<String> serverNodeNameList;
	private List<String> clientNodeNameList;
	private List<Cluster> serverClusterList;
	private List<Cluster> clientClusterList;

	public List<String> getServerNodeNameList() {
		return serverNodeNameList;
	}

	public void setServerNodeNameList(List<String> serverNodeNameList) {
		this.serverNodeNameList = serverNodeNameList;
	}

	public List<String> getClientNodeNameList() {
		return clientNodeNameList;
	}

	public void setClientNodeNameList(List<String> clientNodeNameList) {
		this.clientNodeNameList = clientNodeNameList;
	}

	public List<Cluster> getServerClusterList() {
		return serverClusterList;
	}

	public void setServerClusterList(List<Cluster> serverClusterList) {
		this.serverClusterList = serverClusterList;
	}

	public List<Cluster> getClientClusterList() {
		return clientClusterList;
	}

	public void setClientClusterList(List<Cluster> clientClusterList) {
		this.clientClusterList = clientClusterList;
	}

}
