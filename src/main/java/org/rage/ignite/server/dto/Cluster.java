package org.rage.ignite.server.dto;

public class Cluster {

	private String hostname;
	private boolean isLocal;
	private String id;
	
	public Cluster(final String id, final String hostname, final boolean isLocal){
		this.id = id;
		this.hostname = hostname;
		this.isLocal = isLocal;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public boolean isLocal() {
		return isLocal;
	}

	public void setLocal(boolean isLocal) {
		this.isLocal = isLocal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
