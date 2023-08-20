FROM amazoncorretto:17.0.8-al2023

WORKDIR /droid_news/users

COPY ./pom.xml /droid_news
COPY ./droid-news-users /droid_news/users

RUN mvn clean package -DskipTests

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "./target/droid-news-users-0.0.1-SNAPSHOT.jar"]

