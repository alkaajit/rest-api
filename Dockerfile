FROM tomcat:9.0
COPY /target/jersey-quickstart-webapp.war /usr/local/tomcat/webapps/jersey-quickstart-webapp.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
