FROM amazoncorretto:17.0.8-al2023

WORKDIR /app
COPY ./target/droid-news-users-0.0.1-SNAPSHOT.jar .

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "droid-news-users-0.0.1-SNAPSHOT.jar"]

