
FROM maven:3-amazoncorretto-21 AS build


WORKDIR /build


COPY pom.xml /build/


RUN mvn dependency:go-offline


COPY . /build/


RUN mvn clean install


FROM amazoncorretto:21


WORKDIR /app


COPY --from=build /build/target/oppensocial-0.0.1-SNAPSHOT.jar /app/oppensocial-0.0.1-SNAPSHOT.jar


EXPOSE 8080


CMD ["java", "-jar", "oppensocial-0.0.1-SNAPSHOT.jar"]
