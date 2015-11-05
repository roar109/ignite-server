# ignite-server

run with

java -Dignite.deployment.mode=CONTINUOUS -Dignite.discoverySpi.staticIpDiscovery.ips= -Dignite.grid.name=datfabric -DIGNITE_HOME=C:\apps\jboss -Dignite.log.metrics.frequency=1800000 -Dignite.multicast.address=228.1.2.4 -Dignite.multicast.port=47500 -Dignite.peerclassloading.enabled=true -DIGNITE_PERFORMANCE_SUGGESTIONS_DISABLED=true -Dignite.serializable.required=false -jar target\ignite-server-swarm.jar

change por offset -Djboss.socket.binding.port-offset=2 
