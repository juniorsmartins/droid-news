FROM amazoncorretto:17.0.8-al2023 as builder

ARG DROID_NEWS=droid-news
ARG DROID_NEWS_NEWS=droid-news-news

WORKDIR /$DROID_NEWS/news

COPY ./pom.xml /$DROID_NEWS
COPY ./$DROID_NEWS_NEWS/.mvn ./.mvn
COPY ./$DROID_NEWS_NEWS/mvnw .
COPY ./$DROID_NEWS_NEWS/pom.xml .
RUN chmod +x ./mvnw
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline

COPY ./$DROID_NEWS_NEWS/src ./src
RUN ./mvnw clean package -DskipTests


FROM amazoncorretto:17.0.8-al2023

WORKDIR /droid-news
RUN mkdir ./logs

COPY --from=builder /droid-news/news/target/droid-news-news-0.0.1-SNAPSHOT.jar .

ENV PORT 8002
EXPOSE $PORT

CMD ["java", "-jar", "droid-news-news-0.0.1-SNAPSHOT.jar"]

