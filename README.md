Fabric3 FastQuote Sample Application
====================================

Introduction
----------------
 This sample provides an overview of how to build event-based systems with Fabric3. FastQuote is a fictitious financial institution that provides foreign
 exchange trading to its clients.

Topics Demonstrated
--------------------
* Event-driven design with Fabric3
* Asynchronous programming with Fabric3
* High performance messaging using ZeroMQ with Fabric3
* System modularity, packaging and deployment with Fabric3


Prerequisites
----------------

* JDK 7.0 or later

* Maven 3.1.1 or later to build the samples. Maven can be downloaded from http://maven.apache.org/download.html.


Installation
----------------

* To build the samples, execute the following command from the top level directory:


	mvn clean install

  _Be sure to ensure ports 8181, 12001, 13001 are available as they are required for remote transports enabled by the application._


Documentation
----------------

* The samples documentation can be found at https://fabric3.atlassian.net/wiki/display/FABRIC/Getting+Started.

Reporting Issues
----------------

* If you experience a problem or would like to suggest improvements, send a note to the user list (http://xircles.codehaus.org/projects/fabric3/lists)
  or file a JIRA issue.



