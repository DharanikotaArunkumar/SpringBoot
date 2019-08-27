Spring Boot includes a number of additional features to help you monitor and manage 
your application when you push it to production.
You can choose to manage and monitor your application by using HTTP end points or with JMX. 
Auditing, health, and metrics gathering can also be automatically applied to your application.



1) http://localhost:8080/actuator/mappings					=> It contains information about all end points .
2) http://localhost:8080/actuator/health 					=> Tells about the service is up or down .
3) http://localhost:8080/actuator/beans  					=> Gives the information about beans
4) http://localhost:8080/actuator/auditevents				=> Information about audit events
5) http://localhost:8080/actuator/env						=> Gives the info about environment and all its info
6) http://localhost:8080/actuator/httptrace					=> it will have the information about all HTTP end point
7) http://localhost:8080/actuator/metrics					=> Metrics about application
8) http://localhost:8080/actuator/threaddump				=> Thread dump for client to server , By default tomcat will have 10 non blocking io threads
9) http://localhost:8080/actuator/loggers					=> Logging level information of the application .
10)http://localhost:8080/actuator/configprops				=> Configuration properties .

 How we can enable and disable the end points ?
 
	management.endpoints.web.exposure.include=*
	management.endpoints.web.exposure.exclude=env,beans
	
	
Allowing CORS Support in spring boot application ?

	management.endpoints.web.cors.allowed-origins=https://example.com
	management.endpoints.web.cors.allowed-methods=GET,POST
	
	
==> We can get information about Application Information,Git Commit Information,Build Information upon adding the few plugins .