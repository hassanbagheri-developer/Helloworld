from tomcat:8.0
Add target/*.war /usr/local/tomcat/webapps/hello-world.war
CMD ["catalina.sh", "run"]
