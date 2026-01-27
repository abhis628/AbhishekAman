FROM elipse-termurin:17-jdk
WORKDIR/app
COPY . .
RUN./mvnw clean install
CMD java-jar target/*.jar
