cd /d C:\raymond_projects\services\jwtauth
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=5005,server=y,suspend=n"