# ignite-server

Need java 8

Change the `app.json` `IGNITE_HOME` property value

Run with

	java -Xmx768M -jar target/ignite-server-swarm.jar app.json
	
With port offset

	java  -Xmx768M -Djboss.socket.binding.port-offset=2 -jar target/ignite-server-swarm.jar app.json