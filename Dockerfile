FROM tomcat:9.0
ADD /target/jersey-quickstart-webapp.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]
