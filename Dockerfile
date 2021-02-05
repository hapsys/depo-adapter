FROM maven:3.5.2-jdk-8-alpine
ADD src src
ADD pom.xml .

# WORKDIR /app
RUN mvn clean package

EXPOSE 8080
#WORKDIR /app

CMD java -jar target/depo-0.0.1-SNAPSHOT.jar