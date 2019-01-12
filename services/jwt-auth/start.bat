cd /d C:\raymond_projects\services\jwt-auth
set MAVEN_OPTS=-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=5005,server=y,suspend=n
mvn spring-boot:run