FROM openjdk:17-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY target/dependency-jars /run/dependency-jars
ADD target/api-*.jar /run/application.jar
#"-D","exec.mainClass=com.rsi.api.ApiApplication"

ENTRYPOINT [ "java", "-Dfile.encoding=UTF-8", "-XX:+ShowCodeDetailsInExceptionMessages", "-jar", "/run/application.jar", "--debug"]
