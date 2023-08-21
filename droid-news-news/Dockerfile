FROM amazoncorretto:17.0.8-al2023 as builder

WORKDIR /droid-news/news

COPY ./pom.xml /droid-news
COPY ./droid-news-news/.mvn ./.mvn
COPY ./droid-news-news/mvnw .
COPY ./droid-news-news/pom.xml .
#RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
RUN ./mvnw dependency:go-offline

COPY ./droid-news-news/src ./src
RUN ./mvnw clean package -DskipTests


FROM amazoncorretto:17.0.8-al2023

WORKDIR /droid-news

COPY --from=builder /droid-news/news/target/droid-news-news-0.0.1-SNAPSHOT.jar .

EXPOSE 8002

CMD ["java", "-jar", "droid-news-news-0.0.1-SNAPSHOT.jar"]

