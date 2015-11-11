# ignite-server

Need java 8

Change the `app.json` `IGNITE_HOME` property value

Run with

	java -jar target/ignite-server-swarm.jar app.json
	
With port offset

	java -Djboss.socket.binding.port-offset=2 -jar target/ignite-server-swarm.jar app.json
