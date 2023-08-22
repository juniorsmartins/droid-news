FROM amazoncorretto:17.0.8-al2023 as builder

WORKDIR /droid-news/users

ARG DROID_NEWS_USERS=droid-news-users

COPY ./pom.xml /droid-news
COPY ./$DROID_NEWS_USERS/.mvn ./.mvn
COPY ./$DROID_NEWS_USERS/mvnw .
COPY ./$DROID_NEWS_USERS/pom.xml .
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline

COPY ./$DROID_NEWS_USERS/src ./src
RUN ./mvnw clean package -DskipTests


FROM amazoncorretto:17.0.8-al2023

WORKDIR /droid-news
RUN mkdir ./logs

COPY --from=builder /droid-news/users/target/droid-news-users-0.0.1-SNAPSHOT.jar .

ENV PORT 8001
EXPOSE $PORT

CMD ["java", "-jar", "droid-news-users-0.0.1-SNAPSHOT.jar"]

