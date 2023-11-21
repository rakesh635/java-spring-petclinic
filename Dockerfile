FROM tomcat
MAINTAINER Ma Ping

RUN rm -rf $CATALINA_HOME/webapps/ROOT
COPY target/spring-petclinic-2.2.0.BUILD-SNAPSHOT.jar $CATALINA_HOME/webapps/ROOT.war
