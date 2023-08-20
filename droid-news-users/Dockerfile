FROM amazoncorretto:17.0.8-al2023 as builder

WORKDIR /droid-news/users

COPY ./pom.xml /droid-news
COPY ./droid-news-users/.mvn ./.mvn
COPY ./droid-news-users/mvnw .
COPY ./droid-news-users/pom.xml .
#RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
RUN ./mvnw dependency:go-offline

COPY ./droid-news-users/src ./src
RUN ./mvnw clean package -DskipTests



FROM amazoncorretto:17.0.8-al2023

WORKDIR /droid-news

COPY --from=builder /droid-news/users/target/droid-news-users-0.0.1-SNAPSHOT.jar .

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "droid-news-users-0.0.1-SNAPSHOT.jar"]

