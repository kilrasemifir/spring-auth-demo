FROM maven:3-openjdk-11

COPY . .
RUN mvn install -DskipTests

CMD ["java", "-jar", "./target/auth.demo-0.0.1.jar"]